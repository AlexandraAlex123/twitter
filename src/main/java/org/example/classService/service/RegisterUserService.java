package org.example.classService.service;

import org.example.classService.service.classDtO.RegisterUserDtO;
import org.example.classService.validation.DtOService;
import org.example.objectClassAndRepository.model.RegisterUser;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.repository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class RegisterUserService extends DtOService {

    @Autowired
    private final RegisterUserRepository rUr;

    public RegisterUserService(RegisterUserRepository rUr) {
        this.rUr = rUr;
    }


    public String singUp(RegisterUser ru) {
        if (isNotNull(ru)) {
            if (validUser(ru)) {
                if (!emailExist(ru.getEmail(), rUr)) {
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
            if (validUser(tu)) {
                if (emailExist(email, rUr)) {
                    RegisterUser ru = rUr.findUserByEmail(email);
                    if (!usernameExist(tu.getUsername(), rUr)) {
                        tu.setCreateDate(new Timestamp(System.currentTimeMillis()));
                        ru.setTwitterUser(tu);
                        rUr.save(ru);
                        return "Account created";
                    } else {
                        return "Username not available";
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
        Set<RegisterUser> ruSFind = new TreeSet<>();
        if (!keyWord.isEmpty() && !keyWord.equals(" ")) {
            List<RegisterUser> ruS = rUr.findAll();
            for (RegisterUser user : ruS) {
                if ((user.getFirstName().toUpperCase() + " " + user.getLastName().toUpperCase()).
                        contains(keyWord.toUpperCase())) {
                    ruSFind.add(user);
                }
            }
        }
        return getListOfUserDtO(ruSFind);
    }


}
