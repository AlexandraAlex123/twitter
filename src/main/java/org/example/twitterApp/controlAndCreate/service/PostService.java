package org.example.twitterApp.controlAndCreate.service;

import org.example.twitterApp.controlAndCreate.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.Follow;
import org.example.twitterApp.objectClassAndRepository.model.TwitterUser;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOFeed;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOMention;
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

    private final TwitterUserService tus;

    @Autowired
    private final PostRepository pR;

    public PostService(TwitterUserService tus, PostRepository pR) {
        this.tus = tus;
        this.pR = pR;
    }

    public Set<PostDtO> searchOnlyUserPosts(String username) {
        Set<PostDtO> postDTOs = new TreeSet<>();
        if (tus.validUsername(username)) {
            List<Post> posts = pR.findAllByUsername(username);
            postDTOs = getListPostsDTO(posts);
            return postDTOs;
        }
        return postDTOs;
    }

    public Set<PostDTOFeed> getFollowsPosts(String username) {
        Set<PostDTOFeed> allFollowPost = new TreeSet<>();
        if (tus.validUsername(username)) {
            TwitterUser tu = tus.getUserByUsername(username);
            List<Follow> follows = tu.getFollows();
            for (Follow f : follows) {
                Set<PostDTOFeed> followPosts = searchFeedPosts(f.getUserFollow().getUsername());
                allFollowPost.addAll(followPosts);
            }
            return allFollowPost;
        }
        return allFollowPost;
    }

    public Set<PostDTOFeed> searchFeedPosts(String username) {
        Set<PostDTOFeed> postsDTOFeed = new TreeSet<>();
        if (tus.validUsername(username)) {
            List<Post> posts = pR.findAllByUsername(username);
            postsDTOFeed = getListPostsDTOF(posts);
            return postsDTOFeed;
        }
        return postsDTOFeed;
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

    public String addReplyPost(Long id, String message, String userWhoPost) {
        if (id != null && !message.isEmpty() && !userWhoPost.isEmpty()) {
            if (!message.equals(" ") && checkStringTu(userWhoPost)) {
                Post post = pR.findPostById(id);
                createAndSaveReply(post, message, tus.getUserByUsername(userWhoPost));
                return "Comment add";
            } else {
                return "Invalid command";
            }
        }
        return "Null parameter";
    }

//    public String addMention(Long idPost, String userMention, String userMentioning) {
//        if (idPost != null && !userMention.isEmpty() && !userMentioning.isEmpty()) {
//            if (checkStringTu(userMention) && checkStringTu(userMentioning)) {
//                if (tus.usernameExists(userMention) && tus.usernameExists(userMentioning)) {
//                    Post post = pR.findPostById(idPost);
//                    if (post != null) {
//                        createAndSaveMention(post, tus.getUserByUsername(userMention), tus.getUserByUsername(userMentioning));
//                        return userMentioning + " mention " + userMention + " in a post";
//                    }else if()
//                }
//            }
//        }
//    }

    public Set<PostDTOMention> getMentionsPosts(String userMention, String userMentioning) {
        Set<PostDTOMention> postDTOMs = new TreeSet<>();
        if (tus.validUsername(userMention) && tus.validUsername(userMentioning)) {
            List<Post> posts = pR.findMentionPosts(userMention);
            for (Post p : posts) {
                if (p.getMentions().get(0).getUserMention().getUsername().equals(userMention) && p.getMentions().get(0).getUserMentioning().getUsername().equals(userMentioning)) {
                    PostDTOMention postDTOM = createPostMentionDTO(p);
                    postDTOMs.add(postDTOM);
                }
            }
            return postDTOMs;
        }
        return postDTOMs;
    }

}
