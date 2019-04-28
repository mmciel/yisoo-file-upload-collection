<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String ProjectPath = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ProjectPath+"/";
%>
<!DOCTYPE html>
<html>
  <head>
	<title>YiSoo</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- 引入 Bootstrap -->
	<link href="..\static\css\bootstrap.css" rel="stylesheet" />
  </head>
  <body>

	<div class="col-md-6 col-md-offset-3">
		<div class="form-bottom" >
				<form action="${ProjectPath }RegisterServlet" method="post" class="form-horizontal">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="username" placeholder="账户" required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label" >密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password" placeholder="密码" required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label" >邮箱</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="email" placeholder="邮箱" required="required">
						</div>
					</div>
					<div class="form-group">
							<label class="col-sm-2 control-label" >权限</label>
							<div class="col-sm-10">
								<input type="radio" value="0" name="yperm">管理员</input>
								<input type="radio" value="1" name="yperm">开发者</input><br>
							</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary">注册</button>
						</div>
					</div>
				</form>
		</div>
	</div>

	<script src="../static/js/jquery.min.js"></script>
	<script src="../static/js/bootstrap.js"></script>
	<script>
		
	</script>

</body>
</html>
	