// 如果登录了，就跳转到主页面
function Bonclick() {
  if (username.length == 0) {
    window.location.href = "index.jsp";
  } else {
    window.location.href = "main.jsp";
  }
}

// main页面初始化
function initUser() {
  var user = document.getElementById("user");
  if (username.length == 0) {
    user.value = "登录";
  } else {
    user.value = username;
  }
  var isgroup = document.getElementsByName("isgroup");
  var seegroupfile = document.getElementById("GroupFile");
  var seegroupfilebt = document.getElementById("GroupBut");
  var seeGroupFileName = document.getElementById("GroupFileName");
  isgroup[0].onclick = function() {
    if (isgroup[0].value == "yes") {
      //显示group上传
      seegroupfile.style.display = "block";
      seegroupfilebt.style.display = "block";
      seeGroupFileName.style.display = "block";
    }
  };
  isgroup[1].onclick = function() {
    if (isgroup[1].value == "no") {
      seegroupfile.style.display = "none";
      seegroupfilebt.style.display = "none";
      seeGroupFileName.style.display = "none";
    }
  };
}

// 文件上传
function UploadGroupData() {
  var fileObj = document.getElementById("GroupFile").files[0];
  var filenameObj = document.getElementById("GroupFileName");
  var formData = new FormData();
  formData.append("file", fileObj);
  formData.append("GroupFileName", filenameObj.value);
  //alert(formData.size);
  $.ajax({
    url: "./UploadGroupDataExcelFileServlet",
    method: "post",
    timeout: 5000,
    data: formData,
    processData: false,
    contentType: false, //这两行是上传文件时才需要加的
    success: function(data) {
      if (data == "ok") {
        //上传成功
        $("#uploadresult").text("上传成功");
      } else {
        alert(data); //打印服务器返回的错误信息
      }
    },
    error: function(data) {
      alert("上传失败");
    }
  });
}

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

// 添加项目
function setFormData() {
    var formData = new FormData();
    formData.append("projectName", $("#projectname").val());
    formData.append("projectPs", $("#projectps").val());
    formData.append("datePicker", $("#datePicker").val());
    formData.append("groupfilename", $("#GroupFileName").val());
    formData.append("userid", "${sessionScope.userid}");

    var file = $("input[name='GroupFile']").val();
    var filename = file.replace(/.*(\/|\\)/, "");
    var fileExt = /[.]/.exec(filename)
      ? /[^.]+$/.exec(filename.toLowerCase())
      : "";
    formData.append("zhui", fileExt);
    // alert(fileExt);
    // alert($('#projectname').val());
    // alert($('#projectps').val());
    //alert($('#datePicker').val());
    // alert('${sessionScope.userid}');

    
    $.ajax({
      async: false,
      type: "post",
      //processData:false,
      url: "./AddPorjectServlet",
      data: formData,
      cache: false,
      processData: false,
      contentType: false,
      //dataType : 'json',
      success: function(res) {
        // alert(res);
      }
    });
  }

