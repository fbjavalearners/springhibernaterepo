<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
h1 {
    color: orange;
    text-align: center;
}
body {
    background-color: #d0e4fe;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/ui-lightness/jquery-ui.css" media="all">
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
        
        <script>
        
      

        
        $(document).ready(function(){
           
           $('#datepicker').datepicker({ changeMonth: true, changeYear: true});
           $("#lastName").blur(function(){
               validateUserName();
           });
           $("#email").blur(function(){
               validateEmail();
           });
           
           $("empform").submit(function(){
               alert("Submitted");
           });
           
        });
        function validateUserName() {
            $.ajax({
                url : 'validuser.htm',
                data:'firstName=' + $("#firstName").val() + "&lastName=" + $("#lastName").val() + "&email=" + $("#email").val(),
                success : function(data) {
                	
                	$('#result').html('');
                	//alert(data.respMsg);
                	$('#result').html(data.respMsg);
                	
                	
                }
            });
        }
        function validateEmail() {
            $.ajax({
                url : 'checkemail.htm',
                data:"email=" + $("#email").val(),
                success : function(data) {
                	
                	$('#result').html('');
                	//alert(data.respMsg);
                	$('#result').html(data.respMsg);
                	
                	
                }
            });
        }
        function validate(){
        	var errMsg = jQuery.trim($('#result').html());
        	var firstName = jQuery.trim($('#firstName').val());
        	var lastName = jQuery.trim($('#lastName').val());
        	var email = jQuery.trim($('#email').val());
        	var hireDate = jQuery.trim($('#datepicker').val());
        	var jobId = jQuery.trim($('#jobId').val());
        	
        	
        	if(firstName.length <= 0 ){
        		alert('Please enter firstName ');
        		return false;
        	}else if(lastName.length <= 0 ){
        		alert('Please enter lastName ');
        		return false;
        	}else if(email.length <= 0 ){
        		alert('Please enter email ');
        		return false;
        	}else if(hireDate.length <= 0 ){
        		alert('Please enter hireDate '+hireDate);
        		return false;
        	}
        	
        	else if(jobId.length <= 0 ){
        		alert('Please enter jobId ');
        		return false;
        	}else 	if(errMsg.length > 0 ){
        		alert('error' +errMsg);
        		return false;
        	}else
        		return true;
        	
        }

        $(function() {      
            $("#jobId").autocomplete({
                source: function (request, response) {
                    $.getJSON("${pageContext.request.contextPath}/getJobIds.htm", {
                        term: request.term
                    }, response);
                }
            });
        });
        
        </script>
</head>
<body>

   <form:form name="empform" method="POST" action="addemployee.htm" onsubmit="return validate()" commandName="employee">
		<table border="0">
			<tr>
			  <td colspan="3"><div id="result"></div></td>
			</tr>
			<tr>
			  <td colspan="3"><h1>Add new Employee</h1></td>
			</tr>
			<tr>
				<td>Enter your First name:</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td>Enter your last name:</td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td>Enter your email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssStyle="color: #ff0000;"/></td>
			</tr>
			 
			 <tr>
				<td>Enter your salary:</td>
				<td><form:input path="salary" /></td>
				<td><form:errors path="salary" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td>Enter your commissionpct:</td>
				<td><form:input path="commissionPct" /></td>
				<td><form:errors path="commissionPct" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td>Enter your phoneNumber:</td>
				<td><form:input path="phoneNumber" /></td>
				<td><form:errors path="phoneNumber" cssStyle="color: #ff0000;"/></td>
			</tr>
			 <tr>
                <td class="BlueSmall11">DOB:</td>
                <td><input type="text" name="hireDate" id="datepicker"/></td>
            </tr>
            <tr>
				<td>Job Id:</td>
				<td><form:input path="jobId" /></td>
				<td><form:errors path="jobId" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
		</table>
	</form:form>




</body>
</html>