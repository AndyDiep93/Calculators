package ca.sait.calculators.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *Determine the next age of the person.
 * @author Andy Diep
 */
public class AgeCalculatorServlet extends HttpServlet {
    
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
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
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
        String ageInput = request.getParameter("age");
        
        if(ageInput != null) {
            try {    
                int age = Integer.parseInt(ageInput);
        
                age++;
        
                String message = String.format("You will be %d after your next birthday.", age);
        
                request.setAttribute("message", message);
            }catch (Exception ex) {
                // Age input exists but is not a number.
                request.setAttribute("message", "You must give your current age");
            }
            
        } else {
            // Age input is missing.
            request.setAttribute("message", "You must enter a number.");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }

}
