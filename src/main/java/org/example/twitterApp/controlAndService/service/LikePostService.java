package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.objectClassAndRepository.repository.LikePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LikePostService {

    @Autowired
    private LikePostRepository pR;

}
