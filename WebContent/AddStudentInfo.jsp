<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<title>ADD STUDENT</title>
<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
<link rel="stylesheet" href="AddStudentInfoCSSWithBootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<style>
  .container-custom{max-width:1500px; font-family:Oswald;}
  .nopad{padding:0;}
  .navbar{background-color:#5a5c5f; padding: 0;}
  .navbar .nav-link,.navbar-brand{color:#fff !important; padding:15px 25px !important; font-size:1rem; margin: 0}
  .navbar .nav-link:hover{background-color:#000; color:#38bdbd !important;}
  .navbar .user-icon:hover{color:#fff !important;}
  .form-inline{margin:0;}
  .search-input{color:#fff !important;background-color: #737171;border-radius: 19px !important; border-color:#737171;}
  .search-btn{z-index:4 !important;background-color:#737171; border: 0 !important;border-radius: 19px !important;position: absolute !important; right: 0;padding: 11px;}
  .search-input.form-control:focus{background-color:#737171; box-shadow:none; border-color:#737171;}
  .btn-secondary:hover, .btn-secondary:active{background-color:#737171 !important; box-shadow:none; border-color:#737171;border-radius: 19px !important;}
  .btn-secondary.focus, .btn-secondary:focus{box-shadow: none;}
  .user-icon .fa-user{padding: 4px;}
  .required {color: red;}
  .btn-save{border-radius: 5px 5px 5px 5px; padding: 5px 5px 5px 5px; width: 60px; height: 28px; float: right; margin: 3px;	text-align: center; background: rgb(92,184,92);  float: right; font-family: Oswald, sans-serif; color: white;}
  .btn-back{border-radius: 5px 5px 5px 5px; padding: 5px 5px 5px 5px;  background: rgb(216,220,222);  width: 60px; height: 28px; float: right; margin: 3px;	text-align: center;  float: right;  font-family: Oswald, sans-serif;}
  .active {  background-color: black;  color:#38bdbd;}
  .label_color{color:rgb(178,178,178);}
  .txtbrcolr{border-color: red;}
  .alert_popup{width: 300px; border-radius: 5px 5px 5px 5px; display: none; position: absolute; left: 500px; top: 5px; background-color: #FFFAFA;}
  .ok_button{font-size: 12px;border-radius: 5px 5px 5px 5px;background:  #D8DCDE;padding: 5px 5px 5px 5px;width: 60px;height: 28px;float: right;margin: 3px;text-align: center;	cursor: pointer;	}
  .add_student_info{font-size: 12px;border-radius: 5px 5px 5px 5px;background: #fff;padding: 5px 5px 5px 15px;margin: 3px;	} 
			.backbutton, .savebutton{
		    	font-size: 12px;
		    	border-radius: 5px 5px 5px 5px;
				background:  #D8DCDE;
				padding: 5px 5px 5px 5px;				
				width: 60px;
				height: 28px;
				float: right;				
				margin: 3px;
				text-align: center;
				cursor: pointer;
			}
</style>
<script src="StudentJS.js"></script>
<body style="font-family: Oswald, sans-serif;">

<div class="container container-custom">
	
  <!---Header--->
  <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad">
    <nav class="navbar navbar-expand-md navbar-light">
        <a href="#" class="navbar-brand" style="background-color:#38bdbd">RD ADMIN PORTAL</a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
            <div class="navbar-nav">
                <!--<a href="#" class="nav-item nav-link" style="background-color:#38bdbd">RD ADMIN PORTAL</a>-->
                <a href="#" class="nav-item nav-link active">STUDENT INFO</a>
                <a href="#" class="nav-item nav-link">MENTOR INFO</a>
                <a href="#" class="nav-item nav-link">BATCH INFO</a>
                <a href="#" class="nav-item nav-link">REPORTS</a>
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
                  <div class="dropdown-menu">
                      <a href="#" class="dropdown-item">Logout</a>
                      
                  </div>
                  
              </div>
              <a href="#" class="nav-item nav-link">Login</a>
            </div>
        </div>
    </nav>
  </div>
  
  <!---Body--->  
  <!-- <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad"> -->
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad" style="background: white;">
	<font size="+2">ADD STUDENT</font>
	</div>
	<div id="alert_popup" class="alert_popup" style="padding: 7px 10px 5px 40px; border: 1px solid #DCDCDC; z-index: 10;">	
			<div style="margin: 10px 0px 20px 10px;">
				RD Portal Says
			</div>
			<div id="message_info">
			</div>
			<span class="ok_button" style="background-color:#5CB85C ; color: #FFF" name="ok"  onClick="closeAlertPopup()">OK</span>		
		</div>
	<form action ="StudentServlet" name="add_student_info" id="add_student_info" method="post">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad" style="background-color: rgb(235,235,235);">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad">
			<span class="savebutton" style="background-color:#5CB85C ; color: #FFF;" name="save"  onClick="validateForm()">SAVE</span>
			<span class="backbutton" onClick="gotoStudentLandingPage()">BACK</span>
		</div>
		
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 nopad " >
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad " style="padding: 5%;float:left;">
				
				<div class="card">
  					<h5 class="card-header" >PERSONAL INFO</h5>
  					<div class="card-body label_color">
  					<div>
    					<span>First Name:<span class="required">*</span></span>
    					<span style="float:right;">
    					<input name="firstName"  id="firstName" type="text"  class="form-control form-control-sm" size="30" />
    					</span>
					</div>
					<br>
					<div>
						Last Name:<span class="required">*</span>
						<span style="float:right;">
						<input name="lastName" id="lastName"  type="text" class="form-control form-control-sm" size="30" />
						</span>
					</div>
					<br>
					<div>
						Date of Birth:<span class="required">*</span>
						<span style="float:right;">
						<input name="dateOfBirth" id="dateOfBirth"  type="date" class="form-control form-control-sm" style="width:195px"/>
						</span>
					</div>
					<br>
					<div>
						Email:<span class="required">*</span>
						<span style="float:right;">
						<input name="email" id="email"  type="email" class="form-control form-control-sm" size="30"/>
						</span>
					</div>
					
					<br>
					<div>
						Gender:<span class="required">*</span>
						<span style="float:right;">
						<select name="gender" id="gender" class="form-control form-control-sm"  style="width:195px" required>
						<option value="no_value"></option>
						<option value="male">Male</option>
						<option value="female">Female</option>
					    </select>
					    </span>
					</div>
					<br>
					<div>
						Contact Number:
						<span style="float:right;">
						<input name="contactNumber" id="contactNumber" type="text" class="form-control form-control-sm" size="30"/>
						</span>
					</div>
					<br>
					<div>
					Location:<span class="required">*</span>
					<span style="float:right;">
					<input name="personalLocation" id="personalLocation" type="text" class="form-control form-control-sm" size="30"/>
					</span>
					</div>
    				
 		   		</div>
	   </div>
			</div>
			 <div  style="padding: 5%; ">
				
				<div class="card">
  					<h5 class="card-header">EDUCATIONAL INFO</h5>
  					<div class="card-body label_color">
  					<div>
  						College:
  						<span style="float:right;" >
  							<select name="collegeName" class="form-control form-control-sm" style="width:195px">
							<option value="MLRIT">MLRIT</option>
							<option value="BVRIT">BVRIT</option>
							<option value="CU">CU</option>
							</select>
  						</span>
  					</div>
  					<br>
    				<div>
    					Location:
    					<span style="float:right;" >
    					<input name="collegeLocation" type="text" class="form-control form-control-sm" size="30"/>
    					</span>
    				</div>
					<br>
					
					<div>
					Graduation:
					<span style="float:right;" >
					<input name="graduation" type="text" class="form-control form-control-sm" size="30"/>
					</span>
					</div>
					
					<br>
					<div>
					Graduation Speciality:
					<span style="float:right;" >
					<select name="graduationSpeciality" class="form-control form-control-sm" style="width:195px" >
					<option value="no_value"></option>
						<option value="ece">ECE</option>
						<option value="cse">CSE</option>
						<option value="it">IT</option>
					</select>
					</span>
					</div>
					
					<br>
					<div>
					Year of Passed Out:
					<span style="float:right;">
					<input name="yearOfPassedOut" type="text" class="form-control form-control-sm" size="30"/>
					</span>
					
					</div>
					<br>
					<div>
					Graduation Marks:
					<span style="float:right;">
					<input name="graduationMarks" type="text"  class="form-control form-control-sm" size="30"/>
					</span>
					</div>
					
					<br>
					<div>
					10th +2 Marks:
					<span style="float:right;">
					<input name="twelveth" type="text" class="form-control form-control-sm" size="30"/>
					</span>
					</div>
					<br>
					<div>
					10th Marks:
					<span style="float:right;">
					<input name="tenth" type="text" class="form-control form-control-sm" size="30"/>
					</span>
					</div>
					
					
 		   		</div>
	   </div>
			</div>
		</div>
		 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 nopad" style=" position: absolute; top: 35px; right: 20px;">
			
			<div class="card">
  					<h5 class="card-header">ADDITIONAL INFO</h5>
  					<div class="card-body label_color">
  					<div>
  						BatchId:<span class="required">*</span>
  						<span style="float:right;">
  						<select name="batchId" id="batchId" class="form-control form-control-sm" style="width:195px" required>
							<option value="no_value"></option>
							<option value="">RD-Q1-2019-B1</option>
							<option value="">RD-Q1-2019-B2</option>
						</select>
  						</span>
  					</div>
						<br>
						<div>
						Employee Type:<span class="required">*</span>
						<span style="float:right;">
						<select name="employeeType" id="employeeType" class="form-control form-control-sm" style="width:195px" required>
						<option value="no_value"></option>
							<option value="fte">FTE</option>
							<option value="internship">Internship</option>
						</select>
						</span>
						</div>
						
						<br>
						<div>
						Core Skill:<span class="required">*</span>
						<span style="float:right;">
						<select name="coreSkill" id="coreSkill" class="form-control form-control-sm" style="width:195px" required>
						<option value="no_value"></option>
							<option value="python">Python</option>
							<option value="java">Java</option>
							<option value=".net">.Net</option>
							<option value="javascript">Javascript</option>
							<option value="php">PHP</option>
						</select>
						</span>
						</div>
						<br>
						<div>
						Preferred Student Stream:
						<span style="float:right;">
						<select name="preferredStudentStream" class="form-control form-control-sm" style="width:195px">
						<option value="no_value"></option>
							<option value="java">Java</option>
							<option value=".net">.Net</option>
							<option value="sdet">SDET - Software Development Engineer in Testing</option>
							<option value="salesforce">Salesforce</option>
							<option value="bigData">Big-Data</option>
							<option value="dep">DEP - [Digital Experience Practice]</option>
						</select>
						</span>
						</div>
						
						<br>
						<div>
						Assigned Stream:
						<span style="float:right;" >
						<select name="assignedStream" class="form-control form-control-sm" style="width:195px">
						<option value="no_value"></option>
							<option value="java">Java</option>
							<option value=".net">.Net</option>
							<option value="sdet">SDET - Software Development Engineer in Testing</option>
							<option value="salesforce">Salesforce</option>
							<option value="bigData">Big-Data</option>
							<option value="dep">DEP - [Digital Experience Practice]</option>
						</select>
						</span>
						</div>
						
						<br>
						<div>
						Date of Joining:
						<span style="float:right;" >
						<input name="dateOfJoining" id="dateOfJoining"  type="date" class="form-control form-control-sm" style="width:195px"/>
						</span>
						</div>
						
						<br>
						<div>
						Mentor:
						<span style="float:right;" >
						<select name="mentorName" class="form-control form-control-sm" style="width:195px">
							<option value="Durga">Durga</option>
							<option value="Revathi">Revathi</option>
						</select>
						</span>
						</div>
						
						<br>
						<div>
						Assigned Location:
						<span style="float:right;" >
						<select name="assignedLocation" class="form-control form-control-sm" style="width:195px">
							<option value="Hyderabad" >Hyderabad</option>
							<option value="pune">Pune</option>
							<option value="banglore">Bangalore</option>
						</select>
						</span>
						</div>
						
						<br>
						<div>
						Relocation:<span class="required">*</span>
						<span style="float:right;" >
						<select name="relocation" id="relocation" class="form-control form-control-sm" style="width:195px" required>
							<option value="Hyderabad">Hyderabad</option>
							<option value="Pune">Pune</option>
						</select>
						</span>
						</div>
						
						<br>
						<div>
						Status:<span class="required">*</span>
						<span style="float:right;" >
						<select name="status" id="status" class="form-control form-control-sm" style="width:195px" required>
							<option value="active">Active</option>
							<option value="terminated">Terminated</option>
							<option value="resigned_fte">Resigned as FTE</option>
							<option value="resigned_intern">Resigned as Intern</option>
						</select>
						</span>
						</div>
 		   		</div>
			
		</div>
	</div>
</div>
</form>
  <!---Footer-->
  <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
  
  </div>
	
</div>
</body>
<script>
		$("#firstName").keypress(function(){
			  if($(this).val().length>=1){}
			 	 $(this).removeClass('txtbrcolr');
			});
		$("#email").keypress(function(){
			  if($(this).val().length>=1){}
			 	 $(this).removeClass('txtbrcolr');
			});
		$("#dateOfBirth").change(function(){
			  if($(this).value){}
			 	 $(this).removeClass('txtbrcolr');
			});
		$("#gender").change(function(){
			  if($(this).val()){}
			 	 $(this).removeClass('txtbrcolr');
			});
		$("#personalLocation").change(function(){
			  if($(this).value){}
			 	 $(this).removeClass('txtbrcolr');
			});
		$("#batchId").change(function(){
			  if($(this).val()){}
			 	 $(this).removeClass('txtbrcolr');
			});
		$("#employeeType").change(function(){
			  if($(this).val()){}
			 	 $(this).removeClass('txtbrcolr');
			});
		$("#coreSkill").change(function(){
			  if($(this).val()){}
			 	 $(this).removeClass('txtbrcolr');
			});
		$("#relocation").change(function(){
			  if($(this).val()){}
			 	 $(this).removeClass('txtbrcolr');
			});
		$("#status").change(function(){
			  if($(this).val()){}
			 	 $(this).removeClass('txtbrcolr');
			});
		$("#dateOfJoining").change(function(){
			  if($(this).value){}
			 	 $(this).removeClass('txtbrcolr');
			});
	</script>
</html>