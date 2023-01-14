package org.example.twitterApp.controler.service.factory.classFactory;

import org.example.twitterApp.controler.service.factory.ValidateValueClass;
import org.example.twitterApp.objectClassAndRepository.classDtO.FollowDtO;
import org.example.twitterApp.objectClassAndRepository.classDtO.LikeDtO;
import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.Like;

public class FollowFactory extends ValidateValueClass implements FactoryInterface {

    @Override
    public Object convertToDTO(Object o) {
        Follow follow = (Follow) o;
        FollowDtO followDTO = new FollowDtO();
        followDTO.setUsernameFollow(follow.getUsernameFollowed());
        followDTO.setCreateDate(getDateAndTime(follow.getCreateDate()));
        return followDTO;
    }

}
