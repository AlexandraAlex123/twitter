package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.like.LikeReply;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.model.like.modelDTO.LikeDtO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LikeReplyFactory extends ValidateFactory implements ConvertDTO, Create {

    @Override
    public LikeReply createAndSave(Object... objects) {
        TwitterUser tuWhoGivesLike = new TwitterUser();
        Reply reply = new Reply();
        for (Object o : objects) {
            if (o instanceof TwitterUser) {
                tuWhoGivesLike = (TwitterUser) o;
            } else if (o instanceof Reply) {
                reply = (Reply) o;
            }
        }
        LikeReply likeReply = new LikeReply();
        likeReply.setCreateDate(new Timestamp(System.currentTimeMillis()));
        likeReply.setWhoGivesLike(tuWhoGivesLike);
        likeReply.setReplyLike(reply);
        List<LikeReply> likes = new ArrayList<>();
        if (reply.getLikes() != null) {
            likes = reply.getLikes();
        }
        likes.add(likeReply);
        reply.setLikes(likes);
        return likeReply;
    }

    @Override
    public LikeDtO convertToDTO(Object o) {
        LikeDtO likeDTO = new LikeDtO();
        LikeReply likeReply = (LikeReply) o;
        likeDTO.setWhoGivesLike(likeReply.getWhoGivesLike().getUsername());
        likeDTO.setCreateDate(getDateAndTime(likeReply.getCreateDate()));
        return likeDTO;
    }

}
