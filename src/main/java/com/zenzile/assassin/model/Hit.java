package com.zenzile.assassin.model;

import com.zenzile.assassin.model.constants.TargetStatus;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Document
@Table(name = "hits")
public class Hit implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double amount;

    @Column
    private String address;

    @Column
    private String codename;

    @Column
    private TargetStatus targetStatus;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="member_id")
    private Member member;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="admin_id")
    private Admin admin;

    public Hit(HitBuilder builder) {
        this.id = builder.id;
        this.codename = builder.codename;
        this.admin = builder.admin;
        this.address = builder.address;
        this.amount = builder.amount;
        this.member = builder.member;
        this.targetStatus = builder.targetStatus;
    }

    public static class HitBuilder {
        private Long id;
        private double amount;
        private String address;
        private String codename;
        private TargetStatus targetStatus;
        private Member member;
        private Admin admin;

        public HitBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public HitBuilder admin(Admin admin) {
            this.admin = admin;
            return this;
        }

        public HitBuilder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public HitBuilder address(String address) {
            this.address = address;
            return this;
        }

        public HitBuilder (String codename) {
            this.codename = codename;
        }

        public HitBuilder targetStatus(TargetStatus targetStatus) {
            this.targetStatus = targetStatus;
            return this;
        }

        public HitBuilder member(Member member) {
            this.member = member;
            return this;
        }

        public HitBuilder copy(Hit hit) {
            this.id = hit.getId();
            this.codename = hit.getCodename();
            this.amount = hit.getAmount();
            this.member = hit.getMember();
            this.targetStatus = hit.getTargetStatus();
            this.address = hit.getAddress();
            this.admin = hit.getAdmin();

            return this;
        }

        public Hit build() {
            return new Hit(this);
        }
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public Member getMember() {
        return member;
    }

    public String getAddress() {
        return address;
    }

    public String getCodename() {
        return codename;
    }

    public TargetStatus getTargetStatus() {
        return targetStatus;
    }

    public Admin getAdmin() {
        return admin;
    }
}

/**
 id -- code_name -- address -- status -- registrationDate -- amount
 REFERENCES
 admin_id -- member_id
 * */