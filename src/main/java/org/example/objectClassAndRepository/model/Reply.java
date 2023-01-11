package org.example.objectClassAndRepository.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Reply extends PostedMessages {

    public Reply() {
    }

    public Reply(String message, Timestamp timestamp, boolean onlyMe) {
        super(message, timestamp, onlyMe);
    }

    @Override
    public String toString() {
        return "Reply{" + super.toString() +
                "}";
    }
}
