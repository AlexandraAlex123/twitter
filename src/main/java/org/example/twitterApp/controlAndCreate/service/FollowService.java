package org.example.twitterApp.controlAndCreate.service;


import org.example.twitterApp.controlAndCreate.service.factory.CreateFactory;
import org.example.twitterApp.controlAndCreate.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FollowService extends ValidateFactory {

    private FollowRepository fR;

    @Autowired
    public FollowService(FollowRepository fR) {
        this.fR = fR;
    }

    public FollowService() {
    }


}
