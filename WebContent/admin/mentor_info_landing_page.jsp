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
		<td><input type="text" class="form-control" placeholder="Mentor Name"></td>
		<td>
			<select required class="form-control">
			  <option value="" disabled selected>Technology Stream</option>
			</select>
			
			
		</td>
		<td>
		<i class="fa fa-search" aria-hidden="true"></i>
		</td>
		<td><div class="button">
			<button class="btn btn-success"> ADD NEW MENTOR</button>
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
  
  <c:forEach items="${mentors}" var="eee" >
  
   <tr>
      <th scope="row">${eee.mentor_name}</th>
      <td>${eee.technology_stream}</td>
      <td>${eee.status}</td>
    
        <td><div class="btn-group" dropdown>
            
		            <button type="button" class="btn btn-light fa fa-cog dropdown-toggle" data-toggle="dropdown" >
		          
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
					 </tr>  
  </c:forEach>
  </tbody>
</table>

 </div>

<%@ include file="/common/footer.jspf"%>
