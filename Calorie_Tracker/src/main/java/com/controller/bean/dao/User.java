package com.controller.bean.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class User {
	
	public User(int id, String name, float weight, float height, String gender, Date age) {
		super();
		this.id = id;
		Name = name;
		this.weight = weight;
		this.height = height;
		Gender = gender;
		this.age = age;
	}
	private int id; 
	private   String Name;
	private   float weight;
	private   float height;
	private   String Gender;
	@Temporal (TemporalType.DATE)
	private   Date  age;
	private int ageInNumber;
     private float bmr;
     
	public User(String name, float weight, float height, String gender, Date age) {
		super();
		Name = name;
		this.weight = weight;
		this.height = height;
		Gender = gender;
		this.age = age;
	}
	public User(int id, String name, float weight, float height, String gender, Date age, float bmr) {
		super();
		this.id = id;
		Name = name;
		this.weight = weight;
		this.height = height;
		Gender = gender;
		this.age = age;
		this.bmr = bmr;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Date getAge() {
		return age;
	}
	public void setAge(Date age) {
		this.age = age;
	}
	public float getBmr() {
		return bmr;
	}
	public void setBmr(float bmr) {
		this.bmr = bmr;
	}
	public int getAgeInNumber() {
		return ageInNumber;
	}
	public void setAgeInNumber(int ageInNumber) {
		this.ageInNumber = ageInNumber;
	}

}
