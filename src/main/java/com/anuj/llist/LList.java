/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuj.llist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anujpatel
 * Custom Linked List implementation which simply adds, prints and checks if the list contains partner numbers
 */
public class LList {
    Node head;
    
    public LList(){}
    
    public void add(int val){ 
        if(head==null)
            head = new Node(val);
        else {
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new Node(val);        
        }
    }
    
    public boolean hasPartners(int val){
        //Map map = new HashMap<Integer, Integer>();
        List list = new ArrayList<Integer>();
        Node temp = head;
        while(temp.next!=null){//0,1,2,3,4,5
            int p2 = val - temp.val;//5,4,3,2,1,0
            list.add(p2);
            
            if(list.contains(temp.val)){
                return true;
            }
            temp = temp.next;
            if(temp.next==null){
                if(list.contains(temp.val))
                    return true;
            }
        }
        
        return false;
    }
    
    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder("");
        if(head!=null){
            Node temp = head;
            while(temp.next!=null){
                strBuilder.append(temp.val + "->");
                temp = temp.next;
            }
            strBuilder.append(temp.val);
        }
        return strBuilder.toString();
    }
    private class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }        
    }
    
    public static void main(String[] args){
        LList list = new LList();
        list.add(0);
        list.add(-11);
        list.add(20);
        list.add(31);
        list.add(9);
        list.add(5);
        System.out.println("Partners for 5 = "+list.hasPartners(5));
        System.out.println("Partners for 99 = "+list.hasPartners(99));     
        System.out.println("Partners for 9 = "+list.hasPartners(9));
        System.out.println("Partners for 5 = "+list.hasPartners(90));
        
        System.out.println(list);

    }
}