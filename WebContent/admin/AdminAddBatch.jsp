<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/common/header.jspf" %> 


		<style type="text/css">
			.batch_info_form td{
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
			.input-group {
			    position: relative;
			    display: -ms-flexbox;
			    display: flex;
			    -ms-flex-wrap: wrap;
			    flex-wrap: wrap;
			    -ms-flex-align: stretch;
			    align-items: stretch;
			    width: 100%;
			    border: 0px;			    
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
		<p class="page_title">ADD BATCH</p>
	</div>

		  <div style="font-family: 'Oswald', sans-serif; text-transform : none; font-size: 15px; background-color: #ECF0F1; margin: 0px 3px 0px 3px;">
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
			
			<div style="background-color: #EBEBEB">
				<div>	
					<table class="getwidth" style="">
						<tr>
							<td align="right">
								<span class="savebutton" style="background-color:#5CB85C ; font-size=14px; color: #FFF" onClick="batchValidateForm()">SAVE</span>
								<span class="backbutton" style="font-size=14px;" onClick="batchInfoLandingPgae()">BACK</span>
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
								<td><div class="start_date">
								<input class="border-right-0 form-control form-control-sm" id="batch_start_date" name="batch_start_date"/>
								<input type="hidden" id="testBatchStartDate" value='<c:out value="${requestScope.startDate}"></c:out>'/>
								</div></td>							
							</tr>
							<tr>
								<td class="form_lable">End Date: </td>
								<td><div class="end_date"><input class="border-right-0 form-control form-control-sm" id="batch_end_date" name="batch_end_date"/></div>
								</td>
							</tr>  
														<tr>
								<td class="form_lable">BatchId: <span class="required">*</span></td>
								<td><input type="text" id="batch_id" name="batch_id" class="form-control form-control-sm" size="30" required readonly placeholder="AUTO-GENERATED"/></td>
							</tr>
							
							<tr>
								<td class="form_lable">Status: <span class="required">*</span></td>
								<td>
									<select name="batch_status" id="batch_status" class="form-control form-control-sm" required>
											
										<option selected="selected" >Not Started</option>
										<option value="in progress">In progress</option>

										<option value="completed">Completed</option>
									</select>
								</td>
							</tr>
						</table>
						<input type="hidden" id="insertUpdateCode" name="BatchInsertUpdate" value="-1">
					</form>
				</div>							
			</div>			
		</div>
		<script>
		 $('#batch_start_date').datepicker({
			
			id: 'start_date',
            uiLibrary: 'bootstrap4',

            iconsLibrary: 'fontawesome',

			format: 'mm-dd-yyyy',
			change: function (e) {
				generatorID();
	             // alert("hi");
	           }
			      });
		
		
		
		
        $('#batch_end_date').datepicker({
	
			id: 'end_date',

            uiLibrary: 'bootstrap4',

            iconsLibrary: 'fontawesome',     

			format: 'mm-dd-yyyy', 
			    

        }); 

$("#batch_start_date").change(function(){
	    	if($(this).val().length >0){
				$("#batch_start_date").removeClass("txtbrcolr");							
				$('.start_date').css('border-color','#ced4da');
			}   
		}); 

		
		</script>
		
		<%@ include file="/common/footer.jspf"%>
	