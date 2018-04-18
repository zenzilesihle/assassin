package com.zenzile.assassin.model.factory;

import com.zenzile.assassin.model.Admin;
import com.zenzile.assassin.model.constants.UserType;

import java.util.Date;

public class AdminFactory {
    public static Admin createAdmin(Admin newAdmin) {

        return new Admin
                .AdminBuilder(newAdmin.getName())
                .email(newAdmin.getEmail())
                .surname(newAdmin.getSurname())
                .password(newAdmin.getPassword())
                .build();
    }
}
