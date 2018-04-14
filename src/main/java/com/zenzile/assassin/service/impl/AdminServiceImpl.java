package com.zenzile.assassin.service.impl;

import com.zenzile.assassin.repository.AdminRepository;
import com.zenzile.assassin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

}
