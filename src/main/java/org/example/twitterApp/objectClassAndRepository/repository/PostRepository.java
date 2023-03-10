package org.example.twitterApp.objectClassAndRepository.repository;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT p " +
                   "FROM Post p " +
                   "WHERE user_who_post = :username")
    List<Post> findAllByUsername(@Param("username") String username);

    @Query(value = "SELECT p FROM Post p WHERE p.id = :id")
    Post findPostById(@Param("id") Long id);

    @Query(value = "SELECT p " +
            "FROM Post p " +
            "WHERE user_who_post = :username and not_public = 0")
    List<Post> findAllByUsernamePublic(@Param("username") String username);
}
