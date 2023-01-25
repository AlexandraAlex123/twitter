package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.modelDTO.FollowDtO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FollowFactory extends ValidateFactory implements ConvertDTO, Create {

    @Override
    public Follow createAndSave(Object... objects) {
        TwitterUser tuFollowing = new TwitterUser();
        String userFollow = null;
        for (Object o : objects) {
            if (o instanceof TwitterUser) {
                tuFollowing = (TwitterUser) o;
            } else if (o instanceof String) {
                userFollow = (String) o;
            }
        }

        Follow follow = new Follow();
        follow.setCreateDate(new Timestamp(System.currentTimeMillis()));
        follow.setUserFollow(userFollow);
        follow.setUserFollowing(tuFollowing);
        List<Follow> follows = new ArrayList<>();
        if (tuFollowing.getFollows() != null) {
            follows = tuFollowing.getFollows();
        }
        follows.add(follow);
        tuFollowing.setFollows(follows);
        return follow;
    }

    @Override
    public FollowDtO convertToDTO(Object o) {
        Follow follow = (Follow) o;
        FollowDtO followDTO = new FollowDtO();
        followDTO.setUsernameFollow(follow.getUserFollow());
        followDTO.setCreateDate(getDateAndTime(follow.getCreateDate()));
        return followDTO;
    }
}