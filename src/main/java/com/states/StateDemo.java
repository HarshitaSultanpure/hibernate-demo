package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Address;
import com.example.Certificate;
import com.example.Student;

public class StateDemo {

	public static void main(String[] args) {
		//practical of hibernate object state
//		transient
//		persistent
//		detached
//		removed
		
		System.out.println("state");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Student student = new Student();
		student.setId(1);
		student.setName("ranu");
		student.setCity("khandwa");
		student.setCerti(new Certificate("java hibernate course","2 month")); 
		// through above steps the object has come into Transient state... data is neither associated with database nor session obj
		
		Session sc = factory.openSession();
		Transaction tx = sc.beginTransaction();
		sc.save(student); //object will move to Persistent state... will be in database, session
		student.setName("john");// the data will be updated automatically into db...
		tx.commit();
		
//		Student st = (Student)sc.get(Student.class, 1);
//		System.out.println(st.getCity());
//		sc.delete(st);  //when we get value from db and delete it, it will be in Removed state means values will be removed from db but will be associated with session..
		
		sc.close();// object will be moved in Detached state
//		student.setName("nobita"); //data is associated in db but change will not be reflected in db
		
		factory.close();
		
	}

}
