package com.zenzile.assassin.model;

import com.zenzile.assassin.AssassinApplicationTests;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminModelTest extends AssassinApplicationTests {
    private Admin admin;

    @Test
    public void testAdmin() {
        Assert.assertEquals("Micheal", admin.getName());
        Assert.assertEquals("jackson@gmail.com", admin.getEmail());
        Assert.assertEquals("Jackson", admin.getSurname());
        Assert.assertEquals("mejejeke101010", admin.getPassword());
    }

    @Before
    @Test
    public void setUp() {
        admin = new Admin
                .AdminBuilder("Micheal")
                .surname("Jackson")
                .email("jackson@gmail.com")
                .password("mejejeke101010")
                .build();

        Assert.assertNotNull("Fucking Admin Not Null", admin);
    }

    @After
    @Test
    public void cleanUp(){
        admin = null;
        Assert.assertNull(admin);
    }
}
