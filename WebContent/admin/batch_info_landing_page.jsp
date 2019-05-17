<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/common/header.jspf" %> 
<script type="text/javascript" src="/admin-portal/js/date.js"></script>


  
    <div class="page_info">
		<p class="page_title">Batch Info - Landing Page</p>
	</div>
    
    <div class="container">

		<table class="table">
				<tr>
				<td>

				
		 <input id="startDate" width="276"  placeholder="Start Date" class=".col-sm-4.date border-right-0"/>		 
		 </td>
		 <td>
		 <input id="endDate" width="276"  placeholder="End Date" class="border-right-0"/>
		  
		  		 
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
            
		            <button type="button" class="btn btn-light fa fa-cog dropdown-toggle xyz" data-toggle="dropdown" >
		          
		                 <ul class="dropdown-menu ddmf" role="menu">
		                 
		 
		                 	
			                 	 <c:forEach items="${actions}" var="action" >
			                 	 <c:choose>
			 
			                 	 	<c:when test="${batch.status == action.status}">
			                
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
