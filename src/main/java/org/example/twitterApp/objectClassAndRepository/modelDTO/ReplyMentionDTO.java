package org.example.twitterApp.objectClassAndRepository.modelDTO;

public class ReplyMentionDTO implements Comparable<ReplyMentionDTO>{
    String message;
    String createDate;
    boolean onlyMe;

    public ReplyMentionDTO(String message, String createDate, boolean onlyMe) {
        this.message = message;
        this.createDate = createDate;
        this.onlyMe = onlyMe;
    }

    public ReplyMentionDTO() {
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


    @Override
    public int compareTo(ReplyMentionDTO o) {
        int i = this.createDate.compareTo(o.getCreateDate());
        return Integer.compare(0, i);
    }
}
