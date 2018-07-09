/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package books.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import books.objects.User;
import books.database.DatabaseIO;

/**
 *
 * @author Ethan
 */
public class LoginServlet extends HttpServlet {

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
        
        String logout = request.getParameter("logout");
        
        String errorMessage = "";
        String url = "";
        
        synchronized(session)
        {
            if (logout != null) //if the user is logging out
            {
                session.setAttribute("currentUser", null);
                session.setAttribute("cart", null);
                url = "/index.jsp";
            }
            else
            {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                User currentUser = null;

                if (DatabaseIO.userExists(username))
                {
                    currentUser = DatabaseIO.selectUser(username);

                    if (password.equals(currentUser.getPassword()))
                    {
                        url = "/displayBooks";
                        session.setAttribute("currentUser", currentUser);
                    }
                    else
                    {
                        errorMessage = "Invalid password";
                        url = "/index.jsp";
                    }
                }
                else
                {
                    errorMessage = "User does not exist";
                    url = "/index.jsp";
                }

                session.setAttribute("errorMessage", errorMessage);
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
