package com.controller.bean.dao;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.controller.bean.dao.*;

public class UserDao  {
	//insertion method
	 public void  insert(User newUser)  {
           Connection con = null;
		   float bmr;
		   String genderCheck="Male";
		  Date userAge= newUser.getAge();
		  @SuppressWarnings("deprecation")
		  int age=java.time.LocalDate.now().getYear()-(userAge.getYear()+1900);
		  float userHieghtInCM=newUser.getHeight();
	       if(newUser.getGender().equalsIgnoreCase(genderCheck)) {	    	   
					//Men’s BMR= 66.4730+(13.7516 x weight in kg)+(5.0033 x height in cm)-(6.7550 x age in years) 
					bmr=(float) (66.4730+(13.7516*newUser.getWeight())+(5.0033*(userHieghtInCM*30.48))-(6.7550 *age));				
					}
				else {
					//Women’s BMR= 655.0955+(9.5634 x weight in kg)+(1.8496 x height in cm)-(4.6756 x age in years) 
	   				   bmr=(float) (655.0955+(9.5634*newUser.getWeight())+(1.8496*newUser.getHeight())-(4.6756*age));
				      }	     		
			try {				
				con=ConnectionClass.createConnection();
			    String q="insert into  users (userName, weight, height, gender, age, bmr ) values(?,?,?,?,?,?);";
				PreparedStatement pst=con.prepareStatement(q);
				pst.setString(1, newUser.getName());
				pst.setFloat(2, newUser.getWeight());
				pst.setFloat(3, newUser.getHeight());
				pst.setString(4, newUser.getGender());					
				pst.setDate(5, newUser.getAge());
				pst.setFloat(6, bmr);
				
               //update the query
				 pst.executeUpdate();
                 pst.close();
				con.close();
	 } catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			}
   }
         public List<User> getUsers() {
		  ArrayList<User> userlist = new ArrayList<User>();
		    Connection con = null;
		    Statement statement = null;
		    ResultSet resultSet = null;
		   try {
		    	con=ConnectionClass.createConnection();
		        statement = con.createStatement();
		        resultSet = statement.executeQuery("SELECT * FROM users");
		        while(resultSet.next()){
		        	User user = new User();
		        	user.setId(resultSet.getInt("userId"));
		        	user.setName(resultSet.getString("userName"));
		        	user.setBmr(resultSet.getFloat("bmr"));
		        	user.setWeight(resultSet.getFloat("weight"));
		        	user.setHeight(resultSet.getFloat("height"));
		        	user.setGender(resultSet.getString("gender"));
		            user.setAge(resultSet.getDate("age"));		        	
		        	  
		        		userlist.add(user);		        
		        }
		    } catch (Exception e) {
		    	System.out.println(e);
		        e.printStackTrace();
		    }

		    return userlist;
		}
	public User selectUser(int id) {
        User user = null;     
        try (Connection connection = ConnectionClass.createConnection();
            
            PreparedStatement pst = connection.prepareStatement("select userName,weight,height,gender,age,bmr from users where userId =?");) {
            pst.setInt(1, id);
            System.out.println(pst);     
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
            	String name=resultSet.getString("userName");
    			float weight=	resultSet.getFloat("weight");
    	        float height=	resultSet.getFloat("height");
    	        String gender=	resultSet.getString("gender");
    	        Date age=   resultSet.getDate("age");   	        	        	
    	        user =new User(id, name, weight, height, gender, age);
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
 return user;
    }
public boolean deleteUser(int id)throws SQLException {
		boolean rowDeletd;
		try (
			Connection con=ConnectionClass.createConnection();
			PreparedStatement pst=con.prepareStatement("delete from users where userId=?");){
			pst.setInt(1, id);
			rowDeletd=pst.executeUpdate()> 0;
		} 
		return rowDeletd;
	}
 public boolean updateUser(User user) throws SQLException {
	        boolean rowUpdated;
	        
	        float bmr;
			   String genderCheck="Male";
			  Date userAge= user.getAge();
			  @SuppressWarnings("deprecation")
			  int age=java.time.LocalDate.now().getYear()-(userAge.getYear()+1900);
			  float userHieghtInCM=user.getHeight();
		       if(user.getGender().equalsIgnoreCase(genderCheck)) {	    	   
						//Men’s BMR= 66.4730+(13.7516 x weight in kg)+(5.0033 x height in cm)-(6.7550 x age in years) 
						bmr=(float) (66.4730+(13.7516*user.getWeight())+(5.0033*(userHieghtInCM*30.48))-(6.7550 *age));				
						}
					else {
						//Women’s BMR= 655.0955+(9.5634 x weight in kg)+(1.8496 x height in cm)-(4.6756 x age in years) 
		   				   bmr=(float) (655.0955+(9.5634*user.getWeight())+(1.8496*user.getHeight())-(4.6756*age));
					      }
	         try (Connection con =ConnectionClass.createConnection(); 
	        	PreparedStatement pst = con.prepareStatement("update users set userName =?,weight= ?, height =?, gender=?, age=?, bmr=? where userId = ?");) {
	        	pst.setString(1, user.getName());
	        	pst.setFloat(2, user.getWeight());
	        	pst.setFloat(3, user.getHeight());
	        	pst.setString(4, user.getGender());
	        	pst.setDate(5, user.getAge());	
	        	pst.setInt(7, user.getId());
	        	pst.setFloat(6, bmr);
	            rowUpdated = pst.executeUpdate() > 0;
	            pst.close();
				con.close();
	        }
	        return rowUpdated;
	    }	
}


	



