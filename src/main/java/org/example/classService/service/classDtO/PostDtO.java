package org.example.classService.service.classDtO;

import org.example.objectClassAndRepository.model.Like;
import org.example.objectClassAndRepository.model.posts.Reply;

import java.util.List;

public class PostDtO {

    String message;
    String date;
    boolean onlyMe;
    List<Reply> replies;
    List<Like> likes;

    public PostDtO(String message, String date, boolean onlyMe, List<Reply> replies, List<Like> likes) {
        this.message = message;
        this.date = date;
        this.onlyMe = onlyMe;
        this.replies = replies;
        this.likes = likes;
    }

    public PostDtO() {
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

    public boolean isOnlyMe() {
        return onlyMe;
    }

    public void setOnlyMe(boolean onlyMe) {
        this.onlyMe = onlyMe;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "PostDtO{" +
                "message='" + message + '\'' +
                ", date='" + date + '\'' +
                ", onlyMe=" + onlyMe +
                ", replies=" + replies +
                ", likes=" + likes +
                '}';
    }
}
