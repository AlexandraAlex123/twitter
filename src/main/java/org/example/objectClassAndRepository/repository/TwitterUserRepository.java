package org.example.objectClassAndRepository.repository;

import org.example.objectClassAndRepository.model.TwitterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterUserRepository extends JpaRepository<TwitterUser, String> {
}
