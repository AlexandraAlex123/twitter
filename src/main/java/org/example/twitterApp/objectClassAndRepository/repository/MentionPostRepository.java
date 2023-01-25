package org.example.twitterApp.objectClassAndRepository.repository;

import org.example.twitterApp.objectClassAndRepository.model.mention.MentionPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentionPostRepository extends JpaRepository<MentionPost, Long> {

    @Query(value = "SELECT mp " +
            "FROM MentionPost mp " +
            "WHERE user_mention = :username")
    List<MentionPost> findAllMentionPostByUsername(@Param("username") String username);


    @Query(value = "SELECT mp FROM MentionPost mp WHERE mp.id = :id")
    MentionPost findMentionPostById(@Param("id") Long id);
}
