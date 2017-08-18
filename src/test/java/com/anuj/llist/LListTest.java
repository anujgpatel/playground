/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuj.llist;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nishapatel
 */
public class LListTest {
    
    public LListTest() {
    }

    /**
     * Test of add method, of class LList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int val = 0;
        LList instance = new LList();
        instance.add(val);
        assertTrue(instance.toString().equals("0"));
        
    }

    /**
     * Test of hasPartners method, of class LList.
     */
    @Test
    public void testHasPartners() {
        System.out.println("hasPartners");
        int val = 33;
        LList instance = new LList();
        instance.add(1);
        instance.add(2);
        instance.add(31);
        boolean expResult = true;
        boolean result = instance.hasPartners(val);
        assertEquals(expResult, result);      
        
        expResult = false;
        result = instance.hasPartners(40);
        assertEquals(expResult,result);
    }

    /**
     * Test of toString method, of class LList.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LList instance = new LList();
        instance.add(1);
        instance.add(2);
        instance.add(3);
        
        String expResult = "1->2->3";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

   
}
