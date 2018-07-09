<%-- 
    Document   : deletebook
    Created on : Dec 9, 2013, 7:56:30 PM
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
        <h1>Are you sure you want to delete this book?</h1>
        <table cellspacing="5" border="0">
            <tr>
                <td align="right">Book ID:</td>
                <td>${book.getBookID()}</td>
            </tr>
            <tr>
                <td align="right">Title:</td>
                <td>${book.getTitle()}</td>
            </tr>
            <tr>
                <td align="right">Author:</td>
                <td>${book.getAuthor()}</td>
            </tr>
            <tr>
                <td align="right">Category:</td>
                <td>${book.getCategory()}</td>
            </tr>
            <tr>
                <td align="right">Price:</td>
                <td>${book.getPriceCurrencyFormat()}</td>
            </tr>
        </table>
        <table cellspacing="5" border="0">
            <tr>
                <td>
                    <form action="<c:url value='updateDatabase?bookID=${book.getBookID()}' />" method="post">
                        <input type="submit" name="delete" value="Yes">
                    </form>
                </td>
                <td>
                    <form action="<c:url value='displayBooks' />" method="get">
                        <input type="submit" value="No">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
