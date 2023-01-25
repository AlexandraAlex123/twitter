package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.controlAndService.service.factory.ConvertDTO;
import org.example.twitterApp.controlAndService.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;
import org.example.twitterApp.objectClassAndRepository.model.Role;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.like.modelDTO.RegisterUserDtO;
import org.example.twitterApp.objectClassAndRepository.repository.RegisterUserRepository;
import org.example.twitterApp.objectClassAndRepository.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Objects.isNull;

@Service
public class RegisterUserService extends ValidateFactory {

    @Autowired
    private PasswordEncoder pe;

    @Autowired
    private RegisterUserRepository rUr;

    @Autowired
    private RoleRepository roleR;


    public String singUp(RegisterUser ru) {
        if (valid(ru)) {
            if (!emailExists(ru.getEmail())) {
                ru.setCreateDate(new Timestamp(System.currentTimeMillis()));
                rUr.save(ru);
                return "User registered";
            } else {
                return "Email already exist";
            }
        }
        return "Invalid command";
    }

    public String createAccount(String email, TwitterUser tu) {
        if (valid(tu)) {
            if (emailExists(email)) {
                RegisterUser ru = rUr.findUserByEmail(email);
                if (ru.getAccount() == null) {
                    if (!usernameExists(tu.getUsername())) {
                        tu.setCreateDate(new Timestamp(System.currentTimeMillis()));
                        tu.setPassword(pe.encode((tu.getPassword())));
                        Role role = roleR.findByName("USER");
                        tu.setRoles(Collections.singletonList(role));
                        ru.setAccount(tu);
                        return "Account created";
                    } else {
                        return "Username not available";
                    }
                } else {
                    return "Email already confirmed";
                }
            } else {
                return "Email not found";
            }
        }
        return "Invalid command";
    }

    public Set<RegisterUserDtO> searchUser(String keyWord) {
        Set<RegisterUserDtO> ruSFind = new TreeSet<>();
        if (!keyWord.equals(" ")) {
            //TODO - read aboun n + 1 JPA problem and fix here
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
        if (ruExists(id)) {
            rUr.deleteById(id);
            return "User deleted";
        }
        return "User not found";
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
