<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
body {
  font-family: 'Oswald', sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #000;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: right;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: black;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 5px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}



.dropdown:hover .dropdown-content {
  display: block;
}
a:hover {
  background-color:#000;
  color: #23CAEB;
  }
  .active {
  background-color: #23CAEB;
  color: white;
}
.round {
    width: 10%;
    border-radius: 15px;
    border: 1px #000 solid;
    padding: 6px 4px 10px 0px;
    position: absolute;
    top: 0.5cm;
    left: 17cm;    
}
.roundbutton {
    width: 2%;
    border-radius: 14px;
    border: 0px #000 solid;
    border-color:white;
    background-color:white;
    padding: 4px 0px 10px 0px;
    position: absolute;
    top: 0.51cm;
    left: 19.85cm;
    
}
</style>
</head>
<body>

<div class="navbar">
  <a class="active" href="#home"> RD ADMIN PORTAL</a>
  <a href="#STUDENT INFO">STUDENT INFO</a>
  <a href="#MENTOR INFO">MENTOR INFO</a>
  <a href="#BATCH INFO">BATCH INFO</a>
  <a href="#REPORTS">REPORTS</a>
  <input type="text" placeholder="      " name="search2" class="round">
  <button type="submit" class="roundbutton"><i class="fa fa-search"></i></button>
  <div class="dropdown">
    <button class="dropbtn"><img  src="userlogout.png" height=26% width=26% >
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#">LOGOUT</a>
    </div> 
  </div> 
  <img  style="float:right; padding-top:2px;padding-right:2px" src="training.png" height=4% width=3% >
  
</div>

<div style="position: absolute; height: 50px; bottom: 0; right: 0;  left: 0; background:black">
  </div>

</body>
</html>
