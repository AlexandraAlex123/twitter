package org.example.twitterApp.objectClassAndRepository.model.posts;

import org.example.twitterApp.objectClassAndRepository.model.like.Like;
import org.example.twitterApp.objectClassAndRepository.model.mention.Mention;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Reply extends PostedMessages {


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "reply_id", referencedColumnName = "id")
    private List<Reply> replies;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reply_id", referencedColumnName = "id")
    private List<Like> likes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reply_id", referencedColumnName = "id")
    private List<Mention> mentions;


    public Reply() {
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
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
        return "Reply{" + super.toString() +
                "replies=" + replies +
                ", likes=" + likes +
                ", mentions=" + mentions +
                "} ";
    }
}
