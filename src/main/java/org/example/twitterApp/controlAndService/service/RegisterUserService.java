package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.controlAndService.service.factory.ConvertDTO;
import org.example.twitterApp.controlAndService.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.modelDTO.RegisterUserDtO;
import org.example.twitterApp.objectClassAndRepository.repository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Objects.isNull;

@Service
@Transactional
public class RegisterUserService extends ValidateFactory {

    @Autowired
    private RegisterUserRepository rUr;


    public String singUp(RegisterUser ru) {
        if (isNotNull(ru)) {
            if (valid(ru)) {
                if (!emailExists(ru.getEmail())) {
                    ru.setCreateDate(new Timestamp(System.currentTimeMillis()));
                    rUr.save(ru);
                    return "User registered";
                } else {
                    return "Email already exist";
                }
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }

    public String createAccount(String email, TwitterUser tu) {
        if (isNotNull(tu) && !email.isEmpty()) {
            if (valid(tu)) {
                if (emailExists(email)) {
                    RegisterUser ru = rUr.findUserByEmail(email);
                    if (ru.getAccount() == null) {
                        if (!usernameExists(tu.getUsername())) {
                            tu.setCreateDate(new Timestamp(System.currentTimeMillis()));
                            ru.setAccount(tu);
                            return "Account created";
                        } else {
                            return "Username not available";
                        }
                    }else {
                        return "Email already confirmed";
                    }
                } else {
                    return "User not found";
                }
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }

    public Set<RegisterUserDtO> searchUser(String keyWord) {
        Set<RegisterUserDtO> ruSFind = new TreeSet<>();
        if (!keyWord.isEmpty() && !keyWord.equals(" ")) {
            List<RegisterUser> ruS = rUr.findAll();
            for (RegisterUser user : ruS) {
                if ((user.getFirstName().toUpperCase() + " " + user.getLastName().toUpperCase()).
                        contains(keyWord.toUpperCase())) {
                    ConvertDTO uFi = factory("ru");
                    RegisterUserDtO ruDtO = (RegisterUserDtO) uFi.convertToDTO(user);
                    ruSFind.add(ruDtO);
                }
            }
        }
        return ruSFind;
    }

    public String deleteRegisterUser(Long id) {
        if (id != null) {
            if (ruExists(id)) {
                rUr.deleteById(id);
                return "User deleted";
            } else {
                return "User not found";
            }
        }
        return "Null parameter";
    }

    public boolean usernameExists(String username) {
        return !isNull(rUr.findUserByUsername(username));
    }

    public boolean emailExists(String email) {
        return rUr.findUserByEmail(email) != null;
    }

    public boolean ruExists(Long id) {
        return rUr.findById(id).isPresent();
    }

}
