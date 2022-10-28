<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@page import="com.controller.bean.dao.*" %>
 <%@page import="java.util.ArrayList"%> 
<%@page import="java.util.Iterator"%> 
<%@ page import="java.util.List"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="icon" href="<%=Common.url%>assets/img/favicon.ico" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Calorie Tracker Coding Assignment - User List</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700;800&display=swap" rel="stylesheet">
    <link href="<%=Common.url%>assets/css/global.css" rel="stylesheet">
</head>
<body>
    <div>
        <header class="header">
            <div class="container">
                <div class="logo">
                    <a href="SignUp.jsp">                       
                    </a>                    
                </div>
            </div>
        </header>
        <div class="mid-container">
            <div class="container">
                <div class="title-row">
                <a class="btn-primary add-data-btn" href="<%=request.getContextPath()%>/new" class="btn btn-success">Add new User</a>
                    <a  class="title" href="<%=request.getContextPath()%>/list"><h1>User List</h1></a>                   
                </div>            
                <div class="user-list">
                    <table class="dcf-table dcf-table-responsive dcf-table-bordered dcf-table-striped dcf-w-100%">
                        <thead>                       
                            <tr>
                                <th scope="col" class="name">Name</th>
                                <th scope="col" class="weight">Weight</th>
                                <th scope="col" class="height">Height</th>
                                <th scope="col" class="gender">Gender</th>
                                <th scope="col" class="age">D.O.B</th>
                                <th scope="col" class="bmr">BMR</th>
                                <th scope="col" class="action">Action</th>                               
                            </tr>
                        </thead>
                        <tbody>                            
                <c:forEach items="${userlist }" var="user" varStatus="status">
                            <tr>                           
                                <th scope="session" name="name"> <c:out value="${user.name}" /></th>
                                <td data-label="Weight"><c:out value="${user.weight}" /></td>
                                <td data-label="Height"><c:out value="${user.height}" /></td>
                                <td data-label="Gender">< c:out value="${user.gender}" /></td>
                                <td data-label="Age"><  c:out value="${user.age}" /></td>                            
                                <td data-label="BMR"><c:out value="${user.bmr}" /></td>
                                <c:set var="userBmr" scope="application" value="${user.bmr}" />
                                <td data-label="Action">
                                <div class="btn-set">
                               <a class="btn-secondary"  href="delete?id=<c:out value='${user.id}' />">Delete</a>
                               <a class="btn-secondary"  href="edit?id=<c:out value='${user.id}' />">Edit</a>
                               <a class="btn-secondary" href="view?id=<c:out value='${user.id}' />" >view </a>                               
                           </div>
                                </td>
                            </tr>
                            </c:forEach> 
                        </tbody>
                    </table>
                </div>               
            </div>
        </div>
 <footer class="footer">
            <div class="container">
                <p>2022 LMD Consulting, LLC , All Rights Reserved</p>
            </div>
        </footer>
    </div>    
</body>
<script src="assets/js/jquery.slim.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/custom.js"></script>
</html>