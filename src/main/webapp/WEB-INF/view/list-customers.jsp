<%--
  Created by IntelliJ IDEA.
  User: pooya
  Date: 5/28/2020
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <!--  add our html table here -->
        <input type="button" value="add Customer" onclick="window.location.href='showFormForAdd';return false;"
        class="add-button"/>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="tempCustomer" items="${customers}">
                <! creating link for update why they must be inside a togather?-->
                <c:url var="updateLink"  value="/customer/showFormUpdate">
                    <c:param name="customerid" value="${tempCustomer.id}"/>

                </c:url>
                <tr>
                    <td> ${tempCustomer.firstName} </td>
                    <td> ${tempCustomer.lastName} </td>
                    <td> ${tempCustomer.email} </td>
                    <td>
                        <a href="${updateLink}">Update</a>
                    </td>



                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>

