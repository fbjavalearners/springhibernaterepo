<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/ui-lightness/jquery-ui.css" media="all">
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
        <style>
h1 {
    color: orange;
    text-align: center;
}
body {
    background-color: #d0e4fe;
}

</style>
        <script>
        
        
        $(document).ready(function(){
           
           $('#datepicker').datepicker({ changeMonth: true, changeYear: true});
        });
        
        </script>
</head>
<body>

   <form:form method="POST" action="${pageContext.request.contextPath}/editemployeeform.htm" commandName="employee">
		<table border="0">
			<tr>
			  <td colspan="3"><h1>Edit Employee Details</h1></td>
			</tr>
			<tr>
				<td>EmployeeId:</td>
				<td><form:input readonly="true" path="employeeId" /></td>
				<td><form:errors path="firstName" cssStyle="color: #ff0000;"/></td>
			</tr>
			
			<tr>
				<td>First name:</td>
				<td><form:input readonly="true" path="firstName" /></td>
				<td><form:errors path="firstName" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td><form:input readonly="true" path="lastName" /></td>
				<td><form:errors path="lastName" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td>Email:</td>
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
                <td><form:input  readonly="true" path="hireDate" id="datepicker"/></td>
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