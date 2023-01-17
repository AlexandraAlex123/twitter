package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.modelDTO.ReplyDtO;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class ReplyFactory extends ValidateFactory implements ConvertDTO, Create {


    @Override
    public Object convertToDTO(Object o) {
        Reply reply = (Reply) o;
        ReplyDtO replyDTO = new ReplyDtO();
        replyDTO.setMessage(reply.getMessage());
        replyDTO.setCreateDate(getDateAndTime(reply.getCreateDate()));
        replyDTO.setOnlyMe(reply.getOnlyMe());
        if (reply.getLikes() != null) {
            replyDTO.setReplyLikes(getListLikesReplyDTO(reply.getLikes()));
        } else {
            replyDTO.setReplyLikes(null);
        }
        if (reply.getReplies() != null) {
            replyDTO.setReplyReplies(getListRepliesDTOF(reply.getReplies()));
        } else {
            replyDTO.setReplyReplies(null);
        }
        return replyDTO;
    }

    @Override
    public void createAndSave(String message, Object... objects) {
        TwitterUser tuWhoPost = new TwitterUser();
        Post post = new Post();
        Reply reply = new Reply();
        for (Object o : objects) {
            if (o instanceof TwitterUser) {
                tuWhoPost = (TwitterUser) o;
            } else if (o instanceof Post) {
                post = (Post) o;
            } else if (o instanceof Reply) {
                reply = (Reply) o;
            }
        }
        try {
            if (!isNull(post)) {
                Reply replyNew = new Reply();
                replyNew.setMessage(message);
                replyNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
                replyNew.setOnlyMe(false);
                replyNew.setUserWhoPost(tuWhoPost);
                List<Reply> replies = post.getReplies();
                replies.add(replyNew);
                post.setReplies(replies);
            } else if (!isNull(reply)) {
                Reply replyNew = new Reply();
                replyNew.setMessage(message);
                replyNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
                replyNew.setOnlyMe(false);
                replyNew.setUserWhoPost(tuWhoPost);
                List<Reply> replies = reply.getReplies();
                replies.add(replyNew);
                reply.setReplies(replies);
            }
        }catch (NullPointerException e){
            System.out.println("Caught NullPointerException" + e.getMessage());
        }
    }
}
