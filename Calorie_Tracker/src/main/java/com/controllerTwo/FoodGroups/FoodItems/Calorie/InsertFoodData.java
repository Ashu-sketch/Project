package com.controllerTwo.FoodGroups.FoodItems.Calorie;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.bean.dao.*;

/**
 * Servlet implementation class insertFoodCopied
 */
@WebServlet("/insertFoodCopied")
public class InsertFoodData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BackendClass back;
    
    public InsertFoodData() {
        super();
       this.back=new BackendClass();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	
	Date dataeOfInsertion=Date.valueOf(request.getParameter("DateOfSubmission"));
	int userId= Integer.parseInt(request.getParameter("id")) ;	
	String userName=request.getParameter("userName");
	String foodGroup=request.getParameter("foodGroup");
	String foodName=request.getParameter("foodName");
	String mealtype=request.getParameter("mealType");
	float calorie=  Float.parseFloat(request.getParameter("calorie"));
	int serving=Integer.parseInt(request.getParameter("serving"));
	float netCalorieIn=calorie*serving;
	System.out.println("netOutcalorie: "+netCalorieIn);
	
	UsersFooddataTry seleFooddata=new  UsersFooddataTry(dataeOfInsertion, userName, userId, foodGroup, foodName, mealtype, serving, netCalorieIn);
      back.insertFoodData(seleFooddata);
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/view");
	    dispatcher.forward(request, response);
	
	}

}
