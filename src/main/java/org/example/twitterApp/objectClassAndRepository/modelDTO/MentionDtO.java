package org.example.twitterApp.objectClassAndRepository.modelDTO;

public class MentionDtO implements Comparable<MentionDtO> {

    String userMention;
    String createDate;

    public MentionDtO() {
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
    public String toString() {
        return "MentionDtO{" +
                "userMention='" + userMention + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

    @Override
    public int compareTo(MentionDtO o) {
        int i = this.createDate.compareTo(o.getCreateDate());
        return Integer.compare(0, i);
    }
}
