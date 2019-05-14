
<%@ include file="/common/header.jspf" %> 


<div class="container container-custom">
	
 
  
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
  					<h5 class="card-header">EDUCATIONAL DETAILS</h5>
  					<div class="card-body label_color">
  					<div>
  						
  						College:
  						<span style="float:right;" >
  							<select name="collegeName" class="form-control form-control-sm" style="width:195px" onchange="setLocation(this.value)" >
  						<option value="no_value"></option>
  						<% Connection connection = DBManager.getConnection();
  						String collegeName = null, collegeLocation = "";
  						PreparedStatement preparedStatement = connection.prepareStatement("select college_name, location from student_college_info");
  						ResultSet resultSet = preparedStatement.executeQuery();
  						while(resultSet.next())
  						{
  							// collegeName = resultSet.getString(1);
  							collegeName = resultSet.getString("college_name");
  						
  						%>
  						
							<option value="<%=collegeName+"$"+resultSet.getString("Location")%>"><%=collegeName %></option>
							<% } %>
							</select>
  						</span>
  					</div>
  					<br>
    				<div>
    					Location:
    					<span style="float:right;" >
    					
    					<input name="collegeLocation" type="text" class="form-control form-control-sm" size="30" value="<%=collegeLocation %>"/>
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
					10th + 2 Marks:
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
						<% 
  						String employee_type = "";
  						 preparedStatement = connection.prepareStatement("select Employee_Type from employee_type");
  						 resultSet = preparedStatement.executeQuery();
  						while(resultSet.next())
  						{
  							// collegeName = resultSet.getString(1);
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
						<span style="float:right;">
						<select name="coreSkill" id="coreSkill" class="form-control form-control-sm" style="width:195px" required>
						<option value="no_value"></option>
						<% 
  						String skill = "";
  						 preparedStatement = connection.prepareStatement("select Skill_Name from core_skill");
  						 resultSet = preparedStatement.executeQuery();
  						while(resultSet.next())
  						{
  							// collegeName = resultSet.getString(1);
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
						<span style="float:right;">
						<select name="preferredStudentStream" class="form-control form-control-sm" style="width:195px">
						<option value="no_value"></option>
						<% 
  						String streamName = "";
  						 preparedStatement = connection.prepareStatement("select Stream_Name from technical_stream");
  						 resultSet = preparedStatement.executeQuery();
  						while(resultSet.next())
  						{
  							// collegeName = resultSet.getString(1);
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
						<span style="float:right;" >
						<select name="assignedStream" class="form-control form-control-sm" style="width:195px">
						<option value="no_value"></option>
						<% 
  						//String streamName = "";
  						 preparedStatement = connection.prepareStatement("select Stream_Name from technical_stream");
  						 resultSet = preparedStatement.executeQuery();
  						while(resultSet.next())
  						{
  							// collegeName = resultSet.getString(1);
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
						<span style="float:right;" >
						<input name="dateOfJoining" id="dateOfJoining"  type="date" class="form-control form-control-sm" style="width:195px"/>
						</span>
						</div>
						
						<br>
						<div>
						Mentor:
						<span style="float:right;" >
						<select name="mentorName" class="form-control form-control-sm" style="width:195px">
						<option value="no_value"></option>
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
							<option value="no_value"></option>
						<% 
  						String assignedLocation = "";
  						 preparedStatement = connection.prepareStatement("select Assigned_Location from assigned_location");
  						 resultSet = preparedStatement.executeQuery();
  						while(resultSet.next())
  						{
  							// collegeName = resultSet.getString(1);
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
						<span style="float:right;" >
						<select name="relocation" id="relocation" class="form-control form-control-sm" style="width:195px" required>
							<option value="no_value"></option>
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select>
						</span>
						</div>
						
						<br>
						<div>
						Status:<span class="required">*</span>
						<span style="float:right;" >
						<select name="status" id="status" class="form-control form-control-sm" style="width:195px" required>
							<option value="no_value"></option>
						<% 
  						String employeeStatus = "";
  						 preparedStatement = connection.prepareStatement("select Employee_Status from Employee_Status");
  						 resultSet = preparedStatement.executeQuery();
  						while(resultSet.next())
  						{
  							// collegeName = resultSet.getString(1);
  							employeeStatus = resultSet.getString("Employee_Status");
  						
  						%>
  						
							<option value="<%=employeeStatus	%>"><%=employeeStatus %></option>
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
