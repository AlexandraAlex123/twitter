package org.example.twitterApp.controlAndCreate.service.factory;

import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOMention;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

public class PostDTOMentionFactory extends ValidateFactory implements Factory {

    @Override
    public PostDTOMention convertToDTO(Object o) {
        if (o instanceof Post) {
            Post post = (Post) o;
            PostDTOMention postDTOM = new PostDTOMention();
            postDTOM.setMessage(post.getMessage());
            postDTOM.setCreateDate(getDateAndTime(post.getCreateDate()));
            postDTOM.setOnlyMe(post.getOnlyMe());
            return postDTOM;
        } else if (o instanceof Reply) {
            Reply reply = (Reply) o;
            PostDTOMention postDTOM = new PostDTOMention();
            postDTOM.setMessage(reply.getMessage());
            postDTOM.setCreateDate(getDateAndTime(reply.getCreateDate()));
            postDTOM.setOnlyMe(reply.getOnlyMe());
            return postDTOM;
        }
        return null;
    }

}
