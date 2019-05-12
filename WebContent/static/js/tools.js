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

 

// 添加项目
// function setFormData() {
//     var formData = new FormData();
//     formData.append("projectName", $("#projectname").val());
//     formData.append("projectPs", $("#projectps").val());
//     formData.append("datePicker", $("#datePicker").val());
//     formData.append("groupfilename", $("#GroupFileName").val());
//     formData.append("userid", "${sessionScope.userid}");

//     var file = $("input[name='GroupFile']").val();
//     var filename = file.replace(/.*(\/|\\)/, "");
//     var fileExt = /[.]/.exec(filename)
//       ? /[^.]+$/.exec(filename.toLowerCase())
//       : "";
//     formData.append("zhui", fileExt);
//     // alert(fileExt);
//     // alert($('#projectname').val());
//     // alert($('#projectps').val());
//     //alert($('#datePicker').val());
//     // alert('${sessionScope.userid}');

    
//     $.ajax({
//       async: false,
//       type: "post",
//       //processData:false,
//       url: "./AddPorjectServlet",
//       data: formData,
//       cache: false,
//       processData: false,
//       contentType: false,
//       //dataType : 'json',
//       success: function(res) {
//         // alert(res);
//       }
//     });
//   }

