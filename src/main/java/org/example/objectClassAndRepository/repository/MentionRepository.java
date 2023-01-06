package org.example.objectClassAndRepository.repository;

import org.example.objectClassAndRepository.model.Mention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentionRepository extends JpaRepository<Mention, Long> {
}
