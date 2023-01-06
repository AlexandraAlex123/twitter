package org.example.objectClassAndRepository.repository;

import org.example.objectClassAndRepository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM User u WHERE u.email = :email", nativeQuery = true)
    User findUserByEmail(@Param("email") String email);

}
