package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.objectClassAndRepository.repository.LikeReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LikeReplyService {

    @Autowired
    private LikeReplyRepository lR;

}
