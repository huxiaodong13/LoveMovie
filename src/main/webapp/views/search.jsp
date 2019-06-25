<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
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


		<div class="my-hr" style="background-color: #F8EA21;" >
			
		</div>

		<div id="search-results">
			<div id="movies">
				<div class="movie">
					<div class="media">
					  	<div class="media-left">
						    <a href="#" class="movie-cover " target="_blank" >
						      <img class="media-object" src="../img/p2221319641.webp" alt="" style="width: 6rem" >
						    </a>
					  	</div>
					  	<div class="media-body">
					  		<h4 class="media-heading"><a href="#">绿皮书(2018)</a></h4>
					  		<strong class="item-degree" title="推荐">8.9</strong>(23245评价)
							<div id="movie-summary">
						    	<p>美国 / 喜剧 / 剧情 / 爱情 / 青春无敌 / 隔着阿妈说爱你 / 105分钟</p>
						    	<p>本·杨格尔 / 梅丽尔·斯特里普 / 乌玛·瑟曼 / 布莱恩·格林伯格</p>
						    </div>

					    	<hr>
							<div class="isWatched">
								<span class="item-tag">想看</span>
							</div>
					  	</div>
					</div>
				</div>

				<div class="movie">
					<div class="media">
					  	<div class="media-left">
						    <a href="#" class="movie-cover " target="_blank" >
						      <img class="media-object" src="../img/p2221319641.webp" alt="" style="width: 6rem" >
						    </a>
					  	</div>
					  	<div class="media-body">
					  		<h4 class="media-heading"><a href="#">绿皮书(2018)</a></h4>
					  		<strong class="item-degree" title="推荐">8.9</strong>(23245评价)
							<div id="movie-summary">
						    	<p>美国 / 喜剧 / 剧情 / 爱情 / 青春无敌 / 隔着阿妈说爱你 / 105分钟</p>
						    	<p>本·杨格尔 / 梅丽尔·斯特里普 / 乌玛·瑟曼 / 布莱恩·格林伯格</p>
						    </div>

					    	<hr>
							<div class="isWatched">
								<span class="item-tag">想看</span>
							</div>
					  	</div>
					</div>
				</div>


				<div class="movie">
					<div class="media">
					  	<div class="media-left">
						    <a href="#" class="movie-cover " target="_blank" >
						      <img class="media-object" src="../img/p2221319641.webp" alt="" style="width: 6rem" >
						    </a>
					  	</div>
					  	<div class="media-body">
					  		<h4 class="media-heading"><a href="#">绿皮书(2018)</a></h4>
					  		<strong class="item-degree" title="推荐">8.9</strong>(23245评价)
							<div id="movie-summary">
						    	<p>美国 / 喜剧 / 剧情 / 爱情 / 青春无敌 / 隔着阿妈说爱你 / 105分钟</p>
						    	<p>本·杨格尔 / 梅丽尔·斯特里普 / 乌玛·瑟曼 / 布莱恩·格林伯格</p>
						    </div>

					    	<hr>
							<div class="isWatched">
								<span class="item-tag">想看</span>
							</div>
					  	</div>
					</div>
				</div>


				<div class="movie">
					<div class="media">
					  	<div class="media-left">
						    <a href="#" class="movie-cover " target="_blank" >
						      <img class="media-object" src="../img/p2221319641.webp" alt="" style="width: 6rem" >
						    </a>
					  	</div>
					  	<div class="media-body">
					  		<h4 class="media-heading"><a href="#">绿皮书(2018)</a></h4>
					  		<strong class="item-degree" title="推荐">8.9</strong>(23245评价)
							<div id="movie-summary">
						    	<p>美国 / 喜剧 / 剧情 / 爱情 / 青春无敌 / 隔着阿妈说爱你 / 105分钟</p>
						    	<p>本·杨格尔 / 梅丽尔·斯特里普 / 乌玛·瑟曼 / 布莱恩·格林伯格</p>
						    </div>

					    	<hr>
							<div class="isWatched">
								<span class="item-tag">想看</span>
							</div>
					  	</div>
					</div>
				</div>






			</div>	
				
			<nav aria-label="" class="page">
			  	<ul class="pagination h-center v-center">
			    	<li class="page-item disabled">
			      		<a class="page-link" href="#" tabindex="-1">上页</a>
			    	</li>
			    	<li class="page-item"><a class="page-link" href="#">1 / 3</a></li>
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