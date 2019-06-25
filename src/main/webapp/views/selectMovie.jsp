<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>选电影</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/selectmovie.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/selectmovie.js"></script>

</head>

<body>
	<div id="header" class="clearfix">
		<div class="header-title v-center">想看电影</div>
		<div class="header-select v-center">
			<a href="#">选电影</a>
		</div>
		<div class="header-mainpage v-center">
			<a href="#">首页</a>
		</div>
		<div class="header-type v-center">
			<a href="#">分类</a>
		</div>
		<div class="header-comment v-center">
			<a href="#">评论</a>
		</div>
	</div>
	<div id="top">
		<div class="nav">
			<nav class="navbar navbar-light  justify-content-between">
				<a class="navbar-brand"
					style='margin-right: 60px; font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";'>搜你所想，看你想看</a>
				<form class="form-inline">
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
						热门 </span></li>
				<li><span class="type"> 最新<input class="tag"
						type="radio" name="tag" value="最新">
				</span></li>
				<li><span class="type"> 经典<input class="tag"
						type="radio" name="tag" value="经典">
				</span></li>
				<li><span class="type"> 可播放 <input class="tag"
						type="radio" name="tag" value="可播放">
				</span></li>

				<li><span class="type"> 高分系列 <input class="tag"
						type="radio" name="tag" value="高分系列"> </label>
				</span></li>
				<li><span class="type"> 冷门佳片 <input class="tag"
						type="radio" name="tag" value="冷门佳片"> </label>
				</span></li>

				<li><span class="type"> 华语 <input class="tag"
						type="radio" name="tag" value="华语">
				</span></li>

				<li><span class="type"> 韩国 <input class="tag"
						type="radio" name="tag" value="韩国">
				</span></li>

				<li><span class="type"> 欧美 <input class="tag"
						type="radio" name="tag" value="欧美">
				</span></li>

				<li><span class="type"> 日本 <input class="tag"
						type="radio" name="tag" value="日本">
				</span></li>
				<li><span class="type"> 动作 <input class="tag"
						type="radio" name="tag" value="动作">
				</span></li>
				<li><span class="type"> 喜剧 <input class="tag"
						type="radio" name="tag" value="喜剧">
				</span></li>
				<li><span class="type"> 爱情 <input class="tag"
						type="radio" name="tag" value="爱情">
				</span></li>
				<li><span class="type"> 科幻 <input class="tag"
						type="radio" name="tag" value="科幻">
				</span></li>

				<li><span class="type"> 治愈 <input class="tag"
						type="radio" name="tag" value="治愈">
				</span></li>

				<li><span class="type"> 悬疑 <input class="tag"
						type="radio" name="tag" value="悬疑">
				</span></li>

				<li><span class="type"> 恐怖 <input class="tag"
						type="radio" name="tag" value="恐怖">
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
				<div class="clearfix">

					<c:forEach items="${hotMoviesPage.list }" var="item">
						<a href="#" class="movie-item" target="_blank">
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

		<!-- ------------------------分页------------------------ -->
		<div class="page">
			<nav aria-label="" class="page">
				<ul class="pagination h-center v-center">
					<li class="page-item disabled"><a class="page-link" href="#"
						tabindex="-1">上页</a></li>
					<li class="page-item"><a class="page-link" href="#">1 / 3</a></li>
					<li class="page-item"><a class="page-link" href="#">下页</a></li>
				</ul>
			</nav>
		</div>



	</div>
	<div class="ad">
		<div class="ad-title clearfix">
			<div class="close">
				<p id="close-ad">x</p>
			</div>
		</div>
		广告
	</div>
	<script type="text/javascript">
		$('.type').click(
				function() {
					if ($(this).attr('class') == 'type') {
						$(this).addClass('change-background');
						$(this).find('input').attr('checked', 'checked')
					} else {
						$(this).removeClass('change-background');
					}
					$(this).parent().siblings().find('span').removeClass(
							"change-background");
				});
		$("#close-ad").click(function() {
			$(".ad").hide();
		});
	</script>
</body>
</html>