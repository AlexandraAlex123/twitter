package org.example.twitterApp.objectClassAndRepository.repository;

import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {

    @Query(value = "SELECT ru FROM RegisterUser ru WHERE ru.email = :email")
    RegisterUser findUserByEmail(@Param("email") String email);

    @Query(value = "SELECT ru FROM RegisterUser ru WHERE ru.account.username = :username")
    RegisterUser findUserByUsername(@Param("username") String username);


}
