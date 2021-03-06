<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="referrer" content="never">
<title>想看电影</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/script.js"></script>
<script src="../js/xscript.js"></script>
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
			<a class="navbar-brand" href="../index/index">想看电影</a>
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
					<li class="nav-item"><a class="nav-link"
						href="../smovie/selectMovie">选电影</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../Rank/NewRank">排行榜</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../review/Review">影评</a></li>
				</ul>

				<form class="form-inline my-2 my-lg-0" action="../index/search"
					method="post">
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
							aria-expanded="false"> ${user.username } </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="../index/userInfo?uid=${user.uid }">个人中心</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="../index/logout">退出</a>
							</div></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</div>
	<div id="content">
		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-100" src="../img/lunbo01.jpg"
						alt="First slide">
					<div class="carousel-caption d-none d-md-block">
						<h5>蜘蛛侠：英雄远征 Spider-Man: Far From Home</h5>
	    				<p>这是一个结束，也是一个开始。</p>
					</div>
				</div>

				<div class="carousel-item">
					<img class="d-block w-100" src="../img/lunbo04.jpg"
						alt="Third slide">
					<div class="carousel-caption d-none d-md-block">
						<h5>请以你的名字呼唤我 Call Me by Your Name</h5>
	    				<p>那个吻和你的衬衫，是我从你那里得到的一切。</p>

					</div>
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" src="../img/lunbo05.jpg"
						alt="Third slide">
					<div class="carousel-caption d-none d-md-block">
						<h5>少年的你</h5>
	    				<p>你保护世界，我保护你。</p>

					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
		<div id="movie-selector" class="selector">
			<div id="movie-tag-list" class="tag-list v-center">
				<ul class="clearfix">
					<li><span class="badge badge-dark" id="main-badge">最近热门电影</span>
					</li>
					<li><span class="badge badge-yellow" id="block-hot"> 热门
							<input type="radio" name="tag" value="热门" class="tag">
					</span></li>

					<li><span class="badge badge-yellow" id="block-date">
							最新 <input type="radio" name="tag" value="最新" class="tag">
					</span></li>

					<li><span class="badge badge-yellow" id="block-score">
							高分 <input type="radio" name="tag" value="豆瓣高分" class="tag">
					</span></li>
					<li><span class="badge badge-yellow" id="block-cold">
							冷门佳片 <input type="radio" name="tag" value="冷门佳片" class="tag">
					</span></li>
				</ul>
			</div>
		</div>

		<div class="my-hr">
			<a href="../smovie/selectMovie">或许你想看更多？</a>
		</div>
		<div id="hot-movie-content">
			<div id="hot-movies">
				<div class="clearfix" id="newDate-movies-items">
					<c:forEach items="${moviesNewDate}" var="movie" varStatus="k">
						<a href="../movie/movieDetail?mid=${movie.mid }"
							class="movie-item" target="_blank">
							<div class="card" style="width: 12rem;">
								<img class="card-img-top" src="${movie.img }"
									alt="Card image cap">
								<div class="card-body movie-info">
									<span class="card-title item-name">${movie.mname}</span> <strong
										class="item-degree card-text">${movie.mscore }</strong>
								</div>
							</div>
							<div class="item-info-summary">
								<h4>${movie.mname }</h4>
								<strong class="item-degree card-text">${movie.mscore}</strong>
								<div class="item-tags">
									<span class="item-tag">${movie.mlong}</span>
									<c:forEach items="${tagsList[k.index] }" var="tag">
										<span class="item-tag">${tag}</span>
									</c:forEach>
									<c:forEach items="${directList[k.index] }" var="direct">
										<span class="item-tag">${direct}</span>
									</c:forEach>

								</div>
								<!-- 
								<hr>
								<div class="isWatched">
									<span class="item-tag"
										style="background-color: #212529; color: white;">想看</span>
								</div>
								 -->

							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>

		<!-- ********************************************************************** -->

		<div class="my-hr" style="margin-top: -20px"></div>



		<div id="comment-selector" class="selector">
			<div id="comment-tag-list" class="tag-list v-center">
				<ul class="clearfix">
					<li><span class="badge badge-dark" id="main-badge">最受欢迎的</span>
					</li>
					<li><span class="badge badge-yellow" id="indexHotComment">
							热门影评 <input type="radio" name="tag" value="热门" class="tag">
					</span></li>

					<li><span class="badge badge-yellow" id="indexNewComment">
							新片影评 <input type="radio" name="tag" value="最新" class="tag">
					</span></li>
					<li id="more-link" class="v-center"><a href="../review/Review"
						style="color: black" class="v-center">或许你想看更多？>></a></li>

				</ul>
			</div>
		</div>

		<div class="my-hr"></div>

		<div id="comments-content">
			<div id="comments">
				<c:forEach items="${commentLikes}" var="like">

					<div class="comment-item">
						<div class="media">
							<div class="media-left">
								<a href="../movie/movieDetail?mid=${like.mid }"
									class="comment-cover " target="_blank" style="width: 10rem">
									<img class="media-object" src="${like.img }" alt="">
								</a>
							</div>
							<div class="media-body comment-info">

								<h4 class="media-heading">
									<a href="../review/reviewDetail?cid=${like.cid }">${like.ctitle }</a>
								</h4>
								<div id="review-meta">
									<a href="../index/userInfo?uid=${like.uid }">${like.username }</a>
									&nbsp;评论&nbsp; <a href="../movie/movieDetail?mid=${like.mid }">${like.mname }</a>
									<strong class="item-degree">${like.cscore }</strong>
								</div>
								<p style="color: #666667;">
									${fn:substring(like.content, 0, 60)}... <a
										href="../review/reviewDetail?cid=${like.cid }"
										class="btn btn-link">全文</a>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
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