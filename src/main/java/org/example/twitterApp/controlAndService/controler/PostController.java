package org.example.twitterApp.controlAndService.controler;

import org.example.twitterApp.controlAndService.service.LikeService;
import org.example.twitterApp.controlAndService.service.PostService;
import org.example.twitterApp.objectClassAndRepository.model.like.modelDTO.PostDTOFeed;
import org.example.twitterApp.objectClassAndRepository.model.like.modelDTO.PostDtO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
@RequestMapping(path = "/user")
public class PostController {

    @Autowired
    private LikeService ls;

    @Autowired
    private PostService pS;


    @GetMapping(path = "/getFeeds")
    public Set<PostDTOFeed> getFeeds(@RequestParam @NotNull String username) {
        return pS.getFeeds(username);
    }

    @GetMapping(path = "/getNewFeed")
    public Set<PostDTOFeed> getNewFeeds(@RequestParam @NotNull String username) {
        return pS.getNewFeeds(username);
    }

    @GetMapping(path = "/getYouOwnPosts")
    public Set<PostDtO> searchUserPosts(@RequestParam @NotNull String username) {
        return pS.searchOnlyUserPosts(username);
    }

    @PutMapping(path = "/leaveComment")
    public String addAReply(@PathVariable @NotNull Long id, @RequestParam @NotNull String message, @RequestParam @NotNull String userWhoReply) {
        return pS.addPostReply(id, message, userWhoReply);
    }

    @PutMapping(path = "/likeAPost")
    public String addLikePost(@PathVariable @NotNull Long id, @RequestParam @NotNull String userWhoGivesLike) {
        return pS.addLikePost(id, userWhoGivesLike);
    }

    @PutMapping(path = "/makePostNotPublic")
    public String makeAPostNotPublic(@PathVariable @NotNull Long id) {
        return pS.makeAPostNotPublic(id);
    }

    @DeleteMapping(path = "/deletePost")
    public String deletePost(@PathVariable @NotNull Long id) {
        return pS.deletePost(id);
    }

    @DeleteMapping(path = "/deleteLike")
    public String deleteLike(@PathVariable @NotNull Long id) {
        return ls.deleteLike(id);
    }
}
