package com.controllerTwo.FoodGroups.FoodItems.Calorie;

public class ActivityNames {
	public ActivityNames() {
		super();
	}
	public ActivityNames(int id, String name, String activityGroup, float metvalue) {
		super();
		this.id = id;
		this.name = name;
		this.activityGroup = activityGroup;
		this.metvalue = metvalue;
	}
	private int id;
	private String name;
	private String activityGroup;
	private float metvalue;
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
	public String getActivityGroup() {
		return activityGroup;
	}
	public void setActivityGroup(String activityGroup) {
		this.activityGroup = activityGroup;
	}
	public float getMetvalue() {
		return metvalue;
	}
	public void setMetvalue(float metvalue) {
		this.metvalue = metvalue;
	}

}
