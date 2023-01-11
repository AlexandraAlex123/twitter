package org.example.objectClassAndRepository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table
public class Post extends PostedMessages {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postId", referencedColumnName = "id")
    private final Set<Reply> replies = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postId", referencedColumnName = "id")
    private final Set<Like> likes = new HashSet<>();

    public Post(String message, Timestamp timestamp, boolean onlyMe) {
        super(message, timestamp, onlyMe);
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" + super.toString() +
                "replies=" + replies +
                ", likes=" + likes +
                "}";
    }

}