<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 
	<c:if test="${not empty errCode}">
		<h1>${errCode} : System Errors</h1>
	</c:if>
 
	<c:if test="${empty errCode}">
		<h1>System Errors</h1>
	</c:if>
 
	<c:if test="${not empty errMsg}">
		<h2>${errMsg}</h2>
	</c:if>
 
</body>
</html>