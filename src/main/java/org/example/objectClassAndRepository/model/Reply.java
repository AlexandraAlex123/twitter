package org.example.objectClassAndRepository.model;

import javax.persistence.*;

@Entity
@Table
public class Reply extends PostedMessages {

    public Reply() {
    }

    @Override
    public String toString() {
        return "Reply{} " + super.toString();
    }
}
