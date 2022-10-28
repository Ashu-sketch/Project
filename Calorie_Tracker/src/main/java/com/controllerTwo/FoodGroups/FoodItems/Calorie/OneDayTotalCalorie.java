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


@WebServlet("/OneDayTotalInCalorie")
public class OneDayTotalCalorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BackendClass back=new BackendClass();
    
    public OneDayTotalCalorie() {
        super();
        this.back=new BackendClass();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int particularUserId= (int) (request.getAttribute("particularUserId"));
		Date eachDayFoodDataDate=(Date) (request.getAttribute("eachDayFoodDataDate"));
		float calorieIn=back.calculateNetCalorie(particularUserId, eachDayFoodDataDate);	
		request.setAttribute("userOneDayCalorie", calorieIn);		
		float calorieOut=back.calculateNetCalorieBurnOfTheDay(particularUserId, eachDayFoodDataDate);		
		request.setAttribute("calorieOut", calorieOut);		
		float bmr=back.getUserBMRFromDB(particularUserId);
		request.setAttribute("userBMR", bmr);		
		//netCalorie Calculation
		float netCalorieOfTheDay=calorieIn-calorieOut-bmr;
		request.setAttribute("netCalorieOfTheDay", netCalorieOfTheDay);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view?id="+particularUserId );
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
