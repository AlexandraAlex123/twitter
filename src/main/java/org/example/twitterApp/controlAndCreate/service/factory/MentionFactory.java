package org.example.twitterApp.controlAndCreate.service.factory;

import org.example.twitterApp.objectClassAndRepository.modelDTO.MentionDtO;
import org.example.twitterApp.objectClassAndRepository.model.Mention;

public class MentionFactory extends ValidateFactory implements Factory {

    @Override
    public Object convertToDTO(Object o) {
        Mention mention = (Mention) o;
        MentionDtO mentionDTO = new MentionDtO();
        mentionDTO.setUserHwoMention(mention.getUserMentioning().getUsername());
        mentionDTO.setCreateDate(getDateAndTime(mention.getCreateDate()));
        mentionDTO.setPostDTOMention(createPostMentionDTO(mention.getPost()));
        return mentionDTO;
    }
}
