/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.develgame.cvwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.microedition.io.SocketConnection;
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html><head><title>CVWebApp</title></head>");
            out.println("<body><h1>CVWebApp</h1>");
            out.println("Hello from ru.develgame.cvwebapp.CVWebApp to");
            out.println("AAAAAA");
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }
}
