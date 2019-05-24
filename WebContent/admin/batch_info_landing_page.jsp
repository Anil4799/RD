<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/common/header.jspf" %> 
<script type="text/javascript" src="/admin-portal/js/date.js"></script>



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
			    width: 200px;
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
   		
   if(startDate==""){msg+="Start Date ";}
   	
   	
   if(endDate==""){
   	msg+="End Date";
   }
   if(startDate=="" && endDate==""){
   	msg="Start Date and End Date";
   	
   }
   
   endMsg=" need to be entered";
   
   var SDate=new Date(startDate);
   var EDate=new Date(endDate);
   
   
  if(EDate<SDate){
	   endMsg="";
	   msg="Incorrect date range";
  }
   
   if(msg.length>0){
   	document.getElementById("alertWhenDateSearch").style.color="red";
   	document.getElementById("batchLandingTable").style.display="none";
   	document.getElementById("alertWhenDateSearch").style.display="block";
   	document.getElementById("alertWhenDateSearch").innerHTML=msg+endMsg;
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
								<input class="border-right-0 form-control form-control-sm" placeholder="Start Date" id="startDate" name="startDate"/>
		 
						 </td>
						 <td>		 	
		 						<input class="border-right-0 form-control form-control-sm" placeholder="End Date" id="endDate" name="endDate"/>
		  						
		  		 
						</td>
						 <td>
			 
  								<button type="button" class="fa fa-search searchIcon searchBox"  style="color:#bebebe"  onclick="validateStartEndDate()"></button>
		
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
			                																						
	   				<span style="text-transform:none;padding-left:10px;color: #909497;">	
							<c:out value='${resultSize}'/> records found
						</span>
							
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
										                																						
								   										 <li><a href="/admin-portal/BatchAction?action=${action.action}&batchid=${batch.batchid}&startDate=${batch.startdate}&endDate=${batch.enddate}&status=${batch.status}" class="dropdown-item" >${action.action}</a></li>
								   									
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
										                																						
								   										 <li><a href="/admin-portal/BatchAction?action=${action.action}&batchid=${batch.batchid}&startDate=${batch.startdate}&endDate=${batch.enddate}&status=${batch.status}" class="dropdown-item" >${action.action}</a></li>
								   									
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
 
<%@ include file="/common/footer.jspf"%>
