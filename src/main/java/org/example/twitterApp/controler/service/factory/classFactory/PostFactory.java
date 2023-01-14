package org.example.twitterApp.controler.service.factory.classFactory;

import org.example.twitterApp.controler.service.factory.ServiceFactory;
import org.example.twitterApp.objectClassAndRepository.classDtO.PostDtO;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.controler.service.factory.ValidateValueClass;
import org.springframework.beans.factory.annotation.Autowired;

public class PostFactory extends ValidateValueClass implements FactoryInterface {


    private ServiceFactory sf = new ServiceFactory();

    @Override
    public PostDtO convertToDTO(Object o) {
        Post post = (Post) o;
        PostDtO postDTO = new PostDtO();
        postDTO.setMessage(post.getMessage());
        postDTO.setCreateDate(getDateAndTime(post.getCreateDate()));
        postDTO.setOnlyMe(post.getOnlyMe());
        if (post.getLikes() != null) {
            postDTO.setPostLikes(sf.getListLikesDTO(post.getLikes()));
        } else {
            postDTO.setPostLikes(null);
        }
        if (post.getReplies() != null) {
            postDTO.setPostReplies(sf.getListRepliesDTO(post.getReplies()));
        } else {
            postDTO.setPostReplies(null);
        }
        return postDTO;
    }


//    public Set<PostDtO> getAllDTO(Set<?> list) {
//        Set<PostDtO> postDTOs = new TreeSet<>();
//        for (int i = 0; i < list.size(); i++) {
//            PostDtO postDTO = new PostDtO();
//            postDTO.setMessage(p.getMessage());
//            postDTO.setCreateDate(getDateAndTime(p.getCreateDate()));
//            postDTO.setOnlyMe(p.getOnlyMe());
//            if (p.getLikes() != null) {
//                postDTO.setPostLikes(p.getLikes());
//            } else {
//                postDTO.setPostLikes(null);
//            }
//            if (p.getReplies() != null) {
//                postDTO.setPostReplies(p.getReplies());
//            } else {
//                postDTO.setPostReplies(null);
//            }
//            postDTOs.add(postDTO);
//        }
//        return postDTOs;
//    }

}
