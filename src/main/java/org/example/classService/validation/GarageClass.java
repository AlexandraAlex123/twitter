package org.example.classService.validation;

import org.example.objectClassAndRepository.model.Follow;
import org.example.objectClassAndRepository.model.TwitterUser;
import org.example.objectClassAndRepository.model.posts.Post;
import org.example.objectClassAndRepository.model.posts.Reply;
import org.example.objectClassAndRepository.repository.PostRepository;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Set;

public class GarageClass extends ValidateValue{

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

    public void createAndSaveReply(Post p, String message, String userWhoReply){
        Reply reply = new Reply(message, new Timestamp(System.currentTimeMillis()), false, userWhoReply);
        Set<Reply> replies = p.getReplies();
        replies.add(reply);
        p.setReplies(replies);
    }
}
