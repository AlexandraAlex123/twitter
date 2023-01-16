package org.example.twitterApp.objectClassAndRepository.model.like;

import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

import javax.persistence.*;

@Entity
@Table(name = "like_reply")
public class LikeReply extends Like{
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "reply_id")
    private Reply replyLiked;

    public LikeReply() {
    }

    public Reply getReplyLiked() {
        return replyLiked;
    }

    public void setReplyLiked(Reply replyLiked) {
        this.replyLiked = replyLiked;
    }

    @Override
    public String toString() {
        return "LikeReply{" +super.toString() +
                "replyLiked=" + replyLiked +
                "} ";
    }
}
