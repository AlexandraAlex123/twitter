package org.example.objectClassAndRepository.model;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "timeStamp")
    private Timestamp timestamp;

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

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                '}';
    }
}
