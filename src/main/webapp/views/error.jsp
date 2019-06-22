<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>NetCTOSS</title>
        <script language="javascript" type="text/javascript">
            var timer;
            //启动跳转的定时器
            function startTimes() {
                timer = window.setInterval(showSecondes,1000);
            }

            var i = 5;
            function showSecondes() {
                if (i > 0) {
                    i--;
                    document.getElementById("secondes").innerHTML = i;
                }
                else {
                    window.clearInterval(timer);
                    location.href = "<%=basePath%>index/login";
                }
            }

            //取消跳转
            function resetTimer() {
                if (timer != null && timer != undefined) {
                    window.clearInterval(timer);
                    location.href = "<%=basePath%>index/login";
                }
            }
        </script> 
    </head>
    <body class="error_page" onload="startTimes();">
        <h1 id="error">
	        您还未登录哦~，&nbsp;<span id="secondes">5</span>&nbsp;秒后将自动跳转，立即跳转请点击&nbsp;
            <a  href="javascript:resetTimer();">返回</a>
        </h1>
    </body>
</html>