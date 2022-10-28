package com.controllerTwo.FoodGroups.FoodItems.Calorie;

import java.sql.Date;

public class UserActivityData {
	public UserActivityData() {
		super();
	}
	public UserActivityData(Date dateOfSubmission, String userName, int userId, String activityGroup, String activity,
			int duration, Float metvalue) {
		super();
		this.dateOfSubmission = dateOfSubmission;
		this.userName = userName;
		this.userId = userId;
		this.activityGroup = activityGroup;
		this.activity = activity;
		this.duration = duration;
		this.metvalue = metvalue;
	}
	public UserActivityData(Date dateOfSubmission, String userName, int userId, String activityGroup, String activity,
			int duration) {
		super();
		this.dateOfSubmission = dateOfSubmission;
		this.userName = userName;
		this.userId = userId;
		this.activityGroup = activityGroup;
		this.activity = activity;
		this.duration = duration;
	}
	private int id;
	private Date dateOfSubmission;
	private String userName;
	private int userId;
	private String activityGroup;
	private String activity;
	private int  duration;
	private Float metvalue;
	
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getActivityGroup() {
		return activityGroup;
	}
	public void setActivityGroup(String activityGroup) {
		this.activityGroup = activityGroup;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Float getMetvalue() {
		return metvalue;
	}
	public void setMetvalue(Float metvalue) {
		this.metvalue = metvalue;
	}
	
}
