<%-- 
    Document   : booksordered
    Created on : Dec 9, 2013, 11:06:13 PM
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
        
        <h1>Books Ordered</h1>
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
                </tr>
                </erb:displayBooks>
                
            </tbody>
        </table>
        <br>
        <form action="<c:url value='displayOrders'/>" method="get">
            <input type="submit" value="Back">
        </form>
    </body>
</html>
