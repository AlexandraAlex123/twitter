package org.example.twitterApp.objectClassAndRepository.model.mention;

import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

import javax.persistence.*;

@Entity
@Table(name = "mention_reply")
public class MentionReply extends Mention {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reply_id")
    private Reply reply;

    public MentionReply() {
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "MentionReply{" + super.toString() +
                "reply=" + reply +
                "} ";
    }
}
