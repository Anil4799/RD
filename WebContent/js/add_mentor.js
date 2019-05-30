function validateForm() {
	var message = "";
	var mentor_name=document.forms["mentor_info_form"]["mentor_name"].value;
	var mentor_email = document.forms["mentor_info_form"]["mentor_email"].value;
	var mentorship_start_date=$("#mentorship_start_date").val();
	var mentorship_end_date=$("#mentorship_end_date").val();	
	var max_no_of_mentees = document.forms["mentor_info_form"]["max_no_of_mentees"].value;
	var mentor_status = document.forms["mentor_info_form"]["mentor_status"].value;
	var regExprEmail = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;	 	
	var regExprDate = /^(0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])[\/\-]\d{4}$/;
		
	if(mentor_name == null || mentor_name == ""){
	message += "Name cannot be empty<br/>" + "\n";
	document.forms["mentor_info_form"]["mentor_name"].classList.add("txtbrcolr");
	}
	else{
		document.forms["mentor_info_form"]["mentor_name"].classList.remove("txtbrcolr");
	}
	if(mentor_email == null || mentor_email == "")
	{
		message += "Email cannot be empty<br/>" + "\n";
	document.forms["mentor_info_form"]["mentor_email"].classList.add("txtbrcolr");
	}
	else if(!regExprEmail.test(mentor_email)){
		message += "Email is not valid<br/>" + "\n";
	document.forms["mentor_info_form"]["mentor_email"].classList.add("txtbrcolr");
	}
	else{
		document.forms["mentor_info_form"]["mentor_email"].classList.remove("txtbrcolr");
	}
	if(mentorship_start_date == null || mentorship_start_date == ""){
	message += "Mentorship Start Date cannot be empty<br/>" + "\n";
	$("#mentorship_start_date").addClass('txtbrcolr');
	$('.start_date').css('border-color','red');	
	}
	else if(!regExprDate.test(mentorship_start_date)){
		message += "Mentorship Start Date is incorrect. Please enter date in MM-DD-YYYY format<br/>" + "\n";
		$("#mentorship_start_date").addClass('txtbrcolr');
		$('.start_date').css('border-color','red');
		document.forms["mentor_info_form"]["mentorship_start_date"].classList.add("txtbrcolr");
	}	
	if(mentorship_end_date != ""){
		if(!regExprDate.test(mentorship_end_date)){
			message += "Mentorship End Date is incorrect. Please enter date in MM-DD-YYYY format<br/>" + "\n";
			$("#mentorship_end_date").addClass('txtbrcolr');
			$('.end_date').css('border-color','red');
			document.forms["mentor_info_form"]["mentorship_end_date"].classList.add("txtbrcolr");
		}
	}
	if(mentorship_start_date!='' && mentorship_start_date > mentorship_end_date)
    {
   // alert("Please ensure that the End Date is greater than or equal to the Start Date.");
    message += "Please ensure that the End Date is greater than the Start Date.<br/>" + "\n";
    $("#mentorship_end_date").addClass('txtbrcolr');
	$('.end_date').css('border-color','red');
    }
	
	
	if(max_no_of_mentees == null || max_no_of_mentees == "")
	{
		message += "Max no.of Mentees cannot be empty<br/>" + "\n";
	document.forms["mentor_info_form"]["max_no_of_mentees"].classList.add("txtbrcolr");
	}
	
	else{
		document.forms["mentor_info_form"]["max_no_of_mentees"].classList.remove("txtbrcolr");	
	}
	if(mentor_status == null || mentor_status == "")
	{
		message += "Mentor Status cannot be empty<br/>" + "\n";
	document.forms["mentor_info_form"]["mentor_status"].classList.add("txtbrcolr");
	}
	else{
		document.forms["mentor_info_form"]["mentor_status"].classList.remove("txtbrcolr");
	}
	if(message.length > 0 ){					
		document.getElementById("blank_popup").style.display = "block";
		document.getElementById("message_info").innerHTML = message;
		document.getElementById("alert_popup").style.display = "block";
		var elements = mentor_info_form.elements;
		for (var i = 0, len = elements.length; i < len; ++i) {
			elements[i].disabled = true;
		}
	}	
	else
	{						
		document.getElementById("mentor_info_form").action="/admin-portal/MentorServlet";
	    document.getElementById("mentor_info_form").method = "POST";
	    document.getElementById("mentor_info_form").submit();
	}
}
function closeAlertPopup(){
	document.getElementById("alert_popup").style.display = "none";
document.getElementById("blank_popup").style.display = "none";	
	var elements = mentor_info_form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].disabled = false;
	}
}

function gotoMentorInfo(){				
	document.location.href = '/admin-portal/mentorList';
	var elements = mentor_info_form.elements;
	for (var i = 0, len = elements.length; i < len; ++i) {
		elements[i].disabled = true;
	}

}				

function validateEditForm() {
	var message = "";
	var mentor_name=document.forms["mentor_info_form"]["mentor_name"].value;
	var mentor_email = document.forms["mentor_info_form"]["mentor_email"].value;
	var mentorship_start_date=$("#mentorship_start_date").val();
	var mentorship_end_date=$("#mentorship_end_date").val();
	var max_no_of_mentees = document.forms["mentor_info_form"]["max_no_of_mentees"].value;
	var mentor_status = document.forms["mentor_info_form"]["mentor_status"].value;
	var regExprEmail = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var regExprDate =  /^(0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])[\/\-]\d{4}$/;
	
	if(mentor_name == null || mentor_name == ""){
		message += "Name cannot be empty<br/>" + "\n";
		document.forms["mentor_info_form"]["mentor_name"].classList.add("txtbrcolr");
	}
	else{
		document.forms["mentor_info_form"]["mentor_name"].classList.remove("txtbrcolr");
	}
	if(mentor_email == null || mentor_email == ""){
		message += "Email cannot be empty<br/>" + "\n";
		document.forms["mentor_info_form"]["mentor_email"].classList.add("txtbrcolr");
	}
	else if(!regExprEmail.test(mentor_email)){
		message += "Email is not valid<br/>" + "\n";
		document.forms["mentor_info_form"]["mentor_email"].classList.add("txtbrcolr");
	}
	else{
		document.forms["mentor_info_form"]["mentor_email"].classList.remove("txtbrcolr");
	}
	if(mentorship_start_date == null || mentorship_start_date == ""){
		message += "Mentorship Start Date cannot be empty<br/>" + "\n";
		$("#mentorship_start_date").addClass('txtbrcolr');
		$('.start_date').css('border-color','red');
	}
	else if(!regExprDate.test(mentorship_start_date)){
		message += "Mentorship Start Date is incorrect. Please enter date in MM-DD-YYYY format<br/>" + "\n";
		$("#mentorship_start_date").addClass('txtbrcolr');
		$('.start_date').css('border-color','red');
		document.forms["mentor_info_form"]["mentorship_start_date"].classList.add("txtbrcolr");
	}	
	
	if(mentorship_end_date != ""){	
		if(!regExprDate.test(mentorship_end_date)){
			message += "Mentorship End Date is incorrect. Please enter date in MM-DD-YYYY format<br/>" + "\n";
			$("#mentorship_end_date").addClass('txtbrcolr');
			$('.end_date').css('border-color','red');
			document.forms["mentor_info_form"]["mentorship_end_date"].classList.add("txtbrcolr");
		}
	}
		if(mentorship_start_date!='' && mentorship_start_date > mentorship_end_date)
	    {
		message += "Please ensure that the End Date is greater than the Start Date.<br/>" + "\n";
	    $("#mentorship_end_date").addClass('txtbrcolr');
		$('.end_date').css('border-color','red');
	    }
		
	if(max_no_of_mentees == null || max_no_of_mentees == "")
	{
		message += "Max no.of Mentees cannot be empty<br/>" + "\n";
		document.forms["mentor_info_form"]["max_no_of_mentees"].classList.add("txtbrcolr");
	}
	else{
		document.forms["mentor_info_form"]["max_no_of_mentees"].classList.remove("txtbrcolr");	
	}
	if(mentor_status == null || mentor_status == "")
	{
		message += "Mentor Status cannot be empty<br/>" + "\n";
		document.forms["mentor_info_form"]["mentor_status"].classList.add("txtbrcolr");
	}
	else{
		document.forms["mentor_info_form"]["mentor_status"].classList.remove("txtbrcolr");
	}
	if(message.length > 0 ){					
		document.getElementById("blank_popup").style.display = "block";
		document.getElementById("message_info").innerHTML = message;
		document.getElementById("alert_popup").style.display = "block";
		var elements = mentor_info_form.elements;
		for (var i = 0, len = elements.length; i < len; ++i) {
			elements[i].disabled = true;
		}
	}	
	else
		{						
			document.getElementById("mentor_info_form").action="/admin-portal/MentorEditServlet";
		    document.getElementById("mentor_info_form").method = "POST";
		    document.getElementById("mentor_info_form").submit();
		}
}


