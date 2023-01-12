package org.example.objectClassAndRepository.model;

import org.example.objectClassAndRepository.model.posts.Post;
import org.example.objectClassAndRepository.model.posts.Reply;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Mention {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mention_id")
    private Long mentionId;

    @Column(name = "user_who_mention")
    private String userWhoMention;

    @Column(name = "time_mention")
    private Timestamp createDate;

    @OneToOne
    @JoinColumn(name = "posts_id", insertable = false, updatable = false)
    private Post post;

    @OneToOne
    @JoinColumn(name = "posts_id", insertable = false, updatable = false)
    private Reply reply;

    public Mention(String userWhoMention, Timestamp createDate) {
        this.userWhoMention = userWhoMention;
        this.createDate = createDate;
    }

    public Mention() {
    }

    public Long getMentionId() {
        return mentionId;
    }

    public void setMentionId(Long mentionId) {
        this.mentionId = mentionId;
    }

    public String getUserWhoMention() {
        return userWhoMention;
    }

    public void setUserWhoMention(String userWhoMention) {
        this.userWhoMention = userWhoMention;
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

    @Override
    public String toString() {
        return "Mention{" +
                "mentionId=" + mentionId +
                ", userWhoMention='" + userWhoMention + '\'' +
                ", createDate=" + createDate +
                ", post=" + post +
                ", reply=" + reply +
                '}';
    }
}
