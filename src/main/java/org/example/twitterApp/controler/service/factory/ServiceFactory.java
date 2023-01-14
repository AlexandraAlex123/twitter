package org.example.twitterApp.controler.service.factory;

import org.example.twitterApp.controler.service.factory.classFactory.*;
import org.example.twitterApp.objectClassAndRepository.classDtO.*;
import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.Like;
import org.example.twitterApp.objectClassAndRepository.model.Mention;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class ServiceFactory extends ValidateValueClass {


    public FactoryInterface create(String channel) {
        switch (channel) {
            case "ru":
                return new RegisterFactory();
            case "tu":
                return new TwitterFactory();
            case "post":
                return new PostFactory();
            case "follow":
                return new FollowFactory();
            case "reply":
                return new ReplyFactory();
            case "like":
                return new LikeFactory();
            case "mention":
                return new MentionFactory();
            case "postM":
                return new PostMentionDTOFactory();
            default:
                throw new IllegalArgumentException("Unknown channel " + channel);
        }
    }

    public Set<PostDtO> getListPostsDTO(List<Post> posts) {
        Set<PostDtO> postDTOs = new TreeSet<>();
        for (Post post : posts) {
            FactoryInterface uFi = create("post");
            PostDtO postDtO = (PostDtO) uFi.convertToDTO(post);
            postDTOs.add(postDtO);
        }
        return postDTOs;
    }

    public Set<FollowDtO> getListFollowsDTO(List<Follow> follows) {
        Set<FollowDtO> followDTOs = new TreeSet<>();
        for (Follow follow : follows) {
            FactoryInterface uFi = create("follow");
            FollowDtO followDTO = (FollowDtO) uFi.convertToDTO(follow);
            followDTOs.add(followDTO);
        }
        return followDTOs;
    }

    public Set<ReplyDtO> getListRepliesDTO(List<Reply> replies) {
        Set<ReplyDtO> replyDTOs = new TreeSet<>();
        for (Reply reply : replies) {
            FactoryInterface uFi = create("reply");
            ReplyDtO replyDTO = (ReplyDtO) uFi.convertToDTO(reply);
            replyDTOs.add(replyDTO);
        }
        return replyDTOs;
    }

    public Set<LikeDtO> getListLikesDTO(List<Like> likes) {
        Set<LikeDtO> likeDTOs = new TreeSet<>();
        for (Like like : likes) {
            FactoryInterface uFi = create("like");
            LikeDtO replyDTO = (LikeDtO) uFi.convertToDTO(like);
            likeDTOs.add(replyDTO);
        }
        return likeDTOs;
    }

    public Set<MentionDtO> getListMentionsDTO(List<Mention> mentions) {
        Set<MentionDtO> mentionDtOS = new TreeSet<>();
        for (Mention mention : mentions) {
            FactoryInterface uFi = create("mention");
            MentionDtO mentionDTO = (MentionDtO) uFi.convertToDTO(mention);
            mentionDtOS.add(mentionDTO);
        }
        return mentionDtOS;
    }

    public PostDTOMention createPostMentionDTO(Post post) {
        FactoryInterface uFi = create("postM");
        return (PostDTOMention) uFi.convertToDTO(post);
    }


}
