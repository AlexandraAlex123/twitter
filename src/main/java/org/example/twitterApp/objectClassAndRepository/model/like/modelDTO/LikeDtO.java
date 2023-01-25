package org.example.twitterApp.objectClassAndRepository.model.like.modelDTO;

public class LikeDtO implements Comparable<LikeDtO> {

    String whoGivesLike;
    String createDate;

    public LikeDtO() {
    }

    public String getWhoGivesLike() {
        return whoGivesLike;
    }

    public void setWhoGivesLike(String whoGivesLike) {
        this.whoGivesLike = whoGivesLike;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public int compareTo(LikeDtO o) {
        int i = this.createDate.compareTo(o.getCreateDate());
        return Integer.compare(0, i);
    }

    @Override
    public String toString() {
        return "LikeDtO{" +
                "whoGivesLike='" + whoGivesLike + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

}
