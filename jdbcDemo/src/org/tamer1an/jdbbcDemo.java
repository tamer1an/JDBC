package org.tamer1an;

import org.tamer1an.model.Circle;
import org.tamer1an.dao.JdbcDaoImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class jdbbcDemo {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		
//		Circle circle = dao.getCircle(1);
//		System.out.println(circle.getName());
		
		
		System.out.println(dao.getAllCircles().size());
	}
}
