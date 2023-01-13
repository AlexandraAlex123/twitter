package org.example.classControler;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.example.classService.service.classDtO.PostDtO;
import org.example.classService.service.classDtO.TwitterUserDtO;
import org.example.classService.service.TwitterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Set<TwitterUserDtO> searchTwitterAccount(@RequestParam String keyWord) {
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
    public Set<PostDtO> getFollowsPosts (@RequestParam String username){
        return tUs.getFollowsPosts(username);
    }
}
