<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/common/header.jspf" %> 
<script type="text/javascript" src="/admin-portal/js/date.js"></script>

<c:choose>
			                 	 	<c:when test="${RESULT ==  'Successfully updated'}">
			                
	   										 <div style="text-transform: none;padding: 7px 15px 10px 20px;border-radius: 5px 5px 5px 5px;background-color: #DFF0D8;color: #008000;display: block;position: absolute;left: 500px;top: 80px;z-index: 10;">	
	   										 	Batch status updated successfully
											</div>
											<script>
												function gotoBatchInfo(){
													window.location = "/admin-portal/batchInfo";
												}
												setTimeout(gotoBatchInfo, 1000);
											</script>
											
	   									
	   							    </c:when>
	   							    <c:when test="${RESULT ==  'Error in updating'}">
			                
	   										 <div style="text-transform: none;padding: 7px 15px 10px 20px;border-radius: 5px 5px 5px 5px;background-color: red;color: #008000;display: block;position: absolute;left: 500px;top: 80px;z-index: 10;">
													Error in updating status
											</div>
											<script>
												function gotoBatchInfo(){
													window.location = "/admin-portal/batchInfo";
												}
												setTimeout(gotoBatchInfo, 1000);
											</script>
											
	   							    </c:when>
	   							    
	   							  
	   							    <c:otherwise>
								    	
								 	</c:otherwise>
								 </c:choose>


<!--     <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script> -->
<!--     <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous"> -->
    
<!--     <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" /> -->
   
   <style>
   
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
			
			.sbtn {
			    display: inline-block;
			    font-weight: 400;
			    color: #A9A9A9;
			    width: 150px;
			    height: 35px;
			    text-decoration: none;
			    text-align: center;
			    vertical-align: middle;
			    -webkit-user-select: none;
			    -moz-user-select: none;
			    -ms-user-select: none;
			    user-select: none;
			    background-color: transparent;
			    border: 1px solid transparent;
			    padding: 5px;
			    font-size: 1rem;
			    line-height: 1.5;
			    border-radius: .25rem;
			        border-top-left-radius: 0.25rem;
			        border-bottom-left-radius: 0.25rem;
			    border-top-left-radius: 0.25rem;
			    border-bottom-left-radius: 0.25rem;
			    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
			}
			.sbtn-success {
			    color: #fff;
			    background-color: #28a745;
			    border-color: #28a745;
			    text-decoration: none;
			}
			a:hover{
				color: #fff;
				background-color: #228B22;
			}
   	
   </style>
   
   <script type="text/javascript">
   
   
  
   
   function validateStartEndDate()
   {
	   
	   
   	var startDate= document.getElementById("startDate").value;
   	var endDate=document.getElementById("endDate").value;
   	var msg="";
   	var endMsg="";
   	//var count=0;
   		
   	document.getElementById("alertWhenDateSearch").style.display="none";
   		
   if(startDate==""){
	  
	   msg+="From Date ";}
   	
   	
   if(endDate==""){
	   
   	msg+="To Date";
   	
   }
   if(startDate=="" && endDate==""){
   	msg="From Date and To Date";
   	
   }
   
   endMsg=" need to be entered";
   
   
  var SDate=startDate.split("-");
  var EDate=endDate.split("-");

var SDateParsed=new Date(SDate[2], SDate[0] - 1, SDate[1]);
var EDateParsed=new Date(EDate[2], EDate[0] - 1, EDate[1]);
 
   
   
 
  if(EDateParsed<SDateParsed){
	   endMsg="";
	   msg="Incorrect date range";
  }
   
   if(msg.length>0){
	   
	  
   	document.getElementById("alertWhenDateSearch").style.color="red";
    
   	document.getElementById("batchLandingTable").style.display="none";
     
   	document.getElementById("alertWhenDateSearch").style.display="block";
   
   	document.getElementById("alertWhenDateSearch").innerHTML=msg+endMsg;
   	
   	document.getElementById("recordsFound").style.display="none";
   	}
   else
   	{
   	
	   
   	var params="?startDate="+startDate+"&endDate="+endDate;
   	
  
   document.getElementById("batchDetailsSearch").action="/admin-portal/AdminBatchInfoListWithInDateRange"+params;
   document.getElementById("batchDetailsSearch").method = "post";
   document.getElementById("batchDetailsSearch").submit();
   
   
   	}


   }

</script>
   
    
  

    <div class="page_info">
		<p class="page_title">Batch Info - Landing Page</p>
	</div>
    
    <div class="container">
         <form id="batchDetailsSearch">
				<table class="table" >
					<tr style="float:left">
						<td >
							<input class="border-right-0 form-control form-control-sm" placeholder="From Date" id="startDate" name="startDate" value="${startDate}" readonly/>
						</td>
						 <td>		 	
		 					<input class="border-right-0 form-control form-control-sm" placeholder="To Date" id="endDate" name="endDate" value="${endDate}" readonly/>
						</td>
						 <td>
			 
  								<button type="button" class="fa fa-search searchIcon searchBox"  style="color:#bebebe;"  onclick="validateStartEndDate()"></button>
		
						</td>
						<td>
								<div class="button">
										<a href="addBatch" class="sbtn sbtn-success" style="text-decoration: none;"> ADD NEW BATCH</a>

								</div>
						</td> 
				  </tr>
			</table>
		</form>
		
		<div id="alertWhenDateSearch" style="text-transform:none;">
		    
		       
		</div>
		<script>
		 $('#startDate').datepicker({
			
			            uiLibrary: 'bootstrap4',
			

			            iconsLibrary: 'fontawesome',
			
						format: 'mm-dd-yyyy',        

			
			        });
			
			        $('#endDate').datepicker({
			
			            uiLibrary: 'bootstrap4',
			

			            iconsLibrary: 'fontawesome',     
			
						format: 'mm-dd-yyyy',     
			
			        }); 
			
			</script>
			
 		<c:choose>
 
			 <c:when test="${searchResult == 'a'}">
			        
	   				<span id="recordsFound" style="text-transform:none;padding-left:10px;color: #909497;">	
							
							<c:out value='${resultSize}'/> records found
							
							
						</span>
					<div id="batchLandingTable">		
					<table class="table">
							<c:choose>
						       <c:when test="${resultSize > 0}" >
						       		<thead>
								    <tr>
								      <th>BATCHID</th>
								      <th>START DATE</th>
								      <th>END DATE</th>
								      <th>STATUS</th>
								      <th>ACTION</th>
								    </tr>
								  </thead>
						       </c:when>
						       <c:otherwise>
						       
						       </c:otherwise>
						       </c:choose>
					       <tbody>
							   <c:forEach items="${batchs}" var="batch" >
							     <tr>
							      <th scope="row">${batch.batchid}</th>
							      <td>${batch.startdate}</td>
							      <td>${batch.enddate}</td>
							      <td>${batch.status}</td>
							      <td><div class="btn-group" >
							            
									            <button type="button" style="color:grey" class="btn btn-light fa fa-cog dropdown-toggle xyz" data-toggle="dropdown" > </button>     
									          
									                 <ul class="dropdown-menu ddmf" role="menu">
									                 
									 
									                 	
										                 <c:forEach items="${actions}" var="action" >
										                 	 <c:set var = "actionStatus" value = "${fn:toLowerCase(batch.status)}" />
										                 	 <c:choose>
										  
										                 	 	<c:when test="${actionStatus == action.statusName}">
										                																						
								   										 <li><a href="/admin-portal/BatchAction?action=${action.action}&batchid=${batch.batchid}&startDate=${batch.startdate}&endDate=${batch.enddate}&status=${batch.status}&serialNo=${batch.serialNo}" class="dropdown-item" >${action.action}</a></li>
								   									
								   							    </c:when>
								   							    <c:otherwise>
															    		  
															    	
															 	</c:otherwise>
															 </c:choose>
								    						
														</c:forEach>
							
												              				               					             
												      </ul>
										    </div>
								      </td>
							        </tr>
							         
							      </c:forEach>
							  </tbody>
					</table>
						</div>						
	   		</c:when>
	   		
	   		
	   	<c:otherwise>
							
							
		<div id="batchLandingTable">	
					
					<table class="table">
			  			<thead>
						    <tr>
						      <th scope="col">BATCHID</th>
						      <th scope="col">START DATE</th>
						      <th scope="col">END DATE</th>
						      <th scope="col">STATUS</th>
						      <th scope="col">ACTION</th>
						    </tr>
			  			</thead>

			  			<tbody>					
			  				<c:forEach items="${batchs}" var="batch" >			  
					   			<tr>
							      <th scope="row">${batch.batchid}</th>
							      <td>${batch.startdate}</td>
							      <td>${batch.enddate}</td>
							      <td>${batch.status}</td>
							      <td>
						      		<div class="btn-group" >
						            
					            	<button type="button" style="color:grey" class="btn btn-light fa fa-cog dropdown-toggle xyz" data-toggle="dropdown" > </button>     
					          
					                 <ul class="dropdown-menu ddmf" role="menu">
					 
					                 	 <c:forEach items="${actions}" var="action" >
					                 		 <c:set var = "actionStatus" value = "${fn:toLowerCase(batch.status)}" />
					                 		 <c:choose>
					  
				                 	 			<c:when test="${actionStatus == action.statusName}">
		   											 <c:choose>
							                 	 			<c:when test="${action.action == 'Start Progress'}">
							                 	 											
					   										 <li><a href="#" data-toggle="modal" data-action="${action.action}" data-id="${batch.batchid}"  data-target="#commentModal" class="batchdetail dropdown-item" >${action.action}</a></li>
					   										 
					   							   			 </c:when>
					   							   			 <c:when test="${action.action == 'Mark Complete'}">
					   							   			 	<li><a href="#" data-toggle="modal" data-action="${action.action}" data-id="${batch.batchid}"  data-target="#commentModal" class="batchdetail dropdown-item" >${action.action}</a></li>
					   							   			 </c:when>
					   							   			 <c:otherwise>
								   									<li><a href="/admin-portal/BatchAction?action=${action.action}&batchid=${batch.batchid}&startDate=${batch.startdate}&endDate=${batch.enddate}&status=${batch.status}&serialNo=${batch.serialNo}" class="dropdown-item" >${action.action}</a></li>
												 			 </c:otherwise>
												    </c:choose>
		   											
		   							   			 </c:when>
		   							   			 <c:otherwise>									    		  
									    	
									 			 </c:otherwise>
										    </c:choose>				    						
										</c:forEach>											              				               					            
								       </ul>
								   	 </div>
						    	</td>
					   			 </tr>
							         
		  						</c:forEach>
						  	</tbody>
					</table>				
			</div>	
								    		  
								    	
	    </c:otherwise>
		</c:choose>


 </div>
 


 <script type="text/javascript">
 $('.batchdetail').click(function () { 
	 if (typeof $(this).data('id') !== 'undefined') {
	      data_id = $(this).data('id');
	    }
	 if (typeof $(this).data('action') !== 'undefined') {
	      action = $(this).data('action');
	    }
	if((action)=='Mark Complete'){
		$('#commentModalLabel').text('COMPLETE BATCH');
	} else {
		$('#commentModalLabel').text('START BATCH');
	}
	$('#batchNo').val(data_id);
	$('#action').val(action);
	
	});
</script>
 
 
 
 <!-- Modal -->
<div class="modal fade" id="commentModal" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog"  aria-labelledby="commentModalLabel" aria-hidden="true">

  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header header-style">
        <h5 class="modal-title" id="commentModalLabel"></h5>
        
      </div>
      <form id="batch_comment_form">
      <div class="modal-body">
        
        <div>
        	<span class="label-comment">Comments: </span>
        	<div class="text-style">
        	 <input type="text" name="comment" class="form-control"  aria-describedby="inputGroup-sizing-sm">
        	 <input type="hidden" id="batchNo" name="batchId" value="">
        	  <input type="hidden" id="action" name="action" value="">
        </div>
        </div>
       
       
        
      </div>
       <div class="modal-footer footer-style">
       <span class="backbutton" data-dismiss="modal" >BACK</span>
       <span class="savebutton" style="background-color:#5CB85C ; color: #FFF;" onClick="commentSubmitForm()">SAVE</span>
      </div>
       </form>
    </div>
  </div>
</div>
 
<%@ include file="/common/footer.jspf"%>
