package org.example.twitterApp.objectClassAndRepository.modelDTO;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;

import java.util.Set;

public class PostDTOFeed implements Comparable<PostDTOFeed> {

    String postBy;
    String message;
    String createDate;
    boolean onlyMe;
    Set<PostDTOFeed> postReplies;
    Set<LikeDtO> postLikes;

    public PostDTOFeed(String postBy, String message, String createDate, boolean onlyMe, Set<PostDTOFeed> postReplies, Set<LikeDtO> postLikes) {
        this.postBy = postBy;
        this.message = message;
        this.createDate = createDate;
        this.onlyMe = onlyMe;
        this.postReplies = postReplies;
        this.postLikes = postLikes;
    }

    public PostDTOFeed() {
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

    public Set<PostDTOFeed> getPostReplies() {
        return postReplies;
    }

    public void setPostReplies(Set<PostDTOFeed> postReplies) {
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
                "postBy='" + postBy + '\'' +
                ", message='" + message + '\'' +
                ", createDate='" + createDate + '\'' +
                ", onlyMe=" + onlyMe +
                ", postReplies=" + postReplies +
                ", postLikes=" + postLikes +
                '}';
    }
}
