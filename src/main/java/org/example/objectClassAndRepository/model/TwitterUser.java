package org.example.objectClassAndRepository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.objectClassAndRepository.model.posts.Post;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class TwitterUser {

    @Id
    @Column(name = "username", length = 300, unique = true)
    private String username;

    @Column(name = "password", length = 300)
    private String password;

    @Column(name = "create_date")
    private Timestamp date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_who_follow", referencedColumnName = "username")
    private List<Follow> follows = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_who_post", referencedColumnName = "username")
    private List<Post> posts = new ArrayList<>();

    public TwitterUser(String username, String password, Timestamp date) {
        this.username = username;
        this.password = password;
        this.date = date;
    }

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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
    public String toString() {
        return "TwitterUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                ", follows=" + follows +
                ", posts=" + posts +
                '}';
    }
}
