package com.example.spring04;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;	//@Test junit library 추가
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//junit test
public class DBConnectTest {
	private static final Logger logger = LoggerFactory.getLogger(DBConnectTest.class );
	String driver="oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String userid = "tester";
	String pwd = "1234";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(driver);
		try {
			Connection conn = DriverManager.getConnection(url,userid,pwd);
			logger.info("db connected!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
