package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.controlAndService.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
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

    public Set<PostDTOFeed> getNewFeeds(String username) {
        Set<PostDTOFeed> postDTOFs = new TreeSet<>();
        if (tus.validUsername(username)) {
            TwitterUser tu = tus.getUserByUsername(username);
            Timestamp ts = tu.getLastLogin();
            postDTOFs = filterPostsByDate(getFallowsPosts(tu), ts, new Timestamp(System.currentTimeMillis()));
            return postDTOFs;
        }
        return postDTOFs;
    }

    public Set<PostDTOFeed> getFeeds(String username) {
        Set<PostDTOFeed> allFollowPost = new TreeSet<>();
        if (tus.validUsername(username)) {
            TwitterUser tu = tus.getUserByUsername(username);
            allFollowPost = getFallowsPosts(tu);
            return allFollowPost;
        }
        return allFollowPost;
    }

    public String addPostReply(Long id, String message, String userWhoReply) {
        if (id != null && message != null && userWhoReply != null) {
            if (!message.equals(" ") && checkStringTu(userWhoReply)) {
                if (tus.usernameExists(userWhoReply)) {
                    if (postExists(id)) {
                        Post post = getPostById(id);
                        Reply reply = createAndSaveReply(message, tus.getUserByUsername(userWhoReply), post);
                        if (message.contains("@")) {
                            return rs.addMentionReply(tus.getUserByUsername(userWhoReply), reply);
                        }
                        return "Comment add";
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

    public String addLikePost(Long id, String userWhoGivesLike) {
        if (id != null && userWhoGivesLike != null) {
            if (checkStringTu(userWhoGivesLike)) {
                if (tus.usernameExists(userWhoGivesLike)) {
                    Post post = getPostById(id);
                    if (postExists(id)) {
                        if (!alreadyLike(tus.getUserByUsername(userWhoGivesLike), post)) {
                            TwitterUser tuWhoGivesLike = tus.getUserByUsername(userWhoGivesLike);
                            createAndSaveLikePost(tuWhoGivesLike, post);
                            return "Like send";
                        } else {
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

    public String makeAPostNotPublic(Long id) {
        if (id != null) {
            if (postExists(id)) {
                Post post = getPostById(id);
                post.setOnlyMe(true);
                if (post.getReplies().size() > 0) {
                    post.getReplies().get(0).setOnlyMe(true);
                    if (post.getReplies().get(0).getReplies().size() > 0) {
                        post.getReplies().get(0).getReplies().get(0).setOnlyMe(true);
                    }
                }
                return "Post not public";
            } else {
                return "Post not found";
            }
        }
        return "Null parameter";
    }

    public String deletePost(Long id) {
        if (id != null) {
            if (postExists(id)) {
                pR.deleteById(id);
                return "Post deleted";
            } else {
                return "Post not found";
            }
        }
        return "Null parameter";
    }

    public Set<PostDTOFeed> filterPostsByDate(Set<PostDTOFeed> posts, Timestamp ts, Timestamp ts2) {
        Set<PostDTOFeed> filterPosts = new TreeSet<>();
        for (PostDTOFeed post : posts) {
            if (post.getCreateDate().compareTo(getDateAndTime(ts)) <= -1 && post.getCreateDate().compareTo(getDateAndTime(ts2)) >= 1) {
                filterPosts.add(post);
            }
        }
        return filterPosts;
    }

    public Set<PostDTOFeed> getFallowsPosts(TwitterUser tu) {
        Set<PostDTOFeed> followPosts = new TreeSet<>();
        if (tu.getFollows() != null) {
            List<Follow> follows = tu.getFollows();
            for (Follow f : follows) {
                List<Post> posts = pR.findAllByUsernamePublic(f.getUserFollow());
                followPosts.addAll(getListPostsDTOF(posts));
            }
        }
        return followPosts;
    }

    public Post getPostById(Long id) {
        return pR.findPostById(id);
    }

    public boolean postExists(Long id) {
        return pR.findPostById(id) != null;
    }
}
