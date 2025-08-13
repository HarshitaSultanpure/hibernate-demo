package com.mapp1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String ar[]) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
	
		Employee e1 = new Employee();
		Employee e2 = new Employee();
	
		e1.setEid(34);
		e1.setName("ram");
		
		e2.setEid(35);
		e2.setName("shyam");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(1);
		p1.setName("library management system");
		p2.setPid(2);
		p2.setName("chatbot");
		
		List<Employee> list1= new ArrayList<Employee>();
		List<Project> list2= new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		e1.setProjects(list2);
		p2.setEmps(list1);
		
		Session sc = factory.openSession();
		Transaction tx = sc.beginTransaction();
		
		sc.save(e1);
		sc.save(e2);
		sc.save(p1);
		sc.save(p2);
		
		tx.commit();
		
		sc.close();
		factory.close();
	}
}
