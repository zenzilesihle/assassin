package com.zenzile.assassin.model;

import com.zenzile.assassin.model.factory.HitFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HitModelTest {

    private Hit hit;

    @Test
    public void testHit() {
        Assert.assertNotNull(hit);
    }

    @Before
    public void init() {
        hit = HitFactory.createHit(new Hit());
    }


    @After
    @Test
    public void deleteModel(){
        hit = null;
        Assert.assertNull(hit);
    }
}
