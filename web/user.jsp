<%-- 
    Document   : user
    Created on : Dec 8, 2013, 8:28:16 PM
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
        <h1>Your Profile</h1>  
        <form action="<c:url value='updateDatabase?username=${user.getUserID()}' />" method="post"> <%-- start of the update users form --%>
        <table cellspacing="5" border="0">
            <tr>
                <td align="right">User ID:</td>
                <td><input type="text" name="userID" value="${user.getUserID()}" size="25"></td>
            </tr>
            <tr>
                <td align="right">First Name:</td>
                <td><input type="text" name="firstName" value="${user.getFirstName()}" size="25"></td>
            </tr>
            <tr>
                <td align="right">Last Name:</td>
                <td><input type="text" name="lastName" value="${user.getLastName()}" size="25"></td>
            </tr>
            <tr>
                <td align="right">Username:</td>
                <td><input type="text" name="userName" value="${user.getUserName()}" size="25"></td>
            </tr>
            <tr>
                <td align="right">Password:</td>
                <td><input type="text" name="password" value="${user.getPassword()}" size="25"></td>
            </tr>
            <tr>
                <td align="right">Email Address:</td>
                <td><input type="text" name="emailAddress" value="${user.getEmailAddress()}" size="25"></td>
            </tr>
            <tr>
                <td align="right">User Type:</td>
                <td>
                    <c:if test="${user.isAdministrator().equals('Y')}">
                        <select name="userType">
                            <option value="Y">Administrator</option>
                            <option value="N">Customer</option>
                        </select>
                    </c:if>
                    <c:if test="${user.isAdministrator().equals('N')}">
                        <select name="userType">
                            <option value="N">Customer</option>
                            <option value="Y">Administrator</option>
                        </select>
                    </c:if>
                </td>
            </tr>
        </table>
        <p>${errorMessage}</p>
        <br>
        <table cellspacing="5" border="0">
            <tr>
                <td>
                    <input type="submit" value="Update Users">
                    </form> <%-- end of the update users form --%>
                </td>
                <td>
                    <c:if test="${user.getUserID() != 0}">
                        <form action="<c:url value='displayBooks' />" method="get">
                            <input type="submit" value="View Books">
                        </form>
                    </c:if>
                </td>
            </tr>
        </table>
    </body>
</html>
