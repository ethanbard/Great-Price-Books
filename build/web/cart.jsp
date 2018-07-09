<%-- 
    Document   : cart
    Created on : Dec 4, 2013, 2:44:00 PM
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
        
        <h1>Your Cart</h1>
        <form action="<c:url value='updateDatabase'/>" method="post">
        <table cellspacing="5" border="0">
            <tr>
                <td>Order ID:</td>
                <td><input type="text" name="orderID" size="10"></td>
            </tr>
        </table>
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
                
                <erb:displayCart>
                <tr>
                    <td>${cartIndex}</td>
                    <td>${title}</td>
                    <td>${author}</td>
                    <td>${category}</td>
                    <td>${priceCurrencyFormat}</td>
                    <td><a href="<c:url value="cart?removeAtIndex=${cartIndex}" />">Remove</a></td>
                </tr>
                </erb:displayCart>
                
            </tbody>
        </table>
        <br>
        <table cellspacing="5" border="0">
            <tr>
                <td>
                    <input type="submit" value="Submit">
                    </form>
                </td>
                <td>
                    <form action="<c:url value='displayBooks'/>" method="get">
                        <input type="submit" value="Back">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
