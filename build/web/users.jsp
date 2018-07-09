<%-- 
    Document   : users
    Created on : Dec 8, 2013, 7:54:15 PM
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
        <h1>User Profiles</h1>
        <%@page import="books.objects.User, java.util.*" %>
        <table cellspacing="5" cellpadding="5" border="1">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Email Address</th>
                    <th>Administrator</th>
                </tr>
            </thead>
            <tbody>
                <%@taglib prefix="erb" uri="/WEB-INF/booktags.tld" %>
                
                <erb:displayUsers>
                    <tr>
                        <td>${userID}</td>
                        <td>${firstName}</td>
                        <td>${lastName}</td>
                        <td>${userName}</td>
                        <td>${password}</td>
                        <td>${emailAddress}</td>
                        <td>${isAdministrator}</td>
                        <td><a href="<c:url value="displayUser?delete=${userName}" />">Delete</a></td>
                    </tr>
                </erb:displayUsers>
            </tbody>
        </table>
        <form action="<c:url value='displayBooks'/>" method="get">
            <input type="submit" value="Back">
        </form>
    </body>
</html>
