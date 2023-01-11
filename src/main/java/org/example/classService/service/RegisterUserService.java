package org.example.classService.service;

import org.example.classService.CheckValue;
import org.example.classService.service.classDtO.RegisterUserDtO;
import org.example.objectClassAndRepository.model.RegisterUser;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.repository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

        if (ruIsNotNull(ru)) {

            if (cV.checkStringRu(ru.getFirstName()) && cV.checkStringRu(ru.getLastName()) && cV.checkStringE(ru.getEmail())) {

                if (!emailExist(ru.getEmail())) {
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

        if (tuIsNotNull(tu) && email != null) {

            if (cV.checkStringE(email) && cV.checkStringTu(tu.getUsername()) && cV.checkStringTu(tu.getPassword())) {

                RegisterUser ru = rUr.findUserByEmail(email);
                if (!usernameExist(tu.getUsername())) {
                    ru.setTwitterUser(tu);
                    rUr.save(ru);
                    return "Account created";
                } else {
                    return "Email doesn't exist";
                }
            }else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }


    public Set<RegisterUserDtO> searchUser(String keyWord) {

        Set<RegisterUserDtO> ruDTOSFind = new TreeSet<>();

        if (!keyWord.isEmpty() && !keyWord.equals(" ")) {

            List<RegisterUserDtO> ruDTOS = getListOfUserDtO();
            for (RegisterUserDtO user : ruDTOS) {
                if ((user.getFirstName().toUpperCase() + " " + user.getLastName().toUpperCase()).
                        contains(keyWord.toUpperCase())) {
                    ruDTOSFind.add(user);
                }
            }
        }
        return ruDTOSFind;
    }


    public List<RegisterUserDtO> getListOfUserDtO() {
        List<RegisterUser> ruS = rUr.findAll();
        List<RegisterUserDtO> ruDTOS = new ArrayList<>();
        for (RegisterUser ru : ruS) {
            RegisterUserDtO ruDTO;
            if (ru.getTwitterUser() != null) {
                ruDTO = new RegisterUserDtO(ru.getFirstName(), ru.getLastName(), ru.getTwitterUser().getUsername());
            } else {
                ruDTO = new RegisterUserDtO(ru.getFirstName(), ru.getLastName(), "Not created");
            }
            ruDTOS.add(ruDTO);
        }
        return ruDTOS;
    }

    public boolean ruIsNotNull(RegisterUser ru) {
        return !ru.getFirstName().isEmpty() || !ru.getLastName().isEmpty();
    }

    public boolean tuIsNotNull(TwitterUser tu) {
        return !tu.getUsername().isEmpty() || !tu.getPassword().isEmpty();
    }

    public boolean usernameExist(String username) {
        return rUr.findUserByUsername(username) != null;
    }

    public boolean emailExist(String email) {
        return rUr.findUserByEmail(email) != null;
    }


}
