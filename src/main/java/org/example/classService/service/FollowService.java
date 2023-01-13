package org.example.classService.service;


import org.example.classService.validation.DtOService;
import org.example.objectClassAndRepository.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FollowService extends DtOService {

    private FollowRepository fR;

    @Autowired
    public FollowService(FollowRepository fR) {
        this.fR = fR;
    }

    public FollowService() {
    }


}
