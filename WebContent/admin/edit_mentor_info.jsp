
     <%@ include file="/common/header.jspf" %>  
     
     
     <%@page import="com.epam.dao.admin.MentorBean"%> 
     <%@page import="java.text.*" %>
		<style type="text/css">
			.mentor_info_form td{
				border: 0px;
			}
			.button, select {
			    text-transform: none;
			    width: 30px;
			    height: 31px;			    
			}
			.btn {
			    display: inline-block;
			    font-weight: 400;
			    color: #A9A9A9;
			    text-align: center;
			    vertical-align: middle;
			    -webkit-user-select: none;
			    -moz-user-select: none;
			    -ms-user-select: none;
			    user-select: none;
			    background-color: transparent;
			    border: 1px solid transparent;
			    padding: 0px;
			    font-size: 1rem;
			    line-height: 1.5;
			    border-radius: .25rem;
			        border-top-left-radius: 0.25rem;
			        border-bottom-left-radius: 0.25rem;
			    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
			}	
			table td, .table th {
			    padding: 0px;			    
			    border-top: 1px solid #dee2e6;
			    font-weight: normal;
			}	
			.gj-datepicker-bootstrap [role=right-icon] button {
			    width: 38px;
			    position: relative;
			    border: 0px;
			}
			.border-right-0 {
			    border: 0px;
			}
			.start_date, .end_date{
				border: 1px solid #ced4da;
				border-radius: 4px 2px 2px 4px;
			}	
		</style>	
		
		<div class="page_info">
		<p class="page_title">EDIT MENTOR DETAILS</p>
	</div>
	
		<div style="font-family: 'Oswald', sans-serif; font-size: 15px; background-color: #EBEBEB; margin: 0px 3px 0px 3px; padding-top: 1px;">
		<div id="blank_popup" class="blank_popup"></div>			
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
						<td align="right" style="padding: 0px 10px 0px 0px;">
							<span class="savebutton" style="background-color:#5CB85C ; color: #FFF" onClick="validateEditForm()">SAVE</span>
							<span onClick="gotoMentorInfo()" class="backbutton">BACK</span>
						</td>
					</tr>
				</table>						
			</div>			
			<div class="mentor_info_title">MENTOR INFO</div>
			<div class="mentor_info_form" style="height: 100%; padding: 20px 30px 20px 30px;">
			<% MentorBean mentor =(MentorBean)request.getAttribute("MentorbeanList3"); %>
				<form id="mentor_info_form" name="mentor_info_form">
					<table width="38%" style="margin-left: 0%;">
						<tr>
							<td class="form_lable">Name:<span class="required">*</span></td>
							<td><input type="text" id="mentor_name" name="mentor_name" class="form-control form-control-sm" size="30" required value=<%=mentor.getName()%> /></td>								
						</tr>
						<tr>
							<td class="form_lable">Email:<span class="required">*</span> </td>
							<td><input type="text"  id="mentor_email" name="mentor_email" class="form-control form-control-sm" size="30" required value=<%=mentor.getEmail() %> readonly/></td>
						</tr>
						<tr>
							<td class="form_lable">Mentorship Start Date:<span class="required">*</span></td>
							<%SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
							String mysqlmentorstartdate=sdf.format(mentor.getMentorStartDate());
							
							%>
								
							<td><div class="start_date"><input class="border-right-0 form-control form-control-sm" id="mentorship_start_date" name="mentorship_start_date" value=<%=mysqlmentorstartdate %>></div></td>
						</tr>
						<tr>
							<td class="form_lable">Mentorship End Date: </td>
							<%
							String mysqlmentorenddate=sdf.format(mentor.getMentorEndDate());
							%>
							<td><div class="end_date"><input class="border-right-0 form-control form-control-sm" id="mentorship_end_date" name="mentorship_end_date"  value=<%=mysqlmentorenddate %>></div></td>
						</tr>
						<tr>
							<td class="form_lable">Max No.of Mentees:<span class="required">*</span></td>
							<td><input type="text" id="max_no_of_mentees" name="max_noof_mentees" class="form-control form-control-sm" size="30" required value=<%=mentor.getMaxNoOfMentees() %>></td>
						</tr>
						<tr>
							<td class="form_lable">Technology Stream: </td>
							<td>
								<select name="mentor_technology" class="form-control form-control-sm" >
								
								<option selected="selected" hidden><%=mentor.getTechnologyStream() %> </option>
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
									<option style="font-family: Oswald" value="active">ACTIVE</option>
									<option style="font-family: Oswald"  value="inactive">INACTIVE</option>
									<option style="font-family: Oswald" value="onhold">ONHOLD</option>
								</select>
							</td>
						</tr>
					</table>
				</form>
				<script>     
			        $('#mentorship_start_date').datepicker({			
			            uiLibrary: 'bootstrap4',			
			            iconsLibrary: 'fontawesome',			
						format: 'mm-dd-yyyy', 			
			        });
			
			        $('#mentorship_end_date').datepicker({			
			            uiLibrary: 'bootstrap4',			
			            iconsLibrary: 'fontawesome',			
						format: 'mm-dd-yyyy',    			
			        });     
			
					$("#mentorship_start_date").change(function(){

				    	if($(this).val().length >0){
							$("#mentorship_start_date").removeClass("txtbrcolr");							
							$('.start_date').css('border-color','#ced4da');
						} 
					});   
    			</script>
			</div>				
			</div>							
		</div>

<%@ include file="/common/footer.jspf"%>