package org.example.classControler;


import org.example.classService.TwitterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TwitterUserController {
    @Autowired
    private TwitterUserService twitterUserService;

    @GetMapping(path = "/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return twitterUserService.login(username, password);
    }

    @PostMapping(path = "/saveFollow")
    public String saveFollow(@RequestParam String usernameToFollow, @RequestParam String usernameWhoFollowYou) {
        return twitterUserService.saveFollow(usernameToFollow, usernameWhoFollowYou);
    }
}
