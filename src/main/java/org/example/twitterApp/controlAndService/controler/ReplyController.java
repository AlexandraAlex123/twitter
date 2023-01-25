package org.example.twitterApp.controlAndService.controler;


import org.example.twitterApp.controlAndService.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "/user")
public class ReplyController {

    @Autowired
    private ReplyService rs;


    @PutMapping(path = "replyComment")
    public String addReplyReply(@PathVariable @NotNull Long id, @RequestParam String message, @RequestParam @NotNull String userWhoReply) {
        return rs.addReplyReply(id, message, userWhoReply);
    }

    @PutMapping(path = "/likeAComment")
    public String addLikePost(@PathVariable @NotNull Long id, @RequestParam @NotNull String userWhoGivesLike) {
        return rs.addLikeReply(id, userWhoGivesLike);
    }

    @PutMapping(path = "makeCommentNotPublic")
    public String makeAReplyNotPublic(@PathVariable @NotNull Long id) {
        return rs.makeAReplyNotPublic(id);
    }

    @DeleteMapping(path = "/deleteReply")
    public String deleteReply(@PathVariable @NotNull Long id) {
        return rs.deleteReply(id);
    }
}
