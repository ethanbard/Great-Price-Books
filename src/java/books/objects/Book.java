/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package books.objects;

import java.text.NumberFormat;

/**
 *
 * @author Ethan
 */
public class Book 
{
    private int bookID;
    private String title;
    private String author;
    private String category;
    private double price;
    
    public Book()
    {
        bookID = 0;
        title = "";
        author = "";
        category = "";
        price = 0;
    }
    
    public Book(int id, String t, String a, String c, double p)
    {
        bookID = id;
        title = t;
        author = a;
        category = c;
        price = p;
    }
    
    public void setBookID(int id)
    {
        bookID = id;
    }
    
    public int getBookID()
    {
        return bookID;
    }
    
    public void setTitle(String t)
    {
        title = t;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setAuthor(String a)
    {
        author = a;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public void setCategory(String c)
    {
        category = c;
    }
    
    public String getCategory()
    {
        return category;
    }
    
    public void setPrice(double p)
    {
        price = p;
    }
    
    public double getPriceNumberFormat()
    {
        return price;
    }
    
    public String getPriceCurrencyFormat()
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String currency = nf.format(price);
        return currency;
    }
}
