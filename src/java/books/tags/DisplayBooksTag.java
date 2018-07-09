/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package books.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import books.objects.*;
import java.io.*;
import java.util.*;
import javax.servlet.jsp.JspWriter;

/**
 *
 * @author Ethan
 */
public class DisplayBooksTag extends BodyTagSupport
{
    private ArrayList<Book> books;
    private Iterator<Book> bookIter;
    private User currentUser;
    
    @Override
    public int doStartTag() throws JspException
    {
        books = (ArrayList)pageContext.findAttribute("books");
        currentUser = (User)pageContext.findAttribute("currentUser");
        
        if (books.size() <= 0)
        {
            return SKIP_BODY;
        }
        else
        {
            return EVAL_BODY_BUFFERED;
        }
    }
    
    @Override
    public void doInitBody() throws JspException
    {
        bookIter = books.iterator();
        
        if (bookIter.hasNext())
        {
            setBookAttributes(bookIter.next());
        }
    }
    
    @Override
    public int doAfterBody() throws JspException
    {
        try
        {
            if (bookIter.hasNext())
            {
                setBookAttributes(bookIter.next());
                return EVAL_BODY_AGAIN;
            }
            else
            {
                JspWriter out = bodyContent.getEnclosingWriter();
                bodyContent.writeOut(out);
                return SKIP_BODY;
            }
        }
        catch (IOException ioe)
        {
            return SKIP_BODY;
        }
    }
    
    private void setBookAttributes(Book book)
    {
        pageContext.setAttribute("bookID", book.getBookID());
        pageContext.setAttribute("title", book.getTitle());
        pageContext.setAttribute("author", book.getAuthor());
        pageContext.setAttribute("category", book.getCategory());
        pageContext.setAttribute("priceCurrencyFormat", book.getPriceCurrencyFormat());
        
        if (currentUser.isAdministrator().equals("Y"))
        {
            String url = "displayBook?bookID=" + book.getBookID();
            pageContext.setAttribute("cartOrEdit", "Edit");
            pageContext.setAttribute("cartOrEditURL", url);
            pageContext.setAttribute("delete", "Delete");
        }
        else
        {
            String url = "cart?bookID=" + book.getBookID();
            pageContext.setAttribute("cartOrEdit", "Add to Cart");
            pageContext.setAttribute("cartOrEditURL", url);
            pageContext.setAttribute("delete", "");
        }
    }    
}
