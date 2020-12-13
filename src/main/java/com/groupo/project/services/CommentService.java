/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupo.project.services;
import com.groupo.project.models.Account;
import com.groupo.project.models.Customer;
import com.mycompany.myblog.databases.Database;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cmuntean
 */
public class CommentService {
    
    private List<Account> list = new Database().getMessagesDB();
    private List<Customer> commentslist = new Database().getCommentsDB(); 
    
    public List<Customer> getAllCommentsByMessage(int MessageID) {
        return list.get(MessageID-1).getComments();
    }
    
    public Customer getCommentByID(int MessageID, int CommentID) {
        return list.get(MessageID-1).getComments().get(CommentID-1);
    }

    public List<Customer> getAllComments() {
        return commentslist;
    }
    
    public Customer createComment(Customer c, int m_id){
        Account msg = list.get(m_id-1);
        c.setId(msg.getComments().size() + 1);
	msg.addCommentToMsg(c);
        
        
	System.out.println("201 - resource created with path: /messages/" + String.valueOf(msg.getId())+"/comments/"+String.valueOf(c.getId()));
        System.out.println("Updated Message:"+c.printComment());
	return c;
    }
}
