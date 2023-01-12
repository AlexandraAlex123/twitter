package org.example.objectClassAndRepository.model.posts;

import com.mysql.cj.xdevapi.TableImpl;
import org.example.objectClassAndRepository.model.Mention;
import org.example.objectClassAndRepository.model.Like;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Reply extends PostedMessages {

    @Column(name = "user_who_reply", length = 300)
    private String userWhoReply;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "reply_id", referencedColumnName = "id")
    private List<Reply> replies;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "posts_id", referencedColumnName = "id")
    private List<Like> likes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "posts_id", referencedColumnName = "id")
    private List<Mention> mentions;


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

    @Override
    public String toString() {
        return "Reply{" + super.toString() +
                "userWhoReply='" + userWhoReply + '\'' +
                ", replies=" + replies +
                ", likes=" + likes +
                ", mentions=" + mentions +
                "} " ;
    }
}
