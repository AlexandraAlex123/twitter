package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.controlAndService.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FollowService extends ValidateFactory {

    @Autowired
    private FollowRepository fR;

    public String deleteFollow(Long id) {
        if (id != null) {
            if (existsFollow(id)) {
                fR.deleteById(id);
                return "User unfollow";
            } else {
                return "Follow not found";
            }
        }
        return "Null parameter";
    }

    public boolean existsFollow(Long id){
        return fR.findById(id).isPresent();
    }

}
