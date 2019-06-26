<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta name="referrer" content="never">
	
	<title>电影详情</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="../css/movieDetail.css">
	<link rel="stylesheet" href="../css/degreebar.css">

	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/script.js"></script>
	<script src="../js/xscript.js"></script>
	

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
	    			<a class="nav-link" href="../index/index">主页<span class="sr-only">(current)</span></a>
	      		</li>
	      		<li class="nav-item">
	        		<a class="nav-link" href="../smovie/selectMovie">选电影</a>
	     		</li>
	     		<li class="nav-item">
	        		<a class="nav-link" href="../Rank/NewRank">排行榜</a>
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
			
				<c:if test="${isLogin == false }">
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
					<span>${movie.mname }</span>
					<!--<span class="year">(2018)</span>-->	
				</h2>
				<div class="media">
				  	<div class="media-left">
					    <a href="#" class="comment-cover " target="_blank" style="width: 10rem">
					      <img class="media-object" src="${movie.img }" alt="" >
					    </a>
				  	</div>
				  	<div class="media-body">
						<div id="movie-info">
							<span>
								<span class="p1">导演</span>
								<span class="attrs">
									<a href="#">${movie.mdirect }</a>
									
								</span>
							</span>
							<br>

							<span>
								<span class="p1">编剧</span>
								<span class="attrs">
									<a href="#">${movie.mwriter }</a> /
								</span>
							</span>
							<br>

							<span class="actors">
								<span class="p1">主演</span>
								<span class="attrs">
									<a href="#">${movie.mactor }</a> /
								</span>
							</span>
							<br>

							<span>
								<span class="p1">类型</span>
								<span>${movie.mtag }</span>
							</span>
							<br>

							<span>
								<span class="p1">制片国家/地区</span>
								 ${movie.mcountry }
							</span>
							<br>
							<span>
								<span class="p1">语言</span>
								 ${movie.mlanguage }
							</span>
							<br>

							<span>
								<span class="p1">上映日期</span>
								 ${movie.mtime }
							</span>
							<br>

							<span>
								<span class="p1">片长</span>
								 ${movie.mlong }
							</span>
							<br>
							<span>
								<span class="p1">又名</span>
								  ${movie.malias }
							</span>
					    </div>
				  	</div>
				</div>
				
				<div class="card degree-card">
				  	<div class="card-header clearfix">
				    	<h4>电影评分 >></h4>
				    	<p class="write-degree"  data-toggle="modal" data-target="#exampleModalCenter"><img src="../img/open-iconic-master/star-2x.png" alt="">  我要评分</p>
				  	</div>
				  	<div class="card-body">
				 		<div id="movie-degree">
				 			<span>${movie.mscore }</span>
							<p><img src="../img/open-iconic-master/people-2x.png" alt="">    ${movie.mcount }人评价</p>
				 		</div>
				 		<div id="degree-detail">
				 			<div class="degree clearfix">
				 				<div class="percent">
					 			>=80%
					 			</div>
					 			<div class="progress">
	  								<div class="progress-bar bg-dark" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
	  								50%
								</div>
				 			</div>
				 			<div class="degree clearfix">
				 				<div class="percent">
					 			>=60%
					 			</div>
					 			<div class="progress">
	  								<div class="progress-bar bg-dark" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
	  									30%
								</div>
				 			</div>
				 			<div class="degree clearfix">
				 				<div class="percent">
					 			>=40%
					 			</div>
					 			<div class="progress">
	  								<div class="progress-bar bg-dark" role="progressbar" style="width: 14%" aria-valuenow="14" aria-valuemin="0" aria-valuemax="100"></div>
	  								14%
								</div>
				 			</div>
				 			<div class="degree clearfix">
				 				<div class="percent">
					 			>=20%
					 			</div>
					 			<div class="progress">
	  								<div class="progress-bar bg-dark" role="progressbar" style="width: 5%" aria-valuenow="5" aria-valuemin="0" aria-valuemax="100"></div>
	  								5%
								</div>
				 			</div>
				 			<div class="degree clearfix">
				 				<div class="percent">
					 			>=0  
					 			</div>
					 			<div class="progress">
	  								<div class="progress-bar bg-dark" role="progressbar" style="width: 1%" aria-valuenow="1" aria-valuemin="0" aria-valuemax="100"></div>
	  								1%
								</div>
				 			</div>
				 		</div>



				  </div>
				</div>	

				<div class="card">
				  	<div class="card-header">
				    	<h4>剧情简介 >></h4>
				  	</div>
				  	<div class="card-body">
				    <blockquote class="blockquote mb-0">
				      	<p>${movie.mbrief }</p>
				      	<!-- <footer class="blockquote-footer">简介源自 <cite title="Source Title">网络</cite></footer> -->
				    </blockquote>
				  </div>
				</div>
		</div>
		
		<div class="my-hr" >
			
		</div>

		<div id="comment-selector" class="selector">
			<div id="comment-tag-list" class="tag-list v-center">
				<ul class="clearfix">
					<li>
						<span class="badge badge-dark" id="main-badge">最受欢迎的</span>
					</li>
					<li>
						<span class="badge badge-yellow" >热门
							<input type="radio" name="tag" value="热门" class="tag">
						</span>
					</li>

					<li>
						<span class="badge badge-yellow" >最新
							<input type="radio" name="tag" value="最新" class="tag">
						</span>
						
					</li>

					<li>
						<span class="badge badge-yellow" >好友
							<input type="radio" name="tag" value="好友" class="tag">
						</span>
						
					</li>

					<li  id="write-review-icon">
						<a  href="../sreview/writeReview?mid=${movie.mid }" > <img src="../img/open-iconic-master/pencil-2x.png" alt="">   我要写影评
						</a>
						
					</li>
					
				</ul>
			</div>
		</div>

		<div id="comment-box">
			<div id="comments-cards">
			<%if(request.getAttribute("commentsList") == "还未有用户评论") {%>
				<h1>还未有用户评论</h1><br>
			<%}else{%>
			<c:forEach items="${commentsList}" var="comment">
				<div class="comment-card-item">
					<div class="card">
				  		<div class="card-body">
							<div id="review-meta">
								<a href="#"><img src="${comment.uimg }" alt=""></a>
						    	<a href="#">${comment.username }</a>
						    	<strong class="item-degree" title="推荐">${movie.mscore }</strong>
						    	<p>${comment.cdate }</p>
						    </div>
					    	<h4 class="media-heading"><a href="#">${comment.ctitle }</a></h4>
					
					    	<p style="color: #666667;">${comment.content} <a href="#" class="btn btn-link">全文</a></p>

					    	<div class="action">
						    	<a href="#" title="有用" >▲ ${comment.clike }</span></a>
						    	<a href="#" title="无用">▼ ${comment.cdislike }</span></a> 
						    	<a href="" class="reply" style="margin: 0 1rem;">28回复</a>
						    </div>
					  	</div>
					</div>
				</div>
				</c:forEach><%} %>
			</div>
		</div>




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



	<div id="footer">
		<div class="my-hr" >
			<div id="copyright" class="h-center v-center">
				<p>想看电影   &copy;第七小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</p>
			</div>
		</div>
	</div>
	</div>


	



	



	<script type="text/javascript">
	</script>

</body>
</html>