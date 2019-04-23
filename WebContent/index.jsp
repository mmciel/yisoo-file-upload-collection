<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

-----------------------------------------------------<br>
<div>
	<input type="button" id="user" name="user" value="登录" onclick="Bonclick()">
</div>
-----------------------------------------------------<br>
<script type="text/javascript">
	var user = document.getElementById('user');
	if("${sessionScope.username}".length == 0 ){
		user.value  = "登录";
	}else{
		user.value  = "${sessionScope.username}";
	}

	function Bonclick(){
		if("${sessionScope.username}".length == 0 ){
			window.location.href="login.jsp";
		}else{
			window.location.href="main.jsp";
		}
	}
</script>

</body>
</html>