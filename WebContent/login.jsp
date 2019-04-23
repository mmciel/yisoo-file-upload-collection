<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String ProjectPath = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ProjectPath+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	-----------------------------------------------------<br>
登录：<br>
<form action="${ProjectPath }LoginServlet" method="post">
	用户名：<input type="text" name="yusername"><br>
	密码：<input type="password" name="ypassword"><br>
	<input type="submit" value="登录">

</form>
</body>
</html>