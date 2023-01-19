package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.mention.MentionPost;
import org.example.twitterApp.objectClassAndRepository.model.mention.MentionReply;
import org.example.twitterApp.objectClassAndRepository.modelDTO.MentionForPostDTO;

public class MentionForPostFactory extends ValidateFactory implements ConvertDTO {

    @Override
    public MentionForPostDTO convertToDTO(Object o) {
        MentionForPostDTO mentionDTOP = new MentionForPostDTO();
        if (o instanceof MentionPost) {
            MentionPost mentionPost = (MentionPost) o;
            mentionDTOP.setCreateDate(getDateAndTime(mentionPost.getCreateDate()));
            mentionDTOP.setUserMention(mentionPost.getUserMention().getUsername());
        } else if (o instanceof MentionReply) {
            MentionReply mentionReply = (MentionReply) o;
            mentionDTOP.setCreateDate(getDateAndTime(mentionReply.getCreateDate()));
            mentionDTOP.setUserMention(mentionReply.getUserMention().getUsername());
        }
        return mentionDTOP;
    }

}
