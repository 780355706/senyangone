package com.senyang.day15.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/caseServlet")
public class CaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取要下载的文件名
        String fileName = request.getParameter("fileName");
        //2.获取ServletContext对象
        ServletContext servletContext = request.getServletContext();
        //获取文件的真实路径
        String realPath = servletContext.getRealPath(fileName);
        FileInputStream fis =  new FileInputStream(realPath);
        //设置响应头
        //设置响应数据格式
        String mimeType = servletContext.getMimeType(fileName);
        response.setContentType(mimeType);
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        //获取输出流
        ServletOutputStream sos = response.getOutputStream();
        //将文件读取到内存并将文件响应到浏览器
        byte[] bytes = new byte[8 * 1024];
        int len = 0;
        while((len = fis.read(bytes)) != -1) {
            sos.write(bytes, 0, len);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
