<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>用户主页</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/userpage.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../js/moment-with-locales.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script src="../js/userpage.js"></script>
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
					<!-- <li class="nav-item" id="regist-login">
	        		<a class="nav-link" href="#">注册/登录</a>
	     		</li> -->
					<li class="nav-item dropdown" id="user-drop"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> 用户名 </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">个人中心</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">账号管理</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">退出</a>
						</div></li>
				</ul>
			</div>
		</nav>
	</div>


	<div id="userpage-center">
		<!--编辑个人资料页-->
		<div class="edit-message-wrap clearfix" style="display: none">
			<div class="edit-message-title clearfix">
				<div class="set">
					<h4>个人设置</h4>
				</div>
				<div class="btns">
					<!-- <button type="button" id="edit-savebtn"class="btn btn-success btn-sm">保存</button>
                    <button type="button" id="edit-cancelbtn" class="btn btn-secondary btn-sm" style="margin-left: 25px;">取消</button> -->
				</div>
			</div>

			<!-- ------------------------个人信息编辑start------------------------ -->
			<form id="set-form" action="updateUserInfo" method="post" enctype="multipart/form-data">
				<div class="input-edit-message clearfix">

					<!----------------------- 用户信息表单 --------------------->
					<label style="color: white">昵称:&nbsp&nbsp&nbsp&nbsp</label> <input
						class="input-style" type="text" name="username"
						value="${userInfo.username }" disabled> <br>
					<br> <label style="color: white; margin-top: 25px;">邮箱:&nbsp&nbsp&nbsp&nbsp</label>
					<input class="input-style" type="email" name="email"
						value="${userInfo.email }">
					<p style="color: red">邮箱用于找回密码，请谨慎修改哦~</p>
					<br>
					<br>
					<div class="div-brief">
						<div class="div-brief-text">简介：</div>
						<div class="div-brief-input">
							<textarea name="brief"
								style="height: 120px; width: 350px; background-color: #343a40; color: white;">${userInfo.brief }</textarea>
						</div>
					</div>

					<br>
					<div class="itm clearfix">
						<label class="lab" style="float: left">性别：</label>
						<c:if test="${userInfo.gender eq 2}">
							<div class="f-cb">
								<label class="check"><input name="gender" type="radio"
									class="u-rdi" value="0"> 男</label> <label class="check"><input
									name="gender" type="radio" class="u-rdi" value="1"> 女</label> <label
									class="check"><input name="gender" type="radio"
									class="u-rdi" checked="true" value="2"> 保密</label>
							</div>
						</c:if>
						<c:if test="${userInfo.gender eq 0}">
							<div class="f-cb">
								<label class="check"><input name="gender" type="radio"
									class="u-rdi" checked="true" value="0"> 男</label> <label
									class="check"><input name="gender" type="radio"
									class="u-rdi" value="1"> 女</label> <label class="check"><input
									name="gender" type="radio" class="u-rdi" value="2"> 保密</label>
							</div>
						</c:if>
						<c:if test="${userInfo.gender eq 1}">
							<div class="f-cb">
								<label class="check"><input name="gender" type="radio"
									class="u-rdi" value="0"> 男</label> <label class="check"><input
									name="gender" type="radio" class="u-rdi" checked="true"
									value="1"> 女</label> <label class="check"><input
									name="gender" type="radio" class="u-rdi" value="2"> 保密</label>
							</div>
						</c:if>

					</div>
					<br> <label class="edit-birth"
						style="color: white; margin-top: 10px;">生日:&nbsp&nbsp&nbsp&nbsp</label>
					<!--指定 date标记-->
					<div class='input-group date' id='datetimepicker1'
						style="width: 350px; background-color: #343a40;">
						<input type='text' class="form-control" name="birth"
							placeholder="${userInfo.birth }"
							style="background-color: #343a40; margin-left: 28px; width: 276px; border-radius: 0; color: white;"
							value="${userInfo.username }" /> <span class="input-group-addon"
							style="width: 50px; background-color: #343a40; color: white; padding-left: 0px; border-radius: 0;">
							<span class="glyphicon glyphicon-calendar"
							style="margin-left: 10px;"></span>
						</span>
					</div>
					<div class="div-hr"></div>
					<input type="submit" id="edit-savebtn" name="edit-savebtn"
						value="保存修改"
						style="margin-left: 130px; margin-top: 30px; background-color: #F8EA21;">
					<input type="button" id="edit-cancelbtn" value="取消修改"
						style="margin-left: 30px; background-color: gery;">
				</div>
				
				<div class="change-avatar">
					<div class="avatar-display">
						<p style="color: white; margin-left: 45px;">更换头像</p>
						<img src="${userInfo.uimg }" alt="图像显示失败"
							style="width: 150px; height: 150px;">
					</div>
					<div class="avatar-put">
						<input type="file" name="putavatar" style="width: 180px;">
					</div>
				</div>
			</form>
		</div>

		<!-- ------------------------个人信息编辑end------------------------ -->

		<!------------------------------用户展示页-------------------------------->
		<div class="userpage-wrap clearfix">
			<div class="wrap-header clearfix">
				<div class="wrap-header-left">
					<div class="avatar">
						<img src="${userInfo.uimg }" alt="图像显示失败"
							style="width: 150px; height: 150px;">
					</div>
				</div>
				<div class="wrap-header-right">
					<div class="username-edit clearfix">
						<div class="username">${userInfo.username }</div>
						<div class="edit">
							<button type="button" id="edit-btn"
								class="btn btn-secondary btn-sm">编辑个人资料</button>
						</div>
					</div>
					<div class="self-introduce">
						自我介绍&nbsp&nbsp<label class="edit-introduce" style="color: #E1D363">(编辑)</label>
					</div>
					<div id="self-introduce-edit" style="display: none">
						<textarea id="edit-concent" name="self-introduce-edit"
							style="width: 705px; height: 70px; background-color: #fff;">${userInfo.brief }</textarea>
						<button type="button" id="btn-brief-save"
							class="btn btn-secondary btn-sm" style="margin-left: 600px">保存</button>
						<button type="button" id="btn-brief-cancel"
							class="btn btn-secondary btn-sm">取消</button>
					</div>
					<div id="self-introduce-text">
						<p style="font-size: 10px; color: grey; margin-left: 20px;">${userInfo.brief }</p>
					</div>
				</div>
			</div>

			<!-- -------------------------看过的电影 想看的电影 参与的评论 start---------------------------------- -->
			<hr style="background-color: gray;">
			<div class="block">
				<label class="block-saw">看过的电影</label>
			</div>
			<div class="block">
				<label class="block-plan">想看的电影</label>
			</div>
			<div class="block">
				<label class="block-comment">参与的评论</label>
			</div>
			<div class="block-collect saw">
				<div id="hot-movie-content" style="background-color: #343a40;">
					<div id="hot-movies" style="margin: 0; width: 100%">
						<div class="clearfix">
							<a href="#" class="movie-item" target="_blank"
								style="margin-left: 5px;">
								<div class="card" style="width: 10rem;">
									<img class="card-img-top" src="img/p2549177902.jpg"
										alt="Card image cap">
									<div class="card-body">
										<span class="card-title item-name">绿皮书</span> <strong
											class="item-degree card-text">8.9</strong>
									</div>
								</div>
							</a> <a href="#" class="movie-item" target="_blank"
								style="margin-left: 5px;">
								<div class="card" style="width: 10rem;">
									<img class="card-img-top" src="img/p2549177902.jpg"
										alt="Card image cap">
									<div class="card-body">
										<span class="card-title item-name">绿皮书</span> <strong
											class="item-degree card-text">8.9</strong>
									</div>
								</div>
							</a> <a href="#" class="movie-item" target="_blank"
								style="margin-left: 5px;">
								<div class="card" style="width: 10rem;">
									<img class="card-img-top" src="img/p2549177902.jpg"
										alt="Card image cap">
									<div class="card-body">
										<span class="card-title item-name">绿皮书</span> <strong
											class="item-degree card-text">8.9</strong>
									</div>
								</div>
							</a> <a href="#" class="movie-item" target="_blank"
								style="margin-left: 5px;">
								<div class="card" style="width: 10rem;">
									<img class="card-img-top" src="img/p2549177902.jpg"
										alt="Card image cap">
									<div class="card-body">
										<h5 class="card-title item-name">绿皮书</h5>
										<strong class="item-degree card-text">8.9</strong>
									</div>
								</div>
							</a> <a href="#" class="movie-item item-br" target="_blank"
								style="margin-left: 5px;">
								<div class="card" style="width: 10rem;">
									<img class="card-img-top" src="img/p2549177902.jpg"
										alt="Card image cap">
									<div class="card-body">
										<h5 class="card-title item-name">绿皮书</h5>
										<strong class="item-degree card-text">8.9</strong>
									</div>
								</div>
							</a> <a href="#" class="movie-item" target="_blank"
								style="margin-left: 5px;">
								<div class="card" style="width: 10rem;">
									<img class="card-img-top" src="img/p2549177902.jpg"
										alt="Card image cap">
									<div class="card-body">
										<h5 class="card-title item-name">绿皮书</h5>
										<strong class="item-degree card-text">8.9</strong>
									</div>
								</div>
							</a> <a href="#" class="movie-item" target="_blank"
								style="margin-left: 5px;">
								<div class="card" style="width: 10rem;">
									<img class="card-img-top" src="img/p2549177902.jpg"
										alt="Card image cap">
									<div class="card-body">
										<h5 class="card-title item-name">绿皮书</h5>
										<strong class="item-degree card-text">8.9</strong>
									</div>
								</div>
							</a> <a href="#" class="movie-item" target="_blank"
								style="margin-left: 5px;">
								<div class="card" style="width: 10rem;">
									<img class="card-img-top" src="img/p2549177902.jpg"
										alt="Card image cap">
									<div class="card-body">
										<h5 class="card-title item-name">绿皮书</h5>
										<strong class="item-degree card-text">8.9</strong>
									</div>
								</div>
							</a>
						</div>
					</div>
				</div>
				<div class="page">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
							</a></li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">4</a></li>
							<li class="page-item"><a class="page-link" href="#">5</a></li>
							<li class="page-item"><a class="page-link" href="#">6</a></li>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
									class="sr-only">Next</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>
			<!-- <div class="block">
                    想看的电影
                </div> -->
			<div class="block-collect plan" style="display: none;">
				<div id="hot-movie-content" style="background-color: #343a40;">
					<div id="hot-movies" style="margin: 0; width: 100%">
						<div class="clearfix">

							<a href="#" class="movie-item item-br" target="_blank"
								style="margin-left: 5px;">
								<div class="card" style="width: 10rem;">
									<img class="card-img-top" src="img/p2549177902.jpg"
										alt="Card image cap">
									<div class="card-body">
										<h5 class="card-title item-name">绿皮书</h5>
										<strong class="item-degree card-text">8.9</strong>
									</div>
								</div>
							</a> <a href="#" class="movie-item" target="_blank"
								style="margin-left: 5px;">
								<div class="card" style="width: 10rem;">
									<img class="card-img-top" src="img/p2549177902.jpg"
										alt="Card image cap">
									<div class="card-body">
										<h5 class="card-title item-name">绿皮书</h5>
										<strong class="item-degree card-text">8.9</strong>
									</div>
								</div>
							</a> <a href="#" class="movie-item" target="_blank"
								style="margin-left: 5px;">
								<div class="card" style="width: 10rem;">
									<img class="card-img-top" src="img/p2549177902.jpg"
										alt="Card image cap">
									<div class="card-body">
										<h5 class="card-title item-name">绿皮书</h5>
										<strong class="item-degree card-text">8.9</strong>
									</div>
								</div>
							</a> <a href="#" class="movie-item" target="_blank"
								style="margin-left: 5px;">
								<div class="card" style="width: 10rem;">
									<img class="card-img-top" src="img/p2549177902.jpg"
										alt="Card image cap">
									<div class="card-body">
										<h5 class="card-title item-name">绿皮书</h5>
										<strong class="item-degree card-text">8.9</strong>
									</div>
								</div>
							</a>
						</div>
					</div>
				</div>
				<div class="page">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
							</a></li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">4</a></li>
							<li class="page-item"><a class="page-link" href="#">5</a></li>
							<li class="page-item"><a class="page-link" href="#">6</a></li>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
									class="sr-only">Next</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>
			<!-- <div class="block">
                参与的评论
            </div> -->
			<div id="comments-content"
				style="background-color: #343a40; display: none;">
				<div id="comments" style="margin-left: 0px">
					<div class="comment-item" style="margin-left: 0px; width: 830px;">
						<div class="media" style="width: 830px;">
							<div class="media-left">
								<a href="#" class="comment-cover " target="_blank"
									style="width: 10rem"> <img class="media-object"
									src="img/p2221319641.webp" alt="">
								</a>
							</div>
							<div class="media-body comment-info">

								<h4 class="media-heading">
									<a href="#">此味只有天上有</a>
								</h4>
								<div id="review-meta">
									<a href="#">可惜没如果</a> &nbsp;评论&nbsp; <a href="#">《小森林》</a> <strong
										class="item-degree">8.9</strong>
								</div>
								<p style="color: #666667;">
									假如你现在想看一部日本电影，又觉得大师们的片子太厚重，不易接近，新电影又拿不准看个啥能轻松娱乐赏心悦目又不失逼格，那么电影红花会就给你指条明路:《小森林夏秋篇》！就是一部不看不知道，一看真奇妙的佳片，去年全世界最好看的电影之一，不信？看完无感您回来插了战台烽...
									<a href="#" class="btn btn-link">全文</a>
								</p>
							</div>
						</div>


					</div>

					<div class="comment-item" style="margin-left: 0px; width: 830px;">
						<div class="media" style="width: 830px;">
							<div class="media-left">
								<a href="#" class="comment-cover " target="_blank"
									style="width: 10rem"> <img class="media-object"
									src="img/p2221319641.webp" alt="">
								</a>
							</div>
							<div class="media-body comment-info">

								<h4 class="media-heading">
									<a href="#" s>此味只有天上有</a>
								</h4>
								<div id="review-meta">
									<a href="#">可惜没如果</a> &nbsp;评论&nbsp; <a href="#">《小森林》</a> <strong
										class="item-degree">8.9</strong>
								</div>
								<p style="color: #666667;">
									假如你现在想看一部日本电影，又觉得大师们的片子太厚重，不易接近，新电影又拿不准看个啥能轻松娱乐赏心悦目又不失逼格，那么电影红花会就给你指条明路:《小森林夏秋篇》！就是一部不看不知道，一看真奇妙的佳片，去年全世界最好看的电影之一，不信？看完无感您回来插了战台烽...
									<a href="#" class="btn btn-link">全文</a>
								</p>
							</div>
						</div>


					</div>
					<div class="comment-item" style="margin-left: 0px; width: 830px;">
						<div class="media" style="width: 830px;">
							<div class="media-left">
								<a href="#" class="comment-cover " target="_blank"
									style="width: 10rem"> <img class="media-object"
									src="img/p2221319641.webp" alt="">
								</a>
							</div>
							<div class="media-body comment-info">

								<h4 class="media-heading">
									<a href="#" s>此味只有天上有</a>
								</h4>
								<div id="review-meta">
									<a href="#">可惜没如果</a> &nbsp;评论&nbsp; <a href="#">《小森林》</a> <strong
										class="item-degree">8.9</strong>
								</div>
								<p style="color: #666667;">
									假如你现在想看一部日本电影，又觉得大师们的片子太厚重，不易接近，新电影又拿不准看个啥能轻松娱乐赏心悦目又不失逼格，那么电影红花会就给你指条明路:《小森林夏秋篇》！就是一部不看不知道，一看真奇妙的佳片，去年全世界最好看的电影之一，不信？看完无感您回来插了战台烽...
									<a href="#" class="btn btn-link">全文</a>
								</p>
							</div>
						</div>


					</div>

					<div class="comment-item" style="margin-left: 0px; width: 830px;">
						<div class="media" style="width: 830px;">
							<div class="media-left">
								<a href="#" class="comment-cover " target="_blank"
									style="width: 10rem"> <img class="media-object"
									src="img/p2221319641.webp" alt="">
								</a>
							</div>
							<div class="media-body comment-info">

								<h4 class="media-heading">
									<a href="#">此味只有天上有</a>
								</h4>
								<div id="review-meta">
									<a href="#">可惜没如果</a> &nbsp;评论&nbsp; <a href="#">《小森林》</a> <strong
										class="item-degree">8.9</strong>
								</div>
								<p style="color: #666667;">
									假如你现在想看一部日本电影，又觉得大师们的片子太厚重，不易接近，新电影又拿不准看个啥能轻松娱乐赏心悦目又不失逼格，那么电影红花会就给你指条明路:《小森林夏秋篇》！就是一部不看不知道，一看真奇妙的佳片，去年全世界最好看的电影之一，不信？看完无感您回来插了战台烽...
									<a href="#" class="btn btn-link">全文</a>
								</p>
							</div>
						</div>
						<div class="page">
							<nav aria-label="Page navigation example">
								<ul class="pagination">
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											<span class="sr-only">Previous</span>
									</a></li>
									<li class="page-item"><a class="page-link" href="#">1</a></li>
									<li class="page-item"><a class="page-link" href="#">2</a></li>
									<li class="page-item"><a class="page-link" href="#">3</a></li>
									<li class="page-item"><a class="page-link" href="#">4</a></li>
									<li class="page-item"><a class="page-link" href="#">5</a></li>
									<li class="page-item"><a class="page-link" href="#">6</a></li>
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											<span class="sr-only">Next</span>
									</a></li>
								</ul>
							</nav>
						</div>

					</div>
				</div>
			</div>
			<!-- <div class="block" style="margin-top: 20px;margin-bottom: 20px;">
                留言板
            </div>
            <div class="wrap-note">
                <textarea id="note" name="note-input" style="width:600px;height:120px;background-color: #fff;"></textarea>
            </div>
            <button type="button" id="note-submit" class="btn btn-secondary btn-sm" style="margin-left: 10px;margin-top: 95px;">发表</button> -->
			<!-- <div class="page">
                    <nav aria-label="Page navigation example">
                            <ul class="pagination">
                              <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                  <span aria-hidden="true">&laquo;</span>
                                  <span class="sr-only">Previous</span>
                                </a>
                              </li>
                              <li class="page-item"><a class="page-link" href="#">1</a></li>
                              <li class="page-item"><a class="page-link" href="#">2</a></li>
                              <li class="page-item"><a class="page-link" href="#">3</a></li>
                              <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                  <span aria-hidden="true">&raquo;</span>
                                  <span class="sr-only">Next</span>
                                </a>
                              </li>
                            </ul>
                          </nav>
            </div> -->
		</div>
	</div>
	<div id="footer">
		<div class="my-hr">
			<div id="copyright" class="h-center v-center">
				<p>想看电影 @第7小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</p>
			</div>
		</div>
	</div>
</body>
</html>