package org.example.twitterApp.objectClassAndRepository.model.like;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @Column(name = "create_date")
    private Timestamp createDate;

    @ManyToOne
    @JoinColumn(name = "who_gives_like")
    private TwitterUser whoGivesLike;

    public Like() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TwitterUser getWhoGivesLike() {
        return whoGivesLike;
    }

    public void setWhoGivesLike(TwitterUser whoGivesLike) {
        this.whoGivesLike = whoGivesLike;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", createDate=" + createDate +
                ", whoGivesLike=" + whoGivesLike;
    }
}
