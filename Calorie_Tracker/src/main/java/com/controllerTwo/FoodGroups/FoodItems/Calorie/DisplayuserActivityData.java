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
 * Servlet implementation class displayuserActivityData
 */
@WebServlet("/DisplayuserActivityData")
public class DisplayuserActivityData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BackendClass back;
    public DisplayuserActivityData() {
        super();
       this.back=new BackendClass();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int particularUserId= (int) (request.getAttribute("particularUserId"));
		Date eachDayFoodDataDate=(Date) (request.getAttribute("eachDayFoodDataDate"));
		
		request.setAttribute("particularUserId", particularUserId); request.setAttribute("eachDayFoodDataDate", eachDayFoodDataDate);
		
		HttpSession session=request.getSession();
			 List<UserActivityData> userActivityData= back.getInsertedActivityDataFromDB(particularUserId, eachDayFoodDataDate);
			 request.setAttribute("userActivityDataWhichIssShown", userActivityData);
			 RequestDispatcher rs = request.getRequestDispatcher("/OneDayTotalInCalorie"); rs.include(request, response);
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
