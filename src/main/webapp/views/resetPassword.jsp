<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>重置密码</title>
<link rel="stylesheet" href="../css/login.css">
<link rel="stylesheet" href="../css/findpassword.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<div class="clearfix top">
		<div class="top-title">重置密码</div>
		<div class="top-back">
			<a href="#" style="color: #fff">返回主页</a>
		</div>
	</div>
	<div class="fpw-center">
		<div class="input-mail">
			<div class="div-br">正在重置密码</div>
			<div class="input-group mb-3"
				style="width: 400px; margin-left: 47px; margin-top: 22px;">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">用户名</span>
				</div>
				<input type="text" class="form-control" aria-label="Username"
					aria-describedby="basic-addon1" name="username" disabled placeholder="${userEmail }">
			</div>
			<div class="input-group mb-3"
				style="width: 400px; margin-left: 47px; margin-top: 22px;">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">密码</span>
				</div>
				<input type="password" class="form-control" placeholder="请输入您的新密码"
					aria-label="Username" aria-describedby="basic-addon1"
					name="newpassword">
			</div>
			<div class="input-group mb-3"
				style="width: 400px; margin-left: 47px; margin-top: 22px;">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">确认</span>
				</div>
				<input type="password" class="form-control" placeholder="请确认您的密码"
					aria-label="Username" aria-describedby="basic-addon1"
					name="newpasswordagain">
			</div>
			<button type="button" id="ok-btn"
				class="btn btn-success btn-md btn-block"
				style="width: 200px; margin-left: 140px; margin-top: 30px;">确定</button>
		</div>
	</div>
	<div class="fpw-footer">想看电影 @第八小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</div>
	<script>
		$(document).ready(function() {
			$("#ok-btn").click(function() {
				alert("密码修改成功！");
				window.open('../index/login');
			});

		})
	</script>
</body>
</html>