package org.example.objectClassAndRepository.model.posts;

import org.example.objectClassAndRepository.model.Mention;
import org.example.objectClassAndRepository.model.Like;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Post extends PostedMessages {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private List<Reply> replies;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "posts_id", referencedColumnName = "id")
    private List<Like> likes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "posts_id", referencedColumnName = "id")
    private List<Mention> mentions;

    public Post(String message, Timestamp date, Boolean onlyMe) {
        super(message, date, onlyMe);
    }

    public Post() {
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
        return "Post{" + super.toString() +
                "replies=" + replies +
                ", likes=" + likes +
                ", mentions=" + mentions +
                "} ";
    }
}