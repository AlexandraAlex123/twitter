package org.example.objectClassAndRepository.repository;

import org.example.objectClassAndRepository.model.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT p FROM Post p WHERE username = :username")
    List<Post> findAll(@Param("username") String username);

//    @Query(value = "SELECT p FROM Post p WHERE (timestamp BETWEEN ")
//    TwitterUser matchLogin(@Param("username") String username, @Param("password") String password);
}
