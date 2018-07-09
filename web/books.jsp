<%-- 
    Document   : books
    Created on : Dec 1, 2013, 7:45:34 PM
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
        <%@page import="books.objects.Book, java.util.*" %>
        
        <h1>Great Price Books</h1>
        <h3><a href="<c:url value="displayUser?username=${currentUser.getUserName()}" />">My Profile</a></h3>
        <h3><a href="<c:url value="login?logout='Y'" />">Log out</a></h3>
        <c:if test="${currentUser.isAdministrator().equals('Y')}">
            <h3><a href="<c:url value="displayUsers" />">View Users</a></h3>
            <h3><a href="<c:url value="displayOrders" />">View Orders</a></h3>
        </c:if>
        <table cellspacing="5" cellpadding="5" border="1">
            <thead>
                <tr>
                    <th>Book ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Category</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                
                <%@taglib prefix="erb" uri="/WEB-INF/booktags.tld" %>
                
                <erb:displayBooks>
                <tr>
                    <td>${bookID}</td>
                    <td>${title}</td>
                    <td>${author}</td>
                    <td>${category}</td>
                    <td>${priceCurrencyFormat}</td>
                    <td><a href="<c:url value="${cartOrEditURL}" />">${cartOrEdit}</a></td>
                    <td><a href="<c:url value="displayBook?delete=${bookID}" />">${delete}</a></td>
                </tr>
                </erb:displayBooks>
                
            </tbody>
        </table>
        <br>
        <form action="<c:url value='displayBook'/>" method="get">
            <c:if test="${currentUser.isAdministrator().equals('Y')}">
                <input type="submit" value="Add Book">
            </c:if>
        </form>
    </body>
</html>
