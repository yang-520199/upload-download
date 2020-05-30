package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Value_lableServlet",urlPatterns = {"/Value_lableServlet.do"})
public class Value_lableServlet extends HttpServlet {
    Connection connection=null;
    public int user_id;
    String message1,message2,message3;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动连接失败！");
            e.printStackTrace();
        }
        try{
            String url="jdbc:mysql://localhost:3306/report?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String user="root";
            String password="yx522732";
            connection= DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            System.out.println("连接失败！");
            e.printStackTrace();
        }
        String sql="select user_id from user where student_no=?";
        String student_no=request.getParameter("id");
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,student_no);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                user_id=resultSet.getInt(1);
                System.out.println(user_id);
            }
            String sql1="select * from file where user_id=? and file_num=?";
            PreparedStatement preparedStatement1=connection.prepareStatement(sql1);
            preparedStatement1.setInt(1,user_id);
            preparedStatement1.setInt(2,1);
            ResultSet resultSet1=preparedStatement1.executeQuery();
            if (resultSet1.next()){
                message1="已提交";

            }else {
                message1="未提交";

            }
            String sql2="select * from file where user_id=? and file_num=?";
            PreparedStatement preparedStatement2=connection.prepareStatement(sql2);
            preparedStatement2.setInt(1,user_id);
            preparedStatement2.setInt(2,2);
            ResultSet resultSet2=preparedStatement2.executeQuery();
            if (resultSet2.next()){
                message2="已提交";
            }else {
                message2="未提交";
            }
            String sql3="select * from file where user_id=? and file_num=?";
            PreparedStatement preparedStatement3=connection.prepareStatement(sql3);
            preparedStatement3.setInt(1,user_id);
            preparedStatement3.setInt(2,3);
            ResultSet resultSet3=preparedStatement3.executeQuery();
            if (resultSet3.next()){
                message3="已提交";
            }else {
                message3="未提交";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");
        PrintWriter out=response.getWriter();
        request.setAttribute("message1",message1);
        out.println("<response>");
        out.println("<message>"+message1+"</message>");
        out.println("<message>"+message2+"</message>");
        out.println("<message>"+message3+"</message>");
        out.println("</response>");

    }
}
