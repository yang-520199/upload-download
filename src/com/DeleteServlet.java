package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DeleteServlet",urlPatterns = {"/DeleteServlet.do"})
public class DeleteServlet extends HttpServlet {
    public Connection connection=null;
    public int stu;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String num=request.getParameter("file_num");
        int file_num=Integer.parseInt(num);
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
            System.out.println("连接失败");
            e.printStackTrace();
        }
       String student_no= request.getParameter("id");

        try {
            String sql1="select user_id from user where student_no=?";
            PreparedStatement preparedStatement1=connection.prepareStatement(sql1);
            preparedStatement1.setString(1,student_no);
            ResultSet rs=preparedStatement1.executeQuery();
            while (rs.next()){
                stu=rs.getInt(1);
            }
        } catch (SQLException throwables) {
            System.out.println("出错");
            throwables.printStackTrace();
        }
        try {
            String sql="delete from file where user_id=? and file_num=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,stu);
            preparedStatement.setInt(2,file_num);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
