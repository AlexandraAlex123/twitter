package org.example.classService.service;

import org.example.classService.CheckValue;
import org.example.classService.service.classDtO.PostDtO;
import org.example.objectClassAndRepository.model.posts.Post;
import org.example.objectClassAndRepository.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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


    public List<PostDtO> convertListPostsToDTO(List<Post> posts) {
        List<PostDtO> postsDTO = new ArrayList<>();
        for (Post p : posts) {
            if (p.getLikes().isEmpty()) {
                postsDTO.add(new PostDtO(p.getMessage(), new SimpleDateFormat("MM/dd/yyyy HH:mm").format(p.getDate()), p.getOnlyMe(), p.getReplies(), null));
            } else if (p.getReplies().isEmpty()) {
                postsDTO.add(new PostDtO(p.getMessage(), new SimpleDateFormat("MM/dd/yyyy HH:mm").format(p.getDate()), p.getOnlyMe(), null, p.getLikes()));
            } else if (p.getLikes().isEmpty() && p.getReplies().isEmpty()) {
                postsDTO.add(new PostDtO(p.getMessage(), new SimpleDateFormat("MM/dd/yyyy HH:mm").format(p.getDate()), p.getOnlyMe(), p.getReplies(), p.getLikes()));
            } else if (p.getLikes() != null && p.getReplies() != null){
                postsDTO.add(new PostDtO(p.getMessage(), new SimpleDateFormat("MM/dd/yyyy HH:mm").format(p.getDate()), p.getOnlyMe(), null, null));
            }
        }
        return postsDTO;
    }

    public List<Post> getYourOwnPosts(String username) {
        return pR.findAll(username);
    }

}
