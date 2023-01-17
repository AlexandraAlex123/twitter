package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOMention;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

public class PostMentionFactory extends ValidateFactory implements ConvertDTO {

    @Override
    public PostDTOMention convertToDTO(Object o) {
        PostDTOMention postDTOM = new PostDTOMention();
        if (o instanceof Post) {
            Post post = (Post) o;
            postDTOM.setPostBy(postDTOM.getPostBy());
            postDTOM.setMessage(post.getMessage());
            postDTOM.setCreateDate(getDateAndTime(post.getCreateDate()));
            postDTOM.setOnlyMe(post.getOnlyMe());
            return postDTOM;
        } else if (o instanceof Reply) {
            Reply reply = (Reply) o;
            postDTOM.setPostBy(postDTOM.getPostBy());
            postDTOM.setMessage(reply.getMessage());
            postDTOM.setCreateDate(getDateAndTime(reply.getCreateDate()));
            postDTOM.setOnlyMe(reply.getOnlyMe());
            return postDTOM;
        }
        return postDTOM;
    }

}
