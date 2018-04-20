package com.zenzile.assassin.service.impl;

import com.zenzile.assassin.model.Admin;
import com.zenzile.assassin.model.factory.AdminFactory;
import com.zenzile.assassin.repository.AdminRepository;
import com.zenzile.assassin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin registerAdmin(Admin admin) {
        Admin newAdmin = AdminFactory.createAdmin(admin);

        if(checkMissingFields(newAdmin)) {
            adminRepository.save(newAdmin);
            return adminRepository.findById(newAdmin.getId()).get();
        } else
            return newAdmin;
    }

    @Override
    public Admin updateAdmin(Admin admin) {

        if(checkMissingFields(admin)) {
            adminRepository.save(admin);
            return admin;
        } else
            return null;
    }

    @Override
    public Admin findByEmail(String email) {

        if(null == email || email.equals(""))
            return null;
        else {
            List<Admin> admins = adminRepository.findAdminByEmail(email);

            return admins.get(0);
        }
    }

    @Override
    public boolean deleteAdmin(Long adminId) {
        adminRepository.deleteById(adminId);

        boolean isDeleted = (adminRepository.findById(adminId).isPresent()) ? true: false;

        return isDeleted;
    }

    private boolean checkMissingFields(Admin admin) {
        boolean passValidation = true;

        if (admin.getEmail() == null ||admin.getEmail().equals("") ||
                admin.getPassword() == null ||admin.getPassword().equals("") ||
                admin.getName() == null ||admin.getName().equals("") ||
                admin.getSurname() == null || admin.getSurname().equals("")
                )
            passValidation = false;

        return passValidation;
    }
}
