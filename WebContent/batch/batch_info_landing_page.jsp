<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="/common/header.jspf" %>
  
    <div class="page_info">
		<p class="page_title">Batch Info - Landing Page</p>
	</div>
    
    <div class="container">
   
		<table class="table">
		<tr>
		<td><input type="text"></td>
		<td><input type="text"></td>
		<td>
			<select>
				<option>1</option>
				<option>2</option>
				<option>3</option>
			</select>
			<i class="fa fa-search" aria-hidden="true"></i>
			
		</td>
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
      <th scope="row">${batch.batch_id}</th>
      <td>${batch.start_date}</td>
      <td>${batch.end_date}</td>
      <td>${batch.status}</td>
      <td><div class="btn-group" dropdown>
            
		            <button type="button" class="fa fa-cog dropdown-toggle" data-toggle="dropdown" >
		          
		                 <ul class="dropdown-menu" role="menu">
		                 	
								
								
								<c:choose>
									  <c:when test="${batch.status == 'In Progress'}">
									    <li><a class="dropdown-item" href="#">View</a></li>
						                <li><a class="dropdown-item" href="#">Edit</a></li>
						                <li><a class="dropdown-item" href="#">Mark Complete</a></li>
									  </c:when>
									  <c:when test="${batch.status == 'Not Started'}">
									     <li><a class="dropdown-item" href="#">View</a></li>
							                <li><a class="dropdown-item" href="#">Edit</a></li>
							                <li><a class="dropdown-item" href="#">Start Progress</a></li>
									  </c:when>
									  <c:otherwise>
									    <li><a class="dropdown-item" href="#">View</a></li>
									  </c:otherwise>
									</c:choose>

					              				               					             
					            </ul>
					             
					            </button>     
					           
					            
					 </div></td>
    </tr>
         
  </c:forEach>
  </tbody>
</table>

 </div>

<%@ include file="/common/footer.jspf"%>
