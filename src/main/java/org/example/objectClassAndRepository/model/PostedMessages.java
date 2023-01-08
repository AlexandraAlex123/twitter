package org.example.objectClassAndRepository.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PostedMessages {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @Column(name = "message", length = 100000)
    private String message;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "onlyMe")
    private boolean onlyMe;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private TwitterUser twitterUser;

    public PostedMessages(String message, Timestamp timestamp, boolean onlyMe, TwitterUser twitterUser) {
        this.message = message;
        this.timestamp = timestamp;
        this.onlyMe = onlyMe;
        this.twitterUser = twitterUser;
    }

    public PostedMessages() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "PostedMessages{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", onlyMe=" + onlyMe +
                ", twitterUser=" + twitterUser +
                '}';
    }
}
