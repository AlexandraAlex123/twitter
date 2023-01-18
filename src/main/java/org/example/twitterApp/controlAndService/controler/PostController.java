package org.example.twitterApp.controlAndService.controler;

import org.example.twitterApp.controlAndService.service.PostService;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOFeed;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDtO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class PostController {

    @Autowired
    private PostService pS;

    @GetMapping(path = "/getFeeds")
    public Set<PostDTOFeed> getFeeds(@RequestParam String username) {
        return pS.getFeeds(username);
    }

    @GetMapping(path = "/getYouOwnPosts")
    public Set<PostDtO> searchUserPosts(@RequestParam String username) {
        return pS.searchOnlyUserPosts(username);
    }

//    @GetMapping(path = "/filterPosts")
//    public Set<PostDtO> filterPosts(@RequestParam Set<PostDtO> postDTOs, @RequestParam Timestamp ts, @RequestParam Timestamp ts2) {
//        return pS.filterPostsByDate(postDTOs, ts, ts2);
//    }

    @PutMapping(path = "/leaveComment")
    public String addAReply(@RequestParam Long id, @RequestParam String message, @RequestParam String userWhoReply) {
        return pS.addPostReply(id, message, userWhoReply);
    }

    @PutMapping(path = "/likeAPost")
    public String addLikePost(@RequestParam Long id,@RequestParam String userWhoGivesLike) {
        return pS.addLikePost(id, userWhoGivesLike);
    }

    @PutMapping(path = "makePostNotPublic")
    public String makeAPostNotPublic(@RequestParam Long id) {
        return pS.makeAPostNotPublic(id);
    }

}
