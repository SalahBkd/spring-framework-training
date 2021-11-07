<%--
  Created by IntelliJ IDEA.
  User: salah
  Date: 10/11/2020
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form</title>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<form:form action="processForm" method="POST" modelAttribute="person">
    Name (*): <form:input path="name"/>
    <form:errors path="name" cssClass="error"/>
    <br>
    <input type="submit">
</form:form>
</body>
</html>
