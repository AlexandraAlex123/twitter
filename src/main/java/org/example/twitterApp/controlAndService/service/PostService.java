package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.controlAndService.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.like.LikePost;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOFeed;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDtO;
import org.example.twitterApp.objectClassAndRepository.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


@Service
@Transactional
public class PostService extends ValidateFactory {


    @Autowired
    private MentionService ms;

    @Autowired
    private TwitterUserService tus;

    @Autowired
    private ReplyService rs;

    @Autowired
    private PostRepository pR;


    public Set<PostDtO> searchOnlyUserPosts(String username) {
        Set<PostDtO> postDTOs = new TreeSet<>();
        if (tus.validUsername(username)) {
            List<Post> posts = pR.findAllByUsername(username);
            postDTOs = getListPostsDTO(posts);
            return postDTOs;
        }
        return postDTOs;
    }

    public Set<PostDTOFeed> getFeeds(String username) {
        Set<PostDTOFeed> allFollowPost = new TreeSet<>();
        if (tus.validUsername(username)) {
            TwitterUser tu = tus.getUserByUsername(username);
            List<Follow> follows = tu.getFollows();
            for (Follow f : follows) {
                Set<PostDTOFeed> followPosts = getFallowPosts(f.getUserFollow());
                allFollowPost.addAll(followPosts);
            }
            return allFollowPost;
        }
        return allFollowPost;
    }

    public String addPostReply(Long id, String message, String userWhoReply) {
        if (id != null && message != null && userWhoReply != null) {
            if (!message.equals(" ") && checkStringTu(userWhoReply)) {
                if (tus.usernameExists(userWhoReply)) {
                    if (postExists(id)) {
                        Post post = pR.findPostById(id);
                        Reply reply = createAndSaveReply(message, tus.getUserByUsername(userWhoReply), post);
                        if (message.contains("@")) {
                            return addMentionReply(tus.getUserByUsername(userWhoReply), reply);
                        } else {
                            return "Comment add";
                        }
                    } else {
                        return "Post not found";
                    }
                } else {
                    return "User not found";
                }
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }

    public String addMentionReply(TwitterUser tuWhoReply, Reply reply) {
        if (tuWhoReply.getFollows() != null) {
            List<Follow> follows = tuWhoReply.getFollows();
            Set<String> followMentionS = new TreeSet<>();
            for (Follow f : follows) {
                if (reply.getMessage().contains("@" + f.getUserFollow())) {
                    TwitterUser tuMention = tus.getUserByUsername(f.getUserFollow());
                    createAndSaveMentionReply(tuMention, reply);
                    followMentionS.add(f.getUserFollow());
                }
            }
            return "Comment add. You mention in this reply " + followMentionS;
        }
        return "Comment add";
    }

    public String addLikePost(Long id, String userWhoGivesLike) {
        if (id != null && userWhoGivesLike != null) {
            if (checkStringTu(userWhoGivesLike)) {
                if (tus.usernameExists(userWhoGivesLike)) {
                    Post post = pR.findPostById(id);
                    if (postExists(id)) {
                        if (!alreadyLike(tus.getUserByUsername(userWhoGivesLike), post)) {
                            TwitterUser tuWhoGivesLike = tus.getUserByUsername(userWhoGivesLike);
                            createAndSaveLikePost(tuWhoGivesLike, post);
                            return "Like send";
                        }else{
                            return "Already liked";
                        }
                    } else {
                        return "Post not found";
                    }
                } else {
                    return "User not found";
                }
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }

    public Set<PostDtO> filterPostsByDate(Set<PostDtO> postDTOs, Timestamp ts, Timestamp ts2) {
        if (ts != null && ts2 != null) {
            Set<PostDtO> filterPosts = new TreeSet<>();
            for (PostDtO postDTO : postDTOs) {
                if (postDTO.getCreateDate().compareTo(getDateAndTime(ts)) <= -1 && postDTO.getCreateDate().compareTo(getDateAndTime(ts2)) >= 1) {
                    filterPosts.add(postDTO);
                }
            }
            return filterPosts;
        }
        return null;
    }

    public boolean alreadyLike(TwitterUser tuWhoGivesLike, Post post) {
        if (post.getLikes() != null) {
            List<LikePost> likePosts = post.getLikes();
            for (LikePost l : likePosts) {
                return l.getWhoGivesLike().equals(tuWhoGivesLike);
            }
        }
        return false;
    }

    public Set<PostDTOFeed> getFallowPosts(String username) {
        Set<PostDTOFeed> postsDTOFeed = new TreeSet<>();
        if (tus.validUsername(username)) {
            List<Post> posts = pR.findAllByUsername(username);
            postsDTOFeed = getListPostsDTOF(posts);
            return postsDTOFeed;
        }
        return postsDTOFeed;
    }

    public boolean postExists(Long id) {
        return pR.findPostById(id) != null;
    }
}
