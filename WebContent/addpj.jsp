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
	<link href="static\css\bootstrap.css" rel="stylesheet" />
	<link rel="stylesheet" href="static/css/bootstrap.css">
	<link rel="stylesheet" href="static/css/daterangepicker.css">
  <link rel="stylesheet" href="static/layui/css/layui.css">
  
  <style type="text/css">
  @media (min-width: 760px) { 
    #ce{
      width: 250px;
      margin-top: 0px;
      z-index: 1;
      position: absolute;
      height: 540px;
    }

    .page_main{
      margin-left: 252px;
      margin-top: 0px;
    }
   }

  
  </style>

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
                <li><a href="airfile.jsp">文件快传</a></li>
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
                    </form>
            </div>	
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->
    <!-- admin管理页面 -->
    <div id="ce" class="navbar-default navbar-collapse">

      <ul class="nav">
        <li>
          <a href="index.html"><span class="glyphicon glyphicon-send"></span> 主页</a>
        </li>
    
        <li>
                <a data-toggle="collapse" data-target="#project-dropdown1" href="#">项目相关<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                  <ul id="project-dropdown1" class="nav collapse">
                    <li><a href="main.jsp"><span class="glyphicon glyphicon-flash"></span>项目浏览</a></li>
                    <li><a href="addpj.jsp"><span class="glyphicon glyphicon-flash"></span>项目添加</a></li>

                    <li><a href="usepj.jsp"><span class="glyphicon glyphicon-flash"></span>项目发布</a></li>
                  </ul>
                </li>
                <li>
                  <a data-toggle="collapse" data-target="#project-dropdown2" href="#">项目监控<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                    <ul id="project-dropdown2" class="nav collapse">
                      <li><a href="uploadnow.jsp"><span class="glyphicon glyphicon-flash"></span>实时提交</a></li>
                      <li><a href="datapjview.jsp"><span class="glyphicon glyphicon-flash"></span>数据分析</a></li>
                      <li><a href="downpj.jsp"><span class="glyphicon glyphicon-flash"></span>项目导出</a></li>
                    </ul>
                </li>
                <li>
                    <a data-toggle="collapse" data-target="#project-dropdown3" href="#">个人信息<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                      <ul id="project-dropdown3" class="nav collapse">
                        <li><a href="userdataupdate.jsp"><span class="glyphicon glyphicon-flash"></span>信息修改</a></li>
                        <li><a href="addgroupdata.jsp"><span class="glyphicon glyphicon-flash"></span>添加人员信息</a></li>
                      </ul>
                  </li>
              </ul>
            </div>
    
    <div class="page_main">
       <div class="container">
         <div class="row col-md-offset-2 col-md-6">
          <form > 
            <div class="form-group">
              <label for="yname">项目名称</label>
              <input type="text" class="form-control" id="yname" placeholder="项目名称">
            </div>
            <div class="form-group">
                <label for="ytext">项目描述</label>
              <textarea class="form-control" id="ytext" rows="3"></textarea>
            </div>
            <div class="form-group">
                <select id="basic" class="selectpicker show-tick form-control" data-live-search="true">
                    <option>请选择项目采用的名单</option>
                    <option value="null" data-subtext="option subtext">无</option>
                  </select>
                <!-- <div class="dropdown">
                    <button class="btn btn-default dropdown-toggle" type="button" id="isgroup" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                      是否采用名单命名文件
                      <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="isgroup" id="groupnametable">
                      <li><a href="#">Action</a></li>
                      <li><a href="#">Another action</a></li>
                      <li><a href="#">Something else here</a></li>
                    </ul>
                  </div> -->
            </div>
            <div class="form-group">
                <label for="datePicker">时间限制</label>
                <input type="text"class="form-control"  name="datePicker" id="datePicker" />
            </div>
            <input type="button" class="btn btn-primary"onclick="AddPorject()" value="提交">

          </form>
         </div>
       </div>
    </div>
    
    
        <!-- admin管理页面 -->






    <script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/moment.min.js"></script>
	<script src="static/js/daterangepicker.js"></script>
	<script src="static/layui/layui.js"></script>
	<script src="static/js/tools.js"></script>
    <script type="text/javascript">
    var StaticUserId = "${sessionScope.userid}";
		var user = document.getElementById('user');
		if("${sessionScope.username}".length == 0 ){
      
      window.location.href = "index.jsp";
		}else{
			user.value  = "${sessionScope.username}";
		}
		function userConsole(){
			if(user.value!="登录"){
				window.location.href = "main.jsp";
			}
		}
		function reg(){
			window.location.href = "register.jsp";
		}
    </script>

  <script>
      $.ajax({
      url: "GroupDataTableInterface",
      type: "post",
      data:{"userid":StaticUserId},
      dataType: "json",
      success: function(data){
        for(var temp in data.data){
          $("#basic").append("<option data-subtext='option subtext' value='"+ data.data[temp].groupkey +"'>"+data.data[temp].groupName+"</option>");
          //var opt = new Option(data.data[temp].groupName, data.data[temp].groupkey);
          // groupselect.options.add(opt);
        }
      }
     });

     function AddPorject(){
      //  console.log($('#yname').val());
      //  console.log($('#ytext').val());
      //  console.log($('#datePicker').val());
      //  console.log($('#basic').val());
       $.ajax({
        url: "AddPorjectServlet",
        type: "post",
        data:{
          "userid":StaticUserId,
          "projectName":$('#yname').val(),
          "projectPs":$('#ytext').val(),
          "datePicker":$('#datePicker').val(),
          "groupname":$('#basic').val()
        },
        dataType: "json",
        success: function(data){
          if(data.status==1){
            alert("添加成功");
          }else{
            alert("添加失败");
          }
        }
       });
     }


  </script>
<script>
// 日期初始化
$('input[name="datePicker"]').daterangepicker({
  timePicker: true, //显示时间
  timePicker24Hour: true, //时间制
  timePickerSeconds: true, //时间显示到秒
  startDate: moment().hours(0).minutes(0).seconds(0), //设置开始日期
  endDate: moment(new Date()), //设置结束器日期
  maxDate: moment(new Date()), //设置最大日期

  minDate: 1999 - 12 - 12,
  maxDate: 2050 - 12 - 30,

  opens: "center",
  ranges: {
    // '今天': [moment(), moment()],
    // '昨天': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
    // '上周': [moment().subtract(6, 'days'), moment()],
    // '前30天': [moment().subtract(29, 'days'), moment()],
    本月: [moment().startOf("month"), moment().endOf("month")]
    // '上月': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
  },
  showWeekNumbers: true,
  locale: {
    format: "YYYY-MM-DD HH:mm:ss", //设置显示格式
    applyLabel: "确定", //确定按钮文本
    cancelLabel: "取消", //取消按钮文本
    customRangeLabel: "自定义",
    daysOfWeek: ["日", "一", "二", "三", "四", "五", "六"],
    monthNames: [
      "一月",
      "二月",
      "三月",
      "四月",
      "五月",
      "六月",
      "七月",
      "八月",
      "九月",
      "十月",
      "十一月",
      "十二月"
    ],
    firstDay: 1
  }
});
</script>
    <!--  -->

</body>
</html>
