package org.example.twitterApp.controlAndCreate.service.factory;

import org.example.twitterApp.objectClassAndRepository.modelDTO.ReplyDtO;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

public class ReplyFactory extends ValidateFactory implements Factory {


    @Override
    public Object convertToDTO(Object o) {
        Reply reply = (Reply) o;
        ReplyDtO replyDTO = new ReplyDtO();
        replyDTO.setMessage(reply.getMessage());
        replyDTO.setCreateDate(getDateAndTime(reply.getCreateDate()));
        replyDTO.setOnlyMe(reply.getOnlyMe());
        if (reply.getLikes() != null) {
            replyDTO.setReplyLikes(getListLikesDTO(reply.getLikes()));
        } else {
            replyDTO.setReplyLikes(null);
        }
        if (reply.getReplies() != null) {
            replyDTO.setReplyReplies(getListRepliesDTO(reply.getReplies()));
        } else {
            replyDTO.setReplyReplies(null);
        }
        return replyDTO;
    }
}
