package org.example.twitterApp.controlAndService.controler;

import org.example.twitterApp.controlAndService.service.RegisterUserService;
import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.modelDTO.RegisterUserDtO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
public class RegisterUserController {

    @Autowired
    private RegisterUserService rUs;


    @PostMapping(path = "/singUp")
    public String singUp(@RequestBody @NotNull RegisterUser ru) {
        return rUs.singUp(ru);
    }

    @PutMapping(path = "/createAccount")
    public String createAccount(@RequestParam @NotNull String email, @RequestBody @NotNull TwitterUser tu) {
        return rUs.createAccount(email, tu);
    }

    @GetMapping(path = "/searchUser")
    public Set<RegisterUserDtO> searchUser(@RequestParam @NotNull String keyWord) {
        return rUs.searchUser(keyWord);
    }

    @DeleteMapping(path = "/deleteUser")
    public String deleteUser(@PathVariable @NotNull Long id) {
        return rUs.deleteRegisterUser(id);
    }

}
