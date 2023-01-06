package org.example.objectClassAndRepository.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "twitter_user")
public class TwitterUser {

    @Id
    @Column(name = "userName", length = 300, unique = true)
    private String userName;

    @Column(name = "password", length = 300)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "userName" )
    private Set<Follow> follows = new HashSet<>();

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "userName" )
    private List<Post> posts = new ArrayList<>();

    public TwitterUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public TwitterUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Follow> getFollows() {
        return follows;
    }

    public void setFollows(Set<Follow> follows) {
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
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
