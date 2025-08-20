//second level cache factory level pr available hota h mtlb jaha jaha hum factory use krenge vaha hum second level cache use krte h
//second level cache multiple sessions k bich me bhi available hoti h..

package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Student;


public class SecondDemo {

	public static void main(String[] args) {
	//by default the entity is not cachable so we use annotation to bring that in second level annotation
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//first session
		Session session1 = factory.openSession();
		Student student1 = session1.get(Student.class, 1);
		System.out.println(student1);
		
		session1.close();
		
		//second session
		Session session2 = factory.openSession();
		Student student2 = session2.get(Student.class, 1);
		System.out.println(student2);
		
		
		//dono sessions k liye ek hi baar query fire hogi
		session2.close();
//		factory.close();
		
	}
}