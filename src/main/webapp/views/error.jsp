<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>想看电影</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/script.js"></script>
</head>

<body>
	<div id="header">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">想看电影</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">主页<span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link" href="#">电影</a></li>
					<li class="nav-item"><a class="nav-link" href="#">分类</a></li>
					<li class="nav-item"><a class="nav-link" href="#">排行榜</a></li>
					<li class="nav-item"><a class="nav-link" href="#">影评</a></li>

				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>

				<ul class="navbar-nav">
					 <li class="nav-item" id="regist-login">
		        		<a class="nav-link" href="../index/login">注册/登录</a>
		     		</li> 
					
				</ul>
			</div>
		</nav>
	</div>
	<!-- 页面不存在 -->
	<div id="error-content" style="height: 32rem;" align="center">

		<h4 style="margin: 4rem;">
			<img src="img/open-iconic-master/warning-4x.png" alt=""> 啊哦~
			您访问的页面不存在哦
		</h4>

		<p>
			还有 >> <span style="color: orange;" id="time-counter">5</span> 秒返回首页
			...
		</p>
		<img src="../img/goodbye.gif" style="width: 8rem;">
	</div>
	<div id="footer">
		<div class="my-hr">
			<div id="copyright" class="h-center v-center">
				<p>想看电影 &copy;第七小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</p>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//计时器
		function timer(intDiff) {
			window.setInterval(function() {
				second = 0;//时间默认值        
				if (intDiff > 0) {
					second = Math.floor(intDiff);
				}
				$('#time-counter').text(second);
				intDiff--;
				if (intDiff <= 0) {
					clearInterval(timer); //定时器清除；
					history.back(-1);
				}
			}, 1000);

		}
		
		var intDiff = parseInt(4);//倒计时总秒数量
		timer(intDiff);
	</script>
</body>
</html>