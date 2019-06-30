<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>找回密码</title>
<link rel="stylesheet" href="../css/login.css">
<link rel="stylesheet" href="../css/findpassword.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/checkcode.js"></script>
<script type="text/javascript" src="http://cdn.webfont.youziku.com/wwwroot/js/wf/youziku.api.min.js"></script>
<script type="text/javascript">
	$youziku.load("body", "8a1f6c8a889447e29321a784b1d855b1", "Source-Han-Light");
	/*$youziku.load("#id1,.class1,h1", "8a1f6c8a889447e29321a784b1d855b1", "Source-Han-Light");*/
	/*．．．*/
	$youziku.draw();
</script>
</head>
<body>
	<div class="clearfix top">
		<div class="top-title">找回密码</div>
		<div class="top-back">
			<a href="#" style="color: #fff">返回主页</a>
		</div>
	</div>
	<div class="fpw-center">
		<div class="input-mail">
			<div class="div-br">正在通过邮箱找回密码</div>
			<div class="input-group mb-3"
				style="width: 400px; margin-left: 47px; margin-top: 30px;">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">邮箱</span>
				</div>
				<input type="text" class="form-control" placeholder="请输入您的邮箱"
					aria-label="Username" aria-describedby="basic-addon1" name="email">
			</div>

			<div class="input-group mb-3 clearfix"
				style="width: 400px; margin-left: 47px; margin-top: 30px;">
				<input type="text" id="input-gverify" class="form-control"
					placeholder="请输入右侧图片验证码" aria-label="Recipient's username"
					aria-describedby="basic-addon2" style="width: 200px">
				<div id="gverify">
					<p class="p-text">获取验证码</p>
				</div>
			</div>

			<button type="button" id="ok-btn"
				class="btn btn-success btn-md btn-block"
				style="width: 200px; margin-left: 140px; margin-top: 40px;">确定</button>
		</div>
	</div>
	<div class="fpw-footer">想看电影 @第八小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</div>
	<script>
		$(document)
				.ready(
						function() {
							var verifyCode = null;
							$("#gverify").click(function() {
								$(".p-text").hide();
								verifyCode = new GVerify("gverify");
							});
							$("#ok-btn")
									.click(
											function() {
												
												var res = verifyCode
														.validate(document
																.getElementById("input-gverify").value);
												if (!res) {
													alert("验证码错误！");
													return false;
												} else {
													alert("您的请求已接收，等待处理...");
													var userEmail = $("input[name=email]").val();
													console.log(userEmail);
													window.open("doFindPassword?userEmail="+userEmail);
												}
											});

						})
	</script>
</body>
</html>