<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/common/header.jspf" %> 
<script src="/admin-portal/js/StudentJS.js"></script>

  <div class="page_info">
		<p class="page_title">ADD STUDENT</p>
	</div>


<div class="container container-custom" style="text-transform: none; max-width=100%">
 
  <!---Body--->  
	

	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad" style="background-color: rgb(235,235,235);">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad" >
			
			<span class="backbutton" onClick="gotoMentorStudentLandingPage()">BACK</span>
		</div>
		
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 nopad " >
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad " style="padding: 6.2%;float:left;">
				
				<div class="card">
  					<h5 class="card-header" >PERSONAL INFO</h5>
  					<div class="card-body label_color">
  					<div>
    					<span>First Name:
    					<!-- <span style="float:right;width:34%"> -->
    					 <span class="displayViewFont">		
    						<c:out value="${student[0].firstName.equals('') ? '': student[0].firstName}" />
    					</span>
					</div>
					<br>
					<div>
						<span>Last Name:
						<span class="displayViewFont">
							<c:out value="${student[0].lastName.equals('') ? '': student[0].lastName}" />
						</span>
					</div>
					<br>
					<div>
						Date of Birth:
						<span class="displayViewFont">
							<c:out value="${student[0].dob}" />
						</span>
					</div>
					<br>
					<div>
						Email:
						<span class="displayViewFont">
						<c:out value="${student[0].email}" />
						</span>
					</div>
					
					<br>
					<div>
						Gender:
						<span  class="displayViewFont" >
						<c:out value="${student[0].gender.equals('') ? '': student[0].gender}" />
					    </span>
					</div>
					<br>
					<div>
						Contact Number:
						<span class="displayViewFont">
						<c:out value="${student[0].contactNumber == 0 ? '': student[0].contactNumber}" />
						</span>
					</div>
					<br>
					<div>
					Location:
					<span class="displayViewFont">
					<c:out value="${student[0].personalLocation.equals('') ? '': student[0].personalLocation}" />
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
  						<span class="displayViewFont" >
  							
  						<c:out value="${student[0].collegeName.equals('') ? '': student[0].collegeName}"/>
  						
						
						
  						</span>
  					</div>
  					<br>
    				<div>
    					Location:
    					<span class="displayViewFont">
    					
    					<c:out value="${student[0].collegeLocation.equals('') ? '':student[0].collegeLocation}"/>
    					</span>
    				</div>
					<br>
					
					<div>
					Graduation:
					<span class="displayViewFont" >
				<c:out value="${student[0].graduation.equals('') ? '':student[0].graduation}"/>
					</span>
					</div>
					
					<br>
					<div>
					Graduation Speciality:
					<span class="displayViewFont">
					
					<c:out value="${student[0].graduationSpeciality==0 ? '': student[0].graduationSpeciality}"/>
					</span>
					</div>
					
					<br>
					<div>
					Year of Passed Out:
					<span class="displayViewFont">
					<c:out value="${student[0].yearOfPassedOut==0 ? '':student[0].yearOfPassedOut}"/>
					</span>
					
					</div>
					<br>
					<div>
					Graduation Marks:
					<span class="displayViewFont">
						<c:out value="${student[0].graduationMarks==0 ? '':student[0].graduationMarks}" />
					</span>
					</div>
					
					<br>
					<div>
					10th + 2 Marks:
					<span class="displayViewFont">
						<c:out value="${student[0].twelveth==0 ? '':student[0].twelveth}" />
					</span>
					</div>
					<br>
					<div>
					10th Marks:
					<span class="displayViewFont">
						<c:out value="${student[0].tenth==0 ? '':student[0].tenth}" />
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
  						BatchId:
				        <span class="displayViewFont">
					      <c:out value="${student[0].batchId}" />
        				</span>
  					</div>
						<br>
						<div>
						Employee Type:
						<span class="displayViewFont">
							<c:out value="${student[0].employeeType.equals('') ? '': student[0].employeeType}" />						
						</span>
						</div>
						
						<br>
						<div>
						Core Skill:
						<span class="displayViewFont">
						<c:out value="${student[0].coreSkill.equals('') ? '': student[0].coreSkill}" />
						</span>
						</div>
						<br>
						<div>
						Preferred Student Stream:
						<span class="displayViewFont">
						<c:out value="${student[0].preferredStudentStream.equals('') ? '': student[0].preferredStudentStream}" />
						</span>
						</div>
						
						<br>
						<div>
						Assigned Stream:
						<span class="displayViewFont" >
						<c:out value="${student[0].assignedStream.equals('') ? '': student[0].assignedStream}" />
						</span>
						</div>
						
						<br>
						<div>
						Date of Joining:
						<span class="displayViewFont" >
						<th scope="row"><c:out value="${student[0].dateOfJoining}" /></th>
						</span>
						</div>
						
						<br>
						<div>
						Assigned Location:
						<span class="displayViewFont" >
						<c:out value="${student[0].assignedLocation.equals('') ? '': student[0].assignedLocation}" />
						</span>
						</div>
						
						<br>
						<div>
						Relocation:
						<span class="displayViewFont" >
						<c:out value="${student[0].relocation.equals('') ? '': student[0].relocation}" />
						</span>
						</div>
						
						<br>
						<div>
						Status:
						<span class="displayViewFont">
						<c:out value="${student[0].status.equals('') ? '': student[0].status}" />
						</span>
						</div>
 		   		</div>
			
		</div>
	</div>
</div>
 	
</div>

<%@ include file="/common/footer.jspf"%>
