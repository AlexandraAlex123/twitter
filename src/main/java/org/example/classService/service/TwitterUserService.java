package org.example.classService.service;

import org.example.classService.CheckValue;
import org.example.classService.service.classDtO.TwitterUserDtO;
import org.example.objectClassAndRepository.model.Follow;
import org.example.objectClassAndRepository.model.Post;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.repository.TwitterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;

@Service
@Transactional
public class TwitterUserService extends CheckValue {

    private final CheckValue cV = new CheckValue();
    @Autowired
    private TwitterUserRepository tUr;


//    public TwitterUserService(TwitterUserRepository tUr) {
//        this.tUr = tUr;
//    }


    public String login(String username, String password) {

        if (!username.isEmpty() && !password.isEmpty()) {
            if (cV.checkStringTu(username) && cV.checkStringTu(password)) {
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

        Set<TwitterUserDtO> tuDtOSFind = new TreeSet<>();
        if (!keyWord.isEmpty() && !keyWord.equals(" ")) {
            List<TwitterUserDtO> tuDtOS = getAllTwitterUserDTO();
            for (TwitterUserDtO tuDTO : tuDtOS) {
                if (tuDTO.getUsername().toUpperCase().contains(keyWord.toUpperCase())) {
                    tuDtOSFind.add(tuDTO);
                }
            }
        }
        return tuDtOSFind;
    }


    public String addAPost(String username, String message, boolean onlyMe) {

        if (!username.isEmpty() && !message.isEmpty()) {
            if (cV.checkStringTu(username) && !message.equals(" ")) {
                TwitterUser tu = tUr.findByUsername(username);
                createAndSavePost(tu, message, onlyMe);
                return "Post uploaded";
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }


    public String whoYouFollow(String usernameWhoFollow, String usernameFollow) {

        if (!usernameWhoFollow.isEmpty() && !usernameFollow.isEmpty()) {
            if (cV.checkStringTu(usernameWhoFollow) && cV.checkStringTu(usernameFollow)) {
                TwitterUser tu = tUr.findByUsername(usernameWhoFollow);
                createAndSaveFollow(tu, usernameFollow);
                return "You fallow " + usernameFollow;
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }


    //    public List<Post> getYourOwnPosts(String username) {
//        List<Post> posts = pR.findAll(username);
//        List<Post> myOwnPosts = new ArrayList<>();
//        for(Post post : posts){
//            if(post.ge)
//        }
//    }


    public List<TwitterUserDtO> getAllTwitterUserDTO() {

        List<TwitterUser> tuS = tUr.findAll();
        List<TwitterUserDtO> tuDTOS = new ArrayList<>();
        for (TwitterUser tu : tuS) {
            if (tu.getFollows() != null && tu.getPosts() != null) {
                tuDTOS.add(new TwitterUserDtO(tu.getUsername(), tu.getFollows(), tu.getPosts()));
            } else if (tu.getFollows().equals(null)) {
                tuDTOS.add(new TwitterUserDtO(tu.getUsername(), null, tu.getPosts()));
            } else if (tu.getPosts().equals(null)) {
                tuDTOS.add(new TwitterUserDtO(tu.getUsername(), tu.getFollows(), null));
            }
        }
        return tuDTOS;
    }


    public void createAndSaveFollow(TwitterUser tu, String usernameFollow) {
        Follow follow = new Follow(usernameFollow, new Timestamp(System.currentTimeMillis()));
        List<Follow> follows = tu.getFollows();
        follows.add(follow);
        tu.setFollows(follows);
    }

    public void createAndSavePost(TwitterUser tu, String message, boolean onlyMe) {
        Post post = new Post(message, new Timestamp(System.currentTimeMillis()), onlyMe);
        List<Post> posts = tu.getPosts();
        posts.add(post);
        tu.setPosts(posts);
    }
}
