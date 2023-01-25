package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.model.like.modelDTO.PostsMentionDTO;

public class PostsMentionFactory extends ValidateFactory implements ConvertDTO {

    @Override
    public Object convertToDTO(Object o) {
        PostsMentionDTO postsMDTO = new PostsMentionDTO();
        if (o instanceof Post) {
            Post post = (Post) o;
            postsMDTO.setPostBy(post.getUserWhoPost().getUsername());
            postsMDTO.setMessage(post.getMessage());
            postsMDTO.setOnlyMe(post.getOnlyMe());
        } else if (o instanceof Reply) {
            Reply reply = (Reply) o;
            postsMDTO.setPostBy(reply.getUserWhoPost().getUsername());
            postsMDTO.setMessage(reply.getMessage());
            postsMDTO.setOnlyMe(reply.getOnlyMe());
        }
        return postsMDTO;
    }
}
