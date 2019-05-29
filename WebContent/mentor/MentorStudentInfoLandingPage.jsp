<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<p class="page_title">Student Info - Landing Page</p>
</div>
<div class="container">
	<c:if test="${result eq false}">
		<form action="mentorStudentSearchServlet" method="post">
			<table class="table">
				<tr>
					<td><input type="text" class="form-control" placeholder="First Name" name="firstname"></td>
					<td><input type="text" class="form-control" placeholder="Last Name" name="lastname"></td>
					<td>
						<select  class="form-control" name="batchid">
							 <option value="" selected="selected" hidden="hidden">BatchId</option>
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
		<table class="table">
  			<thead>
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
						<td>
						<div class="btn-group">    
							<button type="button" style="color:grey" class="btn btn-light fa fa-cog dropdown-toggle xyz" data-toggle="dropdown" ></button>
							<ul class="dropdown-menu ddmf" role="menu">
								<c:forEach items="${actions}" var="action" >
									<c:set var = "actionStatus" value = "${fn:toLowerCase(ms.mentorStudentStatus)}" />
									<c:choose>
										<c:when test="${actionStatus == action.statusName}">
											<li><a class="dropdown-item" href="javascript:checkImplementation('${action.action}','${ms.mentorStudentEmailId}');">${action.action}</a></li>
										</c:when>
										<c:otherwise>
										</c:otherwise>
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
	<c:if test="${result eq true }">
		<form action="adminStudentSearch" method="post">
			<table class="table">
				<tr>
					<td><input type="text" class="form-control" placeholder="First Name" name="firstname" value="${firstname}"></td>
					<td><input type="text" class="form-control" placeholder="Last Name" name="lastname" value="${lastname}"></td>
					<td>
						<select  class="form-control" name="batchid">
							<c:choose>
								<c:when test="${fn:length(batchid) eq 0}">
									<option value="" selected="selected" hidden="hidden">BatchId</option>
								</c:when>
								<c:when test="${fn:length(batchid) gt 0}">
									<option value="${batchid}" selected="selected" hidden="hidden">${batchid}</option>
									<option value="">BatchId</option>
								</c:when>
							</c:choose>
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
								<td>
									<div class="btn-group">    
										<button type="button" style="color:grey" class="btn btn-light fa fa-cog dropdown-toggle xyz" data-toggle="dropdown" ></button>
										<ul class="dropdown-menu ddmf" role="menu">
											<c:forEach items="${actions}" var="action" >
												<c:set var = "actionStatus" value = "${fn:toLowerCase(ms.mentorStudentStatus)}" />
												<c:choose>
													<c:when test="${actionStatus == action.statusName}">
														<li><a class="dropdown-item" href="javascript:checkImplementation('${action.action}','${ms.mentorStudentEmailId}');">${action.action}</a></li>
													</c:when>
													<c:otherwise>
													</c:otherwise>
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
