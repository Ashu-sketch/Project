package com.controller.bean.dao;

import java.util.Date;

public class UsersFooddata {
public UsersFooddata(Date dateOfSubmission, String userName, String foodGroup) {
		super();
		this.dateOfSubmission = dateOfSubmission;
		this.userName = userName;
		this.foodGroup = foodGroup;
	}
public UsersFooddata(String food) {
		super();
		this.food = food;
	}
public UsersFooddata(Date dateOfSubmission, String foodGroup, String food, String mealType, float serving) {
		super();
		this.dateOfSubmission = dateOfSubmission;
		this.foodGroup = foodGroup;
		this.food = food;
		this.mealType = mealType;
		this.serving = serving;
	}

public UsersFooddata() {
	
}

private int id;
private Date dateOfSubmission;
private String userName;
private String foodGroup;
private String food;
private String mealType;
private float serving;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getDateOfSubmission() {
	return dateOfSubmission;
}
public void setDateOfSubmission(Date dateOfSubmission) {
	this.dateOfSubmission = dateOfSubmission;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getFoodGroup() {
	return foodGroup;
}
public void setFoodGroup(String foodGroup) {
	this.foodGroup = foodGroup;
}
public String getFood() {
	return food;
}
public void setFood(String food) {
	this.food = food;
}
public String getMealType() {
	return mealType;
}
public void setMealType(String mealType) {
	this.mealType = mealType;
}
public float getServing() {
	return serving;
}
public void setServing(float serving) {
	this.serving = serving;
}




}
