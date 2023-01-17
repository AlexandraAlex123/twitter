package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDtO;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;

import java.sql.Timestamp;
import java.util.List;

public class PostFactory extends ValidateFactory implements ConvertDTO, Create{

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
        return postDTO;
    }


    public void createAndSave(String message, Object... objects) {
        TwitterUser tuWhoPost = new TwitterUser();
        for (Object o : objects) {
            if (o instanceof TwitterUser) {
                tuWhoPost = (TwitterUser) o;
            }
        }
        Post post = new Post();
        post.setMessage(message);
        post.setCreateDate(new Timestamp(System.currentTimeMillis()));
        post.setOnlyMe(false);
        post.setUserWhoPost(tuWhoPost);
        List<Post> posts = tuWhoPost.getPosts();
        posts.add(post);
        tuWhoPost.setPosts(posts);
    }
}
