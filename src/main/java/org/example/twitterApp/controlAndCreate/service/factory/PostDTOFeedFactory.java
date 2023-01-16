package org.example.twitterApp.controlAndCreate.service.factory;

import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;
import org.example.twitterApp.objectClassAndRepository.modelDTO.PostDTOFeed;

public class PostDTOFeedFactory extends ValidateFactory implements Factory {


    @Override
    public Object convertToDTO(Object o) {
        if (o instanceof Post) {
            Post post = (Post) o;
            PostDTOFeed postDTO = new PostDTOFeed();
            postDTO.setPostBy(post.getUserWhoPost().getUsername());
            postDTO.setMessage(post.getMessage());
            postDTO.setCreateDate(getDateAndTime(post.getCreateDate()));
            postDTO.setOnlyMe(post.getOnlyMe());
            if (post.getLikes() != null) {
                postDTO.setPostLikes(getListLikesDTO(post.getLikes()));
            } else {
                postDTO.setPostLikes(null);
            }
            if (post.getReplies() != null) {
                postDTO.setPostReplies(getListRepliesDTOF(post.getReplies()));
            } else {
                postDTO.setPostReplies(null);
            }
            return postDTO;
        } else if (o instanceof Reply) {
            Reply reply = (Reply) o;
            PostDTOFeed postDTO = new PostDTOFeed();
            postDTO.setPostBy(reply.getUserWhoPost().getUsername());
            postDTO.setMessage(reply.getMessage());
            postDTO.setCreateDate(getDateAndTime(reply.getCreateDate()));
            postDTO.setOnlyMe(reply.getOnlyMe());
            if (reply.getLikes() != null) {
                postDTO.setPostLikes(getListLikesDTO(reply.getLikes()));
            } else {
                postDTO.setPostLikes(null);
            }
            if (reply.getReplies() != null) {
                postDTO.setPostReplies(getListRepliesDTOF(reply.getReplies()));
            } else {
                postDTO.setPostReplies(null);
            }
            return postDTO;
        }
        return null;
    }
}
