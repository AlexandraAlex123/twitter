package org.example.twitterApp.objectClassAndRepository.modelDTO;

public class PostDTOMention implements Comparable<PostDTOMention>{

    String postBy;
    String message;
    String createDate;
    boolean onlyMe;

    public PostDTOMention(String postBy, String message, String createDate, boolean onlyMe) {
        this.postBy = postBy;
        this.message = message;
        this.createDate = createDate;
        this.onlyMe = onlyMe;
    }

    public PostDTOMention() {
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

    @Override
    public String toString() {
        return "PostDTOMention{" +
                "postBy='" + postBy + '\'' +
                ", message='" + message + '\'' +
                ", createDate='" + createDate + '\'' +
                ", onlyMe=" + onlyMe +
                '}';
    }

    @Override
    public int compareTo(PostDTOMention o) {
        int i = this.createDate.compareTo(o.getCreateDate());
        return Integer.compare(0, i);
    }
}
