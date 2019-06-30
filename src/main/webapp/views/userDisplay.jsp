<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="referrer" content="never">
<title>用户展示页</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/userpage.css">
<link rel="stylesheet" href="../css/userpageDisplay.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/userpagedisplay.js"></script>

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
					<li class="nav-item"><a class="nav-link" href="../index/index">主页</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../smovie/selectMovie">选电影</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../Rank/NewRank">排行榜</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../review/Review">影评</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="../review/Review">用户详情<span class="sr-only">(current)</span></a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0" action ="../index/search" method="post">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search" name="keyword">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>

				<ul class="navbar-nav">
					<li class="nav-item" id="regist-login"><a class="nav-link"
						href="../index/login">注册/登录</a></li>
				</ul>

			</div>
		</nav>
	</div>

	<div id="userpage-center">
		<!--用户展示页-->
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
						<div class="username">
							<label class="label-username"> ${userInfo.username }</label>
						</div>
						<div class="attention">
							<button id="not-attention" type="button"
								class="btn btn-secondary btn-sm">+关注</button>
							<button id="attention" type="button"
								class="btn btn-success btn-sm" style="display: none">已关注</button>
						</div>
						<div class="fans">
							<label id="fans-num">粉丝:20</label>&nbsp&nbsp&nbsp|&nbsp&nbsp <label
								id="attention-num">关注:20</label>
						</div>
					</div>
					<div class="self-introduce">简介</div>
					<div id="self-introduce-text">
						<p style="font-size: 15px; color: white; margin-left: 20px;">${userInfo.brief }</p>
					</div>
				</div>
			</div>
			<hr style="background-color: gray;">
			<!--展示下部分 分为三个板块：电影 关注 粉丝-->
			<div class="center-bottom clearfix">
				<div class="block-all clearfix">
					<div class="block">
						<label class="block-saw">看过的电影</label>
					</div>
					<div class="block">
						<label class="block-plan">想看的电影</label>
					</div>
					<div class="block">
						<label class="block-comment">参与的评论</label>
					</div>
				</div>
				<div class="block-collect saw">
					<div id="hot-movie-content" style="background-color: #343a40;">
						<div id="hot-movies" style="margin: 0; width: 100%">
							<div class="clearfix" id="seen-movies-items">

								<c:forEach items="${smPageInfo.list }" var="item">
									<a href="../movie/movieDetail?mid=${item.mid }"
										class="movie-item" target="_blank" style="margin-left: 5px;">
										<div class="card" style="width: 10rem;">
											<img class="card-img-top" src="${item.img }"
												alt="Card image cap">
											<div class="card-body">
												<span class="card-title item-name" title="${item.mname }">${item.mname }</span>
												<strong class="item-degree card-text">${item.mscore }</strong>
											</div>

											<div class="item-info-summary">
												<h4>${item.mname }</h4>
												<strong class="item-degree card-text">${item.mscore }</strong>
												<div class="item-tags">
													<span class="item-tag">${item.mlong }</span> <span
														class="item-tag">${item.mcountry }</span> <span
														class="item-tag">${item.mtag }</span> <span
														class="item-tag">${item.mdirect }</span> <span
														class="item-tag">${item.mactor }</span>
												</div>
											</div>
										</div>
									</a>
								</c:forEach>

							</div>
						</div>
					</div>

					<!-- --------------------------看过的电影分页------------------------------->
					<nav aria-label="" class="page" style="margin-bottom: 20px;">
						<ul class="pagination h-center v-center"
							id="seen-movie-pagination">
							<c:if test="${smPageInfo.hasPreviousPage==true}">
								<li class="page-item page-link pre-page" id="pre-page-sm"
									value=${ smPageInfo.prePage}>上页</li>
							</c:if>
							<c:if test="${smPageInfo.hasPreviousPage==false}">
								<li class="page-item page-link pre-page" tabindex="-1">上页</li>
							</c:if>

							<li class="page-item  page-link">${smPageInfo.pageNum}/${ smPageInfo.pages}</li>

							<c:if test="${smPageInfo.hasNextPage==true}">
								<li class="page-item page-link next-page" id="next-page-sm"
									value=${ smPageInfo.nextPage}>下页</li>
							</c:if>
							<c:if test="${smPageInfo.hasNextPage==false}">
								<li class="page-item page-link next-page " tabindex="-1">下页</li>
							</c:if>

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
						<div class="clearfix" id="ws-movies-items">

							<c:forEach items="${wmPageInfo.list }" var="item">
								<a href="../movie/movieDetail?mid=${item.mid }"
									class="movie-item" target="_blank" style="margin-left: 5px;">
									<div class="card" style="width: 10rem;">
										<img class="card-img-top" src="${item.img }"
											alt="Card image cap">
										<div class="card-body">
											<span class="card-title item-name" title="${item.mname }">${item.mname }</span>
											<strong class="item-degree card-text">${item.mscore }</strong>
										</div>
										<div class="item-info-summary">
											<h4>${item.mname }</h4>
											<strong class="item-degree card-text">${item.mscore }</strong>
											<div class="item-tags">
												<span class="item-tag">${item.mlong }</span> <span
													class="item-tag">${item.mcountry }</span> <span
													class="item-tag">${item.mtag }</span> <span
													class="item-tag">${item.mdirect }</span> <span
													class="item-tag">${item.mactor }</span>
											</div>
										</div>
									</div>
								</a>
							</c:forEach>

						</div>
					</div>
				</div>
				<!-- --------------------------想看的电影分页------------------------------->
				<nav aria-label="" class="page" style="margin-bottom: 20px;">
					<ul class="pagination h-center v-center" id="ws-movie-pagination">

						<c:if test="${wmPageInfo.hasPreviousPage==true}">
							<li class="page-item page-link pre-page" id="pre-page-ws"
								value=${ wmPageInfo.prePage}>上页</li>
						</c:if>
						<c:if test="${wmPageInfo.hasPreviousPage==false}">
							<li class="page-item page-link pre-page" tabindex="-1">上页</li>
						</c:if>

						<li class="page-item  page-link">${wmPageInfo.pageNum}/${ wmPageInfo.pages}</li>

						<c:if test="${wmPageInfo.hasNextPage==true}">
							<li class="page-item page-link next-page" id="next-page-ws"
								value=${ wmPageInfo.nextPage}>下页</li>
						</c:if>
						<c:if test="${wmPageInfo.hasNextPage==false}">
							<li class="page-item page-link next-page " tabindex="-1">下页</li>
						</c:if>

					</ul>
				</nav>

			</div>
			<!-- <div class="block">
                参与的评论
            </div> -->

			<!-- -----------------------------参与的评论------------------------------->
			<div id="comments-content"
				style="background-color: #343a40; display: none;">
				<div id="comments" style="margin-left: 0px">
					<div id="comment-items">
						<c:forEach items="${cPageInfo.list }" var="item">
							<div class="comment-item" style="margin-left: 0px; width: 830px;">
								<div class="media" style="width: 830px;">
									<div class="media-left">
										<a href="../movie/movieDetail?mid=${item.mid }"
											class="comment-cover " target="_blank" style="width: 10rem">
											<img class="media-object" src="${item.img }" alt="">
										</a>
									</div>

									<div class="media-body comment-info">

										<h4 class="media-heading">
											<a href="../review/reviewDetail?cid=${item.cid }">${item.ctitle }</a>
										</h4>
										<div id="review-meta">
											<a href="../index/userInfo?uid=${item.uid }">${userInfo.username }</a>
											&nbsp;评论&nbsp; <a href="../index/userInfo?uid=${item.uid }">${item.mname }</a>
											<strong class="item-degree">${item.mscore }</strong>
										</div>
										<p style="color: #666667;">
											${fn:substring(item.content, 0, 60)}... <a
												href="../review/reviewDetail?cid=${item.cid }"
												class="btn btn-link">全文</a>
										</p>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>

					<!-- --------------------------参与的影评分页------------------------------->
					<nav aria-label="" class="page" style="margin-bottom: 20px;">
						<ul class="pagination h-center v-center" id="comment-pagination">

							<c:if test="${cPageInfo.hasPreviousPage==true}">
								<li class="page-item page-link pre-page" id="pre-page-comment"
									value=${ cPageInfo.prePage}>上页</li>
							</c:if>
							<c:if test="${cPageInfo.hasPreviousPage==false}">
								<li class="page-item page-link pre-page" tabindex="-1">上页</li>
							</c:if>

							<li class="page-item  page-link">${cPageInfo.pageNum}/${ cPageInfo.pages}</li>

							<c:if test="${cPageInfo.hasNextPage==true}">
								<li class="page-item page-link next-page" id="next-page-comment"
									value=${ cPageInfo.nextPage}>下页</li>
							</c:if>
							<c:if test="${cPageInfo.hasNextPage==false}">
								<li class="page-item page-link next-page " tabindex="-1">下页</li>
							</c:if>

						</ul>
					</nav>
				</div>
			</div>
		</div>
		
		<!---------------------------关注页面------------------------------------------->
		<div class="center-bottom-attention clearfix">
			<div class="list clearfix">
				<div class="list-avatar">
					<img class="list-img" src="img/2.jpg" alt="图片加载失败">
				</div>
				<div class="list-username">
					<a href="#" title="Instagram美图社">Instagram美图社</a>
					<button class="list-not-attention btn btn-secondary" type="button"
						style="display: none">+关注</button>
					<button class="list-attention btn btn-success" type="button">已关注</button>
				</div>
				<div class="list-brief">
					<label
						title="日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极 合作推广☆zhaoer1995☆">
						日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极
						合作推广☆zhaoer1995☆</label>
				</div>
				<div class="list-fans">
					<a href="#">粉丝：20</a>&nbsp&nbsp&nbsp|&nbsp&nbsp <a href="#">关注：20</a>
				</div>
			</div>
			<div class="list clearfix">
				<div class="list-avatar">
					<img class="list-img" src="img/2.jpg" alt="图片加载失败">
				</div>
				<div class="list-username">
					<a href="#" title="Instagram美图社">Instagram美图社</a>
					<button class="list-not-attention btn btn-secondary" type="button"
						style="display: none">+关注</button>
					<button class="list-attention btn btn-success" type="button">已关注</button>
				</div>
				<div class="list-brief">
					<label
						title="日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极 合作推广☆zhaoer1995☆">
						日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极
						合作推广☆zhaoer1995☆</label>
				</div>
				<div class="list-fans">
					<a href="#">粉丝：20</a>&nbsp&nbsp&nbsp|&nbsp&nbsp <a href="#">关注：20</a>
				</div>
			</div>
			<div class="list clearfix">
				<div class="list-avatar">
					<img class="list-img" src="img/2.jpg" alt="图片加载失败">
				</div>
				<div class="list-username">
					<a href="#" title="Instagram美图社">Instagram美图社</a>
					<button class="list-not-attention btn btn-secondary" type="button"
						style="display: none">+关注</button>
					<button class="list-attention btn btn-success" type="button">已关注</button>
				</div>
				<div class="list-brief">
					<label
						title="日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极 合作推广☆zhaoer1995☆">
						日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极
						合作推广☆zhaoer1995☆</label>
				</div>
				<div class="list-fans">
					<a href="#">粉丝：20</a>&nbsp&nbsp&nbsp|&nbsp&nbsp <a href="#">关注：20</a>
				</div>
			</div>
			<div class="list clearfix">
				<div class="list-avatar">
					<img class="list-img" src="img/2.jpg" alt="图片加载失败">
				</div>
				<div class="list-username">
					<a href="#" title="Instagram美图社">Instagram美图社</a>
					<button class="list-not-attention btn btn-secondary" type="button"
						style="display: none">+关注</button>
					<button class="list-attention btn btn-success" type="button">已关注</button>
				</div>
				<div class="list-brief">
					<label
						title="日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极 合作推广☆zhaoer1995☆">
						日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极
						合作推广☆zhaoer1995☆</label>
				</div>
				<div class="list-fans">
					<a href="#">粉丝：20</a>&nbsp&nbsp&nbsp|&nbsp&nbsp <a href="#">关注：20</a>
				</div>
			</div>
			<div class="list clearfix">
				<div class="list-avatar">
					<img class="list-img" src="img/2.jpg" alt="图片加载失败">
				</div>
				<div class="list-username">
					<a href="#" title="Instagram美图社">Instagram美图社</a>
					<button class="list-not-attention btn btn-secondary" type="button"
						style="display: none">+关注</button>
					<button class="list-attention btn btn-success" type="button">已关注</button>
				</div>
				<div class="list-brief">
					<label
						title="日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极 合作推广☆zhaoer1995☆">
						日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极
						合作推广☆zhaoer1995☆</label>
				</div>
				<div class="list-fans">
					<a href="#">粉丝：20</a>&nbsp&nbsp&nbsp|&nbsp&nbsp <a href="#">关注：20</a>
				</div>
			</div>
			<nav aria-label="" class="page">
				<ul class="pagination h-center v-center">
					<li class="page-item disabled"><a class="page-link" href="#"
						tabindex="-1">上页</a></li>
					<li class="page-item"><a class="page-link" href="#">1 / 3</a></li>
					<li class="page-item"><a class="page-link" href="#">下页</a></li>
				</ul>
			</nav>
		</div>
		<!--粉丝页面-->
		<div class="center-bottom-fans">
			<div class="list clearfix">
				<div class="list-avatar">
					<img class="list-img" src="img/2.jpg" alt="图片加载失败">
				</div>
				<div class="list-username">
					<a href="#" title="Instagram美图社">Instagram美图社</a>
					<button class="list-not-attention btn btn-secondary" type="button">+关注</button>
					<button class="list-attention btn btn-success" type="button"
						style="display: none">已关注</button>
				</div>
				<div class="list-brief">
					<label
						title="日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极 合作推广☆zhaoer1995☆">
						日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极
						合作推广☆zhaoer1995☆</label>
				</div>
				<div class="list-fans">
					<a href="#">粉丝：20</a>&nbsp&nbsp&nbsp|&nbsp&nbsp <a href="#">关注：20</a>
				</div>
			</div>
			<div class="list clearfix">
				<div class="list-avatar">
					<img class="list-img" src="img/2.jpg" alt="图片加载失败">
				</div>
				<div class="list-username">
					<a href="#" title="Instagram美图社">Instagram美图社</a>
					<button class="list-not-attention btn btn-secondary" type="button">+关注</button>
					<button class="list-attention btn btn-success" type="button"
						style="display: none">已关注</button>
				</div>
				<div class="list-brief">
					<label
						title="日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极 合作推广☆zhaoer1995☆">
						日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极
						合作推广☆zhaoer1995☆</label>
				</div>
				<div class="list-fans">
					<a href="#">粉丝：20</a>&nbsp&nbsp&nbsp|&nbsp&nbsp <a href="#">关注：20</a>
				</div>
			</div>
			<div class="list clearfix">
				<div class="list-avatar">
					<img class="list-img" src="img/2.jpg" alt="图片加载失败">
				</div>
				<div class="list-username">
					<a href="#" title="Instagram美图社">Instagram美图社</a>
					<button class="list-not-attention btn btn-secondary" type="button">+关注</button>
					<button class="list-attention btn btn-success" type="button"
						style="display: none">已关注</button>
				</div>
				<div class="list-brief">
					<label
						title="日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极 合作推广☆zhaoer1995☆">
						日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极
						合作推广☆zhaoer1995☆</label>
				</div>
				<div class="list-fans">
					<a href="#">粉丝：20</a>&nbsp&nbsp&nbsp|&nbsp&nbsp <a href="#">关注：20</a>
				</div>
			</div>
			<div class="list clearfix">
				<div class="list-avatar">
					<img class="list-img" src="img/2.jpg" alt="图片加载失败">
				</div>
				<div class="list-username">
					<a href="#" title="Instagram美图社">Instagram美图社</a>
					<button class="list-not-attention btn btn-secondary" type="button">+关注</button>
					<button class="list-attention btn btn-success" type="button"
						style="display: none">已关注</button>
				</div>
				<div class="list-brief">
					<label
						title="日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极 合作推广☆zhaoer1995☆">
						日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极
						合作推广☆zhaoer1995☆</label>
				</div>
				<div class="list-fans">
					<a href="#">粉丝：20</a>&nbsp&nbsp&nbsp|&nbsp&nbsp <a href="#">关注：20</a>
				</div>
			</div>
			<div class="list clearfix">
				<div class="list-avatar">
					<img class="list-img" src="img/2.jpg" alt="图片加载失败">
				</div>
				<div class="list-username">
					<a href="#" title="Instagram美图社">Instagram美图社</a>
					<button class="list-not-attention btn btn-secondary" type="button">+关注</button>
					<button class="list-attention btn btn-success" type="button"
						style="display: none">已关注</button>
				</div>
				<div class="list-brief">
					<label
						title="日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极 合作推广☆zhaoer1995☆">
						日更 美图高清壁纸头像 欧美日韩娱乐资讯 心灵鸡汤励志短文 优质原创音乐推荐 年轻且优秀/颓废且积极
						合作推广☆zhaoer1995☆</label>
				</div>
				<div class="list-fans">
					<a href="#">粉丝：20</a>&nbsp&nbsp&nbsp|&nbsp&nbsp <a href="#">关注：20</a>
				</div>
			</div>
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
	</div>
	<!--底部-->
	<div id="footer">
		<div class="my-hr">
			<div id="copyright" class="h-center v-center">
				<p>想看电影 @第七小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</p>
			</div>
		</div>
	</div>
</body>
</html>