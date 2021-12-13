package com.example.spring04;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.spring04.model.shop.CartDAO;
import com.example.spring04.model.shop.CartDTO;
//junit test
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class CartDAOImplTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CartDAOImplTest.class);
	
	@Inject
	CartDAO dao;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testList() {
		List<CartDTO> list = dao.list("admin");
        for (CartDTO cart : list) {
        	logger.info(cart.toString());
        }
	}

}
