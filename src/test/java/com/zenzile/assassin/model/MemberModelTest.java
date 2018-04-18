package com.zenzile.assassin.model;

import com.zenzile.assassin.model.constants.UserType;
import com.zenzile.assassin.model.factory.MemberFactor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberModelTest {
    private Member member;

    @Test
    public void testUserType() {
        Assert.assertNotNull(member);

        Assert.assertTrue(UserType.MEMBER.equals(member.getUserType()));

        Assert.assertEquals("Sihle", member.getName());
        Assert.assertEquals("Zenzile", member.getSurname());
        Assert.assertEquals("Male", member.getGender());
        Assert.assertEquals("sihlezen10@gmail.com", member.getEmail());

    }

    @Before
    public void init() {
//        member = MemberFactor.createMember(new Member());
    }


    @After
    @Test
    public void deleteModel(){
        member = null;
        Assert.assertNull(member);
    }
}
