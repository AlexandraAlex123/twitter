package org.example.classService;

import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.model.User;
import org.example.objectClassAndRepository.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/user")
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private TwitterUser twitterUser;
    @Autowired
    public UserService(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
    }

    @PostMapping(path = "/registerUser")
    public String registerUser(@RequestBody User user) {
        userRepository.save(user);
        return "Saved";
    }

    @PostMapping(path = "/createAccount")
    public String createAccount(@RequestParam String email, @RequestBody TwitterUser twitterUser) {
        User user = userRepository.findUserByEmail(email);
        user.setTwitterUser(twitterUser);
        userRepository.save(user);
        return "Created";
    }

    @PostMapping(path = "/saveFollow")
    public String saveFollow(@RequestParam String usernameToFollow, @RequestParam String usernameWhoFollow) {
        TwitterUser twitterUser
        return "Created";
    }
}
