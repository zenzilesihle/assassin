package com.zenzile.assassin.service;

import com.zenzile.assassin.AssassinApplicationTests;
import com.zenzile.assassin.repository.MemberRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberServiceTest extends AssassinApplicationTests {
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
