package org.example.twitterApp.objectClassAndRepository.repository;

import org.example.twitterApp.objectClassAndRepository.model.mention.Mention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentionReplyRepository extends JpaRepository<Mention, Long> {
}
