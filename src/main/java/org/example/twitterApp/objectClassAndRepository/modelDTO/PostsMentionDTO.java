package org.example.twitterApp.objectClassAndRepository.modelDTO;

public class PostsMentionDTO {

    String postBy;
    String message;
    boolean onlyMe;

    public PostsMentionDTO() {
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


    public boolean isOnlyMe() {
        return onlyMe;
    }

    public void setOnlyMe(boolean onlyMe) {
        this.onlyMe = onlyMe;
    }

    @Override
    public String toString() {
        return "PostsMentionDTO{" +
                "postBy='" + postBy + '\'' +
                ", message='" + message + '\'' +
                ", onlyMe=" + onlyMe +
                '}';
    }
}
