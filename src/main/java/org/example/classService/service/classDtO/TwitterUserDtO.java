package org.example.classService.service.classDtO;

import org.example.objectClassAndRepository.model.Follow;
import org.example.objectClassAndRepository.model.Post;

import java.util.List;

public class TwitterUserDtO implements  Comparable<TwitterUserDtO> {

    String username;
    private List<Follow> follow;
    private List<Post> posts;

    public TwitterUserDtO(String username, List<Follow> follow, List<Post> posts) {
        this.username = username;
        this.follow = follow;
        this.posts = posts;
    }

    public TwitterUserDtO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Follow> getFollow() {
        return follow;
    }

    public void setFollow(List<Follow> follow) {
        this.follow = follow;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "TwitterUserDtO{" +
                "username='" + username + '\'' +
                ", follow=" + follow +
                ", posts=" + posts +
                '}';
    }

    @Override
    public int compareTo(TwitterUserDtO o) {
        return this.username.compareTo(o.getUsername());
    }
}
