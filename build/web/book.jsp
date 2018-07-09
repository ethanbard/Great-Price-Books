<%-- 
    Document   : book
    Created on : Dec 3, 2013, 2:02:56 PM
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
        
        <h1>Book</h1>
        <p>${message}</p>  
        <form action="<c:url value='updateDatabase' />" method="post"> <%-- start of the update books form --%>
        <table cellspacing="5" border="0">
            <tr>
                <td align="right">Book ID:</td>
                <td><input type="text" name="bookID" value="${book.getBookID()}" size="25"></td>
            </tr>
            <tr>
                <td align="right">Title:</td>
                <td><input type="text" name="title" value="${book.getTitle()}" size="25"></td>
            </tr>
            <tr>
                <td align="right">Author:</td>
                <td><input type="text" name="author" value="${book.getAuthor()}" size="25"></td>
            </tr>
            <tr>
                <td align="right">Category:</td>
                <td><input type="text" name="category" value="${book.getCategory()}" size="25"></td>
            </tr>
            <tr>
                <td align="right">Price:</td>
                <td><input type="text" name="price" value="${book.getPriceNumberFormat()}" size="25"></td>
            </tr>
        </table>
        <p>${errorMessage}</p>
        <br>
        <table cellspacing="5" border="0">
            <tr>
                <td>
                    <input type="submit" value="Update Books">
                    </form> <%-- end of the update books form --%>
                </td>
                <td>
                    <form action="<c:url value='displayBooks' />" method="get">
                        <input type="submit" value="View Books">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
