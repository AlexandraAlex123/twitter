package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.like.modelDTO.TwitterUserDtO;

public class TwitterUserFactory extends ValidateFactory implements ConvertDTO {

    @Override
    public TwitterUserDtO convertToDTO(Object o) {
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
        return tuDTO;
    }

}
