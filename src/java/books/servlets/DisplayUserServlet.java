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
public class DisplayUserServlet extends HttpServlet {

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
        
        String username = request.getParameter("username");
        String delete = request.getParameter("delete");
        
        HttpSession session = request.getSession();
        
        String url = "";
        
        synchronized(session)
        {
            User user;
            
            if (delete != null)
            {
                user = DatabaseIO.selectUser(delete);
                url = "/deleteuser.jsp";
            }
            else
            {
                url = "/user.jsp";
                
                if (username == null)
                {
                    user = new User();
                }
                else
                {
                    user = DatabaseIO.selectUser(username);
                }
            }
            
            session.setAttribute("user", user);
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
