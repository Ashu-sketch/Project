package com.controllerTwo.FoodGroups.FoodItems.Calorie;

import java.io.IOException;
import java.sql.Date;

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
		HttpSession session=request.getSession();
		int particularUserId= Integer.parseInt(request.getParameter("id"));
		Date eachDayFoodDataDate=Date.valueOf(request.getParameter("eachDayFoodDataDate"));
		float calorieIn=back.calculateNetCalorie(particularUserId, eachDayFoodDataDate);
		
		//calling userOneDayCalorie to show on the view Page
		session.setAttribute("userOneDayCalorie", calorieIn);
		//calling calculateNetCalorieBurnOfTheDay to show on the view Page
		float calorieOut=back.calculateNetCalorieBurnOfTheDay(particularUserId, eachDayFoodDataDate);
		session.setAttribute("calorieOut", calorieOut);
		
		float bmr=back.getUserBMRFromDB(particularUserId);
		session.setAttribute("userBMR", bmr);
		
		float netCalorieOfTheDay=calorieIn-calorieOut-bmr;
		session.setAttribute("netCalorieOfTheDay", netCalorieOfTheDay);
																				
		System.out.println(calorieIn);
		System.out.println(calorieOut);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view?id="+particularUserId );
		//RequestDispatcher dispatcher = request.getRequestDispatcher("ShowUserDetails.jsp");
	    dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
