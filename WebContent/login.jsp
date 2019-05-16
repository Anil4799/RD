<!DOCTYPE html>
<html>
<head> 
  <title>Login Template</title> 
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"> 
  <link rel="stylesheet" href="css/custom.css"> 
  <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script> 
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 

</head> 
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
   color: white;
  background: green;
  }




  .container {
  height: 200px;
  
 
}
.footer {
  height: 50px;
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  background-color: #5A5C5F;
  color: white;
  text-align: center;
}

  </style>
<script>
   function validateForm() 
        {
              var email= document.forms["myForm"]["email"].value;
              var password=document.forms["myForm"]["password"].value;
              if (email == "" || password== "") {
                    document.getElementById("loginstatus").innerHTML = "User Name or Password is required";
                    document.forms["myForm"]["email"].placeholder="Email / Login ID";
                    document.forms["myForm"]["password"].placeholder="Password";
                    document.forms["myForm"]["email"].value="";
                    document.forms["myForm"]["password"].value="";
                        return false;
                      }
            
            else 
                       return true;

        }
        
  </script>
<body>
<%String loginFail=(String)request.getAttribute("loginFail"); %>
    <div class="topnav" bgcolor="#5A5C5F" >
          <a class="active" href="#home" style="font-family:Oswald;font-size:16px;background: #39C2DF;width: 100px;border-color:#CCCCCC">RD ADMIN<br> PORTAL</a>
           <div class="topnav-right"   color:black;">
            <img src="training.png" height="54px" width="40px"  ></img>
          </div>
    </div>
<br><br><br><br>
<div class="container vertical-center" >
  <div id="loginbox" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 loginbox"> 
    <div class="panel panel-info" > 

      <div class="panel-heading" style="background: #231f20;font-family:Oswald;"> 
        <div  color="black"> <font color="white"> Sign In</font>  <img src="epamlogo.png" height="29px"  align="right"></img></div> 
      
      </div> 

      <div class="panel-body panel-pad"> 
        
          <form name="myForm"  action="LoginServlet" onsubmit="return validateForm()" method="post"  class="form-horizontal" >
            <div class="form-group" > 
            <!-- Button --> 
             
            </div>  
   
            <div class="input-group margT25" style="padding-left: 70px"> 
              <span class="input-group-addon" >
                <i class="glyphicon glyphicon-user"></i>
              </span> 

              <input id="login-username" type="text" class="form-control" name="email" value=""  placeholder="Email / Login ID" style="background-color: #e6f5ff;font-family:Oswald;width:80%;z-index: 0;"> 
           
          </div>
            <br>
            <div class="input-group margT25" style="padding-left: 70px"> 
              <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
              <input  type="password" placeholder="Password" class="form-control"   font-color="#DEE0E2" name="password"  style="font-family:Oswald;background-color: #e6f5ff;width:80%;z-index: 0;">
             
            </div> 
          <br>
            <div class="form-group margT10"> 
            <!-- Button --> 
           <div align="center">  
            <button type="submit"  class="btn btn-success"  style="font-size:14px;font-family:Oswald;"> Login
           </button>
         
              
            </div>
            </form> 
            <br>
            <div align="center">
              <font  style="font-family:Oswald" font-size=14><a href="#" style="text-decoration:none;color="#b3b3ff">Forgot Password</a></font>
            </div>
            <br>
           <div id="loginstatus" align="center" style="color:red;font-size:15px;font-family:Oswald;">
            <%if(loginFail!=null) {%>
                              <%=loginFail%>
                              <script type="text/javascript">
                                document.forms["myForm"]["email"].placeholder="Email / Login ID";
                                document.forms["myForm"]["password"].placeholder="Password";
                              </script>
                            <%} %>
            </div> 
           
        </div> 
      </div> 
    </div> 
   
        </form> 
      </div> 
    </div> 
  </div> 
</div> 
</div>
<div class="footer">&nbsp;</div>
</body> 
</html>
