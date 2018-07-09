/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package books.database;

import java.util.*;
import java.sql.*;

import books.objects.*;

/**
 *
 * @author Ethan
 */
public class DatabaseIO 
{
    //*********************************************************
    //******************BOOK TABLE FUNCTIONS*******************
    //*********************************************************
    
    public static ArrayList<Book> selectBooks()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Book";
        
        try
        {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Book> books = new ArrayList<Book>();
            Book book = null;
            
            while (rs.next())
            {
                book = new Book();
                book.setBookID(rs.getInt("BookID"));
                book.setTitle(rs.getString("Title"));
                book.setAuthor(rs.getString("Author"));
                book.setCategory(rs.getString("Category"));
                book.setPrice(rs.getDouble("Price"));
                
                books.add(book);
            }
            return books;
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
    }
    
    public static Book selectBook(int id)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Book WHERE BookID = ?";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Book book = null;
            
            while (rs.next())
            {
                book = new Book();
                book.setBookID(rs.getInt("BookID"));
                book.setTitle(rs.getString("Title"));
                book.setAuthor(rs.getString("Author"));
                book.setCategory(rs.getString("Category"));
                book.setPrice(rs.getDouble("Price"));
            }
            return book;
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
    }
    
    public static boolean bookExists(int id)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT BookID FROM Book WHERE BookID = ?";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            return rs.next();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return false;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
    }
    
    public static int insertBook(Book book)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "INSERT INTO Book (BookID, Title, Author, Category, Price) " +
                       "VALUES (?, ?, ?, ?, ?)";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setInt(1, book.getBookID());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getCategory());
            ps.setDouble(5, book.getPriceNumberFormat());
            
            return ps.executeUpdate();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
    }
    
    public static int updateBook(Book book)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE Book SET " +
                       "Title = ?, Author = ?, Category = ?, Price = ? " +
                       "WHERE BookID = ?";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setDouble(4, book.getPriceNumberFormat());
            ps.setInt(5, book.getBookID());
            
            return ps.executeUpdate();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
    }
    
    public static int deleteBook(Book book)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "DELETE FROM Book WHERE BookID = ?";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setInt(1, book.getBookID());
            
            return ps.executeUpdate();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
    }
    
    //****************************************************************
    //*******************USERS TABLE FUNCTIONS************************
    //****************************************************************
    
    public static ArrayList<User> selectUsers()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Users";
        
        try
        {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<User> users = new ArrayList<User>();
            User user = null;
            
            while (rs.next())
            {
                user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setEmailAddress(rs.getString("EmailAddress"));
                user.setUserType(rs.getString("Administrator"));
                
                users.add(user);
            }
            return users;
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
    }
    
    public static User selectUser(String username)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Users WHERE UserName = ?";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            User user = null;
            
            while (rs.next())
            {
                user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setEmailAddress(rs.getString("EmailAddress"));
                user.setUserType(rs.getString("Administrator"));                
            }
            return user;
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
    }
    
    public static boolean userExists(String username)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT UserName FROM Users WHERE UserName = ?";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            return rs.next();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return false;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
    }
    
    public static int insertUser(User user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "INSERT INTO Users "
                + "(UserID, FirstName, LastName, UserName, Password, EmailAddress, Administrator)" +
                  "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setInt(1, user.getUserID());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getUserName());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getEmailAddress());
            ps.setString(7, user.isAdministrator());
            
            return ps.executeUpdate();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
    }
    
    public static int updateUser(User user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE Users SET " +
                       "FirstName = ?, LastName = ?, UserName = ?, "
                     + "Password = ?, EmailAddress = ?, Administrator = ? " +
                       "WHERE UserID = ?";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getEmailAddress());
            ps.setString(6, user.isAdministrator());
            ps.setInt(7, user.getUserID());
            
            return ps.executeUpdate();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
    }
    
    public static int deleteUser(User user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "DELETE FROM Users WHERE UserID = ?";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setInt(1, user.getUserID());
            
            return ps.executeUpdate();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
    }
    
    //****************************************************************
    //*******************ORDERS TABLE FUNCTIONS***********************
    //****************************************************************
    
    public static ArrayList<Order> selectOrders()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Orders";
        
        //Inner query to select books
        PreparedStatement bookPS = null;
        ResultSet bookRS = null;
        
        String bookQuery = "SELECT * FROM Book, OrderBook, Orders " +
                           "WHERE Book.BookID = OrderBook.BookID " +
                           "AND OrderBook.OrderID = ?";
        
        try
        {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Order> orders = new ArrayList<Order>();
            Order ord = null;
            
            while (rs.next())
            {
                bookPS = conn.prepareStatement(bookQuery);
                bookPS.setInt(1, rs.getInt("OrderID"));
                bookRS = bookPS.executeQuery();
                ArrayList<Book> booksOrdered = new ArrayList<Book>();
                Book book = null;
                
                ord = new Order();
                ord.setOrderID(rs.getInt("OrderID"));
                ord.setOrderDate(rs.getDate("OrderDate").toString());
                ord.setTotalCost(rs.getDouble("TotalCost"));
                ord.setUserID(rs.getInt("CustomerID"));
                //Add the books to the order
                while (bookRS.next())
                {
                    book = new Book();
                    book.setBookID(bookRS.getInt("BookID"));
                    book.setTitle(bookRS.getString("Title"));
                    book.setAuthor(bookRS.getString("Author"));
                    book.setCategory(bookRS.getString("Category"));
                    book.setPrice(bookRS.getDouble("Price"));
                    
                    booksOrdered.add(book);
                }
                
                ord.setBooksOrdered(booksOrdered);
                orders.add(ord);
            }
            return orders;
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(bookRS);
            DBUtil.closePreparedStatement(bookPS);
            pool.freeConnection(conn);
        }
    }
    
    public static int insertOrder(Order ord)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "INSERT INTO Orders "
                + "(OrderID, OrderDate, TotalCost, CustomerID)" +
                  "VALUES (?, GETDATE(), ?, ?)";
        
        PreparedStatement bookPS = null;
        String bookQuery = "INSERT INTO OrderBook (BookID, OrderID)" +
                           "VALUES (?, ?)";
        
        try
        {
            ps = conn.prepareStatement(query);
            bookPS = conn.prepareStatement(bookQuery);
            
            for (int i = 0; i < ord.getBooksOrdered().size(); i++)
            {
                bookPS.setInt(1, ord.getBooksOrdered().get(i).getBookID());
                bookPS.setInt(2, ord.getOrderID());
                
                bookPS.executeUpdate();
            }
            
            ps.setInt(1, ord.getOrderID());
            ps.setDouble(2, ord.getTotalCostNumberFormat());
            ps.setInt(3, ord.getUserID());
            
            return ps.executeUpdate();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closePreparedStatement(bookPS);
            pool.freeConnection(conn);
        }
    }
    
    public static ArrayList<Book> selectBooksOrdered(int orderID)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Book, OrderBook " +
                       "WHERE Book.BookID = OrderBook.BookID " +
                       "AND OrderBook.OrderID = ?";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderID);
            rs = ps.executeQuery();
            ArrayList<Book> books = new ArrayList<Book>();
            Book book = null;
            
            while (rs.next())
            {
                book = new Book();
                book.setBookID(rs.getInt("BookID"));
                book.setTitle(rs.getString("Title"));
                book.setAuthor(rs.getString("Author"));
                book.setCategory(rs.getString("Category"));
                book.setPrice(rs.getDouble("Price"));
                
                books.add(book);
            }
            return books;
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
    }
}
