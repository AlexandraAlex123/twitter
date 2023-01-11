package org.example.objectClassAndRepository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class TwitterUser {

    @Id
    @Column(name = "username", length = 300, unique = true)
    private String username;

    @Column(name = "password", length = 300)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private List<Follow> follows = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private List<Post> posts = new ArrayList<>();

    public TwitterUser(String username, String password) {
        this.username = username;
        this.password = password;
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
                '}';
    }
}
