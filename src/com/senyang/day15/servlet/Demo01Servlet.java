package com.senyang.day15.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
案例：
    1. 完成重定向；/demo02Servlet
    2. 服务器输出字符数据到浏览器
    3. 服务器输出字节数据到浏览器
    4. 验证码
 */
@WebServlet("/demo01Servlet")
public class Demo01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo01...");
/*
        response.setStatus(302);
        response.setHeader("location", "/day15_response/demo02Servlet");
*/
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        response.sendRedirect(contextPath + "/demo02Servlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
