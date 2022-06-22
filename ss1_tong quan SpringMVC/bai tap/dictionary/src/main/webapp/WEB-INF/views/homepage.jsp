<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/21/2022
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/look-up" method="post">
    <input type="text" name="word" placeholder="Input word">
    <button type="submit">Look Up</button>
</form>

<h1>
    <c:if test="${result!= null}">
        ${word}: ${result}
    </c:if>
</h1>
</body>
</html>
