<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>想看电影最受欢迎的影评</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/style.css">

	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/script.js"></script>
	
	

</head>
<body>
	<div id="header">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">想看电影</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    	<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
	    		<li class="nav-item active">
	    			<a class="nav-link" href="#">主页<span class="sr-only">(current)</span></a>
	      		</li>
	      		<li class="nav-item">
	        		<a class="nav-link" href="#">电影</a>
	     		</li>
	      		<li class="nav-item">
	        		<a class="nav-link" href="#">分类</a>
	     		</li>
	     		<li class="nav-item">
	        		<a class="nav-link" href="#">排行榜</a>
	     		</li>
	     		<li class="nav-item">
	        		<a class="nav-link" href="#">影评</a>
	     		</li>
	     		
	    	</ul>
	    	<form class="form-inline my-2 my-lg-0">
	      		<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
	      		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	    	</form>

			<ul class="navbar-nav">
				<!-- <li class="nav-item" id="regist-login">
	        		<a class="nav-link" href="#">注册/登录</a>
	     		</li> -->
		    	<li class="nav-item dropdown" id="user-drop">
		        	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		        		用户名
		    		</a>
		    		<div class="dropdown-menu" aria-labelledby="navbarDropdown">
		      			<a class="dropdown-item" href="#">个人中心</a>
		      			<div class="dropdown-divider"></div>
		      			<a class="dropdown-item" href="#">账号管理</a>
		      			<div class="dropdown-divider"></div>
		      			<a class="dropdown-item" href="#">退出</a>
		        	</div>
		      	</li>
	      	</ul>
	  </div>
	</nav>
	</div>
	<div id="content">
		

<!-- ********************************************************************** -->



		<div id="comment-selector" class="selector">
			<div id="comment-tag-list" class="tag-list v-center">
				<ul class="clearfix">
					<li>
						<span class="badge badge-dark" id="main-badge">最受欢迎的</span>
					</li>
					<li>
						<span class="badge badge-yellow" >热门影评
							<input type="radio" name="tag" value="热门" class="tag">
						</span>
					</li>

					<li>
						<span class="badge badge-yellow" >新片影评
							<input type="radio" name="tag" value="最新" class="tag">
						</span>
						
					</li>
					
				</ul>
			</div>
		</div>

		<div class="my-hr" >
			
		</div>

		<div id="comments-content">
			<div id="comments">
				<div class="comment-item">
					<div class="media">
					  	<div class="media-left">
						    <a href="#" class="comment-cover " target="_blank" style="width: 10rem">
						      <img class="media-object" src="img/p2221319641.webp" alt="" >
						    </a>
					  	</div>
					  	<div class="media-body comment-info">
							<div id="review-meta">
								<a href="#"><img src="../img/u163694915-1.jpg" alt=""></a>
						    	<a href="#">可惜没如果</a>
						    	<strong class="item-degree" title="推荐">8.9</strong>
						    	<p>2018-09-23 12:22:22</p>
						    </div>
					    	<h4 class="media-heading"><a href="#">此味只有天上有</a></h4>
					
					    	<p style="color: #666667;">假如你现在想看一部日本电影，又觉得大师们的片子太厚重，不易接近，新电影又拿不准看个啥能轻松娱乐赏心悦目又不失逼格，那么电影红花会就给你指条明路:《小森林夏秋篇》！就是一部不看不知道，一看真奇妙的佳片，去年全世界最好看的电影之一，不信？看完无感您回来插了战台烽... <a href="#" class="btn btn-link">全文</a></p>

					    	<div class="action">
						    	<a href="#" title="有用" >▲ 123</span></a>
						    	<a href="#" title="无用">▼ 11</span></a> 
						    	<a href="" class="reply" style="margin: 0 1rem;">28回复</a>
						    </div>
					  	</div>
					</div>
				</div>

				<div class="comment-item">
					<div class="media">
					  	<div class="media-left">
						    <a href="#" class="comment-cover " target="_blank" style="width: 10rem">
						      <img class="media-object" src="../img/p2221319641.webp" alt="" >
						    </a>
					  	</div>
					  	<div class="media-body comment-info">
							<div id="review-meta">
								<a href="#"><img src="../img/u163694915-1.jpg" alt=""></a>
						    	<a href="#">可惜没如果</a>
						    	<strong class="item-degree" title="推荐">8.9</strong>
						    	<p>2018-09-23 12:22:22</p>
						    </div>
					    	<h4 class="media-heading"><a href="#">此味只有天上有</a></h4>
					
					    	<p style="color: #666667;">假如你现在想看一部日本电影，又觉得大师们的片子太厚重，不易接近，新电影又拿不准看个啥能轻松娱乐赏心悦目又不失逼格，那么电影红花会就给你指条明路:《小森林夏秋篇》！就是一部不看不知道，一看真奇妙的佳片，去年全世界最好看的电影之一，不信？看完无感您回来插了战台烽... <a href="#" class="btn btn-link">全文</a></p>

					    	<div class="action">
						    	<a href="#" title="有用" >▲ 123</span></a>
						    	<a href="#" title="无用">▼ 11</span></a> 
						    	<a href="" class="reply" style="margin: 0 1rem;">28回复</a>
						    </div>
					  	</div>
					</div>
				</div>

				<div class="comment-item">
					<div class="media">
					  	<div class="media-left">
						    <a href="#" class="comment-cover " target="_blank" style="width: 10rem">
						      <img class="media-object" src="../img/p2221319641.webp" alt="" >
						    </a>
					  	</div>
					  	<div class="media-body comment-info">
							<div id="review-meta">
								<a href="#"><img src="../img/u163694915-1.jpg" alt=""></a>
						    	<a href="#">可惜没如果</a>
						    	<strong class="item-degree" title="推荐">8.9</strong>
						    	<p>2018-09-23 12:22:22</p>
						    </div>
					    	<h4 class="media-heading"><a href="#">此味只有天上有</a></h4>
					
					    	<p style="color: #666667;">假如你现在想看一部日本电影，又觉得大师们的片子太厚重，不易接近，新电影又拿不准看个啥能轻松娱乐赏心悦目又不失逼格，那么电影红花会就给你指条明路:《小森林夏秋篇》！就是一部不看不知道，一看真奇妙的佳片，去年全世界最好看的电影之一，不信？看完无感您回来插了战台烽... <a href="#" class="btn btn-link">全文</a></p>

					    	<div class="action">
						    	<a href="#" title="有用" >▲ 123</span></a>
						    	<a href="#" title="无用">▼ 11</span></a> 
						    	<a href="" class="reply" style="margin: 0 1rem;">28回复</a>
						    </div>
					  	</div>
					</div>
				</div>


				<div class="comment-item">
					<div class="media">
					  	<div class="media-left">
						    <a href="#" class="comment-cover " target="_blank" style="width: 10rem">
						      <img class="media-object" src="../img/p2221319641.webp" alt="" >
						    </a>
					  	</div>
					  	<div class="media-body comment-info">
							<div id="review-meta">
								<a href="#"><img src="../img/u163694915-1.jpg" alt=""></a>
						    	<a href="#">可惜没如果</a>
						    	<strong class="item-degree" title="推荐">8.9</strong>
						    	<p>2018-09-23 12:22:22</p>
						    </div>
					    	<h4 class="media-heading"><a href="#">此味只有天上有</a></h4>
					
					    	<p style="color: #666667;">假如你现在想看一部日本电影，又觉得大师们的片子太厚重，不易接近，新电影又拿不准看个啥能轻松娱乐赏心悦目又不失逼格，那么电影红花会就给你指条明路:《小森林夏秋篇》！就是一部不看不知道，一看真奇妙的佳片，去年全世界最好看的电影之一，不信？看完无感您回来插了战台烽... <a href="#" class="btn btn-link">全文</a></p>

					    	<div class="action">
						    	<a href="#" title="有用" >▲ 123</span></a>
						    	<a href="#" title="无用">▼ 11</span></a> 
						    	<a href="" class="reply" style="margin: 0 1rem;">28回复</a>
						    </div>
					  	</div>
					</div>
				</div>
			</div>



			<!----------------------------- 分页布局不对------------------------ -->
			<nav aria-label="" class="page">
			  	<ul class="pagination h-center v-center">
			    	<li class="page-item disabled">
			      		<a class="page-link" href="#" tabindex="-1">上页</a>
			    	</li>
			    	<li class="page-item"><a class="page-link" href="#">1</a></li>
			    	<li class="page-item active">
			      		<a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
			    	</li>
			    	<li class="page-item"><a class="page-link" href="#">3</a></li>
			    	<li class="page-item">
			      		<a class="page-link" href="#">下页</a>
			    	</li>
			  	</ul>
			</nav>
			
		</div>
		
	</div>
	<div id="footer">
		<div class="my-hr" >
			<div id="copyright" class="h-center v-center">
				<p>想看电影   &copy;第七小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</p>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	</script>

</body>
</html>