<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/common/header.jspf" %>
<div class="page_info">
		<p class="page_title">Student Info - Landing Page</p>
</div>
<div class="container">
	<form action="adminStudentSearch" method="post">
		<table class="table">
			<tr>
				<td><input type="text" class="form-control" placeholder="First Name" name="firstname"></td>
				<td><input type="text" class="form-control" placeholder="Last Name" name="lastname"></td>
				<td>
					<select  class="form-control" name="batchid">
						<option value="">BatchId</option>
						 <c:forEach items="${batchIDs}" var ="batch_id">
					 		<option value="${batch_id}">${batch_id}</option>
					 	 </c:forEach>
					</select>
				</td>
				<td>
					<button type=submit class="fa fa-search searchIcon searchBox"  style="color:#bebebe" aria-hidden="true"></button>
				</td>
				<td>
					<div class="button">		
						<a href="addStudent" class="btn btn-success"> ADD NEW STUDENT</a>
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
				      <th scope="col">BATCHID</th>
				      <th scope="col">CORE SKILLS</th>
				      <th scope="col">MENTOR</th>
				      <th scope="col">STATUS</th>
				      <th scope="col">ACTION</th>
		    		</tr>
		  		</thead>
		  		<tbody>
			  	 	<c:forEach items="${students}" var="student" >
			     		<tr>
					      <th scope="row">${student.studentName}</th>
					      <td>${student.studentBatch}</td>
					      <td>${student.studentCoreSkill}</td>
					      <td>${student.studentMentor}</td>
					      <td>${student.studentStatus}</td>
					      <td>
					      		<div class="btn-group dropdown">     
					        		<button type="button" style="color:grey" class="btn btn-light fa fa-cog dropdown-toggle xyz" data-toggle="dropdown" > </button> 
						                 <ul class="dropdown-menu ddmf" role="menu">
						                 	 <c:forEach items="${actions}" var="action" >
						                 	 	<c:set var = "actionStatus" value = "${fn:toLowerCase(student.studentStatus)}" />
							                 	 	<c:choose>
							                 	 		<c:when test="${actionStatus ==  action.statusName}">
							             				 	<li><a class="dropdown-item" href="AdminStudentActionServlet?actionView=${action.action}&email_id=${student.studentEmailId}">${action.action}</a></li>   									
					   							    	</c:when>
												 	</c:choose> 	
											</c:forEach>
										</ul>
								       				
								 </div>
							</td>
			    		</tr>
			  		</c:forEach>
		  		</tbody>
			</table>
		</c:if>
		<c:if test="${result eq true}">
		 	<c:choose>
			  <c:when test="${fn:length(students) eq 0}">
			  	<p style="text-transform: lowercase;">0 records found.</p>
			  </c:when>
			  <c:when test="${fn:length(students) gt 0}">
			  	<p style="text-transform: lowercase;"> ${fn:length(students)} records found.</p>
			  	<table class="table">
			  		<thead>
			    		<tr>
					      <th scope="col">NAME</th>
					      <th scope="col">BATCHID</th>
					      <th scope="col">CORE SKILLS</th>
					      <th scope="col">MENTOR</th>
					      <th scope="col">STATUS</th>
					      <th scope="col">ACTION</th>
			    		</tr>
			  		</thead>
			  		<tbody>
				  	 	<c:forEach items="${students}" var="student" >
				     		<tr>
						      <th scope="row">${student.studentName}</th>
						      <td>${student.studentBatch}</td>
						      <td>${student.studentCoreSkill}</td>
						      <td>${student.studentMentor}</td>
						      <td>${student.studentStatus}</td>
						      <td>
						      		<div class="btn-group dropdown">     
						        		<button type="button" style="color:grey" class="btn btn-light fa fa-cog dropdown-toggle xyz" data-toggle="dropdown" ></button>
							                 <ul class="dropdown-menu ddmf" role="menu">
							                 	 <c:forEach items="${actions}" var="action" >
							                 	 	<c:set var = "actionStatus" value = "${fn:toLowerCase(student.studentStatus)}" />
								                 	 	<c:choose>
								                 	 		<c:when test="${actionStatus ==  action.statusName}">
								             				 	<li><a class="dropdown-item" href="AdminStudentActionServlet?actionView=${action.action}&email_id=${student.studentEmailId}">${action.action}</a></li>   									
						   							    	</c:when>
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
			</c:choose>
		</c:if>

 </div>

<%@ include file="/common/footer.jspf"%>
