package org.example.twitterApp.controlAndService.service;

import org.example.twitterApp.controlAndService.service.factory.ValidateFactory;
import org.example.twitterApp.objectClassAndRepository.model.mention.MentionPost;
import org.example.twitterApp.objectClassAndRepository.model.mention.MentionReply;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.modelDTO.MentionDtO;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOFeed;
import org.example.twitterApp.objectClassAndRepository.repository.MentionPostRepository;
import org.example.twitterApp.objectClassAndRepository.repository.MentionReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class MentionService extends ValidateFactory {

    @Autowired
    private PostService ps;

    @Autowired
    private TwitterUserService tus;

    @Autowired
    private MentionPostRepository mPr;

    @Autowired
    private MentionReplyRepository mRr;


    public Set<MentionDtO> getYourMentionsPosts(String userMention) {
        Set<MentionDtO> allMentions = new TreeSet<>();
        if (tus.validUsername(userMention)) {
            allMentions.addAll(getMentionPosts(userMention));
            allMentions.addAll(getMentionReply(userMention));
            return allMentions;
        }
        return allMentions;
    }

    public PostDTOFeed getPostWhereYouGotMention(Long idMention) {
        MentionPost mp = getMentionPost(idMention);
        MentionReply mr = getMentionReply(idMention);
        PostDTOFeed postDTOFeed = new PostDTOFeed();
        if (mp != null) {
            Long idPost = mp.getPostMention().getId();
            Post post = ps.getPostById(idPost);
            return createPostDTOF(post);
        } else if (mr != null) {
            Long idPost = mr.getReplyMention().getReplyPost().getId();
            Post post = ps.getPostById(idPost);
            return createPostDTOF(post);
        }
        return postDTOFeed;
    }

    public Set<MentionDtO> getMentionPosts(String userMention) {
        List<MentionPost> mentionPosts = mPr.findAllMentionPostByUsername(userMention);
        return getListMentionPostDTO(mentionPosts);
    }

    public Set<MentionDtO> getMentionReply(String userMention) {
        List<MentionReply> mentionReply = mRr.findAllMentionReplyByUsername(userMention);
        return getListMentionReplyDTO(mentionReply);
    }

    public String deleteMention(Long id) {
        if (id != null) {
            if (existsMentionPost(id)) {
                mPr.deleteById(id);
                return "Mention deleted";
            } else if (existsMentionReply(id)) {
                mRr.deleteById(id);
                return "Mention deleted";
            } else {
                return "Mention not found";
            }
        }
        return " Null parameter";
    }

    public MentionPost getMentionPost(Long id) {
        return mPr.findMentionPostById(id);
    }

    public MentionReply getMentionReply(Long id) {
        return mRr.findMentionReplyById(id);
    }

    public boolean existsMentionPost(Long id) {
        return mPr.findById(id).isPresent();
    }

    public boolean existsMentionReply(Long id) {
        return mPr.findById(id).isPresent();
    }
}
