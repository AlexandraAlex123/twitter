package org.example.classService.service.classDtO;

import org.example.objectClassAndRepository.model.Like;
import org.example.objectClassAndRepository.model.posts.Reply;

import java.util.List;
import java.util.Set;

public class ReplyDtO {

    String message;
    String createDate;
    boolean onlyMe;
    Set<Reply> replyReplies;
    Set<Like> replyLikes;

    public ReplyDtO(String message, String createDate, boolean onlyMe, Set<Reply> replyReplies, Set<Like> replyLikes) {
        this.message = message;
        this.createDate = createDate;
        this.onlyMe = onlyMe;
        this.replyReplies = replyReplies;
        this.replyLikes = replyLikes;
    }

    public ReplyDtO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public boolean isOnlyMe() {
        return onlyMe;
    }

    public void setOnlyMe(boolean onlyMe) {
        this.onlyMe = onlyMe;
    }

    public Set<Reply> getReplyReplies() {
        return replyReplies;
    }

    public void setReplyReplies(Set<Reply> replyReplies) {
        this.replyReplies = replyReplies;
    }

    public Set<Like> getReplyLikes() {
        return replyLikes;
    }

    public void setReplyLikes(Set<Like> replyLikes) {
        this.replyLikes = replyLikes;
    }

    @Override
    public String toString() {
        return "ReplyDtO{" +
                "message='" + message + '\'' +
                ", createDate='" + createDate + '\'' +
                ", onlyMe=" + onlyMe +
                ", replyReplies=" + replyReplies +
                ", replyLikes=" + replyLikes +
                '}';
    }
}
