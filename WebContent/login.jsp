<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script>
		function validateForm() 
		{
			  var username= document.forms["myForm"]["email"].value;
			  var userpassword=document.forms["myForm"]["password"].value;
			  if (username == "") {
				    	document.getElementById("loginstatus").innerHTML = "User Name or Password is required";
				    	document.forms["myForm"]["email"].placeholder="";
					document.forms["myForm"]["password"].placeholder="";
					document.forms["myForm"]["email"].value="";
					document.forms["myForm"]["password"].value="";
				        return false;
					  }
			else if(userpassword==""){
					document.getElementById("loginstatus").innerHTML = "User Name or Password is required";
					document.forms["myForm"]["email"].placeholder="";
					document.forms["myForm"]["password"].placeholder="";
					document.forms["myForm"]["email"].value="";
					document.forms["myForm"]["password"].value="";
			                return false;
						}
			else 
   					return true;

		}
</script>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color:  #23CAEB;
  text-align: center;
  padding: 5px 7px;
  text-decoration: none;
  font-size: 13px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #00ccff;
  color: white;
}

.topnav-right {
  float: right;
}



.input-container {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  width: 40%;
   height:40%;
  margin-bottom: 15px;
}

.icon {
  padding: 6px;
  background: #e6e6e6;
 
  color: black;
  min-width: 20px;
  text-align: center;
}



.input-field:focus {
  border: 2px solid dodgerblue;
}

/* Set a style for the submit button */
.btn {
  background-color: green;
  color: white;
  padding: 10px 15px;
  border: none;
border-radius: 3px;

 
 
}

.btn:hover {
  opacity: 1;

</style>
</head>
<body bgcolor="#D3D3D3">
	<%String loginFail=(String)request.getAttribute("loginFail"); %>
	<div class="topnav" >
  		<a class="active" href="#home" style="font-family:Oswald;">RD ADMIN<br> PORTAL</a>
   		<div class="topnav-right"  style="padding: 2px 3px; color:black">
			<img src="training.png" height="41px" width="30px"></img>
  		</div>
	</div>
	<div style="padding-left:16px"></div>
	<div>
		<form name="myForm" action="LoginServlet" onsubmit="return validateForm()" method="post" >
			<table style="position: fixed; left: 30%;top: 30%;"  height=40% width= 40%  bgcolor="white" cellspacing=0 cellpadding=0 border=0>
				<tr>
					<td bgcolor="black" height="30">&nbsp;<font color="#fff" size="3px" align="left">&nbsp;Sign In</font></td>
					<td bgcolor="black" height="30" align="right">
						<font color="#23CAEB" size="5px" style="font-family:Oswald;">&lt;</font>
						<font color="white" style="font-family:Oswald;" size="5px">epam</font>
						<font color="#23CAEB" size="5px" style="font-family:Oswald;"> &gt;</font>&nbsp;
					</td>
				</tr>  
	 			<tr valign="center" >
					<td align="center" height="60" valign="bottom" colspan="2"> 
			    		<div class="input-container" ><i class="fa fa-user icon" ></i>
							<input  type="text" placeholder="raj@epam.com" name="email" color="blue"  style="background-color: #e6f5ff;width:100%">
  			    		</div>
					</td>
				</tr>
	  			<tr align="center" height="60" valign="top">
					<td colspan="2">  
						<div class="input-container">
	    					<i class="fa fa-lock icon"></i>
	    					<input  type="password" placeholder="*********" name="password"  style="background-color: #e6f5ff;width:100%">
 					 	</div>
					<td>
				</tr>
				<tr align="center" height="60" valign="top">
					<td colspan="2">
						<button type="submit"  class="btn" >Login</button>
					</td>
				</tr>
				<tr align="center" height="60" valign="top">
					<td colspan="2"><font color="#b3b3ff"><a href="#" style="text-decoration:none;">Forgot Password</a></font></td>
				</tr>
				<tr align="center" height="30" valign="top">
					<td colspan="2" style="color:red;font-size:15px;font-family:Oswald;">
						<div id="loginstatus" style="color:red;font-size:15px;font-family:Oswald;"></div>
						<%if(loginFail!=null) {%>
						<%=loginFail%>
						<%} %>
					</td>
				</tr>
			</table>
		</form>
	</div>
<div style="position: absolute; height: 50px; bottom: 0; right: 0;  left: 0; background:black">
</div>
</body>
</html>
