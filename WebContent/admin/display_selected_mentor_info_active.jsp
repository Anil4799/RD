
     <%@ include file="/common/header.jspf" %>
     <%@page import="com.epam.dao.admin.MentorBean"%> 
     <%@page import="java.text.*" %>
     

		<style type="text/css">
			.mentor_info_form td{
				border: 0px;
			}
			.form_value{			
			color: #6E6E6E;
			}	
		</style>	
		
		<div class="page_info">
			<p class="page_title">ADD MENTOR</p>
		</div>
	<% MentorBean mentor =(MentorBean)request.getAttribute("MentorbeanList"); 
			
			
			
			%>
		<div style="font-family: 'Oswald', sans-serif; font-size: 15px; background-color: #EBEBEB; margin: 0px 3px 0px 3px; padding-top: 1px;">
		<div id="blank_popup" style="height: 600px; width: 100%; display: none; position: absolute; top: 0px; left: 0px; opacity: 0.1; background-color: #fff;"></div>			
		<div id="alert_popup" class="alert_popup" style="padding: 7px 10px 5px 40px; border: 1px solid #DCDCDC;">	
			<div style="margin: 10px 0px 20px 10px;">
				RD Portal Says
			</div>
			<div id="message_info" style="font-family: Oswald"></div>
			<span class="ok_button" style="background-color:#5CB85C ; color: #FFF" onClick="closeAlertPopup()">OK</span>		
			</div>		
		<div>
			<div>	
				<table width="100%">
					<tr>
						<td align="right" style="padding: 0px 10px 0px 0px;">
							<a class="savebutton" style="background-color:#5CB85C; color: #FFF; text-decoration: none;" href="MentorMenuServlet?actionview=Edit&id=<%=mentor.getEmail()%>&status=<%=mentor.getStatus()%>">Edit</a>
							<span onClick="gotoMentorInfo()" class="backbutton">BACK</span>
						</td>
					</tr>
				</table>						
			</div>			
			<div class="mentor_info_title">MENTOR INFO</div>
			<div class="mentor_info_form" style="height: 100%; padding: 20px 0px 20px 0px;">
			
				<form id="mentor_info_form" name="mentor_info_form"> 								
					<table width="38%" style="margin-left: 0%;">
						<tr>
							<td class="form_lable">Name:</td>
							<td class="form_value" style="text-transform: uppercase;"><%=mentor.getName()%></td>								
						</tr>
						<tr>
							<td class="form_lable">Email:</td>
							<td class="form_value" id="mentor_email"><%=mentor.getEmail() %></td>
						</tr>
						<tr>
							<td class="form_lable">Mentorship Start Date:</td>
							<td class="form_value">
							
							
							
							<%SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
							String mysqlmentorstartdate=sdf.format(mentor.getMentorStartDate());
							
							%>
							<%=mysqlmentorstartdate %>	
							
					


</td>
						</tr>
						<tr>
							<td class="form_lable">Mentorship End Date: </td>
							<td class="form_value">
							<%
							String mysqlmentorenddate=sdf.format(mentor.getMentorEndDate());
							%>
							<%=mysqlmentorenddate %>	
							
							
							
							</td>
						</tr>
						<tr>
							<td class="form_lable">Max No.of Mentees:</td>
							<td class="form_value"><%=mentor.getMaxNoOfMentees() %></td>
						</tr>
						<tr>
							<td class="form_lable">Technology Stream: </td>
							<td class="form_value"><%=mentor.getTechnologyStream() %>
								
							</td>
						</tr>
						<tr>
							<td class="form_lable">Status:</td>
						
							<td class="form_value" style="text-transform: capitalize;"><%=mentor.getStatus() %></td>	
							
				
						</tr>
					</table>
				</form>
			</div>				
			</div>							
		</div>

<%@ include file="/common/footer.jspf"%>