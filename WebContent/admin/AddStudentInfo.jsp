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
			<span class="savebutton" style="background-color:#5CB85C ; color: #FFF;" name="save"  onClick="studentValidateForm()">SAVE</span>
			<span class="backbutton" onClick="gotoStudentLandingPage()">BACK</span>
		</div>
		
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 nopad " >
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopad " style="padding: 5%;float:left;">
				
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
						 <input name="dateOfBirth" id="dateOfBirth"  type="date" class="form-control form-control-sm"  />
						</span>
					</div>
					<br>
					<div>
						Email:<span class="required">*</span>
						<span style="float:right;width:34%">
						<input name="email" id="email"  type="email" class="form-control form-control-sm" />
						</span>
					</div>
					
					<br>
					<div>
						Gender:<span class="required">*</span>
						<span style="float:right; width:34%" >
						<select name="gender" id="gender" class="form-control form-control-sm"  required>
						<option value="no_value"></option>
						<option value="male">Male</option>
						<option value="female">Female</option>
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
  						 
  						 <c:forEach items="${collegeNames}" var="cn" >
							<option value="${cn}>">${cn}</option>
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
		 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 nopad" style=" position: absolute; top: 35px; right: 20px;">
			
			<div class="card">
  					<h5 class="card-header">ADDITIONAL INFO</h5>
  					<div class="card-body label_color">
  					<div>
  						BatchId:<span class="required">*</span>
				        <span style="float:right;width:34%">
					        <select name="batchId" id="batchId" class="form-control form-control-sm"  required>
					       <option value="NULL"></option>
					      <%
					        String batchId = "";
					      Connection connection = DBManager.getConnection();
					      PreparedStatement preparedStatement=null;
					      ResultSet resultSet =null;
					         preparedStatement = connection.prepareStatement("select Batch_Id from batch_info");
					         resultSet = preparedStatement.executeQuery();
					        while(resultSet.next())
					        {
					         batchId = resultSet.getString("Batch_Id");
					        
					        %>
					       <option value="<%=batchId%>"><%=batchId %></option>
					       <% } %>
					       </select>
        				</span>
  					</div>
						<br>
						<div>
						Employee Type:<span class="required">*</span>
						<span style="float:right;width:34%">
						<select name="employeeType" id="employeeType" class="form-control form-control-sm"  required>
						<option value="NULL"></option>
						<% 
  						String employee_type = "";
  						 preparedStatement = connection.prepareStatement("select Employee_Type from employee_type");
  						 resultSet = preparedStatement.executeQuery();
  						while(resultSet.next())
  						{
  							employee_type = resultSet.getString("employee_type");
  						
  						%>
							<option value="<%=employee_type%>"><%=employee_type %></option>
							<% } %>
							</select>
						</span>
						</div>
						
						<br>
						<div>
						Core Skill:<span class="required">*</span>
						<span style="float:right;width:34%">
						<select name="coreSkill" id="coreSkill" class="form-control form-control-sm"  required>
						<option value="NULL"></option>
						<% 
  						String skill = "";
  						 preparedStatement = connection.prepareStatement("select Skill_Name from core_skill");
  						 resultSet = preparedStatement.executeQuery();
  						while(resultSet.next())
  						{
  							skill = resultSet.getString("Skill_Name");
  						
  						%>
  						
							<option value="<%=skill	%>"><%=skill %></option>
							<% } %>
							</select>
						</span>
						</div>
						<br>
						<div>
						Preferred Student Stream:
						<span style="float:right;width:34%">
						<select name="preferredStudentStream" class="form-control form-control-sm" >
						<option value="NULL"></option>
						<% 
  						String streamName = "";
  						 preparedStatement = connection.prepareStatement("select Stream_Name from technical_stream");
  						 resultSet = preparedStatement.executeQuery();
  						while(resultSet.next())
  						{
  							
  							streamName = resultSet.getString("Stream_Name");
  						
  						%>
  						
							<option value="<%=streamName	%>"><%=streamName %></option>
							<% } %>
							</select>
						</span>
						</div>
						
						<br>
						<div>
						Assigned Stream:
						<span style="float:right;width:34%" >
						<select name="assignedStream" class="form-control form-control-sm" >
						<option value="NULL"></option>
						<% 
  						 preparedStatement = connection.prepareStatement("select Stream_Name from technical_stream");
  						 resultSet = preparedStatement.executeQuery();
  						while(resultSet.next())
  						{
  							
  							streamName = resultSet.getString("Stream_Name");
  						
  						%>
  						
							<option value="<%=streamName	%>"><%=streamName %></option>
							<% } %>
							</select>
						</span>
						</div>
						
						<br>
						<div>
						Date of Joining:<span class="required">*</span>
						<span style="float:right;width:34%" >
						<input name="dateOfJoining" id="dateOfJoining"  type="date" class="form-control form-control-sm"  />
						</span>
						</div>
						
						<br>
						<div>
						Mentor:
					      <span style="float:right;width:34%" >
						      <select name="mentorName" class="form-control form-control-sm" >
						      <option value="NULL"></option>
						       <%
						       String Mentor_Name = "";
						         preparedStatement = connection.prepareStatement("select Mentor_Name, Email_Id from mentor_info");
						         resultSet = preparedStatement.executeQuery();
						        while(resultSet.next())
						        {
						         Mentor_Name = resultSet.getString("Mentor_Name");
						        
						        %>
						        
						       <option value="<%=Mentor_Name %>"><%=Mentor_Name %></option>
						       <% } %>
						       </select>
					      </span>
						</div>
						
						<br>
						<div>
						Assigned Location:
						<span style="float:right;width:34%" >
						<select name="assignedLocation" class="form-control form-control-sm" >
							
						<% 
  						String assignedLocation = "";
  						 preparedStatement = connection.prepareStatement("select Assigned_Location from assigned_location");
  						 resultSet = preparedStatement.executeQuery();
  						while(resultSet.next())
  						{
  							assignedLocation = resultSet.getString("Assigned_Location");
  						
  						%>
  						<option value="<%=assignedLocation	%>"><%=assignedLocation %></option>
							<% } %>
							</select>
						</span>
						</div>
						
						<br>
						<div>
						Relocation:<span class="required">*</span>
						<span style="float:right;width:34%" >
						<select name="relocation" id="relocation" class="form-control form-control-sm"  required>
							<option value="no_value"></option>
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select>
						</span>
						</div>
						
						<br>
						<div>
						Status:<span class="required">*</span>
						<span style="float:right;width:34%" >
						<select name="status" id="status" class="form-control form-control-sm"  required>
							
						<% 
  						String employeeStatus = "";
  						 preparedStatement = connection.prepareStatement("select Employee_Status from Employee_Status");
  						 resultSet = preparedStatement.executeQuery();
  						while(resultSet.next())
  						{
  							employeeStatus = resultSet.getString("Employee_Status");
  						
  						%>
  						
							<option value="<%=employeeStatus.toLowerCase()%>"><%=employeeStatus %></option>
							<% } %>
							</select>
						</span>
						</div>
 		   		</div>
			
		</div>
	</div>
</div>
</form>
 	
</div>

<%@ include file="/common/footer.jspf"%>
