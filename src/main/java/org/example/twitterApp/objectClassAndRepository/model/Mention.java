package org.example.twitterApp.objectClassAndRepository.model;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table
public class Mention {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @Column(name = "time_mention")
    private Timestamp createDate;

    @Column(name = "user_mentioning")
    private String userMentioning;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_mention")
    private TwitterUser userMention;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post postMention;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reply_id")
    private Reply replyMention;

    public Mention() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserMentioning() {
        return userMentioning;
    }

    public void setUserMentioning(String userMentioning) {
        this.userMentioning = userMentioning;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }


    public TwitterUser getUserMention() {
        return userMention;
    }

    public void setUserMention(TwitterUser userMention) {
        this.userMention = userMention;
    }

    public Reply getReplyMention() {
        return replyMention;
    }

    public void setReplyMention(Reply replyMention) {
        this.replyMention = replyMention;
    }

    public Post getPostMention() {
        return postMention;
    }

    public void setPostMention(Post postMention) {
        this.postMention = postMention;
    }

    @Override
    public String toString() {
        return "Mention{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", userMentioning=" + userMentioning +
                ", userMention=" + userMention +
                ", post=" + postMention +
                ", reply=" + replyMention +
                '}';
    }
}
