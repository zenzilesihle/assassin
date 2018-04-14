package com.zenzile.assassin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "hits")
public class Hit implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double amount;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="target_id")
    private List<Target> targets;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="client_id")
    private Client client;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="member_id")
    private Member member;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
