<%@page import="javax.swing.event.MenuListener"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.epam.services.login.*"%>
<%@page import="com.epam.servlets.login.*"%>
<%@page session="true" %>

<!DOCTYPE html>
<html>
	<head>
	 	<meta charset="ISO-8859-1">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		
		<title>Home</title>
		<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		<link rel="stylesheet" href="AddStudentInfoCSSWithBootstrap.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="css/style.css">
	  	
		<script>
		  	function logout() {
		  		 document.getElementById("logoutform").action="./LogoutServlet";
		  		 document.getElementById("logoutform").method = "POST";
		  		 document.getElementById("logoutform").submit();
		  		 
				
			}
		  	
		    window.history.forward();
		    function noBack() { window.history.forward(); }
		
		  	
	  	</script>	   
	</head> 
 
	<body style="font-family: Oswald, sans-serif;onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
		<div>
		 	<!-- Get Menu from GetMentServlet -->
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad">
	    		<nav class="navbar navbar-expand-md navbar-light">
		        	<a class="navbar-brand" style="background-color:#00ccff">RD ADMIN PORTAL</a>
		        	<button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
		            <span class="navbar-toggler-icon"></span>
		        	</button>
		
		        	<div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
		            	<div class="navbar-nav">		                
			               	                
		            	</div> 
			            <form class="form-inline">
			                <div class="input-group">                    
			                    <input type="text" class="search-input form-control">
			                    <div class="input-group-append">
			                        <button type="button" class="search-btn btn btn-secondary"><i class="fa fa-search"></i></button>
			                    </div>
			                </div>
			            </form>
			            <div class="navbar-nav">
			                <div class="nav-item dropdown">
			                  <a href="#" class="nav-link dropdown-toggle user-icon" data-toggle="dropdown"><i class="fa fa-fw fa-user"></i></a>
			                  
			                  <form id="logoutform" class="dropdown-menu">
					        		<button class="dropdown-item dropdown-item:focus dropdown-item:hover" type="submit"  onclick="logout()"> Logout</button>
					        	</form>            
			              	</div>		              
		            	</div>
		        	</div>
		        	<img style="float: left;padding: 0px; "src="training.png" class="nav-item nav-link-img" height=3% width=3%>
	   	 		</nav>
	  		</div>
  			<p id="demo">sdfdsf</p>
  		</div>
  		<div style="position: absolute; height: 50px; bottom: 0; right: 0;  left: 0; background:#5A5C5F"></div>	  
	  </body>
</html>
   
