<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<link href=".\static\css\bootstrap.css" rel="stylesheet" />
	<link rel="stylesheet" href="static/css/bootstrap.css">
	<link rel="stylesheet" href="static/css/daterangepicker.css">
	<link rel="stylesheet" href="static/layui/css/layui.css">
  </head>
  <body>
			<nav class="navbar navbar-default navbar-static-top">
					<div class="container">
						<div class="navbar-header">
							<a class="navbar-brand" href="#">YiSoo</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li class="active"><a href="#">主页</a></li>
								<li><a href="#about">关于</a></li>
								<li><a href="#contact">更新</a></li>
								<li class="dropdown">
									<a
										href="#"
										class="dropdown-toggle"
										data-toggle="dropdown"
										role="button"
										aria-haspopup="true"
										aria-expanded="false"
										>功能 <span class="caret"></span
									></a>
									<ul class="dropdown-menu">
												<li role="separator" class="divider"></li>
										<li><a href="#">文件收集</a></li>
										<li role="separator" class="divider"></li>
										<li><a href="#">文件快传</a></li>
										<li role="separator" class="divider"></li>
									</ul>
								</li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
								<li>
										<input  type="button" class="btn btn-primary" data-toggle="modal" data-target="#LoginModal" id="user" name="user" value="登录" onclick="userConsole()">
								</li>
		
							</ul>
						</div>
					</div>
				</nav>
		
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="LoginModal" tabindex="-1" role="dialog" aria-labelledby="LoginModalLabel" aria-hidden="true">
						<div class="modal-dialog">
								<div class="modal-content">
										<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
												<h4 class="modal-title" id="LoginModalLabel">登录YiSoo</h4>
										</div>
						<!--登陆框中间部分(from表单)-->
						<div class="modal-body">
										<form action="${ProjectPath }LoginServlet" method="post" class="form-horizontal">
												<!--用户框-->
												<div class="form-group">
														<label for="username" class="col-sm-2 control-label">用户名</label>
														<div class="col-sm-10">
																<input type="text" class="form-control" name="yusername" id="username" placeholder="账户" required="required">
														</div>
												</div>
												<!--密码框-->
												<div class="form-group">
														<label for="password" class="col-sm-2 control-label" >密码</label>
														<div class="col-sm-10">
																<input type="password" class="form-control" name="ypassword" id="password" placeholder="密码" required="required">
														</div>
												</div>
												<!--记住密码-->
												<!-- <div class="form-group">
														<div class="col-sm-offset-2 col-sm-10">
																<div class="checkbox">
																		<label>
																				<input type="checkbox"> 记住密码
																		</label>
																</div>
														</div>
												</div> -->
												<!--登陆按钮-->
												<div class="form-group">
														<div class="col-sm-offset-2 col-sm-10">
																<button type="submit" class="btn btn-primary">登录</button>
																<button type="button" class="btn btn-default" onclick="reg()">注册</button>
														</div>
												</div>
										</form>
						</div>	
								</div><!-- /.modal-content -->
						</div><!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
	

	<div class="col-md-6 col-md-offset-3">
		<div class="form-bottom" >
				<form action="${ProjectPath }RegisterServlet" method="post" class="form-horizontal">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="username" id="username" placeholder="账户" required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label" >密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="password" id="password" placeholder="密码" required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label" >邮箱</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="email" id="email" placeholder="邮箱" required="required">
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




  <script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/moment.min.js"></script>
	<script src="static/js/daterangepicker.js"></script>
	<script src="static/layui/layui.js"></script>
	<script src="static/js/tools.js"></script>

</body>
</html>





	