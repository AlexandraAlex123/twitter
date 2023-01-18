package org.example.twitterApp.objectClassAndRepository.modelDTO;

import java.util.Set;

public class TwitterUserDtO implements Comparable<TwitterUserDtO> {

    String account;
    String createDate;
    Set<FollowDtO> yourFollows;
    Set<PostDtO> yourPosts;


    public TwitterUserDtO() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Set<FollowDtO> getYourFollows() {
        return yourFollows;
    }

    public void setYourFollows(Set<FollowDtO> yourFollows) {
        this.yourFollows = yourFollows;
    }

    public Set<PostDtO> getYourPosts() {
        return yourPosts;
    }

    public void setYourPosts(Set<PostDtO> yourPosts) {
        this.yourPosts = yourPosts;
    }


    @Override
    public int compareTo(TwitterUserDtO o) {
        return this.account.compareTo(o.getAccount());
    }

    @Override
    public String toString() {
        return "TwitterUserDtO{" +
                "account='" + account + '\'' +
                ", createDate='" + createDate + '\'' +
                ", yourFollows=" + yourFollows +
                ", yourPosts=" + yourPosts +
                '}';
    }
}
