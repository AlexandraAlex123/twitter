package org.example.classService;

import org.example.classes.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/addUser")
    public String addUser(@RequestBody User user) {
        userRepository.save(user);
        return "Saved";
    }
}
