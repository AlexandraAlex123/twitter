package org.example.twitterApp.objectClassAndRepository.model.posts;

import org.example.twitterApp.objectClassAndRepository.model.Mention;
import org.example.twitterApp.objectClassAndRepository.model.like.LikeReply;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reply")
public class Reply extends PostedMessages {

    @ManyToOne(cascade = CascadeType.ALL)
    private Reply replyReply;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "replyReply")
    private List<Reply> replies;

    @OneToMany(mappedBy = "replyLike",cascade = CascadeType.ALL)
    private List<LikeReply> likes;

    @OneToMany(mappedBy = "replyMention",cascade = CascadeType.ALL)
    private List<Mention> mentions;


    public Reply() {
    }

    public Reply getReplyReply() {
        return replyReply;
    }

    public void setReplyReply(Reply replyReply) {
        this.replyReply = replyReply;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public List<LikeReply> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeReply> likes) {
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
                "replyReply=" + replyReply +
                ", replies=" + replies +
                ", likes=" + likes +
                ", mentions=" + mentions +
                "} ";
    }
}
