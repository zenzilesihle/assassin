package com.zenzile.assassin.model;

import com.zenzile.assassin.model.constants.TargetStatus;
import com.zenzile.assassin.model.constants.UserType;
import com.zenzile.assassin.model.factory.TargetFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TargetModelTest {
    private Target target;



    @Test
    public void testUserType() {
        Assert.assertNotNull(target);
        Assert.assertEquals(UserType.TARGET, target.getUserType());
        Assert.assertEquals(TargetStatus.ALIVE, target.getTargetStatus());
    }

    @Before
    public void init() {
        target = TargetFactory.createTarget(new Target());
    }

    @After
    @Test
    public void deleteModel(){
        target = null;
        Assert.assertNull(target);
    }
}
