package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.controlAndService.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.Mention;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOMention;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class MentionService extends ValidateFactory {

//    public Set<PostDTOMention> getMentionsPosts(String userMention, String userMentioning) {
//        Set<PostDTOMention> postDTOMs = new TreeSet<>();
//        if (tus.validUsername(userMention) && tus.validUsername(userMentioning)) {
//            List<Post> posts = pR.findMentionPosts(userMention);
//            for (Post p : posts) {
//                if (p.getMentions().get(0).getUserMention().getUsername().equals(userMention) && p.getMentions().get(0).getUserMentioning().equals(userMentioning)) {
//                    PostDTOMention postDTOM = createPostMentionDTO(p);
//                    postDTOMs.add(postDTOM);
//                }
//            }
//            return postDTOMs;
//        }
//        return postDTOMs;
//    }



}
