package com.github.ethan0w.sjblog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SJBlogApplication.class)
@WebAppConfiguration
public class SJBlogApplicationTests {

	@Test
	public void contextLoads() {
	}

}
