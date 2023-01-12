package org.example.classService.validation;

import org.example.objectClassAndRepository.model.Follow;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.model.posts.Post;
import org.example.objectClassAndRepository.repository.PostRepository;

import java.sql.Timestamp;
import java.util.Set;

public class GarageClass extends ValidateValue{

    public boolean validateUsername(String username, PostRepository pr) {
        return !username.isEmpty() && checkStringTu(username) && usernameExist(username, pr);
    }

    public void createAndSaveFollow(TwitterUser tu, String usernameFollow) {
        Follow follow = new Follow(usernameFollow, new Timestamp(System.currentTimeMillis()));
        Set<Follow> follows = tu.getFollows();
        follows.add(follow);
        tu.setFollows(follows);
    }

    public void createAndSavePost(TwitterUser tu, String message) {
        Post post = new Post(message, new Timestamp(System.currentTimeMillis()), false);
        Set<Post> posts = tu.getPosts();
        posts.add(post);
        tu.setPosts(posts);
    }
}
