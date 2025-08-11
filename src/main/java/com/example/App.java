package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "project started");
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        //in case if it could not find file/file is moved somewhere else then we will provide its path...
        //SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        System.out.println(factory);
        System.out.println(factory.isClosed());
    }
}