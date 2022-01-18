/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ca.sait.calculators.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andy Diep
 */
@WebServlet(name = "ArithmeticCalculatorServlet", urlPatterns = {"/arithmetic"})
public class ArithmeticCalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("result", "---"); 
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       String firstnum = request.getParameter("firstnum");
       String secondnum = request.getParameter("secondnum");

       int result;
       
    if(firstnum != null && secondnum != null) {
        
    try {
        if (request.getParameter("calculate").equals("add")) {
            result = Integer.parseInt(firstnum) + Integer.parseInt(secondnum);
            request.setAttribute("result", result);

        } else if (request.getParameter("calculate").equals("minus")) {
            result = Integer.parseInt(firstnum) - Integer.parseInt(secondnum);
            request.setAttribute("result", result);

        } else if (request.getParameter("calculate").equals("multiply")) {
            result = Integer.parseInt(firstnum) * Integer.parseInt(secondnum);
            request.setAttribute("result", result);

        } else if (request.getParameter("calculate").equals("divide")) {
            result = Integer.parseInt(firstnum) / Integer.parseInt(secondnum);
            request.setAttribute("result", result);
        }
    
    } catch (Exception ex) {
            request.setAttribute("result", "Invalid");
    }
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    }
}
