package org.example.twitterApp.objectClassAndRepository.model.mention;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;

import javax.persistence.*;


@Entity
@Table(name = "mention_post")
public class MentionPost extends Mention {

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post postMention;

    public Post getPostMention() {
        return postMention;
    }

    public void setPostMention(Post postMention) {
        this.postMention = postMention;
    }

    @Override
    public String toString() {
        return "MentionPost{" + super.toString() +
                "postMention=" + postMention +
                "} ";
    }
}
