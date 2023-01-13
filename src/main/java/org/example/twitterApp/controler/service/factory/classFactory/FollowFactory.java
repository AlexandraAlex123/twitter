package org.example.twitterApp.controler.service.factory.classFactory;

import org.example.twitterApp.controler.service.factory.ValidateValueClass;
import org.example.twitterApp.objectClassAndRepository.classDtO.FollowDtO;
import org.example.twitterApp.objectClassAndRepository.model.Follow;

public class FollowFactory extends ValidateValueClass implements UserFactoryInterface {

    private Follow f;

    @Override
    public Object convertToDTO(Object o) {
        return new FollowDtO(f.getUsernameFollowed(), getDateAndTime(f.getCreateDate()));
    }

}
