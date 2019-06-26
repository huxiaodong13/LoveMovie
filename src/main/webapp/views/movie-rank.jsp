<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
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
	<script src="../js/xscript.js"></script>
	<meta name="referrer" content="never">

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
	    			<a class="nav-link" href="../index/index">主页</a>
	      		</li>
	      		<li class="nav-item">
	        		<a class="nav-link" href="../smovie/selectMovie">选电影</a>
	     		</li>
	     		<li class="nav-item">
	        		<a class="nav-link" href="../Rank/NewRank">排行榜<span class="sr-only">(current)</span></a>
	     		</li>
	     		<li class="nav-item">
	        		<a class="nav-link" href="../review/Review">影评</a>
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
<!-- 					<span><a id="NewRank" class="active">新片排行榜</a></span> / 
					<span><a id="classicsRank" class="">经典TOP10</a></span>
					<div id="comments"></div>
 -->				
					<span><a href="NewRank" class="active">新片排行榜</a></span> / 
					<span><a href="classicsRank" class="">经典TOP10</a></span>
				</h5>
			<c:forEach items="${moviesRank}" var="movieRank">
				<div class="media">
				  	<div class="media-left">
					    <a href="#" class="comment-cover " target="_blank" style="width: 8rem">
					      <img class="media-object" src="${movieRank.img }" alt="" >
					    </a>
				  	</div>
				  	<div class="media-body">
						<div id="movie-info">
							<div class="media-heading">
								<h4>
									<a href="#">${movieRank.mname }</a>
								</h4>
								
							</div>
							<div class="movie-sum">
								<p>
									${movieRank.mtime } ${movieRank.mactor} ${movieRank.mlong } ${movieRank.mtag }
								</p>
								
							</div>
							<div class="movie-degree">
								<span class="degree-tag">${movieRank.mscore }</span>
								<img src="../img/open-iconic-master/people-2x.png" alt=""> ${movieRank.mcount}点赞
							</div>
					    </div>
				  	</div>
				</div>
			</c:forEach>
		</div>



	<div id="footer">
		<div class="my-hr" >
			<div id="copyright" class="h-center v-center">
				<p>想看电影   &copy;第七小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</p>
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
	</div>
</body>
</html>