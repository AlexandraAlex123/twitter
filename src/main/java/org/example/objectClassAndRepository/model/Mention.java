package org.example.objectClassAndRepository.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Mention {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mention_id")
    private Long mentionId;

    @Column(name = "user_mentioned")
    private String userMentioned;

    @Column(name = "user_who_mention")
    private String userWhoMention;

    @Column(name = "time_mention")
    private Timestamp date;

    public Mention(String userMentioned, String userWhoMention, Timestamp date) {
        this.userMentioned = userMentioned;
        this.userWhoMention = userWhoMention;
        this.date = date;
    }

    public Mention() {
    }

    public Long getMentionId() {
        return mentionId;
    }

    public void setMentionId(Long mentionId) {
        this.mentionId = mentionId;
    }

    public String getUserMentioned() {
        return userMentioned;
    }

    public void setUserMentioned(String userMentioned) {
        this.userMentioned = userMentioned;
    }

    public String getUserWhoMention() {
        return userWhoMention;
    }

    public void setUserWhoMention(String userWhoMention) {
        this.userWhoMention = userWhoMention;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Mention{" +
                "mentionId=" + mentionId +
                ", userMentioned='" + userMentioned + '\'' +
                ", userWhoMention='" + userWhoMention + '\'' +
                ", date=" + date +
                '}';
    }
}
