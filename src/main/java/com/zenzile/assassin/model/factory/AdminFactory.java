package com.zenzile.assassin.model.factory;

import com.zenzile.assassin.model.Admin;
import com.zenzile.assassin.model.constants.UserType;
import org.jasypt.util.password.StrongPasswordEncryptor;

import java.util.Date;

public class AdminFactory {
    public static Admin createAdmin(Admin newAdmin) {
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        return new Admin
                .AdminBuilder(newAdmin.getName())
                .email(newAdmin.getEmail())
                .surname(newAdmin.getSurname())
                .password(encryptor.encryptPassword(newAdmin.getPassword()))
                .build();
    }
}
