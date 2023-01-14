package org.example.twitterApp.controler.classControler;

import org.example.twitterApp.controler.service.serviceClass.PostService;
import org.example.twitterApp.objectClassAndRepository.classDtO.PostDtO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Set;

@RestController
public class PostController {

    @Autowired
    private PostService pS;

    @GetMapping(path = "/searchUserPosts")
    public Set<PostDtO> searchUserPosts(@RequestParam String username) {
        return pS.searchUserPosts(username);
    }

    @GetMapping(path = "/filterPosts")
    public Set<PostDtO> filterPosts(@RequestParam Timestamp ts, @RequestParam Timestamp ts2) {
        return pS.filterPostsByDate(ts, ts2);
    }

    @PutMapping(path = "/leaveComment")
    public String addAReply(@PathVariable Long id, @RequestParam String message, @RequestParam String userWhoReply){
        return pS.addAReply(id, message, userWhoReply);
    }
}
