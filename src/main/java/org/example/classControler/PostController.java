package org.example.classControler;

import org.example.classService.service.PostService;
import org.example.classService.service.classDtO.PostDtO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        return pS.searchUserPosts(username);
    }

    @GetMapping(path = "/filterPosts")
    public Set<PostDtO> filterPosts(@RequestParam Timestamp ts, @RequestParam Timestamp ts2) {
        return pS.filterPostsByDate(ts, ts2);
    }
}
