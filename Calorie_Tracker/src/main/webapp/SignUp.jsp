<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%> 
    <%@page import="java.util.Iterator"%> 
    <%@ page import="java.util.List"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <link rel="icon" href="assets/img/favicon.ico" type="image/x-icon">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <title>Calorie Tracker Coding Assignment - Sign up</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700;800&display=swap" rel="stylesheet">
        <link href="assets/css/global.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        
    </head>
    <body>
      <a href="list" class="btn-primary"> UserList</a>
        <div>
            <header class="header">
                <div class="container">
                    <div class="logo">
                        <a href="#">
                           
                        </a>
                    </div>
                </div>
            </header>
            <div class="mid-container">
                <div class="signup-container">
                <div class="white-card">
                    <h1>Sign Up</h1>
                       <div class="card-body">
                       <form action="insert" method="post">
                       <div class="input-field">
                                <label>Name</label>
                                        <input type="text" placeholder="Name"  value="<c:out value='${user.name}'/>"name="name" id="name" required="required" />
                                    </div>
                                    <div class="input-field">
                                        <label>Weight</label>
                                        <input type="number" step="any" min="20" max="200" placeholder="insert your weight in k.g" value="<c:out value='${user.weight}'/>" name ="weight" required />
                                    </div>
                                    <div class="input-field">
                                        <label>Height</label>
                                        <input type="number" step="any" min="2" max="10" placeholder="insert your height in feett" value="<c:out value='${user.height}'/>" name ="height" required />
                                    </div>
                                    <div class="input-field">
                                        <label>Gender</label>
                                        <select class="selectbox" name="gender" value="<c:out value='${user.gender}'/>" required="required">
                                            <option value ="Male" >Male</option>
                                            <option value ="Female">Female</option>
                                        </select>
                                    </div>
                                    <div class="input-field">
                                        <label>Date of birth</label>
                                        <input type="date"  name ="dob" value="<c:out value='${user.age}'/>" min='1900-01-01' max='2020-01-01'required/>
                                    </div>
                                     <div class="input-field btn-set--right">
                                        <button  class="btn-primary">Sign Up</button>
                                    </div>                                  
                            </form>
                             
                        </div>
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
<script type="text/javascript">
function testInput(event) {
	   var value = String.fromCharCode(event.which);
	   var pattern = new RegExp(/[a-zåäö ]/i);
	   return pattern.test(value);
	}

	$('#name').bind('keypress', testInput);

</script>

</html>
