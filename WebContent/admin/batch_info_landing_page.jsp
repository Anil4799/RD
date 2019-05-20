<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/common/header.jspf" %> 
<script type="text/javascript" src="/admin-portal/js/date.js"></script>


<head>
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
</head>


  
    <div class="page_info">
		<p class="page_title">Batch Info - Landing Page</p>
	</div>
    
    <div class="container">

		<table class="table" >
				<tr style="float:left">
				<td >
		<input id="startDate" width="276"  placeholder="Start Date" class="col-md-8 border-right-0"/>
			 	 <script type="text/javascript" src="./js/date.js"></script>
		 
		 </td>
		 <td>		 	
		 <input id="endDate" width="276"  placeholder="End Date" class="col-md-8 border-right-0 "/>
		   <script type="text/javascript" src="./js/date.js"></script>
		  		 
		</td>
			<td>
		<i class="fa fa-search" style="color:lightgrey" aria-hidden="true"></i>
		</td>
		

		<td><div class="button">
			<a href="addBatch" class="btn btn-success"> ADD NEW BATCH</a>

			</div></td> 
			
		 
			
		</tr>
		  
		
		</table>
		
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
      <td><div class="btn-group" dropdown>
            
		            <button type="button" style="color:grey" class="btn btn-light fa fa-cog dropdown-toggle xyz" data-toggle="dropdown" >
		          
		                 <ul class="dropdown-menu ddmf" role="menu">
		                 
		 
		                 	
			                 	 <c:forEach items="${actions}" var="action" >
			                 	 <c:set var = "actionStatus" value = "${fn:toLowerCase(batch.status)}" />
			                 	 <c:choose>
			  
			                 	 	<c:when test="${actionStatus == action.statusName}">
			                
	   										 <li><a class="dropdown-item" href="#">${action.action}</a></li>
	   									
	   							    </c:when>
	   							    <c:otherwise>
								    		  
								    	
								 	</c:otherwise>
								 </c:choose>
	    						
							</c:forEach>

					              				               					             
					            </ul>
					             
					            </button>     
					           
					            
					 </div></i></td>
    </tr>
         
  </c:forEach>
  </tbody>
</table>

 </div>
 
<%@ include file="/common/footer.jspf"%>
