package org.example.twitterApp.controlAndCreate.service;

import org.example.twitterApp.controlAndCreate.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDtO;
import org.example.twitterApp.objectClassAndRepository.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


@Service
@Transactional
public class PostService extends ValidateFactory {

    private PostRepository pR;

    @Autowired
    public PostService(PostRepository pR) {
        this.pR = pR;
    }

    public PostService() {

    }

    public Set<PostDtO> searchUserPosts(String username) {
        if (validUsername(username)) {
            List<Post> posts = pR.findAllByUsername(username);
            return getListPostsDTO(posts);
        }
        return null;
    }

    public Set<PostDtO> filterPostsByDate(Set<PostDtO> postDTOs, Timestamp ts, Timestamp ts2) {
        if (ts != null && ts2 != null) {
            Set<PostDtO> filterPosts = new TreeSet<>();
            for (PostDtO postDTO : postDTOs) {
                if (postDTO.getCreateDate().compareTo(getDateAndTime(ts)) <= -1 && postDTO.getCreateDate().compareTo(getDateAndTime(ts2)) >= 1) {
                    filterPosts.add(postDTO);
                }
            }
            return filterPosts;
        }
        return null;
    }

    public String addAReplyPost(Long id, String message, String userWhoReply) {
        if (id != null && !message.isEmpty() && !userWhoReply.isEmpty()) {
            if (!message.equals(" ") && checkStringTu(userWhoReply)) {
                Post post = pR.findPostById(id);
                createAndSaveReply(post, message, userWhoReply);
                return "Comment add";
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }

    public Set<PostDtO> getMentionsPosts (String userMentioned){
        if(validUsername(userMentioned)) {
            List<Post> posts = pR.findMentionPosts(userMentioned);
            return getListPostsDTO(posts);
        }
        return null;
    }




}
