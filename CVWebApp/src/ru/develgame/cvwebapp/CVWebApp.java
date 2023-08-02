/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.develgame.cvwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pasca
 */
public class CVWebApp extends HttpServlet {

    /**
     * Processes requests for <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (CV.getName() == null) {
            CV.setName("Username");
        }
        if (CV.getEmail() == null) {
            CV.setEmail("user@example.com");
        }
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html><head><title>CVWebApp</title></head>");
            out.print("<body><h1>");
            out.print(CV.getName());
            out.println("</h1>");
            
            out.println("<h2>Summary</h2>");
            
            out.print("<b>E-Mail: </b>");
            out.println(CV.getEmail());
            out.print("</br>");
            
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }
}
