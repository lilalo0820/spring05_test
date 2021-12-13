package com.example.spring04.controller.message;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.spring04.model.message.MessageDAO;
import com.example.spring04.model.message.MessageDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MessageControllerTest {

	@Inject 
	MessageDAO dao;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testList() {
		String userid ="park";
		List<MessageDTO> list = new ArrayList<MessageDTO>();
		if(userid != null ) {
			list = dao.list(userid);
		}
		System.out.println(list.toString()+ ": list value");
	}

}
