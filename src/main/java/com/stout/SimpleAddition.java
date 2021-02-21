/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stout;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ragbr
 */
@WebServlet(
        name = "SimpleAddition",
        urlPatterns = "/addition"
)
public class SimpleAddition extends HttpServlet {

    String result;
    String printed1;
    String printed2;
    String noSum;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("numOne") != null || request.getParameter("numTwo") != null) {
            try {
                BigDecimal num1 = new BigDecimal(request.getParameter("numOne"));
                BigDecimal num2 = new BigDecimal(request.getParameter("numTwo"));
                BigDecimal addedResult = num1.add(num2);
                printed1 = num1.toString();
                printed2 = num2.toString();
                result = addedResult.toString();
                noSum = "";
            } catch (Exception ex) {
                printed1 = "";
                printed2 = "";
                result = "";
                noSum = "There is no sum";
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>My Addition Web Servlet</title>");
            out.println("<link href=\"" + request.getContextPath() + "/styles/main.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 id=\"MyHeader\">Basic Addition Servlet Assignment</h1><br>");
            out.println("<p id=\"MyPara\">Please enter two numbers and click the Submit button</p>");
            out.println("<form action=\"addition\" method=\"POST\">");
            out.println("<label for=\"firstnum\">First Number:</label><br>");
            out.println("<input type=\"text\" name=\"numOne\" id=\"yournum\"><br><br>");
            out.println("<label for=\"secondnum\">Second Number:</label><br>");
            out.println("<input type=\"text\" name=\"numTwo\" id=\"yournum\"><br><br>");
            out.println("<input type=\"submit\" value=\"Go\">");
            out.println("<p>RESULT: " + printed1 + " + " + printed2 + " = "
                    + result);
            out.println("</form>");
            out.println("<p>" + noSum + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

}
