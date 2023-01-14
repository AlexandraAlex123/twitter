package org.example.twitterApp.controler.service.factory.classFactory;

import org.example.twitterApp.controler.service.factory.ServiceFactory;
import org.example.twitterApp.controler.service.factory.ValidateValueClass;
import org.example.twitterApp.objectClassAndRepository.classDtO.MentionDtO;
import org.example.twitterApp.objectClassAndRepository.model.Mention;
import org.springframework.beans.factory.annotation.Autowired;

public class MentionFactory extends ValidateValueClass implements FactoryInterface {


    private ServiceFactory sf = new ServiceFactory();

    @Override
    public Object convertToDTO(Object o) {
        Mention mention = (Mention) o;
        MentionDtO mentionDTO = new MentionDtO();
        mentionDTO.setUserHwoMention(mention.getUserWhoMention());
        mentionDTO.setCreateDate(getDateAndTime(mention.getCreateDate()));
        mentionDTO.setPostDTOMention(sf.createPostMentionDTO(mention.getPost()));
        return mentionDTO;
    }
}
