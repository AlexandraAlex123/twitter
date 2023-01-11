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

    @Column(name = "usernameFollow")
    private String usernameFollow;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public Follow(String usernameFollow, Timestamp timestamp) {
        this.usernameFollow = usernameFollow;
        this.timestamp = timestamp;
    }

    public Follow() {
    }

    public String getUsernameFollow() {
        return usernameFollow;
    }

    public void setUsernameFollow(String usernameFollow) {
        this.usernameFollow = usernameFollow;
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
                ", usernameFollow='" + usernameFollow + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
