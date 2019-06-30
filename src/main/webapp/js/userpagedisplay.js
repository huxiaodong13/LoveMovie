$(document).ready(function(){
    //点击模块显示不同的界面 想看的电影模块、看过的电影模块、参与的评论模块
    $(".block-saw").click(function(){
        $(".saw").show();
        $(".plan").hide();
       
        $("#comments-content").hide();
    });
    //模块被点击后更换背景颜色
    $(".block").click(function(){
        if($(this).attr('class') == 'block'){
            $(this).addClass('clicked');
        }else{
            $(this).removeClass('clicked');
        }
        $(this).siblings().removeClass('clicked');
        
    });

    $(".block-plan").click(function(){
        $(".saw").hide();
        $(".plan").show();
        $("#comments-content").hide();
    });
    $(".block-comment").click(function(){
        $(".saw").hide();
        $(".plan").hide();
        $("#comments-content").show();
    });
    //详情弹窗
    $('.movie-item').mouseover(function () {
		$(this).find('.item-info-summary').show();
	});

	$('.movie-item').mouseleave(function () {
		$(this).find('.item-info-summary').hide();
    });
    //添加关注与取消关注
    $("#attention").click(function(){
        $("#attention").hide();
        $("#not-attention").show();
    });
    $("#not-attention").click(function(){
        $("#attention").show();
        $("#not-attention").hide();
    });
    //添加关注与粉丝数显示不同的界面
    $("#fans-num").click(function(){
        $(".center-bottom-attention").hide();
        $(".center-bottom-fans").show();
        $(".center-bottom").hide();
    });
    $("#attention-num").click(function(){
        $(".center-bottom-attention").show();
        $(".center-bottom-fans").hide();
        $(".center-bottom").hide();
    });
    $(".list-attention").click(function(){
        $(this).hide();
        // $(".list-not-attention").show();
        $(this).parent().find(".list-not-attention").show();
    });
    $(".list-not-attention").click(function(){
        $(this).hide();
        // $(".list-not-attention").show();
        $(this).parent().find(".list-attention").show();
    });
    //点击用户名返回用户主页
    $(".label-username").click(function(){
        $(".center-bottom-attention").hide();
        $(".center-bottom-fans").hide();
        $(".center-bottom").show();
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
					 
					 var item = '<a href="../movie/movieDetail?mid='+value.mid+'" class="movie-item" target="_blank"\
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
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-sm" value='+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item page-link pre-page" tabindex="-1">上页/li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-sm" value='+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item page-link next-page" tabindex="-1">下页/li>';
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
					 
					 var item = '<a href="../movie/movieDetail?mid='+value.mid+'" class="movie-item" target="_blank"\
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
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-sm"\
								value='+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item page-link pre-page" tabindex="-1">上页/li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-sm" value='+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item page-link next-page" tabindex="-1">下页/li>';
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
					 
					 var item = '<a href="../movie/movieDetail?mid='+value.mid+'" class="movie-item" target="_blank"\
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
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-ws"\
								value='+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item page-link pre-page" tabindex="-1">上页/li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				  if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-ws" value='+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item page-link next-page" tabindex="-1">下页/li>';
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
					 
					 var item = '<a href="../movie/movieDetail?mid='+value.mid+'" class="movie-item" target="_blank"\
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
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-ws"\
								value='+info.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item page-link pre-page" tabindex="-1">上页/li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.pageNum+'/'+info.pages+'</li>'
				 
				  if(info.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-ws" value='+info.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item page-link next-page" tabindex="-1">下页/li>';
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
							<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank"\
								style="width: 10rem"> <img class="media-object"\
								src="'+value.img +'" alt="">\
							</a>\
						</div>\
						<div class="media-body comment-info">\
							<h4 class="media-heading">\
								<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
							</h4>\
							<div id="review-meta">\
								<a href="../index/userInfo?uid='+value.uid+'">'+info.username+'</a> &nbsp;评论&nbsp; <a\
									href="../movie/movieDetail?mid='+value.mid+'">'+value.mname +'</a> <strong class="item-degree">'+value.mscore +'</strong>\
							</div>\
							<p style="color: #666667;">\
								'+value.content.substring(0,60) +'...<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
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
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-comment"\
								value='+info.cPageInfo.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.cPageInfo.pageNum+'/'+info.cPageInfo.pages+'</li>'
				 
				 if(info.cPageInfo.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-comment"\
								value='+info.cPageInfo.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage ='<li class="page-item page-link next-page" tabindex="-1">下页</li>';
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
							<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank"\
								style="width: 10rem"> <img class="media-object"\
								src="'+value.img +'" alt="">\
							</a>\
						</div>\
						<div class="media-body comment-info">\
							<h4 class="media-heading">\
								<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
							</h4>\
							<div id="review-meta">\
								<a href="../index/userInfo?uid='+value.uid+'">'+info.username+'</a> &nbsp;评论&nbsp; <a\
									href="../movie/movieDetail?mid='+value.mid+'">'+value.mname +'</a> <strong class="item-degree">'+value.mscore +'</strong>\
							</div>\
							<p style="color: #666667;">\
								'+value.content.substring(0,60) +'...<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
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
					 prePage = '<li class="page-item page-link pre-page" id="pre-page-comment"\
								value='+info.cPageInfo.prePage+'>上页</li>';
				 }else{
					 prePage = '<li class="page-item page-link pre-page" tabindex="-1">上页</li>';
				 }
				 
				 var nowPage = '<li class="page-item page-link">'+info.cPageInfo.pageNum+'/'+info.cPageInfo.pages+'</li>'
				 
				 if(info.cPageInfo.hasNextPage){
					 nextPage = '<li class="page-item page-link next-page" id="next-page-comment"\
								value='+info.cPageInfo.nextPage+'>下页</li>';
					 console.log('有后一页');
				 }else{
					 nextPage ='<li class="page-item page-link next-page" tabindex="-1">下页</li>';
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
})