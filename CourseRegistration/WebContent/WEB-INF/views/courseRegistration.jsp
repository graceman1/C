<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Registration</title>
</head>
<body>
  <div align="center">

    <form:form action="saveNewRegistration" method="post">
        Please Select a Course:&nbsp;
    <select name="courseId" id="courseId">
        <c:forEach items="${courseList}" var="acourse">
            <option value="${acourse.id}">${acourse.courseName}</option>
        </c:forEach>
    </select>
    <br/><br/>
    <input type="submit" value="Submit" />
    </form:form>
  </div>
</body>
</html>