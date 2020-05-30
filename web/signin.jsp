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
    <title>用户登录 - Java语言实验报告提交</title>

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
    <form class="form-signin">
      <img class="mb-4" src="img/logo2.png" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Java语言实验报告<br>提交系统</h1>
      <input type="studentid" id="inputStudentID" class="form-control" placeholder="学号" required autofocus>
      <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
      <div class="checkbox mb-3">
        <input type="checkbox" value="remember-me"> 下次自动登录
      </div>
      <!--
      <button class="btn btn-lg btn-success btn-block" type="submit">登录</button>
      -->
      <a class="btn btn-md btn-success btn-block" href="upload.jsp">登录</a>
      <ul class="list-inline list-signin">
        <li class="list-inline-item"><a href="signup.jsp">新用户注册</a></li>
        <li class="list-inline-item"><a href="forget.jsp">忘记密码</a></li>
      </ul>
      <!--
      <p class="mt-5 mb-3 text-muted">&copy; 2020 广州大学 版权所有</p>
      -->
    </form>
  </body>

</html>