package org.example.objectClassAndRepository.repository;

import org.example.objectClassAndRepository.model.TwitterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterUserRepository extends JpaRepository<TwitterUser, String> {

    @Query(value = "SELECT * FROM twitter_user tu WHERE tu.username = :username", nativeQuery = true)
    TwitterUser findTwitterUserByUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM TwitterUser tu WHERE tu.username = :username and tu.password = :password")
    boolean matchLogin(@Param("username") String username, @Param("password") String password);
}
