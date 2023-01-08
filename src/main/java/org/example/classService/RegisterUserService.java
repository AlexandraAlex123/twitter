package org.example.classService;

import org.example.objectClassAndRepository.model.RegisterUser;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.repository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Objects;

@Service
public class RegisterUserService {

    private RegisterUserRepository registerUserRepository;

    @Autowired
    public RegisterUserService(RegisterUserRepository registerUserRepository) {
        this.registerUserRepository = registerUserRepository;
    }


    public String registerUser(RegisterUser registerUser) {
        if (registerUser.getFirstName() != null && registerUser.getLastName() != null && registerUser.getEmail() != null) {
            List<String> emails = registerUserRepository.GetAllEmails();
            for (String email : emails) {
                if (registerUser.getEmail().equals(email)) {
                    return "Email already exist!";
                }
            }
        } else {
            throw new NullPointerException("Complete all the fields.");
        }
        registerUserRepository.save(registerUser);
        return "User registered";
    }

    public String createAccount(String email, TwitterUser twitterUser) {
        RegisterUser registerUser = registerUserRepository.findUserByEmail(email);
        registerUser.setTwitterUser(twitterUser);
        registerUserRepository.save(registerUser);
        return "Account created";
    }



}
