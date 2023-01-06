package org.example.objectClassAndRepository.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PostedMessages {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @Column(name = "message", length = 100000)
    private String message;

    @Column(name = "timeStamp")
    private Timestamp timeStamp;

    @Column(name = "onlyMe")
    private boolean onlyMe;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private TwitterUser twitterUser;

    public PostedMessages(String message, Timestamp timeStamp, boolean onlyMe, TwitterUser twitterUser) {
        this.message = message;
        this.timeStamp = timeStamp;
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

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "PostedMessages{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                ", onlyMe=" + onlyMe +
                ", twitterUser=" + twitterUser +
                '}';
    }
}
