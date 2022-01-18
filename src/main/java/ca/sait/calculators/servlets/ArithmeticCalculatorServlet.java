package ca.sait.calculators.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Andy Diep
 */
@WebServlet(name = "ArithmeticCalculatorServlet", urlPatterns = {"/arithmetic"})
public class ArithmeticCalculatorServlet extends HttpServlet {

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
        if (request.getParameter("first") != null && request.getParameter("second") != null) {
            try {
                //Set variables
                int number1 = Integer.parseInt(request.getParameter("first"));
                int number2 = Integer.parseInt(request.getParameter("second"));

                //If a operator is clicked after inputting first and second number, a result is displayed
                if (request.getParameter("calculate").equals("add")) {
                    request.setAttribute("result", number1 + number2);
                } else if (request.getParameter("calculate").equals("minus")) {
                    request.setAttribute("result", number1 - number2);
                } else if (request.getParameter("calculate").equals("multiply")) {
                    request.setAttribute("result", number1 * number2);
                } else if (request.getParameter("calculate").equals("divide")) {
                    request.setAttribute("result", (double) number1 / number2);
                }
                // If no number is inputted in either input, then "invalid" is displayed as a result
            } catch (Exception ex) {
                request.setAttribute("result", "Invalid");
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }
}
