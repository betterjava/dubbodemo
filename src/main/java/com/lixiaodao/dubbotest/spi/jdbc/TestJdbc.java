package com.lixiaodao.dubbotest.spi.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ServiceLoader;

import org.junit.Test;

/**
 * @author cookie.liya
 * @date Jul 1, 2017
 */
public class TestJdbc {

	@Test
	public void testDbdriver() {
		Enumeration<Driver> dEnumeration = DriverManager.getDrivers();
		while (dEnumeration.hasMoreElements()) {
			Driver driver = (Driver) dEnumeration.nextElement();
			System.out.println(driver.getClass() + " : " + driver.getClass().getClassLoader());
		}
		System.out.println(Thread.currentThread().getContextClassLoader());
		System.out.println(DriverManager.class.getClassLoader());
	}

	@Test
	public void testJdbc() throws ClassNotFoundException, SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://10.1.200.144/lagou", "lagourw", "JUY#*f2349Kl");
		PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement("select count(1) from user");
		ResultSet rs = pstmt.executeQuery();
		System.out.println(rs);
	}
	
	
	@Test
	public void testsss(){
		ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class,ClassLoader.getSystemClassLoader().getParent());
		Iterator<Driver> it = serviceLoader.iterator();
		while(it.hasNext()){
			Driver driver = it.next();
			System.out.println(driver.getClass()+":"+driver.getClass().getClassLoader());
		}
		System.out.println(Thread.currentThread().getContextClassLoader());
		System.out.println(DriverManager.class.getClassLoader());
		
	}
	
	
}
