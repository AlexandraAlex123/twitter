package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.RegisterUser;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Transactional
public class ValidateFactory extends ConvertDTOFactory {

    public boolean checkStringRu(String stringToCheck) {
        char[] c = stringToCheck.toCharArray();
        if (!stringToCheck.isEmpty()) {
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

    public boolean valid(RegisterUser ru) {
        return checkStringRu(ru.getFirstName()) && checkStringRu(ru.getLastName()) && checkStringE(ru.getEmail());
    }

    public boolean valid(TwitterUser tu) {
        return checkStringTu(tu.getUsername()) && checkStringTu(tu.getPassword());
    }

    public boolean alreadyLike(TwitterUser tuWhoGivesLike, Reply rely) {
        if (rely.getLikes() != null) {
            return rely.getLikes().stream().anyMatch(likeReply -> likeReply.getWhoGivesLike().equals(tuWhoGivesLike));
        }
        return false;
    }

    public boolean alreadyLike(TwitterUser tuWhoGivesLike, Post post) {
        if (post.getLikes() != null) {
            return post.getLikes().stream().anyMatch(likePost -> likePost.getWhoGivesLike().equals(tuWhoGivesLike));
        }
        return false;
    }

    public boolean alreadyFollow(TwitterUser tuFollowing, String userFollow) {
        if (tuFollowing.getFollows() != null) {
            return tuFollowing.getFollows().stream().anyMatch(follow -> follow.getUserFollow().equals(userFollow));
        }
        return false;
    }

}
