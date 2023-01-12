package org.example.objectClassAndRepository.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "like_a_post")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "like_id")
    private Long id;

    @Column(name = "who_gives_like")
    private String whoGivesLike;

    @Column(name = "create_date")
    private Timestamp date;

    public Like(String whoGivesLike, Timestamp date) {
        this.whoGivesLike = whoGivesLike;
        this.date = date;
    }

    public Like() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWhoGivesLike() {
        return whoGivesLike;
    }

    public void setWhoGivesLike(String whoGivesLike) {
        this.whoGivesLike = whoGivesLike;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", whoGivesLike='" + whoGivesLike + '\'' +
                ", date=" + date +
                '}';
    }
}
