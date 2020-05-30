package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DownloadServlet",urlPatterns = {"/DownloadServlet.do"})
public class DownloadServlet extends HttpServlet {
    public String xueqi;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.reset();
        Connection connection=null;

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String fileName = request.getParameter("filename");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动启动失败！");
            e.printStackTrace();
        }
        try {
            String url="jdbc:mysql://localhost:3306/report?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String user="root";
            String password="yx522732";
            connection= DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            System.out.println("连接失败！");
            e.printStackTrace();
        }
        String sql1="select count(*) from setting";
        try {
            PreparedStatement pstm=connection.prepareStatement(sql1);
            ResultSet rs= pstm.executeQuery();

            if (rs.next()){
                int rownum=rs.getInt(1);
                String sql="select * from setting limit "+(rownum-1)+","+rownum;
                PreparedStatement pstm1=connection.prepareStatement(sql);
                ResultSet rs1=pstm1.executeQuery();
                while (rs1.next()){
                    xueqi=rs1.getNString(3);
                    System.out.println(xueqi);
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 上传的文件都是保存在/WEB-INF/xueqi名目录下的子目录当中
        String fileSaveRootPath = this.getServletContext().getRealPath("/WEB-INF/"+xueqi);
//        System.out.println(fileSaveRootPath);
        response.setHeader("Content-disposition", "attachment; filename="+fileName);// 设定输出文件头
        // 得到要下载的文件
        File file = new File(fileSaveRootPath + "\\" + fileName);
//        System.out.println(file);
        // 如果文件不存在
        if (!file.exists()) {
            request.setAttribute("message", "您要下载的资源已被删除！！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
//        // 设置响应头，控制浏览器下载该文件
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        // 读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + fileName);
        // 创建输出流
        OutputStream out = response.getOutputStream();
        // 创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        // 循环将输入流中的内容读取到缓冲区当中
        while ((len = in.read(buffer)) > 0) {
            // 输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        // 关闭文件输入流
        in.close();
        // 关闭输出流
        out.close();
    }

}
