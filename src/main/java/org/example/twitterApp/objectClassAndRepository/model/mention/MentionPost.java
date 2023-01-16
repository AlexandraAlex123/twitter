package org.example.twitterApp.objectClassAndRepository.model.mention;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;

import javax.persistence.*;

@Entity
@Table(name = "mention_post")
public class MentionPost extends Mention{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    public MentionPost() {
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "MentionPost{" + super.toString() +
                "post=" + post +
                "} ";
    }
}
