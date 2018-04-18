package com.zenzile.assassin.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
//@Document
@Table(name = "admins")
public class Admin  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    private Admin() {

    }

    public Admin(AdminBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.password = builder.password;
    }

    public static class AdminBuilder {
        private Long id;
        private String name;
        private String surname;
        private String password;
        private String email;

        public AdminBuilder (String name) {
            this.id = id;
        }

        public AdminBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public AdminBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public AdminBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AdminBuilder password(String password) {
            this.password = password;
            return this;
        }

        public AdminBuilder copy(Admin copy) {
            this.id = copy.getId();
            this.name = copy.getName();
            this.surname = copy.getSurname();
            this.email = copy.getEmail();
            this.password = copy.getPassword();

            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}

/****
*
 id --name -- surname -- email -- password

 * */
