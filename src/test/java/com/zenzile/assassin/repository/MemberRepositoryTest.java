package com.zenzile.assassin.repository;

import com.zenzile.assassin.AssassinApplicationTests;
import com.zenzile.assassin.model.Member;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberRepositoryTest extends AssassinApplicationTests {
    @Autowired
    private MemberRepository memberRepository;

    private Member member;

    @Test
    public void test1Save() {

    }

    @Test
    public void test2FindAll() {

    }

    @Test
    public void test3FindOneById() {

    }

    @Test
    public void test4Delete() {

    }

    @After
    public void cleanUp() {

    }

    @Before
    public void setUp() {

    }
}
