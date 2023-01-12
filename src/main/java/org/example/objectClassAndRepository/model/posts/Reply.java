package org.example.objectClassAndRepository.model.posts;

import org.example.classService.service.classDtO.PostDtO;
import org.example.objectClassAndRepository.model.Like;
import org.example.objectClassAndRepository.model.Mention;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Reply extends PostedMessages {

    @Column(name = "user_who_reply", length = 300)
    private String userWhoReply;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "reply_id", referencedColumnName = "id")
    private Set<Reply> replies;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "posts_id", referencedColumnName = "id")
    private Set<Like> likes;


    public Reply(String message, Timestamp date, Boolean onlyMe, String userWhoReply) {
        super(message, date, onlyMe);
        this.userWhoReply = userWhoReply;
    }

    public Reply() {
    }

    public String getUserWhoReply() {
        return userWhoReply;
    }

    public void setUserWhoReply(String userWhoReply) {
        this.userWhoReply = userWhoReply;
    }

    public Set<Reply> getReplies() {
        return replies;
    }

    public void setReplies(Set<Reply> replies) {
        this.replies = replies;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "userWhoReply='" + userWhoReply + '\'' +
                ", replies=" + replies +
                ", likes=" + likes +
                "} " + super.toString();
    }

}
