package org.example.twitterApp.controler.service.serviceClass;


import org.example.twitterApp.controler.service.factory.ServiceFactory;
import org.example.twitterApp.controler.service.factory.ValidateValueClass;
import org.example.twitterApp.objectClassAndRepository.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FollowService extends ServiceFactory {

    private FollowRepository fR;

    @Autowired
    public FollowService(FollowRepository fR) {
        this.fR = fR;
    }

    public FollowService() {
    }


}
