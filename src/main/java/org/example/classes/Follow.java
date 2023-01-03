package org.example.classes;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "timestamp")
    private Timestamp timestamp;


    @OneToOne
    private User user;

    public Follow(Timestamp timestamp, User user) {
        this.timestamp = timestamp;
        this.user = user;
    }

    public Follow() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", user=" + user +
                '}';
    }
}
