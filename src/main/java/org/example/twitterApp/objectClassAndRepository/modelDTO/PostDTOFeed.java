package org.example.twitterApp.objectClassAndRepository.modelDTO;

import java.util.Set;

public class PostDTOFeed implements Comparable<PostDTOFeed> {

    String userWhoPost;
    String message;
    String createDate;
    boolean onlyMe;
    Set<ReplyDtO> postReplies;
    Set<LikeDtO> postLikes;

    public PostDTOFeed(String userWhoPost, String message, String createDate, boolean onlyMe, Set<ReplyDtO> postReplies, Set<LikeDtO> postLikes) {
        this.userWhoPost = userWhoPost;
        this.message = message;
        this.createDate = createDate;
        this.onlyMe = onlyMe;
        this.postReplies = postReplies;
        this.postLikes = postLikes;
    }

    public PostDTOFeed() {
    }

    public String getUserWhoPost() {
        return userWhoPost;
    }

    public void setUserWhoPost(String userWhoPost) {
        this.userWhoPost = userWhoPost;
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

    @Override
    public int compareTo(PostDTOFeed o) {
        int i = this.createDate.compareTo(o.getCreateDate());
        return Integer.compare(0, i);
    }

    @Override
    public String toString() {
        return "PostDTOFeed{" +
                "userWhoPost='" + userWhoPost + '\'' +
                ", message='" + message + '\'' +
                ", createDate='" + createDate + '\'' +
                ", onlyMe=" + onlyMe +
                ", postReplies=" + postReplies +
                ", postLikes=" + postLikes +
                '}';
    }
}
