package org.example.classService.service;

import org.example.classService.CheckValue;
import org.example.classService.service.classDtO.RegisterUserDtO;
import org.example.objectClassAndRepository.model.RegisterUser;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.repository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;

@Service
@Transactional
public class RegisterUserService extends CheckValue {

    private final CheckValue cV = new CheckValue();
    @Autowired
    private final RegisterUserRepository rUr;

    public RegisterUserService(RegisterUserRepository rUr) {
        this.rUr = rUr;
    }


    public String singUp(RegisterUser ru) {

        if (cV.ruIsNotNull(ru)) {

            if (cV.validRu(ru)) {

                if (!emailExist(ru.getEmail())) {
                    ru.setDate(new Timestamp(System.currentTimeMillis()));
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

        if (cV.tuIsNotNull(tu) && !email.isEmpty()) {

            if (cV.validTu(tu)) {

                if (emailExist(email)) {

                    RegisterUser ru = rUr.findUserByEmail(email);
                    if (!cV.usernameExist(tu.getUsername(), rUr)) {
                        tu.setDate(new Timestamp(System.currentTimeMillis()));
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


    public Set<RegisterUserDtO> getListOfUserDtO(Set<RegisterUser> ruS) {
        Set<RegisterUserDtO> ruDTOS = new TreeSet<>();
        for (RegisterUser ru : ruS) {
            RegisterUserDtO ruDTO;
            if (ru.getTwitterUser() != null) {
                ruDTO = new RegisterUserDtO(ru.getFirstName(), ru.getLastName(), ru.getTwitterUser().getUsername(), cV.getLocalDate(ru.getDate()) );
            } else {
                ruDTO = new RegisterUserDtO(ru.getFirstName(), ru.getLastName(), "Not created", cV.getLocalDate(ru.getDate()));
            }
            ruDTOS.add(ruDTO);
        }
        return ruDTOS;
    }


    public boolean emailExist(String email) {
        return rUr.findUserByEmail(email) != null;
    }


}
