package com.controller.bean.dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controllerTwo.FoodGroups.FoodItems.Calorie.BackendClass;
import com.controllerTwo.FoodGroups.FoodItems.Calorie.UserActivityData;
import com.controllerTwo.FoodGroups.FoodItems.Calorie.UsersFooddataTry;

@WebServlet("/")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao logic;	
    public controller() {
        super();
        this.logic=new UserDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {this.doGet(request, response);}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		   
			 String action = request.getServletPath();

		        try {
		            switch (action) {
		                case "/new":
		                    showNewForm(request, response);
		                    break;
		                case "/insert":
		                    insertUser(request, response);
		                    break;
		                case "/delete":
		                    deleteUser(request, response);
		                    break;
		                case "/edit":
		                    showEditForm(request, response);
		                    break;		             
		                case "/view":
		                	viewPage(request, response);
		                    break;
		                case "/User_Details":
		                	User_Details(request, response);
		                    break;
		                case "/update":
		                    updateUser(request, response);
		                    break;
	                    default:
		                    userlist(request, response);
		                    break;
		            }
		        } catch (SQLException ex) {
		            throw new ServletException(ex);
		        }
		    }
		
private void viewPage(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
    User user = logic.selectUser(id);
    RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
      
    request.setAttribute("user", user);
    dispatcher.forward(request, response);			
		}

//  iterate all the list of both activity and fooddata of person
private void User_Details(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
	BackendClass back=new BackendClass();
	
	HttpSession session=request.getSession();	
	int id = Integer.parseInt(request.getParameter("id"));
    User user = logic.selectUser(id);
    
    List<UsersFooddataTry> userFoodData= back.getAllFoodDataOfUser(id);
	 session.setAttribute("userFoodData",userFoodData);
  
    List<UserActivityData> useractivityData= back.getAllActivityDataOfUser(id);
	 session.setAttribute("useractivityData",useractivityData);
    RequestDispatcher dispatcher = request.getRequestDispatcher("User_Data.jsp");
   
    request.setAttribute("user", user);
    dispatcher.forward(request, response);			
		}

		private void userlist(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
		    HttpSession session=request.getSession();
		    List<User> userlist= logic.getUsers();
			 		 
			session.setAttribute("userlist", userlist);			
			RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");
	        dispatcher.forward(request, response);		
		}
		private void updateUser(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");	        
	        float weight=Float.parseFloat(request.getParameter("weight"));
	        float height=Float.parseFloat(request.getParameter("height"));
	        String gender=request.getParameter("gender");
	        Date age=Date.valueOf(request.getParameter("dob"));
	       
	        User user =new User(id, name, weight, height, gender, age);
	        logic.updateUser(user);
	        response.sendRedirect("list");		
		}
		
		private void showEditForm(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
	        User user = logic.selectUser(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Edit.jsp");
	        request.setAttribute("user", user);
	        dispatcher.forward(request, response);			
		}
		
		private void deleteUser(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException{
			int id = Integer.parseInt(request.getParameter("id"));
	        logic.deleteUser(id);
	        response.sendRedirect("list");	
		}
		private void insertUser(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
			
			    //getting user data from the sign up form
			    String name=request.getParameter("name");
				float weight=Float.parseFloat(request.getParameter("weight"));
		        float height=Float.parseFloat(request.getParameter("height"));
		        String gender=request.getParameter("gender");
		        Date age=Date.valueOf(request.getParameter("dob"));

		      User user=new User(name, weight, height, gender, age);
		      logic.insert(user);
		        
		      response.sendRedirect("list");
		}
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
			 RequestDispatcher dispatcher = request.getRequestDispatcher("SignUp.jsp");
		        dispatcher.forward(request, response);			
		}		
}

