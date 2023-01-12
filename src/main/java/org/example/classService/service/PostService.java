package org.example.classService.service;

import org.example.classService.service.classDtO.PostDtO;
import org.example.classService.validation.DtOService;
import org.example.objectClassAndRepository.model.posts.Post;
import org.example.objectClassAndRepository.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Set;


@Service
@Transactional
public class PostService extends DtOService {

    private PostRepository pR;

    @Autowired
    public PostService(PostRepository pR) {
        this.pR = pR;
    }

    public PostService() {

    }

    public Set<PostDtO> filterPosts(Timestamp ts, Timestamp ts2) {
        Set<Post> posts = pR.findPostsBetweenDates(ts, ts2);
        return getAllPostsDTO(posts);
    }

    public Set<PostDtO> searchUserPosts(String username) {
        if (username != null) {
            if (checkStringTu(username)) {
                if (usernameExist(username, pR)) {
                    Set<Post> posts = pR.findAll(username);
                    return getAllPostsDTO(posts);
                }
            }
        }
        return null;
    }





}
