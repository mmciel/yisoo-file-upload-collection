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
    <link rel="stylesheet" href="static/css/fileinput.min.css" />

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
              <a href="updatepj.jsp"
                ><span class="glyphicon glyphicon-flash"></span>项目修改</a
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
      <!-- <input
        type="button"
        class="btn btn-primary"
        data-toggle="modal"
        data-target="#AddGroupModal"
        value="添加组"
        id = "addgroup"
      /> -->
      <table id="GroupListData" lay-filter="tableFilter"></table>

    </div>

    <!-- 添加group的模态框 -->
    <!-- 模态框（Modal） -->
    <div
      class="modal fade"
      id="AddGroupModal"
      tabindex="-1"
      role="dialog"
      aria-labelledby="GroupModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content" style="height:280px;">
          <div class="modal-header">
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-hidden="true"
            >
              ×
            </button>
            <h4 class="modal-title" id="GroupModalLabel">添加组</h4>
          </div>
          <div class="modal-body">
            <!--input file name -->
            <div class="form-group">
              <div class="row col-md-offset-2 col-md-8">
                <input
                  type="text"
                  class="form-control"
                  id="GroupName"
                  placeholder="组名称"
                  required="required"
                />
                <br>
              </div>
            </div>
            <!--input file -->
            <div class="form-group">
              <div class="row col-md-offset-2 col-md-8">
                <input type="file" class="file" id="GroupFile" /><br>
              </div>
            </div>

            <!-- <div class="form-group">
              <div class="row col-md-offset-8 col-md-2">
                <br><br>
                <button type="button" class="btn btn-primary " id="submitfile">提交</button>
              </div>
            </div> -->
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
    <!-- 添加group的模态框 -->


        <!-- 查看group的模态框 -->
    <!-- 模态框（Modal） -->
    <div
      class="modal fade"
      id="ViewGroupModal"
      tabindex="-1"
      role="dialog"
      aria-labelledby="ViewGroupModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog" >
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
            <h4 class="modal-title" id="ViewGroupModalLabel">查看组</h4>
          </div>
          <div class="modal-body">
            <!--input file name -->
            <div class="form-group">
            
                <table id="viewgroup"></table>
             
            </div>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
    <!-- 查看group的模态框 -->

    <!-- admin管理页面 -->

    <script type="text/html" id="BBar">
      <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>

    <script src="static/js/jquery.min.js"></script>
    <script src="static/js/bootstrap.js"></script>
    <script src="static/js/moment.min.js"></script>
    <script src="static/js/daterangepicker.js"></script>
    <script src="static/layui/layui.js"></script>
    <script src="static/js/tools.js"></script>
    <script src="static/js/fileinput.min.js"></script>
    <script src="static/js/locales/zh.js"></script>
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
    </script>

    <script>
          $("#GroupFile")
            .fileinput({
              language: "zh",
              uploadUrl: "UploadGroupDataExcelFileServlet",
              allowedFileExtensions: ["xlsx", "xls"],
              uploadExtraData: function() {
                var obj = {};
                obj.userid = "${sessionScope.userid}";
                obj.GroupFileName = $('#GroupName').val();
                console.log(obj.GroupFileName);
                return obj;
              },
              uploadAsync: true,
              showUpload: true,
              showCaption: true,
              showPreview: false,
              browseClass: "btn btn-primary",
              dropZoneEnabled: false,
              enctype: "multipart/form-data",
              maxFileSize: 10240
            })
            .on("fileuploaded", function(event, data, previewId, index) {
              if (data.response.status == 1) {
                console.log("ok");
              } else {
                console.log("no");
              }
            })
            .on("filebatchselected", function(event, files) {
              //$(this).fileinput("upload");
              var $filename = $("#GroupFile")
                .val()
                .split(".")[1]
                .toLocaleLowerCase();
              if ($filename == "xls" || $filename == "xlsx") {
              } else {
                alert("格式不正确");
              }
              //console.log($filename);
            });
      
    </script>
    <!--  -->

    <script>
      // 项目数据表格
      var btStr = "<input type='button' class='btn btn-info btn-sm' data-toggle='modal' data-target='#AddGroupModal' value='添加组'id = 'addgroup'/>"
      layui.use("table", function() {
          var table = layui.table;
          //第一个实例
          table.render({
            elem: "#GroupListData",
            height: 550,
            url: "./GroupDataTableInterface", //数据接口
            page:{ //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                  layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                  ,curr: 1 //设定初始在第 1 页
                  ,groups: 1 //只显示 1 个连续页码
                  ,first: false //不显示首页
                  ,last: false //不显示尾页
            },
            done: function(res, curr, count){
               }, //开启分页
            cols: [
              [
              // ,
                { field: "userid", title: "用户ID", width: 100},
                { field: "groupName", title: "采用名单", width: 200},
                { field: "groupkey", title: "组识别码", width:  300},
                {field:'null'  , title:btStr , align:'center' , minWidth: 100, toolbar:"#BBar"}
              ]
            ]
            
          });
          var viewGroupTable = table.render({
                  elem: "#viewgroup",
                  height: 550,
                  url: "", //数据接口
                  cols: [
                    [
                      { field: "grade", title: "组", width: 200},
                      { field: "number", title: "序号", width: 200,sort:true},
                      { field: "name", title: "姓名", width: 180},
                    ]
                  ]
                  ,skin: 'row' //表格风格
                  ,even: true
                  ,page: true //是否显示分页
                  ,limit: 5 //每页默认显示的数量
          });
          table.on('tool(tableFilter)', function(obj){
            //console.log("2");
            var data = obj.data;
            if(obj.event === 'detail'){
                //layer.msg('ID：'+ data.id + ' 的查看操作');
                //查看这个名字的所有表单
                console.log(data.groupkey);
                viewGroupTable.reload({
                  url: "./PersonDataTableInterface"+"?groupkey="+data.groupkey
                });
                $('#ViewGroupModal').modal('show');
            } else if(obj.event === 'del'){
                layer.confirm('是否删除？', function(index){
                    console.log(data);

                    $.ajax({
                        url: "DelGroupDataServlet",
                        type: "POST",
                        data:{"userid":data.userid,"groupName":data.groupName},
                        dataType: "json",
                        success: function(data){

                            if(data.status==1){
                                obj.del();
                                layer.close(index);
                                layer.msg("删除成功");
                            }else{
                                layer.msg("删除失败");
                            }
                        }

                    });
                });
            }
        });




        });
      
      </script>

          <!--  -->

  </body>
</html>
