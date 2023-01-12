package org.example.classService.validation;

import org.example.classService.service.classDtO.FollowDtO;
import org.example.classService.service.classDtO.PostDtO;
import org.example.classService.service.classDtO.RegisterUserDtO;
import org.example.classService.service.classDtO.TwitterUserDtO;
import org.example.objectClassAndRepository.model.Follow;
import org.example.objectClassAndRepository.model.RegisterUser;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.model.posts.Post;

import java.util.Set;
import java.util.TreeSet;

public class DtOService extends GarageClass{

    public Set<RegisterUserDtO> getListOfUserDtO(Set<RegisterUser> ruS) {
        Set<RegisterUserDtO> ruDTOs = new TreeSet<>();
        for (RegisterUser ru : ruS) {
            RegisterUserDtO ruDTO;
            if (ru.getTwitterUser() != null) {
                ruDTO = new RegisterUserDtO(ru.getFirstName(), ru.getLastName(), ru.getTwitterUser().getUsername(), getLocalDate(ru.getCreateDate()));
            } else {
                ruDTO = new RegisterUserDtO(ru.getFirstName(), ru.getLastName(), "Not created", getLocalDate(ru.getCreateDate()));
            }
            ruDTOs.add(ruDTO);
        }
        return ruDTOs;
    }

    public Set<TwitterUserDtO> getAllTwitterUserDTO(Set<TwitterUser> tuS) {
        Set<TwitterUserDtO> tuDTOs = new TreeSet<>();
        for (TwitterUser tu : tuS) {
            TwitterUserDtO tuDTO = new TwitterUserDtO();
            tuDTO.setAccount(tu.getUsername());
            tuDTO.setCreateDate(getLocalDate(tu.getCreateDate()));
            if (tu.getFollows() != null) {
                tuDTO.setYourFollows(getAllFollowsDTO(tu.getFollows()));
            } else {
                tuDTO.setYourFollows(null);
            }
            if (tu.getPosts() != null) {
                tuDTO.setYourPosts(getAllPostsDTO(tu.getPosts()));
            } else {
                tuDTO.setYourPosts(null);
            }
            if (tu.getMentions() != null) {
                tuDTO.setYourMentions(tu.getMentions());
            } else {
                tuDTO.setYourMentions(null);
            }
            tuDTOs.add(tuDTO);
        }
        return tuDTOs;
    }

    public Set<FollowDtO> getAllFollowsDTO(Set<Follow> follows) {
        Set<FollowDtO> followDtOS = new TreeSet<>();
        for (Follow f : follows) {
            followDtOS.add(new FollowDtO(f.getUsernameFollowed(), getLocalDate(f.getCreateDate())));
        }
        return followDtOS;
    }

    public Set<PostDtO> getAllPostsDTO(Set<Post> posts) {
        Set<PostDtO> postsDTO = new TreeSet<>();
        for (Post p : posts) {
            if (p.getLikes().isEmpty()) {
                postsDTO.add(new PostDtO(p.getMessage(), getLocalDate(p.getCreateDate()), p.getOnlyMe(), p.getReplies(), null));
            } else if (p.getReplies().isEmpty()) {
                postsDTO.add(new PostDtO(p.getMessage(), getLocalDate(p.getCreateDate()), p.getOnlyMe(), null, p.getLikes()));
            } else if (p.getLikes().isEmpty() && p.getReplies().isEmpty()) {
                postsDTO.add(new PostDtO(p.getMessage(), getLocalDate(p.getCreateDate()), p.getOnlyMe(), p.getReplies(), p.getLikes()));
            } else if (p.getLikes() != null && p.getReplies() != null) {
                postsDTO.add(new PostDtO(p.getMessage(), getLocalDate(p.getCreateDate()), p.getOnlyMe(), null, null));
            }
        }
        return postsDTO;
    }
}
