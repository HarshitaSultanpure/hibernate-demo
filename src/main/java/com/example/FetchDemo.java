package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get, load
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		//get-student : 102 provide entity_type, primary_key
		//get method returns null if obj is not found
		//Student student = (Student)session.get(Student.class, 102);
		//System.out.println(student);
		
		//get-student : 102 through load load() throws ObjectNotFoundException if obj is not found but never return null.
		//Student student = (Student)session.load(Student.class, 102);
		//System.out.println(student);
		
		Address ad = (Address)session.get(Address.class, 1);
		System.out.println(ad.getCity());
		
		session.close();
		factory.close();
	}

}
