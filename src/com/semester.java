package com;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class semester {
    private static int user_id;

    public static void main(String args[]) throws SQLException {
        String message1,message2,message3;

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        Date date = new Date(System.currentTimeMillis());
        List<Integer>list=new ArrayList<Integer>();

        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动连接失败");
        }
        try {
            String url="jdbc:mysql://localhost:3306/report?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String user="root";
            String password="yx522732";
            connection=DriverManager.getConnection(url,user,password);

        } catch (SQLException throwables) {
            System.out.println("连接失败");
            throwables.printStackTrace();
        }
//        System.out.println("连接失败");


        try {
            String sql="select count(*) from setting";
            PreparedStatement pstm=connection.prepareStatement(sql);
            ResultSet rs= pstm.executeQuery();
            if (rs.next()){
              int last=rs.getInt(1);
              System.out.println(last-1);
              String sql1="select * from setting limit "+(last-1)+","+last;
              PreparedStatement pstm1=connection.prepareStatement(sql1);
              ResultSet rs1=pstm1.executeQuery();
              while (rs1.next()){
                String  xueqi=rs1.getNString(3);
                System.out.println(xueqi);


                  System.out.println(formatter.format(date));
                  String name="Java语言实验报告_学号_名字_班级 实验报告3.pdf";
                  System.out.println(name.length());
                  int a=name.length()-5;
                  String index=name.substring(a,a+1);
                  System.out.println(index);
                  System.out.println(name.substring(25,26));
                  int b= Integer.parseInt(index);
                  list.add(b);
                  list.add(2);
                  Collections.sort(list);


                  System.out.println(name);

                  System.out.println(list);
              }
            }
           for (int i=0;i<list.size();i++){
               System.out.println(list.get(i));
               String sql1="INSERT INTO file (user_id,file_num,file_time,file_address) VALUE(?,?,?,?)";
              Date date1=new Date(System.currentTimeMillis());
               java.sql.Timestamp sql_time=new java.sql.Timestamp(date1.getTime());
               System.out.println(sql_time);
//               java.sql.Date sql_date=new java.sql.Date(date.getTime());
               PreparedStatement pstm1=connection.prepareStatement(sql1);
               pstm1.setInt(1,2);
               pstm1.setInt(2,list.get(i));
               pstm1.setTimestamp(3, sql_time);
               pstm1.setString(4,"F:\\test\\out\\artifacts\\test_war_exploded\\WEB-INF\\2020-2021-02");
               pstm1.executeUpdate();
           }
//            System.out.println(list);
//            System.out.println(list.get(1));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql="select file_address from file where user_id = ?";
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setInt(1,1);
        ResultSet rs=pstm.executeQuery();
        while (rs.next()){
            String filepath = rs.getNString(1);
            System.out.println(filepath);
        }
//        String sql1="select * from file where user_id=? and file_num=?";
//        PreparedStatement preparedStatement=connection.prepareStatement(sql1);
//        preparedStatement.setInt(1,1);
//        preparedStatement.setInt(2,2);
//        ResultSet resultSet=preparedStatement.executeQuery();
//        if (resultSet.next()){
//            System.out.println("不为空");
//        }else {
//            System.out.println("为空");
//        }

        try {
            String sql4="select user_id from user where student_no=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql4);
            preparedStatement.setString(1, String.valueOf(1706300020));
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
                System.out.println(message1);
            }else {

                message1="未提交";
                System.out.println(message1);
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
        connection.close();
    }



}
