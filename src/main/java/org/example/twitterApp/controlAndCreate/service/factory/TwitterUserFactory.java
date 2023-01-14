package org.example.twitterApp.controlAndCreate.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.modelDTO.TwitterUserDtO;

public class TwitterUserFactory extends ValidateFactory implements Factory {

    @Override
    public Object convertToDTO(Object o) {
        TwitterUser tu = (TwitterUser) o;
        TwitterUserDtO tuDTO = new TwitterUserDtO();
        tuDTO.setAccount(tu.getUsername());
        tuDTO.setCreateDate(getDateAndTime(tu.getCreateDate()));
        if (tu.getFollows() != null) {
            tuDTO.setYourFollows(getListFollowsDTO(tu.getFollows()));
        } else {
            tuDTO.setYourFollows(null);
        }
        if (tu.getPosts() != null) {
            tuDTO.setYourPosts(getListPostsDTO(tu.getPosts()));
        } else {
            tuDTO.setYourPosts(null);
        }
        if (tu.getMentions() != null) {
            tuDTO.setYourMentions(getListMentionsDTO(tu.getMentions()));
        } else {
            tuDTO.setYourMentions(null);
        }
        return tuDTO;
    }

}
