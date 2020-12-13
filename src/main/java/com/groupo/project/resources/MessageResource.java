/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupo.project.resources;

import com.groupo.project.models.Account;
import com.groupo.project.services.MessageService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;




@Path("/messages")

public class MessageResource {
    
    MessageService messageService = new MessageService();
    /*
    If using POSTMAN as client, remember setting a Header 
    "Accept:application/json" for retrieving JSON format
    "Accept:application/xml" for retrieving XML format
    */    
   /*
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessagesXML() {
        return messageService.getAllMessages();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessagesJSON() {
        return messageService.getAllMessages();
    }
*/
          
 /* Search for a Message  
   GET http://localhost:49000/api/messages?author=Emer&message=this+is+a+test+message      by @QueryParam message content and by @QueryParam author     
   GET http://localhost:49000/api/messages?author=Emer      by @QueryParam author only
    */  
 
@GET 
@Produces(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_XML)
 public List<Account> getFilteredMessages(@QueryParam("message") String message, @QueryParam("author") String author) 
 { 
   if ((message != null) || (author != null)) 
      {        
          return messageService.getSearchMessages(message, author); 
      } 
    return messageService.getAllMessages();    
 }  
    
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_XML)
    public Account getMessageXML(@PathParam("messageId") int id) {
        return messageService.getMessage(id);
    }
    
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getMessageJSON(@PathParam("messageId") int id) {
        return messageService.getMessage(id);
    }
/*
    * When using POSTMAN remember to include in Headers: Content-type : application/json
    * and include in the body of the request in RAW format the object in JSON notation
    e.g. 
    {  "author": "Emer", 
    "created": "2018-10-27T00:39:57.726", 
    "message": "This is a test message" 
    } 

    */
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account postMessage(Account m) {
	return messageService.createMessage(m);
    }
    
    @Path("/{messageID}/comments")
    public CommentResource getCommentsResource() {
	System.out.println("Getting comments subresoruces...");
	return new CommentResource();
    }

    
} 
    
    