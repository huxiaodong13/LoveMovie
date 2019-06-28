<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta name="referrer" content="never">
	
	<title>想看电影——写影评</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="../css/degreebar.css">
	<link rel="stylesheet" href="../css/writeReview.css">


	<script src="../js/jquery.min.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/script.js"></script>
	<script src="../js/writeReview.js"></script>
	<script src="../ckeditor/ckeditor.js"></script>


</head>
<body>
	<div id="header">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="index">想看电影</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    	<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
	    		<li class="nav-item active">
	    			<a class="nav-link" href="#">写影评<span class="sr-only">(current)</span></a>
	      		</li>
	     		
	    	</ul>
	    	<form class="form-inline my-2 my-lg-0">

			<ul class="navbar-nav">
		    	<li class="nav-item dropdown" id="user-drop">
		        	<a class="nav-link dropdown-toggle" href="userInfo" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		        		${user.username }
		    		</a>
		    		<div class="dropdown-menu" aria-labelledby="navbarDropdown">
		      			<a class="dropdown-item" href="../index/userInfo">个人中心</a>
		      			<div class="dropdown-divider"></div>
		      			<a class="dropdown-item" href="../index/logout">退出</a>
		        	</div>
		      	</li>
	      	</ul>
	  </div>
	</nav>
	</div>
	<div id="content" style="background-color: white;">
		

<!-- ***********************************写影评*********************************** -->

<!--   -->
		<a href="#" id="movie-summary-card " target="_blank">
			<div class="media" >
				<!-- <a href="#" id="movie-summary-card " target="_blank"> -->
				  	<div class="media-left">
					    <img class="media-object" src="${movie.img }" alt="${movie.mname }图片"  style="width: 5rem">  
				  	</div>
				  	<div class="media-body">
						<h4 class="media-heading"><a href="movieDeatil?mid=${movie.mid }" id="sm-title">${movie.mname }</a></h4>
							
						<p class="movie-summary" >导演 ${movie.mdirect} / 主演 ${movie.mactor } ${movie.mcountry } / ${movie.mscore }分 (${movie.mcount }评价)</p>
					</div>
				<!-- </a> -->
			</div>
		</a>

		<div class="card">
		  	<div class="card-header">
		    	<h4><img src="../img/open-iconic-master/star-3x.png" alt="">  给个评价吧 </h4>
		  	</div>
		  	<div class="card-body">
		    	<div id="Main">
		          	<div id="scrollBar">
		            	<div id="scroll_Track"></div>
		            	<div id="scroll_Thumb"></div>
		          	</div>
		        	<p id="scrollBarTxt" style="text-align:center;" class="score-bar"></p>
		    	</div>
			</div>

			<div id="write-Review">
				<form action="">
					<div id="review-heading">
					<label title="stitle">标题</label>
					<input type="text" id="head" name="stitle">
					</div>	
					
					<textarea name="editor1"></textarea>
	                <script>
	                        CKEDITOR.replace( 'editor1' );
	                </script>
				</form>
				
			</div>
			<div class="card-footer">
				<input  type="button" class="btn btn-dark" value="发表" id="btn-subReview">
			</div>
		</div>
		
		
	</div>
	<div id="footer">
		<div class="my-hr" >
			<div id="copyright" class="h-center v-center">
				<p>想看电影   &copy;第七小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</p>
			</div>
		</div>
	</div>
	
	<!-- 
		<script>
		 	var data = CKEDITOR.instances.editor1.getData();
		</script>
	 -->
	

</body>
</html>