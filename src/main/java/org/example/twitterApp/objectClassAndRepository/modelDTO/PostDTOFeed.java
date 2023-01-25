package org.example.twitterApp.objectClassAndRepository.modelDTO;

import java.util.Set;

public class PostDTOFeed implements Comparable<PostDTOFeed> {

    String postBy;
    String message;
    String createDate;
    boolean onlyMe;
    Set<LikeDtO> postLikes;
    Set<MentionForPostDTO> mentions;
    Set<ReplyDtO> postReplies;

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

    public Set<MentionForPostDTO> getMentions() {
        return mentions;
    }

    public void setMentions(Set<MentionForPostDTO> mentions) {
        this.mentions = mentions;
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
                ", postLikes=" + postLikes +
                ", mentions=" + mentions +
                ", postReplies=" + postReplies +
                '}';
    }
}
