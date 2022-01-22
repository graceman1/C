<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Account</title>
</head>
<body>
<div align="center">

  <h3> <a href="updateMyAccount?id=${accountId}">Update My Account</a></h3>
	<h3> <a href="registerCourse">Register Course</a></h3>

	<br>
	<h3>My Course List</h3>
	<table border="1" cellpadding="5">
		<tr>
			<th>ID</th>
			<th>Course Name</th>
			<th>Course Code</th>
			<th>Course Credit</th>
			<th>Register Date</th>
			<th>Final Mark</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${myCourseList}" var="course">
		<tr>
			<td>${course.id}</td>
			<td>${course.courseName}</td>
			<td>${course.courseCode}</td>
			<td>${course.courseCredit}</td>
			<td>${course.registrationDate}</td>
			<td>${course.mark}</td>
			<td>
							<a href="cancelRegistration?id=${course.id}">Cancel</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>