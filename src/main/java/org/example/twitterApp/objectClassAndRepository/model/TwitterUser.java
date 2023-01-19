package org.example.twitterApp.objectClassAndRepository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table
public class TwitterUser implements Comparable<TwitterUser> {

    @Id
    @Column(name = "username", length = 300, unique = true)
    private String username;

    @Column(name = "password", length = 300)
    private String password;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "last_login")
    private Timestamp lastLogin;

    @OneToMany(mappedBy = "userFollowing", cascade = CascadeType.ALL)
    private List<Follow> follows;

    @OneToMany(mappedBy = "userWhoPost", cascade = CascadeType.ALL)
    private List<Post> posts;

    public TwitterUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<Follow> getFollows() {
        return follows;
    }

    public void setFollows(List<Follow> follows) {
        this.follows = follows;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public int compareTo(TwitterUser o) {
        return this.createDate.compareTo(o.getCreateDate());
    }

    @Override
    public String toString() {
        return "TwitterUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                ", lastLogin=" + lastLogin +
                ", follows=" + follows +
                ", posts=" + posts +
                '}';
    }
}
