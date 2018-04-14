package com.zenzile.assassin.model;

import com.zenzile.assassin.model.constants.TargetStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "targets")
public class Target extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @Column(nullable = false)
//    @NotNull
//    @JoinColumn(name="address_id")
//    private Address address;

    private TargetStatus targetStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public TargetStatus getTargetStatus() {
        return targetStatus;
    }

    public void setTargetStatus(TargetStatus targetStatus) {
        this.targetStatus = targetStatus;
    }
}
