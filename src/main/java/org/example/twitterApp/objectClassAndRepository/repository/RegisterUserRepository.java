package org.example.twitterApp.objectClassAndRepository.repository;

import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {

    RegisterUser findUserByEmail(String email);

    @Query(value = "SELECT ru FROM RegisterUser ru WHERE ru.account.username = :username")
    RegisterUser findUserByUsername(@Param("username") String username);


}
