package org.example.twitterApp.controlAndCreate.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.mention.MentionPost;
import org.example.twitterApp.objectClassAndRepository.model.mention.MentionReply;
import org.example.twitterApp.objectClassAndRepository.modelDTO.MentionDtO;

public class MentionFactory extends ValidateFactory implements Factory {

    @Override
    public Object convertToDTO(Object o) {
        MentionDtO mentionDTO = new MentionDtO();
        if(o instanceof MentionPost) {
            MentionPost mentionPost = (MentionPost) o;
            mentionDTO.setUserHwoMention(mentionPost.getUserMentioning().getUsername());
            mentionDTO.setCreateDate(getDateAndTime(mentionPost.getCreateDate()));
            mentionDTO.setPostDTOMention(createPostMentionDTO(mentionPost.getPost()));
            return mentionDTO;
        } else if (o instanceof MentionReply) {
            MentionReply mentionReply = (MentionReply) o;
            mentionDTO.setUserHwoMention(mentionReply.getUserMentioning().getUsername());
            mentionDTO.setCreateDate(getDateAndTime(mentionReply.getCreateDate()));
            mentionDTO.setPostDTOMention(createPostMentionDTO(mentionReply.getReply()));
            return mentionDTO;
        }
        return mentionDTO;
    }
}
