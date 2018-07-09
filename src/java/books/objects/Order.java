/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package books.objects;

import java.util.*;
import java.text.NumberFormat;
import books.objects.Book;

/**
 *
 * @author Ethan
 */
public class Order 
{
    private int orderID;
    private String orderDate;
    private double totalCost;
    private int userID;
    private ArrayList<Book> booksOrdered;
    
    public Order()
    {
        orderID = 0;
        orderDate = "";
        totalCost = 0;
        userID = 0;
        booksOrdered = null;
    }
    
    public Order(int id, String od, double tc, int uid, ArrayList<Book> b)
    {
        orderID = id;
        orderDate = od;
        totalCost = tc;
        userID = uid;
        booksOrdered = b;
    }
    
    public void setOrderID(int id)
    {
        orderID = id;
    }
    
    public int getOrderID()
    {
        return orderID;
    }
    
    public void setOrderDate(String od)
    {
        orderDate = od;
    }
    
    public String getOrderDate()
    {
        return orderDate;
    }
    
    public void setTotalCost(double tc)
    {
        totalCost = tc;
    }
    
    public double getTotalCostNumberFormat()
    {
        return totalCost;
    }
    
    public String getTotalCostCurrencyFormat()
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String currency = nf.format(totalCost);
        return currency;
    }
    
    public void setUserID(int id)
    {
        userID = id;
    }
    
    public int getUserID()
    {
        return userID;
    }
    
    public void setBooksOrdered(ArrayList<Book> b)
    {
        booksOrdered = b;
    }
    
    public ArrayList<Book> getBooksOrdered()
    {
        return booksOrdered;
    }
    
    public void addBookToOrder(Book b)
    {
        booksOrdered.add(b);
    }
    
    public Book getBookFromOrder(int i)
    {
        return booksOrdered.get(i);
    }
}
