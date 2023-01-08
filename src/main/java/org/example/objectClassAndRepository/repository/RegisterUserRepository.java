package org.example.objectClassAndRepository.repository;

import org.example.objectClassAndRepository.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {

    @Query(value = "SELECT * FROM RegisterUser ru WHERE ru.email = :email")
    RegisterUser findUserByEmail(@Param("email") String email);



    @Query(value = "SELECT email FROM RegisterUser ru")
    List<String> GetAllEmails();

}
