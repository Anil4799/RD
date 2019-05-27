<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/common/header.jspf" %>
<div class="page_info">
	<p class="page_title">Mentor Info - Landing Page</p>
</div>
<div class="container">
	<form action="adminMentorSearchServlet" method="post">
		<table class="table">
			<tr>
				<td><input type="text" class="form-control" placeholder="Mentor Name" name ="mentorname"></td>
				<td>
					<select class="form-control" name="technologystream">
					 	<option value="">Technology Stream</option>
					 	<c:forEach items="${technologies}" var ="techology">
				 			<option value="${techology}">${techology}</option>
				 	 	</c:forEach>
					</select>	
				</td>
				<td>
					<button type=submit class="fa fa-search searchIcon searchBox"  style="color:#bebebe" aria-hidden="true"></button>
				</td>
				<td>
					<div class="button">
						<a href="addMentor" class="btn btn-success"> ADD NEW MENTOR</a>
					</div>
				</td> 
			</tr>
		</table>
	</form>
	<c:if test="${result eq false}">
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
            
		            <button type="button" style="color:grey" class="btn btn-light fa fa-cog dropdown-toggle xyz" data-toggle="dropdown" >  </button>   
		          
		                 <ul class="dropdown-menu ddmf" role="menu">
		                 	<c:forEach items="${actions}" var="action" >
		                 	 <c:set var = "actionStatus" value = "${fn:toLowerCase(mentor.mentorStatus)}" />
			                 	 <c:choose>
			                 	 	<c:when test="${actionStatus ==  action.statusName}">
			                				
	   						<li><a href="MentorMenuServlet?actionview=${action.action}&id=${mentor.emailid}&status=${mentor.mentorStatus}" class="dropdown-item" >${action.action}</a></li>				
	   									
	   							    </c:when>
	   							    <c:otherwise>
								 	</c:otherwise>
								 </c:choose>
	    						
							</c:forEach>

					              				               					             
					            </ul>
					             
					            
					           
					            
					 </div></td>
					 </tr>  
  				</c:forEach>
  			</tbody>
		</table>
	</c:if>
	<c:if test="${result eq true}">
		<c:choose>
  			<c:when test="${fn:length(mentors) eq 0}">
  				<p style="text-transform: lowercase;">0 records found.</p>
  			</c:when>
  			<c:when test="${fn:length(mentors) gt 0}">
  				<p style="text-transform: lowercase;"> ${fn:length(mentors)} records found.</p>
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
						      <td>
						      	<div class="btn-group" dropdown>
						      		<button type="button" style="color:grey" class="btn btn-light fa fa-cog dropdown-toggle xyz" data-toggle="dropdown" >
									    <ul class="dropdown-menu ddmf" role="menu">
									    	<c:forEach items="${actions}" var="action" >
									            <c:set var = "actionStatus" value = "${fn:toLowerCase(mentor.mentorStatus)}" />
						                 	 	<c:choose>
							                 	 	<c:when test="${actionStatus ==  action.statusName}">
					   									<li><a class="dropdown-item" href="#">${action.action}</a></li>
					   							    </c:when>
					   							 	<c:otherwise>
												 	</c:otherwise>
												</c:choose>						    						
											</c:forEach>
										</ul>
								   </button>     
								</div>
							  </td>
							</tr>  
						  </c:forEach>
					  </tbody>
				</table>
			  </c:when>
		</c:choose>
	</c:if>
</div>

<%@ include file="/common/footer.jspf"%>
