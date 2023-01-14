package org.example.twitterApp.controler.service.serviceClass;

import org.example.twitterApp.controler.service.factory.ServiceFactory;
import org.example.twitterApp.controler.service.factory.classFactory.FactoryInterface;
import org.example.twitterApp.objectClassAndRepository.classDtO.RegisterUserDtO;
import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.repository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class RegisterUserService extends ServiceFactory {

    @Autowired
    private final RegisterUserRepository rUr;

    public RegisterUserService(RegisterUserRepository rUr) {
        this.rUr = rUr;
    }


    public String singUp(RegisterUser ru) {
        if (isNotNull(ru)) {
            if (validUser(ru)) {
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
            if (validUser(tu)) {
                if (emailExists(email)) {
                    RegisterUser ru = rUr.findUserByEmail(email);
                    if (!usernameExists(tu.getUsername())) {
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
        Set<RegisterUserDtO> ruSFind = new TreeSet<>();
        if (!keyWord.isEmpty() && !keyWord.equals(" ")) {
            List<RegisterUser> ruS = rUr.findAll();
            for (RegisterUser user : ruS) {
                if ((user.getFirstName().toUpperCase() + " " + user.getLastName().toUpperCase()).
                        contains(keyWord.toUpperCase())) {
                    FactoryInterface uFi = create("ru");
                    RegisterUserDtO ruDtO = (RegisterUserDtO) uFi.convertToDTO(user);
                    ruSFind.add(ruDtO);
                }
            }
        }
        return ruSFind;
    }


}
