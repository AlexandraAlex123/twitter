package org.example.classes;

import javax.persistence.*;

@Entity
public class Mention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private User user;

    @OneToOne
    private Post post;

    public Mention(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public Mention() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Mention{" +
                "id=" + id +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}
