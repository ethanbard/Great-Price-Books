<%-- 
    Document   : deleteuser
    Created on : Dec 9, 2013, 7:56:40 PM
    Author     : Ethan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Great Price Books</title>
    </head>
    <body>
        <c:if test="${user.getUserID() == currentUser.getUserID()}">
            <h1>Error!</h1>
            <p>You cannot delete your own account</p>
        </c:if>
        <c:if test="${user.getUserID() != currentUser.getUserID()}">
            <h1>Are you sure you want to delete this user?</h1>
            <table cellspacing="5" border="0">
                <tr>
                    <td align="right">User ID:</td>
                    <td>${user.getUserID()}</td>
                </tr>
                <tr>
                    <td align="right">First Name:</td>
                    <td>${user.getFirstName()}</td>
                </tr>
                <tr>
                    <td align="right">Last Name:</td>
                    <td>${user.getLastName()}</td>
                </tr>
                <tr>
                    <td align="right">Username:</td>
                    <td>${user.getUserName()}</td>
                </tr>
                <tr>
                    <td align="right">Password:</td>
                    <td>${user.getPassword()}</td>
                </tr>
                <tr>
                    <td align="right">Email Address:</td>
                    <td>${user.getEmailAddress()}</td>
                </tr>
            </table>
            <table cellspacing="5" border="0">
                <tr>
                    <td>
                        <form action="<c:url value='updateDatabase?username=${user.getUserName()}' />" method="post">
                            <input type="submit" name="delete" value="Yes">
                        </form>
                    </td>
                    <td>
                        <form action="<c:url value='displayUsers' />" method="get">
                            <input type="submit" value="No">
                        </form>
                    </td>
                </tr>
            </table>
        </c:if>
    </body>
</html>
