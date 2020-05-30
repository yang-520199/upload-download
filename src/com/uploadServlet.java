package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.sql.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
@WebServlet(name = "uploadServlet",urlPatterns = {"/uploadServlet.do"})
public class uploadServlet extends HttpServlet {
    List<Integer>filenumlist=new ArrayList<Integer>();
    public int stu_no;
    Connection connection=null;
    String xueqi;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String student_no=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("驱动连接失败！");
            e.printStackTrace();
        }
        try {
            String url="jdbc:mysql://localhost:3306/report?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String user="root";
            String password="yx522732";
            connection=DriverManager.getConnection(url,user,password);
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
//                    System.out.println(xueqi);
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String savepath=this.getServletContext().getRealPath("/WEB-INF/"+xueqi);
        File file=new File(savepath);
        if(!file.exists()&&!file.isDirectory()){
            System.out.println(savepath+"目录不存在，需要创建");
            file.mkdir();
        }
        try{
            //使用Apache组件上传文件
            //创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory=new DiskFileItemFactory();
            //创建一个文件上传解析器
            ServletFileUpload upload=new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //判断提交上来的数据是否是上传表单的数据
            if (!ServletFileUpload.isMultipartContent(request)){
                return;
            }
            //使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem>list=upload.parseRequest(request);
            for (FileItem item:list){
                //如果fileitem中封装的是普通输入项的数据
                if (item.isFormField()){
                    String name=item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value=item.getString("UTF-8");
                    student_no=value;
//                    System.out.println(name+"="+value);
//                    System.out.println(value);

                }else {//如果fileitem中封装的是上传文件
                    //得到上传的文件名称，
                    String filename=item.getName();
//                    System.out.println(filename);
//                    System.out.println(savepath);
                    if (filename==null||filename.trim().equals("")){
                        continue;
                    }
                    filename=filename.substring(filename.lastIndexOf("\\")+1);
//                    System.out.println(filename.length());
                    int search=filename.length()-5;
                    String index=filename.substring(search,search+1);
//                    System.out.println(index);
                    int num=Integer.parseInt(index);
                    filenumlist.add(num);
//                    System.out.println(filename);
                    InputStream in=item.getInputStream();
                    FileOutputStream out=new FileOutputStream(savepath+"\\"+filename);
                    byte buffer[]=new byte[2048];
                    int len=0;
                    while ((len=in.read(buffer))>0){
                        out.write(buffer,0,len);
                    }
                    Collections.sort(filenumlist);
                    in.close();
                    out.close();
                    item.delete();
                }
            }
            String sql3="select user_id from user where student_no=?";
            PreparedStatement pstm=connection.prepareStatement(sql3);
            pstm.setString(1,student_no);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                 stu_no=rs.getInt(1);
//                 System.out.println(stu_no);
            }
            for (int i=0;i<filenumlist.size();i++){
                String sql2="INSERT INTO file (user_id,file_num,file_time,file_address) VALUE(?,?,?,?)";
                Date date=new Date(System.currentTimeMillis());
                Timestamp timestamp=new Timestamp(date.getTime());
                PreparedStatement pstm2=connection.prepareStatement(sql2);
                pstm2.setInt(1,stu_no);
                pstm2.setInt(2,filenumlist.get(i));
                pstm2.setTimestamp(3,timestamp);
                pstm2.setString(4,savepath);
                pstm2.executeUpdate();
            }
            filenumlist.clear();
            connection.close();
        } catch (Exception e) {
            System.out.println("文件上传失败！");
            e.printStackTrace();
        }

        request.getRequestDispatcher("/success.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
