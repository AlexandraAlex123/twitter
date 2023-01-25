package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.mention.MentionReply;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.model.like.modelDTO.MentionDtO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MentionReplyFactory extends ValidateFactory implements ConvertDTO, Create {

    @Override
    public MentionReply createAndSave(Object... objects) {
        TwitterUser tuMention = new TwitterUser();
        Reply reply = new Reply();
        for (Object o : objects) {
            if (o instanceof TwitterUser) {
                tuMention = (TwitterUser) o;
            } else if (o instanceof Reply) {
                reply = (Reply) o;
            }
        }
        MentionReply mentionReply = new MentionReply();
        mentionReply.setCreateDate(new Timestamp(System.currentTimeMillis()));
        mentionReply.setUserMention(tuMention);
        mentionReply.setReplyMention(reply);
        List<MentionReply> mentions = new ArrayList<>();
        if (reply.getMentions() != null) {
            mentions = reply.getMentions();
        }
        mentions.add(mentionReply);
        reply.setMentions(mentions);
        return mentionReply;
    }

    @Override
    public Object convertToDTO(Object o) {
        MentionDtO mentionDTO = new MentionDtO();
        MentionReply mentionR = (MentionReply) o;
        mentionDTO.setUserMention(mentionR.getUserMention().getUsername());
        mentionDTO.setTimeMention(getDateAndTime(mentionR.getCreateDate()));
        mentionDTO.setMentionPost(getPostMentionDTO(mentionR.getReplyMention()));
        return mentionDTO;
    }
}

