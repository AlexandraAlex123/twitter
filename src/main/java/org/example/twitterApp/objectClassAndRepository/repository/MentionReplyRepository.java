package org.example.twitterApp.objectClassAndRepository.repository;

import org.example.twitterApp.objectClassAndRepository.model.mention.MentionReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentionReplyRepository extends JpaRepository<MentionReply, Long> {

    @Query(value = "SELECT mr " +
            "FROM MentionReply mr " +
            "WHERE user_mention = :username")
    List<MentionReply> findAllMentionReplyByUsername(@Param("username") String username);

    @Query(value = "SELECT mr FROM MentionReply mr WHERE mr.id = :id")
    MentionReply findMentionReplyById(@Param("id") Long id);

}
