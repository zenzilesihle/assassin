package com.zenzile.assassin.model;

import com.zenzile.assassin.model.constants.UserType;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    @Column(nullable = false)
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setUserType(UserType userType) { this.userType = userType; }

    public UserType getUserType() { return userType; }

    public Date getRegistrationDate() {
        return registrationDate;
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
}
