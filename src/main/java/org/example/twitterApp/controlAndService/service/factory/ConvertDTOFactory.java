package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.like.LikePost;
import org.example.twitterApp.objectClassAndRepository.model.like.LikeReply;
import org.example.twitterApp.objectClassAndRepository.model.like.modelDTO.*;
import org.example.twitterApp.objectClassAndRepository.model.mention.MentionPost;
import org.example.twitterApp.objectClassAndRepository.model.mention.MentionReply;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

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
            case "follow":
                return new FollowFactory();
            case "post":
                return new PostFactory();
            case "reply":
                return new ReplyFactory();
            case "likeP":
                return new LikePostFactory();
            case "likeR":
                return new LikeReplyFactory();
            case "mention":
                return new MentionForPostFactory();
            case "mentionP":
                return new MentionPostFactory();
            case "mentionR":
                return new MentionReplyFactory();
            case "postF":
                return new PostFeedFactory();
            case "postM":
                return new PostsMentionFactory();
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
        Set<PostDTOFeed> postDTOFs = new TreeSet<>();
        for (Post post : posts) {
            PostDTOFeed postDTOF = createPostDTOF(post);
            postDTOFs.add(postDTOF);
        }
        return postDTOFs;
    }

    public  PostDTOFeed createPostDTOF(Post post){
        ConvertDTO convertDTO = factory("postF");
        return (PostDTOFeed) convertDTO.convertToDTO(post);
    }

    public PostsMentionDTO getPostMentionDTO(Post post) {
        ConvertDTO convertDTO = factory("postM");
        return (PostsMentionDTO) convertDTO.convertToDTO(post);
    }

    public PostsMentionDTO getPostMentionDTO(Reply reply) {
        ConvertDTO convertDTO = factory("postM");
        return (PostsMentionDTO) convertDTO.convertToDTO(reply);
    }

    public Set<LikeDtO> getListLikesPostDTO(List<LikePost> likes) {
        Set<LikeDtO> likeDTOs = new TreeSet<>();
        for (LikePost likePost : likes) {
            ConvertDTO convertDTO = factory("likeP");
            LikeDtO likeDtO = (LikeDtO) convertDTO.convertToDTO(likePost);
            likeDTOs.add(likeDtO);
        }
        return likeDTOs;
    }

    public Set<LikeDtO> getListLikesReplyDTO(List<LikeReply> likes) {
        Set<LikeDtO> likeDTOs = new TreeSet<>();
        for (LikeReply likeReply : likes) {
            ConvertDTO convertDTO = factory("likeR");
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

    public Set<MentionForPostDTO> getListMentionForPostDTO(List<MentionPost> mentions) {
        Set<MentionForPostDTO> mentionDtOS = new TreeSet<>();
        for (MentionPost mentionPost : mentions) {
            ConvertDTO convertDTO = factory("mention");
            MentionForPostDTO mentionDtO = (MentionForPostDTO) convertDTO.convertToDTO(mentionPost);
            mentionDtOS.add(mentionDtO);
        }
        return mentionDtOS;
    }

    public Set<MentionForPostDTO> getListMentionForReplyDTO(List<MentionReply> mentions) {
        Set<MentionForPostDTO> mentionDtOS = new TreeSet<>();
        for (MentionReply mentionReply : mentions) {
            ConvertDTO convertDTO = factory("mention");
            MentionForPostDTO mentionDtO = (MentionForPostDTO) convertDTO.convertToDTO(mentionReply);
            mentionDtOS.add(mentionDtO);
        }
        return mentionDtOS;
    }

    public Set<MentionDtO> getListMentionPostDTO(List<MentionPost> mentionPs) {
        Set<MentionDtO> mentionDtOS = new TreeSet<>();
        for (MentionPost mentionP : mentionPs) {
            ConvertDTO convertDTO = factory("mentionP");
            MentionDtO mentionDtO = (MentionDtO) convertDTO.convertToDTO(mentionP);
            mentionDtOS.add(mentionDtO);
        }
        return mentionDtOS;
    }

    public Set<MentionDtO> getListMentionReplyDTO(List<MentionReply> mentionRs) {
        Set<MentionDtO> mentionDtOS = new TreeSet<>();
        for (MentionReply mentionR : mentionRs) {
            ConvertDTO convertDTO = factory("mentionR");
            MentionDtO mentionDtO = (MentionDtO) convertDTO.convertToDTO(mentionR);
            mentionDtOS.add(mentionDtO);
        }
        return mentionDtOS;
    }

}
