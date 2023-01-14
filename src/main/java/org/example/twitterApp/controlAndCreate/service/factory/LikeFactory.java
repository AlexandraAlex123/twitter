package org.example.twitterApp.controlAndCreate.service.factory;

import org.example.twitterApp.objectClassAndRepository.modelDTO.LikeDtO;
import org.example.twitterApp.objectClassAndRepository.model.Like;

public class LikeFactory extends ValidateFactory implements Factory {

    @Override
    public Object convertToDTO(Object o) {
        Like like = (Like) o;
        LikeDtO likeDTO = new LikeDtO();
        likeDTO.setWhoGivesLike(like.getWhoGivesLike());
        likeDTO.setCreateDate(getDateAndTime(like.getCreateDate()));
        return likeDTO;
    }
}
