package org.example.twitterApp.objectClassAndRepository.model.mention;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;

import javax.persistence.*;
import java.sql.Timestamp;


@MappedSuperclass
public class Mention {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @Column(name = "time_mention")
    private Timestamp createDate;

    @ManyToOne
    @JoinColumn(name = "user_mention")
    private TwitterUser userMention;

    public Mention() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public TwitterUser getUserMention() {
        return userMention;
    }

    public void setUserMention(TwitterUser userMention) {
        this.userMention = userMention;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", createDate=" + createDate +
                ", userMention=" + userMention;
    }
}
