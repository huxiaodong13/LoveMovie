// 用户注册
function register() {
	var isRegistOk = false;
	console.log($("#register-form").serialize());
	$.ajax({
		url : "doRegister",
		type : "post",
		data : $("#register-form").serialize(),
		async : false,
		success : function(msg) {
			console.log(msg);
			if (msg == "success") {
				isRegistOk = true;
			}
		}
	});
	return isRegistOk;
}

$(document).ready(function() {
	$(".click-message").click(function() {
		$("#login-password").hide();
		$("#login-message").show();
	});

	$(".click-password").click(function() {
		$("#login-message").hide();
		$("#login-password").show();
	});

	$(".register-a").click(function() {
		$("#login-message").hide();
		$("#login-password").hide();
		$("#register").show();
	});

	$(".register-btn").click(function() {

		// 获取用户注册信息
		var username = $("#register-username").val();
		var password = $("#register-password").val();
		var repassword = $("#register-password-again").val();
		var email = $("#register-email").val();

		 var uPattern = /^[a-zA-Z0-9_]{6,12}$/; //用户名字母数字下划线
		 if(!uPattern.test(username)){
		 alert("用户名不合法~，用户名要求为6-12位以字母数字和下划线组成");
		 }
		        
		 if(password!=repassword){
		 alert("两次密码不一致");
		 }
		        
		 var pPattern =
		 /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
		 if(!pPattern.test(password)){
		 alert("密码不合法~最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符");
		 }
		        
		 var ePattern =
		 /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		 if(!ePattern.test(email)){
		 alert("邮箱格式不合法~");
		 }

		// 如果注册成功则返回登录窗口
		if (register()) {
			alert("注册成功");
			$("#login-message").hide();
			$("#login-password").show();
			$("#register").hide();
		} else {
			alert("注册失败，用户名重名");
		}
	});

	$(".cancel-register-btn").click(function() {
		$("#login-message").hide();
		$("#login-password").show();
		$("#register").hide();
	});

	$(".loginBtn").click(function() {
		console.log("login===" + $("#lform").serialize());
		$.ajax({
			url : "doLogin",
			type : "post",
			data : $("#lform").serialize(),
			async : false,
			success : function(msg) {
				console.log(msg);
				if (msg == "-1") {
					alert("用户名不正确");
				}else if(msg =="0"){
					alert("密码不正确");
				}else{
					alert("成功登录");
					window.open('../index/LMindex');
				}
			}
		});

	});
})