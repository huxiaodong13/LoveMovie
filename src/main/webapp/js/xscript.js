function time(time = +new Date()) {
    var date = new Date(time + 8 * 3600 * 1000);
    return date.toJSON().substr(0, 11).replace('T', ' ');
}

$(function(){

	$('#newDate-movies-items').on('mouseover','.movie-item',function(){
//		console.log('over');
//		console.log($(this));
		$(this).find('.item-info-summary').show();
	});
	
	$('#newDate-movies-items').on('mouseleave','.movie-item',function(){
//		console.log('left');
//		console.log($(this));
		$(this).find('.item-info-summary').hide();
	});
	

	//设置最大值
    ScrollBar.maxValue = 100;
    //初始化
    ScrollBar.Initialize();

	$('#myModal').modal();


});

$(document).ready(function() {
	//热门电影
	$("#block-hot").on("click",function(){
		$.ajax({
			url : "showHotMovies",
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#newDate-movies-items").empty();//清空
				// 将字符串数据转换为json数据
				 //var info = JSON.parse(data);
				 //var movies = info.list;
				 $.each(data, function(key, value) { // 遍历json中的key和value
					 console.log(value.mid);
					 console.log(value.mname);
					 var item = '<a href="../movie/movieDetail?mid='+value.mid+'" class="movie-item" target="_blank">'+
							'<div class="card" style="width: 12rem;">'+
						'<img class="card-img-top" src="'+ value.img +'"alt="Card image cap">'+
						'<div class="card-body movie-info">'+
							'<span class="card-title item-name">'+value.mname+'</span>'+
							'<strong class="item-degree card-text">'+value.mscore+'</strong>'+
						'</div>'+
					'</div>'+
					'<div class="item-info-summary">'+
						'<h4>'+value.mname+'</h4>'+
						'<strong class="item-degree card-text">'+value.mscore+'</strong>'+
						'<div class="item-tags">'+
							'<span class="item-tag">'+value.mlong+'</span>'+
							'<span class="item-tag">'+value.mtag+'</span>'+
							'<span class="item-tag">'+value.mdirect+'</span>'+							
						'</div>'+
						'<hr>'+
						'<div class="isWatched">'+
							'<span class="item-tag"'+
								'style="background-color: #212529; color: white;">想看</span>'+
						'</div>'+
					'</div>'+
				'</a>'+'';	
					$("#newDate-movies-items").append(item);
				 }); 

			},error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			}
		});
	});
	
	//最新电影
	$("#block-date").on("click",function(){
		$.ajax({
			url : "showDateMovies",
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#newDate-movies-items").empty();//清空
				// 将字符串数据转换为json数据
				 $.each(data, function(key, value) { // 遍历json中的key和value
					 console.log(value.mid);
					 console.log(value.mname);
					 var item = '<a href="../movie/movieDetail?mid='+value.mid+'" class="movie-item" target="_blank">'+
							'<div class="card" style="width: 12rem;">'+
						'<img class="card-img-top" src="'+ value.img +'"alt="Card image cap">'+
						'<div class="card-body movie-info">'+
							'<span class="card-title item-name">'+value.mname+'</span>'+
							'<strong class="item-degree card-text">'+value.mscore+'</strong>'+
						'</div>'+
					'</div>'+
					'<div class="item-info-summary">'+
						'<h4>'+value.mname+'</h4>'+
						'<strong class="item-degree card-text">'+value.mscore+'</strong>'+
						'<div class="item-tags">'+
							'<span class="item-tag">'+value.mlong+'</span>'+ 
							'<span class="item-tag">'+value.mtag+'</span>'+
							'<span class="item-tag">'+value.mdirect+'</span>'+							
						'</div>'+
						'<hr>'+
						'<div class="isWatched">'+
							'<span class="item-tag"'+
								'style="background-color: #212529; color: white;">想看</span>'+
						'</div>'+
					'</div>'+
				'</a>'+'';	
					$("#newDate-movies-items").append(item);
				 }); 

			},error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			}
		});
	});

	//高分电影
	$("#block-score").on("click",function(){
		$.ajax({
			url : "showScoreMovies",
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#newDate-movies-items").empty();//清空
				// 将字符串数据转换为json数据
				 $.each(data, function(key, value) { // 遍历json中的key和value
					 console.log(value.mid);
					 console.log(value.mname);
					 var item = '<a href="../movie/movieDetail?mid='+value.mid+'" class="movie-item" target="_blank">'+
							'<div class="card" style="width: 12rem;">'+
						'<img class="card-img-top" src="'+ value.img +'"alt="Card image cap">'+
						'<div class="card-body movie-info">'+
							'<span class="card-title item-name">'+value.mname+'</span>'+
							'<strong class="item-degree card-text">'+value.mscore+'</strong>'+
						'</div>'+
					'</div>'+
					'<div class="item-info-summary">'+
						'<h4>'+value.mname+'</h4>'+
						'<strong class="item-degree card-text">'+value.mscore+'</strong>'+
						'<div class="item-tags">'+
							'<span class="item-tag">'+value.mlong+'</span>'+ 
							'<span class="item-tag">'+value.mtag+'</span>'+
							'<span class="item-tag">'+value.mdirect+'</span>'+							
						'</div>'+
						'<hr>'+
						'<div class="isWatched">'+
							'<span class="item-tag"'+
								'style="background-color: #212529; color: white;">想看</span>'+
						'</div>'+
					'</div>'+
				'</a>'+'';	
					$("#newDate-movies-items").append(item);
				 }); 

			},error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			}
		});
	});

	//冷门电影
	$("#block-cold").on("click",function(){
		$.ajax({
			url : "showColdMovies",
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#newDate-movies-items").empty();//清空
				// 将字符串数据转换为json数据
				 $.each(data, function(key, value) { // 遍历json中的key和value
					 console.log(value.mid);
					 console.log(value.mname);
					 var item = '<a href="../movie/movieDetail?mid='+value.mid+'" class="movie-item" target="_blank">'+
							'<div class="card" style="width: 12rem;">'+
						'<img class="card-img-top" src="'+ value.img +'"alt="Card image cap">'+
						'<div class="card-body movie-info">'+
							'<span class="card-title item-name">'+value.mname+'</span>'+
							'<strong class="item-degree card-text">'+value.mscore+'</strong>'+
						'</div>'+
					'</div>'+
					'<div class="item-info-summary">'+
						'<h4>'+value.mname+'</h4>'+
						'<strong class="item-degree card-text">'+value.mscore+'</strong>'+
						'<div class="item-tags">'+
							'<span class="item-tag">'+value.mlong+'</span>'+ 
							'<span class="item-tag">'+value.mtag+'</span>'+
							'<span class="item-tag">'+value.mdirect+'</span>'+							
						'</div>'+
						'<hr>'+
						'<div class="isWatched">'+
							'<span class="item-tag"'+
								'style="background-color: #212529; color: white;">想看</span>'+
						'</div>'+
					'</div>'+
				'</a>'+'';	
					$("#newDate-movies-items").append(item);
				 }); 

			},error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			}
		});
	});

	//热门影评
	$("#indexHotComment").on("click",function(){
		$.ajax({
			url : "showHotComment",
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#comments").empty();//清空
				// 将字符串数据转换为json数据
				 $.each(data, function(key, value) { // 遍历json中的key和value
					 console.log(value.mid);
					 var content = value.content.substring(100);
					 var item = '<div class="comment-item">'+
					 				'<div class="media">'+
					 					'<div class="media-left">'+
					 						'<a href="#" class="comment-cover " target="_blank" style="width: 10rem">'+
					 							'<img class="media-object" src="'+value.img+'" alt=""></a>'+
					 					'</div>'+
					 				'<div class="media-body comment-info">'+
					 					'<h4 class="media-heading">'+
					 					 '<a href="../review/reviewDetail?mname='+value.mname+ '&cid='+value.cid+ '">'+value.ctitle+'</a>'+
					 					 '</h4>'+
					 				'<div id="review-meta">'+
					 					'<a href="#">'+value.username+'</a> &nbsp;评论&nbsp; <a href="#">'+value.mname+'</a>'+
					 					'<strong class="item-degree">'+value.cscore+'</strong>'+
					 				'</div>'+
					 				'<p style="color: #666667;">'+content+
					 					'<a href="#" class="btn btn-link">全文</a>'+
					 				'</p>'+
					 			'</div>'+
					 			'</div>'+
					 			'</div>'+'';	
					$("#comments").append(item);
				 }); 

			},error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			}
		});
	});
	
	//新片影评
	$("#indexNewComment").on("click",function(){
		$.ajax({
			url : "showDateComment",
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#comments").empty();//清空
				// 将字符串数据转换为json数据
				 $.each(data, function(key, value) { // 遍历json中的key和value
					 var content = value.content.substring(100);
					 var item = '<div class="comment-item">'+
					 				'<div class="media">'+
					 					'<div class="media-left">'+
					 						'<a href="#" class="comment-cover " target="_blank" style="width: 10rem">'+
					 							'<img class="media-object" src="'+value.img+'" alt=""></a>'+
					 					'</div>'+
					 				'<div class="media-body comment-info">'+
					 					'<h4 class="media-heading">'+
					 					 '<a href="../review/reviewDetail?mname='+value.mname+ '&cid='+value.cid+ '">'+value.ctitle+'</a>'+
					 					 '</h4>'+
					 				'<div id="review-meta">'+
					 					'<a href="#">'+value.username+'</a> &nbsp;评论&nbsp; <a href="#">'+value.mname+'</a>'+
					 					'<strong class="item-degree">'+value.cscore+'</strong>'+
					 				'</div>'+
					 				'<p style="color: #666667;">'+content+
					 					'<a href="#" class="btn btn-link">全文</a>'+
					 				'</p>'+
					 			'</div>'+
					 			'</div>'+
					 			'</div>'+'';	
					$("#comments").append(item);
				 }); 

			},error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			}
		});
	});

	//所有新片影评
	$("#newReview").on("click",function(){
		$.ajax({
			url : "showNewComment",
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#comments").empty();//清空
				// 将字符串数据转换为json数据
				 $.each(data, function(key, value) { // 遍历json中的key和value
					 var content = value.content.substring(100);
					 var item = '<div class="comment-item">'+
			 				'<div class="media">'+
			 					'<div class="media-left">'+
			 						'<a href="#" class="comment-cover " target="_blank" style="width: 10rem">'+
			 							'<img class="media-object" src="'+value.img+'" alt="" >'+
			 						'</a>'+
			 					'</div>'+
			 					'<div class="media-body comment-info">'+
			 						'<div id="review-meta">'+
			 							'<a href="#"><img src="'+value.uimg+'" alt=""></a>'+
			 							'<a href="#">'+value.username+'</a>'+
			 							'<strong class="item-degree" title="推荐">'+value.mscore+'</strong>'+
			 							'<p>'+time(value.cdate)+'</p>'+
			 						'</div>'+
			 						'<h4 class="media-heading"><a href="#">'+value.ctitle+'</a></h4>'+
			 						'<p style="color: #666667;">'+content + '<a href="#" class="btn btn-link">全文</a></p>'+
			    	'<div class="action">'+
				    	'<a href="#" title="有用" >▲ ' +value.clike+ '</span></a>'+
				    	'<a href="#" title="无用">▼ '+value.cdislike+ '</span></a>'+ 
				    	'<a href="" class="reply" style="margin: 0 1rem;">28回复</a>'+
				    '</div>'+
			  	'</div>'+
			'</div>'+
		'</div>'+'';	
					$("#comments").append(item);
				 }); 

			},error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			}
		});
	});

	
	//所有热门影评
	$("#hotReview").on("click",function(){
		$.ajax({
			url : "showHotComment",
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#comments").empty();//清空
				// 将字符串数据转换为json数据
				 $.each(data, function(key, value) { // 遍历json中的key和value
					 var content = value.content.substring(100);
					 var item = '<div class="comment-item">'+
			 				'<div class="media">'+
			 					'<div class="media-left">'+
			 						'<a href="#" class="comment-cover " target="_blank" style="width: 10rem">'+
			 							'<img class="media-object" src="'+value.img+'" alt="" >'+
			 						'</a>'+
			 					'</div>'+
			 					'<div class="media-body comment-info">'+
			 						'<div id="review-meta">'+
			 							'<a href="#"><img src="'+value.uimg+'" alt=""></a>'+
			 							'<a href="#">'+value.username+'</a>'+
			 							'<strong class="item-degree" title="推荐">'+value.mscore+'</strong>'+
			 							'<p>'+time(value.cdate)+'</p>'+
			 						'</div>'+
			 						'<h4 class="media-heading"><a href="#">'+value.ctitle+'</a></h4>'+
			 						'<p style="color: #666667;">'+content + '<a href="#" class="btn btn-link">全文</a></p>'+
			    	'<div class="action">'+
				    	'<a href="#" title="有用" >▲ ' +value.clike+ '</span></a>'+
				    	'<a href="#" title="无用">▼ '+value.cdislike+ '</span></a>'+ 
				    	'<a href="" class="reply" style="margin: 0 1rem;">28回复</a>'+
				    '</div>'+
			  	'</div>'+
			'</div>'+
		'</div>'+'';	
					$("#comments").append(item);
				 }); 

			},error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			}
		});
	});

	//经典排行榜10
	$("#classicsRank").on("click",function(){
		$.ajax({
			url : "classicsRankMovies",
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#movies").empty();//清空
				// 将字符串数据转换为json数据
				 $.each(data, function(key, value) { // 遍历json中的key和value
					 console.log(value.mid);
					 console.log(value.mname);
					 var item = '<div class="media">'+
				  					'<div class="media-left">'+
				  						'<a href="#" class="comment-cover " target="_blank" style="width: 8rem">'+
				  						'<img class="media-object" src="'+value.img+'" alt="" >'+
				  						'</a>'+
				  					'</div>'+
				  					'<div class="media-body">'+
				  						'<div id="movie-info">'+
				  							'<div class="media-heading">'+
				  							'<h4><a href="#">'+value.mname+'</a></h4>'+
				  						'</div>'+
				  						'<div class="movie-sum">'+
				  							'<p>'+ value.mtime+ value.mactor + value.mlong + value.mtag + '</p>'+
				  						'</div>'+
				  						'<div class="movie-degree">'+
				  							'<span class="degree-tag">'+value.mscore+'</span>'+
				  							'<img src="../img/open-iconic-master/people-2x.png" alt="">'+value.mcount+"点赞"+
				  						'</div>'+
				  					'</div>'+
				  				'</div>'+
				  			'</div>'+'';	
					$("#movies").append(item);
				 }); 

			},error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			}
		});
	});
	
	//新片排行榜
	$("#NewRank").on("click",function(){
		$.ajax({
			url : "newRankMovies",
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#movies").empty();//清空
				// 将字符串数据转换为json数据
				 $.each(data, function(key, value) { // 遍历json中的key和value
					 console.log(value.mid);
					 console.log(value.mname);
					 var item = '<div class="media">'+
				  					'<div class="media-left">'+
				  						'<a href="#" class="comment-cover " target="_blank" style="width: 8rem">'+
				  						'<img class="media-object" src="'+value.img+'" alt="" >'+
				  						'</a>'+
				  					'</div>'+
				  					'<div class="media-body">'+
				  						'<div id="movie-info">'+
				  							'<div class="media-heading">'+
				  							'<h4><a href="#">'+value.mname+'</a></h4>'+
				  						'</div>'+
				  						'<div class="movie-sum">'+
				  							'<p>'+ value.mtime+ value.mactor + value.mlong + value.mtag + '</p>'+
				  						'</div>'+
				  						'<div class="movie-degree">'+
				  							'<span class="degree-tag">'+value.mscore+'</span>'+
				  							'<img src="../img/open-iconic-master/people-2x.png" alt="">'+value.mcount+"点赞"+
				  						'</div>'+
				  					'</div>'+
				  				'</div>'+
				  			'</div>'+'';	
					$("#movies").append(item);
				 }); 

			},error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			}
		});
	});
	
});

