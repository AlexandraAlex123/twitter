package org.example.objectClassAndRepository.model;

import javax.persistence.*;

@Entity
@Table
public class Mention {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mentionId")
    private Long mentionId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private TwitterUser twitterUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "postId")
    private Post post;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "replyId")
    private Reply reply;

    public Mention(TwitterUser twitterUser, Post post, Reply reply) {
        this.twitterUser = twitterUser;
        this.post = post;
        this.reply = reply;
    }

    public Mention() {
    }

    public Long getMentionId() {
        return mentionId;
    }

    public void setMentionId(Long mentionId) {
        this.mentionId = mentionId;
    }

    public TwitterUser getTwitterUser() {
        return twitterUser;
    }

    public void setTwitterUser(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
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
                ", twitterUser=" + twitterUser +
                ", post=" + post +
                ", reply=" + reply +
                '}';
    }
}
