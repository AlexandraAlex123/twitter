package org.example.twitterApp.controlAndCreate.service.factory;

import org.example.twitterApp.objectClassAndRepository.modelDTO.FollowDtO;
import org.example.twitterApp.objectClassAndRepository.model.Follow;

public class FollowFactory extends ValidateFactory implements Factory {

    @Override
    public Object convertToDTO(Object o) {
        Follow follow = (Follow) o;
        FollowDtO followDTO = new FollowDtO();
        followDTO.setUsernameFollow(follow.getUsernameFollowed());
        followDTO.setCreateDate(getDateAndTime(follow.getCreateDate()));
        return followDTO;
    }

}
