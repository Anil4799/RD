<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

  <%@ include file="/common/header.jspf" %>
  
    <div class="page_info">
		<p class="page_title">Mentor Student Info - Landing Page</p>
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
  <!-- Code to change in jsp according to servlet page -->
    <tr>
      <th scope="col">NAME</th>
<<<<<<< HEAD:WebContent/admin/student_info_landing_page.jsp
      <th scope="col">TECHNOLOGY STREAM</th>
=======
      <th scope="col">BATCHID</th>
      <th scope="col">CORE SKILLS</th>
>>>>>>> origin/EPMRDINFDP-32:WebContent/admin/MentorStudentInfoLandingPage.jsp
      <th scope="col">STATUS</th>
      <th scope="col">ACTION</th>
    </tr>
  </thead>
  <tbody>
  
<<<<<<< HEAD:WebContent/admin/student_info_landing_page.jsp
<<<<<<< HEAD
=======
>>>>>>> origin/EPMRDINFDP-32:WebContent/admin/MentorStudentInfoLandingPage.jsp
 <c:forEach items="${students}" var="eee" >
  
   <tr>
      <th scope="row">${eee.name}</th>
      <td>${eee.batch}</td>
      <td>${eee.coreSkill}</td>
<<<<<<< HEAD:WebContent/admin/student_info_landing_page.jsp
      <td>${eee.mentor}</td>
      <td>Reddy</td>
      <td>Reddy</td>
      <td>${eee.status}</td>
      <td><div class="btn-group" dropdown>
            
		            <button type="button" class="fa fa-cog dropdown-toggle" data-toggle="dropdown" >
		          
		                 <ul class="dropdown-menu" role="menu">
		                 	<c:choose>
								  <c:when test="${eee.status == 'active'}">
								     <li><a class="dropdown-item" href="#">View</a></li>
					                <li><a class="dropdown-item" href="#">Edit</a></li>
					                <li><a class="dropdown-item" href="#">Deactivate</a></li>
								  </c:when>
								  <c:otherwise>
								    <li><a class="dropdown-item" href="#">View</a></li>
					                <li><a class="dropdown-item" href="#">Activate</a></li>
								  </c:otherwise>
								</c:choose>

					              				               					             
					            </ul>
					             
					            </button>     
					           
					            
					 </div></td>

=======
      <td>${eee.status}</td>
>>>>>>> origin/EPMRDINFDP-32:WebContent/admin/MentorStudentInfoLandingPage.jsp
    </tr>
  </c:forEach>
  </tbody>
</table>

 </div>

<%@ include file="/common/footer.jspf"%>
