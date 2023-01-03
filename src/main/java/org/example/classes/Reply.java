package org.example.classes;

import javax.persistence.*;

@Entity
public class Reply extends Post {

    @Column(name = "available")
    private boolean available;


}
