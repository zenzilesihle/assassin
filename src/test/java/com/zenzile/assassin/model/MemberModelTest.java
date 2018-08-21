package com.zenzile.assassin.model;

import com.zenzile.assassin.AssassinApplicationTests;
import com.zenzile.assassin.model.constants.UserType;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberModelTest extends AssassinApplicationTests {
    private Member member;

    @Test
    public void testMember() {
      Assert.assertEquals( "Sanda", member.getName());
      Assert.assertEquals( "Zitha", member.getSurname());
      Assert.assertEquals( "zitha.sanda@gmail.com", member.getEmail());
      Assert.assertEquals( "female", member.getGender());
      Assert.assertEquals(UserType.TARGET , member.getUserType());


    }

    @Before
    public void setUp() {
        member = new Member.MemberBuilder("Sanda")
                .surname("Zitha")
                .email("zitha.sanda@gmail.com")
                .gender("female")
                .registrationDate(new Date())
                .userType(UserType.TARGET)
                .build();
        Assert.assertNotNull("The fuck is member NULL for?", member);

    }

    @After
    @Test
    public void cleanUp(){

    }
}
