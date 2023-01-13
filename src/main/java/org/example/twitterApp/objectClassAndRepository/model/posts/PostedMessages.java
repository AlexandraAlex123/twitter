package org.example.twitterApp.objectClassAndRepository.model.posts;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PostedMessages implements Comparable<PostedMessages> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @Column(name = "message", length = 100000)
    private String message;

    @Column(name = "date_of_posting")
    private Timestamp createDate;

    @Column(name = "not_public")
    private Boolean onlyMe;


    public PostedMessages() {
    }

    public PostedMessages(String message, Timestamp createDate, Boolean onlyMe) {
        this.message = message;
        this.createDate = createDate;
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Boolean getOnlyMe() {
        return onlyMe;
    }

    public void setOnlyMe(Boolean onlyMe) {
        this.onlyMe = onlyMe;
    }

    @Override
    public int compareTo(PostedMessages o) {
        return this.createDate.compareTo(o.getCreateDate());
    }

    @Override
    public String toString() {
        return "PostedMessages{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", createDate=" + createDate +
                ", onlyMe=" + onlyMe +
                '}';
    }

}
