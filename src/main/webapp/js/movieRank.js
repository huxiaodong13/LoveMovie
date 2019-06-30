/**
 * 电影排行榜 
 */

$(function(){

	//-----排行榜---经典排行榜10
	$("#classicsRank").on("click",function(){
		
		console.log("经典top10");
		
		
		$.ajax({
			url : "getClassicMovieRankData",
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#moviesRankItems").empty();//清空
				$('#moviesRank-pagination').empty();
				
				// 将字符串数据转换为json数据
				 $.each(data, function(key, value) { // 遍历json中的key和value
					 console.log(value.mid);
					 console.log(value.mname);
					 var item = '<div class="media">'+
				  					'<div class="media-left">'+
				  						'<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank" style="width: 8rem">'+
				  						'<img class="media-object" src="'+value.img+'" alt="" >'+
				  						'</a>'+
				  					'</div>'+
				  					'<div class="media-body">'+
				  						'<div id="movie-info">'+
				  							'<div class="media-heading">'+
				  							'<h4><a href="../movie/movieDetail?mid='+value.mid+'">'+value.mname+'</a></h4>'+
				  						'</div>'+
				  						'<div class="movie-sum">'+
				  							'<p>'+ value.mtime+ value.mactor + value.mlong + value.mtag + '</p>'+
				  						'</div>'+
				  						'<div class="movie-degree">'+
				  							'<span class="degree-tag">'+value.mscore+'</span>'+
				  							'<img src="../img/open-iconic-master/people-2x.png" alt="">'+value.mcount+"评分"+
				  						'</div>'+
				  					'</div>'+
				  				'</div>'+
				  			'</div>'+'';	
					$("#moviesRankItems").append(item);
				 }); 

			},error : function(errordata) {
				console.log(errordata);
			}
		});
	});
	
	//---排行榜----新片排行榜 新片排行 ---
 	$("#NewRank").on("click",function(){
 		
 		
 		console.log("新片");
 		var requestUrl = "getNewMovieRankData?page=";
 		
		$.ajax({
			url : "getNewMovieRankData?page=1",
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#moviesRankItems").empty();//清空
				
				var movies = data.list;
				
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 
					 var item = '<div class="media">'+
				  					'<div class="media-left">'+
				  						'<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank" style="width: 8rem">'+
				  						'<img class="media-object" src="'+value.img+'" alt="" >'+
				  						'</a>'+
				  					'</div>'+
				  					'<div class="media-body">'+
				  						'<div id="movie-info">'+
				  							'<div class="media-heading">'+
				  							'<h4><a href="../movie/movieDetail?mid='+value.mid+'">'+value.mname+'</a></h4>'+
				  						'</div>'+
				  						'<div class="movie-sum">'+
				  							'<p>'+ value.mtime+ value.mactor + value.mlong + value.mtag + '</p>'+
				  						'</div>'+
				  						'<div class="movie-degree">'+
				  							'<span class="degree-tag">'+value.mscore+'</span>'+
				  							'<img src="../img/open-iconic-master/people-2x.png" alt="">'+value.mcount+"评分"+
				  						'</div>'+
				  					'</div>'+
				  				'</div>'+
				  			'</div>'+'';	
					$("#moviesRankItems").append(item);
				 }); 
				 
				 var prePage = "";
				 var nextPage = "";
				 
				//修改页码
				 var infoPage = data;
				 if(infoPage.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-movieRank"\
								value="'+requestUrl+infoPage.prePage+'">上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page"  tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item disabled page-link">'+infoPage.pageNum+' / '+infoPage.pages+'</li>'
				 
				 if(infoPage.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-movieRank"\
								value="'+requestUrl+infoPage.nextPage+'">下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
				 }
				 
				 $("#moviesRank-pagination").empty();
				 $("#moviesRank-pagination").append(prePage);
				 $("#moviesRank-pagination").append(nowPage);
				 $("#moviesRank-pagination").append(nextPage);

			},error : function(errordata) {
				console.log(errordata);
			}
		});
	});
 	
	//---排行榜----新片排行榜 新片排行 下一页---
 	$('#moviesRank-pagination').on('click', '#next-page-movieRank', function(){

 		var url = $(this).attr('value');
 		
 		console.log("新片下一页");
 		var requestUrl = "getNewMovieRankData?page=";
 		
		$.ajax({
			url : url,
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#moviesRankItems").empty();//清空
				
				var movies = data.list;
				
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 
					 var item = '<div class="media">'+
				  					'<div class="media-left">'+
				  						'<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank" style="width: 8rem">'+
				  						'<img class="media-object" src="'+value.img+'" alt="" >'+
				  						'</a>'+
				  					'</div>'+
				  					'<div class="media-body">'+
				  						'<div id="movie-info">'+
				  							'<div class="media-heading">'+
				  							'<h4><a href="../movie/movieDetail?mid='+value.mid+'">'+value.mname+'</a></h4>'+
				  						'</div>'+
				  						'<div class="movie-sum">'+
				  							'<p>'+ value.mtime+ value.mactor + value.mlong + value.mtag + '</p>'+
				  						'</div>'+
				  						'<div class="movie-degree">'+
				  							'<span class="degree-tag">'+value.mscore+'</span>'+
				  							'<img src="../img/open-iconic-master/people-2x.png" alt="">'+value.mcount+"评分"+
				  						'</div>'+
				  					'</div>'+
				  				'</div>'+
				  			'</div>'+'';	
					$("#moviesRankItems").append(item);
				 }); 
				 
				 var prePage = "";
				 var nextPage = "";
				 
				//修改页码
				 var infoPage = data;
				 if(infoPage.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-movieRank"\
								value="'+requestUrl+infoPage.prePage+'">上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page"  tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item disabled page-link">'+infoPage.pageNum+' / '+infoPage.pages+'</li>'
				 
				 if(infoPage.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-movieRank"\
								value="'+requestUrl+infoPage.nextPage+'">下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
				 }
				 
				 $("#moviesRank-pagination").empty();
				 $("#moviesRank-pagination").append(prePage);
				 $("#moviesRank-pagination").append(nowPage);
				 $("#moviesRank-pagination").append(nextPage);
				 
			},error : function(errordata) {
				console.log(errordata);
			}
		});
	});
 	
	//---排行榜----新片排行榜 新片排行 上一页---
 	$('#moviesRank-pagination').on('click', '#pre-page-movieRank', function(){

 		var url = $(this).attr('value');
 		
 		console.log("新片上一页");
 		var requestUrl = "getNewMovieRankData?page=";
 		
		$.ajax({
			url : url,
			type : "post",
	        dataType: 'json', 
	        data: { },
			success : function(data) {
				$("#moviesRankItems").empty();//清空
				
				var movies = data.list;
				
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 
					 var item = '<div class="media">'+
				  					'<div class="media-left">'+
				  						'<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank" style="width: 8rem">'+
				  						'<img class="media-object" src="'+value.img+'" alt="" >'+
				  						'</a>'+
				  					'</div>'+
				  					'<div class="media-body">'+
				  						'<div id="movie-info">'+
				  							'<div class="media-heading">'+
				  							'<h4><a href="../movie/movieDetail?mid='+value.mid+'">'+value.mname+'</a></h4>'+
				  						'</div>'+
				  						'<div class="movie-sum">'+
				  							'<p>'+ value.mtime+ value.mactor + value.mlong + value.mtag + '</p>'+
				  						'</div>'+
				  						'<div class="movie-degree">'+
				  							'<span class="degree-tag">'+value.mscore+'</span>'+
				  							'<img src="../img/open-iconic-master/people-2x.png" alt="">'+value.mcount+"评分"+
				  						'</div>'+
				  					'</div>'+
				  				'</div>'+
				  			'</div>'+'';	
					$("#moviesRankItems").append(item);
				 }); 
				 
				 var prePage = "";
				 var nextPage = "";
				 
				//修改页码
				 var infoPage = data;
				 if(infoPage.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-movieRank"\
								value="'+requestUrl+infoPage.prePage+'">上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page"  tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item disabled page-link">'+infoPage.pageNum+' / '+infoPage.pages+'</li>'
				 
				 if(infoPage.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-movieRank"\
								value="'+requestUrl+infoPage.nextPage+'">下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
				 }
				 
				 $("#moviesRank-pagination").empty();
				 $("#moviesRank-pagination").append(prePage);
				 $("#moviesRank-pagination").append(nowPage);
				 $("#moviesRank-pagination").append(nextPage);
				 
			},error : function(errordata) {
				console.log(errordata);
			}
		});
	});
	
});