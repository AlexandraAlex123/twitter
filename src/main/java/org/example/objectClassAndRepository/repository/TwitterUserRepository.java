package org.example.objectClassAndRepository.repository;

import org.example.objectClassAndRepository.model.TwitterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TwitterUserRepository extends JpaRepository<TwitterUser, String> {

    TwitterUser findByUsername(String username);

    @Query(value = "SELECT tu FROM TwitterUser tu WHERE tu.username = :username and tu.password = :password")
    TwitterUser matchLogin(@Param("username") String username, @Param("password") String password);

}
