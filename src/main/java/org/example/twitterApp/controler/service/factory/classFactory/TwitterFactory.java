package org.example.twitterApp.controler.service.factory.classFactory;

import org.example.twitterApp.controler.service.factory.ServiceFactory;
import org.example.twitterApp.controler.service.factory.ValidateValueClass;
import org.example.twitterApp.objectClassAndRepository.classDtO.TwitterUserDtO;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.springframework.beans.factory.annotation.Autowired;

public class TwitterFactory extends ValidateValueClass implements FactoryInterface {

    private ServiceFactory sf = new ServiceFactory();

    @Override
    public TwitterUserDtO convertToDTO(Object o) {
        TwitterUser tu = (TwitterUser) o;
        TwitterUserDtO tuDTO = new TwitterUserDtO();
        tuDTO.setAccount(tu.getUsername());
        tuDTO.setCreateDate(getDateAndTime(tu.getCreateDate()));
        if (tu.getFollows() != null) {
            tuDTO.setYourFollows(sf.getListFollowsDTO(tu.getFollows()));
        } else {
            tuDTO.setYourFollows(null);
        }
        if (tu.getPosts() != null) {
            tuDTO.setYourPosts(sf.getListPostsDTO(tu.getPosts()));
        } else {
            tuDTO.setYourPosts(null);
        }
        if (tu.getMentions() != null) {
            tuDTO.setYourMentions(sf.getListMentionsDTO(tu.getMentions()));
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
