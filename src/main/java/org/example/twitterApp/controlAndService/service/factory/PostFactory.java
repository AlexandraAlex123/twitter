package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDtO;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PostFactory extends ValidateFactory implements ConvertDTO, Create {

    public Post createAndSave(Object... objects) {
        TwitterUser tuWhoPost = new TwitterUser();
        String message = null;
        for (Object o : objects) {
            if (o instanceof TwitterUser) {
                tuWhoPost = (TwitterUser) o;
            } else if (o instanceof String) {
                message = (String) o;
            }

        }
        Post post = new Post();
        post.setMessage(message);
        post.setCreateDate(new Timestamp(System.currentTimeMillis()));
        post.setOnlyMe(false);
        post.setUserWhoPost(tuWhoPost);
        List<Post> posts = new ArrayList<>();
        if (tuWhoPost.getPosts() != null) {
            posts = tuWhoPost.getPosts();
        }
        posts.add(post);
        tuWhoPost.setPosts(posts);
        return post;
    }

    @Override
    public PostDtO convertToDTO(Object o) {
        Post post = (Post) o;
        PostDtO postDTO = new PostDtO();
        postDTO.setMessage(post.getMessage());
        postDTO.setCreateDate(getDateAndTime(post.getCreateDate()));
        postDTO.setOnlyMe(post.getOnlyMe());
        if (post.getLikes() != null) {
            postDTO.setPostLikes(getListLikesPostDTO(post.getLikes()));
        } else {
            postDTO.setPostLikes(null);
        }
        if (post.getReplies() != null) {
            postDTO.setPostReplies(getListRepliesDTOF(post.getReplies()));
        } else {
            postDTO.setPostReplies(null);
        }
        if (post.getMentions() != null) {
            postDTO.setMentionPost(getListMentionPostDTO(post.getMentions()));
        }
        return postDTO;
    }


}
