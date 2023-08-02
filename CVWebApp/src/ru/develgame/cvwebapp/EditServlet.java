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
 *
 * @author pasca
 */
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html><head><title>Edit CV</title></head>");
            out.println("<body><h1>Edit CV</h1>");
            
            out.println("<form method=\"post\" action=\"/cvwebapp/edit\">");
            out.println("<table border=0>");
            
            out.println("<tr><td>Name:</td>");
            out.print("<td><input type=\"text\" name=\"name\""); 
            out.print(" value=\"");
            out.print(CV.getName());
            out.println("\"></input></td></tr>");
            
            out.println("<tr><td>E-Mail:</td>");
            out.print("<td><input type=\"text\" name=\"email\""); 
            out.print(" value=\"");
            out.print(CV.getEmail());
            out.println("\"></input></td></tr>");
            
            out.println("<tr><td>&nbsp;</td>");
            out.print("<td><input type=\"submit\" value=\"Edit\"></input></td></tr>");
            
            out.println("</table>");
            out.println("</form>");
       
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CV.setName(req.getParameter("name"));
        CV.setEmail(req.getParameter("email"));
    }
    
}
