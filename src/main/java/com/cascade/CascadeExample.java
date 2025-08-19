//cascade related entities k sath me work krne k liye use hota h 

package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapp.Answer;
import com.mapp.Question;

public class CascadeExample {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s=factory.openSession();
		
		Question q1=new Question();
		q1.setQuestionId(104);
		q1.setQuestion("what is cascade");
		
		Answer a1 = new Answer(204, "mechanism used to automatically propagate the state of a parent entity to its associated child entities ");
		Answer a2 = new Answer(205, "when a specific operation is performed on the parent");
		Answer a3 = new Answer(206, "This eliminates the need to explicitly perform the same operation on each related child entity");
		
		List<Answer> list=new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		Transaction tx = s.beginTransaction();
		
		//without cascade
//		s.save(q1);
//		s.save(a1);
//		s.save(a2);
//		s.save(a3);
		
		//when we have multiple answers to save then we have to save them one by one. that's why here we use cascading
		//koi bhi activity agr hum perform krenge main entity(Querstion) pr, to usse jitni bhi related entities(suppose Answer) hogi unpr activity khud se perform ho jaegi
		
		
		//hum jese hi question save krenge sari related entities khud se save ho jaengi
		s.save(q1);
		
		
		
		
		tx.commit();
		s.close();
		factory.close();

	}

}
