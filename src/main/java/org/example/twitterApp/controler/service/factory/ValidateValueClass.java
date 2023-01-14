package org.example.twitterApp.controler.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.repository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ValidateValueClass  {

    @Autowired
    RegisterUserRepository rUr;

    public boolean checkStringRu(String stringToCheck) {
        char[] c = stringToCheck.toCharArray();
        if (!stringToCheck.equals(" ")) {
            return c.length >= 2;
        }
        return false;
    }

    public boolean checkStringTu(String stringToCheck) {
        char[] c = stringToCheck.toCharArray();
        if (!stringToCheck.contains(" ")) {
            return c.length >= 6;
        }
        return false;
    }

    public boolean checkStringE(String stringToCheck) {
        if (!stringToCheck.equals(" ")) {
            return stringToCheck.matches("^(.+)@(.+)$");
        }
        return false;
    }

    public String getDateAndTime(Timestamp ts) {
        return new SimpleDateFormat("MMM dd yyyy HH:mm:ss").format(new Date(ts.getTime()));
    }

    public boolean isNotNull(TwitterUser tu) {
        return !tu.getUsername().isEmpty() && !tu.getPassword().isEmpty();
    }

    public boolean isNotNull(RegisterUser ru) {
        return !ru.getFirstName().isEmpty() && !ru.getLastName().isEmpty() && !ru.getEmail().isEmpty();
    }

    public boolean validUser(RegisterUser ru) {
        return checkStringRu(ru.getFirstName()) && checkStringRu(ru.getLastName()) && checkStringE(ru.getEmail());
    }

    public boolean validUser(TwitterUser tu) {
        return checkStringTu(tu.getUsername()) && checkStringTu(tu.getPassword());
    }

    public boolean validUsername(String username) {
        return !username.isEmpty() && checkStringTu(username) && usernameExists(username);
    }

    public boolean usernameExists(String username) {
        return rUr.findUserByUsername(username) != null;
    }

    public boolean emailExists(String email) {
        return rUr.findUserByEmail(email) != null;
    }


    public void createAndSaveFollow(TwitterUser tu, String usernameFollow) {
        Follow follow = new Follow(usernameFollow, new Timestamp(System.currentTimeMillis()));
        List<Follow> follows = tu.getFollows();
        follows.add(follow);
        tu.setFollows(follows);
    }

    public void createAndSavePost(TwitterUser tu, String message) {
        Post post = new Post(message, new Timestamp(System.currentTimeMillis()), false);
        List<Post> posts = tu.getPosts();
        posts.add(post);
        tu.setPosts(posts);
    }

    public void createAndSaveReply(Post post, String message, String userWhoReply) {
        Reply reply = new Reply(message, new Timestamp(System.currentTimeMillis()), false, userWhoReply);
        List<Reply> replies = post.getReplies();
        replies.add(reply);
        post.setReplies(replies);
    }

    public String getHash(String password) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

}
