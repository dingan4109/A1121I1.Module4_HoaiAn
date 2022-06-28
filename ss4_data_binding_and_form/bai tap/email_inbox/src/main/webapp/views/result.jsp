<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/28/2022
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${mess != null}">
    ${mess}
</c:if>
<h1>${setting.language}</h1>
<h1>${setting.size}</h1>
<h1>${setting.spamFilter}</h1>
<h1>${setting.signature}</h1>
</body>
</html>
