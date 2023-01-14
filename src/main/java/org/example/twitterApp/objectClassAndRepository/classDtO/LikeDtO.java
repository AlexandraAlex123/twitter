package org.example.twitterApp.objectClassAndRepository.classDtO;

public class LikeDtO implements Comparable<LikeDtO>{

     private String whoGivesLike;
     private String createDate;

    public LikeDtO(String whoGivesLike, String createDate) {
        this.whoGivesLike = whoGivesLike;
        this.createDate = createDate;
    }

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
    public String toString() {
        return "LikeDtO{" +
                "whoGivesLike='" + whoGivesLike + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

    @Override
    public int compareTo(LikeDtO o) {
        int i = this.createDate.compareTo(o.getCreateDate());
        return Integer.compare(0, i);
    }
}
