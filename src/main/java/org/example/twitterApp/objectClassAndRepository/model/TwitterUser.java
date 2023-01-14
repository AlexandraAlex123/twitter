package org.example.twitterApp.objectClassAndRepository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_who_follow", referencedColumnName = "username")
    private List<Follow> follows;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_who_post", referencedColumnName = "username")
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_mentioned", referencedColumnName = "username")
    public List<Mention> mentions;

    public TwitterUser(String username, String password, Timestamp createDate) {
        this.username = username;
        this.password = password;
        this.createDate = createDate;
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
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

    public List<Mention> getMentions() {
        return mentions;
    }

    public void setMentions(List<Mention> mentions) {
        this.mentions = mentions;
    }

    @Override
    public int compareTo(TwitterUser o) {
        return this.username.compareTo(o.getUsername());
    }

    @Override
    public String toString() {
        return "TwitterUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                ", follows=" + follows +
                ", posts=" + posts +
                ", mentions=" + mentions +
                '}';
    }
}