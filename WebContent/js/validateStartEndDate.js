
function validateStartEndDate()
{
	
	var startDate= document.getElementById("startDate").value;
	var endDate=document.getElementById("endDate").value;
	var msg="";
	var endMsg="";
	var count=0;
if(startDate==null){msg+="Start Date ";count=1;}
	
	
if(endDate==null){
	msg+="End Date";count=2;
}
if(count ==2){
	msg="Start Date and End Date";
}
endMsg="need to be entered";
return msg+endMsg;

}

