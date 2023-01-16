package org.example.twitterApp.objectClassAndRepository.model;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "like_a_post")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "like_id")
    private Long id;

    @Column(name = "create_date")
    private Timestamp createDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "who_gives_like")
    private TwitterUser whoGivesLike;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "post_id")
    private Post postLiked;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "reply_id")
    private Reply replyLiked;



    public Like() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TwitterUser getWhoGivesLike() {
        return whoGivesLike;
    }

    public void setWhoGivesLike(TwitterUser whoGivesLike) {
        this.whoGivesLike = whoGivesLike;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Post getPostLiked() {
        return postLiked;
    }

    public void setPostLiked(Post postLiked) {
        this.postLiked = postLiked;
    }

    public Reply getReplyLiked() {
        return replyLiked;
    }

    public void setReplyLiked(Reply replyLiked) {
        this.replyLiked = replyLiked;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", whoGivesLike=" + whoGivesLike +
                ", postLiked=" + postLiked +
                ", replyLiked=" + replyLiked +
                '}';
    }
}
