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

/**
 * Servlet implementation class displayFoodData
 */
@WebServlet("/displayFoodData")
public class DisplayFoodData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BackendClass back;
    public DisplayFoodData() {
        super();
        this.back=new BackendClass();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int particularUserId= Integer.parseInt(request.getParameter("id"));
		Date eachDayFoodDataDate=Date.valueOf(request.getParameter("eachDayFoodDataDate"));	
		
		request.setAttribute("particularUserId", particularUserId); request.setAttribute("eachDayFoodDataDate", eachDayFoodDataDate);
		
			 List<UsersFooddataTry> userFoodData= back.getInsertedFoodDataFromDB(particularUserId, eachDayFoodDataDate);
			request.setAttribute("userFoodDataWhichisShown", userFoodData);
			request.getRequestDispatcher("/DisplayuserActivityData").include(request, response);		 
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
