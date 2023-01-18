package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.like.LikePost;
import org.example.twitterApp.objectClassAndRepository.model.like.LikeReply;
import org.example.twitterApp.objectClassAndRepository.model.mention.MentionPost;
import org.example.twitterApp.objectClassAndRepository.model.mention.MentionReply;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

import javax.transaction.Transactional;

@Transactional
public class CreateFactory {

    public Create create(String channel) {
        switch (channel) {
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
            case "mentionP":
                return new MentionPostFactory();
            case "mentionR":
                return new MentionReplyFactory();
            default:
                throw new IllegalArgumentException("Unknown channel " + channel);
        }
    }

    public Follow createAndSaveFollow(String userFollow, TwitterUser tuFollowing) {
        Create create = create("follow");
        return (Follow) create.createAndSave(userFollow, tuFollowing);
    }

    public Post createAndSavePost(String message, TwitterUser tuWhoPost) {
        Create create = create("post");
        return (Post) create.createAndSave(message, tuWhoPost);
    }

    public Reply createAndSaveReply(String message, TwitterUser tuWhoPost, Post post) {
        Create create = create("reply");
        return (Reply) create.createAndSave(message, tuWhoPost, post);
    }

    public Reply createAndSaveReplyReply(String message, TwitterUser tuWhoReply, Reply reply) {
        Create create = create("reply");
        return (Reply) create.createAndSave(message, tuWhoReply, reply);
    }

    public LikePost createAndSaveLikePost(TwitterUser tuMention, Post post) {
        Create create = create("likeP");
        return (LikePost) create.createAndSave(tuMention, post);
    }

    public LikeReply createAndSaveLikeReply(TwitterUser tuMention, Reply reply) {
        Create create = create("likeR");
        return (LikeReply) create.createAndSave(tuMention, reply);
    }

    public MentionPost createAndSaveMentionPost(TwitterUser tuMention, Post post) {
        Create create = create("mentionP");
        return (MentionPost) create.createAndSave(tuMention, post);
    }

    public MentionReply createAndSaveMentionReply(TwitterUser tuMention, Reply reply) {
        Create create = create("mentionR");
        return (MentionReply) create.createAndSave(tuMention, reply);
    }

}
