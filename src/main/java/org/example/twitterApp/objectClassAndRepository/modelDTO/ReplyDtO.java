package org.example.twitterApp.objectClassAndRepository.modelDTO;

import java.util.Set;

public class ReplyDtO implements Comparable<ReplyDtO> {

    String postBy;
    String message;
    String createDate;
    boolean onlyMe;
    Set<LikeDtO> replyLikes;
    Set<MentionForPostDTO> mentionReply;
    Set<ReplyDtO> replyReplies;

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

    public Set<MentionForPostDTO> getMentionReply() {
        return mentionReply;
    }

    public void setMentionReply(Set<MentionForPostDTO> mentionReply) {
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
                ", replyLikes=" + replyLikes +
                ", mentionReply=" + mentionReply +
                ", replyReplies=" + replyReplies +
                '}';
    }

}
