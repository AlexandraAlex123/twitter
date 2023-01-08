package org.example.classService;

import org.example.objectClassAndRepository.model.Follow;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.repository.TwitterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TwitterUserService {

    private TwitterUserRepository twitterUserRepository;

    @Autowired
    public TwitterUserService(TwitterUserRepository twitterUserRepository) {
        this.twitterUserRepository = twitterUserRepository;
    }

    public String login(String username, String password) {
        if (twitterUserRepository.matchLogin(username, password)) {
            return "Login successful!";
        }
        return "The username and password doesn't match";
    }

    public String saveFollow(String usernameToFollow, String usernameWhoFollowYou) {
        TwitterUser twitterUser = twitterUserRepository.findTwitterUserByUsername(usernameToFollow);
        Follow follow = new Follow(usernameWhoFollowYou, new Timestamp(System.currentTimeMillis()));
        List<Follow> follows = twitterUser.getFollows();
        follows.add(follow);
        twitterUser.setFollows(follows);
        twitterUserRepository.save(twitterUser);
        return usernameWhoFollowYou + " followed you";
    }
}
