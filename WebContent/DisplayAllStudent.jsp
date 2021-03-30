<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SvecwOpenElective</title>
</head>
<body>
<jsp:include page="hod.html" />
	<table align=center border=2>
		<tr>
			<th>STUDENTID</th>
			<th>YEAR-SEMESTER</th>
			<th>BRANCH</th>
			<th>SUBJECT</th>
			
		</tr>
	<c:forEach var="student" items="${openList}">	
		<tr>
			<td>${student.oId}</td>
			<td>${student.year}</td>
			<td>${student.branch}</td>
			<td>${student.sub}</td>
		</tr>
		</c:forEach>
		
	</table>

</body>
</html>