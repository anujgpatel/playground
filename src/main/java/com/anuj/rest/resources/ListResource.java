/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuj.rest.resources;

import com.anuj.llist.LList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.json.JSONException;

/**
 *
 * @author anujpatel
 */
@Path("/list")
public class ListResource {
    
    @GET
    @Produces("application/xml")
    public Response ping() throws JSONException{
        String result = "<healthy>\n"+Boolean.TRUE+"\n</healthy>";
        return Response.status(Response.Status.OK).entity(result).build();                
    }
    
    @POST
    @Consumes("text/plain")
    @Produces("application/xml")
    public Response addListCheckPartner(@QueryParam("checkPartner")String strCheckPartner, String csvList) throws JSONException{
        if(strCheckPartner==null || strCheckPartner.isEmpty())
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        
        String[] strNums = csvList.split(",");
        LList list = new LList();
        
        for(String strNum:strNums){
            try {
                Integer num = Integer.valueOf(strNum);
                list.add(num);
            }catch(Exception ex){
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }
        
        Integer checkPartner = Integer.valueOf(strCheckPartner);
        String result = "<result>\n"+list.hasPartners(checkPartner)+"\n</result>";        
        return Response.status(Response.Status.OK).entity(result).build();
    }
    
   
}
