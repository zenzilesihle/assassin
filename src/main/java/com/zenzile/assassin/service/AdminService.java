package com.zenzile.assassin.service;


import com.zenzile.assassin.model.Admin;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminService {
    Admin registerAdmin(Admin admin);
    Admin updateAdmin(Admin admin);
    Admin findByEmail(String email);
    boolean deleteAdmin(Long adminId);
}
