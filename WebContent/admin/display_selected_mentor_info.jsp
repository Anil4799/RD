
     <%@ include file="/common/header.jspf" %>

		<style type="text/css">
			.mentor_info_form td{
				border: 0px;
			}
		</style>	
		
		<div class="page_info">
		<p class="page_title">ADD MENTOR</p>
	</div>
	
		<div style="font-family: 'Oswald', sans-serif; font-size: 15px; background-color: #ECF0F1; margin: 0px 3px 0px 3px; padding-top: 1px;">
		<div id="blank_popup" style="height: 600px; width: 100%; display: none; position: absolute; top: 0px; left: 0px; opacity: 0.1; background-color: #fff;"></div>			
		<div id="alert_popup" class="alert_popup" style="padding: 7px 10px 5px 40px; border: 1px solid #DCDCDC;">	
			<div style="margin: 10px 0px 20px 10px;">
				RD Portal Says
			</div>
			<div id="message_info" style="font-family: Oswald">
			</div>
			<span class="ok_button" style="background-color:#5CB85C ; color: #FFF" onClick="closeAlertPopup()">OK</span>		
		</div>		
		<div>
			<div>	
				<table width="100%">
					<tr>
						<td align="right" style="padding: 0px;">
							<span class="savebutton" style="background-color:#5CB85C ; color: #FFF" onClick="validateForm()">SAVE</span>
							<span onClick="gotoMentorInfo()" class="backbutton">BACK</span>
						</td>
					</tr>
				</table>						
			</div>			
			<div class="mentor_info_title">MENTOR INFO</div>
			<div class="mentor_info_form" style="height: 100%; padding: 20px 0px 20px 0px;">
				<form id="mentor_info_form" name="mentor_info_form">
					<table width="40%" style="margin-left: 25%;">
						<tr>
							<td class="form_lable">Name:<span class="required">*</span></td>
							<td>Mentor Name</td>								
						</tr>
						<tr>
							<td class="form_lable">Email:<span class="required">*</span> </td>
							<td>Mentor Email</td>
						</tr>
						<tr>
							<td class="form_lable">Mentorship Start Date:<span class="required">*</span></td>
							<td>Mentor Ship Start Date</td>
						</tr>
						<tr>
							<td class="form_lable">Mentorship End Date: </td>
							<td>Mentor Ship End Date</td>
						</tr>
						<tr>
							<td class="form_lable">Max No.of Mentees:<span class="required">*</span></td>
							<td>Max No.of Mentees</td>
						</tr>
						<tr>
							<td class="form_lable">Technology Stream: </td>
							<td>Technology Stream
								<!--select name="mentor_technology" class="form-control form-control-sm">
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
								</select-->
							</td>
						</tr>
						<tr>
							<td class="form_lable">Status:<span class="required">*</span> </td>
						
							<td>Status</td>	
						
						</tr>
					</table>
				</form>
			</div>				
			</div>							
		</div>

<%@ include file="/common/footer.jspf"%>