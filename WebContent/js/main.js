/**
 * 
 */

	function batchInfoLandingPgae(){
				
				document.getElementById("batch_info_form").action="/admin-portal/batchInfo";
			    document.getElementById("batch_info_form").method = "POST";
			    document.getElementById("batch_info_form").submit();
			}
		
	function batchValidateForm() {
				
				var message = "";
				var codeToInsertOrUpdate=document.getElementById("insertUpdateCode").value;
				var batch_id=document.forms["batch_info_form"]["batch_id"].value;
				var batch_start_date=document.getElementsByName("batch_start_date")[0].value;
				
				//var batch_start_date=document.getElementById("batch_start_date").value;
				alert("Hello"+batch_start_date);
				var batch_end_date=document.getElementById("batch_end_date").value;
				var batch_status=document.getElementById("batch_status").value;
				var default_id="";
				
			if(batch_start_date == null || batch_start_date == ""){
					message += "Start Date cannot be empty" + "<br>";
					$("#batch_start_date").addClass('txtbrcolr');
					
					$('.start_date').css('border-color','red');
				}	
			else{
					$("#batch_start_date").removeClass('txtbrcolr');
					
				}
			if(batch_id == default_id)
			{
				message += "BatchId cannot be empty" + "<br>";
				$("#batch_id").addClass('txtbrcolr');
		
			}
		else
			{
				$("#batch_id").removeClass('txtbrcolr');
			}
				
				if(message.length > 17 ){
					customAlertIdGenerated(message);
					
				}	
				else
					{						
					
						saveAsynchronous(batch_id, batch_start_date, batch_end_date, batch_status,codeToInsertOrUpdate);
						
					}
				
				
			}
			
			function customAlertIdAdded(message){
				var batch_added_message = document.getElementById('batch_added_message');	 					        	        
				document.getElementById('batch_added_message').innerHTML = message;
				batch_added_message.style.display = "block";
				setTimeout(function () {document.getElementById('batch_added_message').style.display='none'}, 1000);
				setTimeout(function () {
					
					batchInfoLandingPgae()}, 500);								
			}
			
			
			
			function customAlertIdGenerated(message){
				var winW = window.innerWidth;
	       		var winH = window.innerHeight;
		        var dialogoverlay = document.getElementById('dialogoverlay');
		        var dialogbox = document.getElementById('dialogbox');
		        dialogoverlay.style.display = "block";
		        dialogoverlay.style.height = winH+"px";
		        dialogbox.style.left = (winW/2) - (550 * .4)+"px";
		        dialogbox.style.top = "10px";
		        dialogbox.style.display = "block";
		        
		        document.getElementById('dialogboxhead').innerHTML = "&nbsp;&nbsp;&nbsp;RD Portal Says <br>";
		        document.getElementById('dialogboxbody').innerHTML = message;
		        document.getElementById('dialogboxfoot').innerHTML = '<span style="background-color:#5CB85C ; color: #FFF; font-size: 12px; border-radius: 5px 5px 5px 5px;  padding: 5px 5px 5px 5px; width: 60px; height: 30px; float: right; margin: 8px; text-align: center; cursor: pointer;" onclick="customOk()">OK</span>';
				}
		        function customOk(){
		        	
		    		document.getElementById('dialogbox').style.display = "none";
		    		document.getElementById('dialogoverlay').style.display = "none";
				
		        }

			
		function saveAsynchronous(batch_id, batch_start_date, batch_end_date, batch_status,codeToInsertOrUpdate) {
			var params = "?batch_id="+ batch_id+ "&batch_start_date="+batch_start_date + "&batch_end_date=" + batch_end_date
			  + "&batch_status="+batch_status+ "&codeToInsertOrUpdate="+codeToInsertOrUpdate;
			var xhttp;
	
			if (window.XMLHttpRequest) {
	 		   xhttp = new XMLHttpRequest();
	  		} else {
	 			xhttp = new ActiveXObject("Microsoft.XMLHTTP");
	  		}
	
		  xhttp.onreadystatechange = function() {
	   	 if (this.readyState == 4 && this.status == 200) {
	       		customAlertIdAdded(this.responseText);
	   	 }
	  };
	 		 xhttp.open("GET", "/admin-portal/SaveBatchInfoServlet"+ params, true);
	  		xhttp.send();
		}