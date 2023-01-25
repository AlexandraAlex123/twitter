package org.example.twitterApp.controlAndService.controler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.twitterApp.controlAndService.service.FollowService;
import org.example.twitterApp.controlAndService.service.TwitterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
@RequestMapping(path = "/user")
public class TwitterUserController {

    @Autowired
    private FollowService fs;

    @Autowired
    private TwitterUserService tus;


    @PutMapping(path = "/login")
    public String login(@RequestParam @NotNull String username, @RequestParam @NotNull String password) {
        return tus.login(username, password);
    }

    @JsonIgnore
    @GetMapping(path = "/searchTwitterAccount")
    public Set<?> searchTwitterAccount(@RequestParam @NotNull String keyWord) {
        return tus.searchTwitterAccount(keyWord);
    }

    @PutMapping(path = "/whoYouFollow")
    public String whoYouFollow(@RequestParam @NotNull String usernameWhoFollow, @RequestParam @NotNull String usernameFollow) {
        return tus.whoYouFollow(usernameWhoFollow, usernameFollow);
    }

    @PutMapping(path = "/addAPost")
    public String addAPost(@RequestParam @NotNull String username, @RequestParam @NotNull String message) {
        return tus.addAPost(username, message);
    }

    @DeleteMapping(path = "/deleteAccount")
    public String deleteAccount(@RequestParam @NotNull String username) {
        return tus.deleteTwitterUser(username);
    }

    @DeleteMapping(path = "/unfollow")
    public String deleteFollow(@PathVariable @NotNull Long id) {
        return fs.deleteFollow(id);
    }

}
