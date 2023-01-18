package org.example.twitterApp.objectClassAndRepository.modelDTO;

import org.example.twitterApp.objectClassAndRepository.model.mention.MentionReply;

import java.util.Set;

public class ReplyDtO implements Comparable<ReplyDtO> {

    String message;
    String createDate;
    boolean onlyMe;
    Set<PostDTOFeed> replyReplies;
    Set<LikeDtO> replyLikes;

    Set<MentionDtO> mentionReply;


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

    public Set<PostDTOFeed> getReplyReplies() {
        return replyReplies;
    }

    public void setReplyReplies(Set<PostDTOFeed> replyReplies) {
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
    public String toString() {
        return "ReplyDtO{" +
                "message='" + message + '\'' +
                ", createDate='" + createDate + '\'' +
                ", onlyMe=" + onlyMe +
                ", replyReplies=" + replyReplies +
                ", replyLikes=" + replyLikes +
                ", mentionReply=" + mentionReply +
                '}';
    }

    @Override
    public int compareTo(ReplyDtO o) {
        int i = this.createDate.compareTo(o.getCreateDate());
        return Integer.compare(0, i);
    }
}
