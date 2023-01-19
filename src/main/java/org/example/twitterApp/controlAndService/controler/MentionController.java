package org.example.twitterApp.controlAndService.controler;

import org.example.twitterApp.controlAndService.service.MentionService;
import org.example.twitterApp.objectClassAndRepository.modelDTO.MentionDtO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class MentionController {

    @Autowired
    private MentionService mps;

    @GetMapping(path = "/getYourMentionsPost")
    public Set<MentionDtO> getYourMentionsPost(@RequestParam String userMention) {
        return mps.getYourMentionsPosts(userMention);
    }

    @DeleteMapping(path = "/deleteMention")
    public String deleteMention(@RequestParam Long id) {
        return mps.deleteMention(id);
    }
}
