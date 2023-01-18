package org.example.twitterApp.objectClassAndRepository.model.posts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.twitterApp.objectClassAndRepository.model.like.LikePost;
import org.example.twitterApp.objectClassAndRepository.model.mention.MentionPost;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "post")
public class Post extends PostBase {

    @OneToMany(mappedBy = "replyPost", cascade = CascadeType.ALL)
    private List<Reply> replies;

    @OneToMany(mappedBy = "postLike",cascade = CascadeType.ALL)
    private List<LikePost> likes;

    @JsonIgnore
    @OneToMany(mappedBy = "postMention",cascade = CascadeType.ALL)
    private List<MentionPost> mentions;

    public Post() {
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public List<LikePost> getLikes() {
        return likes;
    }

    public void setLikes(List<LikePost> likes) {
        this.likes = likes;
    }

    public List<MentionPost> getMentions() {
        return mentions;
    }

    public void setMentions(List<MentionPost> mentions) {
        this.mentions = mentions;
    }

    @Override
    public String toString() {
        return "Post{" + super.toString() +
                "replies=" + replies +
                ", likes=" + likes +
                ", mentions=" + mentions +
                "} ";
    }

}
