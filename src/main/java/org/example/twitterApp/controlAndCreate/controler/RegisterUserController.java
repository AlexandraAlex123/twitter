package org.example.twitterApp.controlAndCreate.controler;

import org.example.twitterApp.objectClassAndRepository.modelDTO.RegisterUserDtO;
import org.example.twitterApp.controlAndCreate.service.RegisterUserService;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class RegisterUserController {

    @Autowired
    private RegisterUserService rUs;

    @PostMapping(path = "/singUp")
    public String singUp(@Valid @RequestBody RegisterUser ru) {
        return rUs.singUp(ru);
    }

    @PostMapping(path = "/createAccount")
    public String createAccount(@RequestParam String email, @RequestBody TwitterUser tu) {
        return rUs.createAccount(email, tu);
    }

    @GetMapping(path = "/searchUser")
    public Set<RegisterUserDtO> searchUser(@RequestParam String keyWord) {
        return rUs.searchUser(keyWord);
    }

}
