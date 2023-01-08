package org.example.objectClassAndRepository.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table
public class Post extends PostedMessages {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postId", referencedColumnName = "id")
    private Set<Reply> replies = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postId", referencedColumnName = "id")
    private Set<Like> likes = new HashSet<>();

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "replies=" + replies +
                ", likes=" + likes +
                "} " + super.toString();
    }
}