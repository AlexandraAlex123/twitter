package org.example.twitterApp.controlAndService.controler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.twitterApp.controlAndService.service.FollowService;
import org.example.twitterApp.controlAndService.service.TwitterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class TwitterUserController {

    @Autowired
    private FollowService fs;

    @Autowired
    private TwitterUserService tUs;


    @PutMapping(path = "/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return tUs.login(username, password);
    }

    @JsonIgnore
    @GetMapping(path = "/searchTwitterAccount")
    public Set<?> searchTwitterAccount(@RequestParam String keyWord) {
        return tUs.searchTwitterAccount(keyWord);
    }

    @PutMapping(path = "/whoYouFollow")
    public String whoYouFollow(@RequestParam String usernameWhoFollow, @RequestParam String usernameFollow) {
        return tUs.whoYouFollow(usernameWhoFollow, usernameFollow);
    }

    @PutMapping(path = "/addAPost")
    public String addAPost(@RequestParam String username, @RequestParam String message) {
        return tUs.addAPost(username, message);
    }

    @DeleteMapping(path = "/deleteAccount")
    public String deleteAccount(@RequestParam String username) {
        return tUs.deleteTwitterUser(username);
    }

    @DeleteMapping(path = "/unfollow")
    public String deleteFollow(@RequestParam Long id) {
        return fs.deleteFollow(id);
    }

}
