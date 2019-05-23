<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

  <%@ include file="/common/header.jspf" %>
  
  <script type="text/javascript">
	function checkImplementation(action,emailId)
	{
		if(action =='View')
		{
			document.location.href = 'MentorStudentActionServlet?actionView='+action+'&email_id='+emailId+'';
		}
		else
		{
			openAlertPopup();
		}
	}
</script>
  
    <div class="page_info">
		<p class="page_title">Student Info-Landing Page</p>
	</div>
    
    <div class="container">
   
		<table class="table">
		<tr>
		<td><input type="text" class="form-control" placeholder="First Name"></td>
		<td><input type="text"  class="form-control" placeholder="Last Name"></td>
		<td>
			<select required class="form-control">
			  <option value="" disabled selected>BatchID</option>
			</select>
			
		</td>
		<td>
		<i class="fa fa-search" style="color:lightgrey" aria-hidden="true"></i>
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
 <c:forEach items="${students}" var="ms" >
  
   <tr>
      <th scope="row">${ms.mentorStudentName}</th>
      <td>${ms.mentorStudentBatch}</td>
      <td>${ms.mentorStudentCoreSkill}</td>
      <td>${ms.mentorStudentStatus}</td>
      <td><div class="btn-group" >
            
		            <button type="button" style="color:grey" class="btn btn-light fa fa-cog dropdown-toggle xyz" data-toggle="dropdown" ></button>
		          		
		                 <ul class="dropdown-menu ddmf" role="menu">
		                 
		 
		                 	
			                 	 <c:forEach items="${actions}" var="action" >
			                 	  <c:set var = "actionStatus" value = "${fn:toLowerCase(ms.mentorStudentStatus)}" />
			                 	 <c:choose>
			 	
			                 	 	<c:when test="${actionStatus == action.statusName}">
			                
	   										 <li><a href="javascript:checkImplementation('${action.action}','${ms.mentorStudentEmailId}');" class="dropdown-item" >${action.action}</a></li>
	   									
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

 </div>

<%@ include file="/common/footer.jspf"%>
