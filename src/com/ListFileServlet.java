package com;

import com.mysql.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ListFileServlet",urlPatterns = {"/ListFileServlet.do"})
public class ListFileServlet extends HttpServlet {
    public int stu;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=null;
        String filepath = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
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
            String student_no=request.getParameter("id");
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
            String sql="select file_address from file where user_id = ?";
            PreparedStatement pstm=connection.prepareStatement(sql);
            pstm.setInt(1,stu);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                filepath=rs.getNString(1);
            }
            connection.close();
            Map<String,String>fileNameMap=new HashMap<String, String>();
            list1file(new File(filepath),fileNameMap);
            request.setAttribute("fileNameMap",fileNameMap);
            request.getRequestDispatcher("/index.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void list1file(File file,Map<String,String> map){
        if (!file.isFile()){
            File files[]=file.listFiles();
            for (File f:files){
                list1file(f,map);
            }
        }else {
            map.put(file.getName(),file.getName());
        }

    }
}
