package org.example.twitterApp.controler.service.serviceClass;

import org.example.twitterApp.controler.service.factory.ServiceFactory;
import org.example.twitterApp.controler.service.factory.classFactory.FactoryInterface;
import org.example.twitterApp.objectClassAndRepository.classDtO.PostDtO;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;


@Service
@Transactional
public class PostService extends ServiceFactory {

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
                Post post = pR.findPostById(id);
                createAndSaveReply(post , message, userWhoReply);
                return "Comment add";
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }

    public Set<PostDtO> filterPostsByDate(Timestamp ts, Timestamp ts2) {
        if (ts != null && ts2 != null) {
            List<Post> posts = pR.findPostsBetweenDates(ts, ts2);
            return getListPostsDTO(posts);
        }
        return null;
    }

    public Set<PostDtO> searchUserPosts(String username) {
        if (validUsername(username)) {
            List<Post> posts = pR.findAllByUsername(username);
            return getListPostsDTO(posts);
        }
        return null;
    }


}
