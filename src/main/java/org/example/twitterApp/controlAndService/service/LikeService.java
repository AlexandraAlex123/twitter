package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.objectClassAndRepository.repository.LikePostRepository;
import org.example.twitterApp.objectClassAndRepository.repository.LikeReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LikeService {

    @Autowired
    private LikePostRepository lPr;

    private LikeReplyRepository lRr;

    public String deleteLike(Long id) {
        if (id != null) {
            if (existsLikePost(id)) {
                lPr.deleteById(id);
                return "Like deleted";
            } else if (existsLikeReply(id)) {
                lRr.deleteById(id);
                return "Like deleted";
            } else {
                return "Like not found";
            }
        }
        return " Null parameter";
    }

    public boolean existsLikePost(Long id) {
        return lPr.findById(id).isPresent();
    }

    public boolean existsLikeReply(Long id) {
        return lRr.findById(id).isPresent();
    }
}
