package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.Student;

public class HqlPagination {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
//		pagination means the number of elements we want to get/fetch like starting from 1 to 10 elements or from 10 to 20 elementes
//		suppose we have pages which will have some elements or rows
		
		Session s = factory.openSession();
		Query query = s.createQuery("from Student",Student.class); //by generic we tell that this query expecting Studnet data.
		
		//implementing pagination using hibernate
		
		query.setFirstResult(1); //from where we want to start.
		query.setMaxResults(5); // max size of page or max amount of values we want to fetch
		
		List<Student> list=query.list();  //returns json format
		
		for(Student st:list)
		{
			System.out.println(st.getName()+" : "+st.getId()+" : ");
		}
		
		s.close();
		factory.close();
	}
}
