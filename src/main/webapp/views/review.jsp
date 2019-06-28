<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>想看电影最受欢迎的影评</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/script.js"></script>
<script src="../js/review.js"></script>
<meta name="referrer" content="never">

</head>
<body>
	<div id="header">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="../index/index">想看电影</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="../index/index">主页</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../smovie/selectMovie">选电影</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../Rank/NewRank">排行榜</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../review/Review">影评<span class="sr-only">(current)</span></a>
					</li>

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
		<div id="comment-selector" class="selector">
			<div id="comment-tag-list" class="tag-list v-center">
				<ul class="clearfix">
					<li><span class="badge badge-dark" id="main-badge">最受欢迎的</span>
					</li>
					<li><span class="badge badge-yellow" id="hotReview">
							热门影评</a> <input type="radio" name="tag" value="热门" class="tag">
					</span></li>

					<li><span class="badge badge-yellow" id="newReview">
							新片影评 <input type="radio" name="tag" value="最新" class="tag">
					</span></li>
				</ul>
			</div>
		</div>

		<div class="my-hr"></div>

		<div id="comments-content">
			<div id="comments" class="review-items">
				<c:forEach items="${commentPageInfo.list}" var="comment"
					varStatus="i">
					
					<div class="comment-item">
						<div class="media">
							<div class="media-left">
								<a href="../movie/movieDetail?mid=${comment.mid }" class="comment-cover " target="_blank"
									style="width: 10rem"> <img class="media-object"
									src="${comment.img }" alt="">
								</a>
							</div>
							<div class="media-body comment-info">
								<div id="review-meta">
									<a href="../index/userInfo?uid=${comment.uid }"><img src="${comment.uimg }" alt=""></a> <a
										href="../index/userInfo?uid=${comment.uid }">${comment.username }</a> <strong class="item-degree"
										title="推荐"> ${comment.cscore } </strong>
									<p>${comment.cdate }</p>
								</div>
								<h4 class="media-heading">
									<a href="../review/reviewDetail?cid=${comment.cid }">${comment.ctitle }</a>
								</h4>

								<p style="color: #666667;">${fn:substring(comment.content, 0, 100)}
									<a href="../review/reviewDetail?cid=${comment.cid }" class="btn btn-link">全文</a>
								</p>

								<div class="action">
									<a href="#" title="有用">▲ ${comment.clike }</span></a> <a href="#"
										title="无用">▼ ${comment.cdislike }</span></a> <a href="" class="reply"
										style="margin: 0 1rem;">${commentReplyCount[i.index] }回复</a>
								</div>
							</div>
						</div>
					</div>
					
				</c:forEach>
			</div>
			
			<nav aria-label="" class="page" >
				<ul class="pagination h-center v-center" id="comments-pagination">

					<c:if test="${commentPageInfo.hasPreviousPage==true}">
						<li class="page-item page-link pre-page" 
						value="showPopuplarComment?page=${ commentPageInfo.prePage}" id="pre-page-comment">上页</li>
					</c:if>
					
					<c:if test="${commentPageInfo.hasPreviousPage==false}">
						<li class="page-item disabled page-link pre-page " tabindex="-1">上页</li>
					</c:if>

					<li class="page-item page-link">${commentPageInfo.pageNum}
							/ ${ commentPageInfo.pages}</li>
					
					<c:if test="${commentPageInfo.hasNextPage==true}">
						<li class="page-item  page-link next-page" 
						value="showPopuplarComment?page=${ commentPageInfo.nextPage}" id="next-page-comment">下页</li>
					</c:if>
					
					<c:if test="${commentPageInfo.hasNextPage==false}">
						<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>
					</c:if>
					
				</ul>
			</nav>

		</div>

	</div>
	<div id="footer">
		<div class="my-hr">
			<div id="copyright" class="h-center v-center">
				<p>想看电影 @第八小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</p>
			</div>
		</div>
	</div>











	<script type="text/javascript">
		
	</script>

</body>
</html>