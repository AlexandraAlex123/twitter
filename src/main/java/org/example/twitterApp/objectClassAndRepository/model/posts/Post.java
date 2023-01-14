package org.example.twitterApp.objectClassAndRepository.model.posts;

import org.example.twitterApp.objectClassAndRepository.model.Like;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Post extends PostedMessages {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private List<Reply> replies;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private List<Like> likes;


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


    @Override
    public String toString() {
        return "Post{" +
                "replies=" + replies +
                ", likes=" + likes +
                "} " + super.toString();
    }

}
