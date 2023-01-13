package org.example.twitterApp.objectClassAndRepository.classDtO;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

public class MentionDtO {

    String userHwoMention;
    String message;
    String date;
    Post post;
    Reply reply;

    public MentionDtO(String userHwoMention, String message, String date, Post post, Reply reply) {
        this.userHwoMention = userHwoMention;
        this.message = message;
        this.date = date;
        this.post = post;
        this.reply = reply;
    }

    public MentionDtO() {
    }

    public String getUserHwoMention() {
        return userHwoMention;
    }

    public void setUserHwoMention(String userHwoMention) {
        this.userHwoMention = userHwoMention;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
}
