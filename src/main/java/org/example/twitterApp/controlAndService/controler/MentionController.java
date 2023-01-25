package org.example.twitterApp.controlAndService.controler;

import org.example.twitterApp.controlAndService.service.MentionService;
import org.example.twitterApp.objectClassAndRepository.modelDTO.MentionDtO;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
@RequestMapping(path = "/user")
public class MentionController {

    @Autowired
    private MentionService mps;


    @GetMapping(path = "/getYourMentionsPost")
    public Set<MentionDtO> getYourMentionsPost(@RequestParam @NotNull String userMention) {
        return mps.getYourMentionsPosts(userMention);
    }

    @GetMapping(path = "/getPostWhereYouGotMention")
    public PostDTOFeed getPostWhereYouGotMention(@PathVariable @NotNull Long id) {
        return mps.getPostWhereYouGotMention(id);
    }

    @DeleteMapping(path = "/deleteMention")
    public String deleteMention(@PathVariable @NotNull Long id) {
        return mps.deleteMention(id);
    }
}
