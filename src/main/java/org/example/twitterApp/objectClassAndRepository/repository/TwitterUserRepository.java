package org.example.twitterApp.objectClassAndRepository.repository;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterUserRepository extends JpaRepository<TwitterUser, String> {

    @Query(value = "SELECT tu FROM TwitterUser tu WHERE tu.username = :username")
    TwitterUser findByUsername(@Param("username") String username);

    @Query(value = "SELECT tu FROM TwitterUser tu WHERE tu.username = :username and tu.password = :password")
    TwitterUser findAccountByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
