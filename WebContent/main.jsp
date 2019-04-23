<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
String ProjectPath = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ProjectPath+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="./static/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="./static/css/daterangepicker.css">

    <!-- <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.css"/> -->
    <!-- <link href="http://cdn.bootcss.com/bootstrap-daterangepicker/2.1.25/daterangepicker.css" rel="stylesheet"> -->
    <!-- <script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script> -->
    <!-- <script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script> -->
    <!-- <script src="http://cdn.bootcss.com/bootstrap-daterangepicker/2.1.25/moment.min.js"></script> -->
    <!-- <script src="http://cdn.bootcss.com/bootstrap-daterangepicker/2.1.25/daterangepicker.js"></script> -->

</head>
<body>
当前用户：   
<input type="button" id="user" name="user" value="登录" onclick="Bonclick()">
<br>
    
-----------------------------------------------------------------------------------------<br> 
项目添加：<br>   
    <form>
      项目名称：<input type="text" id="projectname" name="projectname"><br><br>
      项目描述：<input type="text" id="projectps" name="projectps"><br><br>
      是否采用名单命名：
      <input type="radio" name="isgroup" id="isgroup1" value="yes" /> 是
      <input type="radio" name="isgroup" id="isgroup2" value="no" /> 否<br><br>
      <form id="GroupForm" enctype="multipart/form-data">
        <input id="GroupFileName" type="text" name="GroupFileName" style="display:none;">
        <input id="GroupFile" type="file" name="GroupFile" style="display:none;"/><span id="uploadresult"></span>
        
        <input id="GroupBut" type="button" onclick="UploadGroupData()" value="提交" style="display:none;"/>
    
    </form>
    项目持续时间：<br>

    <input type="text" name="datePicker" id="datePicker" /><br><br>
<!-- <button id="reportrange" style="width:350px">
    <span id="searchDateRange"></span>
</button><br><br>
-->


<input type="button" id = "SubmitBt" value="提交" onclick="setFormData()"><br>
</form>
-----------------------------------------------------------------------------------------<br>  

<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="./static/js/bootstrap.js"></script>
<script src="./static/js/moment.min.js"></script>
<script src="./static/js/daterangepicker.js"></script>
<script>
     function setFormData(){
    var formData=new FormData();
        formData.append("projectName",$('#projectname').val());
        formData.append("projectPs",$('#projectps').val());
         formData.append("datePicker",$('#datePicker').val());
         formData.append("groupfilename",$('#GroupFileName').val());
        formData.append("userid","${sessionScope.userid}");

        var file=$("input[name='GroupFile']").val(); 
        var filename=file.replace(/.*(\/|\\)/, ""); 
        var fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : ''; 
        formData.append("zhui",fileExt);
       // alert(fileExt);
        // alert($('#projectname').val());
        // alert($('#projectps').val());
        //alert($('#datePicker').val());
        // alert('${sessionScope.userid}');

        $.ajax({
          async:false,
          type:"post",
          //processData:false,
          url:"./AddPorjectServlet",
          data:formData,
          cache:false,
          processData: false,
          contentType: false,
          //dataType : 'json',
          success:function(res){
           // alert(res);
       }
   });
    };




</script>

<script type="text/javascript">
 $('input[name="datePicker"]').daterangepicker({
  timePicker: true, //显示时间
  timePicker24Hour: true, //时间制
  timePickerSeconds: true, //时间显示到秒
  startDate: moment().hours(0).minutes(0).seconds(0), //设置开始日期
  endDate: moment(new Date()), //设置结束器日期
  maxDate: moment(new Date()), //设置最大日期

    minDate:1999-12-12,
    maxDate:2050-12-30,

  "opens": "center",
  ranges: {
   // '今天': [moment(), moment()],
   // '昨天': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
   // '上周': [moment().subtract(6, 'days'), moment()],
   // '前30天': [moment().subtract(29, 'days'), moment()],
   '本月': [moment().startOf('month'), moment().endOf('month')],
   // '上月': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
},
showWeekNumbers: true,
locale: {
   format: "YYYY-MM-DD HH:mm:ss", //设置显示格式
   applyLabel: '确定', //确定按钮文本
   cancelLabel: '取消', //取消按钮文本
   customRangeLabel: '自定义',
   daysOfWeek: ['日', '一', '二', '三', '四', '五', '六'],
   monthNames: ['一月', '二月', '三月', '四月', '五月', '六月',
   '七月', '八月', '九月', '十月', '十一月', '十二月'
   ],
   firstDay: 1
},
});

</script>




    <script type="text/javascript">
    function UploadGroupData(){
        var fileObj = document.getElementById("GroupFile").files[0];
        var filenameObj = document.getElementById("GroupFileName");
        var formData=new FormData();
        formData.append("file", fileObj);    
        formData.append("GroupFileName",filenameObj.value);
        //alert(formData.size);
        $.ajax({
            url:"./UploadGroupDataExcelFileServlet",
            method:"post",
            timeout:5000,
            data:formData,
            processData:false,
            contentType:false,//这两行是上传文件时才需要加的
            success:function(data){
                if(data=="ok"){
                    //上传成功
                    $("#uploadresult").text("上传成功");
                }
                else{
                   alert(data);//打印服务器返回的错误信息
               }
           },
           error:function(data){
            alert("上传失败");
        }
    });
    };

</script>  
<script type="text/javascript">
    var user = document.getElementById('user');
    if("${sessionScope.username}".length == 0 ){
        user.value  = "登录";
    }else{
        user.value  = "${sessionScope.username}";
    }

    function Bonclick(){
        if("${sessionScope.username}".length == 0 ){
            window.location.href="login.jsp";
        }else{
            window.location.href="main.jsp";
        }
    }
    var isgroup = document.getElementsByName("isgroup");
    var seegroupfile = document.getElementById("GroupFile");
    var seegroupfilebt = document.getElementById("GroupBut");
    var seeGroupFileName = document.getElementById("GroupFileName");
    isgroup[0].onclick=function(){
        if(isgroup[0].value == "yes"){
            //显示group上传
            seegroupfile.style.display="block";
            seegroupfilebt.style.display="block";
            seeGroupFileName.style.display="block";

        }
    };
    isgroup[1].onclick=function(){
        if(isgroup[1].value == "no"){
            seegroupfile.style.display="none";
            seegroupfilebt.style.display="none";
            seeGroupFileName.style.display="none";

        }
    };

</script>  
</body>
</html>