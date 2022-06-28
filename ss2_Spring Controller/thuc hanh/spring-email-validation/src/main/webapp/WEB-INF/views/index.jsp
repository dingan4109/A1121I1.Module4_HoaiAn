<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/23/2022
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h1>Email Validation</h1>
  <h3 style="color: red">${mess}</h3>

<form action="validate" method="post">
  <input type="text" name="email" placeholder="input email">
  <input type="submit" value="Validate">
</form>
  </body>
</html>
