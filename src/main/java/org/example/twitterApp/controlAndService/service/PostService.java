package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.controlAndService.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
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

    public String addPostReply(Long id, String message, String userWhoPost) {
        if (id != null && !message.isEmpty() && !userWhoPost.isEmpty()) {
            if (!message.equals(" ") && checkStringTu(userWhoPost)) {
                Post post = pR.findPostById(id);
                createAndSaveReply(message, tus.getUserByUsername(userWhoPost), post);
                return "Comment add";
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }

    public String addLikePost(Long id, String userWhoGivesLike) {
        if (id != null && !userWhoGivesLike.isEmpty()) {
            if (checkStringTu(userWhoGivesLike)) {
                if (tus.usernameExists(userWhoGivesLike)) {
                    Post post = pR.findPostById(id);
                    TwitterUser tuWhoGivesLike = tus.getUserByUsername(userWhoGivesLike);
                    createAndSaveLike(post, tuWhoGivesLike);
                } else {
                    return "User Not Found";
                }
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }

    public String addMentionPost(String userMention) {
        if (!userMention.isEmpty()) {
            if (checkStringTu(userMention)) {
                if (tus.usernameExists(userMention)) {
                    List<Post> posts = pR.findMentionPosts(userMention);
                    for (Post post : posts) {
                        if (!alreadyMention(post, tus.getUserByUsername(userMention))) {
                            createAndSaveMentionPost(post.getUserWhoPost().getUsername(), tus.getUserByUsername(userMention), post);
                            return post.getUserWhoPost().getUsername() + " mention " + userMention + " in a post";
                        }else {
                            return "Notification already send";
                        }
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


    public Set<PostDTOFeed> getFallowPosts(String username) {
        Set<PostDTOFeed> postsDTOFeed = new TreeSet<>();
        if (tus.validUsername(username)) {
            List<Post> posts = pR.findAllByUsername(username);
            postsDTOFeed = getListPostsDTOF(posts);
            return postsDTOFeed;
        }
        return postsDTOFeed;
    }

}
