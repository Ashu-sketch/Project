<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="com.controller.bean.dao.Common"%>
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
        <title>Dependent Select Option</title>
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
                    <h5>Enter Activity Data</h5>
                     

 <a href="view?id=<c:out value='${userIdToBeEnterd}' />">Back To View Page</a>
                                     
                                   
                </div>
                <div class="divider"></div>
                <form action="insertActivityDataServlet" method="post">
                 <div class="input-field">
                 <div class="input-field">
                
                            
                                <input type="hidden" name="id" value="<c:out value='${userIdToBeEnterd}' />" readonly />
                                <input type="hidden" name="userName" value="<c:out value='${userNameToBeEnterd}' />" readonly />
                                <input type="hidden" name="weightOfUser" value="<c:out value='${weightOfUserToBeEntered}' />" readonly />
                               </div>
                                <label>Select Date</label>
                                <input type="date" value="" placeholder="" name="DateOfSubmission" id="DateOfSubmission" required>
                            </div>
                               
                    <div class="input-field">
                        <select id="activityGroup" name="activityGroup" required>
                            <option>Select Activity Group</option>
                        </select>
                    </div>
                    <div class="input-field">
                        <select id="activityName" name="activityName" required>
                            <option>Select Activity Name</option>
                        </select>
                    </div>
                     <div class="input-field">                     
                    <input type="number" id="duration" name="duration" placeholder="insert duration in minutes"  required>
                      
                    </div>                  
                    <div class="input-field" > 
                                        
                    <select id="metValue" name="metValue">
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
         <script type="text/javascript">
        DateOfSubmission.max = new Date().toISOString().split("T")[0];
        </script>
    </body>
</html>

  