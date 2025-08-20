//we can use criteria to fetch data...
 
package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.example.Student;

public class CriteriaExample {
	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Criteria c = session.createCriteria(Student.class); //the class whose object we want
		
		//to make restrictions....
		//c.add(Restrictions.eq("certi.course", "MERN"));
		//c.add(Restrictions.gt("id", 24)); //greater than restriction
		//c.add(Restrictions.lt("id", 24)); //less than
		c.add(Restrictions.like("certi.course", "java%")); //insensitive like 
		
		List<Student> students = c.list();
		
		for(Student st : students)
		{
			System.out.println(st);
		}
		session.close(); 
	}
}
