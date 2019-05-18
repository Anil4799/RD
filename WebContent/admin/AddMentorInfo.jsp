
     <%@ include file="/common/header.jspf" %>

		<style type="text/css">
			.mentor_info_form td{
				border: 0px;
			}
		</style>	
	
		<div style="font-family: 'Oswald', sans-serif; font-size: 15px; background-color: #ECF0F1; margin: 0px 3px 0px 3px; padding-top: 1px;">		
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
						<td align="right">
							<span class="savebutton" style="background-color:#5CB85C ; color: #FFF" onClick="validateForm()">SAVE</span>
							<span onClick="gotoMentorInfo()" class="backbutton">BACK</span>
						</td>
					</tr>
				</table>						
			</div>			
			<div class="mentor_info_title">MENTOR INFO</div>
			<div class="mentor_info_form" style="height: 100%; padding: 20px 0px 20px 0px;">
				<form id="mentor_info_form" name="mentor_info_form">
					<table>
						<tr>
							<td class="form_lable">Name:<span class="required">*</span></td>
							<td><input type="text" id="mentor_name" name="mentor_name" class="form-control form-control-sm" size="30" required/></td>								
						</tr>
						<tr>
							<td class="form_lable">Email:<span class="required">*</span> </td>
							<td><input type="text"  id="mentor_email" name="mentor_email" class="form-control form-control-sm" size="30" required/></td>
						</tr>
						<tr>
							<td class="form_lable">Mentorship Start Date:<span class="required">*</span></td>
							<td><input type="date" id="mentorship_start_date"  name="mentor_start_date" class="form-control form-control-sm" size="30" required/--></td>
						</tr>
						<tr>
							<td class="form_lable">Mentorship End Date: </td>
							<td><input type="date" class="form-control form-control-sm" name="mentor_end_date" size="30" /></td>
						</tr>
						<tr>
							<td class="form_lable">Max No.of Mentees:<span class="required">*</span></td>
							<td><input type="number" id="max_no_of_mentees" name="max_noof_mentees" class="form-control form-control-sm" size="30" required/>
						</tr>
						<tr>
							<td class="form_lable">Technology Stream: </td>
							<td>
								<select name="mentor_technology" class="form-control form-control-sm">
								<option></option>
								<%
								try{
								Connection con=DBManager.getConnection();		
								PreparedStatement ps=con.prepareStatement("select Stream_Name from technical_stream ");
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
									<option value="active">ACTIVE</option>
									<option value="inactive">INACTIVE</option>
									<option value="onhold">ONHOLD</option>
								</select>
							</td>
						</tr>
					</table>
				</form>
			</div>				
			</div>							
		</div>

<%@ include file="/common/footer.jspf"%>