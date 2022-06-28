<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/28/2022
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <f:form action="/save" method="post" modelAttribute="setting">
    <table>
      <tr>
        <td><f:label path="language">Language: </f:label></td>
        <td>
          <f:select path="language">
          <f:option value="English">English</f:option>
          <f:option value="Vietnamese">Vietnamese</f:option>
          <f:option value="Japanese">Japanese</f:option>
          <f:option value="Chinese">Chinese</f:option>
        </f:select>
        </td>
      </tr>
      <tr>
        <td><f:label path="size">Page size:</f:label></td>
        <td>
          Show <span>
          <f:select path="size">
            <f:option value="5">5</f:option>
            <f:option value="10">10</f:option>
            <f:option value="15">15</f:option>
            <f:option value="25">25</f:option>
            <f:option value="50">50</f:option>
            <f:option value="100">100</f:option>
          </f:select>
        </span> emails per page
        </td>
      </tr>
      <tr>
        <td><f:label path="spamFilter">Spams filter</f:label></td>
        <td><f:checkbox path="spamFilter"></f:checkbox></td>
      </tr>
      <tr>
        <td><f:label path="signature">Signature: </f:label></td>
        <td><f:textarea path="signature"></f:textarea></td>
      </tr>
      <br/>
      <tr>
        <td><f:button type="submit">Update</f:button></td>
        <td><f:button type="reset">Cancel</f:button></td>
      </tr>
    </table>
  </f:form>
  </body>
</html>
