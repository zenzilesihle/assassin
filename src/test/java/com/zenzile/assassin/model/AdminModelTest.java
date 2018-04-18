package com.zenzile.assassin.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminModelTest {
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
