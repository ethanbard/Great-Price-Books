<%-- 
    Document   : orders
    Created on : Dec 9, 2013, 4:54:34 PM
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
        <h1>Orders</h1>
        <table cellspacing="5" cellpadding="5" border="1">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Order Date</th>
                    <th>Total Cost</th>
                    <th>Customer ID</th>
                </tr>
            </thead>
            <tbody>
                
                <%@taglib prefix="erb" uri="/WEB-INF/booktags.tld" %>
                
                <erb:displayOrders>
                <tr>
                    <td>${orderID}</td>
                    <td>${orderDate}</td>
                    <td>${totalCost}</td>
                    <td>${userID}</td>
                    <td><a href="<c:url value="displayBooks?booksOrdered=${orderID}" />">Books Ordered</a></td>
                </tr>
                </erb:displayOrders>
                
            </tbody>
        </table>
        <br>
        <form action="<c:url value='displayBooks'/>" method="get">
            <input type="submit" value="Back">
        </form>
    </body>
</html>
