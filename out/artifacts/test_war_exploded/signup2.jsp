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
    <title>用户注册 - Java语言实验报告提交</title>

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

  <body class="text-center">
    <form class="form-signup">
      <img class="mb-4" src="img/logo2.png" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Java语言实验报告<br>提交系统</h1>
      <div class="mb-3">
        <div class="input-group group-id">
          <div class="input-group-prepend">
            <span class="input-group-text">学号</span>
          </div>
          <input type="text" class="form-control" id="id" placeholder="191192193" readonly>
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
      <div class="mb-3">
        <input type="password1" id="inputPassword" class="form-control" placeholder="设置密码" required autofocus>
        <div class="invalid-feedback">请输入密码！</div>
        <input type="password2" id="inputPassword" class="form-control" placeholder="确认密码" required>
        <div class="invalid-feedback">密码不匹配！</div>
      </div>
      <a class="btn btn-md btn-success btn-block" href="signup3.jsp">下一步</a>
      <a class="btn btn-md btn-success btn-block" href="signup.jsp">返回</a>
      <!--
      <p class="mt-5 mb-3 text-muted">&copy; 2020 广州大学 版权所有</p>
      -->
    </form>
  </body>

</html>