package com.example;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbeddDemo{

	public static void main(String[] args) {
		
		//System.out.println(Student.class.getResource("Student.class"));

		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Student student1 = new Student();
		student1.setId(103);
		student1.setName("itasu");
		student1.setCity("pune");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("java");
		certificate1.setDuration("3 months");
		
		student1.setCerti(certificate1);
		
		Student student2 = new Student();
		student2.setId(104);
		student2.setName("ishita");
		student2.setCity("Delhi");
		
		Certificate certificate2 = new Certificate();
		certificate2.setCourse("MERN");
		certificate2.setDuration("1.5 months");
		
		student2.setCerti(certificate2);
		
		Session sc = factory.openSession();
		Transaction tx = sc.beginTransaction();
		
		//save objects.....
		sc.save(student1);
		sc.save(student2);
		
		tx.commit();
		sc.close();
		factory.close();
		
	}

}
