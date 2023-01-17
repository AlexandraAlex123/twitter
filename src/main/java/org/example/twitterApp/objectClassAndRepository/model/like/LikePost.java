package org.example.twitterApp.objectClassAndRepository.model.like;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;

import javax.persistence.*;

@Entity
@Table(name = "like_post")
public class LikePost extends Like {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post postLike;

    public LikePost() {
    }

    public Post getPostLike() {
        return postLike;
    }

    public void setPostLike(Post postLike) {
        this.postLike = postLike;
    }

    @Override
    public String toString() {
        return "LikePost{" + super.toString() +
                "postLiked=" + postLike +
                "} ";
    }
}
