<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>
  <div align="center">
    <h2>Update My Account User</h2>
    <form:form action="saveUser" method="post" modelAttribute="user">
      <table border="0" cellpadding="5">
        <tr>
          <td>ID: </td>
          <td>${user.id}
            <form:hidden path="id"/>
          </td>
        </tr>

        <tr>
          <td>User Name: </td>
          <td><form:input path="username" /></td>
        </tr>

        <tr>
          <td><form:hidden path="password" value="${password}"/></td>
        </tr>

        <tr>
          <td>First Name: </td>
          <td><form:input path="firstname" /></td>
        </tr>
                <tr>
          <td>Last Name: </td>
          <td><form:input path="lastname" /></td>
        </tr>
        <tr>
          <td>Email: </td>
          <td><form:input path="email" /></td>
        </tr>
        <tr>
          <td>Address: </td>
          <td><form:input path="address" /></td>
        </tr>
                <tr>
          <td>Role: </td>
          <td><form:input path="role" /></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="Save User"></td>
        </tr>
      </table>
    </form:form>
  </div>
</body>
</html>