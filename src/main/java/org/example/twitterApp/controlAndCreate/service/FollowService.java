package org.example.twitterApp.controlAndCreate.service;

import org.example.twitterApp.controlAndCreate.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FollowService extends ValidateFactory {

    @Autowired
    private FollowRepository fR;

    public boolean alreadyFollow(String userFollow){
        return fR.findFollowByUsernameFollow(userFollow) != null;
    }


}
