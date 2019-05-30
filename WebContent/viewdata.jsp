<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions" %> <% String ProjectPath =
request.getContextPath(); String basePath =
request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ProjectPath+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>YiSoo</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="static/css/fileinput.min.css" />
    <link rel="stylesheet" href="static/layui/css/layui.css" />
    <link rel="stylesheet" href="static/css/bootstrap.css" />

    <style>
    .all-bg{
	
	background-image: url(./static/img/yisoo-bg.jpg);
    background-attachment:fixed;
	background-repeat:no-repeat;
}
	.brand {
	    margin-top: 10vh;
	    color: #fff;
	    text-align: center;
	}
    </style>
  </head>
  <body class="all-bg">
    <nav class="navbar navbar-collapse">
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
                <li><a href="airfile.jsp">文件快传</a></li>
                <li role="separator" class="divider"></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>


      <div class="container">
        <div class="row">
          <div class="col-md-offset-3 col-md-6">
            <div class="brand">
              <h1 id="projectid">项目未知异常</h1>
              <br />
              <p id="projectps">404</p>
              <br />
              <p id="projecttime">404</p>
              <br />
            </div>
          </div>
          <div class="col-md-offset-2 col-md-8">
            <table id="viewsubmit" lay-filter="tableFilter"></table>

          </div>
        </div>
      </div>


    <script src="static/js/jquery.min.js"></script>
    <script src="static/js/bootstrap.js"></script>
    <script src="static/js/fileinput.min.js"></script>
    <script src="static/js/locales/zh.js"></script>
    <script src="static/layui/layui.js"></script>
    <script>
      //初始化页面参数
      var fromData = new Object();
      var aParams = document.location.search.substr(1).split("&");
      for (i = 0; i < aParams.length; i++) {
        aParam = aParams[i].split("=");
        fromData[aParam[0]] = aParam[1];
      }
      //console.log(fromData);

      // 把此参数传到后台，获取项目信息
      //得到项目信息
      var pdata;



      $.ajax({
        url: "UploadServer",
        type: "POST",
        data: fromData,
        dataType: "json",
        success: function(re) {
          if (re.status === "0") {
            location.href = "404.jsp/?error=项目未启动";
          }else{
            pdata = re;
            $("#projectid").html(re.projectname);
            $("#projectps").html(re.projectps);
            $("#projecttime").html("开始日期："+re.starttime+ " 截止日期：" + re.endtime);
          }
          console.log(pdata);
        }
      });



      layui.use("table", function() {
          var table = layui.table;
          //第一个实例
          var viewGroupTable = table.render({
                  elem: "#viewsubmit",
                  height: 550,
                  url:"RealTimeInterface?projectid="+pdata.projectid,
                  cols: [
                    [
                    { field: "grade", title: "组", width: 200},
                      { field: "number", title: "序号", width: 200,sort:true},
                      { field: "name", title: "姓名", width: 180},
                      { field: "committime", title: "提交时间", width: 200,sort:true},
                      { field: "iscommit", title: "是否提交", width: 200,sort:true}
                      
                    ]
                  ]
                  ,skin: 'row' //表格风格
                  ,even: true
                  ,page: false //是否显示分页
          });
        });
    </script>


  </body>
</html>
