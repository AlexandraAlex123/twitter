package org.example.classService.service;

import org.example.classService.CheckValue;
import org.example.objectClassAndRepository.model.Post;
import org.example.objectClassAndRepository.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;


@Service
@Transactional
public class PostService extends CheckValue {

    private final CheckValue cV = new CheckValue();
    private final PostRepository pR;

    @Autowired
    public PostService(PostRepository pR) {
        this.pR = pR;
    }

    public List<Post> getYourOwnPosts(String username) {
        return pR.findAll(username);
    }

}
