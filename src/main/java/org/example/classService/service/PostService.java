package org.example.classService.service;

import org.example.classService.service.classDtO.PostDtO;
import org.example.classService.validation.DtOService;
import org.example.objectClassAndRepository.model.posts.Post;
import org.example.objectClassAndRepository.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Optional;
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

    public String addAReply(Long id, String message, String userWhoReply) {
        if (id != null && !message.isEmpty() && !userWhoReply.isEmpty()) {
            if (!message.equals(" ") && checkStringTu(userWhoReply)) {
                Optional<Post> p = pR.findById(id);
//                createAndSaveReply(p , message, userWhoReply);
                return "Comment add";
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }

    public Set<PostDtO> filterPostsByDate(Timestamp ts, Timestamp ts2) {
        if (ts != null && ts2 != null) {
            Set<Post> posts = pR.findPostsBetweenDates(ts, ts2);
            return getAllPostsDTO(posts);
        }
        return null;
    }

    public Set<PostDtO> searchUserPosts(String username) {
        if (validUsername(username, pR)) {
            Set<Post> posts = pR.findAllByUsername(username);
            return getAllPostsDTO(posts);
        }
        return null;
    }


}
