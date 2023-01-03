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
}
