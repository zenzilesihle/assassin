package com.zenzile.assassin;

import com.zenzile.assassin.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssassinApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testApp() {
		Client client = new Client();
		Hit hit = new Hit();
		Member member = new Member();
		Admin admin = new Admin();
		Target target = new Target();

		Assert.assertNotNull(client);
		Assert.assertNotNull(hit);
		Assert.assertNotNull(member);
		Assert.assertNotNull(admin);
		Assert.assertNotNull(target);
	}

}
