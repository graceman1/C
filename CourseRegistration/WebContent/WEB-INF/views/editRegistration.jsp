<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Registration</title>
</head>
<body>
  <div align="center">

    <form:form action="saveRegistration" method="post" modelAttribute="courseRegistration">
      <table border="0" cellpadding="5">
             <tr>
          <td>Registration  Id: </td>
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
          <td>Course Credit: </td>
          <td><form:input path="courseCredit" /></td>
        </tr>

        <tr>
          <td>Registration Date: </td>
          <td><form:input path="registrationDate" /></td>
        </tr>

        <tr>
          <td>Course Mark: </td>
          <td><form:input path="mark" /></td>
        </tr>

        <tr>
          <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
      </table>
    </form:form>
  </div>
</body>
</html>