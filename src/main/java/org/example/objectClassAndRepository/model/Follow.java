package org.example.objectClassAndRepository.model;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Follow implements Comparable<Follow> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "follow_id")
    private Long followId;

    @Column(name = "user_followed")
    private String usernameFollowed;

    @Column(name = "start_follow")
    private Timestamp createDate;

    public Follow(String usernameFollowed, Timestamp createDate) {
        this.usernameFollowed = usernameFollowed;
        this.createDate = createDate;
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "followId=" + followId +
                ", usernameFollowed='" + usernameFollowed + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public int compareTo(Follow o) {
       return this.createDate.compareTo(o.createDate);
    }
}
