package com.zenzile.assassin.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "members")
public class Member extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
