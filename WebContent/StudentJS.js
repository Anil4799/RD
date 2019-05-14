function validateForm() {
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
    else{
        document.forms["add_student_info"]["firstName"].classList.remove("txtbrcolr");
    }
    if(last_name == null || last_name == ""){
        message += "Last Name cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["lastName"].classList.add("txtbrcolr");
    }
    else{
        document.forms["add_student_info"]["lastName"].classList.remove("txtbrcolr");
    }
    if(email == null || email == "")
    {
        message += "Email cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["email"].classList.add("txtbrcolr");
    }else{
        document.forms["add_student_info"]["email"].classList.remove("txtbrcolr");
    }
    if(date_of_birth == null || date_of_birth == ""){
        message += "Date of Birth cannot be empty<br/>" + "\n";
        $("#dateOfBirth").addClass('txtbrcolr');
    }
    else{
        $("#dateOfBirth").removeClass('txtbrcolr');
    }
    if(gender == null || gender == "no_value")
    {
        message += "Gender cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["gender"].classList.add("txtbrcolr");
    }
    else{
        $("#gender").removeClass('txtbrcolr');
    }
    
    if(personalLocation == null || personalLocation == "")
   {
       message += "Loaction cannot be empty<br/>" + "\n";
       document.forms["add_student_info"]["personalLocation"].classList.add("txtbrcolr");
    }
   else{
	   $("#personalLocation").removeClass('txtbrcolr');
       }
    
    if(batch_id == null || batch_id == "no_value")
    {
        message += "BatchId cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["batchId"].classList.add("txtbrcolr");
    }
    else{
        $("#batchId").removeClass('txtbrcolr');
    }
    if(employee_type == null || employee_type == "no_value")
    {
        message += "Employee Type cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["employeeType"].classList.add("txtbrcolr");
    }
    else{
        $("#employeeType").removeClass('txtbrcolr');
    }
    if(core_skill == null || core_skill == "no_value")
    {
        message += "Core Skill cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["coreSkill"].classList.add("txtbrcolr");
    }
    else{
        $("#coreSkill").removeClass('txtbrcolr');
    }
    if(relocation == null || relocation == "no_value")
    {
        message += "Relocation cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["relocation"].classList.add("txtbrcolr");
    }
    else{
        $("#relocation").removeClass('txtbrcolr');
    } if(status == null || status == "no_value")
    {
        message += "Status cannot be empty<br/>" + "\n";
        document.forms["add_student_info"]["status"].classList.add("txtbrcolr");
    }
    else{
        $("#status").removeClass('txtbrcolr');
    }
    if(date_of_joining == null || date_of_joining == ""){
        message += "Date of Joining cannot be empty<br/>" + "\n";
        $("#dateOfJoining").addClass('txtbrcolr');
    }
    else{
        $("#dateOfJoining").removeClass('txtbrcolr');
    }
    if(message.length > 0 ){
        //alert(message);
        document.getElementById("message_info").innerHTML = message;
        document.getElementById("alert_popup").style.display = "block";
    }    
    else
        {                        
            //document.getElementById("mentor_info_form").reset();
            //document.getElementById("mentor_added_message").style.display = "block";
              //document.getElementById("add_student_info").action="./MentorServlet";
            //document.getElementById("add_student_info").method = "POST";
    		document.getElementById("success_message").style.display = "block";
            document.getElementById("add_student_info").submit();
        }
    

}
function closeAlertPopup(){
    document.getElementById("alert_popup").style.display = "none";
}
function gotoStudentLandingPage(){
    window.location = 'StudentInfoLandingPage.jsp';
}


function setLocation()
{
 var collegeNameLocation = document.add_student_info.collegeName.value;
 var collegeName1 = collegeNameLocation.substring(0, collegeNameLocation.indexOf("$"));
// alert(collegeName1);
 var location = collegeNameLocation.substring(collegeNameLocation.indexOf("$") + 1);
 //alert(location + "===" + collegeName);
 //document.add_student_info.collegeName.value = collegeName1;
 document.add_student_info.collegeLocation.value = location;
 
}


