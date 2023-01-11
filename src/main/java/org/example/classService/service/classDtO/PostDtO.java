package org.example.classService.service.classDtO;

import org.example.objectClassAndRepository.model.Like;
import org.example.objectClassAndRepository.model.Reply;

import java.sql.Timestamp;
import java.util.List;

public class PostDtO {

    String message;
    Timestamp timestamp;
    boolean onlyMe;
    List<Reply> replies;
    List<Like> likes;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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
                ", timestamp=" + timestamp +
                ", onlyMe=" + onlyMe +
                ", replies=" + replies +
                ", likes=" + likes +
                '}';
    }
}
