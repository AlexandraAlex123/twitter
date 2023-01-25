package org.example.twitterApp.objectClassAndRepository.model.like.modelDTO;

public class FollowDtO implements Comparable<FollowDtO> {

    private String usernameFollow;
    private String createDate;

    public FollowDtO(String usernameFollow, String createDate) {
        this.usernameFollow = usernameFollow;
        this.createDate = createDate;
    }

    public FollowDtO() {
    }

    public String getUsernameFollow() {
        return usernameFollow;
    }

    public void setUsernameFollow(String usernameFollow) {
        this.usernameFollow = usernameFollow;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public int compareTo(FollowDtO o) {
        int i = this.createDate.compareTo(o.getCreateDate());
        return Integer.compare(0, i);
    }

    @Override
    public String toString() {
        return "FollowDtO{" +
                "usernameFollow='" + usernameFollow + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

}
