package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.controlAndService.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
                Reply reply = getReplyById(id);
                createAndSaveReplyReply(message, tus.getUserByUsername(userWhoReply), reply);
                return "Reply Add";
            } else {
                return "Invalid Command";
            }
        }
        return "Null parameter";
    }

    public String addLikeReply(Long id, String userWhoGivesLike) {
        if (id != null && !userWhoGivesLike.isEmpty()) {
            if (checkStringTu(userWhoGivesLike)) {
                if (tus.usernameExists(userWhoGivesLike)) {
                    Reply reply = rR.findReplyById(id);
                    TwitterUser tuWhoGivesLike = tus.getUserByUsername(userWhoGivesLike);
                    createAndSaveLike(reply, tuWhoGivesLike);
                } else {
                    return "User Not Found";
                }
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }

    public String addMentionPost(String userMention) {
        if (!userMention.isEmpty()) {
            if (checkStringTu(userMention)) {
                if (tus.usernameExists(userMention)) {
                    List<Reply> replies = rR.findMentionReply(userMention);
                    for (Reply reply : replies) {
                        if (!alreadyMention(reply, tus.getUserByUsername(userMention))) {
                            createAndSaveMentionReply(reply.getUserWhoPost().getUsername(), tus.getUserByUsername(userMention), reply);
                            return reply.getUserWhoPost().getUsername() + " mention " + userMention + " in a reply";
                        }else{
                            return "Notification already send";
                        }
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


    public Reply getReplyById(Long id) {
        return rR.findReplyById(id);
    }


}
