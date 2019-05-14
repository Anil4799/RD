<%@ include file="/common/header.jspf" %> 

		  <div style="font-family: 'Oswald', sans-serif; font-size: 15px; background-color: #ECF0F1; margin: 0px 3px 0px 3px;">
		  <div id="dialogoverlay"></div>
			<div id="dialogbox">
  				<div>
    				<div id="dialogboxhead"></div>
   					<div id="dialogboxbody"></div>
    				<div id="dialogboxfoot"></div>
 				</div>
			</div>
			<div id="batch_added_message" class="batch_added_message" style="padding: 7px 10px 5px 40px;">
			
			</div>
			<div class="add_batch_head">ADD BATCH</div>
			<div>
				<div>	
					<table class="getwidth">
						<tr>
							<td align="right">
								<span class="savebutton" style="background-color:#58D68D ; color: #FFF" onClick="validateForm()">SAVE</span>
								<span class="backbutton"  onClick="batchInfoLandingPgae()">BACK</span>
							</td>
						</tr>
					</table>						
				</div>			
				<div class="batch_info_title">BATCH INFO</div>
				<div class="batch_info_form">
					<form id="batch_info_form" name="batch_info_form">
						<table>
							
							<tr>
								<td class="form_lable">Start Date: <span class="required">*</span></td>
								<td><input type="date" id="batch_start_date" name="batch_start_date" class="form-control form-control-sm" size="30" required/></td>
							</tr>
							<tr>
								<td class="form_lable">End Date: </td>
								<td><input type="date" id="batch_end_date" class="form-control form-control-sm" name="batch_end_date" size="30" /></td>
							</tr>
							<tr>
								<td class="form_lable">BatchID: <span class="required">*</span></td>
								<td><input type="text" id="batch_id" name="batch_id" class="form-control form-control-sm" size="30" required readonly placeholder="AUTO-GENERATED"/></td>
							</tr>
							
							<tr>
								<td class="form_lable">Status: <span class="required">*</span></td>
								<td>
									<select name="batch_status" id="batch_status" class="form-control form-control-sm" required>
										<option selected="selected">Not Started</option>
										<option>In Progress</option>
										<option>Completed</option>
									</select>
								</td>
							</tr>
						</table>
					</form>
				</div>				
			</div>			
		</div>
		
		<%@ include file="/common/footer.jspf"%>
	