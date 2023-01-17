package org.example.twitterApp.objectClassAndRepository.model.posts;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;

import javax.persistence.*;
import java.sql.Timestamp;


@MappedSuperclass
public class PostedMessages implements Comparable<PostedMessages> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @Column(name = "message", length = 100000)
    private String message;

    @Column(name = "date_of_posting")
    private Timestamp createDate;

    @Column(name = "not_public")
    private Boolean onlyMe;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_who_post")
    private TwitterUser userWhoPost;


    public PostedMessages() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Boolean getOnlyMe() {
        return onlyMe;
    }

    public void setOnlyMe(Boolean onlyMe) {
        this.onlyMe = onlyMe;
    }

    public TwitterUser getUserWhoPost() {
        return userWhoPost;
    }

    public void setUserWhoPost(TwitterUser userWhoPost) {
        this.userWhoPost = userWhoPost;
    }


    @Override
    public int compareTo(PostedMessages o) {
        return this.createDate.compareTo(o.getCreateDate());
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", message='" + message + '\'' +
                ", createDate=" + createDate +
                ", onlyMe=" + onlyMe +
                ", userWhoPost=" + userWhoPost;
    }
}
