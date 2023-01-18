package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.modelDTO.ReplyDtO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReplyFactory extends ValidateFactory implements ConvertDTO, Create {


    @Override
    public Reply createAndSave(Object... objects) {
        Reply replyNew = new Reply();
        TwitterUser tuWhoPost = new TwitterUser();
        Post post = null;
        Reply reply = null;
        String message = null;
        for (Object o : objects) {
            if (o instanceof TwitterUser) {
                tuWhoPost = (TwitterUser) o;
            } else if (o instanceof Post) {
                post = (Post) o;
            } else if (o instanceof Reply) {
                reply = (Reply) o;
            } else if (o instanceof String) {
                message = (String) o;
            }
        }
            if (post != null) {
                replyNew.setMessage(message);
                replyNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
                replyNew.setOnlyMe(false);
                replyNew.setUserWhoPost(tuWhoPost);
                List<Reply> replies = new ArrayList<>();
                if (post.getReplies() != null) {
                    replies = post.getReplies();
                }
                replies.add(replyNew);
                post.setReplies(replies);
                return replyNew;
            } else if (reply != null) {
                replyNew.setMessage(message);
                replyNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
                replyNew.setOnlyMe(false);
                replyNew.setUserWhoPost(tuWhoPost);
                List<Reply> replies = new ArrayList<>();
                if (reply.getReplies() != null) {
                    replies = reply.getReplies();
                }
                replies.add(replyNew);
                reply.setReplies(replies);
                return replyNew;
            }
        return replyNew;
    }

    @Override
    public ReplyDtO convertToDTO(Object o) {
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
        if (reply.getMentions() != null) {
            replyDTO.setMentionReply(getListMentionReplyDTO(reply.getMentions()));
        }
        return replyDTO;
    }
}
