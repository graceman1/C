<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
</head>
<body>
<div align="center">
	<h2>User List</h2>
	<br>
	<form method="get" action="searchUser">

		<input type="text" id="keyword" name="keyword" /> &nbsp;

		<input type="submit" value="KeyWord Search" />
	</form>

	<table border="1" cellpadding="5">
		<tr>
			<th>ID</th>
			<th>User Name</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>E-mail</th>
			<th>Address</th>
			<th>Role</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${listUsers}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.username}</td>
			<td>${user.firstname}</td>
			<td>${user.lastname}</td>
			<td>${user.email}</td>
			<td>${user.address}</td>
			<td>${user.role}</td>
			<td>
				<a href="editUser?id=${user.id}">Edit</a>
				&nbsp;&nbsp;&nbsp;
				<a href="deleteUser?id=${user.id}">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>

  <h3><a href="newUser">Create New User</a></h3>
<br>
<br>
<div>
<h2>Course List</h2>
<table border="1" cellpadding="5">
    <tr>
      <th>ID</th>
      <th>Course Name</th>
      <th>Course Code</th>
      <th>Prerequisite</th>
      <th>Course Credit</th>
      <th>Action</th>
    </tr>
    <c:forEach items="${listCourses}" var="course">
    <tr>
      <td>${course.id}</td>
      <td>${course.courseName}</td>
      <td>${course.courseCode}</td>
      <td>${course.prerequisite}</td>
      <td>${course.courseCredit}</td>
      <td>
        <a href="editCourse?id=${course.id}">Edit</a>
        &nbsp;&nbsp;&nbsp;
        <a href="deleteCourse?id=${course.id}">Delete</a>
      </td>
    </tr>
    </c:forEach>
  </table>

</div>
	<h3><a href="newCourse">Create New Course</a></h3>
</div>
</body>
</html>