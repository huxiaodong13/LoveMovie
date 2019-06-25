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
<meta name="referrer" content="never">

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
			<a class="navbar-brand" href="show">想看电影</a>
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
			<form id="set-form" action="updateUserInfo" method="post"
				enctype="multipart/form-data">
				<div class="input-edit-message clearfix">

					<!----------------------- 用户信息表单 --------------------->
					<label style="color: white">昵称:&nbsp&nbsp&nbsp&nbsp</label> <input
						class="input-style" type="text" name="username"
						value="${userInfo.username }" disabled> <br> <br>
					<label style="color: white; margin-top: 25px;">邮箱:&nbsp&nbsp&nbsp&nbsp</label>
					<input class="input-style" type="email" name="email"
						value="${userInfo.email }">
					<p style="color: red">邮箱用于找回密码，请谨慎修改哦~</p>
					<br> <br>
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
				<a name="seenMovie"><label class="block-saw">看过guoguog的电影</label></a>
			</div>
			<div class="block">
				<a name="wSeenMovie"><label class="block-plan">想看的电影</label></a>
			</div>
			<div class="block">
				<a name="comment"><label class="block-comment">参与的评论</label></a>
			</div>

			<!-- -----------------------------看过的电影------------------------------->
			<div class="block-collect saw">
			
				<div id="hot-movie-content" style="background-color: #343a40;">
					<div id="hot-movies" style="margin: 0; width: 100%">
						<div class="clearfix" id="seen-movies-items">
							<c:forEach items="${smPageInfo.list }" var="item">>
							<a href="#" class="movie-item" target="_blank"
									style="margin-left: 5px;">
									<div class="card" style="width: 10rem;">
										<img class="card-img-top" src="${item.img }"
											alt="Card image cap">
										<div class="card-body">
											<span class="card-title item-name">${item.mname }</span> <strong
												class="item-degree card-text">${item.mscore }</strong>
										</div>
									</div>
								</a>
							</c:forEach>
						</div>
					</div>
				</div>
				
				<div class="page">
					<nav aria-label="Page navigation example">
					
						<ul class="pagination" id="seen-movie-pagination">
						
							<c:if test="${smPageInfo.hasPreviousPage==true}">
								<li class="page-item" id="pre-page-sm" value=2> <span aria-hidden="true">前一页</span>
										<span class="sr-only"></span>
								</li>
							</c:if>
							
							<c:if test="${smPageInfo.hasPreviousPage==false}">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">没有了哦</span>
								</a></li>>
							</c:if>

							<li class="page-item"><a class="page-link" href="#">${smPageInfo.pageNum}/${ smPageInfo.pages}</a></li>

							<c:if test="${smPageInfo.hasNextPage==true}">
								<li class="page-item" id="next-page-sm" value=2><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">下一页</span>
										<span class="sr-only">下一页</span>
								</a></li>
							</c:if>
							<c:if test="${smPageInfo.hasNextPage==false}">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">没有了哦</span>
								</a></li>
							</c:if>
						</ul>
						
					</nav>
				</div>
			</div>

			<!-- -----------------------------想看的电影------------------------------->
			<div class="block-collect plan" style="display: none;">
				<div id="hot-movie-content" style="background-color: #343a40;">
					<div id="hot-movies" style="margin: 0; width: 100%">
						<div class="clearfix">

							<c:forEach items="${wmPageInfo.list }" var="item">
								<a href="#" class="movie-item item-br" target="_blank"
									style="margin-left: 5px;">
									<div class="card" style="width: 10rem;">
										<img class="card-img-top" src="${item.img }"
											alt="Card image cap">
										<div class="card-body">
											<h5 class="card-title item-name">${item.mname }</h5>
											<strong class="item-degree card-text">${item.mscore }</strong>
										</div>
									</div>
								</a>
							</c:forEach>

						</div>
					</div>
				</div>
				<div class="page">
					<nav aria-label="Page navigation example">
						<ul class="pagination">

							<c:if test="${smPageInfo.hasPreviousPage==true}">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">前一页</span>
								</a></li>
							</c:if>
							<c:if test="${smPageInfo.hasPreviousPage==false}">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">没有了哦</span>
								</a></li>
							</c:if>


							<li class="page-item">${smPageInfo.pageNum}/${ smPageInfo.pages}</li>

							<c:if test="${smPageInfo.hasNextPage==true}">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										<span class="sr-only">下一页</span>
								</a></li>
							</c:if>
							<c:if test="${smPageInfo.hasNextPage==false}">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										<span class="sr-only">没有了哦</span>
								</a></li>
							</c:if>

						</ul>
					</nav>
				</div>
			</div>

			<!-- -----------------------------参与的评论------------------------------->
			<div id="comments-content"
				style="background-color: #343a40; display: none;">
				<div id="comments" style="margin-left: 0px">

					<c:forEach items="${cPageInfo.list }" var="item">
						<div class="comment-item" style="margin-left: 0px; width: 830px;">
							<div class="media" style="width: 830px;">
								<div class="media-left">
									<a href="#" class="comment-cover " target="_blank"
										style="width: 10rem"> <img class="media-object"
										src="${item.img }" alt="">
									</a>
								</div>
								<div class="media-body comment-info">

									<h4 class="media-heading">
										<a href="#">${item.ctitle }</a>
									</h4>
									<div id="review-meta">
										<a href="#">${userInfo.username }</a> &nbsp;评论&nbsp; <a
											href="#">${item.mname }</a> <strong class="item-degree">${item.mscore }</strong>
									</div>
									<p style="color: #666667;">
										${item.content } <a href="#" class="btn btn-link">全文</a>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>

					<div class="page">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<c:if test="${smPageInfo.hasPreviousPage==true}">
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											<span class="sr-only">前一页</span>
									</a></li>
								</c:if>
								<c:if test="${smPageInfo.hasPreviousPage==false}">
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											<span class="sr-only">没有了哦</span>
									</a></li>
								</c:if>


								<li class="page-item">${smPageInfo.pageNum}/${ smPageInfo.pages}</li>

								<c:if test="${smPageInfo.hasNextPage==true}">
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											<span class="sr-only">下一页</span>
									</a></li>
								</c:if>
								<c:if test="${smPageInfo.hasNextPage==false}">
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											<span class="sr-only">没有了哦</span>
									</a></li>
								</c:if>

							</ul>
						</nav>
					</div>
				</div>

			</div>
		</div>

	</div>
	</div>
	<div id="footer">
		<div class="my-hr">
			<div id="copyright" class="h-center v-center">
				<p>想看电影 &copy; 第7小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</p>
			</div>
		</div>
	</div>
</body>
</html>