package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.controlAndService.service.factory.ConvertDTO;
import org.example.twitterApp.controlAndService.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.modelDTO.TwitterUserDtO;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.repository.TwitterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class TwitterUserService extends ValidateFactory {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager am;

    @Autowired
    private TwitterUserRepository tUr;


    public String login(String username, String password) {
        if (checkStringTu(username) && checkStringTu(password)) {
            TwitterUser tu = tUr.findByUsername(username);
            if (tu != null) {
                Authentication authentication = am.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                tu.setLastLogin(new Timestamp(System.currentTimeMillis()));
                return "Login successful!";
            } else {
                return "User not found";
            }
        }
        return "Invalid command";
    }

    public Set<TwitterUserDtO> searchTwitterAccount(String keyWord) {
        Set<TwitterUserDtO> tuSFind = new TreeSet<>();
        if (!keyWord.equals(" ")) {
            //TODO -- n + 1
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

    public String whoYouFollow(String userFollowing, String userFollow) {
        if (checkStringTu(userFollowing) && checkStringTu(userFollow)) {
            if (usernameExists(userFollowing) && usernameExists(userFollow)) {
                if (!alreadyFollow(getUserByUsername(userFollowing), userFollow)) {
                    createAndSaveFollow(userFollow, getUserByUsername(userFollowing));
                    return "You fallow " + userFollow;
                } else {
                    return "You already follow " + userFollow;
                }
            } else {
                return "User not found";
            }
        }
        return "Invalid command";

    }

    public String addAPost(String userWhoPost, String message) {
        if (checkStringTu(userWhoPost) && !message.equals(" ")) {
            if (usernameExists(userWhoPost)) {
                TwitterUser tuWhoPost = getUserByUsername(userWhoPost);
                Post post = createAndSavePost(message, tuWhoPost);
                if (message.contains("@")) {
                    return addMentionPost(tuWhoPost, post);
                } else {
                    return "Post uploaded";
                }
            } else {
                return "User not found";
            }
        }
        return "Invalid command";
    }

    public String addMentionPost(TwitterUser tuWhoPost, Post post) {
        if (tuWhoPost.getPosts() != null) {
            List<Follow> follows = tuWhoPost.getFollows();
            List<String> followMentionS = new ArrayList<>();
            for (Follow f : follows) {
                if (post.getMessage().contains("@" + f.getUserFollow())) {
                    TwitterUser tuMention = getUserByUsername(f.getUserFollow());
                    createAndSaveMentionPost(tuMention, post);
                    followMentionS.add(f.getUserFollow());
                }
            }
            return "Post uploaded. You mention in this post " + followMentionS;
        }
        return "Comment add";
    }

    public String deleteTwitterUser(String username) {
        if (checkStringTu(username)) {
            if (usernameExists(username)) {
                tUr.deleteById(username);
                return "Account deleted";
            } else {
                return "Account not found";
            }
        }
        return "Invalid command";
    }

    public TwitterUser getUserByUsername(String username) {
        return tUr.findByUsername(username);
    }

    public boolean usernameExists(String username) {
        return tUr.findByUsername(username) != null;
    }

    public boolean validUsername(String username) {
        return username != null && checkStringTu(username) && usernameExists(username);
    }

}
