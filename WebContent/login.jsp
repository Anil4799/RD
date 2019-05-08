<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
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

<div class="topnav" >
  <a class="active" href="#home" style="font-family:Oswald;">RD ADMIN<br> PORTAL</a>
   <div class="topnav-right"  style="padding: 2px 3px; color:black">
<img src="training.png" height="41px" width="30px"></img>
 
   
  </div>

</div>

<div style="padding-left:16px">
 
</div>
<div >
<form action="LoginServlet" method="post" >
<table style="position: fixed; left: 30%;top: 30%;"  height=40% width= 40%  bgcolor="white" cellspacing=0 cellpadding=0 border=0>
<tr valign="center">
<td bgcolor="black" ><font color="#fff">&nbsp;&nbsp;<b>Sign In</b></font>
<img src="logo.png "height="40px" width="80px" align="right" ></img></td>
</tr> 
 <tr valign="center" >
<td align="center" height="60" valign="bottom"> 
<div class="input-container" >
    <i class="fa fa-user icon" ></i>
    <input  type="text" placeholder="email@epam.com" name="email" color="blue" size=35 style="background-color: #e6f5ff;">
   </div>
</td>
</tr>
  <tr align="center" height="60" valign="top">
<td >
  
  <div class="input-container">
    <i class="fa fa-lock icon"></i>
    <input  type="password" placeholder="*********" name="password" size=35 style="background-color: #e6f5ff;">
  </div>
<td></tr>
<tr align="center" height="60" valign="top"><td>
  <button type="submit"  class="btn">Login</button>
</td></tr>
<tr align="center" height="60" valign="top"><td><font color="#b3b3ff"> <a href="forgotpassword.html" style="text-decoration:none">Forgot Password</a></font></td></tr>
</table>
</form>

</div>
<div style="position: absolute; height: 50px; bottom: 0; right: 0;  left: 0; background:black">
  </div>

</body>
</html>
