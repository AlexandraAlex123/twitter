package org.example.twitterApp.controlAndCreate.controler;

import org.example.twitterApp.controlAndCreate.service.PostService;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOFeed;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOMention;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDtO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Set;

@RestController
public class PostController {

    @Autowired
    private PostService pS;


    @GetMapping(path = "/searchUserPosts")
    public Set<PostDtO> searchUserPosts(@RequestParam String username) {
        return pS.searchOnlyUserPosts(username);
    }

    @GetMapping(path = "/filterPosts")
    public Set<PostDtO> filterPosts(@RequestParam Set<PostDtO> postDTOs, @RequestParam Timestamp ts, @RequestParam Timestamp ts2) {
        return pS.filterPostsByDate(postDTOs, ts, ts2);
    }

    @PutMapping(path = "/leaveComment")
    public String addAReply(@RequestParam Long id, @RequestParam String message, @RequestParam String userWhoReply) {
        return pS.addReplyPost(id, message, userWhoReply);
    }

    @GetMapping(path = "/getMentionsPosts")
    public Set<PostDTOMention> getMentionsPosts (@RequestParam String userMentioned, @RequestParam String userMentioning){
        return pS.getMentionsPosts(userMentioned, userMentioning);
    }

    @GetMapping(path = "/getFeeds")
    public Set<PostDTOFeed> getFeeds(@RequestParam String username) {
        return pS.getFollowsPosts(username);
    }

}
