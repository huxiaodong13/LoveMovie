<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel=
    "stylesheet">
    <link rel="stylesheet" href="../css/login.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../js/login.js"></script>
</head>

<body>
	<div id="all">
		<div id="top" class="clearfix">
			<div class="top-title">想看电影</div>
			<div class="top-back">
				<a href="#" style="color: aliceblue">返回主页</a>
			</div>
		</div>
		<div id="center">
			<div id="login-message" hidden>
				<div class="title clearfix">
					<div class="message font-center">
						<b class="click-message">短信登录</b>
					</div>
					<div class="password font-center">
						<a class="click-password" href="#"
							style="text-decoration: none; color: white">密码登录</a>
					</div>
				</div>
				<div class="descrption">登录表示同意使用协议、隐私政策</div>
				<div class="input-phonenumber-captcha">
					<form class="bs-example bs-example-form" role="form">
						<div class="input-group">
							<span class="input-group-addon">+86</span> <input type="text"
								class="form-control" placeholder="手机号" name="phonenumber">
						</div>
						<br>
						<div class="input-group">
							<input type="text" class="form-control" placeholder="验证码"
								name="captcha"> <a href="#" class="input-group-addon"
								style="text-decoration: none">获取验证码</a>
						</div>
					</form>
				</div>
				<button type="button" class="btn btn-success btn-md btn-block "
					id="btn-login">登录</button>
				<div class="login-auto clearfix">
					<div class="login-auto-left checkbox">
						<label> <input type="checkbox">下次自动登录
						</label> <label class="login-auto-right">收不到验证码</label>
					</div>
				</div>
				<div class="other-login clearfix">
					<span>-------------------------第三方登录------------------------</span>
					<div class="qq">
						<a href="#"> <img
							src="http://localhost:8080/LoveMovie/img/qq.jpg" alt="">
						</a>
					</div>
					<div class="weixin">
						<a href="#"> <img
							src="http://localhost:8080/LoveMovie/img/weixin.jpg" alt="">
						</a>
					</div>
					<div class="weibo">
						<a href="#"> <img
							src="http://localhost:8080/LoveMovie/img/weibo.jpg" alt="">
						</a>
					</div>
				</div>
			</div>
			<!--密码登录-->
			<div id="login-password">
				<div class="title clearfix">
					<div class="password font-center">
						<a class="click-message" href="#"
							style="text-decoration: none; color: white">短信登录</a>
					</div>
					<div class="message font-center">
						<b class="click-password">密码登录</b>
					</div>
				</div>
				<div class="descrption" style="margin-top: 40px">
					登录表示同意使用协议、隐私政策</div>
					
				<!----------------- 账户用户名登录 ------------------->
				<div class="input-phonenumber-captcha"
					style="margin-top: 10px; margin-bottom: px">
					<form class="bs-example bs-example-form form-password-login"
						role="form" id="lform">
						<div class="form-group">
							<span class="glyphicon glyphicon-user"></span> <input type="text"
								class="form-control" placeholder="请输入用户名"  name = "username" id="l-username" >
						</div>
						<div class="input-group">
							<input type="password" class="form-control" placeholder="请输入密码"
								 name ="password" id="l-password">   
								
							<a href="../forgetPassword/findPassword" class="input-group-addon" style="text-decoration: none">找回密码</a>
						</div>
					</form>
				</div>

				<button type="button" class="btn btn-success btn-md btn-block loginBtn" id="btn-login" >登录</button>
					
				<div class="login-auto clearfix">
					<div class="login-auto-left checkbox">
						<label> <input type="checkbox">下次自动登录
						</label> <label class="login-auto-right"><a class="register-a"
							href="#" style="text-decoration: none; color: white">注册账号</a></label>
					</div>
				</div>
				<div class="other-login clearfix other-login-password">
					<span>-------------------------第三方登录------------------------</span>
					<div class="qq">
						<a href="#"> <img
							src="http://localhost:8080/LoveMovie/img/qq.jpg" alt="">
						</a>
					</div>
					<div class="weixin">
						<a href="#"> <img
							src="http://localhost:8080/LoveMovie/img/weixin.jpg" alt="">
						</a>
					</div>
					<div class="weibo">
						<a href="#"> <img
							src="http://localhost:8080/LoveMovie/img/weibo.jpg" alt="">
						</a>
					</div>
				</div>
			</div>
			<!--注册-->
			<div id="register" hidden>
				<div class="register-title font-center">注册</div>
				<div class="descrption" style="margin-top: 10px">
					注册表示同意使用协议、隐私政策</div>
				<div class="input-register-message">
					<form class="bs-example bs-example-form" role="form" id="register-form">
						<div class="input-group">
							<span class="input-group-addon">用户名称</span> <input type="text"
								class="form-control" id="register-username" name="username">
								
						</div>
						<span class="username-error"></span>
						<br>
						<div class="input-group">
							<span class="input-group-addon">用户密码</span> <input
								type="password" class="form-control" id="register-password" name="password">
						</div>
						<span class="password-error"></span>
						<br>
						<div class="input-group">
							<span class="input-group-addon">确认密码</span> <input
								type="password" class="form-control"
								id="register-password-again" name="repassword">
						</div>
						<span class="repassword-error"></span>
						<br>
						<div class="input-group">
							<span class="input-group-addon">您的邮箱</span> <input type="text"
								class="form-control" id="register-email" name="email">
						</div>
						<span class="email-error"></span>
						
					</form>
				</div>
				<div class="register-btns clearfix">
					<div class="register-btn ">
						<button type="button" class="btn btn-success btn-sm">注册</button>
					</div>
					<div class="cancel-register-btn">
						<button type="button" class="btn btn-default btn-sm">取消</button>
					</div>
				</div>
			</div>
		</div>
		<div id="bottom">想看电影 @第八小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</div>
	</div>
</body>
</html>