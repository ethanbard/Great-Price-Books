/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package books.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import books.objects.Book;
import java.io.*;
import java.util.*;
import javax.servlet.jsp.JspWriter;

/**
 *
 * @author Ethan
 */
public class DisplayCartTag extends BodyTagSupport
{
    private ArrayList<Book> cart;
    private Iterator<Book> cartIter;
    
    //When removing a book from the cart, this variable will give the
    //cart array's remove function the correct index
    private int cartIndex = 0;
    
    @Override
    public int doStartTag() throws JspException
    {
        cart = (ArrayList)pageContext.findAttribute("cart");
        
        if (cart.size() <= 0)
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
        cartIter = cart.iterator();
        
        if (cartIter.hasNext())
        {
            setCartAttributes(cartIter.next());
        }
    }
    
    @Override
    public int doAfterBody() throws JspException
    {
        try
        {
            if (cartIter.hasNext())
            {
                setCartAttributes(cartIter.next());
                return EVAL_BODY_AGAIN;
            }
            else
            {
                JspWriter out = bodyContent.getEnclosingWriter();
                bodyContent.writeOut(out);
                cartIndex = 0; //reset the cart index
                return SKIP_BODY;
            }
        }
        catch (IOException ioe)
        {
            return SKIP_BODY;
        }
    }
    
    private void setCartAttributes(Book book)
    {
        pageContext.setAttribute("cartIndex", cartIndex);
        pageContext.setAttribute("title", book.getTitle());
        pageContext.setAttribute("author", book.getAuthor());
        pageContext.setAttribute("category", book.getCategory());
        pageContext.setAttribute("priceCurrencyFormat", book.getPriceCurrencyFormat());
        
        cartIndex++;
    }
}