<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.dto.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		Student student = (Student) request.getAttribute("student");
	%>
	<%@ include file="index.html"%>
	
	<table align=center border=2>
		<tr>
			<th>NAME</th>
			<th>YEAR</th>
			<th>BRANCH</th>
			<th>LOGINID</th>
		</tr>
		<tr>
			<td><%=student.getsName()%></td>
			<td><%=student.getYear()%></td>
			<td><%=student.getBranch()%></td>
			<td><%=student.getLoginId()%></td>
			
			
		</tr>
	</table>
</body>
</html>