
     <%@ include file="/common/header.jspf" %>
     <style>
     	.mentor_info_form td{
				border: 0px;
			}
     </style>

		<div style="font-family: 'Oswald', sans-serif; font-size: 15px; background-color: #EBEBEB; margin: 0px 3px 0px 3px; padding-top: 1px;">
		<div id="mentor_added_message" class="mentor_added_message" style="padding: 10px 10px 5px 25px;">
			Mentor Updated Successfully
		</div>		
		<div id="alert_popup" class="alert_popup" style="padding: 7px 10px 5px 40px; border: 1px solid #DCDCDC;">	
			<div style="margin: 10px 0px 20px 10px;">
				RD Portal Says
			</div>
			<div id="message_info" style="font-family: Oswald">
			</div>
			<span class="ok_button" style="background-color:#5CB85C ; color: #FFF" onClick="closeAlertPopup()">OK</span>		
		</div>		
		<div class="add_mentor_head">ADD MENTOR</div>
		<div>
			<div>	
				<table width="100%">
					<tr>
						<td align="right" style="padding: 0px 10px 0px 0px;">
							<span class="savebutton" style="background-color:#5CB85C ; color: #FFF" onClick="validateForm()">SAVE</span>
							<a href="mentor_info_landing_page.jsp" class="backbutton" style="text-decoration: none; color: #464343;">BACK</span>
						</td>
					</tr>
				</table>						
			</div>			
			<div class="mentor_info_title">MENTOR INFO</div>
			<div class="mentor_info_form" style="height: 100%;">
				<form id="mentor_info_form" name="mentor_info_form">
					<table width="38%" style="margin-left: 25%;">
						<tr>
							<td class="form_lable">Name:<span class="required">*</span></td>
							<td><input type="text" id="mentor_name" name="mentor_name" class="form-control form-control-sm" size="30" required/></td>								
						</tr>
						<tr>
							<td class="form_lable">Email:<span class="required">*</span> </td>
							<td><input type="text"  id="mentor_email" name="mentor_email" class="form-control form-control-sm" size="30" required/>
						</tr>
						<tr>
							<td class="form_lable">Mentorship Start Date:<span class="required">*</span></td>
							<td><input type="date" id="mentorship_start_date"  name="mentor_start_date" class="form-control form-control-sm" size="30" required/>
						</tr>
						<tr>
							<td class="form_lable">Mentorship End Date: </td>
							<td><input type="date" class="form-control form-control-sm" name="mentor_end_date" size="30" />
						</tr>
						<tr>
							<td class="form_lable">Max No.of Mentees:<span class="required">*</span></td>
							<td><input type="text" id="max_no_of_mentees" name="max_noof_mentees" class="form-control form-control-sm" size="30" required/>
						</tr>
						<tr>
							<td class="form_lable">Technology Stream: </td>
							<td>
								<select name="mentor_technology" class="form-control form-control-sm">
								<option></option>
								<%
								try{
								Connection con=DBManager.getConnection();		
								PreparedStatement ps=con.prepareStatement("select coursename from technical_stream");
								ResultSet rs=ps.executeQuery();
								while(rs.next())
								{
								%>
								
						<option  style="font-family: Oswald"><%=rs.getString(1)%></option>
								<%
								}
								}
								catch(Exception e)
								{
								e.printStackTrace();
								}
							
								%>	
								</select>
							</td>
						</tr>
						<tr>
							<td class="form_lable">Status:<span class="required">*</span> </td>
							<td>
								<select id="mentor_status" name="mentor_status" class="form-control form-control-sm" required>										
									<option >ACTIVE</option>
									<option>INACTIVE</option>
									<option >ONHOLD</option>
								</select>
							</td>
						</tr>
					</table>
				</form>
			</div>				
			</div>			
			<script>
				function gotoMentoInfo() {
					document.location.href = '/admin-portal/mentorList';					  
					}
	
				setTimeout(gotoMentoInfo, 1000);
			</script>				
		</div>

<%@ include file="/common/footer.jspf"%>
