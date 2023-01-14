package org.example.twitterApp.controlAndCreate.service;

import org.example.twitterApp.controlAndCreate.service.factory.Factory;
import org.example.twitterApp.controlAndCreate.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOFeed;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDtO;
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
    private FollowService fs;

    @Autowired
    private PostService ps;
    @Autowired
    private RegisterUserService rus;

    @Autowired
    private TwitterUserRepository tUr;


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
                if (rus.usernameExists(username)) {
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
                if (rus.usernameExists(usernameWhoFollow) && rus.usernameExists(usernameFollow)) {
                    TwitterUser tu = tUr.findByUsername(usernameWhoFollow);
                    if(!fs.alreadyFollow(usernameFollow)) {
                        createAndSaveFollow(tu, usernameFollow);
                        return "You fallow " + usernameFollow;
                    }else{
                        return "You already follow " + usernameFollow;
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

    public Set<PostDTOFeed> getFollowsPosts(String username) {
        Set<PostDTOFeed> allFollowPost = new TreeSet<>();
        if (rus.validUsername(username)) {
            TwitterUser tu = tUr.findByUsername(username);
            List<Follow> follows = tu.getFollows();
            for (Follow f : follows) {
                String follow = f.getUsernameFollowed();
                Set<PostDTOFeed> followPosts = ps.searchFeedPosts(follow);
                allFollowPost.addAll(followPosts);
            }
            return allFollowPost;
        }
        return allFollowPost;
    }

}