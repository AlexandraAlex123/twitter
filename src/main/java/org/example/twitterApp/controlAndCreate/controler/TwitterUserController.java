package org.example.twitterApp.controlAndCreate.controler;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.twitterApp.controlAndCreate.service.TwitterUserService;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class TwitterUserController {

    @Autowired
    private TwitterUserService tUs;

    @GetMapping(path = "/login")
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

    @GetMapping(path = "/getFeeds")
    public Set<PostDTOFeed> getFollowsPosts(@RequestParam String username) {
        return tUs.getFollowsPosts(username);
    }
}
