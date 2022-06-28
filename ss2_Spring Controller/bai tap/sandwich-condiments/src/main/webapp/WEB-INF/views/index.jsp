<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/24/2022
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h1>Sandwich Condiments</h1>
<form action="/condiments/save" method="get">
  <input type="checkbox" name="condiment" value="Lettuce"> Lettuce
  <input type="checkbox" name="condiment" value="Tomato"> Tomato
  <input type="checkbox" name="condiment" value="Mustard"> Mustard
  <input type="checkbox" name="condiment" value="Sprouts"> Sprouts
  <br>
  <input type="submit" value="Save">
</form>

  <div>
    <c:if test="${condiment != null}">
      Selected condiment(s):
      <c:forEach items="${condiment}" var="item">
        <br>${item}
      </c:forEach>
    </c:if>
  </div>
  </body>
</html>
