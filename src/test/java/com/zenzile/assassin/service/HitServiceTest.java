package com.zenzile.assassin.service;

import com.zenzile.assassin.repository.AdminRepository;
import com.zenzile.assassin.repository.HitRepository;
import com.zenzile.assassin.repository.MemberRepository;
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
public class HitServiceTest {
    @Autowired
    private HitService hitService;

    @Autowired
    private HitRepository hitRepository;

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

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
