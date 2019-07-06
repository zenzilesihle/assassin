package com.zenzile.assassin;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class AssassinApplicationTests {
    /**
     * All the unit tests run in isolation
     * a change in one unit test does not affect another
     * for an example,
     *      if i'm testing read;
     *      I start with create
     *      or I'm doing delete,
     *      I start with add -> find -> delete
     * */

}