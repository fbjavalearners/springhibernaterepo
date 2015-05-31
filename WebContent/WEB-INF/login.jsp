<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

</head>

<body>
	<h1>JavaLearners Login Page</h1>

	<form:form method="POST" commandName="employeeTo">
		<table>
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
				<td><input type="submit" name="submit" value="Login"></td>
			</tr>
			<tr>
		</table>
	</form:form>

</body>
</html>	
