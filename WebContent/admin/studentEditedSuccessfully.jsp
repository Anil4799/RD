 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/admin/AddStudentInfo.jsp" %> 
<c:choose>
			                 	 	<c:when test="${result ==  'success'}">
			                
	   										 <div  class="student_added_message" style="text-transform: none; padding: 7px 10px 5px 40px; height: 40px;width: 250px;border-radius: 5px 5px 5px 5px;background-color: #DFF0D8;	color: #008000;	display: block;	position: absolute;	left: 500px;top: 60px;z-index: 10;"	>
													Student Updated Successfully
											</div>
											<script>
												function gotoStudentInfo(){
													window.location = "/admin-portal/studentList";
												}
												setTimeout(gotoStudentInfo, 1000);
											</script>
	   									
	   							    </c:when>
	   							    <c:when test="${result ==  'fail'}">
			                
	   										 <div  class="student_added_message" style=" text-transform: none; padding: 7px 10px 5px 40px; height: 40px;width: 250px;border-radius: 5px 5px 5px 5px;background-color: #DFF0D8;	color: #008000;	display: block;	position: absolute;	left: 500px;top: 60px;z-index: 10;"	>
													Couldn't Update details
											</div>
											
											<script>
												function gotoStudentInfo(){
													window.location = "/admin-portal/addStudent";
												}
												setTimeout(gotoStudentInfo, 1000);
											</script>
	   									
	   							    </c:when>
	   							    <c:otherwise>
								    	
								 	</c:otherwise>
								 </c:choose>




