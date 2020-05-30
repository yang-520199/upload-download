<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/26
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <c:forEach var="me" items="${fileNameMap}">
    <c:url value="/DownloadServlet.do" var="downurl">
      <c:param name="filename" value="${me.key}"></c:param>
    </c:url>
    ${me.value}<a href="${downurl}">下载</a>
    <br>
  </c:forEach>
<script src="js/Ajax-delete.js"></script>

  </body>
</html>
