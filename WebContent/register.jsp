<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
注册：<br>
<form action="/AAAA/RegisterServlet" method="post">
	用户名：<input type="text" name="yusername"><br>
	密码：<input type="password" name="ypassword"><br>
	邮箱：<input type="text" name="ymail"><br>
	权限:<input type="radio" value="0" name="yperm">管理员</input><br>
	<input type="radio" value="1" name="yperm">开发者</input><br>
	<input type="submit" value="登录">

</form>
</body>
</html>