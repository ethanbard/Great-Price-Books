<%-- 
    Document   : index
    Created on : Nov 27, 2013, 7:19:05 PM
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
        <h1>Welcome to Great Price Books!</h1>
        <h3>Please Sign In</h3>
        
        <form action="<c:url value='login' />" method="post"> <%-- start of the login form --%>
        <table cellspacing="5" border="0">
            <tr>
                <td align="right">Username:</td>
                <td><input type="text" name="username" value="" size="25"></td>
            </tr>
            <tr>
                <td align="right">Password:</td>
                <td><input type="text" name="password" value="" size="25"></td>
            </tr>
        </table>
        <p>${errorMessage}</p>
        <br>
        <table cellspacing="5" border="0">
            <tr>
                <td>
                    <input type="submit" value="Log In">
                    </form> <%-- end of the login form --%>
                </td>
                <td>
                    <form action="<c:url value='displayUser' />" method="get">
                        <input type="submit" value="Sign Up">
                    </form>
                </td>
            </tr>
        </table>
        
        
    </body>
</html>
