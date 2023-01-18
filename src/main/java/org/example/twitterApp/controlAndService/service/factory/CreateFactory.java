package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
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

    public void createAndSaveFollow(String userFollow, TwitterUser tuFollowing) {
        Create create = create("follow");
        create.createAndSave(userFollow, tuFollowing);
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

    public void createAndSaveLikePost(TwitterUser tuMention, Post post) {
        Create create = create("likeP");
        create.createAndSave(tuMention, post);
    }

    public void createAndSaveLikeReply(TwitterUser tuMention, Reply reply) {
        Create create = create("likeR");
        create.createAndSave(tuMention, reply);
    }

    public void createAndSaveMentionPost(TwitterUser tuMention, Post post) {
        Create create = create("mentionP");
        create.createAndSave(tuMention, post);
    }

    public void createAndSaveMentionReply(TwitterUser tuMention, Reply reply) {
        Create create = create("mentionR");
        create.createAndSave(tuMention, reply);
    }

}
