package com.mapp;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappDemo {
	public static void main(String ar[]) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating Question object
		Question q1 = new Question();
		q1.setQuestionId(101);
		q1.setQuestion("what is hibernate");
		
		//creating Answer object
		Answer ans1 = new Answer();
		ans1.setAnswerId(201);
		ans1.setAnswer("hibernate is a java framework");
		ans1.setQues(q1);
		
		q1.setAnswer(ans1);
		
		Question q2 = new Question();
		q2.setQuestionId(102);
		q2.setQuestion("what is HQL");
		
		Answer ans2 = new Answer();
		ans2.setAnswerId(202);
		ans2.setAnswer("Like SQL but works with Java objects instead of tables.");
		ans2.setQues(q2);  //dono table me ek ek join column bn jaenge
		
		q2.setAnswer(ans2);
		
		//session 
		Session sc = factory.openSession();
		Transaction tx = sc.beginTransaction();
		
		sc.save(q1);
		sc.save(q2);
		
		sc.save(ans1);
		sc.save(ans2);
		
		tx.commit();
		
		//fetching data....
		Question q = (Question) sc.get(Question.class, 101);
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswer().getAnswer());
		
		
		sc.close();
		factory.close();
		
		//answer_answer_id is our foreign key. foreign key is a column that establishes a link between data in two tables.
	}
}
