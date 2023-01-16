package org.example.twitterApp.controlAndCreate.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.like.LikePost;
import org.example.twitterApp.objectClassAndRepository.model.like.LikeReply;
import org.example.twitterApp.objectClassAndRepository.modelDTO.LikeDtO;

public class LikeFactory extends ValidateFactory implements Factory {

    @Override
    public Object convertToDTO(Object o) {
        LikeDtO likeDTO = new LikeDtO();
        if (o instanceof LikePost) {
            LikePost likePost = (LikePost) o;
            likeDTO.setWhoGivesLike(likePost.getWhoGivesLike().getUsername());
            likeDTO.setCreateDate(getDateAndTime(likePost.getCreateDate()));
            return likeDTO;
        } else if (o instanceof LikeReply) {
            LikeReply likeReply = (LikeReply) o;
            likeDTO.setWhoGivesLike(likeReply.getWhoGivesLike().getUsername());
            likeDTO.setCreateDate(getDateAndTime(likeReply.getCreateDate()));
            return likeDTO;
        }
        return likeDTO;
    }
}
