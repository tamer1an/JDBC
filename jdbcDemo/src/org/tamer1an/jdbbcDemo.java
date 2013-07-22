package org.tamer1an;

import org.tamer1an.model.Circle;

import src.tamer1an.dao.JdbcDaoImpl;

public class jdbbcDemo {

	public static void main(String[] args) {
		Circle circle = new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());
	}

}
