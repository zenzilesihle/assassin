package com.zenzile.assassin.service;

import com.zenzile.assassin.model.Admin;
import com.zenzile.assassin.model.factory.AdminFactory;
import com.zenzile.assassin.repository.AdminRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    private Admin admin;

    private long id;

    @Test
    public void testSave() {

        adminRepository.save(admin);

        Iterable<Admin> newAdmin = adminRepository.findAll();

        Assert.assertNotNull(newAdmin);
    }

    @Before
    public void init() {

        admin = new Admin();
//        admin.setId(admin.getId());
        admin.setEmail("sandakahle@gmail.com");
        admin.setName("Sandakahle");
        admin.setGender("Female");
        admin.setSurname("Sanda");
        admin = AdminFactory.createAdmin(admin);
        id = admin.getId();

    }

    @After
    @Test
    public void cleanUp(){
        adminRepository.delete(admin);
        Assert.assertTrue(adminRepository.count() == 0);
    }
}