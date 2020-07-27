<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pooya
  Date: 6/1/2020
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>

</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM CUSOMER MANAGER</h2>


    </div>
</div>
<div id="container">
    <form:form action="savecustomer" modelAttribute="customer" method="post">
<!-- nee dto assicated this data  with customer id -->
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>First Name</label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>last Name</label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label>email </label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><label> </label></td>
                <td><input type="submit" value="save" class="save"></td>
            </tr>

            </tbody>
        </table>
    </form:form>
<div style="clear: both"></div>
    <p>
        <a href="${pageContext.request.contextPath}/customer/list">
            back to the form </a>
    </p>
</div>
</body>
</html>
