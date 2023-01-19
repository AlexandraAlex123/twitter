package org.example.twitterApp.objectClassAndRepository.model.mention;

import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

import javax.persistence.*;


@Entity
@Table(name = "mention_reply")
public class MentionReply extends Mention{

    @ManyToOne
    @JoinColumn(name = "reply_id")
    private Reply replyMention;

    public Reply getReplyMention() {
        return replyMention;
    }

    public void setReplyMention(Reply replyMention) {
        this.replyMention = replyMention;
    }

    @Override
    public String toString() {
        return "MentionReply{" + super.toString() +
                "replyMention=" + replyMention +
                "} ";
    }
}
