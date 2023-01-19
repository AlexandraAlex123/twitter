package org.example.twitterApp.controlAndService.controler;

import org.example.twitterApp.controlAndService.service.LikeService;
import org.example.twitterApp.controlAndService.service.PostService;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOFeed;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDtO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PostController {

    @Autowired
    private LikeService ls;

    @Autowired
    private PostService pS;


    @GetMapping(path = "/getFeeds")
    public Set<PostDTOFeed> getFeeds(@RequestParam String username) {
        return pS.getFeeds(username);
    }

    @GetMapping(path = "/getNewFeed")
    public Set<PostDTOFeed> getNewFeeds(@RequestParam String username) {
        return pS.getNewFeeds(username);
    }

    @GetMapping(path = "/getYouOwnPosts")
    public Set<PostDtO> searchUserPosts(@RequestParam String username) {
        return pS.searchOnlyUserPosts(username);
    }

    @PutMapping(path = "/leaveComment")
    public String addAReply(@RequestParam Long id, @RequestParam String message, @RequestParam String userWhoReply) {
        return pS.addPostReply(id, message, userWhoReply);
    }

    @PutMapping(path = "/likeAPost")
    public String addLikePost(@RequestParam Long id, @RequestParam String userWhoGivesLike) {
        return pS.addLikePost(id, userWhoGivesLike);
    }

    @PutMapping(path = "/makePostNotPublic")
    public String makeAPostNotPublic(@RequestParam Long id) {
        return pS.makeAPostNotPublic(id);
    }

    @DeleteMapping(path = "/deletePost")
    public String deletePost(@RequestParam Long id) {
        return pS.deletePost(id);
    }

    @DeleteMapping(path = "/deleteLike")
    public String deleteLike(@RequestParam Long id) {
        return ls.deleteLike(id);
    }
}
