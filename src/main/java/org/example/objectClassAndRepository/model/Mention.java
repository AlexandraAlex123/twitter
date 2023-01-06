package org.example.objectClassAndRepository.model;

import javax.persistence.*;

@Entity
public class Mention {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private TwitterUser twitterUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reply_id")
    private Reply reply;

    public Mention(TwitterUser twitterUser, Post post, Reply reply) {
        this.twitterUser = twitterUser;
        this.post = post;
        this.reply = reply;
    }

    public Mention() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Mention{" +
                "id=" + id +
                ", twitterUser=" + twitterUser +
                ", post=" + post +
                ", reply=" + reply +
                '}';
    }
}
