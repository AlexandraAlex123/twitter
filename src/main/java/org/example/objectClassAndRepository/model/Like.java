package org.example.objectClassAndRepository.model;

import javax.persistence.*;

@Entity
@Table(name = "likePost")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "likeId")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private TwitterUser twitterUser;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TwitterUser getTwitterUser() {
        return twitterUser;
    }

    public void setTwitterUser(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", twitterUser=" + twitterUser +
                '}';
    }
}
