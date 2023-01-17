package org.example.twitterApp.objectClassAndRepository.model.like;

import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

import javax.persistence.*;

@Entity
@Table(name = "like_reply")
public class LikeReply extends Like{
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "reply_id")
    private Reply replyLike;

    public LikeReply() {
    }

    public Reply getReplyLike() {
        return replyLike;
    }

    public void setReplyLike(Reply replyLike) {
        this.replyLike = replyLike;
    }

    @Override
    public String toString() {
        return "LikeReply{" +super.toString() +
                "replyLiked=" + replyLike +
                "} ";
    }
}
