package com.zenzile.assassin.model;

import com.zenzile.assassin.AssassinApplicationTests;
import com.zenzile.assassin.model.constants.TargetStatus;
import org.junit.*;
import org.junit.runners.MethodSorters;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HitModelTest extends AssassinApplicationTests {
    private Hit hit;

    @Test
    public void testHit() {
        Assert.assertEquals( "summer greens", hit.getCodename());
        Assert.assertEquals( "78 Gretna green, summer greens", hit.getAddress());
    }

    @Before
    public void setUp() {
        hit = new Hit.HitBuilder("summer greens")
                .address("78 Gretna green, summer greens")
                .amount(500.0000)
                .targetStatus(TargetStatus.ALIVE)
                .build();
        Assert.assertNotNull("The fuck is hit NULL for?", hit);
    }

 @After
    @Test
    public void cleanUp(){

    }
}
