package org.example.twitterApp.objectClassAndRepository.model.like.modelDTO;

public class MentionDtO implements Comparable<MentionDtO> {

    String userMention;
    String timeMention;
    PostsMentionDTO mentionPost;

    public MentionDtO() {
    }

    public String getUserMention() {
        return userMention;
    }

    public void setUserMention(String userMention) {
        this.userMention = userMention;
    }

    public String getTimeMention() {
        return timeMention;
    }

    public void setTimeMention(String timeMention) {
        this.timeMention = timeMention;
    }

    public PostsMentionDTO getMentionPost() {
        return mentionPost;
    }

    public void setMentionPost(PostsMentionDTO mentionPost) {
        this.mentionPost = mentionPost;
    }

    @Override
    public String toString() {
        return "MentionDtO{" +
                "userMention='" + userMention + '\'' +
                ", timeMention='" + timeMention + '\'' +
                ", mentionPost=" + mentionPost +
                '}';
    }

    @Override
    public int compareTo(MentionDtO o) {
        int i = this.timeMention.compareTo(o.getTimeMention());
        return Integer.compare(0, i);
    }
}
