function studentValidateForm() {
    var message = "";
    var first_name=document.forms["add_student_info"]["firstName"].value;
    var last_name=document.forms["add_student_info"]["lastName"].value;
    var email = document.forms["add_student_info"]["email"].value;
    var gender = $("#gender").val();
    var date_of_birth=document.forms["add_student_info"]["dateOfBirth"].value;
    var personalLocation =document.forms["add_student_info"]["personalLocation"].value; 
    
    var batch_id = $("#batchId").val();
    var employee_type = $("#employeeType").val();
    var core_skill = $("#coreSkill").val();
    var relocation = $("#relocation").val();
    var status = $("#status").val();
    var date_of_joining=document.forms["add_student_info"]["dateOfJoining"].value;
    
    if(first_name == null || first_name == ""){
        message += "First Name cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["firstName"].classList.add("txtbrcolr");
    }
   
    if(last_name == null || last_name == ""){
        message += "Last Name cannot be empty<br/>" + "\n";
        $("#lastName").addClass("txtbrcolr");
    }
    
    
    if(email == null || email == "")
    {
        message += "Email cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["email"].classList.add("txtbrcolr");
    }
    if(date_of_birth == null || date_of_birth == ""){
        message += "Date of Birth cannot be empty<br/>" + "\n";
        $("#dateOfBirth").addClass('txtbrcolr');
    }   else{
        $("#dateOfBirth").removeClass('txtbrcolr');
    }
    
    if(gender == null || gender == "no_value" || gender =="NULL")
    {
        message += "Gender cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["gender"].classList.add("txtbrcolr");
    }
   
    
    if(personalLocation == null || personalLocation == "")
   {
       message += "Loaction cannot be empty<br/>" + "\n";
       document.forms["add_student_info"]["personalLocation"].classList.add("txtbrcolr");
    }
  
    
    if(batch_id == null || batch_id == "no_value" || batch_id =="NULL")
    {
        message += "BatchId cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["batchId"].classList.add("txtbrcolr");
    }
   
    if(employee_type == null || employee_type == "no_value" || employee_type =="NULL")
    {
        message += "Employee Type cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["employeeType"].classList.add("txtbrcolr");
    }
    
    if(core_skill == null || core_skill == "no_value" || core_skill =="NULL")
    {
        message += "Core Skill cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["coreSkill"].classList.add("txtbrcolr");
    }
    
    if(relocation == null || relocation == "no_value" || relocation =="NULL")
    {
        message += "Relocation cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["relocation"].classList.add("txtbrcolr");
    }
     if(status == null || status == "no_value" || status =="NULL")
    {
        message += "Status cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["status"].classList.add("txtbrcolr");
    }
    
    if(date_of_joining == null || date_of_joining == ""){
        message += "Date of Joining cannot be empty<br/>" + "\n";
        $("#dateOfJoining").addClass('txtbrcolr');
    }
    else{
        $("#dateOfJoining").removeClass('txtbrcolr');
    }
    if(message.length > 0 ){    
    	document.getElementById("blank_popup").style.display = "block";
        document.getElementById("message_info").innerHTML = message;
        document.getElementById("alert_popup").style.display = "block";
        var elements = add_student_info.elements;
		for (var i = 0, len = elements.length; i < len; ++i) {
			elements[i].disabled = true;
		}
    } else{
    	document.getElementById("add_student_info").action="/admin-portal/StudentServlet";
	    document.getElementById("add_student_info").method = "POST";
	    document.getElementById("add_student_info").submit();
    }   
   
}
function closeAlertPopup(){
    document.getElementById("alert_popup").style.display = "none";
    document.getElementById("blank_popup").style.display = "none";
    var elements = add_student_info.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].disabled = false;
	}
}
function gotoStudentLandingPage(){   
	document.location.href = 'studentList';	
}

function gotoStudentEditPage(emailId){   
	document.location.href = 'AdminStudentActionServlet?actionView=Edit&email_id='+emailId;	
}

function gotoMentorStudentLandingPage(){   
	document.location.href = 'mentorstudentList';	
}


function setLocation()
{
 var collegeNameLocation = document.add_student_info.collegeName.value;
 var location = collegeNameLocation.substring(collegeNameLocation.indexOf("$") + 1);
 document.add_student_info.collegeLocation.value = location;
 
}

function openAlertPopup()
{
	alert("Not yet Implemented");
}


function studentUpadte(){
	 var message = "";
	    var first_name=document.forms["add_student_info"]["firstName"].value;
	    var last_name=document.forms["add_student_info"]["lastName"].value;
	    var email = document.forms["add_student_info"]["email"].value;
	    var gender = $("#gender").val();
	    var date_of_birth=document.forms["add_student_info"]["dateOfBirth"].value;
	    var personalLocation =document.forms["add_student_info"]["personalLocation"].value; 
	    
	    var batch_id = $("#batchId").val();
	    var employee_type = $("#employeeType").val();
	    var core_skill = $("#coreSkill").val();
	    var relocation = $("#relocation").val();
	    var status = $("#status").val();
	    var date_of_joining=document.forms["add_student_info"]["dateOfJoining"].value;
	    
	    if(first_name == null || first_name == ""){
	        message += "First Name cannot be empty<br/>" + "\n";
	        document.forms["add_student_info"]["firstName"].classList.add("txtbrcolr");
	    }
	   
	    if(last_name == null || last_name == ""){
	        message += "Last Name cannot be empty<br/>" + "\n";
	        $("#lastName").addClass("txtbrcolr");
	    }
	    
	    
	    if(email == null || email == "")
	    {
	        message += "Email cannot be empty<br/>" + "\n";
	        document.forms["add_student_info"]["email"].classList.add("txtbrcolr");
	    }
	    if(date_of_birth == null || date_of_birth == ""){
	        message += "Date of Birth cannot be empty<br/>" + "\n";
	        $("#dateOfBirth").addClass('txtbrcolr');
	    }   else{
	        $("#dateOfBirth").removeClass('txtbrcolr');
	    }
	    
	    if(gender == null || gender == "no_value" || gender =="NULL")
	    {
	        message += "Gender cannot be empty<br/>" + "\n";
	        document.forms["add_student_info"]["gender"].classList.add("txtbrcolr");
	    }
	   
	    
	    if(personalLocation == null || personalLocation == "")
	   {
	       message += "Loaction cannot be empty<br/>" + "\n";
	       document.forms["add_student_info"]["personalLocation"].classList.add("txtbrcolr");
	    }
	  
	    
	    if(batch_id == null || batch_id == "no_value" || batch_id =="NULL")
	    {
	        message += "BatchId cannot be empty<br/>" + "\n";
	        document.forms["add_student_info"]["batchId"].classList.add("txtbrcolr");
	    }
	   
	    if(employee_type == null || employee_type == "no_value" || employee_type =="NULL")
	    {
	        message += "Employee Type cannot be empty<br/>" + "\n";
	        document.forms["add_student_info"]["employeeType"].classList.add("txtbrcolr");
	    }
	    
	    if(core_skill == null || core_skill == "no_value" || core_skill =="NULL")
	    {
	        message += "Core Skill cannot be empty<br/>" + "\n";
	        document.forms["add_student_info"]["coreSkill"].classList.add("txtbrcolr");
	    }
	    
	    if(relocation == null || relocation == "no_value" || relocation =="NULL")
	    {
	        message += "Relocation cannot be empty<br/>" + "\n";
	        document.forms["add_student_info"]["relocation"].classList.add("txtbrcolr");
	    }
	     if(status == null || status == "no_value" || status =="NULL")
	    {
	        message += "Status cannot be empty<br/>" + "\n";
	        document.forms["add_student_info"]["status"].classList.add("txtbrcolr");
	    }
	    
	    if(date_of_joining == null || date_of_joining == ""){
	        message += "Date of Joining cannot be empty<br/>" + "\n";
	        $("#dateOfJoining").addClass('txtbrcolr');
	    }
	    else{
	        $("#dateOfJoining").removeClass('txtbrcolr');
	    }
	    if(message.length > 0 ){    
	    	document.getElementById("blank_popup").style.display = "block";
	        document.getElementById("message_info").innerHTML = message;
	        document.getElementById("alert_popup").style.display = "block";
	        var elements = add_student_info.elements;
			for (var i = 0, len = elements.length; i < len; ++i) {
				elements[i].disabled = true;
			}
	    } else{
	    	document.getElementById("add_student_info").action="/admin-portal/EditStudentServlet";
		    document.getElementById("add_student_info").method = "POST";
		    document.getElementById("add_student_info").submit();
	    }   	
}


