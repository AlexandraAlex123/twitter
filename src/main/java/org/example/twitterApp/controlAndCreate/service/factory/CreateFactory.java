package org.example.twitterApp.controlAndCreate.service.factory;


import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.like.Like;
import org.example.twitterApp.objectClassAndRepository.model.mention.Mention;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.PostedMessages;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.modelDTO.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class CreateFactory {


    public Factory create(String channel) {
        switch (channel) {
            case "ru":
                return new RegisterUserFactory();
            case "tu":
                return new TwitterUserFactory();
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
                return new PostDTOMentionFactory();
            case "postF":
                return new PostDTOFeedFactory();
            default:
                throw new IllegalArgumentException("Unknown channel " + channel);
        }
    }

    public Set<PostDtO> getListPostsDTO(List<Post> posts) {
        Set<PostDtO> postDTOs = new TreeSet<>();
        for (Post post : posts) {
            Factory uFi = create("post");
            PostDtO postDtO = (PostDtO) uFi.convertToDTO(post);
            postDTOs.add(postDtO);
        }
        return postDTOs;
    }

    public Set<PostDTOFeed> getListPostsDTOF(List<Post> posts) {
        Set<PostDTOFeed> postDTOs = new TreeSet<>();
        for (Post post : posts) {
            Factory uFi = create("postF");
            PostDTOFeed postDTOFeed = (PostDTOFeed) uFi.convertToDTO(post);
            postDTOs.add(postDTOFeed);
        }
        return postDTOs;
    }

    public Set<PostDTOFeed> getListRepliesDTOF(List<Reply> replies) {
        Set<PostDTOFeed> postDTOs = new TreeSet<>();
        for (Reply reply : replies) {
            Factory uFi = create("postF");
            PostDTOFeed postDTOFeed = (PostDTOFeed) uFi.convertToDTO(reply);
            postDTOs.add(postDTOFeed);
        }
        return postDTOs;
    }

    public Set<FollowDtO> getListFollowsDTO(List<Follow> follows) {
        Set<FollowDtO> followDTOs = new TreeSet<>();
        for (Follow follow : follows) {
            Factory uFi = create("follow");
            FollowDtO followDTO = (FollowDtO) uFi.convertToDTO(follow);
            followDTOs.add(followDTO);
        }
        return followDTOs;
    }

    public Set<ReplyDtO> getListRepliesDTO(List<Reply> replies) {
        Set<ReplyDtO> replyDTOs = new TreeSet<>();
        for (Reply reply : replies) {
            Factory uFi = create("reply");
            ReplyDtO replyDTO = (ReplyDtO) uFi.convertToDTO(reply);
            replyDTOs.add(replyDTO);
        }
        return replyDTOs;
    }

    public Set<LikeDtO> getListLikesDTO(List<Like> likes) {
        Set<LikeDtO> likeDTOs = new TreeSet<>();
        for (Like like : likes) {
            Factory uFi = create("like");
            LikeDtO likeDTO = (LikeDtO) uFi.convertToDTO(like);
            likeDTOs.add(likeDTO);
        }
        return likeDTOs;
    }


    public Set<MentionDtO> getListMentionsDTO(List<Mention> mentions) {
        Set<MentionDtO> mentionDtOS = new TreeSet<>();
        for (Mention mention : mentions) {
            Factory uFi = create("mention");
            MentionDtO mentionDTO = (MentionDtO) uFi.convertToDTO(mention);
            mentionDtOS.add(mentionDTO);
        }
        return mentionDtOS;
    }


    public PostDTOMention createPostMentionDTO(PostedMessages postedMessages) {
        Factory uFi = create("postM");
        return (PostDTOMention) uFi.convertToDTO(postedMessages);
    }


}
