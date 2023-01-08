package org.example.classControler;

import org.example.classService.RegisterUserService;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.model.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterUserController {

    @Autowired
    private RegisterUserService registerUserService;

    public RegisterUserController(RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }

    @PostMapping(path = "/registerUser")
    public String registerUser(@RequestBody RegisterUser registerUser) {
        return registerUserService.registerUser(registerUser);

    }

    @PostMapping(path = "/createAccount")
    public String createAccount(@RequestParam String email, @RequestBody TwitterUser twitterUser) {
        return registerUserService.createAccount(email, twitterUser);
    }


}
