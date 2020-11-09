package com.senyang.day15.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo01ServletContext")
public class Demo01ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        ServletContext servletContext1 = this.getServletContext();
        System.out.println(servletContext == servletContext1);

        String fileName = "a.jpg";
        String mimeType = servletContext.getMimeType(fileName);
        System.out.println(mimeType);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
