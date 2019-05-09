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
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
 <title>Insert title here</title>
  <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <script src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>
  
  <style type="text/css">
   .tabs {
       margin:  0;
       padding: 0;
       list-style: none;
       display: table;
       table-layout: fixed; 
       width: 100%;
   }
  
      .tabs_item {
          display: table-cell; 
      }
  
      .tabs_link {
          display: block; 
      }
   .primary_nav {
       text-align: center;
       border-radius: 1px;
       overflow: hidden; 
   }
  
      .primary_nav a {
             padding: 0.5em;
             background-color: #454545;
             color: #fff;
             text-decoration: none;
      }
  
      .primary_nav a:hover {
          background-color: #000;
          color: #23CAEB;
      }  
      .round {
    width: 10%;
    border-radius: 15px;
    border: 1px #000 solid;
    padding: 5px 5px 5px 25px;
    position: absolute;
   
    top: 0;
    left: 30cm;
    
}
 </style>
   
 </head> 
 
 <body>
 	<% ArrayList<Menu> menu = (ArrayList<Menu>) request.getAttribute("menuList");%>
 	<!--  iterate ArrayList --> 
 	<div style="font-family: 'Oswald', sans-serif; font-size: 15px; background-color: #ECF0F1;">
   <ul class="tabs  primary_nav">
   		<li style="padding: 0.5em; background-color: #23CAEB; color: #fff; text-decoration: none;"> 
            RD ADMIN PORTAL 
        </li>
		<% for (int i=0;i<menu.size();i++) { 
		Menu items = (Menu)menu.get(i); %>
        <li class="tabs_item">
            <a href=<%=items.getMenuPagePath()%> class="tabs_link"> <%=items.getMenuName()%> </a>
        </li>       
     	<%}%> 
        <li class="tabs_item">
            <input class="tabs_item" type="text"  placeholder="Search.." name="search" class="round" style="background:#454545;">
        </li>
        <li>
        <form id="logoutform">
        		<button type="submit"  onclick="logout()" align="center"> Logout</button>
        </form>
        </li>              
   </ul>
  </div>
  <div>
  	<p id="demo"></p>
  </div>
  
   <script>
  	function logout() {
  		 document.getElementById("logoutform").action="./LogoutServlet";
  		 document.getElementById("logoutform").method = "POST";
  		 document.getElementById("logoutform").submit();
		
	}
  </script>
 </body>
</html>
   
