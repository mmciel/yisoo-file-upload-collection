<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String ProjectPath = request.getContextPath(); String
basePath =
request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ProjectPath+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.css" />
    <link
      rel="stylesheet"
      type="text/css"
      href="static/css/daterangepicker.css"
    />
    <link rel="stylesheet" href="static/layui/css/layui.css" />

    <!-- <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.css"/> -->
    <!-- <link href="http://cdn.bootcss.com/bootstrap-daterangepicker/2.1.25/daterangepicker.css" rel="stylesheet"> -->
    <!-- <script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script> -->
    <!-- <script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script> -->
    <!-- <script src="http://cdn.bootcss.com/bootstrap-daterangepicker/2.1.25/moment.min.js"></script> -->
    <!-- <script src="http://cdn.bootcss.com/bootstrap-daterangepicker/2.1.25/daterangepicker.js"></script> -->
  
  </head>
  <body>
    当前用户：
    <input
      type="button"
      id="user"
      name="user"
      value="登录"
      onclick="Bonclick()"
    />
    <br />

    -----------------------------------------------------------------------------------------<br />
    项目添加：<br />
    <form>
      项目名称：<input
        type="text"
        id="projectname"
        name="projectname"
      /><br /><br />
      项目描述：<input
        type="text"
        id="projectps"
        name="projectps"
      /><br /><br />
      是否采用名单命名：
      <input type="radio" name="isgroup" id="isgroup1" value="yes" /> 是
      <input type="radio" name="isgroup" id="isgroup2" value="no" />
      否<br /><br />
      <form id="GroupForm" enctype="multipart/form-data">
        <input
          id="GroupFileName"
          type="text"
          name="GroupFileName"
          style="display:none;"
        />
        <input
          id="GroupFile"
          type="file"
          name="GroupFile"
          style="display:none;"
        /><span id="uploadresult"></span>

        <input
          id="GroupBut"
          type="button"
          onclick="UploadGroupData()"
          value="提交"
          style="display:none;"
        />
      </form>
      项目持续时间：<br />

      <input type="text" name="datePicker" id="datePicker" /><br /><br />
      <!-- <button id="reportrange" style="width:350px">
    <span id="searchDateRange"></span>
</button><br><br>
-->

      <input
        type="button"
        id="SubmitBt"
        value="提交"
        onclick="setFormData()"
      /><br />
    </form>
    -----------------------------------------------------------------------------------------<br />
    <table id="data"></table>
    -----------------------------------------------------------------------------------------<br />
    项目发布：
    <input type="button" value="ok" id="temp" name="temp" />

    <script>
      // $(document).ready(function() {
      //   $("#temp").click(function() {});
      // });
    </script>
    
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="static/js/bootstrap.js"></script>
    <script src="static/js/moment.min.js"></script>
    <script src="static/js/daterangepicker.js"></script>
    <script src="static/layui/layui.js"></script>
    <script src="static/js/tools.js"></script>
    <script type="text/javascript">
    var username = "${sessionScope.username}";
        initUser();
    </script>
  </body>
</html>
