package org.example.objectClassAndRepository.model.posts;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PostedMessages {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @Column(name = "message", length = 100000)
    private String message;

    @Column(name = "date_of_posting")
    private Timestamp date;

    @Column(name = "not_public")
    private Boolean onlyMe;


    public PostedMessages() {
    }

    public PostedMessages(String message, Timestamp date, Boolean onlyMe) {
        this.message = message;
        this.date = date;
        this.onlyMe = onlyMe;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Boolean getOnlyMe() {
        return onlyMe;
    }

    public void setOnlyMe(Boolean onlyMe) {
        this.onlyMe = onlyMe;
    }

    @Override
    public String toString() {
        return "PostedMessages{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", onlyMe=" + onlyMe +
                '}';
    }
}
