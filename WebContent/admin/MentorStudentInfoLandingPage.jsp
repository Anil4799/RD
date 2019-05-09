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
      <th scope="col">BATCHID</th>
      <th scope="col">CORE SKILLS</th>
      <th scope="col">STATUS</th>
      <th scope="col">ACTION</th>
    </tr>
  </thead>
  <tbody>
  
 <c:forEach items="${students}" var="eee" >
  
   <tr>
      <th scope="row">${eee.name}</th>
      <td>${eee.batch}</td>
      <td>${eee.coreSkill}</td>
      <td>${eee.status}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>

 </div>

<%@ include file="/common/footer.jspf"%>