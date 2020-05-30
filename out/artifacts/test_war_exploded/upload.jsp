<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>上传文件 - Java语言实验报告提交</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="img/favicons/manifest.json">
    <link rel="mask-icon" href="img/favicons/safari-pinned-tab.svg" color="#563d7c">
    <link rel="icon" href="img/favicons/favicon.ico">
    <meta name="msapplication-config" content="img/favicons/browserconfig.xml">
    <meta name="theme-color" content="#563d7c">

    <!-- Custom styles for this template -->
    <link href="css/custom.css" rel="stylesheet">
  </head>

  <body class="text-center"onload="Value_lable()">
    <form class="form-upload" action="uploadServlet.do" enctype="multipart/form-data" method="post">
      <img class="mb-4" src="img/logo2.png" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Java语言实验报告<br>提交系统</h1>
      <div class="mb-3">
        <div class="input-group group-id">
          <div class="input-group-prepend">
            <span class="input-group-text">学号</span>
          </div>
          <input type="text" class="form-control" id="id" value="1706300020" name="student_no" readonly>
        </div>
        <div class="input-group group-name">
          <div class="input-group-prepend">
            <span class="input-group-text">姓名</span>
          </div>
          <input type="text" class="form-control" id="name" placeholder="张三" readonly>
        </div>
        <div class="input-group group-class">
          <div class="input-group-prepend">
            <span class="input-group-text">班级</span>
          </div>
          <input type="text" class="form-control" id="class" placeholder="计科191" readonly>
        </div>
      </div>
      <div class="file-upload">
        <p id="lable1">实验报告1 <label class="badge badge-primary"></label></p>
        <div class="input-group">
          <div class="custom-file">
            <input type="file" class="custom-file-input" id="customFile1" name="file1" multiple="multiple" onchange="check()">
            <label class="custom-file-label" for="customFile1" data-browse="浏览"></label>
          </div>
          <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="button"onclick="listFile()">查看</button>
          </div>
          <div class="input-group-append">
            <button class="btn btn-outline-secondary" type="button"onclick="remove1()">删除</button>
          </div>
        </div>
        <div class="mb-3">
        </div>
        <p id="lable2">实验报告2 <span class="badge badge-primary"></span></p>
        <div class="input-group">
          <div class="custom-file">
            <input type="file" class="custom-file-input" id="customFile2" name="file2" multiple="multiple" onchange="check2()">
            <label class="custom-file-label" for="customFile2" data-browse="浏览"></label>
          </div>
          <div class="input-group-append">
            <button class="btn btn-outline-secondary"onclick="listFile()">查看</button>
          </div>
          <div class="input-group-append">
            <button class="btn btn-outline-secondary" type="button"id="file_num"value="2"onclick="remove2()">删除</button>
          </div>
        </div>
        <div class="mb-3">
        </div>
        <p id="lable3">实验报告3 <span class="badge badge-danger"></span></p>
        <div class="input-group">
          <div class="custom-file">
            <input type="file" class="custom-file-input" id="customFile3" name="file3" multiple="multiple" onchange="check3()" >
            <label class="custom-file-label" for="customFile3" data-browse="浏览"></label>
          </div>
          <div class="input-group-append">
            <button class="btn btn-outline-secondary"onclick="listFile()">查看</button>
          </div>
          <div class="input-group-append">
            <button class="btn btn-outline-secondary" type="button"onclick="remove3()">删除</button>
          </div>
        </div>
        <div class="mb-3">
        </div>
      </div>
      <input type="submit"value="上传" class="btn btn-md btn-secondary btn-block">
      <a class="btn btn-md btn-success btn-block" href="signin.jsp">退出登录</a>
    </form>
    <script src="js/jquery-3.4.1.slim.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/docs.min.js"></script>
    <script src="js/panduan.js"></script>
    <script src="js/Ajax-delete.js"></script>
    <script src="js/Lable_value.js"></script>
  </body>
</html>