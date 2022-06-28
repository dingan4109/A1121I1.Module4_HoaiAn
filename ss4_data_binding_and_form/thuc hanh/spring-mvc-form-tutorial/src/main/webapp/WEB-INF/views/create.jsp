<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/26/2022
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create new employee form</title>
</head>
<body>
<h3>Welcome, enter employee details</h3>
<f:form action="/employee/addEmployee" method="post" modelAttribute="employee">
    <table>
        <tr>
            <td><f:label path="id">Employee ID:</f:label></td>
            <td><f:input path="id"/></td>
        </tr>
        <tr>
            <td><f:label path="name">Employee Name: </f:label></td>
            <td><f:input path="name"/></td>
        </tr>
        <tr>
            <td><f:label path="contactNumber">Contact number: </f:label></td>
            <td><f:input path="contactNumber"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</f:form>
</body>
</html>
