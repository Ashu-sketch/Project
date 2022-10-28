package com.controllerTwo.FoodGroups.FoodItems.Calorie;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.controller.bean.dao.*;

/**
 * Servlet implementation class insertActivityDataServlet
 */
@WebServlet("/insertActivityDataServlet")
public class InsertActivityDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BackendClass back;
   
    public InsertActivityDataServlet() {
        super(); 
        this.back=new BackendClass();
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request, response);
     
     Date dataeOfInsertion=Date.valueOf(request.getParameter("DateOfSubmission"));
 	int userId= Integer.parseInt(request.getParameter("id")) ;
 	String userName=request.getParameter("userName");
 	String activityGroup=request.getParameter("activityGroup");
 	String activityNameactivityName=request.getParameter("activityName");
 	float weightOfUser=Float.parseFloat(request.getParameter("weightOfUser"));
 	float metValue=Float.parseFloat(request.getParameter("metValue"));
 	int duration=Integer.parseInt(request.getParameter("duration"));
 	float calorieBurnAsPerActivity=metValue*weightOfUser*(duration/60);
 	
 	System.out.println(calorieBurnAsPerActivity);
 	
 	UserActivityData selectedActivityData=new  UserActivityData(dataeOfInsertion, userName, userId, activityGroup, activityNameactivityName, duration, calorieBurnAsPerActivity);
 	
 	back.insertActivityData(selectedActivityData);
 	RequestDispatcher dispatcher = request.getRequestDispatcher("/view");
    dispatcher.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
