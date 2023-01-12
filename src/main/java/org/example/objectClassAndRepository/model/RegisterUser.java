package org.example.objectClassAndRepository.model;


import org.example.classService.service.classDtO.TwitterUserDtO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
public class RegisterUser implements Comparable<RegisterUser>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 300)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 300)
    private String lastName;

    @Column(name = "email", nullable = false, length = 300, unique = true)
    private String email;

    @Column(name = "create_date")
    private Timestamp date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account")
    private TwitterUser twitterUser;


    public RegisterUser(String firstName, String lastName, String email, Timestamp date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.date = date;
    }

    public RegisterUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public TwitterUser getTwitterUser() {
        return twitterUser;
    }

    public void setTwitterUser(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
    }

    @Override
    public int compareTo(RegisterUser o) {
        return this.email.compareTo(o.getEmail());
    }

    @Override
    public String toString() {
        return "RegisterUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", twitterUser=" + twitterUser +
                '}';
    }
}
