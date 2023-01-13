package org.example.classService.validation;

import org.example.objectClassAndRepository.model.RegisterUser;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.repository.PostRepository;
import org.example.objectClassAndRepository.repository.RegisterUserRepository;
import org.example.objectClassAndRepository.repository.TwitterUserRepository;

public class ValidateValue extends CheckValue {

    public boolean usernameExist(String username, TwitterUserRepository tUr) {
        return tUr.findById(username).isPresent();
    }

    public boolean usernameExist(String username, RegisterUserRepository rUr) {
        return rUr.findUserByUsername(username) != null;
    }

    public boolean usernameExist(String username, PostRepository pR) {
        return pR.findAllByUsername(username) != null;
    }

    public boolean emailExist(String email, RegisterUserRepository rUr) {
        return rUr.findUserByEmail(email) != null;
    }

    public boolean isNotNull(RegisterUser ru) {
        return !ru.getFirstName().isEmpty() && !ru.getLastName().isEmpty() && !ru.getEmail().isEmpty();
    }

    public boolean isNotNull(TwitterUser tu) {
        return !tu.getUsername().isEmpty() && !tu.getPassword().isEmpty();
    }

    public boolean validUser(RegisterUser ru) {
        return checkStringRu(ru.getFirstName()) && checkStringRu(ru.getLastName()) && checkStringE(ru.getEmail());
    }

    public boolean validUser(TwitterUser tu) {
        return checkStringTu(tu.getUsername()) && checkStringTu(tu.getPassword());
    }

    public boolean validUsername(String username, PostRepository pR) {
        return !username.isEmpty() && checkStringTu(username) && usernameExist(username, pR);
    }

    public boolean validUsername(String username, TwitterUserRepository tUr) {
        return !username.isEmpty() && checkStringTu(username) && usernameExist(username, tUr);
    }
}
