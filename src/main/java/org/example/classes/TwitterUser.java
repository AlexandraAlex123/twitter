package org.example.classes;

import javax.persistence.*;

@Entity
@Table(name = "twitterUser")
public class TwitterUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "userName", nullable = false, length = 300)
    private String userName;

    @Column(name = "password", nullable = false, length = 300)
    private String password;

    public TwitterUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public TwitterUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TwitterUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
