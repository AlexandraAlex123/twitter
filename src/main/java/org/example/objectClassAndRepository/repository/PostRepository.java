package org.example.objectClassAndRepository.repository;

import org.example.objectClassAndRepository.model.RegisterUser;
import org.example.objectClassAndRepository.model.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT p FROM Post p WHERE user_who_post = :username")
    Set<Post> findAllByUsername(@Param("username") String username);

    @Query(value = "SELECT p " +
            "FROM Post p WHERE (date_of_posting " +
            "BETWEEN :timestamp and :timestamp2)")
    Set<Post> findPostsBetweenDates(@Param("timestamp") Timestamp timestamp, @Param("timestamp2") Timestamp timestamp2);


}
