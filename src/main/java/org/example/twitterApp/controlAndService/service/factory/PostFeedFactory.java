package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOFeed;

public class PostFeedFactory extends ValidateFactory implements ConvertDTO {


    @Override
    public PostDTOFeed convertToDTO(Object o) {
        PostDTOFeed postDTO = new PostDTOFeed();
        if (o instanceof Post) {
            Post post = (Post) o;
            postDTO.setPostBy(post.getUserWhoPost().getUsername());
            postDTO.setMessage(post.getMessage());
            postDTO.setCreateDate(getDateAndTime(post.getCreateDate()));
            postDTO.setOnlyMe(post.getOnlyMe());
            if (post.getLikes() != null) {
                postDTO.setPostLikes(getListLikesPostDTO(post.getLikes()));
            } else {
                postDTO.setPostLikes(null);
            }
            if (post.getReplies() != null) {
                postDTO.setPostReplies(getListRepliesDTOF(post.getReplies()));
            } else {
                postDTO.setPostReplies(null);
            }
            if (post.getMentions() != null){
                postDTO.setMentions(getListMentionPostDTO(post.getMentions()));
            }else {
                postDTO.setMentions(null);
            }
            return postDTO;
        } else if (o instanceof Reply) {
            Reply reply = (Reply) o;
            postDTO.setPostBy(reply.getUserWhoPost().getUsername());
            postDTO.setMessage(reply.getMessage());
            postDTO.setCreateDate(getDateAndTime(reply.getCreateDate()));
            postDTO.setOnlyMe(reply.getOnlyMe());
            if (reply.getLikes() != null) {
                postDTO.setPostLikes(getListLikesReplyDTO(reply.getLikes()));
            } else {
                postDTO.setPostLikes(null);
            }
            if (reply.getReplies() != null) {
                postDTO.setPostReplies(getListRepliesDTOF(reply.getReplies()));
            } else {
                postDTO.setPostReplies(null);
            }
            if (reply.getMentions() != null){
                postDTO.setMentions(getListMentionReplyDTO(reply.getMentions()));
            }else {
                postDTO.setMentions(null);
            }
            return postDTO;
        }
        return postDTO;
    }
}
