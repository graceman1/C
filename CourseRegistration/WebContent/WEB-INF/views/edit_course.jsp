<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
</head>
<body>
	<div align="center">
		<h2>Please Enter Curse Information</h2>
		<form:form action="saveCourse" method="post" modelAttribute="course">
			<table border="0" cellpadding="5">
			       <tr>
          <td>Course Id: </td>
          <td><form:input path="id" /></td>
        </tr>
				<tr>
					<td>Course Name: </td>
					<td><form:input path="courseName" /></td>
				</tr>

				<tr>
          <td>Course Code: </td>
          <td><form:input path="courseCode" /></td>
        </tr>
				<tr>
          <td>Prerequisite: </td>
          <td><form:input path="prerequisite" /></td>
        </tr>
        <tr>
          <td>Course Credit: </td>
          <td><form:input path="courseCredit" /></td>
        </tr>


				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>