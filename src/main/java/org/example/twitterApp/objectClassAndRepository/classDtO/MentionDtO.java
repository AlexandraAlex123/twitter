package org.example.twitterApp.objectClassAndRepository.classDtO;

import org.example.twitterApp.controler.service.factory.ServiceFactory;
import org.example.twitterApp.objectClassAndRepository.model.posts.Post;
import org.example.twitterApp.objectClassAndRepository.model.posts.Reply;

public class MentionDtO implements Comparable<MentionDtO> {

    String userHwoMention;
    String createDate;
    PostDTOMention postDTOMention;

    public MentionDtO(String userHwoMention, String createDate, PostDTOMention postDTOMention) {
        this.userHwoMention = userHwoMention;
        this.createDate = createDate;
        this.postDTOMention = postDTOMention;

    }

    public MentionDtO() {
    }

    public String getUserHwoMention() {
        return userHwoMention;
    }

    public void setUserHwoMention(String userHwoMention) {
        this.userHwoMention = userHwoMention;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public PostDTOMention getPostDTOMention() {
        return postDTOMention;
    }

    public void setPostDTOMention(PostDTOMention postDTOMention) {
        this.postDTOMention = postDTOMention;
    }


    @Override
    public String toString() {
        return "MentionDtO{" +
                "userHwoMention='" + userHwoMention + '\'' +
                ", date='" + createDate + '\'' +
                ", post=" + postDTOMention +
                '}';
    }

    @Override
    public int compareTo(MentionDtO o) {
        int i = this.createDate.compareTo(o.getCreateDate());
        return Integer.compare(0, i);
    }
}
