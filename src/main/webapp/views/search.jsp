<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta name="referrer" content="never">
<title>搜索结果</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/search.css">

<script src="../js/jquery.min.js"></script>
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
					<li class="nav-item active"><a class="nav-link"
						href="../index/index">主页</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../smovie/selectMovie">选电影</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../Rank/NewRank">排行榜</a></li>
					<li class="nav-item "><a class="nav-link"
						href="../review/Review">影评</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">搜索<span
							class="sr-only">(current)</span></a></li>

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
								<a class="dropdown-item"
									href="../index/userInfo?uid=${user.uid }">个人中心</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="../index/logout">退出</a>
							</div></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</div>
	<div id="content">


		<!-- ********************************************************************** -->


		<div class="my-hr" style="background-color: #F8EA21;"></div>

		<div id="search-results">
			<div id="movies">
				<c:forEach items="${resultsPageInfo.list }" var="item">
					<div class="movie">
						<div class="media">
							<div class="media-left">
								<a href="../movie/movieDetail?mid=${item.mid }" class="movie-cover " target="_blank"> <img
									class="media-object" src="${item.img }" alt=""
									style="width: 6rem">
								</a>
							</div>
							<div class="media-body">
								<h4 class="media-heading">
									<a href="../movie/movieDetail?mid=${item.mid }">${item.mname }</a>
								</h4>
								<strong class="item-degree" title="推荐">${item.mscore }</strong>(${item.mcount }人评价)
								<div id="movie-summary">
									<p>${item.mcountry } / ${item.mtag } / ${item.mlong }</p>
									<p>${item.mactor }</p>
								</div>
							<!-- 
								<hr>
								<div class="isWatched">
									<span class="item-tag">想看</span>
								</div>
							 -->
							 
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