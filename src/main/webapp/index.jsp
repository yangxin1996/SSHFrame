<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>

  </head>
  
  <body>
  	<form action="${pageContext.request.contextPath }/login.action" method="post">
  	${error}
    <input type="text" name="id">
    <input type="password" name="password">
    <input type="submit" value="提交">  	
  	</form>
  </body>
</html>
