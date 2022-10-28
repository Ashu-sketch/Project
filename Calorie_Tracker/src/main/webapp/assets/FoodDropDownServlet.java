package com.controllerTwo.FoodGroups.FoodItems.Calorie;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


/**
 * Servlet implementation class trySomethingNew
 */
@WebServlet("/InsertFoodDataServlet")
public class FoodDropDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   BackendClass back;
	
    public FoodDropDownServlet() {
        super();
        this.back=new BackendClass();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("operation");
        
        if (op.equals("group")) {
            List<FoodGroup> fgList = back.foodGroup();
            Gson json = new Gson();
            String foodGroupList = json.toJson(fgList);
            response.setContentType("text/html");
            response.getWriter().write(foodGroupList);
        }

        if (op.equals("food")) {
            //int iod = Integer.parseInt(request.getParameter("id"));
            String foodg=request.getParameter("name");
            List<FoodItems> foods = back.getfoodByFoodGroupId(foodg);
            Gson json = new Gson();
            String foodGroupList = json.toJson(foods);
            response.setContentType("text/html");
            response.getWriter().write(foodGroupList);
        }
        
        if (op.equals("calorie")) {
            //int iod = Integer.parseInt(request.getParameter("id"));
            String calorieOfFood=request.getParameter("name");
            List<FoodItems> calorieOfParticularFood = back.getCalorie(calorieOfFood);
            Gson json = new Gson();
            String foodGroupList = json.toJson(calorieOfParticularFood);
            response.setContentType("text/html");
            response.getWriter().write(foodGroupList);
        }
       
        //ActivityDropDown Servlet Module using in Ajax in Jsp page
        
        if (op.equals("activityGroup")) {
            List<ActivityGroup> agList = back.activityGroup();
            Gson json = new Gson();
            String activityGroupList = json.toJson(agList);
            response.setContentType("text/html");
            response.getWriter().write(activityGroupList);
        }

        if (op.equals("activity")) {
            //int iod = Integer.parseInt(request.getParameter("id"));
            String activityG=request.getParameter("name");
            List<ActivityNames> activities = back.getActivitybyActivityG(activityG);
            Gson json = new Gson();
            String activityGroupList = json.toJson(activities);
            response.setContentType("text/html");
            response.getWriter().write(activityGroupList);
        }
        
        if (op.equals("metvalue")) {
            //int iod = Integer.parseInt(request.getParameter("id"));
            String activityName=request.getParameter("name");
            List<ActivityNames> metvalueFromDataBase = back.getMetValue(activityName);
            Gson json = new Gson();
            String activityGroupList = json.toJson(metvalueFromDataBase);
            response.setContentType("text/html");
            response.getWriter().write(activityGroupList);
        }

	}
}
		

		 
		
  
 
		
	




