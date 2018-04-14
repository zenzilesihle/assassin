package com.zenzile.assassin.model.factory;

import com.zenzile.assassin.model.Admin;
import com.zenzile.assassin.model.constants.UserType;

import java.util.Date;

public class AdminFactory {
    public static Admin createAdmin(Admin newAdmin) {
        Admin factoryAdmin = new Admin();

//        factoryAdmin.setId(newAdmin.getId());
        factoryAdmin.setName(newAdmin.getName());
        factoryAdmin.setId(newAdmin.getId());
        factoryAdmin.setSurname(newAdmin.getSurname());
        factoryAdmin.setGender(newAdmin.getGender());
        factoryAdmin.setEmail(newAdmin.getEmail());
        factoryAdmin.setUserType(UserType.ADMIN);
        factoryAdmin.setRegistrationDate(new Date());

        return factoryAdmin;
    }
}
