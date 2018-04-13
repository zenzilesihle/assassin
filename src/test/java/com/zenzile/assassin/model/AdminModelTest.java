package com.zenzile.assassin.model;

import com.zenzile.assassin.model.constants.UserType;
import com.zenzile.assassin.model.factory.AdminFactory;
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
    private Admin adminFactory;

    @Test
    public void testUserType() {
        Assert.assertNotNull(adminFactory);
        Assert.assertTrue(UserType.ADMIN.equals(adminFactory.getUserType()));
    }

    @Before
    public void init() {
        adminFactory = AdminFactory.createAdmin(new Admin());

    }

    @After
    @Test
    public void deleteModel(){
        adminFactory = null;
        Assert.assertNull(adminFactory);
    }
}
