package org.example.classControler;

import org.example.classService.service.PostService;
import org.example.objectClassAndRepository.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService pS;

    @GetMapping(path = "/getYourOwnPosts")
    public List<Post> getYourOwnPosts(@RequestParam String username) {
        return pS.getYourOwnPosts(username);
    }
}
