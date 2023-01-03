package org.example.classes;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Reply extends Post {

    @Column(name = "whoCanSee")
    private boolean whoCanSee;

    public Reply() {
    }

    public Reply(String message, Date timeStamp, User user, Set<Reply> replies, boolean whoCanSee) {
        super(message, timeStamp, user, replies);
        this.whoCanSee = whoCanSee;
    }

}
