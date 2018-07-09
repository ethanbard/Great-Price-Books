/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package books.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import books.objects.*;
import books.database.DatabaseIO;

/**
 *
 * @author Ethan
 */
public class UpdateDatabaseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        ServletContext context = getServletContext();
        
        HttpSession session = request.getSession();
        
        String url = "";
        String errorMessage = "";
        
        String bookID = request.getParameter("bookID");
        String username = request.getParameter("username");
        String delete = request.getParameter("delete");
        String order = request.getParameter("orderID");
        
        synchronized(session)
        {
            if (bookID != null)
            {
                Book b = (Book)session.getAttribute("book");
                
                if (delete != null)
                {
                    //delete the book from the database
                    DatabaseIO.deleteBook(b);
                    
                    url = "/displayBooks";
                }
                else
                {
                    b.setBookID(Integer.parseInt(request.getParameter("bookID")));
                    b.setTitle(request.getParameter("title"));
                    b.setAuthor(request.getParameter("author"));
                    b.setCategory(request.getParameter("category"));

                    //validate the user enteries
                    try
                    {
                        b.setPrice(Double.parseDouble(request.getParameter("price")));

                        if (b.getTitle().equals("") || b.getAuthor().equals("") || 
                            b.getCategory().equals("") || b.getPriceCurrencyFormat().equals(""))
                        {
                            errorMessage = "Please enter information for all fields";
                            url = "/book.jsp";
                        }
                        else if (b.getPriceNumberFormat() < 0)
                        {
                            errorMessage = "Price cannot be negative";
                            url = "/book.jsp";
                        }
                        else
                        {
                            url = "/displayBooks";

                            if (DatabaseIO.bookExists(b.getBookID()))
                            {
                                //save the changes to the existing book
                                DatabaseIO.updateBook(b);
                            }
                            else //adding a new book to the database
                            {
                                DatabaseIO.insertBook(b);
                            }
                        }
                    }
                    catch(NumberFormatException nfe)
                    {
                        errorMessage = "Price must be a decimal";
                        url = "/book.jsp";
                    }
                    
                    session.setAttribute("errorMessage", errorMessage);
                }
            }
            else if (username != null)
            {
                User u = (User)session.getAttribute("currentUser");
                
                if (u == null)
                {
                    u = new User();
                }
                
                if (delete != null)
                {
                    u = DatabaseIO.selectUser(username);
                    //delete the user from the database
                    DatabaseIO.deleteUser(u);
                    
                    url = "/displayUsers";
                }
                else
                {
                    u.setUserID(Integer.parseInt(request.getParameter("userID")));
                    u.setFirstName(request.getParameter("firstName"));
                    u.setLastName(request.getParameter("lastName"));
                    u.setUserName(request.getParameter("userName"));
                    u.setPassword(request.getParameter("password"));
                    u.setEmailAddress(request.getParameter("emailAddress"));
                    u.setUserType(request.getParameter("userType"));

                    //validate the user enteries
                    if (u.getFirstName().equals("") || 
                            u.getLastName().equals("") || 
                            u.getUserName().equals("") ||
                            u.getPassword().equals("") ||
                            u.getEmailAddress().equals(""))
                    {
                        errorMessage = "Please enter information for all fields";
                        url = "/user.jsp";
                    }
                    else
                    {
                        url = "/displayBooks";

                        if (DatabaseIO.userExists(u.getUserName()))
                        {
                            //save the changes to the existing user
                            DatabaseIO.updateUser(u);
                        }
                        else //adding a new user to the database
                        {
                            DatabaseIO.insertUser(u);
                        }
                        
                        session.setAttribute("currentUser", u);
                    }
                }
                
                session.setAttribute("errorMessage", errorMessage);
            }
            else //save the user's order to the database
            {
                url = "/displayBooks";
                
                ArrayList<Book> booksOrdered = (ArrayList<Book>)session.getAttribute("cart");
                double total = 0;
                User currentUser = (User)session.getAttribute("currentUser");
                int orderID = Integer.parseInt(order);
                
                //Calculate the total cost of the books ordered
                for (int i = 0; i < booksOrdered.size(); i++)
                {
                    total += booksOrdered.get(i).getPriceNumberFormat();
                }
                
                Order ord = new Order(orderID, "", total, currentUser.getUserID(), booksOrdered);
                
                DatabaseIO.insertOrder(ord);
                
                //reset the cart attribute
                session.setAttribute("cart", null);
            }
        }
        
        RequestDispatcher dispatcher = context.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
