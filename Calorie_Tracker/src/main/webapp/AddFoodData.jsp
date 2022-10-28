<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.sql.Connection"%>
      <%@page import="java.util.ArrayList"%> 
 <%@page import="java.util.ArrayList"%> 
    <%@page import="java.util.Iterator"%> 
    <%@ page import="java.util.List"%>
     <%@page import="com.controller.bean.dao.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fill The Forms</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <style type="text/css">
            body{
                background: url(image/roenkae.jpg);
                background-size: cover;
            }
            .drop-down-list{
                margin: 150px auto;
                width: 50%;
                padding: 30px;
            }
        </style>
    </head>
    <body class="cyan">
        <div class="container">
            <div class="drop-down-list card">
                <div class="center">
                    <h5>Enter Food Data</h5>
                    <a href="view?id=<c:out value='${userIdToBeEnterd}' />">Back To View Page</a> 
                </div>
                <div class="divider"></div>
                <form action="insertFoodCopied" method="post">
                 <div class="input-field">
                 <div class="input-field">
                
                            
                                <input type="hidden" name="userName" value="<c:out value='${userNameToBeEnterd}' />" readonly />
                                <input type="hidden" name="id" value="<c:out value='${userIdToBeEnterd}' />" readonly />
                               </div>
                                <label>Select Date</label>
                                <input type="date" value="" placeholder="" name="DateOfSubmission" id="DateOfSubmission" required>
                            </div>
                               
                    <div class="input-field">
                        <select id="foodGroup" name="foodGroup"  required>
                            <option>Select Food Group</option>
                        </select>
                    </div>
                    <div class="input-field">
                        <select id="foodName" name="foodName" required>
                            <option>Select Food Name</option>
                        </select>
                    </div>
                    <div class="input-field">
                                 <div class="input-field">
                               
                                <input type="text" placeholder="Serving" name="serving" id="serving" required>
                            </div>
                                <select class="selectbox" name="mealType" id="mealType" required>
                                <option>Select Meal Type</option>
                                    <option>Breakfast</option>
                                    <option>Lunch</option>
                                    <option>Dinner</option>
                                </select>
                            </div>
                    <div class="input-field">
                    
                    <select id="calorie" name="calorie">
                           
                        </select>
                        
                    </div>
                    <div class="center">
                        <button class="btn" type="submit">Submit</button>
                         <button class="btn" type="reset">Reset</button>
                    </div>
                </form>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
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
        <script type="text/javascript">
        DateOfSubmission.max = new Date().toISOString().split("T")[0];
        </script>
    </body>
</html>

  