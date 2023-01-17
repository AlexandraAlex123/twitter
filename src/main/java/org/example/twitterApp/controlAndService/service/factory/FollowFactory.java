package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.modelDTO.FollowDtO;

import java.sql.Timestamp;
import java.util.List;

public class FollowFactory extends ValidateFactory implements ConvertDTO, Create {

    @Override
    public Object convertToDTO(Object o) {
        Follow follow = (Follow) o;
        FollowDtO followDTO = new FollowDtO();
        followDTO.setUsernameFollow(follow.getUserFollow());
        followDTO.setCreateDate(getDateAndTime(follow.getCreateDate()));
        return followDTO;
    }

    @Override
    public void createAndSave(String userFollow, Object... objects) {
        TwitterUser tuFollowing = new TwitterUser();
        for (Object o : objects) {
            if (o instanceof TwitterUser) {
                tuFollowing = (TwitterUser) o;
            }
        }
        List<Follow> follows = tuFollowing.getFollows();
        Follow follow = new Follow();
        follow.setCreateDate(new Timestamp(System.currentTimeMillis()));
        follow.setUserFollow(userFollow);
        follow.setUserFollowing(tuFollowing);
        follows.add(follow);
        tuFollowing.setFollows(follows);
    }
}