package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.controlAndService.service.factory.ConvertDTO;
import org.example.twitterApp.controlAndService.service.factory.ValidateFactory;
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
                    ConvertDTO uFi = factory("tu");
                    TwitterUserDtO tuDtO = (TwitterUserDtO) uFi.convertToDTO(tu);
                    tuSFind.add(tuDtO);
                }
            }
        }
        return tuSFind;
    }


    public String addAPost(String userWhoPost, String message) {
        if (!userWhoPost.isEmpty() && !message.isEmpty()) {
            if (checkStringTu(userWhoPost) && !message.equals(" ")) {
                if (usernameExists(userWhoPost)) {
                    TwitterUser tuWhoPost = tUr.findByUsername(userWhoPost);
                    createAndSavePost(message, tuWhoPost);
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
                        createAndSaveFollow(userFollow, getUserByUsername(userFollowing));
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

    public boolean alreadyFollow(String userFollowing, String userFollow) {
        TwitterUser tuFollowing = getUserByUsername(userFollowing);
        if (!tuFollowing.getFollows().isEmpty()) {
            return tuFollowing.getFollows().get(0).getUserFollow().equals(userFollow);
        }
        return false;
    }

}
