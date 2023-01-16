package org.example.twitterApp.objectClassAndRepository.model.like;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;

import javax.persistence.*;

@Entity
@Table(name = "like_post")
public class LikePost extends Like {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post postLiked;

    public LikePost() {
    }

    public Post getPostLiked() {
        return postLiked;
    }

    public void setPostLiked(Post postLiked) {
        this.postLiked = postLiked;
    }

    @Override
    public String toString() {
        return "LikePost{" + super.toString() +
                "postLiked=" + postLiked +
                "} ";
    }
}
