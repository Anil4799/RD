 <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
 <%@ include file="/common/header.jspf" %>
		<style type="text/css">
			.batch_info_form td{
				border: 0px;
			}
		</style>
		<div class="page_info">
		<p class="page_title">VIEW BATCH DETAILS</p>
	</div>
	<div style="font-family: 'Oswald', sans-serif; text-transform : none; font-size: 15px; background-color: #ECF0F1; margin: 0px 3px 0px 3px;">
	<div>
				<div>	
					<table class="getwidth">
						<tr>
							<td align="right">
							
							<c:set var = "actionValue" value = "${requestScope.status}" />
							<c:set var="caseActionValue" value="${fn:toLowerCase(actionValue)}" />
							<c:set var = "actionStatus" value = "completed" />
							
							<c:choose>
						
							
							
							<c:when test = "${caseActionValue == actionStatus}">
							
			                	<span class="savebutton"  style=" display:none; background-color:#5CB85C ; font-size=14px; color: #FFF" onClick="editBatchForm()">EDIT</span>																					
	   							</c:when>
	   						    <c:otherwise>
								<span class="savebutton"  style=" background-color:#5CB85C ; font-size=14px; color: #FFF" onClick="editBatchForm()">EDIT</span>    		  	
									 	</c:otherwise>
								 </c:choose>
							
							
							<!-- 	<span class="editbutton"  style=" background-color:#5CB85C ; font-size=14px; color: #FFF" onClick="editBatchForm()">EDIT</span>-->
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
							  	<td class="form_lable">Start Date:</td>
								<td><span class="view_batch_start_date" id="view_batch_start_date"><c:out value="${requestScope.startDate}"/></span></td>
								</tr>
							<tr>
								<td class="form_lable">End Date: </td>
								
								<td><span class="view_batch_end_date" id="view_batch_end_date"><c:out value="${requestScope.endDate}"/></span></td>
							</tr>  
							<tr>
								<td class="form_lable">BatchId:</td>
								<td><span class="view_batch_id" id="view_batch_id"><c:out value="${requestScope.batchId}"/></span></td>
							</tr>
							
							<tr>
								<td class="form_lable">Status:</td>
								<td><span class="view_batch_status" id="view_batch_status"><c:out value="${requestScope.status}"/></span>								</td>
							</tr>
						</table>
					</form>
				</div>				
			</div>			
	
	</div>
	
	<%@ include file="/common/footer.jspf"%>