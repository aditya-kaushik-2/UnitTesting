package com.test.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MerchandiseUtilTest { // scenario....assumptions... given argument.... validations

    MerchandiseUtil merchandiseUtil;

    @Before
    public void setup() {
        merchandiseUtil = new MerchandiseUtil();
    }

    @Test
    public void getShirtName_WhenLengthIsLessThan10() {
        Assert.assertEquals(5, merchandiseUtil.getShirtName(5).length());
    }

    @Test(expected = RuntimeException.class)
    public void getShirtName_WhenLengthIsLessThan0() {
        Assert.assertEquals(5, merchandiseUtil.getShirtName(-1).length());
    }

    @Test(expected = RuntimeException.class)
    public void getShirtName_WhenLengthIsGreaterThan10() {
        merchandiseUtil.getShirtName(12);
    }
}