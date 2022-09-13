package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    //private DBCommentRepository dbCommentRepository; --> it's tightly coupled
    private CommentRepository commentRepository; //always put here interface, because implementation can change
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment){ //it is business logic
        //save in the DB
        commentRepository.storeComment(comment);
        //send email
        commentNotificationProxy.sendComment(comment);




    }
}
