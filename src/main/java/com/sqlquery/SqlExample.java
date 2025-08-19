package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.example.Student;

public class SqlExample {

	public static void main(String[] args) {
		// SQL queries are native querites 
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		String q = "select * from student";
		
		NativeQuery nq = s.createSQLQuery(q); //this method will return our native query object. an interface represents native query.
		List<Object[]> list=nq.list(); //jo bhi data fetch hoga vo Object k form me hoga 
		
		for(Object[] student : list)
		{
//			System.out.println(Arrays.deepToString(student)); //will proivde complete data
			System.out.println(student[4]+" : "+student[3]); //will provide 3rd(city) column and 4th column(name)
		}
		
		s.close();
		factory.close();
	}

}
