package com.mapp;

import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappDemo {
	public static void main(String ar[]) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating Question object
//		Question q1 = new Question();
//		q1.setQuestionId(101);
//		q1.setQuestion("what is hibernate");
//		
//		//creating Answer object
//		Answer ans1 = new Answer();
//		ans1.setAnswerId(201);
//		ans1.setAnswer("hibernate is a java framework");
//		ans1.setQues(q1);
//		
//		Answer ans2 = new Answer();
//		ans2.setAnswerId(203);
//		ans2.setAnswer("it maps Java objects to database tables");
//		ans2.setQues(q1);
//		
//		Answer ans3 = new Answer();
//		ans3.setAnswerId(204);
//		ans3.setAnswer("and lets you work with data using Java code instead of writing SQL directly.");
//		ans3.setQues(q1);
//		
//		List<Answer> list = new ArrayList<Answer>();
//		list.add(ans1);
//		list.add(ans2);
//		list.add(ans3);
//		
//		q1.setAnswers(list);
//		
		//session 
		Session sc = factory.openSession();
		Transaction tx = sc.beginTransaction();
		
		
		Question q = (Question)sc.get(Question.class, 101);
		
		//lazy loading
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswers().size()); //to get the size of answers
		
//		for(Answer a: q.getAnswers())
//		{
//			System.out.println(a.getAnswer());
//		}
//		sc.save(q1);
//		sc.save(ans1);
//		sc.save(ans2);
//		sc.save(ans3);
//		
		
		tx.commit();
		
		sc.close();
		factory.close();
		
		//answer_answer_id is our foreign key. foreign key is a column that establishes a link between data in two tables.
	}
}
