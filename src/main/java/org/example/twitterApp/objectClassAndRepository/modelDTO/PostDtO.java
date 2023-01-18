package org.example.twitterApp.objectClassAndRepository.modelDTO;

import org.example.twitterApp.objectClassAndRepository.model.mention.MentionPost;

import java.util.Set;

public class PostDtO implements Comparable<PostDtO> {

    String message;
    String createDate;
    boolean onlyMe;
    Set<ReplyDtO> postReplies;
    Set<LikeDtO> postLikes;

    Set<MentionDtO> mentionPost;


    public PostDtO() {
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

    public Set<ReplyDtO> getPostReplies() {
        return postReplies;
    }

    public void setPostReplies(Set<ReplyDtO> postReplies) {
        this.postReplies = postReplies;
    }

    public Set<LikeDtO> getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(Set<LikeDtO> postLikes) {
        this.postLikes = postLikes;
    }

    public Set<MentionDtO> getMentionPost() {
        return mentionPost;
    }

    public void setMentionPost(Set<MentionDtO> mentionPost) {
        this.mentionPost = mentionPost;
    }

    @Override
    public int compareTo(PostDtO o) {
        int i = this.createDate.compareTo(o.getCreateDate());
        return Integer.compare(0, i);
    }

    @Override
    public String toString() {
        return "PostDtO{" +
                "message='" + message + '\'' +
                ", createDate='" + createDate + '\'' +
                ", onlyMe=" + onlyMe +
                ", postReplies=" + postReplies +
                ", postLikes=" + postLikes +
                ", mentionPost=" + mentionPost +
                '}';
    }
}
