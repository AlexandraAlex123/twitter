package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.Mention;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.modelDTO.MentionDtO;

import java.sql.Timestamp;
import java.util.List;

public class MentionFactory extends ValidateFactory implements ConvertDTO, Create {

    @Override
    public Object convertToDTO(Object o) {
        MentionDtO mentionDTO = new MentionDtO();
        Mention mention = (Mention) o;
        mentionDTO.setUserHwoMention(mention.getUserMentioning());
        mentionDTO.setCreateDate(getDateAndTime(mention.getCreateDate()));
        mentionDTO.setPostDTOMention(createPostMentionDTO(mention.getPostMention()));
        return mentionDTO;
    }

    @Override
    public void createAndSave(String userMentioning, Object... objects) {
        TwitterUser tuMention = new TwitterUser();
        Post post = new Post();
        Reply reply = new Reply();
        for (Object o : objects){
            if (o instanceof TwitterUser){
                tuMention = (TwitterUser) o;
            } else if (o instanceof Post) {
                post = (Post) o;
            } else if (o instanceof Reply) {
                reply = (Reply) o;
            }
        }
        Mention mention = new Mention();
        mention.setCreateDate(new Timestamp(System.currentTimeMillis()));
        mention.setUserMention(tuMention);
        mention.setUserMentioning(userMentioning);
        mention.setPostMention(post);
        mention.setReplyMention(reply);
        List<Mention> mentions = tuMention.getMentions();
        mentions.add(mention);
        tuMention.setMentions(mentions);
    }
}
