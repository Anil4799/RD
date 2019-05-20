<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="/common/header.jspf" %>
  
    <div class="page_info">
		<p class="page_title">Mentor Info - Landing Page</p>
	</div>
    
    <div class="container">
   
		<table class="table">
		<tr>
		<td><input type="text" class="form-control" placeholder="Mentor Name"></td>
		<td>
			<select required class="form-control">
			  <option value="" disabled selected>Technology Stream</option>
			</select>
			
			
		</td>
		<td>
		<i class="fa fa-search" style="color:lightgrey" aria-hidden="true"></i>
		</td>
		<td><div class="button">
			<a href="addMentor" class="btn btn-success"> ADD NEW MENTOR</a>
			</div></td> 
		</tr>
		</table>
		
		<table class="table">
  <thead>
    <tr>
      <th scope="col">NAME</th>
      <th scope="col">TECHNOLOGY STREAM</th>
      <th scope="col">STATUS</th>
      <th scope="col">ACTION</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${mentors}" var="mentor" >
  
   <tr>
      <th scope="row">${mentor.mentorname}</th>
      <td>${mentor.technologystream}</td>
      <td>${mentor.mentorStatus}</td>
    
        <td><div class="btn-group" dropdown>
            
		            <button type="button" style="color:grey" class="btn btn-light fa fa-cog dropdown-toggle xyz" data-toggle="dropdown" >
		          
		                 <ul class="dropdown-menu ddmf" role="menu">
		                 	<c:forEach items="${actions}" var="action" >
		                 	 <c:set var = "actionStatus" value = "${fn:toLowerCase(action.statusName)}" />
			                 	 <c:choose>
			                 	 	<c:when test="${mentor.mentorStatus ==  actionStatus}">
			                
	   										 <li><a class="dropdown-item" href="#">${action.action}</a></li>
	   									
	   							    </c:when>
	   							    <c:otherwise>
								    	
								 	</c:otherwise>
								 </c:choose>
	    						
							</c:forEach>

					              				               					             
					            </ul>
					             
					            </button>     
					           
					            
					 </div></td>
					 </tr>  
  </c:forEach>
  </tbody>
</table>

 </div>

<%@ include file="/common/footer.jspf"%>
