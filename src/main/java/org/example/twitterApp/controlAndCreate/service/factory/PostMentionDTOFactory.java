package org.example.twitterApp.controlAndCreate.service.factory;

import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOMention;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

public class PostMentionDTOFactory extends ValidateFactory implements Factory {

    @Override
    public Object convertToDTO(Object o) {
        Post post = (Post) o;
        PostDTOMention postDTOM = new PostDTOMention();
        postDTOM.setMessage(post.getMessage());
        postDTOM.setCreateDate(getDateAndTime(post.getCreateDate()));
        postDTOM.setOnlyMe(post.getOnlyMe());
        return postDTOM;
    }

    public PostDTOMention convertToDTO(Reply reply) {
        PostDTOMention postDTOM = new PostDTOMention();
        postDTOM.setMessage(reply.getMessage());
        postDTOM.setCreateDate(getDateAndTime(reply.getCreateDate()));
        postDTOM.setOnlyMe(reply.getOnlyMe());
        return postDTOM;
    }
}
