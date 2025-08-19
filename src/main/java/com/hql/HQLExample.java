package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.Student;

public class HQLExample {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session s=factory.openSession();
		
		//HQL 
		//hql queries are not native queries they does not depend on a particular database.
		//Syntax 
		//String query = "from Student"; //will select all columns from Student table
		//String query = "from Student where city='pune'"; //get data from particular column
		//String query = "from Student where city=:x"; //dynamic input 
		
		String query = "from Student as s where city=:x and s.name=:n";
		
		Query q1 = s.createQuery(query); //it expects HQL Session method to get query object to fire query
		q1.setParameter("x", "pune"); //to set dynamic value
		q1.setParameter("n", "itasu");
		
		//to get single result (Single-Unique)
		//q1.uniqueResult();
				
		
		//to get multiple result (multiple-list)
		List<Student> list = q1.list();
		
		for(Student st:list)
		{
			System.out.println(st.getName()+" : "+st.getCerti().getCourse());
		}
		
		System.out.println("......................................\n\n");
		
		//to delete we need transaction
		Transaction tx=s.beginTransaction();
//		Query q2=s.createQuery("delete from Student where city=:c");
//		q2.setParameter("c", "pune");
//		int r=q2.executeUpdate();
//		System.out.println("deleted : "+r);
		
		//to update using alias (Alias query means using short names (aliases) for entities in HQL e.g. c is alias of City class)
		Query q3=s.createQuery("update Student set city=:c where name=:n");
		q3.setParameter("c", "pune");
		q3.setParameter("n", "john");
		int r1=q3.executeUpdate();
		System.out.println(r1+": objects updated");
		
//		to execute join query......   q is alias(short name) of Question
		Query q4=s.createQuery("select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answers as a ");  //question wali field se answers wali field pr join apply kia
		List<Object []> list4 = q4.getResultList(); //this method will provide list of Object[] as it is obj of Object 
		
		for(Object[] arr:list4)
		{
			System.out.println(Arrays.toString(arr));
		}
		tx.commit();
		s.close();
		factory.close();
	}
}