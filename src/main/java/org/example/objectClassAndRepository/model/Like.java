package org.example.objectClassAndRepository.model;

import javax.persistence.*;
import java.sql.Timestamp;

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
    private Timestamp createDate;

    public Like(String whoGivesLike, Timestamp createDate) {
        this.whoGivesLike = whoGivesLike;
        this.createDate = createDate;
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", whoGivesLike='" + whoGivesLike + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
