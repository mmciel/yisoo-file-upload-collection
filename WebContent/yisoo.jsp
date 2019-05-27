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

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

    <!-- 引入 Bootstrap -->
	<!-- <link rel="stylesheet" href="static/css/bootstrap.css"> -->
    <link rel="stylesheet" href="static/css/components.css" />
    <link rel="stylesheet" href="static/css/fileinput.min.css" />

  </head>
  <body class="all-bg">

    <div class="wrapper ">
        <!--header section-->
        <section class="hero-header">
            <div class="container ">
                <div class="row">
                    <div class="col-md-8 offset-md-2">
                        <div class="brand ">
                        <h1 id="projectid"></h1>
                        <p id="projectps">89</p>
                        <p id="time"></p>
                        <select id="group" class="selectpicker show-tick form-control" data-live-search="true">
                                <option>请选择</option>
                        </select>
                        <input type="file" class="file" id="UserFile" /><br>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>



    <script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
    <script src="static/js/fileinput.min.js"></script>
    <script>
    //初始化页面参数
    var fromData = new Object;
    var aParams = document.location.search.substr(1).split("&");
    for (i = 0; i < aParams.length; i++) {
    　　aParam = aParams[i].split("=");
    　　fromData[aParam[0]] = aParam[1];
    }
    //console.log(fromData);
    // 把此参数传到后台，获取项目信息
    $.ajax({
        url: "UploadServer",
        type: "POST",
        data: fromData,
        dataType: "json",
        success: function(re){
            console.log(re);
            $('#projectid').html(re.projectname);
            $('#projectps').html(re.projectps);
             
        }

    });
    </script>

</body>
</html>
