package org.example.twitterApp.controlAndCreate.service.factory;

import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDtO;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;

public class PostFactory extends ValidateFactory implements Factory {

    @Override
    public PostDtO convertToDTO(Object o) {
        Post post = (Post) o;
        PostDtO postDTO = new PostDtO();
        postDTO.setMessage(post.getMessage());
        postDTO.setCreateDate(getDateAndTime(post.getCreateDate()));
        postDTO.setOnlyMe(post.getOnlyMe());
        if (post.getLikes() != null) {
            postDTO.setPostLikes(getListLikesDTO(post.getLikes()));
        } else {
            postDTO.setPostLikes(null);
        }
        if (post.getReplies() != null) {
            postDTO.setPostReplies(getListRepliesDTOF(post.getReplies()));
        } else {
            postDTO.setPostReplies(null);
        }
        return postDTO;
    }


}
