<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>

<body>
	

	<form:form method="POST" commandName="student">
		<table>
			<tr>
				<td>Enter your name:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td>Enter your last name:</td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
		</table>
	</form:form>

</body>
</html>	
