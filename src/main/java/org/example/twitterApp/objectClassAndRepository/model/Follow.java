package org.example.twitterApp.objectClassAndRepository.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Follow implements Comparable<Follow> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "follow_id")
    private Long followId;

    @Column(name = "start_follow")
    private Timestamp createDate;

    @Column(name = "user_follow")
    private String userFollow;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_following")
    private TwitterUser userFollowing;


    public Follow() {
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

    public String getUserFollow() {
        return userFollow;
    }

    public void setUserFollow(String userFollow) {
        this.userFollow = userFollow;
    }

    public TwitterUser getUserFollowing() {
        return userFollowing;
    }

    public void setUserFollowing(TwitterUser userFollowing) {
        this.userFollowing = userFollowing;
    }


    @Override
    public String toString() {
        return "Follow{" +
                "followId=" + followId +
                ", createDate=" + createDate +
                ", userFollow=" + userFollow +
                ", userFollowing=" + userFollowing +
                '}';
    }

    @Override
    public int compareTo(Follow o) {
       return this.createDate.compareTo(o.createDate);
    }
}
