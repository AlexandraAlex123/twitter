package org.example.twitterApp.controler.classControler;

import org.example.twitterApp.controler.service.serviceClass.PostService;
import org.example.twitterApp.objectClassAndRepository.classDtO.PostDtO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
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
}
