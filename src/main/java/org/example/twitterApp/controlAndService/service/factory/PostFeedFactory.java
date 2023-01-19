package org.example.twitterApp.controlAndService.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOFeed;

public class PostFeedFactory extends ValidateFactory implements ConvertDTO {

    @Override
    public PostDTOFeed convertToDTO(Object o) {
        PostDTOFeed postDTO = new PostDTOFeed();
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
            postDTO.setPostReplies(getListRepliesDTO(post.getReplies()));
        } else {
            postDTO.setPostReplies(null);
        }
        if (post.getMentions() != null) {
            postDTO.setMentions(getListMentionForPostDTO(post.getMentions()));
        } else {
            postDTO.setMentions(null);
        }
        return postDTO;
    }

}
