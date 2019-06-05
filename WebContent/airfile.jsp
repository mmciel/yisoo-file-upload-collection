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
  <link rel="stylesheet" href="static/css/bootstrap.css">
  <link rel="stylesheet" href="static/css/fileinput.min.css" />
  <link rel="stylesheet" href="static/css/normalize.css" /><!--CSS RESET-->

  <style>
    html, body {
      height: 100%;
      width: 100%;
      margin: 0;
      overflow: hidden;
    }
    #site-landing {
      position:relative;
      height: 100%;
      width: 100%;
       background-image: linear-gradient(to top, #30cfd0 0%, #330867 100%);
    }
    </style>
  </head>
  <body>

    <div id="site-landing"  class="container">
        <div class="row">
          
          <div class="form-group">
              <div class="col-md-offset-3 col-md-6">
                  <h1 style="color:azure; font-size:40px">YiSoo Air File</h1>
                  <h2 style="color:azure">文件投放</h2>
              </div>
            <div class="col-md-offset-3 col-md-6">
                
              <input
                type="text"
                class="form-control"
                id="maxcount"
                placeholder="最大可下载数"
                required="required"
              />
              <br>
            </div>
          </div>
          <div class="form-group">
              <div class="col-md-offset-3 col-md-6">
                <input type="file" class="file" id="airfile" /><br>
              </div>
          </div>
          <div class="form-group">
              <div class="col-md-offset-3 col-md-6">
                  <h2 style="color:azure">文件获取</h2>
              </div>
              
                  <div class="col-md-offset-3 col-md-4">
                      <input
                      type="text"
                      class="form-control"
                      id="sharecode"
                      placeholder="分享码"
                      required="required"
                    />
                  </div>
                  <div class="col-md-2">
                    <button id="btsharecode" class="btn btn-info btn-block" onclick="downFile()">下载</button>
                  </div>

             

          </div>

      </div>
    </div>

            <!-- 上传完成后的模态框 -->
    <!-- 模态框（Modal） -->
    <div
      class="modal fade"
      id="uploadresult"
      tabindex="-1"
      role="dialog"
      aria-labelledby="result"
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
            <h4 class="modal-title" id="result">分享码</h4>
          </div>
          <div class="modal-body">
            <!--input file name -->
            <div class="form-group">
                <input type="text"
                class="form-control"
                id="ans"
                required="required"
              />
            </div>
            <div class="form-group">
                <input type="button"
                class="btn btn-primary"
                id="btans"
                value="复制分享码"
                onclick="copyText()"
              />
            </div>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
    <!-- 上传完成后的模态框 -->




  <script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
  <script src="static/js/polygonizr.min.js"></script>
  <script src="static/js/fileinput.min.js"></script>
  <script src="static/js/locales/zh.js"></script>
  <script src="static/js/jquery.fileDownload.js"></script>
	<script type="text/javascript">
		$('#site-landing').polygonizr();

    function copyText(){
      var e=document.getElementById("ans");//对象是contents   
        e.select(); //选择对象   
        tag = document.execCommand("Copy"); //执行浏览器复制命令  
        if(tag){  
          $('#btans').val("复制成功");
        } 
    }
    function downFile(){
      if($('#sharecode').val() === ""){
        $('#sharecode').val("请填写分享码！");
      }
      var url = "AirFileDownServlet"
      $.fileDownload(url,{
		    httpMethod: 'POST',
		    data:"sharecode=" + $('#sharecode').val(),

		    prepareCallback:function(url){
          //$('#btsharecode').val("正在下载");
          console.log("正在下载");
		    },
		    abortCallback:function(url){
          //$('#btsharecode').val("异常终止");
		    	console.log("异常终止");
		    },
		    successCallback:function(url){
          //$('#btsharecode').val("下载成功");
		    	console.log("下载成功");

		    },
		    failCallback: function (html, url) {
          
          //$('#btsharecode').val("下载失败");
	        console.log("下载失败");

		    }
		    
	  });


      
    }
	</script>
    <script>
        $("#airfile")
          .fileinput({
            language: "zh",
            uploadUrl: "AirFileUploadServlet",
            uploadExtraData: function() {
              var obj = {};
              obj.maxcount = $('#maxcount').val();
              if(obj.maxcount === ""){
                obj.maxcount = "1000";
              }
              //console.log(obj.GroupFileName);
              return obj;
            },
            uploadAsync: true,
            showUpload: true,
            showCaption: true,
            showPreview: true,
            browseClass: "btn btn-primary",
            dropZoneEnabled: false,
            enctype: "multipart/form-data",
            maxFileSize: 10240
          })
          .on("fileuploaded", function(event, data, previewId, index) {
            if (data.response.status == 1) {
              $('#ans').val(data.response.data);
		          $('#uploadresult').modal('show');
              console.log("upload ok");
            } else {
              $('#ans').val('分享码获取失败');
              $("#btans").hide();
              $('#uploadresult').modal('show');
              console.log("upload no");
            }
          })
          .on("filebatchselected", function(event, files) {
            //$(this).fileinput("upload");
            console.log("ok");
            //console.log($filename);
          });
    
  </script>
</body>
</html>
