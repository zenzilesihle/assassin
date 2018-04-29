package com.zenzile.assassin.security;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class SecuritySpaceHolder {


    public static void main(String[] args) {
        String password = "admiral";

        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        System.out.println(encryptor.checkPassword("admiral", encryptor.encryptPassword(password)));
        System.out.println(encryptor.encryptPassword(password));
    }
}
