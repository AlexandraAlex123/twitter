package org.example.twitterApp.objectClassAndRepository.modelDTO;

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
        if(i == 0){
            return 0;
        } else if (i < 0) {
            return -1;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "FollowDtO{" +
                "usernameFollow='" + usernameFollow + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

}
