<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String ProjectPath = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ProjectPath+"/";
%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>404</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,300,100,100italic,300italic,400italic,700,700italic">
        
        <link rel="stylesheet" href="static/css/bootstrap.css">

        <style>
        body {
		    background: #fff;
		    font-family: 'Roboto', sans-serif;
		    font-weight: 300;
		    color: #fff;
		    text-align: center;
		    background-image: url(./static/img/bg-404.jpg);
		}	
        
        </style>
		
    </head>

    <body>
        <div class="coming-soon">
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
							</br></br>
                            <h1 id="errorword" class="fadeInLeftBig">404:页面找不到</h1>
<!-- 
                            <div class="fadeInLeftBig">
                            	<p>
                            		We are working very hard on the new version of our site. 
                            		In the meantime sign up to our newsletter and you'll be one of the first to know when the site is ready: 
                            	</p>
                            </div> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Javascript -->
        <script src="static/js/jquery.min.js"></script>
        <script src="static/js/jquery.backstretch.min.js"></script>
        <script>
        var word = new Object;
        var aParams = document.location.search.substr(1).split("&");
        for (i = 0; i < aParams.length; i++) {
		        　　aParam = aParams[i].split("=");
		      word[aParam[0]] = aParam[1];
        }
        //console.log(word['error']);
        $('#errorword').html("页面找不到 : "+decodeURI(word['error']));
        </script>
    </body>
</html>
