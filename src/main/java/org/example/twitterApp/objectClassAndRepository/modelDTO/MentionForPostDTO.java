package org.example.twitterApp.objectClassAndRepository.modelDTO;

public class MentionForPostDTO implements Comparable<MentionForPostDTO> {

    String userMention;
    String createDate;

    public MentionForPostDTO() {
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUserMention() {
        return userMention;
    }

    public void setUserMention(String userMention) {
        this.userMention = userMention;
    }

    @Override
    public int compareTo(MentionForPostDTO o) {
        int i = this.createDate.compareTo(o.getCreateDate());
        return Integer.compare(0, i);
    }

    @Override
    public String toString() {
        return "MentionDtO{" +
                "userMention='" + userMention + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

}
