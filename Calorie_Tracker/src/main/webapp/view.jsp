<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.sql.*"%>
<%@page import="java.util.Iterator"%> 
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.controllerTwo.FoodGroups.FoodItems.Calorie.Common" %>
<%@page import="com.controller.bean.dao.*" %>
<%@page import="com.controllerTwo.FoodGroups.FoodItems.Calorie.*" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <link rel="icon" href="<%=Common.url %>assets/img/favicon.ico" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Calorie Tracker Coding Assignment - User Data Details</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700;800&display=swap"
        rel="stylesheet">
    <link href="<%=Common.url %>assets/css/global.css" rel="stylesheet">
</head>
<body>
    <div>
        <header class="header">
            <div class="container">
                <div class="logo">
                   
             <!-- upper header section  -->

                </div>
            </div>
        </header>
 <div class="mid-container">
            <div class="container">
                <div class="title-row">
                     <c:if test="${user != null}">
 <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
  </c:if>       
   <a class="btn-primary" href="UserList.jsp">back to The Previous page</a>
     <h5><c:out value='${user.name}'/></h5>
 
     <c:set var="userNameToBeEnterd" scope="application" value="${user.name}" />
     <c:set var="userIdToBeEnterd" scope="application" value="${user.id}" />
      <c:set var="weightOfUserToBeEntered" scope="application" value="${user.weight}" />
                    <div class="title-row-right">                      
                      <a class="btn-primary" href="AddFoodData.jsp">Add Food Data</a>                     
                     <br>
                      <a class="btn-primary" href="AddActivityData.jsp">Add Activity  Data</a>
                    </div>
                </div> 
                 <!-- <button class="btn-primary" data-toggle="modal" data-target="#addDataModal">Add Data</button> -->
                <div class="view-calorie-data">
                    <div class="view-calorie-data-date-input">
                    <form action="displayFoodData"  method="get">                      
                        <div class="date-input">                 
                            <input type="date" name="eachDayFoodDataDate" id="eachDayFoodDataDate" required>
                        </div>                       
                     <input type="hidden" name="id" value="<c:out value='${user.id}' />" />                           
                      <button type="submit">submit</button>
                    </form>
                    </div>
                    <div class="view-calorie-data-chart">
                        <div class="food-data white-card">
                            <h2>Food Data</h2>
                            <div class="food-data-table">
                                <table
                                    class="dcf-table dcf-table-responsive dcf-table-bordered dcf-table-striped dcf-w-100%">
                                    <thead>
                                        <tr>
                                            <th scope="col">Date</th>
                                            <th scope="col">Meal Type</th>
                                            <th scope="col">Food Group</th>
                                            <th scope="col">Serving</th>
                                            <th scope="col">Calorie In</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${userFoodDataWhichisShown}" var="data" varStatus="status">
                                        <tr>
                                            <th scope="row"><c:out value="${data.dateOfSubmission}" /></th>
                                            <td data-label="Meal Type"><c:out value="${data.mealType}" /></td>
                                            <td data-label="Food Group"><c:out value="${data.foodGroup}" /></td>
                                            <td data-label="Serving"><c:out value="${data.serving}" /></td>
                                            <td data-label="Calorie In"><c:out value="${data.calorie}" /></td>
                                        </tr>
                                       </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="activity-data white-card">
                            <h2>Activity Data</h2>
                            <div class="activity-data-table">
                                <table
                                    class="dcf-table dcf-table-responsive dcf-table-bordered dcf-table-striped dcf-w-100%">
                                    <thead>
                                        <tr>
                                            <th scope="col">Date</th>
                                            <th scope="col">Name</th>
                                            <th scope="col">Calorie Out</th>
                                            
                                            <th scope="col">Duration</th>                                           
                                        </tr>
                                    </thead>
                                    <tbody>
                                          <c:forEach items="${userActivityDataWhichIssShown}" var="userActivityData" varStatus="status">
                                        <tr>
                                            <th scope="row"><c:out value="${userActivityData.dateOfSubmission}" /></th>                                            
                                            <td data-label="Activity"><c:out value="${userActivityData.activity}" /></td>
                                            <td data-label="calorie Out"><c:out value="${userActivityData.metvalue}" /></td>
                                            <td data-label="Duration"><c:out value="${userActivityData.duration}" /></td>                                           
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="net-calorie-data white-card">
                            <h2>Net Calorie</h2>
                            <div class="net-calorie-table">
                                <div class="net-calorie-row">
                                    <strong>BMR: </strong>
                                    <span><c:set var = "userBMR" scope = "session" value = "${userBMR}"/>
                                      <c:out value = "${userBMR}"/></span>                                  	
                                </div>                              
                                <div class="net-calorie-row">
                               <strong>Food: </strong>
                                    <span><c:out value="${userActivityData.duration}" /></span>
                                    <c:set var = "userOneDayCalorie" scope = "session" value = "${userOneDayCalorie}"/>
                                      <c:out value = "${userOneDayCalorie}"/>                                   
                                </div>
                                <div class="net-calorie-row">
                                    <strong>Activity: </strong>
                                    <span><c:set var = "calorieOut" scope = "session" value = "${calorieOut}"/>
                                      <c:out value = "${calorieOut}"/></span>
                                </div>
                                <div class="net-calorie-row net-calorie-totl">
                                    <strong>Net Calorie:</strong>
                                    <span><c:set var = "netCalorieOfTheDay" scope = "session" value = "${netCalorieOfTheDay}"/>
                                      <c:out value = "${netCalorieOfTheDay}"/></span>
                                </div>
                            </div>
                        </div>
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
    
  <!-- Modal Box Start -->
    <div class="modal fade" id="addDataModal" tabindex="-1" aria-labelledby="addDataModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content add-data-modal">
                <div class="modal-header">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item" role="presentation">
                            <a class="nav-link active" id="food-tab" data-toggle="tab" href="#food" role="tab"
                                aria-controls="food" aria-selected="true">Add Food</a>
                        </li>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" id="activity-tab" data-toggle="tab" href="#activity" role="tab"
                                aria-controls="activity" aria-selected="false">Add Activity</a>
                        </li>
                    </ul>
                </div>
                <div class="modal-body">
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="food" role="tabpanel" aria-labelledby="food-tab">
                        
                        <form action="insertFoodCopied" method="post">
                                                        <input type="hidden" name="userName" value="<c:out value='${userNameToBeEnterd}' />" readonly />
                                                        <input type="hidden" name="id" value="<c:out value='${userIdToBeEnterd}' />" readonly />
                                                        
                        
                        
                            <div class="input-field">
                                <label>Select Date</label>
                                <input type="date" value="" placeholder="" name="DateOfSubmission" required>
                            </div>
                            <div class="input-field">
                                <label>Select Food Group</label>
                                <select class="selectbox" id="foodGroup" name="foodGroup"  required>
                                    <option>Beans</option>                                   
                                </select>
                                 <div class="input-field">
                                <label>Select Food Name</label>
                                <select class="selectbox" id="foodName" name="foodName" required>
                                    <option>Beans</option>
                                    
                                </select>
                            </div>
                            </div>
                            <div class="input-field">
                                <label>Select Meal Type</label>
                                <select class="selectbox">
                                    <option>Breakfast</option>
                                    <option>Lunch</option>
                                    <option>Dinner</option>
                                </select>
                            </div>
                           
                            <div class="input-field">
                                <label>Serving</label>
                                <input type="text" placeholder="Serving" name="serving" id="serving" required>
                            </div>
                            <div class="input-field"> 
                            <label>Calorie You wil Consume per food</label>                  
                    <select class="selectbox" id="calorie" name="calorie">                         
                        </select>
                        
                    </div>
                            <div class="input-field input-field-btn btn-set--center">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal">Save</button>
                            </div>
                            </form>
                        </div>
                        <div class="tab-pane fade" id="activity" role="tabpanel" aria-labelledby="activity-tab">
                            <div class="input-field">
                                <label>Select Date</label>
                                 <input type="date" value="" placeholder="" name="DateOfSubmission" required>
                            </div>
                            <div class="input-field">
                                <label>Activity Group Name</label>
                                <select class="selectbox" id="activityGroup" name="activityGroup" required>
                                    <option>Bicycling</option>
                                 
                                </select>
                            </div>
                            <div class="input-field">
                                <label>Activity  Name</label>
                                <select class="selectbox" id="activityName" name="activityName" required>
                                    <option>Bicycling</option>
                                 
                                </select>
                            </div>                           
                            <div class="input-field">
                                <label>Activity Duration</label>
                                 <input type="number" id="duration" name="duration" placeholder="insert duration in minutes"  required>
                            </div>
                            <div class="input-field">
                                <label>Met  value</label>
                                <select class="selectbox" id="metValue" name="metValue" required>
                                    <option></option>                                
                                </select>
                            </div>
                            <div class="input-field input-field-btn btn-set--center">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal">Save</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal Box End -->
</body>
<script src="assets/js/jquery.slim.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/custom.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
     
      <script type="text/javascript">
            $(document).ready(function () {
                $.ajax({
                    url: "InsertFoodDataServlet",
                    method: "GET",
                    data: {operation: 'group'},
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        let obj = $.parseJSON(data);
                        $.each(obj, function (key, value) {
                            $('#foodGroup').append('<option value="' + value.name + '">' + value.name + '</option>')
                        });
                        $('select').formSelect();
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        $('#foodGroup').append('<option>Food Group Unavailable</option>');
                    },
                    cache: false
                });


                $('#foodGroup').change(function () {
                    $('#foodName').find('option').remove();
                    $('#foodName').append('<option>Select FoodName</option>'); 
                    $('#calorie').find('option').remove();
                    $('#calorie').append('<option>calorie</option>');

                    let cname = $('#foodGroup').val();
                    let data = {
                        operation: "food",
                        name: cname
                    };

                    $.ajax({
                        url: "InsertFoodDataServlet",
                        method: "GET",
                        data: data,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            let obj = $.parseJSON(data);
                            $.each(obj, function (key, value) {
                                $('#foodName').append('<option value="' + value.name + '">' + value.name + '</option>')
                              
                            });
                            $('select').formSelect();
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $('#foodName').append('<option>FoodName Unavailable</option>');
                        },
                        cache: false
                    });
                });

                $('#foodName').change(function () {
                                  $('#calorie').find('option').remove();
                                  
                                  //*$('#calorie').append('<option></option>');

                                  let sname = $('#foodName').val();
                                  let data = {
                                      operation: "calorie",
                                      name: sname
                                  };

                                  $.ajax({
                                      url: "InsertFoodDataServlet",
                                      
                                      method: "GET",
                                      
                                      data: data,
                                      
                                      success: function (data, textStatus, jqXHR) {
                                          console.log(data);
                                          let obj = $.parseJSON(data);
                                          $.each(obj, function (key, value) {                                          
                                          	$('#calorie').append('<option value="' + value.calorie + '">' + value.calorie + '</option>')
                                          });
                                          $('select').formSelect();
                                      },
                                      error: function (jqXHR, textStatus, errorThrown) {
                                          $('#calorie').append('<textarea readonly>City Unavailable</textarea>');
                                      },
                                      cache: false
                                  });
                              });	
                  });
        </script>
        
        <!-- Activity Dropdown Ajax Module  -->
        <script type="text/javascript">
            $(document).ready(function () {
                $.ajax({
                    url: "InsertFoodDataServlet",
                    method: "GET",
                    data: {operation: 'activityGroup'},
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        let obj = $.parseJSON(data);
                        $.each(obj, function (key, value) {
                            $('#activityGroup').append('<option value="' + value.name + '">' + value.name + '</option>')
                        });
                        $('select').formSelect();
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        $('#activityGroup').append('<option>Activity Group Unavailable</option>');
                    },
                    cache: false
                });


                $('#activityGroup').change(function () {
                    $('#activityName').find('option').remove();
                    $('#activityName').append('<option>Select Activity Name</option>'); 
                    $('#metValue').find('option').remove();
                    $('#metValue').append('<option>Met Value</option>');

                    let cname = $('#activityGroup').val();
                    let data = {
                        operation: "activity",
                        name: cname
                    };

                    $.ajax({
                        url: "InsertFoodDataServlet",
                        method: "GET",
                        data: data,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            let obj = $.parseJSON(data);
                            $.each(obj, function (key, value) {
                                $('#activityName').append('<option value="' + value.name + '">' + value.name + '</option>')
                               
                            });
                            $('select').formSelect();
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $('#activityName').append('<option>Activity Name Unavailable</option>');
                        },
                        cache: false
                    });
                });
                $('#activityName').change(function () {
                    $('#metValue').find('option').remove();
                    
                    //*$('#metValue').append('<option></option>');

                    let sname = $('#activityName').val();
                    let data = {
                        operation: "metvalue",
                        name: sname
                    };

                    $.ajax({
                        url: "InsertFoodDataServlet",
                        
                        method: "GET",
                        
                        data: data,
                        
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            let obj = $.parseJSON(data);
                            $.each(obj, function (key, value) {                                          
                            	$('#metValue').append('<option value="' + value.metvalue + '">' + value.metvalue + '</option>')
                            });
                            $('select').formSelect();
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $('#metValue').append('<textarea readonly>City Unavailable</textarea>');
                        },
                        cache: false
                    });
                });	
              
            });
        </script>

</html>