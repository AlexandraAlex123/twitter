package org.example.objectClassAndRepository.repository;

import org.example.objectClassAndRepository.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {


}
