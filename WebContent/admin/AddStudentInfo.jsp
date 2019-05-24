<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/common/header.jspf" %> 
<script src="/admin-portal/js/StudentJS.js"></script>
<style>
.btn {
    display: inline-block;    font-weight: 400;    color: #A9A9A9;    padding: 0px;    text-align: center;    vertical-align: middle;    -webkit-user-select: none;    -moz-user-select: none;    -ms-user-select: none;    user-select: none;    background-color: transparent;    border: 1px solid transparent;    /* padding: .375rem .75rem; */    font-size: 1rem;    line-height: 1.5;    border-radius: .25rem;    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;}
    </style>

  <div class="page_info">
		<p class="page_title">ADD STUDENT</p>
	</div>

<div id="blank_popup" class="blank-popup-div"></div>
<div class=" container-custom" >
 
  <!---Body--->  
 		
 
	
	<div id="alert_popup" class="alert_popup">	
			<div style="margin: 10px 0px 20px 10px;">
				RD Portal Says
			</div>
			<div id="message_info">
			</div>
			<span class="ok_button" style="background-color:#5CB85C ; color: #FFF;" onClick="closeAlertPopup()">OK</span>		
		</div>
	<form action ="StudentServlet" name="add_student_info" id="add_student_info" method="post">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad" style="background-color: rgb(235,235,235); ">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad"  style="padding-right:3.5%;">
			<span class="savebutton" style="background-color:#5CB85C ; color: #FFF;"  onClick="studentValidateForm()">SAVE</span>
			<span class="backbutton" onClick="gotoStudentLandingPage()">BACK</span>
		</div>
		
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 nopad " style="margin-top:0.5%; padding-right: 2%; " >
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad " style="padding: 5%;float:left; margin-top: 1%;">
				
				<div class="card">
  					<h5 class="card-header" >PERSONAL INFO</h5>
  					<div class="card-body label_color">
  					<div>
    					<span>First Name:<span class="required">*</span></span>
    					<span style="float:right;width:34%">
    					<input name="firstName"  id="firstName" type="text"  class="form-control form-control-sm"  />
    					</span>
					</div>
					<br>
					<div>
						<span>Last Name:<span class="required">*</span></span>
						<span style="float:right;width:34%">
						<input name="lastName" id="lastName"  type="text" class="form-control form-control-sm"  />
						</span>
					</div>
					<br>
					<div>
						Date of Birth:<span class="required">*</span>
						<span style="float:right;width:34%">
						<input type="text" class="border-right-0 form-control-sm" id="dateOfBirth" name="dateOfBirth"/>
						 <!-- <input name="dateOfBirth" id="dateOfBirth"  type="date" class="form-control form-control-sm"  /> -->
						</span>
					</div>
					<br>
					<div>
						Email:<span class="required">*</span>
						<span style="float:right;width:34%">
						<input name="email" id="email"  type="text" class="form-control form-control-sm" />
						</span>
					</div>
					
					<br>
					<div>
						Gender:<span class="required">*</span>
						<span style="float:right; width:34%" >
						<select name="gender" id="gender" class="form-control form-control-sm"  required>
						<option value="no_value"></option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					    </select>
					    </span>
					</div>
					<br>
					<div>
						Contact Number:
						<span style="float:right;width:34%">
						<input name="contactNumber" id="contactNumber" type="text" class="form-control form-control-sm" />
						</span>
					</div>
					<br>
					<div>
					Location:<span class="required">*</span>
					<span style="float:right;width:34%">
					<input name="personalLocation" id="personalLocation" type="text" class="form-control form-control-sm" />
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
  							<select name="collegeName" class="form-control form-control-sm" on change="setLocation(this.value)" >
  						 
  						 <c:forEach items="${collegeNames}" var="collegeName" >
							<option value="${collegeName.collegeName}$${collegeName.collegeLocation}">${collegeName.collegeName}</option>
						</c:forEach>
						
							</select>
  						</span>
  					</div>
  					<br>
    				<div>
    					Location:
    					<span style="float:right;width:34%" >
    					
    					<input name="collegeLocation" type="text" class="form-control form-control-sm"  value=""/>
    					</span>
    				</div>
					<br>
					
					<div>
					Graduation:
					<span style="float:right;width:34%" >
					<input name="graduation" type="text" class="form-control form-control-sm" />
					</span>
					</div>
					
					<br>
					<div>
					Graduation Speciality:
					<span style="float:right;width:34%" >
					<select name="graduationSpeciality" class="form-control form-control-sm"  >
					<option value="NULL"></option>
						<option value="ece">ECE</option>
						<option value="cse">CSE</option>
						<option value="it">IT</option>
					</select>
					</span>
					</div>
					
					<br>
					<div>
					Year of Passed Out:
					<span style="float:right;width:34%">
					<input name="yearOfPassedOut" type="text" class="form-control form-control-sm" />
					</span>
					
					</div>
					<br>
					<div>
					Graduation Marks:
					<span style="float:right;width:34%">
					<input name="graduationMarks" type="text"  class="form-control form-control-sm" />
					</span>
					</div>
					
					<br>
					<div>
					10th + 2 Marks:
					<span style="float:right;width:34%">
					<input name="twelveth" type="text" class="form-control form-control-sm"/>
					</span>
					</div>
					<br>
					<div>
					10th Marks:
					<span style="float:right;width:34%">
					<input name="tenth" type="text" class="form-control form-control-sm" />
					</span>
					</div>
					
					
 		   		</div>
	   </div>
			</div>
		</div>
		 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 nopad" style=" position: absolute; top: 35px; right: 20px; margin-top: 0.5%;padding-right: 2%;

padding-left: 1%;">
			
			<div class="card">
  					<h5 class="card-header">ADDITIONAL INFO</h5>
  					<div class="card-body label_color">
  					<div>
  						BatchId:<span class="required">*</span>
				        <span style="float:right;width:34%">
					        <select name="batchId" id="batchId" class="form-control form-control-sm"  required>
						       <option value="NULL"></option>
							     <c:forEach items="${batchIDList}" var="batchID" >
									<option value="${batchID}">${batchID}</option>
								</c:forEach>
					       </select>
        				</span>
  					</div>
						<br>
						<div>
						Employee Type:<span class="required">*</span>
						<span style="float:right;width:34%">
						<select name="employeeType" id="employeeType" class="form-control form-control-sm"  required>
						<option value="NULL"></option>
						<c:forEach items="${employeeTypeList}" var="employeeType" >
									<option value="${employeeType}">${employeeType}</option>
						</c:forEach>
							</select>
						</span>
						</div>
						
						<br>
						
						
						
						<div>
						Core Skill:<span class="required">*</span>
						<span style="float:right;width:34%">
						<select name="coreSkill" id="coreSkill" class="form-control form-control-sm"  required>
						<option value="NULL"></option>
						<c:forEach items="${coreSkills}" var="coreSkill" >
									<option value="${coreSkill}">${coreSkill}</option>
						</c:forEach>
							</select>
						</span>
						</div>
						<br>
						<div>
						Preferred Student Stream:
						<span style="float:right;width:34%">
						<select name="preferredStudentStream" class="form-control form-control-sm" >
						<option value="NULL"></option>
						<c:forEach items="${preferredStreams}" var="preferredStream" >
									<option value="${preferredStream}">${preferredStream}</option>
						</c:forEach>
						
  						
						
							</select>
						</span>
						</div>
						
						<br>
						<div>
						Assigned Stream:
						<span style="float:right;width:34%" >
						<select name="assignedStream" class="form-control form-control-sm" >
						<option value="NULL"></option>
						<c:forEach items="${assignedStreams}" var="assignedStream" >
									<option value="${assignedStream}">${assignedStream}</option>
						</c:forEach>
							</select>
						</span>
						</div>
						
						<br>
						<div>
						Date of Joining:<span class="required">*</span>
						<span style="float:right;width:34%" >
						<input class="border-right-0 form-control-sm" id="dateOfJoining" name="dateOfJoining"/>
						<!-- <input name="dateOfJoining" id="dateOfJoining"  type="date" class="form-control form-control-sm"  />-->
						</span>
						</div>
						
						<br>
						<div>
						Mentor:
					      <span style="float:right;width:34%" >
						      <select name="mentorName" class="form-control form-control-sm" >
						      <option value="NULL"></option>
						      <c:forEach items="${mentorList}" var="mentorName" >
									<option value="${mentorName}">${mentorName}</option>
						</c:forEach>
						       </select>
					      </span>
						</div>
						
						<br>
						<div>
						Assigned Location:
						<span style="float:right;width:34%" >
						<select name="assignedLocation" class="form-control form-control-sm" >
							
						<c:forEach items="${assignedLocationList}" var="assignedLocation" >
									<option value="${assignedLocation}">${assignedLocation}</option>
						</c:forEach>
							</select>
						</span>
						</div>
						
						<br>
						<div>
						Relocation:<span class="required">*</span>
						<span style="float:right;width:34%" >
						<select name="relocation" id="relocation" class="form-control form-control-sm"  required>
							<option value="no_value"></option>
							<option value="Yes">Yes</option>
							<option value="No">No</option>
						</select>
						</span>
						</div>
						
						<br>
						<div>
						Status:<span class="required">*</span>
						<span style="float:right;width:34%" >
						<select name="status" id="status" class="form-control form-control-sm"  required>
							
						<c:forEach items="${statusList}" var="status" >
									<option value="${status}">${status}</option>
						</c:forEach>
							</select>
						</span>
						</div>
 		   		</div>
			
		</div>
	</div>
</div>
<script>


$("#lastName").keyup(function(){
    if($(this).val().length >0){
$("#lastName").removeClass("txtbrcolr");
}    
});

$("#dateOfBirth").change(function(){
    if($(this).val().length >0){
$("#dateOfBirth").removeClass("txtbrcolr");
}    
});

$("#dateOfJoining").change(function(){
    if($(this).val().length >0){
$("#dateOfJoining").removeClass("txtbrcolr");
}    
});


$('#dateOfBirth').datepicker({
    uiLibrary: 'bootstrap4',
    iconsLibrary: 'fontawesome',
    format: 'mm-dd-yyyy',
    
   
});
$('#dateOfJoining').datepicker({
    uiLibrary: 'bootstrap4',
    iconsLibrary: 'fontawesome',
    format: 'mm-dd-yyyy',
});


</script>

</form>
 	
</div>

<%@ include file="/common/footer.jspf"%>
