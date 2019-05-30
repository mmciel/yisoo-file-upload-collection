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

    <!-- <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
      integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
      crossorigin="anonymous"
    /> -->

    <!-- 引入 Bootstrap -->
    <!-- <link rel="stylesheet" href="static/css/bootstrap.css"> -->
    <!-- <link rel="stylesheet" href="static/css/components.css" /> -->
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
          <ul class="nav nav-pills navbar-right">
            <li role="presentation"><a id="viewdata" href="#">查看提交情况</a></li>
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
            <form class="layui-form">
              <select
                id="group"
                lay-verify=""
                class="layui-form-selected"
                lay-search
              >
                <option value="null" selected>请选择</option>
              </select>
            </form>
            <br />
            <br />
            <input type="file" class="file" id="UserFile" /><br />
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
      $('#viewdata').attr('href','viewdata.jsp?url='+fromData['url']); 
      //console.log(fromData);

      // 把此参数传到后台，获取项目信息
      //得到项目信息
      var pdata;
      // function initSelect(){
      //   $.ajax({
      //   url: "PersonDataTableInterface"+"?groupkey="+pdata.groupkey,
      //   type: "get",
      //   dataType: "json",
      //   success: function(re) {
      //       for(var temp in re.data){
      //       $("#group").append("<option value='"+ re.data[temp].number +"'>"+re.data[temp].name+"</option>");
      //       }
      //   }
      // });
      // }


      $.ajax({
        url: "UploadServer",
        type: "POST",
        data: fromData,
        dataType: "json",
        success: function(re) {
          if (re.status === "0") {
            location.href = "404.jsp/?error=项目未启动";
          } else if (re.status === "-1") {
            alert("未开始！！！");
            location.href = 'viewdata.jsp?url='+fromData['url'];
          } else if (re.status === "1") {
            alert("已结束！！！");
            location.href = 'viewdata.jsp?url='+fromData['url'];
          } else if (re.status === "2") {
            pdata = re;
            //initSelect();

            $.ajax({
              url: "PersonDataTableInterface"+"?groupkey="+pdata.groupkey,
              type: "get",
              dataType: "json",
              success: function(re) {
                  for(var temp in re.data){
                  $("#group").append("<option value='"+ re.data[temp].number +"'>"+re.data[temp].name+"</option>");
                  }
              }
            });
            $("#projectid").html(re.projectname);
            $("#projectps").html(re.projectps);
            $("#projecttime").html("开始日期："+re.starttime+ " 截止日期：" + re.endtime);
          }
          console.log(pdata);
          
        }
      });
    </script>
    <script>
      $("#UserFile")
        .fileinput({
          language: "zh",
          uploadUrl: "UploadFileServlet",
          //allowedFileExtensions: ["xlsx", "xls"],
          uploadExtraData: function() {
            var obj = {};
            obj.projectid = pdata.projectid;//项目id
            obj.groupkey = pdata.groupkey;//项目组key
            obj.number = $('#group').val();
            return obj;
          },
          uploadAsync: true,
          showUpload: true,
          showCaption: true,
          showPreview: true,
          showRemove: true,
          browseClass: "btn btn-info",
          dropZoneEnabled: false,
          enctype: "multipart/form-data",
          maxFileSize: 10240,
          maxFileCount: 1
        })
        .on("fileuploaded", function(event, data, previewId, index) {
          if (data.response.status == 1) {
            layer.msg('上传成功', {icon: 6});
            console.log("ok");
          } else {
            console.log("no");
          }
        })
        .on("filebatchselected", function(event, files) {
            if($('#group').val() == "null"){
            	layer.msg('请选择姓名', {icon: 6});
	              $(event.target)
	              .fileinput('clear')
	              .fileinput('unlock')
	            $(event.target)
	              .parent()
	              .siblings('.fileinput-remove')
	              .hide()
               
            }
        });
    </script>
    <script>
      //加载样式
      layui.use("form", function() {
        //var form = layui.form;
      });
    </script>
  </body>
</html>
