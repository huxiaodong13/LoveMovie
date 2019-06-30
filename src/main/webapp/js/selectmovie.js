/**
 *	选电影的js文件 
 */


$(document).ready(function() {
	
	/**
	 * 热门电影 
	 */
	$('#shot-movie').click(function(){
		console.log("点击热门电影");
		$.ajax({
			url : "showHotMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value=showHotMovies?page='+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled pre-page page-link" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value=showHotMovies?page='+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled page-link next-page" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 最新电影
	 */
	$('#snew-movie').click(function(){
		console.log("点击最新电影");
		$.ajax({
			url : "showNewMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value=showNewMovies?page='+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled pre-page page-link" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value=showNewMovies?page='+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled page-link next-page" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	

	/**
	 * 最新电影
	 */
	$('#snew-movie').click(function(){
		console.log("点击最新电影");
		$.ajax({
			url : "showNewMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item pre-page page-link" id="pre-page-selectMovie"\
								value=showNewMovies?page='+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value=showNewMovies?page='+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled page-link next-page" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 经典电影
	 */
	$('#sclassic-movie').click(function(){
		console.log("点击经典电影");
		
		var requestUrl = "showClassicMovies?page=";
		
		$.ajax({
			url : "showClassicMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 可播放电影
	 */
	$('#splayable-movie').click(function(){
		console.log("点击可播放电影");
		
		var requestUrl = "showPlayableMovies?page=";
		
		$.ajax({
			url : "showPlayableMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 高分电影
	 */
	$('#shighscore-movie').click(function(){
		console.log("点击高分电影");
		
		var requestUrl = "showHighScoreMovies?page=";
		
		$.ajax({
			url : "showHighScoreMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link"> '+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled page-link next-page" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 冷门电影
	 */
	$('#sdarkHouse-movie').click(function(){
		console.log("点击高分电影");
		
		var requestUrl = "showDarkHouseMovies?page=";
		
		$.ajax({
			url : "showDarkHouseMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item next-page page-link" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 华语电影
	 */
	$('#sChinese-movie').click(function(){
		console.log("点击华语电影");
		
		var requestUrl = "showChineseMovies?page=";
		
		$.ajax({
			url : "showChineseMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 韩国电影
	 */
	$('#skorean-movie').click(function(){
		console.log("点击华语电影");
		
		var requestUrl = "showKoreanMovies?page=";
		
		$.ajax({
			url : "showKoreanMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 欧美电影
	 */
	$('#sea-movie').click(function(){
		console.log("点击欧美电影");
		
		var requestUrl = "showEAMovies?page=";
		
		$.ajax({
			url : "showEAMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 日本电影
	 */
	$('#sJanpanse-movie').click(function(){
		console.log("点击日本电影");
		
		var requestUrl = "showJapaneseMovies?page=";
		
		$.ajax({
			url : "showJapaneseMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 动作电影
	 */
	$('#saction-movie').click(function(){
		console.log("点击动作电影");
		
		var requestUrl = "showActionMovies?page=";
		
		$.ajax({
			url : "showActionMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 喜剧电影
	 */
	$('#scomedy-movie').click(function(){
		console.log("点击动作电影");
		
		var requestUrl = "showComedyMovies?page=";
		
		$.ajax({
			url : "showComedyMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 爱情电影
	 */
	$('#slove-movie').click(function(){
		console.log("点击爱情电影");
		
		var requestUrl = "showLoveMovies?page=";
		
		$.ajax({
			url : "showLoveMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 科幻电影
	 */
	$('#ssf-movie').click(function(){
		console.log("点击科幻电影");
		
		var requestUrl = "showSFMovies?page=";
		
		$.ajax({
			url : "showSFMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 动画电影
	 */
	$('#scartoon-movie').click(function(){
		console.log("点击动画电影");
		
		var requestUrl = "showCartoonMovies?page=";
		
		$.ajax({
			url : "showCartoonMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item ='<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 悬疑电影
	 */
	$('#ssuspense-movie').click(function(){
		console.log("点击悬疑电影");
		
		var requestUrl = "showSuspenseMovies?page=";
		
		$.ajax({
			url : "showSuspenseMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 恐怖电影
	 */
	$('#shorriable-movie').click(function(){
		console.log("点击悬疑电影");
		
		var requestUrl = "showHorribleMovies?page=";
		
		$.ajax({
			url : "showHorribleMovies?page=1",
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrl+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrl+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	
	/*------------------------------------电影分页------------------------------------*/
	/**
	 * 点击选电影的下一页
	 */
	$("#select-movie-pagination").on('click', '#next-page-selectMovie', function(){
		console.log("#next-page-selectMovie");
		var url = $(this).attr("value");
		console.log(url);
		
		$.ajax({
			url : url,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
				 
				 var requestUrlPre = url.split("=")[0] + "=" +info.prePage;
				 var requestUrlNext = url.split("=")[0] + "=" +info.nextPage;
				 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrlPre+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrlNext+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 点击选电影的上一页
	 */
	$("#select-movie-pagination").on('click', '#pre-page-selectMovie', function(){
		console.log("#pre-page-selectMovie");
		var url = $(this).attr("value");
		console.log(url);
		
		$.ajax({
			url : url,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#select-movie-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 var item = '<a href=../movie/movieDetail?mid='+value.mid+' class="movie-item" target="_blank">\
							<div class="card" style="width: 10rem;">\
						<img class="card-img-top" src='+value.img+'\
							alt="Card image cap">\
						<div class="card-body">\
							<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
						</div>\
						<div class="item-info-summary">\
							<h4>'+value.mname+'</h4>\
							<strong class="item-degree card-text">'+value.mscore+'</strong>\
							<div class="item-tags">\
								<span class="item-tag">'+value.mlong +'</span> <span class="item-tag">'+value.mcountry +'</span>\
								<span class="item-tag">'+value.mtag +' </span> \
								<span class="item-tag">'+value.mdirect +'</span> <span class="item-tag">'+value.mactor +'</span>\
							</div>\
							<hr>\
								<div class="isWatched">\
									<span class="item-tag"\
										style="background-color: #212529; color: white;">这里为登录用户标记是否看过\
										想看</span>\
								</div>\
						</div>\
					</div>\
				</a>';
					 
					$("#select-movie-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 var requestUrlPre = url.split("=")[0] + "=" + info.prePage;
				 var requestUrlNext = url.split("=")[0] + "=" + info.nextPage;
				 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-selectMovie"\
								value='+requestUrlPre+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item disabled page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-selectMovie"\
								value='+requestUrlNext+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled next-page page-link" tabindex="-1">下页</li>';
				 }
				 
				 $("#select-movie-pagination").empty();
				 $("#select-movie-pagination").append(prePage);
				 $("#select-movie-pagination").append(nowPage);
				 $("#select-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	//下拉菜单
	$('.dropdown-toggle').dropdown();
	
	//详情弹窗
	$("#select-movie-items").on('mouseover', '.movie-item', function(){
		$(this).find('.item-info-summary').show();
	});
	
	$("#select-movie-items").on('mouseleave', '.movie-item', function(){
		$(this).find('.item-info-summary').hide();
	});
	
	
	//tags
	$('.type').click(function () {
		if ($(this).attr('class') == 'type') {
			$(this).addClass('change-background');
			$(this).find('input').attr('checked','checked')
		}else{
			$(this).removeClass('change-background');
		}
		$(this).parent().siblings().find('span').removeClass("change-background");
	});
	//关闭广告
	$("#close-ad").click(function(){
		$(".ad").hide();
	});
	
});