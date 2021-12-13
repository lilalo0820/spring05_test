package com.example.spring04;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//junit test
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MybatisTest {
	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	@Inject
	SqlSession sqlSession;
	
	@Test
	public void testSession1() {
		logger.info("sqlSession:" + sqlSession);
		logger.info("mybatis 연결 성공1");
	}
	
	@Test
	public void testSession2() {
		logger.info("sqlSession:" + sqlSession);
		logger.info("mybatis 연결 성공2");
	}
	
}
