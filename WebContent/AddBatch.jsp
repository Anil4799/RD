<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Batch Info</title>
		<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<script src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>		
		<style type="text/css">
			.tabs {
			    margin:  0px;
			    padding: 0px;
			    list-style: none;
			    display: table;
			    table-layout: fixed; 
			    width: 100%;	  
			}
		    .tabs_item {
		        display: table-cell; 
		        //width: 250px;       
		    }
		    .tabs_link {
		        display: block; 
		    }
			.primary_nav {
			    text-align: center;
			    border-radius: 4px;
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
			.batch_info_title{
		    	font-size: 17px;
		    	border-radius: 5px 5px 5px 5px;
				background: #fff;
				padding: 5px 5px 5px 15px;				
				height: 30px;	
				margin: 3px;							
			}  	
			.add_batch_head{
				font-size: 20px; 
				padding-left: 20px;
				border-radius: 5px 5px 5px 5px;
				margin: 3px;
				background-color: #fff;
				height: 30px;
			}
			.form_lable{
				width: 300px;
				padding-left: 100px;
				font-size: 14px;
				color: #909497;
			}
			.required{
				color: #e32;
				content: " *";
				display: inline; 
			}
			.batch_info_form{
		    	font-size: 12px;
		    	border-radius: 5px 5px 5px 5px;
				background: #fff;
				padding: 5px 5px 5px 15px;	
				margin: 3px;												
			} 
			.page_footer{
				height: 40px; 
				background-color: #454545;
			}
			.rd_admin_tab{		
				background-color: #23CAEB;
				color: #fff;	
				display: table-cell; 		             
			}
			table.b, table tr.b, table td.b	{ 
				border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; border: 0; 
			}
			.getwidth{width:100%}
			.txtbrcolr
			{
				border-color: red;
			} 		
			.batch_added_message{
				height: 40px;
				width: 250px;
				border-radius: 5px 5px 5px 5px;
				background-color: #DFF0D8;
				color: #008000;
				display: none;
				position: absolute;
				left: 500px;
				top: 60px;"			
			}		  			
		</style>
		<script>
		
			function batchInfoLandingPgae(){
				
				document.getElementById("batch_info_form").action="./batch_info_landing_page.jsp";
			    document.getElementById("batch_info_form").method = "POST";
			    document.getElementById("batch_info_form").submit();
			}
		
			function validateForm() {
				var message = "RD Portal Says"+"\n\n\n";
				var batch_id=document.forms["batch_info_form"]["batch_id"].value;
				var batch_start_date=document.getElementById("batch_start_date").value;
				var batch_end_date=document.getElementById("batch_end_date").value;
				var batch_status=document.getElementById("batch_status").value;
				var default_id="";
				if(batch_id == default_id)
				{
					message += "batch id is auto generated and cannot be empty" + "\n";
					$("#batch_id").addClass('txtbrcolr');
			
				}
			else
				{
					$("#batch_id").removeClass('txtbrcolr');
				}
			if(batch_start_date == null || batch_start_date == ""){
					message += "batch_start_date cannot be empty" + "\n";
					$("#batch_start_date").addClass('txtbrcolr');
				}
			else{
					$("#batch_start_date").removeClass('txtbrcolr');
				}
			
				
				if(message.length > 17 ){
					alert(message);
				}	
				else
					{						
						
						saveAsynchronous(batch_id, batch_start_date, batch_end_date, batch_status);
					}
				
				
			}
			
function saveAsynchronous(batch_id, batch_start_date, batch_end_date, batch_status) {
	var params = "?batch_id="+ batch_id+ "&batch_start_date="+batch_start_date + "&batch_end_date=" + batch_end_date
	  + "&batch_status="+batch_status;
	var xhttp;
	
	if (window.XMLHttpRequest) {
	    xhttp = new XMLHttpRequest();
	  } else {
	    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
	  }
	
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      alert(this.responseText);
	    }
	  };
	  xhttp.open("GET", "./SaveBatchInfoServlet"+ params, true);
	  xhttp.send();
}
	</script>
	</head>
	<body>
		  <div style="font-family: 'Oswald', sans-serif; font-size: 15px; background-color: #ECF0F1; margin: 0px 3px 0px 3px;">
		<div id="batch_added_message" class="batch_added_message" style="padding: 7px 10px 5px 40px;">
			Batch Added Successfully
		</div>
		<!-- <div>
			<ul class="tabs  primary_nav">
				    <li class="rd_admin_tab"> 
				        RD ADMIN PORTAL
				    </li>
				    <li class="tabs_item">
				        <a href="#" class="tabs_link">STUDENT INFO</a>
				    </li>
				    <li class="tabs_item">
				        <a href="#" class="tabs_link">MENTOR INFO</a>
				    </li>
				     <li class="tabs_item">
				        <a href="#" class="tabs_link">BATCH INFO</a>
				    </li>
				    <li class="tabs_item">
				        <a href="#" class="tabs_link">REPORTS</a>
				    </li>
				    <li class="tabs_item">
				        <a href="#" class="tabs_link">SEARCH</a>
				    </li>
				    <li class="tabs_item">
				        <a href="#" class="tabs_link">LOGOUT</a>
				    </li>				   			   
			</ul>
			</div>
		-->	
			<div class="add_batch_head">ADD BATCH</div>
			<div>
				<div>	
					<table class="getwidth">
						<tr>
							<td align="right">
								<span class="savebutton" style="background-color:#58D68D ; color: #FFF" onClick="validateForm()">SAVE</span>
								<span class="backbutton"  onClick="batchInfoLandingPgae()">BACK</span>
							</td>
						</tr>
					</table>						
				</div>			
				<div class="batch_info_title">BATCH INFO</div>
				<div class="batch_info_form">
					<form id="batch_info_form" name="batch_info_form">
						<table>
							
							<tr>
								<td class="form_lable">Start Date: <span class="required">*</span></td>
								<td><input type="date" id="batch_start_date" name="batch_start_date" class="form-control form-control-sm" size="30" required/></td>
							</tr>
							<tr>
								<td class="form_lable">End Date: </td>
								<td><input type="date" id="batch_end_date" class="form-control form-control-sm" name="batch_end_date" size="30" /></td>
							</tr>
							<tr>
								<td class="form_lable">Batch ID: <span class="required">*</span></td>
								<td><input type="text" id="batch_id" name="batch_id" class="form-control form-control-sm" size="30" required readonly placeholder="AUTO-GENERATED"/></td>
							</tr>
							
							<tr>
								<td class="form_lable">Status: <span class="required">*</span></td>
								<td>
									<select name="batch_status" id="batch_status" class="form-control form-control-sm" required>
										<option selected="selected">Not Started</option>
										<option>In Progress</option>
										<option>Completed</option>
									</select>
								</td>
							</tr>
						</table>
					</form>
				</div>				
			</div>	
			<div class="page_footer">
			</div>				
		</div>
	</body>
	<script>
		$("#batch_id").keypress(function(){
			  if($(this).val().length>=1){}
			 	 $(this).removeClass('txtbrcolr');
			});
		$("#batch_start_date").change(function(){
			  if($(this).value){}
			 	 $(this).removeClass('txtbrcolr');
			});
	
		
		$("#batch_status").change(function(){
			  if($(this).val()){}
			 	 $(this).removeClass('txtbrcolr');
			});	
		
		$("#batch_start_date").change(function(){
			var v =document.getElementById('batch_start_date').value;
			var xhttp;
			
			if (window.XMLHttpRequest) {
			    // code for modern browsers
			    xhttp = new XMLHttpRequest();
			  } else {
			    // code for IE6, IE5
			    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
			  }
			
			  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			      document.getElementById('batch_id').value = this.responseText;
			    }
			  };
			  xhttp.open("GET", "./BatchIdControllerServlet?batch_start_date="+v, true);
			  xhttp.send();
					
			
		});	
		
	</script>
</html>