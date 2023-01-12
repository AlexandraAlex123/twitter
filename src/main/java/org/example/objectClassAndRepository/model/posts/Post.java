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
public class Post extends PostedMessages {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Set<Reply> replies;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "posts_id", referencedColumnName = "id")
    private Set<Like> likes;


    public Post(String message, Timestamp date, Boolean onlyMe) {
        super(message, date, onlyMe);
    }


    public Post() {
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
        return "Post{" +
                "replies=" + replies +
                ", likes=" + likes +
                "} " + super.toString();
    }

}
