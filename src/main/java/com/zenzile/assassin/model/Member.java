package com.zenzile.assassin.model;

import com.zenzile.assassin.model.constants.UserType;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;

@Entity
@Document
@Table(name = "members")
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String gender;

    @Column(unique = true, nullable = false)
//    @NotNull
    @Email
    private String email;

    private Date registrationDate;

    private UserType userType;

    public Member(MemberBuilder m) {
        this.id = m.id;
        this.name = m.name;
        this.surname = m.surname;
        this.gender = m.gender;
        this.userType = m.userType;
        this.email = m.email;
        this.registrationDate = m.registrationDate;
    }

    public static class MemberBuilder{
        private Long id;
        private String name;
        private String surname;
        private String gender;
        private String email;
        private UserType userType;
        private Date registrationDate;


        public MemberBuilder (String name) {
            this.name = name;
        }

        public MemberBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MemberBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public MemberBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public MemberBuilder email(String email) {
            this.email = email;
            return this;
        }

        public MemberBuilder userType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public MemberBuilder registrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public MemberBuilder copy(Member copy) {
            this.id = copy.getId();
            this.name = copy.getName();
            this.surname = copy.getSurname();
            this.gender = copy.getGender();
            this.registrationDate = copy.getRegistrationDate();
            this.userType = copy.getUserType();
            this.email = copy.getEmail();

            return this;
        }

        public Member build(){
            return new Member(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public UserType getUserType() {
        return userType;
    }
}
