package org.example.objectClassAndRepository.model;


import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "follow_id")
    private Long followId;

    @Column(name = "user_followed")
    private String usernameFollowed;

    @Column(name = "start_follow")
    private Timestamp date;

    public Follow(String usernameFollowed, Timestamp date) {
        this.usernameFollowed = usernameFollowed;
        this.date = date;
    }

    public Follow() {
    }

    public String getUsernameFollowed() {
        return usernameFollowed;
    }

    public void setUsernameFollowed(String usernameFollowed) {
        this.usernameFollowed = usernameFollowed;
    }

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "followId=" + followId +
                ", usernameFollowed='" + usernameFollowed + '\'' +
                ", date=" + date +
                '}';
    }
}
