package com.example.spring04.controller.member;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerTest.class);
	
	@Inject
	WebApplicationContext context;
	
	MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		logger.info("setup...");
	}

	@Test
	public void testAddress() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/spring04/member/join"));
		logger.info("testAddress");
	}

	@Test
	public void testLogin() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/spring04/member/login"));
		logger.info("testLogin");
	}

//	@Test
//	public void testLogin_checkMemberDTOHttpSession() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLogin_checkHttpSessionModelAndView() {
//		fail("Not yet implemented");
//	}

}
