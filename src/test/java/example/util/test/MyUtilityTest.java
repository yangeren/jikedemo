package example.util.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class MyUtilityTest {
    @Before
    public void init() {

    }

    @After
    public void cleanup() {

    }

    @Test
    public void method1() throws Exception {
        MyUtility utility = new MyUtility();
        int result = utility.method1(100, 200);
        Assert.assertEquals(300, result);
    }

    @Test
    public void method2() throws Exception {
        MyUtility utility = new MyUtility();
        long result = utility.method2(100L);
        Assert.assertEquals(100L, result);
    }

}