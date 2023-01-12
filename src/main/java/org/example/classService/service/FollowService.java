package org.example.classService.service;


import org.example.classService.service.classDtO.FollowDtO;
import org.example.classService.validation.CheckValue;
import org.example.classService.validation.DtOService;
import org.example.classService.validation.GarageClass;
import org.example.objectClassAndRepository.model.Follow;
import org.example.objectClassAndRepository.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.TreeSet;

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
