<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>影评详情</title>

<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/reviewDetails.css">


<script src="../js/jquery.min.js"></script>
<script src="../js/jquery-ui.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/script.js"></script>
<script src="../js/reviewDetail.js"></script>
<script type="text/javascript" src="http://cdn.webfont.youziku.com/wwwroot/js/wf/youziku.api.min.js"></script>
<script type="text/javascript">
	$youziku.load("body", "8a1f6c8a889447e29321a784b1d855b1", "Source-Han-Light");
	/*$youziku.load("#id1,.class1,h1", "8a1f6c8a889447e29321a784b1d855b1", "Source-Han-Light");*/
	/*．．．*/
	$youziku.draw();
</script>

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
					<li class="nav-item "><a class="nav-link"
						href="../index/index">主页</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../smovie/selectMovie">选电影</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../Rank/NewRank">排行榜</a></li>
					<li class="nav-item "><a class="nav-link"
						href="../review/Review">影评</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="#">影评详情<span class="sr-only">(current)</span></a></li>

				</ul>
				<form class="form-inline my-2 my-lg-0" action ="../index/search" method="post">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search" name="keyword">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>

				<ul class="navbar-nav">

					<c:if test="${isLogin == false}">
						<li class="nav-item" id="regist-login"><a class="nav-link"
							href="../index/login">注册/登录</a></li>
					</c:if>

					<c:if test="${isLogin == true }">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> ${userLogin.username } </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item"
									href="../index/userInfo?uid=${userLogin.uid }">个人中心</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="../index/logout">退出</a>
							</div></li>
					</c:if>


				</ul>
			</div>
		</nav>
	</div>
	<div id="content">

		<div id="review-card" class="container">
			<div class="card">
				<div class="card-header">
					<h3 id="commentId" value=${comment.cid }>${comment.ctitle }</h3>
				</div>
				<div class="card-body">
					<div id="review-meta">
						<a href="../index/userInfo?uid=${userPost.uid }"><img
							src="${userPost.uimg }" alt=""></a> <a
							href="../index/userInfo?uid=${userPost.uid }" id="touidUrl">${userPost.username }</a>
						&nbsp;评论&nbsp; <a href="../movie/movieDetail?mid=${movie.mid }">${ movie.mname}</a>
						<strong class="item-degree" title="推荐">${comment.cscore }</strong>
						<p>${comment.cdate }</p>
					</div>

					<blockquote class="review-content">
						<p style="color: #666667;">${comment.content }</p>
						<footer class="blockquote-footer">
							源自<cite title="Source Title">想看电影</cite>
						</footer>
					</blockquote>

					<div class="review-response" id="likeId">

						<!-- 若是用户没有登录 -->
						<c:if test="${empty isLike}">
							<button type="button" class="btn btn-outline-dark" id="thumb-up"
								value="0">
								<img src="../img/open-iconic-master/thumb-up-3x.png" alt="">
								有用 <span>${comment.clike }</span>
							</button>

							<button type="button" class="btn btn-outline-dark"
								id="thumb-down" value="0">
								<img src="../img/open-iconic-master/thumb-down-3x.png" alt="">
								没用 <span>${comment.cdislike }</span>
							</button>
						</c:if>

						<c:if test="${!empty isLike }">
							<!-- 该用户踩了影评 -->
							<c:if test="${isLike == 0 }">
								<button type="button" class="btn btn-outline-dark" id="thumb-up"
									value="10">
									<img src="../img/open-iconic-master/thumb-up-3x.png" alt="">
									有用 <span>${comment.clike }</span>
								</button>

								<!-- 修改踩的样式 -->
								<button type="button" class="btn btn-dark" id="thumb-down"
									value="01">
									<img src="../img/open-iconic-master/thumb-down-white-3x.png"
										alt=""> 没用 <span>${comment.cdislike }</span>
								</button>
							</c:if>

							<!-- 该用户赞了该影评 -->
							<c:if test="${isLike == 1 }">
								<!-- 修改赞的样式 -->
								<button type="button" class="btn btn-dark" id="thumb-up"
									value="11">
									<img src="../img/open-iconic-master/thumb-up-white-3x.png"
										alt=""> 有用 <span>${comment.clike }</span>
								</button>

								<button type="button" class="btn btn-outline-dark"
									id="thumb-down" value="00">
									<img src="../img/open-iconic-master/thumb-down-3x.png" alt="">
									没用 <span>${comment.cdislike }</span>
								</button>
							</c:if>

							<!-- 既没有踩也没有赞 -->
							<c:if test="${isLike == -1 }">
								<button type="button" class="btn btn-outline-dark" id="thumb-up"
									value="10">
									<img src="../img/open-iconic-master/thumb-up-3x.png" alt="">
									有用 <span>${comment.clike }</span>
								</button>

								<button type="button" class="btn btn-outline-dark"
									id="thumb-down" value="00">
									<img src="../img/open-iconic-master/thumb-down-3x.png" alt="">
									没用 <span>${comment.cdislike }</span>
								</button>
							</c:if>


						</c:if>

						<hr>
					</div>

					<div id="review-action" class="stroupId">
						<button type="button" class="btn btn-outline-dark report"
							data-toggle="modal" data-target="#reportModal">举报</button>

						<c:if test="${isStoreup==false }">
							<button type="button" class="btn btn-outline-dark favorites">
								收藏 <span>${storeCount }</span>
							</button>
						</c:if>

						<c:if test="${isStoreup==true }">
							<button type="button" class="btn btn-dark isfavorites">
								已收藏 <span>${storeCount }</span>
							</button>
						</c:if>


					</div>

				</div>
			</div>
		</div>


		<div class="modal fade" id="reportModal" tabindex="-1" role="dialog"
			aria-labelledby="reportModalTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">选择举报原因</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div id="report_value">
							<ul>
								<li><label for=""><input type="radio" name="reason"
										value='广告或垃圾信息'>广告或垃圾信息</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='低俗或色情 '> 低俗或色情 </label></li>
								<li><label for=""><input type="radio" name="reason"
										value='违反相关法律法规或管理规定'>违反相关法律法规或管理规定</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='未经授权的下载资源'> 未经授权的下载资源</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='辱骂或不友善 '> 辱骂或不友善 </label></li>
								<li><label for=""><input type="radio" name="reason"
										value='引战或过于偏激的主观判断'>引战或过于偏激的主观判断</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='泄露他人隐私'> 泄露他人隐私</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='影响评分公正性'> 影响评分公正性</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='与作品或讨论区主题无关'> 与作品或讨论区主题无关</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='其他原因'> 其他原因</label></li>
							</ul>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-dark" data-dismiss="modal"
							id="comment-report">举报</button>
					</div>
				</div>
			</div>
		</div>



		<div id="comments-card" class="container">
			<div class="card">
				<div class="card-header">
					<h5>回复</h5>
				</div>
				<div class="card-body">
					<c:forEach items="${replyToComment}" var="item">
						<div class="review-comment">
							<div class="comment_meta">
								<a href="../index/userInfo?uid=${item.uid }"><img src="${item.uimg }" alt="" style="width: 50px; height: 50px;"></a>
								<a href="../index/userInfo?uid=${item.uid }">${item.username }</a> <span>${item.rdate }</span>
							</div>
							<blockquote class="comment_content" style="color: #666667;">
								<span>${item.rcontent }</span>
							</blockquote>

							<div class="comment_action">
								<span class="response-btn">回应</span> <span data-toggle="modal"
									data-target="#reportModal">举报</span>
							</div>

							<div class="reply-editor">
								<form>
									<div class="form-input-wrapper">
										<input type="text" placeholder="回应@可惜没如果">
										<button type="button" class="btn btn-dark reply-btn">添加回复</button>
										<button type="button" class="btn btn-dark cancel-btn">取消</button>
									</div>
								</form>

							</div>
						</div>

					</c:forEach>



					<!--   
					<div class="comment_reply">
						<div class="reply_meta">
							<a href="#"><img src="../img/u163694915-1.jpg" alt=""></a>
							<a href="#">可惜没如果</a> <span>2018-09-23 12:22:22</span>
						</div>
						<blockquote class="reply_content" style="color: #666667;">
							<span>感谢</span>
						</blockquote>

						<div class="reply_action">
							<span class="response-btn">回应</span> <span data-toggle="modal"
								data-target="#reportModal">举报</span>
						</div>

						<div class="reply-editor">
							<form>
								<div class="form-input-wrapper">
									<input type="text" placeholder="回应@可惜没如果">
									<button type="button" class="btn btn-dark reply-btn">添加回复</button>
									<button type="button" class="btn btn-dark cancel-btn">取消</button>
								</div>
							</form>

						</div>
					</div>
					-->
					
				</div>
				
			</div>
</div>
 
					<div id="add-comment-card" class="container">
						<div class="card">
							<div class="card-header">
								<h5>添加回复</h5>
							</div>
							<div class="card-body clearfix">

								<div class="comment_user_avatar">
									<c:if test="${isLogin == true }">
										<a href="../index/userInfo?uid=${userLogin.uid }"><img
											src="${userLogin.uimg }" alt="用户头像"
											style="width: 50px; height: 50px;"></a>
									</c:if>
									<c:if test="${isLogin == false }">
										<a href="#"><img src="../img/u163694915-1.jpg" alt="默认头像"></a>
									</c:if>
								</div>

								<textarea name="comment-text" id="comment-text" cols="30"
									rows="6" placeholder="添加回复"></textarea>

								<button type="button" class="btn btn-dark add-comment-btn"
									id="addReply">添加</button>
							</div>

						</div>
					</div>


				</div>


				<div id="footer">
					<div class="my-hr">
						<div id="copyright" class="h-center v-center">
							<p>想看电影 &copy;第七小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</p>
						</div>
					</div>
				</div>


				<script type="text/javascript">
					
				</script>
</body>
</html>