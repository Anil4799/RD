<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/common/header.jspf" %> 
<script src="/admin-portal/js/StudentJS.js"></script>

  <div class="page_info">
		<p class="page_title">ADD STUDENT</p>
	</div>


<div class="container container-custom" style="text-transform: none; max-width=100%">
 
  <!---Body--->  
	
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
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad" >
			
			<span class="backbutton" onClick="gotoStudentLandingPage()">BACK</span>
		</div>
		
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 nopad " >
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad " style="padding: 6.2%;float:left;">
				
				<div class="card">
  					<h5 class="card-header" >PERSONAL INFO</h5>
  					<div class="card-body label_color">
  					<div>
    					<span>First Name:<span class="required"></span></span>
    					<!-- <span style="float:right;width:34%"> -->
    					  					
    					
    					<th scope="row">${student[0].firstName}</th>
    					</span>
					</div>
					<br>
					<div>
						<span>Last Name:<span class="required"></span></span>
						<span style="float:right;width:34%">
						<th scope="row">${student[0].lastName}</th>
						</span>
					</div>
					<br>
					<div>
						Date of Birth:<span class="required"></span>
						<span style="float:right;width:34%">
						<th scope="row">${student[0].dob}</th>
						</span>
					</div>
					<br>
					<div>
						Email:<span class="required"></span>
						<span style="float:right;width:34%">
						<th scope="row">${student[0].email}</th>
						</span>
					</div>
					
					<br>
					<div>
						Gender:<span class="required"></span>
						<span style="float:right; width:34%" >
						<th scope="row">${student[0].gender}</th>
					    </span>
					</div>
					<br>
					<div>
						Contact Number:
						<span style="float:right;width:34%">
						<th scope="row">${student[0].contactNumber}</th>
						</span>
					</div>
					<br>
					<div>
					Location:<span class="required"></span>
					<span style="float:right;width:34%">
					<th scope="row">${student[0].personalLocation}</th>
					</span>
					</div>
    				
 		   		</div>
	   </div>
			</div>
			 <div  style="padding: 5%; ">
				
				<div class="card">
  					<h5 class="card-header">EDUCATIONAL DETAILS</h5>
  					<div class="card-body label_color">
  					<div>
  						
  						College:
  						<span style="float:right;width:34%" >
  							
  						 <th scope="row">${student[0].collegeName}</th>
  						
						
						
  						</span>
  					</div>
  					<br>
    				<div>
    					Location:
    					<span style="float:right;width:34%" >
    					
    					<th scope="row">${student[0].collegeLocation}</th>
    					</span>
    				</div>
					<br>
					
					<div>
					Graduation:
					<span style="float:right;width:34%" >
				<th scope="row">${student[0].graduation}</th>
					</span>
					</div>
					
					<br>
					<div>
					Graduation Speciality:
					<span style="float:right;width:34%" >
					
					<th scope="row">${student[0].graduationSpeciality}</th>
					</span>
					</div>
					
					<br>
					<div>
					Year of Passed Out:
					<span style="float:right;width:34%">
					<th scope="row">${student[0].yearOfPassedOut}</th>
					</span>
					
					</div>
					<br>
					<div>
					Graduation Marks:
					<span style="float:right;width:34%">
				<th scope="row">${student[0].graduationMarks}</th>
					</span>
					</div>
					
					<br>
					<div>
					10th + 2 Marks:
					<span style="float:right;width:34%">
					<th scope="row">${student[0].twelveth}</th>
					</span>
					</div>
					<br>
					<div>
					10th Marks:
					<span style="float:right;width:34%">
				<th scope="row">${student[0].tenth}</th>
					</span>
					</div>
					
					
 		   		</div>
	   </div>
			</div>
		</div>
		<br>
		 <div class="col-md-6 nopad" style=" position: absolute; top: 35px; right: 5px;">
			
			<div class="card">
  					<h5 class="card-header">ADDITIONAL INFO</h5>
  					<div class="card-body label_color">
  					<div>
  						BatchId:<span class="required"></span>
				        <span style="float:right;width:34%">
					       <th scope="row">${student[0].batchId}</th> 
        				</span>
  					</div>
						<br>
						<div>
						Employee Type:<span class="required"></span>
						<span style="float:right;width:34%">
							<th scope="row">${student[0].employeeType}</th>						
						</span>
						</div>
						
						<br>
						<div>
						Core Skill:<span class="required"></span>
						<span style="float:right;width:34%">
						<th scope="row">${student[0].coreSkill}</th>
						</span>
						</div>
						<br>
						<div>
						Preferred Student Stream:
						<span style="float:right;width:34%">
						<th scope="row">${student[0].preferredStudentStream}</th>
						</span>
						</div>
						
						<br>
						<div>
						Assigned Stream:
						<span style="float:right;width:34%" >
						<th scope="row">${student[0].assignedStream}</th>
						</span>
						</div>
						
						<br>
						<div>
						Date of Joining:<span class="required"></span>
						<span style="float:right;width:34%" >
						<th scope="row">${student[0].dateOfJoining}</th>
						</span>
						</div>
						
						<br>
						<div>
						Assigned Location:
						<span style="float:right;width:34%" >
						<th scope="row">${student[0].assignedLocation}</th>
						</span>
						</div>
						
						<br>
						<div>
						Relocation:<span class="required"></span>
						<span style="float:right;width:34%" >
						<th scope="row">${student[0].relocation}</th>
						</span>
						</div>
						
						<br>
						<div>
						Status:<span class="required"></span>
						<span style="float:right;width:34%" >
						<th scope="row">${student[0].status}</th>
						</span>
						</div>
 		   		</div>
			
		</div>
	</div>
</div>
</form>
 	
</div>

<%@ include file="/common/footer.jspf"%>
