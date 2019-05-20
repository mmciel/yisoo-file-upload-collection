<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String ProjectPath = request.getContextPath(); String
basePath =
request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ProjectPath+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>YiSoo</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- 引入 Bootstrap -->
    <link href="static\css\bootstrap.css" rel="stylesheet" />
    <link rel="stylesheet" href="static/css/bootstrap.css" />
    <link rel="stylesheet" href="static/css/daterangepicker.css" />
    <link rel="stylesheet" href="static/layui/css/layui.css" />

    <style type="text/css">
      @media (min-width: 760px) {
        #ce {
          width: 250px;
          margin-top: 0px;
          z-index: 1;
          position: absolute;
          height: 540px;
        }

        .page_main {
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
              <input
                type="button"
                class="btn btn-primary"
                data-toggle="modal"
                data-target="#LoginModal"
                id="user"
                name="user"
                value="登录"
                onclick="userConsole()"
              />
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- 模态框（Modal） -->
    <div
      class="modal fade"
      id="LoginModal"
      tabindex="-1"
      role="dialog"
      aria-labelledby="LoginModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-hidden="true"
            >
              ×
            </button>
            <h4 class="modal-title" id="LoginModalLabel">登录YiSoo</h4>
          </div>
          <!--登陆框中间部分(from表单)-->
          <div class="modal-body">
            <form
              action="${ProjectPath }LoginServlet"
              method="post"
              class="form-horizontal"
            >
              <!--用户框-->
              <div class="form-group">
                <label for="username" class="col-sm-2 control-label"
                  >用户名</label
                >
                <div class="col-sm-10">
                  <input
                    type="text"
                    class="form-control"
                    name="yusername"
                    id="username"
                    placeholder="账户"
                    required="required"
                  />
                </div>
              </div>
              <!--密码框-->
              <div class="form-group">
                <label for="password" class="col-sm-2 control-label"
                  >密码</label
                >
                <div class="col-sm-10">
                  <input
                    type="password"
                    class="form-control"
                    name="ypassword"
                    id="password"
                    placeholder="密码"
                    required="required"
                  />
                </div>
              </div>

              <!--登陆按钮-->
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-primary">登录</button>
                  <button type="button" class="btn btn-default" onclick="reg()">
                    注册
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
    <!-- admin管理页面 -->
    <div id="ce" class="navbar-default navbar-collapse">
      <ul class="nav">
        <li>
          <a href="index.html"
            ><span class="glyphicon glyphicon-send"></span> 主页</a
          >
        </li>

        <li>
          <a data-toggle="collapse" data-target="#project-dropdown1" href="#"
            >项目相关<span
              class="glyphicon glyphicon-chevron-right pull-right"
            ></span
          ></a>
          <ul id="project-dropdown1" class="nav collapse">
            <li>
              <a href="main.jsp"
                ><span class="glyphicon glyphicon-flash"></span>项目浏览</a
              >
            </li>
            <li>
              <a href="addpj.jsp"
                ><span class="glyphicon glyphicon-flash"></span>项目添加</a
              >
            </li>

            <li>
              <a href="usepj.jsp"
                ><span class="glyphicon glyphicon-flash"></span>项目发布</a
              >
            </li>
          </ul>
        </li>
        <li>
          <a data-toggle="collapse" data-target="#project-dropdown2" href="#"
            >项目监控<span
              class="glyphicon glyphicon-chevron-right pull-right"
            ></span
          ></a>
          <ul id="project-dropdown2" class="nav collapse">
            <li>
              <a href="uploadnow.jsp"
                ><span class="glyphicon glyphicon-flash"></span>实时提交</a
              >
            </li>
            <li>
              <a href="datapjview.jsp"
                ><span class="glyphicon glyphicon-flash"></span>数据分析</a
              >
            </li>
            <li>
              <a href="downpj.jsp"
                ><span class="glyphicon glyphicon-flash"></span>项目导出</a
              >
            </li>
          </ul>
        </li>
        <li>
          <a data-toggle="collapse" data-target="#project-dropdown3" href="#"
            >个人信息<span
              class="glyphicon glyphicon-chevron-right pull-right"
            ></span
          ></a>
          <ul id="project-dropdown3" class="nav collapse">
            <li>
              <a href="userdataupdate.jsp"
                ><span class="glyphicon glyphicon-flash"></span>信息修改</a
              >
            </li>
            <li>
              <a href="addgroupdata.jsp"
                ><span class="glyphicon glyphicon-flash"></span>添加人员信息</a
              >
            </li>
          </ul>
        </li>
      </ul>
    </div>

    <div class="page_main">
      <table id="ProjectListData" lay-filter="tableFilter"></table>
    </div>

    <!-- admin管理页面 -->

    <script type="text/html" id="ReleaseButton">
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="stopbt">停止</a>
      <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="sharebt">启动</a>
    </script>


        <!-- 模态框（Modal） -->
        <div
        class="modal fade"
        id="ReleaseModal"
        tabindex="-1"
        role="dialog"
        aria-labelledby="ReleaseModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button
                type="button"
                class="close"
                data-dismiss="modal"
                aria-hidden="true"
              >
                ×
              </button>
              <h4 class="modal-title" id="ReleaseModalLabel">发布项目</h4>
            </div>
            <!--登陆框中间部分(from表单)-->
            <div class="modal-body">
              <div class="row">
                <div class="col-md-offset-2 col-md-8">


                          <div class="form-group">
                            <input type="text"
                            class="form-control"
                            id="shareurl"
                            required="required"
                          />
                        </div>
                        <div class="form-group">
                            <input type="button"
                            class="btn btn-primary"
                            id="copyurl"
                            value="复制链接"
                            onclick="copyText()"
                          />
                        </div>
                </div>
                <!-- <div class="col-md-offset-2 col-md-8">.col-md-8</div> -->

              </div>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
      <!-- /.modal -->

    <script src="static/js/jquery.min.js"></script>
    <script src="static/js/bootstrap.js"></script>
    <script src="static/js/moment.min.js"></script>
    <script src="static/js/daterangepicker.js"></script>
    <script src="static/layui/layui.js"></script>
    <script src="static/js/tools.js"></script>
    <script type="text/javascript">
      var user = document.getElementById("user");
      if ("${sessionScope.username}".length == 0) {
        window.location.href = "index.jsp";
      } else {
        user.value = "${sessionScope.username}";
      }
      function userConsole() {
        if (user.value != "登录") {
          window.location.href = "main.jsp";
        }
      }
      function reg() {
        window.location.href = "register.jsp";
      }



      function copyText(){
      var e=document.getElementById("shareurl");//对象是contents   
        e.select(); //选择对象   
        tag = document.execCommand("Copy"); //执行浏览器复制命令  
        if(tag){  
          //$('#copyurl').val("复制l");
          layer.msg("复制成功", {icon: 6});
        } 
    }

    </script>
    <script>
      // 项目数据表格
      layui.use("table", function() {
        var table = layui.table;

        //第一个实例
        var tableIns = table.render({
          elem: "#ProjectListData",
          height: 550,
          url: "./ProjectDataTableInterface", //数据接口
          page: false, //开启分页
          cols: [
            [
              //表头
              {
                field: "projectid",
                title: "ID",
                width: 50,
                sort: true
                //fixed: "left"
              },
              { field: "projectname", title: "项目名称", width: 160 },
              { field: "groupname", title: "采用名单", width: 180 },
              { field: "starttime", title: "开始时间", width: 177, sort: true },
              { field: "endtime", title: "结束时间", width: 177, sort: true },
              { field: "status", title: "当前状态", width: 100, sort: true },
              {
                field: "null",
                title: "操作",
                width: 180,
                align: "center",
                minWidth: 100,
                toolbar: "#ReleaseButton"
              }
            ]
          ]
        });



        table.on("tool(tableFilter)", function(obj) {
          var data = obj.data;
          if (obj.event === "stopbt") {
              if(data.status == "未发布"){
                  alert("已经停止");
              }else if(data.status == "已发布"){
                  //改变当前状态
                  var fromData = {order:'share',projectid:data.projectid,status:'0'};
                  $.ajax({
                    url: "./UpdateProjectServlet",
                    method: "post",
                    timeout: 5000,
                    data: fromData,
                    dataType:"json",
                    success: function(re) {
                      console.log(re);
                      alert("关闭成功！");
                      tableIns.reload();
                    }
                  });
              }
          }else if(obj.event === "sharebt") {
              if(data.status == "未发布"){
                //ajax修改状态
                var fromData = {order:'share',projectid:data.projectid,status:'1'};
                  $.ajax({
                    url: "./UpdateProjectServlet",
                    method: "post",
                    timeout: 5000,
                    data: fromData,
                    dataType:"json",
                    success: function(re) {
                      $('#shareurl').val(re.url);
                      console.log(re);
                      tableIns.reload();
                    }
                  });
                $('#ReleaseModal').modal('show');
              }else if(data.status == "已发布"){
                alert("已经发布");
              }
          }
        });
      });
    </script>
    <!--  -->
  </body>
</html>
