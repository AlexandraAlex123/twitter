package org.example.twitterApp.controler.service.factory.classFactory;

import org.example.twitterApp.controler.service.factory.ValidateValueClass;
import org.example.twitterApp.objectClassAndRepository.classDtO.LikeDtO;
import org.example.twitterApp.objectClassAndRepository.classDtO.PostDtO;
import org.example.twitterApp.objectClassAndRepository.model.Like;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;

public class LikeFactory extends ValidateValueClass implements FactoryInterface{

    @Override
    public Object convertToDTO(Object o) {
        Like like = (Like) o;
        LikeDtO likeDTO = new LikeDtO();
        likeDTO.setWhoGivesLike(like.getWhoGivesLike());
        likeDTO.setCreateDate(getDateAndTime(like.getCreateDate()));
        return likeDTO;
    }
}
