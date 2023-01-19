package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.mention.MentionPost;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.modelDTO.MentionDtO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MentionPostFactory extends ValidateFactory implements ConvertDTO, Create {

    @Override
    public MentionPost createAndSave(Object... objects) {
        TwitterUser tuMention = new TwitterUser();
        Post post = new Post();
        for (Object o : objects) {
            if (o instanceof TwitterUser) {
                tuMention = (TwitterUser) o;
            } else if (o instanceof Post) {
                post = (Post) o;
            }
        }
        MentionPost mentionPost = new MentionPost();
        mentionPost.setCreateDate(new Timestamp(System.currentTimeMillis()));
        mentionPost.setUserMention(tuMention);
        mentionPost.setPostMention(post);
        List<MentionPost> mentions = new ArrayList<>();
        if (post.getMentions() != null) {
            mentions = post.getMentions();
        }
        mentions.add(mentionPost);
        post.setMentions(mentions);
        return mentionPost;
    }

    @Override
    public MentionDtO convertToDTO(Object o) {
        MentionDtO mentionDTO = new MentionDtO();
        MentionPost mentionP = (MentionPost) o;
        mentionDTO.setUserMention(mentionP.getUserMention().getUsername());
        mentionDTO.setTimeMention(getDateAndTime(mentionP.getCreateDate()));
        mentionDTO.setMentionPost(getPostMentionDTO(mentionP.getPostMention()));
        return mentionDTO;
    }
}
