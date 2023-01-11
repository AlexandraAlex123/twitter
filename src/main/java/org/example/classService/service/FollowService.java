package org.example.classService.service;


import org.example.classService.CheckValue;
import org.example.objectClassAndRepository.model.Follow;
import org.example.objectClassAndRepository.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FollowService extends CheckValue {

    private final CheckValue cV = new CheckValue();
    private final FollowRepository followRepository;

    @Autowired
    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }


}
