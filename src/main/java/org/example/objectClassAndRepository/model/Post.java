package org.example.objectClassAndRepository.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "postFromUser")
public class Post extends PostedMessages {

    @OneToMany(targetEntity = Reply.class)
    private Set<Reply> replies = new HashSet<>();

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "replies=" + replies +
                "} " + super.toString();
    }
}