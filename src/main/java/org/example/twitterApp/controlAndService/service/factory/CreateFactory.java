package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.like.LikePost;
import org.example.twitterApp.objectClassAndRepository.model.like.LikeReply;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.repository.ReplyRepository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Transactional
public class CreateFactory {

    public Create create(String channel) {
        switch (channel) {
            case "post":
                return new PostFactory();
            case "reply":
                return new ReplyFactory();
            case "follow":
                return new FollowFactory();
            case "mention":
                return new MentionFactory();
            default:
                throw new IllegalArgumentException("Unknown channel " + channel);
        }
    }

    public void createAndSavePost(String message, TwitterUser tuWhoPost) {
        Create create = create("post");
        create.createAndSave(message, tuWhoPost);
    }

    public void createAndSaveReply(String message, TwitterUser tuWhoPost, Post post) {
        Create create = create("reply");
        create.createAndSave(message, tuWhoPost, post);
    }

    public void createAndSaveReplyReply(String message, TwitterUser tuWhoReply, Reply reply) {
        Create create = create("reply");
        create.createAndSave(message, tuWhoReply, reply);
    }

    public void createAndSaveFollow(String userFollow, TwitterUser tuFollowing) {
        Create create = create("follow");
        create.createAndSave(userFollow, tuFollowing);
    }

    public void createAndSaveMentionPost(String userMentioning, TwitterUser tuMention, Post post) {
        Create create = create("mention");
        create.createAndSave(userMentioning, tuMention, post);
    }

    public void createAndSaveMentionReply(String userMentioning, TwitterUser tuMention, Reply reply) {
        Create create = create("mention");
        create.createAndSave(userMentioning, tuMention, reply);
    }

    public void createAndSaveLike(Object o, TwitterUser tuWhoGivesLike) {
        if (o instanceof Post) {
            Post post = (Post) o;
            LikePost likePost = new LikePost();
            likePost.setCreateDate(new Timestamp(System.currentTimeMillis()));
            likePost.setWhoGivesLike(tuWhoGivesLike);
            likePost.setPostLike(post);
            List<LikePost> likes = post.getLikes();
            likes.add(likePost);
            post.setLikes(likes);
        } else if (o instanceof Reply) {
            Reply reply = (Reply) o;
            LikeReply likeReply = new LikeReply();
            likeReply.setCreateDate(new Timestamp(System.currentTimeMillis()));
            likeReply.setWhoGivesLike(tuWhoGivesLike);
            likeReply.setReplyLike(reply);
            List<LikeReply> likes = reply.getLikes();
            likes.add(likeReply);
        }
    }
}
