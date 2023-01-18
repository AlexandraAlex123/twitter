package org.example.twitterApp.objectClassAndRepository.modelDTO;

import java.util.Set;

public class ReplyDtO implements Comparable<ReplyDtO> {

    String postBy;
    String message;
    String createDate;
    boolean onlyMe;
    Set<ReplyDtO> replyReplies;
    Set<LikeDtO> replyLikes;

    Set<MentionDtO> mentionReply;


    public ReplyDtO() {
    }

    public String getPostBy() {
        return postBy;
    }

    public void setPostBy(String postBy) {
        this.postBy = postBy;
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

    public void setReplyReplies(Set<ReplyDtO> replyReplies) {
        this.replyReplies = replyReplies;
    }

    public Set<LikeDtO> getReplyLikes() {
        return replyLikes;
    }

    public void setReplyLikes(Set<LikeDtO> replyLikes) {
        this.replyLikes = replyLikes;
    }

    public Set<MentionDtO> getMentionReply() {
        return mentionReply;
    }

    public void setMentionReply(Set<MentionDtO> mentionReply) {
        this.mentionReply = mentionReply;
    }

    @Override
    public int compareTo(ReplyDtO o) {
        int i = this.createDate.compareTo(o.getCreateDate());
        return Integer.compare(0, i);
    }

    @Override
    public String toString() {
        return "ReplyDtO{" +
                "postBy='" + postBy + '\'' +
                ", message='" + message + '\'' +
                ", createDate='" + createDate + '\'' +
                ", onlyMe=" + onlyMe +
                ", replyReplies=" + replyReplies +
                ", replyLikes=" + replyLikes +
                ", mentionReply=" + mentionReply +
                '}';
    }

}
