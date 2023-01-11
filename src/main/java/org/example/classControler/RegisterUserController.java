package org.example.classControler;

import org.example.classService.service.classDtO.RegisterUserDtO;
import org.example.classService.service.RegisterUserService;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.model.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
