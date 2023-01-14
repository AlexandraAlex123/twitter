package org.example.twitterApp.controler.service.factory.classFactory;

import org.example.twitterApp.controler.service.factory.ServiceFactory;
import org.example.twitterApp.controler.service.factory.ValidateValueClass;
import org.example.twitterApp.objectClassAndRepository.classDtO.PostDtO;
import org.example.twitterApp.objectClassAndRepository.classDtO.ReplyDtO;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.springframework.beans.factory.annotation.Autowired;

public class ReplyFactory extends ValidateValueClass implements FactoryInterface{


    private ServiceFactory sf = new ServiceFactory();

    @Override
    public Object convertToDTO(Object o) {
        Reply reply = (Reply) o;
        ReplyDtO replyDTO = new ReplyDtO();
        replyDTO.setMessage(reply.getMessage());
        replyDTO.setCreateDate(getDateAndTime(reply.getCreateDate()));
        replyDTO.setOnlyMe(reply.getOnlyMe());
        if (reply.getLikes() != null) {
            replyDTO.setReplyLikes(sf.getListLikesDTO(reply.getLikes()));
        } else {
            replyDTO.setReplyLikes(null);
        }
        if (reply.getReplies() != null) {
            replyDTO.setReplyReplies(sf.getListRepliesDTO(reply.getReplies()));
        } else {
            replyDTO.setReplyReplies(null);
        }
        return replyDTO;
    }
}
