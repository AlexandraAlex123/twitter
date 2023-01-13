package org.example.twitterApp.objectClassAndRepository.classDtO;

public class PostDTOMention {

    String message;
    String createDate;
    boolean onlyMe;

    public PostDTOMention(String message, String createDate, boolean onlyMe) {
        this.message = message;
        this.createDate = createDate;
        this.onlyMe = onlyMe;
    }

    public PostDTOMention() {
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
                "message='" + message + '\'' +
                ", createDate='" + createDate + '\'' +
                ", onlyMe=" + onlyMe +
                '}';
    }
}
