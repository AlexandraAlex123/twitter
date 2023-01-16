package org.example.twitterApp.controlAndCreate.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.Mention;
import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

import javax.transaction.Transactional;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Transactional
public class ValidateFactory extends CreateFactory {

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


    public void createAndSaveFollow(TwitterUser userFollowing, TwitterUser userFollow) {
        List<Follow> follows = userFollowing.getFollows();
        Follow follow = new Follow();
        follow.setCreateDate(new Timestamp(System.currentTimeMillis()));
        follow.setUserFollow(userFollow);
        follow.setUserFollowing(userFollowing);
        follows.add(follow);
        userFollowing.setFollows(follows);
    }

    public void createAndSavePost(TwitterUser tu, String message) {
        Post post = new Post();
        post.setMessage(message);
        post.setCreateDate(new Timestamp(System.currentTimeMillis()));
        post.setOnlyMe(false);
        post.setUserWhoPost(tu);
        List<Post> posts = tu.getPosts();
        posts.add(post);
        tu.setPosts(posts);
    }

    public void createAndSaveReply(Post post, String message, TwitterUser userWhoPost) {
        Reply reply = new Reply();
        reply.setMessage(message);
        reply.setCreateDate(new Timestamp(System.currentTimeMillis()));
        reply.setOnlyMe(false);
        reply.setUserWhoPost(userWhoPost);
        List<Reply> replies = post.getReplies();
        replies.add(reply);
        post.setReplies(replies);
    }

    public void createAndSaveMention(Post post, TwitterUser userMention, TwitterUser userMentioning) {
        Mention mention = new Mention();
        mention.setCreateDate(new Timestamp(System.currentTimeMillis()));
        mention.setUserMention(userMention);
        mention.setUserMentioning(userMentioning);
        mention.setPost(post);
        List<Mention> mentions = userMention.getMentions();
        mentions.add(mention);
        userMention.setMentions(mentions);
    }

    public void createAndSaveMention(Reply reply, TwitterUser userMention, TwitterUser userMentioning) {
        Mention mention = new Mention();
        mention.setCreateDate(new Timestamp(System.currentTimeMillis()));
        mention.setUserMention(userMention);
        mention.setUserMentioning(userMentioning);
        mention.setReply(reply);
        List<Mention> mentions = userMention.getMentions();
        mentions.add(mention);
        userMention.setMentions(mentions);
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
