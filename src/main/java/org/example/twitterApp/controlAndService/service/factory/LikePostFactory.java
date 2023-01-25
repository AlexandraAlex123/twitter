package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.like.LikePost;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.like.modelDTO.LikeDtO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LikePostFactory extends ValidateFactory implements ConvertDTO, Create {

    @Override
    public LikePost createAndSave(Object... objects) {
        TwitterUser tuWhoGivesLike = new TwitterUser();
        Post post = new Post();
        for (Object o : objects) {
            if (o instanceof TwitterUser) {
                tuWhoGivesLike = (TwitterUser) o;
            } else if (o instanceof Post) {
                post = (Post) o;
            }
        }
        LikePost likePost = new LikePost();
        likePost.setCreateDate(new Timestamp(System.currentTimeMillis()));
        likePost.setWhoGivesLike(tuWhoGivesLike);
        likePost.setPostLike(post);
        List<LikePost> likes = new ArrayList<>();
        if (post.getLikes() != null) {
            likes = post.getLikes();
        }
        likes.add(likePost);
        post.setLikes(likes);
        return likePost;
    }

    @Override
    public LikeDtO convertToDTO(Object o) {
        LikeDtO likeDTO = new LikeDtO();
        LikePost likePost = (LikePost) o;
        likeDTO.setWhoGivesLike(likePost.getWhoGivesLike().getUsername());
        likeDTO.setCreateDate(getDateAndTime(likePost.getCreateDate()));
        return likeDTO;
    }

}
