package com.controllerTwo.FoodGroups.FoodItems.Calorie;

import java.text.DateFormat;
import java.util.Date;

public class FoodItems {
	
	public FoodItems(String name, int foodg_id, float serving, float calorie, String mealType, String foodGroup) {
		super();
		this.name = name;
		this.foodg_id = foodg_id;
		this.serving = serving;
		this.calorie = calorie;
		this.mealType = mealType;
		this.foodGroup = foodGroup;
	}
	public FoodItems() {
		super();
	}
	public FoodItems(String name, float serving, String mealType, String foodGroup) {
		super();
		this.name = name;
		this.serving = serving;
		this.mealType = mealType;
		this.foodGroup = foodGroup;
	}
	private int id;
	private String name;
	private int foodg_id;
	private float serving;
	private float calorie;
	private String mealType;
	private String foodGroup;
	
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
	public int getFoodg_id() {
		return foodg_id;
	}
	public void setFoodg_id(int foodg_id) {
		this.foodg_id = foodg_id;
	}
	public float getServing() {
		return serving;
	}
	public void setServing(float serving) {
		this.serving = serving;
	}
	public float getCalorie() {
		return calorie;
	}
	public void setCalorie(float calorie) {
		this.calorie = calorie;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public String getFoodGroup() {
		return foodGroup;
	}
	public void setFoodGroup(String foodGroup) {
		this.foodGroup = foodGroup;
	}
	
	
	
	
	
}