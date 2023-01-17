package org.example.twitterApp.objectClassAndRepository.model.posts;

import org.example.twitterApp.objectClassAndRepository.model.like.LikePost;
import org.example.twitterApp.objectClassAndRepository.model.Mention;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
public class Post extends PostedMessages {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private List<Reply> replies;

    @OneToMany(mappedBy = "postLike",cascade = CascadeType.ALL)
    private List<LikePost> likes;

    @OneToMany(mappedBy = "postMention",cascade = CascadeType.ALL)
    private List<Mention> mentions;


    public Post() {
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public List<LikePost> getLikes() {
        return likes;
    }

    public void setLikes(List<LikePost> likes) {
        this.likes = likes;
    }

    public List<Mention> getMentions() {
        return mentions;
    }

    public void setMentions(List<Mention> mentions) {
        this.mentions = mentions;
    }

    @Override
    public String toString() {
        return "Post{" + super.toString() +
                "replies=" + replies +
                ", likes=" + likes +
                ", mentions=" + mentions +
                "} ";
    }

}
