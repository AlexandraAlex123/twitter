package org.example.classes;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;

    @Column(name = "message", nullable = false, length = 300)
    private String message;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date timeStamp;

    @OneToOne
    private User user;

    @OneToMany(targetEntity = Reply.class)
    private Set<Reply> replies = new HashSet<>();

    public Post(String message, Date timeStamp, User user, Set<Reply> replies) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.user = user;
        this.replies = replies;
    }

    public Post() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Reply> getReplies() {
        return replies;
    }

    public void setReplies(Set<Reply> replies) {
        this.replies = replies;
    }
}