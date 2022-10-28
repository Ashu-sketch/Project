package com.controllerTwo.FoodGroups.FoodItems.Calorie;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.controller.bean.dao.User;
public class BackendClass {

	//get Food group
	public List<FoodGroup> foodGroup() {
		 ArrayList<FoodGroup> fgList = new ArrayList<FoodGroup>();
		    Connection con = null;
		    Statement statement = null;
		    ResultSet resultSet = null;
		   

		    try {
		    	 con=ConnectionClassForTry.createConnection();
		        statement = con.createStatement();
		        resultSet = statement.executeQuery("select * from foodgroup");
		        while(resultSet.next()){
		        	FoodGroup fg = new FoodGroup();
		             fg.setId(resultSet.getInt("fgId"));
		        	
		        	fg.setName(resultSet.getString("foodg"));
		        	fgList.add(fg);
		        }	        
	}
		    catch (Exception e) {
		    	System.out.println(e);
		    	e.printStackTrace();
		    }
	   return fgList; 
	    }
	

	public List<FoodItems> getfoodByFoodGroupId(String foodg){
	    List<FoodItems> foods = new ArrayList<>();
	    
	    try{
	    	Connection connection =ConnectionClassForTry.createConnection();

	       PreparedStatement pst = connection.prepareStatement("select * from fooddb where foodg=?");
	        pst.setString(1, foodg);
	       ResultSet rs = pst.executeQuery();
	        while(rs.next()){
	            FoodItems f = new FoodItems();
	            f.setId(rs.getInt("foodId"));
	            f.setFoodGroup(rs.getString("foodg"));
	            f.setFoodg_id(rs.getInt("fgId"));
	            f.setName(rs.getString("foodname"));
	            f.setCalorie(rs.getFloat("calorie"));
	            foods.add(f);
	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	    } 
	    return foods;
	}
	public List<FoodItems> getCalorie(String foodName){
	    List<FoodItems> calorieOfParticularFood = new ArrayList<>();
	    
	    try{
	    	Connection connection =ConnectionClassForTry.createConnection();

	       PreparedStatement pst = connection.prepareStatement("select calorie from fooddb where foodname=?");
	        pst.setString(1, foodName);
	       ResultSet rs = pst.executeQuery();
	        while(rs.next()){
	            FoodItems c = new FoodItems();
	
	            c.setCalorie(rs.getFloat("calorie"));
	           calorieOfParticularFood.add(c);
	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	    } 
	    return calorieOfParticularFood;
	}
	//foodGroup
		public void insertFoodData(UsersFooddataTry selectedFood) {
			
			try {
				
				Connection con=ConnectionClassForTry.createConnection();
				String q="insert into userFoodData (dateOfSubmission, foodGroup,food, mealType, serving, calorie, userId,userName) values(?,?,?,?,?,?,?,?)";
		

				//String q="insert into userFoodData (food) values(?);";
				PreparedStatement pst=con.prepareStatement(q);
				
				pst.setDate(1, (Date) selectedFood.getDateOfSubmission());
				pst.setString(2, selectedFood.getFoodGroup());
				pst.setString(3, selectedFood.getFood());
				pst.setString(4, selectedFood.getMealType());
				pst.setFloat(5, selectedFood.getServing());
				pst.setFloat(6, selectedFood.getCalorie());
				pst.setInt(7, selectedFood.getUserId());
				pst.setString(8, selectedFood.getUserName());
				
				 pst.executeUpdate();	
		   pst.close();
				con.close();
				
				
				
	 } catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			}
	}
	
		//userFood Data by ID
				public List<UsersFooddataTry> getInsertedFoodDataFromDB(int userId, Date dateOfFoodSubmission ){
				    List<UsersFooddataTry> userFoodData = new ArrayList<>();
				    
				    try{
				    	Connection connection =ConnectionClassForTry.createConnection();

				       PreparedStatement pst = connection.prepareStatement("select * from userFoodData where userId=? AND dateOfSubmission=?");
				       pst.setInt(1, userId);
				       pst.setDate(2, dateOfFoodSubmission);
				      
				      ResultSet rs = pst.executeQuery();
				      while(rs.next()){
				      UsersFooddataTry userFoodDataFromDB = new UsersFooddataTry();
				      userFoodDataFromDB.setDateOfSubmission(rs.getDate("dateOfSubmission"));
				      userFoodDataFromDB.setUserName(rs.getString("userName"));
				      userFoodDataFromDB.setFood(rs.getString("food"));
				      userFoodDataFromDB.setFoodGroup(rs.getString("foodGroup"));
				      userFoodDataFromDB.setMealType(rs.getString("mealType"));
				      userFoodDataFromDB.setServing(rs.getFloat("serving"));
				      userFoodDataFromDB.setCalorie(rs.getFloat("calorie"));				      
				      userFoodData.add(userFoodDataFromDB);				     
				        }
				    }catch(SQLException e){
				    	System.out.println("check your query"+ e);
				        e.printStackTrace();
				    } 
				    return userFoodData;
				}
	//Activity Module Methods
	//get Activity group
		public List<ActivityGroup> activityGroup() {
			 ArrayList<ActivityGroup> agList = new ArrayList<ActivityGroup>();
			    Connection con = null;
			    Statement statement = null;
			    ResultSet resultSet = null;
			   

			    try {
			    	 con=ConnectionClassForTry.createConnection();
			        statement = con.createStatement();
			        resultSet = statement.executeQuery("select * from activitygroup");
			        while(resultSet.next()){
			        	ActivityGroup ag = new ActivityGroup();
			             ag.setId(resultSet.getInt("agId"));
			        	
			        	ag.setName(resultSet.getString("activityg"));
			        	agList.add(ag);
			        }	        
		}
			    catch (Exception e) {
			    	System.out.println(e);
			    	e.printStackTrace();
			    }
		   return agList; 
		    }
		public List<ActivityNames> getActivitybyActivityG(String activityG){
		    List<ActivityNames> activities = new ArrayList<>();
		    
		    try{
		    	Connection connection =ConnectionClassForTry.createConnection();

		       PreparedStatement pst = connection.prepareStatement("select * from activity where activityg=?");
		        pst.setString(1, activityG);
		       ResultSet rs = pst.executeQuery();
		        while(rs.next()){
		            ActivityNames a = new ActivityNames();
		           a.setName(rs.getString("activityname"));
		           a.setActivityGroup(rs.getString("activityg"));
		           a.setMetvalue(rs.getFloat("metValue"));
		            activities.add(a);
		        }
		    }catch(SQLException e){
		        e.printStackTrace();
		    } 
		    return activities;
		}
		//MetValue Based on Particular Activity 
		public List<ActivityNames> getMetValue(String activityName){
		    List<ActivityNames> metvalueFromDataBase = new ArrayList<>();
		    
		    try{
		    	Connection connection =ConnectionClassForTry.createConnection();

		       PreparedStatement pst = connection.prepareStatement("select metValue from activity where activityname=?");
		        pst.setString(1, activityName);
		       ResultSet rs = pst.executeQuery();
		        while(rs.next()){
		            ActivityNames activityInfo = new ActivityNames();
		
		            activityInfo.setMetvalue(rs.getFloat("metValue"));
		            metvalueFromDataBase.add(activityInfo);
		        }
		    }catch(SQLException e){
		    	System.out.println("please check your query"+ e);
		        e.printStackTrace();
		    } 
		    return metvalueFromDataBase;
		}
public void insertActivityData(UserActivityData selectedActivityData) {
			
			try {
				
				Connection con=ConnectionClassForTry.createConnection();
				String q="insert into userActivity (userName, dateOfSubmission, activity,calorieburnt, activityGroup,userId, duration ) values(?,?,?,?,?,?,?)";

				PreparedStatement pst=con.prepareStatement(q);	
				
				pst.setString(1, selectedActivityData.getUserName());	
				pst.setDate(2, selectedActivityData.getDateOfSubmission());
				pst.setString(3, selectedActivityData.getActivity());
				
				pst.setFloat(4, selectedActivityData.getMetvalue());
				pst.setString(5, selectedActivityData.getActivityGroup());
				pst.setInt(6, selectedActivityData.getUserId());
				pst.setInt(7, selectedActivityData.getDuration());
			

				 pst.executeUpdate();	
		         pst.close();
				 con.close();
	 } catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			}
	
}
//display userActivity according to the date
public List<UserActivityData> getInsertedActivityDataFromDB(int userId, Date dateOfFoodSubmission) {
	List<UserActivityData> useractivityData = new ArrayList<>();
	try{
    	Connection connection =ConnectionClassForTry.createConnection();

       PreparedStatement pst = connection.prepareStatement("select * from userActivity where userId=? AND dateOfSubmission=?");
       pst.setInt(1, userId);
       pst.setDate(2, dateOfFoodSubmission);
      
      ResultSet rs = pst.executeQuery();
      while(rs.next()){
      UserActivityData userActivityDataFromDb = new  UserActivityData();
     userActivityDataFromDb.setDateOfSubmission(rs.getDate("dateOfSubmission"));
     userActivityDataFromDb.setActivity(rs.getString("activity"));
     userActivityDataFromDb.setDuration(rs.getInt("duration"));
     userActivityDataFromDb.setMetvalue(rs.getFloat("calorieburnt"));
    
      useractivityData.add(userActivityDataFromDb);		     
        }
    }catch(SQLException e){
    	System.out.println("check your query"+ e);
        e.printStackTrace();
    } 
	return useractivityData;
}
	//calculate net InCalroie of the day
public float calculateNetCalorie(int userId,Date dateOfFoodSubmission ) {

	float calorieIn=0;
	try {
		Connection connection =ConnectionClassForTry.createConnection();

	       PreparedStatement pst = connection.prepareStatement("select sum(calorie) as totalcalorieIn \r\n"
	       		+ "	from userFoodData  where userId=? and dateOfSubmission =?");
	       pst.setInt(1, userId);
	       pst.setDate(2, dateOfFoodSubmission);
	       ResultSet rs = pst.executeQuery();
	       if(rs.next()) {
	    	   calorieIn= rs.getFloat("totalcalorieIn");
	    	   
	       }
	} catch (Exception e) {
	
	}
	return calorieIn;
	
}
//net calorieBurn Of the day
public float calculateNetCalorieBurnOfTheDay(int userId,Date dateOfFoodSubmission ) {

	float calorieOut=0;
	try {
		Connection connection =ConnectionClassForTry.createConnection();

	       PreparedStatement pst = connection.prepareStatement("select sum(calorieburnt) as totalcalorieOut \r\n"
	       		+ "from userActivity  where userId=? and dateOfSubmission =? ");
	       pst.setInt(1, userId);
	       pst.setDate(2, dateOfFoodSubmission);
	       ResultSet rs = pst.executeQuery();
	       if(rs.next()) {
	    	   calorieOut=rs.getFloat("totalcalorieOut");
	    	   
	       }
	} catch (Exception e) {
	
	}
	return calorieOut;
	
}
public float getUserBMRFromDB(int userId) {

	float bmr=0;
	try {
		Connection connection =ConnectionClassForTry.createConnection();

	       PreparedStatement pst = connection.prepareStatement("select bmr from users where userId=?");
	       pst.setInt(1, userId);
	      
	       ResultSet rs = pst.executeQuery();
	       if(rs.next()) {
	    	   bmr=rs.getFloat("bmr");
	    	   
	       }
	} catch (Exception e) {
	
	}
	return bmr;
	
}
//public public List<UserActivityData> getUserAllPhysicalData(int userId) {
//	
//}


}


	
	

