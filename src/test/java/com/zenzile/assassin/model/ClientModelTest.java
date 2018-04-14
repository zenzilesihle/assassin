package com.zenzile.assassin.model;

import com.zenzile.assassin.model.constants.UserType;
import com.zenzile.assassin.model.factory.ClientFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientModelTest {

    private Client client;

    @Test
    public void testUserType() {
        Assert.assertNotNull(client);
        Assert.assertEquals(UserType.CLIENT, client.getUserType());
    }

    @Before
    public void init() {
        client = ClientFactory.createClient(new Client());
    }


    @After
    @Test
    public void deleteModel(){
        client = null;
        Assert.assertNull(client);
    }
}
