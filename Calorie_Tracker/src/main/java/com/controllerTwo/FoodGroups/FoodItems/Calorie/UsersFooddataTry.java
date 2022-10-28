package com.controllerTwo.FoodGroups.FoodItems.Calorie;

import java.util.Date;

public class UsersFooddataTry {


public UsersFooddataTry(Date dateOfSubmission, String userName, int userId, String foodGroup, String food,
			String mealType, float serving, float calorie) {
		super();
		this.dateOfSubmission = dateOfSubmission;
		this.userName = userName;
		this.userId = userId;
		this.foodGroup = foodGroup;
		this.food = food;
		this.mealType = mealType;
		this.serving = serving;
		this.calorie = calorie;
	}
public UsersFooddataTry(Date dateOfSubmission, String userName, int userId, String foodGroup, String food,
			String mealType, float serving) {
		super();
		this.dateOfSubmission = dateOfSubmission;
		this.userName = userName;
		this.userId = userId;
		this.foodGroup = foodGroup;
		this.food = food;
		this.mealType = mealType;
		this.serving = serving;
	}
public UsersFooddataTry(Date dateOfSubmission, String userName, String foodGroup) {
		super();
		this.dateOfSubmission = dateOfSubmission;
		this.userName = userName;
		this.foodGroup = foodGroup;
	}
public UsersFooddataTry(String food) {
		super();
		this.food = food;
	}
public UsersFooddataTry(Date dateOfSubmission, String foodGroup, String food, String mealType, float serving) {
		super();
		this.dateOfSubmission = dateOfSubmission;
		this.foodGroup = foodGroup;
		this.food = food;
		this.mealType = mealType;
		this.serving = serving;
	}

public UsersFooddataTry() {
	
}

private int id;
private Date dateOfSubmission;
private String userName;
private int userId;
private String foodGroup;
private String food;
private String mealType;
private float serving;
private float calorie;
private float netCAlorieIn;


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
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public float getCalorie() {
	return calorie;
}
public void setCalorie(float calorie) {
	this.calorie = calorie;
}
public float getNetCAlorieIn() {
	return netCAlorieIn;
}
public void setNetCAlorieIn(float netCAlorieIn) {
	this.netCAlorieIn = netCAlorieIn;
}




}
