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
					<li class="nav-item active"><a class="nav-link"
						href="../review/Review">影评<span class="sr-only">(current)</span></a></li>

				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
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
							aria-expanded="false"> ${user.username } </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="../index/userInfo">个人中心</a>
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
					<h3>不会被遗忘的时光</h3>
				</div>
				<div class="card-body">
					<div id="review-meta">
						<a href="#"><img src="../img/u163694915-1.jpg" alt=""></a> <a
							href="#">可惜没如果</a> &nbsp;评论&nbsp; <a href="#">《小森林》</a> <strong
							class="item-degree" title="推荐">8.9</strong>
						<p>2018-09-23 12:22:22</p>
					</div>

					<blockquote class="review-content">
						<p style="color: #666667;">
							托尼（维果·莫腾森 Viggo Mortensen
							饰）是一个吊儿郎当游手好闲的混混，在一家夜总会做侍者。这间夜总会因故要停业几个月，可托尼所要支付的房租和生活费不会因此取消，所以他的当务之急是去寻找另一份工作来填补这几个月的空缺。在这个节骨眼上，一位名叫唐雪莉（马赫沙拉·阿里
							Mahershala Ali 饰）的黑人钢琴家提出雇佣托尼。 <br>
							唐雪莉即将开始为期八个星期的南下巡回演出，可是，那个时候南方对黑人的歧视非常的严重，于是托尼便成为了唐雪莉的司机兼保镖。一路上，两人迥异的性格使得他们之间产生了很多的矛盾，与此同时，唐雪莉在南方所遭受的种种不公平的对待也让托尼对种族歧视感到深恶痛绝。
						</p>
						<footer class="blockquote-footer">
							源自<cite title="Source Title">想看电影</cite>
						</footer>
					</blockquote>
					<div class="review-response">
						<button type="button" class="btn btn-outline-dark" id="thumb-up">
							<img src="../img/open-iconic-master/thumb-up-3x.png" alt="">
							有用 <span>36</span>
						</button>
						<button type="button" class="btn btn-outline-dark" id="thumb-down">
							<img src="../img/open-iconic-master/thumb-down-3x.png" alt="">
							没用 <span>1</span>
						</button>
						<hr>
					</div>
					<div id="review-action">
						<button type="button" class="btn btn-outline-dark favorites">
							收藏 <span>178</span>
						</button>
						<button type="button" class="btn btn-dark isfavorites">
							已收藏 <span>178</span>
						</button>
						<button type="button" class="btn btn-outline-dark report"
							data-toggle="modal" data-target="#reportModal">举报</button>
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
										value='0'>广告或垃圾信息</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='1'> 低俗或色情 </label></li>
								<li><label for=""><input type="radio" name="reason"
										value='2'>违反相关法律法规或管理规定</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='3'> 未经授权的下载资源</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='4'> 辱骂或不友善 </label></li>
								<li><label for=""><input type="radio" name="reason"
										value='5'>引战或过于偏激的主观判断</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='6'> 泄露他人隐私</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='7'> 影响评分公正性</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='8'> 与作品或讨论区主题无关</label></li>
								<li><label for=""><input type="radio" name="reason"
										value='9'> 其他原因</label></li>
							</ul>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-dark" data-dismiss="modal">举报</button>
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
					<div class="review-comment">
						<div class="comment_meta">
							<a href="#"><img src="../img/u163694915-1.jpg" alt=""></a>
							<a href="#">可惜没如果</a> <span>2018-09-23 12:22:22</span>
						</div>
						<blockquote class="comment_content" style="color: #666667;">
							<span>赞楼主，不容易</span>
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
						<a href="#"><img src="../img/u163694915-1.jpg" alt=""></a>
					</div>
					<textarea name="comment-text" id="comment-text" cols="30" rows="6"
						placeholder="添加回复"></textarea>

					<button type="button" class="btn btn-dark add-comment-btn">添加</button>
				</div>

			</div>
		</div>





		<!-- <div class="my-hr" >
			
		</div> -->
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