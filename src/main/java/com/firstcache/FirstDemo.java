//caching is a mechanism to enhance perfromance of a application
//it is used to reduce the number of database queries.
 
package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Student;

public class FirstDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		//first level cache is bydefault enabled and associated with session object...
		Student st1 = s.get(Student.class, 1);
		System.out.println(st1);
		System.out.println("working something");
		
		//we want the detail of same student again so we would need to create the object again 
		Student st2 = s.get(Student.class, 1);
		System.out.println(st2);     
		//hibernate ne is student k obj ko s session ki cache memory me store kr dia. 
//		jb humne again same obj ko get kia to hibernate will check if the same memory already exist or not 
//		and it will get obj so it wont fire the same query again.
		
		
		System.out.println(s.contains(st1));//checks if the object available in session cache
		
		s.close();
		factory.close();
	}
}