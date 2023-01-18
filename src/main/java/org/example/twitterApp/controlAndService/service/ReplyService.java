package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.controlAndService.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.like.LikeReply;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class ReplyService extends ValidateFactory {

    @Autowired
    private TwitterUserService tus;

    @Autowired
    private ReplyRepository rR;

    public String addReplyReply(Long id, String message, String userWhoReply) {
        if (id != null && !message.isEmpty() && !userWhoReply.isEmpty()) {
            if (!message.equals(" ") && checkStringTu(userWhoReply)) {
                if (tus.usernameExists(userWhoReply)) {
                    if (replyExists(id)) {
                        Reply reply = getReplyById(id);
                        Reply replyReply = createAndSaveReplyReply(message, tus.getUserByUsername(userWhoReply), reply);
                        if (message.contains("@")) {
                            return addMentionReply(tus.getUserByUsername(userWhoReply), replyReply);
                        }
                        return "Reply comment add";
                    } else {
                        return "Comment not found";
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

    public String addMentionReply(TwitterUser tuWhoReply, Reply reply) {
        if (tuWhoReply.getFollows() != null) {
            List<Follow> follows = tuWhoReply.getFollows();
            Set<String> followMentionS = new TreeSet<>();
            for (Follow f : follows) {
                if (reply.getMessage().contains("@" + f.getUserFollow())) {
                    TwitterUser tuMention = tus.getUserByUsername(f.getUserFollow());
                    createAndSaveMentionReply(tuMention, reply);
                    followMentionS.add(f.getUserFollow());
                }
            }
            return "Comment add. You mention in this comment " + followMentionS;
        }
        return "Comment add";
    }

    public String addLikeReply(Long id, String userWhoGivesLike) {
        if (id != null && !userWhoGivesLike.isEmpty()) {
            if (checkStringTu(userWhoGivesLike)) {
                if (tus.usernameExists(userWhoGivesLike)) {
                    Reply reply = rR.findReplyById(id);
                    if (replyExists(id)) {
                        if (!alreadyLike(tus.getUserByUsername(userWhoGivesLike), reply)) {
                            TwitterUser tuWhoGivesLike = tus.getUserByUsername(userWhoGivesLike);
                            createAndSaveLikeReply(tuWhoGivesLike, reply);
                            return "Like send";
                        } else {
                            return "Already liked";
                        }
                    } else {
                        return "Comment not found";
                    }
                } else {
                    return "User Not Found";
                }
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }


    public Reply getReplyById(Long id) {
        return rR.findReplyById(id);
    }

    public boolean replyExists(Long id) {
        return rR.findReplyById(id) != null;
    }

    private static boolean alreadyLike(TwitterUser tuWhoGivesLike, Reply rely) {
        if (rely.getLikes() != null) {
            List<LikeReply> likesReply = rely.getLikes();
            for (LikeReply l : likesReply) {
                return l.getWhoGivesLike().equals(tuWhoGivesLike);
            }
        }
        return false;
    }
}
