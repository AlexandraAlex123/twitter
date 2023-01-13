package org.example.classService.service;

import org.example.classService.service.classDtO.PostDtO;
import org.example.classService.service.classDtO.TwitterUserDtO;
import org.example.classService.validation.DtOService;
import org.example.objectClassAndRepository.model.Follow;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.repository.TwitterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class TwitterUserService extends DtOService {

    private PostService ps;
    private TwitterUserRepository tUr;

    @Autowired
    public TwitterUserService(TwitterUserRepository tUr) {
        this.tUr = tUr;
    }

    public TwitterUserService() {
    }

    public String login(String username, String password) {
        if (!username.isEmpty() && !password.isEmpty()) {
            if (checkStringTu(username) && checkStringTu(password)) {
                if (tUr.matchLogin(username, password) != null) {
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
        Set<TwitterUser> tuSFind = new TreeSet<>();
        if (!keyWord.isEmpty() && !keyWord.equals(" ")) {
            List<TwitterUser> tuS = tUr.findAll();
            for (TwitterUser tu : tuS) {
                if (tu.getUsername().toUpperCase().contains(keyWord.toUpperCase())) {
                    tuSFind.add(tu);
                }
            }
        }
        return getAllTwitterUserDTO(tuSFind);
    }


    public String addAPost(String username, String message) {
        if (!username.isEmpty() && !message.isEmpty()) {
            if (checkStringTu(username) && !message.equals(" ")) {
                if (usernameExist(username, tUr)) {
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


    public String whoYouFollow(String usernameWhoFollow, String usernameFollow) {
        if (!usernameWhoFollow.isEmpty() && !usernameFollow.isEmpty()) {
            if (checkStringTu(usernameWhoFollow) && checkStringTu(usernameFollow)) {
                if (usernameExist(usernameWhoFollow, tUr) && usernameExist(usernameFollow, tUr)) {
                    TwitterUser tu = tUr.findByUsername(usernameWhoFollow);
                    createAndSaveFollow(tu, usernameFollow);
                    return "You fallow " + usernameFollow;
                } else {
                    return "User not found";
                }
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }

    public Set<PostDtO> getFollowsPosts(String username) {
        Set<PostDtO> allFollowPost = new TreeSet<>();
        if (validUsername(username, tUr)) {
            TwitterUser tu = tUr.findByUsername(username);
            Set<Follow> follows = tu.getFollows();
            for (Follow f : follows) {
                String follow = f.getUsernameFollowed();
                Set<PostDtO> followPosts = ps.searchUserPosts(username);
                allFollowPost.addAll(followPosts);
            }
            return allFollowPost;
        }
        return allFollowPost;
    }

}
