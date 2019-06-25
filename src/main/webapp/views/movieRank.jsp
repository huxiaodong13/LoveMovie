<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>电影排行榜</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="../css/movieDetail.css">
	<link rel="stylesheet" href="../css/rank.css">

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
		
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  	<div class="modal-dialog modal-dialog-centered" role="document">
		    	<div class="modal-content">
			      	<div class="modal-header">
			        	<h5 class="modal-title" id="exampleModalLongTitle">评分</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          	<span aria-hidden="true">&times;</span>
				        </button>
		      		</div>
				    <div class="modal-body">
				        <div id="Main">
				          	<div id="scrollBar">
				            	<div id="scroll_Track"></div>
				            	<div id="scroll_Thumb"></div>
				          	</div>
					        <p id="scrollBarTxt" style="text-align:center;"></p>
					    </div>
				    </div>
				    <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
				        <button type="button" class="btn btn-dark">确定</button>
				    </div>
				</div>
		  </div>
		</div>


<!-- ********************************************************************** -->

		<div class="my-hr" style="background-color: #F8EA21;">
			
		</div>

		<div id="movie-info-box">
			<div id="movie-info-card">
				<h2>
					<span>想看电影排行榜</span>
				</h2>

				<h5>
					<span><a href="#" class="active">新片排行榜</a></span> / 
					<span><a href="#" class="">经典TOP10</a></span>
				</h5>
		
				<div class="media">
				  	<div class="media-left">
					    <a href="#" class="comment-cover " target="_blank" style="width: 8rem">
					      <img class="media-object" src="../img/p2549177902.jpg" alt="" >
					    </a>
				  	</div>
				  	<div class="media-body">
						<div id="movie-info">
							<div class="media-heading">
								<h4>
									<a href="#">地久天长</a>
								</h4>
								
							</div>
							<div class="movie-sum">
								<p>
									2019-02-14(柏林电影节) / 2019-03-22(中国大陆) / 王景春 / 咏梅 / 齐溪 / 王源 / 杜江 / 艾丽娅 / 徐程 / 李菁菁 / 赵燕国彰 / 鲍振江 / 吴双 / 王子子 / 张新园 / 吴佳宸 / 王亚军 / 刘芮麟 / 中国大陆 / 王小帅 / 175分钟 / 剧情 / 家庭 / 阿美 A Mei...
								</p>
								
							</div>
							<div class="movie-degree">
								<span <span class="degree-tag">8.9</span>
								<img src="img/open-iconic-master/people-2x.png" alt=""> (111234评价)
							</div>
					    </div>
				  	</div>
				</div>
				
				<div class="media">
				  	<div class="media-left">
					    <a href="#" class="comment-cover " target="_blank" style="width: 8rem">
					      <img class="media-object" src="../img/p2549177902.jpg" alt="" >
					    </a>
				  	</div>
				  	<div class="media-body">
						<div id="movie-info">
							<div class="media-heading">
								<h4>
									<a href="#">地久天长</a>
								</h4>
								
							</div>
							<div class="movie-sum">
								<p>
									2019-02-14(柏林电影节) / 2019-03-22(中国大陆) / 王景春 / 咏梅 / 齐溪 / 王源 / 杜江 / 艾丽娅 / 徐程 / 李菁菁 / 赵燕国彰 / 鲍振江 / 吴双 / 王子子 / 张新园 / 吴佳宸 / 王亚军 / 刘芮麟 / 中国大陆 / 王小帅 / 175分钟 / 剧情 / 家庭 / 阿美 A Mei...
								</p>
								
							</div>
							<div class="movie-degree">
								<span <span class="degree-tag">8.9</span>
								<img src="img/open-iconic-master/people-2x.png" alt=""> (111234评价)
							</div>
					    </div>
				  	</div>
				</div>

				<div class="media">
				  	<div class="media-left">
					    <a href="#" class="comment-cover " target="_blank" style="width: 8rem">
					      <img class="media-object" src="img/p2549177902.jpg" alt="" >
					    </a>
				  	</div>
				  	<div class="media-body">
						<div id="movie-info">
							<div class="media-heading">
								<h4>
									<a href="#">地久天长</a>
								</h4>
								
							</div>
							<div class="movie-sum">
								<p>
									2019-02-14(柏林电影节) / 2019-03-22(中国大陆) / 王景春 / 咏梅 / 齐溪 / 王源 / 杜江 / 艾丽娅 / 徐程 / 李菁菁 / 赵燕国彰 / 鲍振江 / 吴双 / 王子子 / 张新园 / 吴佳宸 / 王亚军 / 刘芮麟 / 中国大陆 / 王小帅 / 175分钟 / 剧情 / 家庭 / 阿美 A Mei...
								</p>
								
							</div>
							<div class="movie-degree">
								<span <span class="degree-tag">8.9</span>
								<img src="img/open-iconic-master/people-2x.png" alt=""> (111234评价)
							</div>
					    </div>
				  	</div>
				</div>
				
				<div class="media">
				  	<div class="media-left">
					    <a href="#" class="comment-cover " target="_blank" style="width: 8rem">
					      <img class="media-object" src="img/p2549177902.jpg" alt="" >
					    </a>
				  	</div>
				  	<div class="media-body">
						<div id="movie-info">
							<div class="media-heading">
								<h4>
									<a href="#">地久天长</a>
								</h4>
								
							</div>
							<div class="movie-sum">
								<p>
									2019-02-14(柏林电影节) / 2019-03-22(中国大陆) / 王景春 / 咏梅 / 齐溪 / 王源 / 杜江 / 艾丽娅 / 徐程 / 李菁菁 / 赵燕国彰 / 鲍振江 / 吴双 / 王子子 / 张新园 / 吴佳宸 / 王亚军 / 刘芮麟 / 中国大陆 / 王小帅 / 175分钟 / 剧情 / 家庭 / 阿美 A Mei...
								</p>
								
							</div>
							<div class="movie-degree">
								<span <span class="degree-tag">8.9</span>
								<img src="../img/open-iconic-master/people-2x.png" alt=""> (111234评价)
							</div>
					    </div>
				  	</div>
				</div>

				<div class="media">
				  	<div class="media-left">
					    <a href="#" class="comment-cover " target="_blank" style="width: 8rem">
					      <img class="media-object" src="img/p2549177902.jpg" alt="" >
					    </a>
				  	</div>
				  	<div class="media-body">
						<div id="movie-info">
							<div class="media-heading">
								<h4>
									<a href="#">地久天长</a>
								</h4>
								
							</div>
							<div class="movie-sum">
								<p>
									2019-02-14(柏林电影节) / 2019-03-22(中国大陆) / 王景春 / 咏梅 / 齐溪 / 王源 / 杜江 / 艾丽娅 / 徐程 / 李菁菁 / 赵燕国彰 / 鲍振江 / 吴双 / 王子子 / 张新园 / 吴佳宸 / 王亚军 / 刘芮麟 / 中国大陆 / 王小帅 / 175分钟 / 剧情 / 家庭 / 阿美 A Mei...
								</p>
								
							</div>
							<div class="movie-degree">
								<span <span class="degree-tag">8.9</span>
								<img src="../img/open-iconic-master/people-2x.png" alt=""> (111234评价)
							</div>
					    </div>
				  	</div>
				</div>

				<div class="media">
				  	<div class="media-left">
					    <a href="#" class="comment-cover " target="_blank" style="width: 8rem">
					      <img class="media-object" src="../img/p2549177902.jpg" alt="" >
					    </a>
				  	</div>
				  	<div class="media-body">
						<div id="movie-info">
							<div class="media-heading">
								<h4>
									<a href="#">地久天长</a>
								</h4>
								
							</div>
							<div class="movie-sum">
								<p>
									2019-02-14(柏林电影节) / 2019-03-22(中国大陆) / 王景春 / 咏梅 / 齐溪 / 王源 / 杜江 / 艾丽娅 / 徐程 / 李菁菁 / 赵燕国彰 / 鲍振江 / 吴双 / 王子子 / 张新园 / 吴佳宸 / 王亚军 / 刘芮麟 / 中国大陆 / 王小帅 / 175分钟 / 剧情 / 家庭 / 阿美 A Mei...
								</p>
								
							</div>
							<div class="movie-degree">
								<span <span class="degree-tag">8.9</span>
								<img src="../img/open-iconic-master/people-2x.png" alt=""> (111234评价)
							</div>
					    </div>
				  	</div>
				</div>
		
	</div>



	<div id="footer">
		<div class="my-hr" >
			<div id="copyright" class="h-center v-center">
				<p>想看电影   &copy;第八小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</p>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$('#movie-info-card h5 a').click(function () {
			if ($(this).attr('class') == '') {
				$(this).addClass('active');
			}else{
				$(this).removeClass('active');
			}
			$(this).parent().siblings().find('a').removeClass("active");
		
		});

	</script>
</body>
</html>