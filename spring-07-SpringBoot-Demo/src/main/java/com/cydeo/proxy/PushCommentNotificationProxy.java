package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("push")
public class PushCommentNotificationProxy implements  CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending Push Notification For Comment: " + comment.getText());
    }
}
