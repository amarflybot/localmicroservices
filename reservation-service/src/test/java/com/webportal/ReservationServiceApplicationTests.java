package com.webportal;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ReservationServiceApplication.class)
//@ContextConfiguration(locations = {"classpath:test-bootstrap.properties"})
@WebAppConfiguration
public class ReservationServiceApplicationTests {

	@BeforeClass
	public static void setSystemProps() {
		System.setProperty("message", "default Message");
	}

	@Test
	public void contextLoads() {
	}

}
