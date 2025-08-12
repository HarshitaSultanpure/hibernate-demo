package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{ 
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "project started");
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        //in case if it could not find file/file is moved somewhere else then we will provide its path...
        //SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        Student st = new Student();
        st.setId(102);
        st.setName("harshita");
        st.setCity("indore");
        
        System.out.println(st);
        
        Address ad = new Address();
        //id will be auto incremented
        ad.setStreet("stree1");
        ad.setCity("pune");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);
        
        //Reading image 
        FileInputStream fi = new FileInputStream("src/main/java/pic.png");
        byte[] data = new byte[fi.available()];
        fi.read(data);
        ad.setImage(data);
        
        System.out.println("done.....");
        
        //to open new session....
        Session session = factory.openSession();
        
        //start transaction to commit changes in physical database....
        Transaction tx = session.beginTransaction();
        
        //to save object....
        session.save(st);
        session.save(ad);
        
        //to get current transaction and commit changes
        //session.getTransaction().commit();
        tx.commit();
        
        session.close();
        }
}