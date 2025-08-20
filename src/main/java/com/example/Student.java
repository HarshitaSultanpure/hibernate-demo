package com.example;


import javax.persistence.Cacheable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//hibernate will treat as a entity. will automatically create its table

//@Entity(name = "student_details") //to change the class/entity name hibernate will create the table with updated name.
//@Table(name="mystudents") //the entity name will be same but only table will be created with this name 

//Entity is used to mark class as entity. we can use this annotation on class.
@Entity   
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)   //second level cache of hibernate is enabled
public class Student {
	@Id   //will mark id column as primary key. if we want to make any column as primary key then we will use this annotation on that column name.
	private int id;
	private String name;
	private String city;
	
	@Embedded
	private Certificate certi;
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	} 
	public void setCity(String city) {
		this.city = city;
	}
	public Certificate getCerti() {
		return certi;
	}
	public void setCerti(Certificate certi) {
		this.certi = certi;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
}
