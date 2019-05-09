<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="/common/header.jspf" %>
  
    <div class="page_info">
		<p class="page_title">Mentor Info - Landing Page</p>
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
      <th scope="col">NAME</th>
      <th scope="col">TECHNOLOGY STREAM</th>
      <th scope="col">STATUS</th>
      <th scope="col">ACTION</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${mentors}" var="eee" >
  
   <tr>
      <th scope="row">${eee.mentor_name}</th>
      <td>${eee.technology_stream}</td>
      <td>${eee.status}</td>
    </tr>
         
  </c:forEach>
  </tbody>
</table>

 </div>

<%@ include file="/common/footer.jspf"%>
