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
public class DisplayOrdersTag extends BodyTagSupport
{
    private ArrayList<Order> orders;
    private Iterator<Order> ordIter;
    
    @Override
    public int doStartTag() throws JspException
    {
        orders = (ArrayList)pageContext.findAttribute("orders");
        
        if (orders.size() <= 0)
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
        ordIter = orders.iterator();
        
        if (ordIter.hasNext())
        {
            setOrderAttributes(ordIter.next());
        }
    }
    
    @Override
    public int doAfterBody() throws JspException
    {
        try
        {
            if (ordIter.hasNext())
            {
                setOrderAttributes(ordIter.next());
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
    
    private void setOrderAttributes(Order ord)
    {
        pageContext.setAttribute("orderID", ord.getOrderID());
        pageContext.setAttribute("orderDate", ord.getOrderDate());
        pageContext.setAttribute("totalCost", ord.getTotalCostCurrencyFormat());
        pageContext.setAttribute("userID", ord.getUserID());
    }
}
