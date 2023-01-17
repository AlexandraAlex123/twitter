package org.example.twitterApp.objectClassAndRepository.model;

import javax.persistence.*;
import java.sql.Timestamp;

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
    private Timestamp createDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account", referencedColumnName = "username")
    private TwitterUser account;


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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public TwitterUser getAccount() {
        return account;
    }

    public void setAccount(TwitterUser account) {
        this.account = account;
    }

    @Override
    public int compareTo(RegisterUser o) {
        return this.createDate.compareTo(o.getCreateDate());
    }

    @Override
    public String toString() {
        return "RegisterUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", twitterUser=" + account +
                '}';
    }
}
