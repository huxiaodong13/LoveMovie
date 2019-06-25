$(document).ready(function() {
	$(".edit-introduce").click(function() {
		$("#self-introduce-text").hide();
		$("#self-introduce-edit").show();
	});
	$("#btn-brief-save").click(function() {
		$("#self-introduce-text").text("----" + $('#edit-concent').val());
		$("#self-introduce-edit").hide()
		$("#self-introduce-text").show();
	});
	$("#btn-brief-cancel").click(function() {
		$("#self-introduce-edit").hide()
		$("#self-introduce-text").show();
	});
	$('#datetimepicker1').datetimepicker({
		format : 'YYYY-MM-DD',
		locale : moment.locale('zh-cn'),
	});
	$('#datetimepicker2').datetimepicker({
		format : 'YYYY-MM-DD',
		locale : moment.locale('zh-cn'),
	});

	// 提交修改数据
	$("#edit-savebtn").click(function() {
		console.log($("#set-form").serialize());
	});

	$("#edit-cancelbtn").click(function() {
		$(".edit-message-wrap").hide();
		$(".userpage-wrap").show();
	});

	$("#edit-btn").click(function() {
		$(".edit-message-wrap").show();
		$(".userpage-wrap").hide();
	});

	// 点击模块显示不同的界面 想看的电影模块、看过的电影模块、参与的评论模块
	$(".block-saw").click(function() {
		$(".saw").show();
		$(".plan").hide();
		$("#comments-content").hide();
	});

	$(".block-plan").click(function() {
		console.log("pannnnn");
		$(".saw").hide();
		$(".plan").show();
		$("#comments-content").hide();
	});
	$(".block-comment").click(function() {
		$(".saw").hide();
		$(".plan").hide();
		$("#comments-content").show();
	});
	
    $( "#datepicker" ).datepicker();
    
    
    //在父级处绑定事件
	$("#seen-movies-items").on('mouseover', '.movie-item', function(){
		console.log("on");
		var item = $(this).html();
		console.log(item);
		$(this).find('.item-info-summary').show();
	});
	
	$("#seen-movies-items").on('mouseleave', '.movie-item', function(){
		console.log("left");
		$(this).find('.item-info-summary').hide();
	});
	
	$("#ws-movies-items").on('mouseover', '.movie-item', function(){
		console.log("on");
		var item = $(this).html();
		console.log(item);
		$(this).find('.item-info-summary').show();
	});
	
	$("#ws-movies-items").on('mouseleave', '.movie-item', function(){
		console.log("left");
		$(this).find('.item-info-summary').hide();
	});
	
	/**********************************************看过的电影*********************************************************/
	
	/**
	 * 点击看过的电影前一页 将事件绑定在父级
	 */
	$("#seen-movie-pagination").on('click', '#pre-page-sm', function(){
		console.log("#next-page-sm");
		var page = $(this).attr("value");
		console.log(page);

		$.ajax({
			url : "showSeenMovies?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#seen-movies-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 
					 var item = '<a href="#" class="movie-item" target="_blank"\
									style="margin-left: 5px;">\
									<div class="card" style="width: 10rem;">\
										<img class="card-img-top" src="'+value.img+'"\
											alt="Card image cap">\
										<div class="card-body">\
											<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
											<strong class="item-degree card-text">'+value.mscore+'</strong>\
										</div>\
										\
										<div class="item-info-summary">\
											<h4>'+value.mname+'</h4>\
											<strong class="item-degree card-text">'+value.mscore+'</strong>\
											<div class="item-tags">\
												<span class="item-tag">'+value.mlong +'</span> <span\
													class="item-tag">'+value.mcountry +'</span> <span\
													class="item-tag">'+value.mtag +'</span> <span\
													class="item-tag">'+value.mdirect +'</span> <span\
													class="item-tag">'+value.mactor +'</span>\
											</div>\
										</div>\
									</div>\
								</a>';
					 
					$("#seen-movies-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item " id="pre-page-sm"\
								value='+info.prePage+'><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled" tabindex="-1"><a\
								class="page-link" href="#">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item disabled"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item " id="next-page-sm"\
								value='+info.nextPage+'><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled" tabindex="-1"><a\
								class="page-link" href="#">下页</a></li>';
				 }
				 
				 $("#seen-movie-pagination").empty();
				 $("#seen-movie-pagination").append(prePage);
				 $("#seen-movie-pagination").append(nowPage);
				 $("#seen-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});
	

	/**
	 * 点击看过的电影下一页
	 */
	$("#seen-movie-pagination").on('click', '#next-page-sm', function(){
		console.log("#next-page-sm");
		var page = $(this).attr("value");
		console.log(page);

		$.ajax({
			url : "showSeenMovies?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#seen-movies-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 
					 var item = '<a href="#" class="movie-item" target="_blank"\
									style="margin-left: 5px;">\
									<div class="card" style="width: 10rem;">\
										<img class="card-img-top" src="'+value.img+'"\
											alt="Card image cap">\
										<div class="card-body">\
											<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
											<strong class="item-degree card-text">'+value.mscore+'</strong>\
										</div>\
										\
										<div class="item-info-summary">\
											<h4>'+value.mname+'</h4>\
											<strong class="item-degree card-text">'+value.mscore+'</strong>\
											<div class="item-tags">\
												<span class="item-tag">'+value.mlong +'</span> <span\
													class="item-tag">'+value.mcountry +'</span> <span\
													class="item-tag">'+value.mtag +'</span> <span\
													class="item-tag">'+value.mdirect +'</span> <span\
													class="item-tag">'+value.mactor +'</span>\
											</div>\
										</div>\
									</div>\
								</a>';
					 
					$("#seen-movies-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item " id="pre-page-sm"\
								value='+info.prePage+'><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled" tabindex="-1"><a\
								class="page-link" href="#">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item disabled"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item " id="next-page-sm"\
								value='+info.nextPage+'><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled" tabindex="-1"><a\
								class="page-link" href="#">下页</a></li>';
				 }
				 
				 $("#seen-movie-pagination").empty();
				 $("#seen-movie-pagination").append(prePage);
				 $("#seen-movie-pagination").append(nowPage);
				 $("#seen-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});
	
	/**********************************************想看的电影*********************************************************/
	/**
	 * 点击想看的电影前一页 将事件绑定在父级
	 */
	$("#ws-movie-pagination").on('click', '#pre-page-ws', function(){
		console.log("#next-page-ws");
		var page = $(this).attr("value");
		console.log(page);

		$.ajax({
			url : "showWSeenMovies?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#ws-movies-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 
					 var item = '<a href="#" class="movie-item" target="_blank"\
									style="margin-left: 5px;">\
									<div class="card" style="width: 10rem;">\
										<img class="card-img-top" src="'+value.img+'"\
											alt="Card image cap">\
										<div class="card-body">\
											<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
											<strong class="item-degree card-text">'+value.mscore+'</strong>\
										</div>\
										\
										<div class="item-info-summary">\
											<h4>'+value.mname+'</h4>\
											<strong class="item-degree card-text">'+value.mscore+'</strong>\
											<div class="item-tags">\
												<span class="item-tag">'+value.mlong +'</span> <span\
													class="item-tag">'+value.mcountry +'</span> <span\
													class="item-tag">'+value.mtag +'</span> <span\
													class="item-tag">'+value.mdirect +'</span> <span\
													class="item-tag">'+value.mactor +'</span>\
											</div>\
										</div>\
									</div>\
								</a>';
					 
					 $("#ws-movies-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item " id="pre-page-ws"\
								value='+info.prePage+'><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled" tabindex="-1"><a\
								class="page-link" href="#">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item disabled"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item " id="next-page-ws"\
								value='+info.nextPage+'><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled" tabindex="-1"><a\
								class="page-link" href="#">下页</a></li>';
				 }
				 
				 $("#ws-movie-pagination").empty();
				 $("#ws-movie-pagination").append(prePage);
				 $("#ws-movie-pagination").append(nowPage);
				 $("#ws-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 点击想看的电影下一页 将事件绑定在父级
	 */
	$("#ws-movie-pagination").on('click', '#next-page-ws', function(){
		console.log("#next-page-ws");
		var page = $(this).attr("value");
		console.log(page);

		$.ajax({
			url : "showWSeenMovies?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#ws-movies-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 //添加电影节点
				 var movies = info.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 
					 var item = '<a href="#" class="movie-item" target="_blank"\
									style="margin-left: 5px;">\
									<div class="card" style="width: 10rem;">\
										<img class="card-img-top" src="'+value.img+'"\
											alt="Card image cap">\
										<div class="card-body">\
											<span class="card-title item-name" title="'+value.mname+'">'+value.mname+'</span>\
											<strong class="item-degree card-text">'+value.mscore+'</strong>\
										</div>\
										\
										<div class="item-info-summary">\
											<h4>'+value.mname+'</h4>\
											<strong class="item-degree card-text">'+value.mscore+'</strong>\
											<div class="item-tags">\
												<span class="item-tag">'+value.mlong +'</span> <span\
													class="item-tag">'+value.mcountry +'</span> <span\
													class="item-tag">'+value.mtag +'</span> <span\
													class="item-tag">'+value.mdirect +'</span> <span\
													class="item-tag">'+value.mactor +'</span>\
											</div>\
										</div>\
									</div>\
								</a>';
					 
					$("#ws-movies-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item " id="pre-page-ws"\
								value='+info.prePage+'><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled" tabindex="-1"><a\
								class="page-link" href="#">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item disabled"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item " id="next-page-ws"\
								value='+info.nextPage+'><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled" tabindex="-1"><a\
								class="page-link" href="#">下页</a></li>';
				 }
				 
				 $("#ws-movie-pagination").empty();
				 $("#ws-movie-pagination").append(prePage);
				 $("#ws-movie-pagination").append(nowPage);
				 $("#ws-movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/*********************************************参与的影评*********************************************************/
	/**
	 * 点击想参与的影评前一页 将事件绑定在父级
	 */
	$("#comment-pagination").on('click', '#pre-page-comment', function(){
		console.log("#pre-page-comment");
		var page = $(this).attr("value");
		console.log(page);

		$.ajax({
			url : "showReviews?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comment-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 //添加电影节点
				 var movies = info.cPageInfo.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 
					 var item = '<div class="comment-item" style="margin-left: 0px; width: 830px;">\
							<div class="media" style="width: 830px;">\
						<div class="media-left">\
							<a href="#" class="comment-cover " target="_blank"\
								style="width: 10rem"> <img class="media-object"\
								src="'+value.img +'" alt="">\
							</a>\
						</div>\
						<div class="media-body comment-info">\
							<h4 class="media-heading">\
								<a href="#">'+value.ctitle +'</a>\
							</h4>\
							<div id="review-meta">\
								<a href="#">'+info.username+'</a> &nbsp;评论&nbsp; <a\
									href="#">'+value.mname +'</a> <strong class="item-degree">'+value.mscore +'</strong>\
							</div>\
							<p style="color: #666667;">\
								'+value.content +'<a href="#" class="btn btn-link">全文</a>\
							</p>\
						</div>\
					</div>\
				</div>'; 
					 
					 $("#comment-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.cPageInfo.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item " id="pre-page-comment"\
								value='+info.cPageInfo.prePage+'><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled" tabindex="-1"><a\
								class="page-link" href="#">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item disabled"><a class="page-link" href="#">'+info.cPageInfo.pageNum+'/'+info.cPageInfo.pages+'</a></li>'
				 
				 if(info.cPageInfo.hasNextPage){
					 nextPage = '<li class="page-item " id="next-page-comment"\
								value='+info.cPageInfo.nextPage+'><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled" tabindex="-1"><a\
								class="page-link" href="#">下页</a></li>';
				 }
				 
				 $("#comment-pagination").empty();
				 $("#comment-pagination").append(prePage);
				 $("#comment-pagination").append(nowPage);
				 $("#comment-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 点击参与评论的下一页 将事件绑定在父级
	 */
	$("#comment-pagination").on('click', '#next-page-comment', function(){
		console.log("#next-page-comment");
		var page = $(this).attr("value");
		console.log(page);

		$.ajax({
			url : "showReviews?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comment-items").empty();
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 //添加电影节点
				 var movies = info.cPageInfo.list;
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 console.log(value.mactor);
					 
					 var item = '<div class="comment-item" style="margin-left: 0px; width: 830px;">\
							<div class="media" style="width: 830px;">\
						<div class="media-left">\
							<a href="#" class="comment-cover " target="_blank"\
								style="width: 10rem"> <img class="media-object"\
								src="'+value.img +'" alt="">\
							</a>\
						</div>\
						<div class="media-body comment-info">\
							<h4 class="media-heading">\
								<a href="#">'+value.ctitle +'</a>\
							</h4>\
							<div id="review-meta">\
								<a href="#">'+info.username+'</a> &nbsp;评论&nbsp; <a\
									href="#">'+value.mname +'</a> <strong class="item-degree">'+value.mscore +'</strong>\
							</div>\
							<p style="color: #666667;">\
								'+value.content +'<a href="#" class="btn btn-link">全文</a>\
							</p>\
						</div>\
					</div>\
				</div>'; 
					 
					 $("#comment-items").append(item);
				 }); 

				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.cPageInfo.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item " id="pre-page-comment"\
								value='+info.cPageInfo.prePage+'><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled" tabindex="-1"><a\
								class="page-link" href="#">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item disabled"><a class="page-link" href="#">'+info.cPageInfo.pageNum+'/'+info.cPageInfo.pages+'</a></li>'
				 
				 if(info.cPageInfo.hasNextPage){
					 nextPage = '<li class="page-item " id="next-page-comment"\
								value='+info.cPageInfo.nextPage+'><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled" tabindex="-1"><a\
								class="page-link" href="#">下页</a></li>';
				 }
				 
				 $("#comment-pagination").empty();
				 $("#comment-pagination").append(prePage);
				 $("#comment-pagination").append(nowPage);
				 $("#comment-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
			} 
		});
	});
	
});