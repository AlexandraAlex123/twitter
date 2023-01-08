package org.example.objectClassAndRepository.model;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "followId")
    private Long followId;

    @Column(name = "usernameWhoFollowYou")
    private String usernameWhoFollowYou;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public Follow(String usernameWhoFollowYou, Timestamp timestamp) {
        this.usernameWhoFollowYou = usernameWhoFollowYou;
        this.timestamp = timestamp;
    }

    public Follow() {
    }

    public String getUsernameWhoFollowYou() {
        return usernameWhoFollowYou;
    }

    public void setUsernameWhoFollowYou(String usernameWhoFollowYou) {
        this.usernameWhoFollowYou = usernameWhoFollowYou;
    }

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
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
                "followId=" + followId +
                ", usernameWhoFollowYou='" + usernameWhoFollowYou + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
