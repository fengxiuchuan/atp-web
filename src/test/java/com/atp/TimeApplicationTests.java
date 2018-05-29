package com.atp;

import com.atp.common.TestProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeApplicationTests {

	@Autowired
	TestProperties testProperties;

	@Test
	public void contextLoads() {
		Assert.assertEquals(testProperties.getName(), "cc");
	}

}
