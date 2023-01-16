package org.example.twitterApp.objectClassAndRepository.model;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Mention {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mention_id")
    private Long mentionId;

    @Column(name = "time_mention")
    private Timestamp createDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_mentioning")
    private TwitterUser userMentioning;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "user_mention")
    private TwitterUser userMention;

    @OneToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToOne
    @JoinColumn(name = "reply_id")
    private Reply reply;


    public Mention() {
    }

    public Long getMentionId() {
        return mentionId;
    }

    public void setMentionId(Long mentionId) {
        this.mentionId = mentionId;
    }

    public TwitterUser getUserMentioning() {
        return userMentioning;
    }

    public void setUserMentioning(TwitterUser userMentioning) {
        this.userMentioning = userMentioning;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public TwitterUser getUserMention() {
        return userMention;
    }

    public void setUserMention(TwitterUser userMention) {
        this.userMention = userMention;
    }

    @Override
    public String toString() {
        return "Mention{" +
                "mentionId=" + mentionId +
                ", createDate=" + createDate +
                ", userMentioning=" + userMentioning +
                ", userMention=" + userMention +
                ", post=" + post +
                ", reply=" + reply +
                '}';
    }
}
