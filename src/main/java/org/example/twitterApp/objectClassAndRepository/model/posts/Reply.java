package org.example.twitterApp.objectClassAndRepository.model.posts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.twitterApp.objectClassAndRepository.model.like.LikeReply;
import org.example.twitterApp.objectClassAndRepository.model.mention.MentionReply;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reply")
public class Reply extends PostBase {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reply_id", referencedColumnName = "id")
    private Reply replyReply;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "replyReply")
    private List<Reply> replies;

    @OneToMany(mappedBy = "replyLike", cascade = CascadeType.ALL)
    private List<LikeReply> likes;

    @JsonIgnore
    @OneToMany(mappedBy = "replyMention", cascade = CascadeType.ALL)
    private List<MentionReply> mentions;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post replyPost;

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

    public List<MentionReply> getMentions() {
        return mentions;
    }

    public void setMentions(List<MentionReply> mentions) {
        this.mentions = mentions;
    }

    public Post getReplyPost() {
        return replyPost;
    }

    public void setReplyPost(Post replyPost) {
        this.replyPost = replyPost;
    }

    @Override
    public String toString() {
        return "Reply{" + super.toString() +
                "replyReply=" + replyReply +
                ", replies=" + replies +
                ", likes=" + likes +
                ", mentions=" + mentions +
                ", replyPost=" + replyPost +
                "} ";
    }
}
