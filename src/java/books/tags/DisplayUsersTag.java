/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package books.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import books.objects.User;
import java.io.*;
import java.util.*;
import javax.servlet.jsp.JspWriter;

/**
 *
 * @author Ethan
 */
public class DisplayUsersTag extends BodyTagSupport
{
    private ArrayList<User> users;
    private Iterator<User> userIter;
    
    @Override
    public int doStartTag() throws JspException
    {
        users = (ArrayList)pageContext.findAttribute("users");
        
        if (users.size() <= 0)
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
        userIter = users.iterator();
        
        if (userIter.hasNext())
        {
            setUserAttributes(userIter.next());
        }
    }
    
    @Override
    public int doAfterBody() throws JspException
    {
        try
        {
            if (userIter.hasNext())
            {
                setUserAttributes(userIter.next());
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
    
    private void setUserAttributes(User user)
    {
        pageContext.setAttribute("userID", user.getUserID());
        pageContext.setAttribute("firstName", user.getFirstName());
        pageContext.setAttribute("lastName", user.getLastName());
        pageContext.setAttribute("userName", user.getUserName());
        pageContext.setAttribute("password", user.getPassword());
        pageContext.setAttribute("emailAddress", user.getEmailAddress());
        pageContext.setAttribute("isAdministrator", user.isAdministrator());
    } 
}
