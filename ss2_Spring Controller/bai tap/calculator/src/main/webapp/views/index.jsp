<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/24/2022
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
<h1>Calculator</h1>
<form action="/calculate" method="get">
  <input type="text" name="number1">
  <input type="text" name="number2">
  <br>
  <button type="submit" name="operator" value="+">Add</button>
  <button type="submit" name="operator" value="-">Sub</button>
  <button type="submit" name="operator" value="x">Mul</button>
  <button type="submit" name="operator" value=":">Div</button>
</form>

  <div>
    <c:if test="${flag==true}">
      ${calculator.number1} ${calculator.operator} ${calculator.number2} = ${result}
    </c:if>
  </div>
  </body>
</html>
