package org.example.twitterApp.objectClassAndRepository.modelDTO;

import java.util.Set;

public class ReplyDtO implements Comparable<ReplyDtO> {

    String message;
    String createDate;
    boolean onlyMe;
    Set<ReplyDtO> replyReplies;
    Set<LikeDtO> replyLikes;

    public ReplyDtO(String message, String createDate, boolean onlyMe, Set<ReplyDtO> replyReplies, Set<LikeDtO> replyLikes) {
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

    public Set<ReplyDtO> getReplyReplies() {
        return replyReplies;
    }

    public void setReplyReplies(Set<ReplyDtO> replyReplies) {
        this.replyReplies = replyReplies;
    }

    public Set<LikeDtO> getReplyLikes() {
        return replyLikes;
    }

    public void setReplyLikes(Set<LikeDtO> replyLikes) {
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

    @Override
    public int compareTo(ReplyDtO o) {
        int i = this.createDate.compareTo(o.getCreateDate());
        return Integer.compare(0, i);
    }
}
