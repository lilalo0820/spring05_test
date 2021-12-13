package com.example.spring04;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.spring04.model.message.MessageDAO;
import com.example.spring04.model.message.MessageDTO;
//junit test
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MessageDAOImplTest {

	private static final Logger logger = LoggerFactory.getLogger(MessageDAOImplTest.class);
	
	@Inject
	MessageDAO dao;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreate() {
		MessageDTO dto = new MessageDTO();
		dto.setMessage("junit testing111");
		dto.setReceive_id("park");
		dto.setSender("kim");
		dao.create(dto);
	}

}
