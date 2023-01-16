package org.example.twitterApp.controlAndCreate.service;

import org.example.twitterApp.controlAndCreate.service.factory.Factory;
import org.example.twitterApp.controlAndCreate.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.modelDTO.TwitterUserDtO;
import org.example.twitterApp.objectClassAndRepository.repository.TwitterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class TwitterUserService extends ValidateFactory {

    @Autowired
    private TwitterUserRepository tUr;


    public String login(String username, String password) {
        if (!username.isEmpty() && !password.isEmpty()) {
            if (checkStringTu(username) && checkStringTu(password)) {
                TwitterUser tu = tUr.findAccountByUsernameAndPassword(username, password);
                if (tu != null) {
                    tu.setLastLogin(new Timestamp(System.currentTimeMillis()));
                    tUr.save(tu);
                    return "Login successful!";
                } else {
                    return "Username and password doesn't match";
                }
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }


    public Set<TwitterUserDtO> searchTwitterAccount(String keyWord) {
        Set<TwitterUserDtO> tuSFind = new TreeSet<>();
        if (!keyWord.isEmpty() && !keyWord.equals(" ")) {
            List<TwitterUser> tuS = tUr.findAll();
            for (TwitterUser tu : tuS) {
                if (tu.getUsername().toUpperCase().contains(keyWord.toUpperCase())) {
                    Factory uFi = create("tu");
                    TwitterUserDtO tuDtO = (TwitterUserDtO) uFi.convertToDTO(tu);
                    tuSFind.add(tuDtO);
                }
            }
        }
        return tuSFind;
    }


    public String addAPost(String username, String message) {
        if (!username.isEmpty() && !message.isEmpty()) {
            if (checkStringTu(username) && !message.equals(" ")) {
                if (usernameExists(username)) {
                    TwitterUser tu = tUr.findByUsername(username);
                    createAndSavePost(tu, message);
                    return "Post uploaded";
                } else {
                    return "User not found";
                }
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }


    public String whoYouFollow(String userFollowing, String userFollow) {
        if (!userFollowing.isEmpty() && !userFollow.isEmpty()) {
            if (checkStringTu(userFollowing) && checkStringTu(userFollow)) {
                if (usernameExists(userFollowing) && usernameExists(userFollow)) {
                    if (!alreadyFollow(userFollowing, userFollow)) {
                        createAndSaveFollow(getUserByUsername(userFollowing), getUserByUsername(userFollow));
                        return "You fallow " + userFollow;
                    } else {
                        return "You already follow " + userFollow;
                    }
                } else {
                    return "User not found";
                }
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }


    public TwitterUser getUserByUsername(String username) {
        return tUr.findByUsername(username);
    }

    public boolean usernameExists(String username) {
        return tUr.findByUsername(username) != null;
    }

    public boolean validUsername(String username) {
        return !username.isEmpty() && checkStringTu(username) && usernameExists(username);
    }

    private boolean alreadyFollow(String userFollowing, String userFollow) {
        TwitterUser tuFollowing = getUserByUsername(userFollowing);
        return tuFollowing.getFollows().get(0).getUserFollow().getUsername().equals(userFollow);
    }
}
