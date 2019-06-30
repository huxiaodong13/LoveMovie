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

<title>选电影</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/selectmovie.css">

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/script.js"></script>
<script src="../js/selectmovie.js"></script>



<script type="text/javascript"
	src="http://cdn.webfont.youziku.com/wwwroot/js/wf/youziku.api.min.js"></script>
<script type="text/javascript">
	$youziku.load("body", "8a1f6c8a889447e29321a784b1d855b1",
			"Source-Han-Light");
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
					<li class="nav-item "><a class="nav-link"
						href="../index/index">主页</a></li>
					<li class="nav-item "><a class="nav-link"
						href="../smovie/selectMovie" style="color: white">选电影<span class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="../Rank/NewRank">排行榜</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../review/Review">影评</a></li>

				</ul>


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

	<div id="top">
		<div class="nav">
			<nav class="navbar navbar-light  justify-content-between">
				<a class="navbar-brand"
					style='margin-right: 60px; font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";'>搜你所想，看你想看</a>
				<form class="form-inline" action="../index/search" method="post">
					<input class="form-control mr-sm-2" type="search"
						placeholder="搜索电影、分类、导演、演员" aria-label="Search"
						style="width: 400px">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
				</form>
			</nav>
		</div>
	</div>

	<div id="select-movie">
		<div class="title">选电影</div>
		<div class="tags">
			<ul class="clearfix">
				<li id="shot-movie"><span class="change-background type">
						热门<input class="tag" type="radio" name="tag" value="热门"
						checked="checked">
				</span></li>

				<li id="snew-movie"><span class="type"> 最新<input
						class="tag" type="radio" name="tag" value="最新">
				</span></li>
				<li id="sclassic-movie"><span class="type"> 经典<input
						class="tag" type="radio" name="tag" value="经典">
				</span></li>
				<li id="splayable-movie"><span class="type"> 可播放 <input
						class="tag" type="radio" name="tag" value="可播放">
				</span></li>

				<li id="shighscore-movie"><span class="type"> 高分系列 <input
						class="tag" type="radio" name="tag" value="高分系列"> </label>
				</span></li>
				<li id="sdarkHouse-movie"><span class="type"> 冷门佳片 <input
						class="tag" type="radio" name="tag" value="冷门佳片"> </label>
				</span></li>

				<li id="sChinese-movie"><span class="type"> 华语 <input
						class="tag" type="radio" name="tag" value="华语">
				</span></li>

				<li id="skorean-movie"><span class="type"> 韩国 <input
						class="tag" type="radio" name="tag" value="韩国">
				</span></li>

				<li id="sea-movie"><span class="type"> 欧美 <input
						class="tag" type="radio" name="tag" value="欧美">
				</span></li>
				<li id="sJanpanse-movie"><span class="type"> 日本 <input
						class="tag" type="radio" name="tag" value="日本">
				</span></li>
				<li id="saction-movie"><span class="type"> 动作 <input
						class="tag" type="radio" name="tag" value="动作">
				</span></li>
				<li id="scomedy-movie"><span class="type"> 喜剧 <input
						class="tag" type="radio" name="tag" value="喜剧">
				</span></li>
				<li id="slove-movie"><span class="type"> 爱情 <input
						class="tag" type="radio" name="tag" value="爱情">
				</span></li>
				<li id="ssf-movie"><span class="type"> 科幻 <input
						class="tag" type="radio" name="tag" value="科幻">
				</span></li>

				<li id="scartoon-movie"><span class="type"> 动画 <input
						class="tag" type="radio" name="tag" value="动画">
				</span></li>

				<li id="ssuspense-movie"><span class="type"> 悬疑 <input
						class="tag" type="radio" name="tag" value="悬疑">
				</span></li>

				<li id="shorriable-movie"><span class="type"> 恐怖 <input
						class="tag" type="radio" name="tag" value="恐怖">
				</span></li>
			</ul>
		</div>
	</div>
	<div id="movie-lists">
		<div class="sort">
			<form action="">
				<input type="radio" name="sort" value="hot">按热度排序 &nbsp
				&nbsp &nbsp &nbsp <input type="radio" name="sort" value="time">按时间排序
				&nbsp &nbsp &nbsp &nbsp <input type="radio" name="sort"
					value="comment">按评价排序
			</form>
		</div>
		<div id="hot-movie-content">
			<div id="hot-movies">

				<div class="clearfix" id="select-movie-items">

					<c:forEach items="${infoPage.list }" var="item">
						<a href="../movie/movieDetail?mid=${item.mid }" class="movie-item"
							target="_blank">
							<div class="card" style="width: 10rem;">
								<img class="card-img-top" src="${item.img }"
									alt="Card image cap">
								<div class="card-body">
									<span class="card-title item-name" title="绿皮书">${item.mname }</span>
									<strong class="item-degree card-text">${item.mscore }</strong>
								</div>

								<div class="item-info-summary">
									<h4>${item.mname }</h4>
									<strong class="item-degree card-text">${item.mscore }</strong>
									<div class="item-tags">
										<span class="item-tag">${item.mlong }</span> <span
											class="item-tag">${item.mcountry }</span> <span
											class="item-tag">${item.mtag } </span> <span class="item-tag">${item.mdirect }</span>
										<span class="item-tag">${item.mactor }</span>
									</div>
									<!--  
									<hr>
									<c:if test="${isLogin == true }">
										
										<div class="isWatched">
											<span class="item-tag"
												style="background-color: #212529; color: white;">这里为登录用户标记是否看过
												想看</span>
										</div>
									</c:if>
									-->

								</div>
							</div>
						</a>

					</c:forEach>
				</div>

			</div>
		</div>

		<nav aria-label="" class="page">
			<ul class="pagination h-center v-center"
				id="select-movie-pagination">
				
				<c:if test="${infoPage.hasPreviousPage==true}">
					<li class="page-item page-link pre-page" id="pre-page-selectMovie" value="showHotMovies?page=${ infoPage.prePage}">上页</li>
				</c:if>
				
				<c:if test="${infoPage.hasPreviousPage==false}">
					<li class="page-item disabled page-link pre-page " tabindex="-1">上页</li>
				</c:if>

				<li class="page-item page-link">${infoPage.pageNum}
						/ ${ infoPage.pages}</li>

				<c:if test="${infoPage.hasNextPage==true}">
					<li class="page-item page-link next-page" id="next-page-selectMovie"
						value="showHotMovies?page=${ infoPage.nextPage}">下页</li>
				</c:if>
				<c:if test="${infoPage.hasNextPage==false}">
					<li class="page-item disabled page-link next-page " tabindex="-1">1111下页</li>
				</c:if>

			</ul>
		</nav>
		
	</div>

	<div class="ad">
		<div class="ad-title clearfix">
			<div class="close">
				<p id="close-ad">x</p>
			</div>
		</div>
		广告
	</div>
</body>
</html>