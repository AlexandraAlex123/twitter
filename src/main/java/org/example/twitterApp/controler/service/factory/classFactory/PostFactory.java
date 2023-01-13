package org.example.twitterApp.controler.service.factory.classFactory;

import org.example.twitterApp.objectClassAndRepository.classDtO.PostDtO;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.controler.service.factory.ValidateValueClass;

import java.util.Set;
import java.util.TreeSet;

public class PostFactory extends ValidateValueClass implements UserFactoryInterface {

   private Post p = new Post();

    @Override
    public PostDtO convertToDTO(Object o) {
        return null;
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
