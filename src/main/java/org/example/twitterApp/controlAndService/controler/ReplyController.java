package org.example.twitterApp.controlAndService.controler;


import org.example.twitterApp.controlAndService.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyController {

    @Autowired
    private ReplyService rs;

    @PutMapping(path = "replyComment")
    public String addReplyReply(@RequestParam Long id, @RequestParam String message, @RequestParam String userWhoReply) {
        return rs.addReplyReply(id, message, userWhoReply);
    }

    @PutMapping(path = "/likeAComment")
    public String addLikePost(@RequestParam Long id,@RequestParam String userWhoGivesLike) {
        return rs.addLikeReply(id, userWhoGivesLike);
    }
}
