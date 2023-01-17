package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.Mention;
import org.example.twitterApp.objectClassAndRepository.model.like.LikePost;
import org.example.twitterApp.objectClassAndRepository.model.like.LikeReply;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.PostedMessages;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.modelDTO.*;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ConvertDTOFactory extends CreateFactory {

    public ConvertDTO factory(String channel) {
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
                return new PostMentionFactory();
            case "postF":
                return new PostFeedFactory();
            default:
                throw new IllegalArgumentException("Unknown channel " + channel);
        }
    }

    public Set<PostDtO> getListPostsDTO(List<Post> posts) {
        Set<PostDtO> postDTOs = new TreeSet<>();
        for (Post post : posts) {
            ConvertDTO convertDTO = factory("post");
            PostDtO postDtO = (PostDtO) convertDTO.convertToDTO(post);
            postDTOs.add(postDtO);
        }
        return postDTOs;
    }

    public Set<ReplyDtO> getListRepliesDTO(List<Reply> replies) {
        Set<ReplyDtO> replyDTOs = new TreeSet<>();
        for (Reply reply : replies) {
            ConvertDTO convertDTO = factory("reply");
            ReplyDtO replyDtO = (ReplyDtO) convertDTO.convertToDTO(reply);
            replyDTOs.add(replyDtO);
        }
        return replyDTOs;
    }

    public Set<PostDTOFeed> getListPostsDTOF(List<Post> posts) {
        Set<PostDTOFeed> postDTOs = new TreeSet<>();
        for (Post post : posts) {
            if (!post.getOnlyMe()) {
                ConvertDTO convertDTO = factory("postF");
                PostDTOFeed postDTOFeed = (PostDTOFeed) convertDTO.convertToDTO(post);
                postDTOs.add(postDTOFeed);
            }
        }
        return postDTOs;
    }

    public Set<PostDTOFeed> getListRepliesDTOF(List<Reply> replies) {
        Set<PostDTOFeed> postDTOs = new TreeSet<>();
        for (Reply reply : replies) {
            if (!reply.getOnlyMe()) {
                ConvertDTO convertDTO = factory("postF");
                PostDTOFeed postDTOFeed = (PostDTOFeed) convertDTO.convertToDTO(reply);
                postDTOs.add(postDTOFeed);
            }
        }
        return postDTOs;
    }

    public Set<LikeDtO> getListLikesPostDTO(List<LikePost> likes) {
        Set<LikeDtO> likeDTOs = new TreeSet<>();
        for (LikePost likePost : likes) {
            ConvertDTO convertDTO = factory("like");
            LikeDtO likeDtO = (LikeDtO) convertDTO.convertToDTO(likePost);
            likeDTOs.add(likeDtO);
        }
        return likeDTOs;
    }

    public Set<LikeDtO> getListLikesReplyDTO(List<LikeReply> likes) {
        Set<LikeDtO> likeDTOs = new TreeSet<>();
        for (LikeReply likeReply : likes) {
            ConvertDTO convertDTO = factory("like");
            LikeDtO likeDtO = (LikeDtO) convertDTO.convertToDTO(likeReply);
            likeDTOs.add(likeDtO);
        }
        return likeDTOs;
    }

    public Set<FollowDtO> getListFollowsDTO(List<Follow> follows) {
        Set<FollowDtO> followDTOs = new TreeSet<>();
        for (Follow follow : follows) {
            ConvertDTO convertDTO = factory("follow");
            FollowDtO followDtO = (FollowDtO) convertDTO.convertToDTO(follow);
            followDTOs.add(followDtO);
        }
        return followDTOs;
    }

    public Set<MentionDtO> getListMentionsDTO(List<Mention> mentions) {
        Set<MentionDtO> mentionDtOS = new TreeSet<>();
        for (Mention mention : mentions) {
            mentionDtOS.add(createMentionDTO(mention));
        }
        return mentionDtOS;
    }

    public MentionDtO createMentionDTO(Mention mention) {
        ConvertDTO convertDTO = factory("mention");
        return (MentionDtO) convertDTO.convertToDTO(mention);
    }

    public PostDTOMention createPostMentionDTO(PostedMessages postedMessages) {
        ConvertDTO convertDTO = factory("postM");
        return (PostDTOMention) convertDTO.convertToDTO(postedMessages);
    }
}
