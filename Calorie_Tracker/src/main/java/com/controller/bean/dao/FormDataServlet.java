package com.controller.bean.dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormDataServlet
 */
@WebServlet("/FormDataServlet")
public class FormDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FormDataServlet() {
        super();
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}


private void insertFoodData(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
	Date dataeOfInsertion=Date.valueOf(request.getParameter("dateOfSubmission"));
String foodGroup=request.getParameter("foodGroup");
String food=request.getParameter("food");
String mealtype=request.getParameter("mealtype");
float serving=Float.parseFloat(request.getParameter("serving"));
UsersFooddata userFoodData=new UsersFooddata(dataeOfInsertion,foodGroup,food,mealtype,serving);
response.sendRedirect("userData");






response.sendRedirect("list");
}
private void showFoodData(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
RequestDispatcher dispatcher = request.getRequestDispatcher("SignUp.jsp");
dispatcher.forward(request, response);
}
}