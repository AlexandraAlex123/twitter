package org.example.twitterApp.controler.service.factory.classFactory;

import org.example.twitterApp.controler.service.factory.ValidateValueClass;
import org.example.twitterApp.objectClassAndRepository.classDtO.FollowDtO;
import org.example.twitterApp.objectClassAndRepository.classDtO.PostDtO;
import org.example.twitterApp.objectClassAndRepository.classDtO.TwitterUserDtO;
import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.Mention;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TwitterUserFactory extends ValidateValueClass implements UserFactoryInterface {

    private FollowFactory ff;
    private PostFactory pf;

    @Override
    public TwitterUserDtO convertToDTO(Object o) {
        TwitterUser tu = (TwitterUser) o;
        TwitterUserDtO tuDTO = new TwitterUserDtO();
        tuDTO.setAccount(tu.getUsername());
        tuDTO.setCreateDate(getDateAndTime(tu.getCreateDate()));
        if (tu.getFollows() != null) {
            Set<FollowDtO> followDTO = new TreeSet<>();
            for (int i = 0; i < tu.getFollows().size(); i++) {
                followDTO.add((FollowDtO) ff.convertToDTO(tu.getFollows().get(i)));
            }
            tuDTO.setYourFollows(followDTO);
        } else {
            tuDTO.setYourFollows(null);
        }
        if (tu.getPosts() != null) {
            Set<PostDtO> postDTO = new TreeSet<>();
            for (int i = 0; i < tu.getPosts().size(); i++) {
                postDTO.add((PostDtO) ff.convertToDTO(tu.getFollows().get(i)));
            }
            tuDTO.setYourPosts(postDTO);
        } else {
            tuDTO.setYourPosts(null);
        }
        if (tu.getMentions() != null) {
            tuDTO.setYourMentions((Set<Mention>) tu.getMentions());
        } else {
            tuDTO.setYourMentions(null);
        }
        return tuDTO;
    }


//    public Set<PostDtO> getAllDTO(Set<Object> list) {
//        Set<TwitterUserDtO> tuDTOs = new TreeSet<>();
//        for (int i = 0; i < list.size(); i++) {
//            TwitterUserDtO tuDTO = new TwitterUserDtO();
//            tuDTO.setAccount(tu.getUsername());
//            tuDTO.setCreateDate(getDateAndTime(tu.getCreateDate()));
//            if (tu.getFollows() != null) {
//                tuDTO.setYourFollows(ff.createDTO(tu.getFollows()));
//            } else {
//                tuDTO.setYourFollows(null);
//            }
//            if (tu.getPosts() != null) {
//                tuDTO.setYourPosts(pf.createDTO(Collections.singleton(tu.getPosts())));
//            } else {
//                tuDTO.setYourPosts(null);
//            }
//            if (tu.getMentions() != null) {
//                tuDTO.setYourMentions(tu.getMentions());
//            } else {
//                tuDTO.setYourMentions(null);
//            }
//            tuDTOs.add(tuDTO);
//        }
//        return tuDTOs;
//    }

}
