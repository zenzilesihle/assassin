package com.zenzile.assassin.service;

import com.zenzile.assassin.repository.AdminRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void test1Register() {

    }

    @Test
    public void test2FindByEmail() {

    }

    @Test
    public void test3Update() {

    }

    @After
    public void cleanUp(){

    }

    @Before
    public void setUp() {

    }
}
