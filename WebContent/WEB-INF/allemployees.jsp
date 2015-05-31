<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

  <table border="0" width="100%"> 
    <tr>
      <td colspan="5" align="center"><h1>All Employees</h1></td>
    
    </tr>    
     <tr>
      <td colspan="5" align="center"><a href="addemployeeform.htm"><h1>Add New Employee</h1></a></td>
    
    </tr> 
    <c:forEach items="${allEmployees}" var="employee">
        <tr>
            <td>${employee.employeeId}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
             <td>${employee.email}</td>
            <td>${employee.phoneNumber}</td>
            <td>${employee.commissionPct}</td>
            
            
            <td><a href="<c:url value='/editemployeeform/${employee.employeeId}.htm' />" >Edit</a></td>
            <td><a href="<c:url value='deleteemployee/${employee.employeeId}.htm' />" >Delete</a></td>
        </tr>
    </c:forEach>
     </table>








</body>
</html>