/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupo.project.resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import com.groupo.project.services.CommentService;
import com.groupo.project.models.Customer;
import com.groupo.project.models.Account;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

@Path("/comments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

//@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})

public class CommentResource {

    private CommentService CommentService = new CommentService();
	
    @GET
    public List<Customer> getComments(@PathParam("messageID") int m_id) {
        System.out.println("getAllCommentsForMessage..."+m_id);
	return CommentService.getAllCommentsByMessage(m_id);
    }
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer postComment(@PathParam("messageID") int m_id, Customer c) {
	return CommentService.createComment(c, m_id);
    }
    @GET
    @Path("/{commentID}")
    public Customer getComment(@PathParam("commentID") int c_id,@PathParam("messageID") int m_id ) {
    	System.out.println("getCommentByID..."+c_id +" for MEssageID "+m_id);
	return CommentService.getCommentByID(m_id,c_id);
    }
    
}
