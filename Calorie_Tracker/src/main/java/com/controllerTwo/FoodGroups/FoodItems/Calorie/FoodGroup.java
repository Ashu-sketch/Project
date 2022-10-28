package com.controllerTwo.FoodGroups.FoodItems.Calorie;

public class FoodGroup {
	public FoodGroup(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private int id;
	private String name;
	public FoodGroup() {
		
		super();
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
	
	

}
