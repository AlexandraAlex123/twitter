package org.example.twitterApp.objectClassAndRepository.repository;

import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    @Query(value = "SELECT f FROM Follow f WHERE user_followed = :username")
    Follow findFollowByUsernameFollow(@Param("username") String username);

}
