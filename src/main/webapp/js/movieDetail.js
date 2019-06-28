

$(document).ready(function() {
	/*----------------------评分----------------------*/
	$('.modal-footer button.btn.btn-dark').click(function(){
		console.log("点击了我要评分");
		var score = $('#scrollBarTxt').text().split('/')[0]; 
		console.log(score);
		
		var mid = $('#smovie-link').attr('href').split('=')[1];
		
		info = {
				'mid':mid,
				'sscore':score
		}
		console.log(info);
		$.ajax({
			url : "modifyMovieScore",
			type : "post",
			data:info,
			success : function(data) {
				console.log(data);
				
				if(data == "1"){
					alert("评分成功");
					location.reload();
				}else{
					alert("评分失败，请登录后对该电影进行评分");
					location.reload();
				}
			},
			error : function(errordata) {
				console.log(errordata);
			}
		});
		
	});
	
	/*-----------------------------获取详情页最受欢迎的评论-----------------------------*/
	$('#md-popular-comment').click(function(){
		console.log("点击了电影详情页最后欢迎评论");
//		
		var mid = $('#smovie-link').attr('href').split('=')[1];
		var requestUrl = "showMovieDetailPopuplarComment?page=1&mid="+mid;
//		
		console.log(requestUrl);
//		
		$.ajax({
			url : requestUrl,
			type : "post",
			success : function(data) {
				
				 
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 console.log("hasComments====" + info.hasComments); //true
//				 console.log("pageInfo=="  + info.commentPageInfo.nextPage);
				 
				 
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comments-cards").empty();
//				 
				 //判断是否含有评论
				 var hasComments = info.hasComments;
				 if(hasComments == false){
					 var item = '<h4 style="color: white;">这里暂时还没有人评论哦~</h4>';
					 $("#comments-cards").append(item);
				 }else{
					 //添加评论节点
					 var comments = info.commentPageInfo.list;
					 var commentReply = info.commentReplyCount;
					 $.each(comments, function(key, value) { // 遍历json中的key和value
						 console.log(value.ctitle);
						 var item = '<div class="comment-card-item">\
								<div class="card">\
									<div class="card-body">\
										<div id="review-meta">\
											<a href="../index/userInfo?uid='+value.uid+'"><img src="'+value.uimg +'" alt=""></a> <a\
												href="../index/userInfo?uid='+value.uid+'">'+value.username +' </a><strong\
												class="item-degree" title="推荐">'+value.cscore+'</strong>\
											<p>'+toTime(value.cdate) +'</p>\
										</div>\
										<h4 class="media-heading">\
											<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
										</h4>\
										<p style="color: #666667;">'+value.content.substring(0,60)+'...\
											<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
										</p>\
										<div class="action">\
											<a href="#" title="有用">▲ '+value.clike +'</span></a> <a href="#"\
												title="无用">▼ '+value.cdislike +'</span></a> <a href=""\
												class="reply" style="margin: 0 1rem;">'+commentReply[key]+'回复</a>\
										</div>\
									</div>\
								</div>\
							</div>';
						$("#comments-cards").append(item);
					 }); 

					 var prePage = "";
					 var nextPage = "";
					 
					//修改页码
					 var infoPage = info.commentPageInfo;
					 if(infoPage.hasPreviousPage){
						 console.log('有前一页');
						 prePage = '<li class="page-item page-link pre-page" id="pre-page-movieDetail"\
									value="showMovieDetailPopuplarComment?page='+infoPage.prePage+'&mid='+mid+'">上页</li>';
					 }else{
						 prePage = '<li class="page-item disabled page-link pre-page"  tabindex="-1">上页</li>';
					 }
					 
					 var nowPage = '<li class="page-item disabled page-link">'+infoPage.pageNum+'/'+infoPage.pages+'</li>'
					 
					 if(infoPage.hasNextPage){
						 nextPage = '<li class="page-item page-link next-page" id="next-page-movieDetail"\
									value="showMovieDetailPopuplarComment?page='+infoPage.nextPage+'&mid='+mid+'">下页</li>';
						 console.log('有后一页');
					 }else{
						 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
					 }
					 
					 $("#movie-detail-pagination").empty();
					 $("#movie-detail-pagination").append(prePage);
					 $("#movie-detail-pagination").append(nowPage);
					 $("#movie-detail-pagination").append(nextPage);
				 }
			}
		});
	});
	
	
	/*-----------------------------获取详情页最新的评论-----------------------------*/
	$('#md-new-comment').click(function(){
		
		console.log("点击了电影详情页最新评论");
//		
		var mid = $('#smovie-link').attr('href').split('=')[1];
		var requestUrl = "showMovieDetailNewComment?page=1&mid="+mid;
//		
		console.log(requestUrl);
//		
		$.ajax({
			url : requestUrl,
			type : "post",
			success : function(data) {
				
				 
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 console.log("hasComments====" + info.hasComments); //true
//				 console.log("pageInfo=="  + info.commentPageInfo.nextPage);
				 
				 
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comments-cards").empty();
//				 
				 //判断是否含有评论
				 var hasComments = info.hasComments;
				 if(hasComments == false){
					 var item = '<h4 style="color: white;">这里暂时还没有人评论哦~</h4>';
					 $("#comments-cards").append(item);
				 }else{
					 //添加评论节点
					 var comments = info.commentPageInfo.list;
					 var commentReply = info.commentReplyCount;
					 $.each(comments, function(key, value) { // 遍历json中的key和value
						 console.log(value.ctitle);
						 var item = '<div class="comment-card-item">\
								<div class="card">\
									<div class="card-body">\
										<div id="review-meta">\
											<a href="../index/userInfo?uid='+value.uid+'"><img src="'+value.uimg +'" alt=""></a> <a\
												href="../index/userInfo?uid='+value.uid+'">'+value.username +' </a><strong\
												class="item-degree" title="推荐">'+value.cscore+'</strong>\
											<p>'+toTime(value.cdate) +'</p>\
										</div>\
										<h4 class="media-heading">\
											<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
										</h4>\
										<p style="color: #666667;">'+value.content.substring(0,60)+'...\
											<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
										</p>\
										<div class="action">\
											<a href="#" title="有用">▲ '+value.clike +'</span></a> <a href="#"\
												title="无用">▼ '+value.cdislike +'</span></a> <a href=""\
												class="reply" style="margin: 0 1rem;">'+commentReply[key]+'回复</a>\
										</div>\
									</div>\
								</div>\
							</div>';
						$("#comments-cards").append(item);
					 }); 

					 var prePage = "";
					 var nextPage = "";
					 
					//修改页码
					 var infoPage = info.commentPageInfo;
					 if(infoPage.hasPreviousPage){
						 console.log('有前一页');
						 prePage = '<li class="page-item page-link pre-page" id="pre-page-movieDetail"\
									value="showMovieDetailNewComment?page='+infoPage.prePage+'&mid='+mid+'">上页</li>';
					 }else{
						 prePage = '<li class="page-item disabled page-link pre-page"  tabindex="-1">上页</li>';
					 }
					 
					 var nowPage = '<li class="page-item disabled page-link">'+infoPage.pageNum+'/'+infoPage.pages+'</li>'
					 
					 if(infoPage.hasNextPage){
						 nextPage = '<li class="page-item page-link next-page" id="next-page-movieDetail"\
									value="showMovieDetailNewComment?page='+infoPage.nextPage+'&mid='+mid+'">下页</li>';
						 console.log('有后一页');
					 }else{
						 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
					 }
					 
					 $("#movie-detail-pagination").empty();
					 $("#movie-detail-pagination").append(prePage);
					 $("#movie-detail-pagination").append(nowPage);
					 $("#movie-detail-pagination").append(nextPage);
				 }
			}
		});
	});
	
	/*-----------------------------获取详情页好友的评论-----------------------------*/
	$('#md-friend-comment').click(function(){
		
		console.log("点击了电影详情页好友评论");
		
		var mid = $('#smovie-link').attr('href').split('=')[1];
		var requestUrl = "showMovieDetailFriendComment?page=1&mid="+mid;
		
		console.log(requestUrl);
		
		$.ajax({
			url : requestUrl,
			type : "post",
			success : function(data) {

				 
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 console.log("hasComments====" + info.hasComments); //true
				 
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comments-cards").empty();
//				 
				 //判断是否含有评论
				 var hasComments = info.hasComments;
				 if(hasComments == false){
					 var item = '<h4 style="color: white;">这里暂时还没有人评论哦~</h4>';
					 $("#comments-cards").append(item);
				 }else{
					 //添加评论节点
					 var comments = info.commentPageInfo.list;
					 var commentReply = info.commentReplyCount;
					 
					 var users = info.commentUser;
					 var movies = info.commentMovie;
					 
					 $.each(comments, function(key, value) { // 遍历json中的key和value
						 console.log(value.ctitle);
						 var item = '<div class="comment-card-item">\
								<div class="card">\
									<div class="card-body">\
										<div id="review-meta">\
											<a href="../index/userInfo?uid='+value.uid+'"><img src="'+users[key].uimg +'" alt=""></a> <a\
												href="../index/userInfo?uid='+value.uid+'">'+users[key].username +' </a><strong\
												class="item-degree" title="推荐">'+value.cscore+'</strong>\
											<p>'+toTime(value.cdate) +'</p>\
										</div>\
										<h4 class="media-heading">\
											<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
										</h4>\
										<p style="color: #666667;">'+value.content.substring(0,60)+'...\
											<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
										</p>\
										<div class="action">\
											<a href="#" title="有用">▲ '+value.clike +'</span></a> <a href="#"\
												title="无用">▼ '+value.cdislike +'</span></a> <a href=""\
												class="reply" style="margin: 0 1rem;">'+commentReply[key]+'回复</a>\
										</div>\
									</div>\
								</div>\
							</div>';
						$("#comments-cards").append(item);
					 }); 

					 var prePage = "";
					 var nextPage = "";
					 
					//修改页码
					 var infoPage = info.commentPageInfo;
					 if(infoPage.hasPreviousPage){
						 console.log('有前一页');
						 prePage = '<li class="page-item page-link pre-page" id="pre-page-movieDetailFriend"\
									value="showMovieDetailFriendComment?page='+infoPage.prePage+'&mid='+mid+'">上页</li>';
					 }else{
						 prePage = '<li class="page-item disabled page-link pre-page"  tabindex="-1">上页</li>';
					 }
					 
					 var nowPage = '<li class="page-item disabled page-link">'+infoPage.pageNum+'/'+infoPage.pages+'</li>'
					 
					 if(infoPage.hasNextPage){
						 nextPage = '<li class="page-item page-link next-page" id="next-page-movieDetailFriend"\
									value="showMovieDetailFriendComment?page='+infoPage.nextPage+'&mid='+mid+'">下页</li>';
						 console.log('有后一页');
					 }else{
						 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
					 }
					 
					 $("#movie-detail-pagination").empty();
					 $("#movie-detail-pagination").append(prePage);
					 $("#movie-detail-pagination").append(nowPage);
					 $("#movie-detail-pagination").append(nextPage);
				 }
			}
		});
	});
	
	/*-----------------------------获取详情页好友的评论  下一页-----------------------------*/
	$('#movie-detail-pagination').on('click', '#next-page-movieDetailFriend', function(){
		
		console.log("点击了电影详情页好友评论 下一页");
		
		var url = $(this).attr("value");
		console.log(url + " 点击了下一页");
		var mid = url.split('=')[2];
		
		var requestUrl = url.split('?')[0];
		
		console.log(requestUrl);
		
		$.ajax({
			url : url,
			type : "post",
			success : function(data) {
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 console.log("hasComments====" + info.hasComments); //true
				 
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comments-cards").empty();
//				 
				 //判断是否含有评论
				 var hasComments = info.hasComments;
				 if(hasComments == false){
					 var item = '<h4 style="color: white;">这里暂时还没有人评论哦~</h4>';
					 $("#comments-cards").append(item);
				 }else{
					 //添加评论节点
					 var comments = info.commentPageInfo.list;
					 var commentReply = info.commentReplyCount;
					 
					 var users = info.commentUser;
					 var movies = info.commentMovie;
					 
					 $.each(comments, function(key, value) { // 遍历json中的key和value
						 console.log(value.ctitle);
						 var item = '<div class="comment-card-item">\
								<div class="card">\
									<div class="card-body">\
										<div id="review-meta">\
											<a href="../index/userInfo?uid='+value.uid+'"><img src="'+users[key].uimg +'" alt=""></a> <a\
												href="../index/userInfo?uid='+value.uid+'">'+users[key].username +' </a><strong\
												class="item-degree" title="推荐">'+value.cscore+'</strong>\
											<p>'+toTime(value.cdate) +'</p>\
										</div>\
										<h4 class="media-heading">\
											<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
										</h4>\
										<p style="color: #666667;">'+value.content.substring(0,60)+'...\
											<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
										</p>\
										<div class="action">\
											<a href="#" title="有用">▲ '+value.clike +'</span></a> <a href="#"\
												title="无用">▼ '+value.cdislike +'</span></a> <a href=""\
												class="reply" style="margin: 0 1rem;">'+commentReply[key]+'回复</a>\
										</div>\
									</div>\
								</div>\
							</div>';
						$("#comments-cards").append(item);
					 }); 

					 var prePage = "";
					 var nextPage = "";
					 
					//修改页码
					 var infoPage = info.commentPageInfo;
					 if(infoPage.hasPreviousPage){
						 console.log('有前一页');
						 prePage = '<li class="page-item page-link pre-page" id="pre-page-movieDetailFriend"\
									value="showMovieDetailFriendComment?page='+infoPage.prePage+'&mid='+mid+'">上页</li>';
					 }else{
						 prePage = '<li class="page-item disabled page-link pre-page"  tabindex="-1">上页</li>';
					 }
					 
					 var nowPage = '<li class="page-item disabled page-link">'+infoPage.pageNum+'/'+infoPage.pages+'</li>'
					 
					 if(infoPage.hasNextPage){
						 nextPage = '<li class="page-item page-link next-page" id="next-page-movieDetailFriend"\
									value="showMovieDetailFriendComment?page='+infoPage.nextPage+'&mid='+mid+'">下页</li>';
						 console.log('有后一页');
					 }else{
						 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
					 }
					 
					 $("#movie-detail-pagination").empty();
					 $("#movie-detail-pagination").append(prePage);
					 $("#movie-detail-pagination").append(nowPage);
					 $("#movie-detail-pagination").append(nextPage);
				 }
			}
		});
	});
	

	/*-----------------------------获取详情页好友的评论  上一页-----------------------------*/
	$('#movie-detail-pagination').on('click', '#pre-page-movieDetailFriend', function(){
		
		console.log("点击了电影详情页好友评论 上一页");
		
		var url = $(this).attr("value");
		console.log(url + " 点击了上一页");
		var mid = url.split('=')[2];
		
		var requestUrl = url.split('?')[0];
		
		console.log(requestUrl);
		
		$.ajax({
			url : url,
			type : "post",
			success : function(data) {
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 console.log("hasComments====" + info.hasComments); //true
				 
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comments-cards").empty();
//				 
				 //判断是否含有评论
				 var hasComments = info.hasComments;
				 if(hasComments == false){
					 var item = '<h4 style="color: white;">这里暂时还没有人评论哦~</h4>';
					 $("#comments-cards").append(item);
				 }else{
					 //添加评论节点
					 var comments = info.commentPageInfo.list;
					 var commentReply = info.commentReplyCount;
					 
					 var users = info.commentUser;
					 var movies = info.commentMovie;
					 
					 $.each(comments, function(key, value) { // 遍历json中的key和value
						 console.log(value.ctitle);
						 var item = '<div class="comment-card-item">\
								<div class="card">\
									<div class="card-body">\
										<div id="review-meta">\
											<a href="../index/userInfo?uid='+value.uid+'"><img src="'+users[key].uimg +'" alt=""></a> <a\
												href="../index/userInfo?uid='+value.uid+'">'+users[key].username +' </a><strong\
												class="item-degree" title="推荐">'+value.cscore+'</strong>\
											<p>'+toTime(value.cdate) +'</p>\
										</div>\
										<h4 class="media-heading">\
											<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
										</h4>\
										<p style="color: #666667;">'+value.content.substring(0,60)+'...\
											<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
										</p>\
										<div class="action">\
											<a href="#" title="有用">▲ '+value.clike +'</span></a> <a href="#"\
												title="无用">▼ '+value.cdislike +'</span></a> <a href=""\
												class="reply" style="margin: 0 1rem;">'+commentReply[key]+'回复</a>\
										</div>\
									</div>\
								</div>\
							</div>';
						$("#comments-cards").append(item);
					 }); 

					 var prePage = "";
					 var nextPage = "";
					 
					//修改页码
					 var infoPage = info.commentPageInfo;
					 if(infoPage.hasPreviousPage){
						 console.log('有前一页');
						 prePage = '<li class="page-item page-link pre-page" id="pre-page-movieDetailFriend"\
									value="showMovieDetailFriendComment?page='+infoPage.prePage+'&mid='+mid+'">上页</li>';
					 }else{
						 prePage = '<li class="page-item disabled page-link pre-page"  tabindex="-1">上页</li>';
					 }
					 
					 var nowPage = '<li class="page-item disabled page-link">'+infoPage.pageNum+'/'+infoPage.pages+'</li>'
					 
					 if(infoPage.hasNextPage){
						 nextPage = '<li class="page-item page-link next-page" id="next-page-movieDetailFriend"\
									value="showMovieDetailFriendComment?page='+infoPage.nextPage+'&mid='+mid+'">下页</li>';
						 console.log('有后一页');
					 }else{
						 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
					 }
					 
					 $("#movie-detail-pagination").empty();
					 $("#movie-detail-pagination").append(prePage);
					 $("#movie-detail-pagination").append(nowPage);
					 $("#movie-detail-pagination").append(nextPage);
				 }
			}
		});
	});
	
	
	
	
	/*-----------------------------获取详情页热门的评论-----------------------------*/
	$('#md-hot-comment').click(function(){
		console.log("获取电影详情页热门评论");
		
		var mid = $('#smovie-link').attr('href').split('=')[1];
		var requestUrl = "showMovieDetailHotComment?page=1&mid="+mid;
		
		console.log(requestUrl);
		
		$.ajax({
			url : requestUrl,
			type : "post",
			success : function(data) {
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 console.log("hasComments====" + info.hasComments); //true
				 
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comments-cards").empty();
//				 
				 //判断是否含有评论
				 var hasComments = info.hasComments;
				 if(hasComments == false){
					 var item = '<h4 style="color: white;">这里暂时还没有人评论哦~</h4>';
					 $("#comments-cards").append(item);
				 }else{
					 //添加评论节点
					 var comments = info.commentPageInfo.list;
					 var commentReply = info.commentReplyCount;
					 
					 var users = info.commentUser;
					 
					 $.each(comments, function(key, value) { // 遍历json中的key和value
						 console.log(value.ctitle);
						 var item = '<div class="comment-card-item">\
								<div class="card">\
									<div class="card-body">\
										<div id="review-meta">\
											<a href="../index/userInfo?uid='+value.uid+'"><img src="'+users[key].uimg +'" alt=""></a> <a\
												href="../index/userInfo?uid='+value.uid+'">'+users[key].username +' </a><strong\
												class="item-degree" title="推荐">'+value.cscore+'</strong>\
											<p>'+toTime(value.cdate) +'</p>\
										</div>\
										<h4 class="media-heading">\
											<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
										</h4>\
										<p style="color: #666667;">'+value.content.substring(0,60)+'...\
											<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
										</p>\
										<div class="action">\
											<a href="#" title="有用">▲ '+value.clike +'</span></a> <a href="#"\
												title="无用">▼ '+value.cdislike +'</span></a> <a href=""\
												class="reply" style="margin: 0 1rem;">'+value.replyCount+'回复</a>\
										</div>\
									</div>\
								</div>\
							</div>';
						$("#comments-cards").append(item);
					 }); 

					 var prePage = "";
					 var nextPage = "";
					 
					//修改页码
					 var infoPage = info.commentPageInfo;
					 if(infoPage.hasPreviousPage){
						 console.log('有前一页');
						 prePage = '<li class="page-item page-link pre-page" id="pre-page-movieDetailHot"\
									value="showMovieDetailHotComment?page='+infoPage.prePage+'&mid='+mid+'">上页</li>';
					 }else{
						 prePage = '<li class="page-item disabled page-link pre-page"  tabindex="-1">上页</li>';
					 }
					 
					 var nowPage = '<li class="page-item disabled page-link">'+infoPage.pageNum+'/'+infoPage.pages+'</li>'
					 
					 if(infoPage.hasNextPage){
						 nextPage = '<li class="page-item page-link next-page" id="next-page-movieDetailHot"\
									value="showMovieDetailHotComment?page='+infoPage.nextPage+'&mid='+mid+'">下页</li>';
						 console.log('有后一页');
					 }else{
						 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
					 }
					 
					 $("#movie-detail-pagination").empty();
					 $("#movie-detail-pagination").append(prePage);
					 $("#movie-detail-pagination").append(nowPage);
					 $("#movie-detail-pagination").append(nextPage);
				 }
			}
		});
		
	});
	

	/*-----------------------------获取详情页热门的评论 下一页-----------------------------*/
	$('#movie-detail-pagination').on('click', '#next-page-movieDetailHot', function(){
		console.log("获取电影详情页热门评论  下一页");
		
		var url = $(this).attr("value");
		
		console.log(url + " 点击了下一页");
		var mid = url.split('=')[2];
		
		var requestUrl = url.split('?')[0];
		
		console.log('requestUrl ' + requestUrl + "mid " + mid);
		
		$.ajax({
			url : url,
			type : "post",
			success : function(data) {
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 console.log("hasComments====" + info.hasComments); //true
				 
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comments-cards").empty();
//				 
				 //判断是否含有评论
				 var hasComments = info.hasComments;
				 if(hasComments == false){
					 var item = '<h4 style="color: white;">这里暂时还没有人评论哦~</h4>';
					 $("#comments-cards").append(item);
				 }else{
					 //添加评论节点
					 var comments = info.commentPageInfo.list;
					 var commentReply = info.commentReplyCount;
					 
					 var users = info.commentUser;
					 
					 $.each(comments, function(key, value) { // 遍历json中的key和value
						 console.log(value.ctitle);
						 var item = '<div class="comment-card-item">\
								<div class="card">\
									<div class="card-body">\
										<div id="review-meta">\
											<a href="../index/userInfo?uid='+value.uid+'"><img src="'+users[key].uimg +'" alt=""></a> <a\
												href="../index/userInfo?uid='+value.uid+'">'+users[key].username +' </a><strong\
												class="item-degree" title="推荐">'+value.cscore+'</strong>\
											<p>'+toTime(value.cdate) +'</p>\
										</div>\
										<h4 class="media-heading">\
											<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
										</h4>\
										<p style="color: #666667;">'+value.content.substring(0,60)+'...\
											<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
										</p>\
										<div class="action">\
											<a href="#" title="有用">▲ '+value.clike +'</span></a> <a href="#"\
												title="无用">▼ '+value.cdislike +'</span></a> <a href=""\
												class="reply" style="margin: 0 1rem;">'+value.replyCount+'回复</a>\
										</div>\
									</div>\
								</div>\
							</div>';
						$("#comments-cards").append(item);
					 }); 

					 var prePage = "";
					 var nextPage = "";
					 
					//修改页码
					 var infoPage = info.commentPageInfo;
					 if(infoPage.hasPreviousPage){
						 console.log('有前一页');
						 prePage = '<li class="page-item page-link pre-page" id="pre-page-movieDetailHot"\
									value="showMovieDetailHotComment?page='+infoPage.prePage+'&mid='+mid+'">上页</li>';
					 }else{
						 prePage = '<li class="page-item disabled page-link pre-page"  tabindex="-1">上页</li>';
					 }
					 
					 var nowPage = '<li class="page-item disabled page-link">'+infoPage.pageNum+'/'+infoPage.pages+'</li>'
					 
					 if(infoPage.hasNextPage){
						 nextPage = '<li class="page-item page-link next-page" id="next-page-movieDetailHot"\
									value="showMovieDetailHotComment?page='+infoPage.nextPage+'&mid='+mid+'">下页</li>';
						 console.log('有后一页');
					 }else{
						 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
					 }
					 
					 $("#movie-detail-pagination").empty();
					 $("#movie-detail-pagination").append(prePage);
					 $("#movie-detail-pagination").append(nowPage);
					 $("#movie-detail-pagination").append(nextPage);
				 }
			}
		});
	});
	
	/*-----------------------------获取详情页热门的评论 上一页-----------------------------*/
	$('#movie-detail-pagination').on('click', '#pre-page-movieDetailHot', function(){
		console.log("获取电影详情页热门评论  下一页");
		
		var url = $(this).attr("value");
		
		console.log(url + " 点击了下一页");
		var mid = url.split('=')[2];
		
		var requestUrl = url.split('?')[0];
		
		console.log('requestUrl ' + requestUrl + "mid " + mid);
		
		$.ajax({
			url : url,
			type : "post",
			success : function(data) {
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 console.log("hasComments====" + info.hasComments); //true
				 
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comments-cards").empty();
//				 
				 //判断是否含有评论
				 var hasComments = info.hasComments;
				 if(hasComments == false){
					 var item = '<h4 style="color: white;">这里暂时还没有人评论哦~</h4>';
					 $("#comments-cards").append(item);
				 }else{
					 //添加评论节点
					 var comments = info.commentPageInfo.list;
					 var commentReply = info.commentReplyCount;
					 
					 var users = info.commentUser;
					 
					 $.each(comments, function(key, value) { // 遍历json中的key和value
						 console.log(value.ctitle);
						 var item = '<div class="comment-card-item">\
								<div class="card">\
									<div class="card-body">\
										<div id="review-meta">\
											<a href="../index/userInfo?uid='+value.uid+'"><img src="'+users[key].uimg +'" alt=""></a> <a\
												href="../index/userInfo?uid='+value.uid+'">'+users[key].username +' </a><strong\
												class="item-degree" title="推荐">'+value.cscore+'</strong>\
											<p>'+toTime(value.cdate) +'</p>\
										</div>\
										<h4 class="media-heading">\
											<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
										</h4>\
										<p style="color: #666667;">'+value.content.substring(0,60)+'...\
											<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
										</p>\
										<div class="action">\
											<a href="#" title="有用">▲ '+value.clike +'</span></a> <a href="#"\
												title="无用">▼ '+value.cdislike +'</span></a> <a href=""\
												class="reply" style="margin: 0 1rem;">'+value.replyCount+'回复</a>\
										</div>\
									</div>\
								</div>\
							</div>';
						$("#comments-cards").append(item);
					 }); 

					 var prePage = "";
					 var nextPage = "";
					 
					//修改页码
					 var infoPage = info.commentPageInfo;
					 if(infoPage.hasPreviousPage){
						 console.log('有前一页');
						 prePage = '<li class="page-item page-link pre-page" id="pre-page-movieDetailHot"\
									value="showMovieDetailHotComment?page='+infoPage.prePage+'&mid='+mid+'">上页</li>';
					 }else{
						 prePage = '<li class="page-item disabled page-link pre-page"  tabindex="-1">上页</li>';
					 }
					 
					 var nowPage = '<li class="page-item disabled page-link">'+infoPage.pageNum+'/'+infoPage.pages+'</li>'
					 
					 if(infoPage.hasNextPage){
						 nextPage = '<li class="page-item page-link next-page" id="next-page-movieDetailHot"\
									value="showMovieDetailHotComment?page='+infoPage.nextPage+'&mid='+mid+'">下页</li>';
						 console.log('有后一页');
					 }else{
						 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
					 }
					 
					 $("#movie-detail-pagination").empty();
					 $("#movie-detail-pagination").append(prePage);
					 $("#movie-detail-pagination").append(nowPage);
					 $("#movie-detail-pagination").append(nextPage);
				 }
			}
		});
	});
	
	/*---------------------电影详情页评论获取 下一页-----------------------*/
	$('#movie-detail-pagination').on('click', '#next-page-movieDetail', function(){
		var url = $(this).attr("value");
		console.log(url + " 点击了下一页");
		var mid = url.split('=')[2];
		
		var requestUrl = url.split('?')[0];
		
		console.log('requestUrl ' + requestUrl + "mid " + mid);
		
		
		$.ajax({
			url : url,
			type : "post",
			success : function(data) {
				
				 
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 console.log("hasComments====" + info.hasComments); //true
//				 console.log("pageInfo=="  + info.commentPageInfo.nextPage);
				 
				 
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comments-cards").empty();
//				 
				 //判断是否含有评论
				 var hasComments = info.hasComments;
				 if(hasComments == false){
					 var item = '<h4 style="color: white;">这里暂时还没有人评论哦~</h4>';
					 $("#comments-cards").append(item);
				 }else{
					 //添加评论节点
					 var comments = info.commentPageInfo.list;
					 var commentReply = info.commentReplyCount;
					 $.each(comments, function(key, value) { // 遍历json中的key和value
						 console.log(value.ctitle);
						 var item = '<div class="comment-card-item">\
								<div class="card">\
									<div class="card-body">\
										<div id="review-meta">\
											<a href="../index/userInfo?uid='+value.uid+'"><img src="'+value.uimg +'" alt=""></a> <a\
												href="../index/userInfo?uid='+value.uid+'">'+value.username +' </a><strong\
												class="item-degree" title="推荐">'+value.cscore+'</strong>\
											<p>'+toTime(value.cdate) +'</p>\
										</div>\
										<h4 class="media-heading">\
											<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
										</h4>\
										<p style="color: #666667;">'+value.content.substring(0,60)+'...\
											<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
										</p>\
										<div class="action">\
											<a href="#" title="有用">▲ '+value.clike +'</span></a> <a href="#"\
												title="无用">▼ '+value.cdislike +'</span></a> <a href=""\
												class="reply" style="margin: 0 1rem;">'+commentReply[key]+'回复</a>\
										</div>\
									</div>\
								</div>\
							</div>';
						$("#comments-cards").append(item);
					 }); 

					 var prePage = "";
					 var nextPage = "";
					 
					//修改页码
					 var infoPage = info.commentPageInfo;
					 if(infoPage.hasPreviousPage){
						 console.log('有前一页');
						 prePage = '<li class="page-item page-link pre-page" id="pre-page-movieDetail"\
									value="'+requestUrl+'?page='+infoPage.prePage+'&mid='+mid+'">上页</li>';
					 }else{
						 prePage = '<li class="page-item disabled page-link pre-page"  tabindex="-1">上页</li>';
					 }
					 
					 var nowPage = '<li class="page-item disabled page-link">'+infoPage.pageNum+'/'+infoPage.pages+'</li>'
					 
					 if(infoPage.hasNextPage){
						 nextPage = '<li class="page-item page-link next-page" id="next-page-movieDetail"\
									value="'+requestUrl+'?page='+infoPage.nextPage+'&mid='+mid+'">下页</li>';
						 console.log('有后一页');
					 }else{
						 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
					 }
					 
					 $("#movie-detail-pagination").empty();
					 $("#movie-detail-pagination").append(prePage);
					 $("#movie-detail-pagination").append(nowPage);
					 $("#movie-detail-pagination").append(nextPage);
				 }
			}
		});
		

	});
	
	/*---------------------电影详情页评论获取 上一页-----------------------*/
	$('#movie-detail-pagination').on('click', '#pre-page-movieDetail', function(){
		
		var url = $(this).attr("value");
		console.log(url + " 点击了下一页");
		var mid = url.split('=')[2];
		
		var requestUrl = url.split('?')[0];
		
		console.log('requestUrl ' + requestUrl + "mid " + mid);
		
		
		$.ajax({
			url : url,
			type : "post",
			success : function(data) {
				
				 
				 // 将字符串数据转换为json数据
				 var info = JSON.parse(data);
				 
				 console.log("hasComments====" + info.hasComments); //true
//				 console.log("pageInfo=="  + info.commentPageInfo.nextPage);
				 
				 
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comments-cards").empty();
//				 
				 //判断是否含有评论
				 var hasComments = info.hasComments;
				 if(hasComments == false){
					 var item = '<h4 style="color: white;">这里暂时还没有人评论哦~</h4>';
					 $("#comments-cards").append(item);
				 }else{
					 //添加评论节点
					 var comments = info.commentPageInfo.list;
					 var commentReply = info.commentReplyCount;
					 $.each(comments, function(key, value) { // 遍历json中的key和value
						 console.log(value.ctitle);
						 var item = '<div class="comment-card-item">\
								<div class="card">\
									<div class="card-body">\
										<div id="review-meta">\
											<a href="../index/userInfo?uid='+value.uid+'"><img src="'+value.uimg +'" alt=""></a> <a\
												href="../index/userInfo?uid='+value.uid+'">'+value.username +' </a><strong\
												class="item-degree" title="推荐">'+value.cscore+'</strong>\
											<p>'+toTime(value.cdate) +'</p>\
										</div>\
										<h4 class="media-heading">\
											<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
										</h4>\
										<p style="color: #666667;">'+value.content.substring(0,60)+'...\
											<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
										</p>\
										<div class="action">\
											<a href="#" title="有用">▲ '+value.clike +'</span></a> <a href="#"\
												title="无用">▼ '+value.cdislike +'</span></a> <a href=""\
												class="reply" style="margin: 0 1rem;">'+commentReply[key]+'回复</a>\
										</div>\
									</div>\
								</div>\
							</div>';
						$("#comments-cards").append(item);
					 }); 

					 var prePage = "";
					 var nextPage = "";
					 
					//修改页码
					 var infoPage = info.commentPageInfo;
					 if(infoPage.hasPreviousPage){
						 console.log('有前一页');
						 prePage = '<li class="page-item page-link pre-page" id="pre-page-movieDetail"\
									value="'+requestUrl+'?page='+infoPage.prePage+'&mid='+mid+'">上页</li>';
					 }else{
						 prePage = '<li class="page-item disabled page-link pre-page"  tabindex="-1">上页</li>';
					 }
					 
					 var nowPage = '<li class="page-item disabled page-link">'+infoPage.pageNum+'/'+infoPage.pages+'</li>'
					 
					 if(infoPage.hasNextPage){
						 nextPage = '<li class="page-item page-link next-page" id="next-page-movieDetail"\
									value="'+requestUrl+'?page='+infoPage.nextPage+'&mid='+mid+'">下页</li>';
						 console.log('有后一页');
					 }else{
						 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
					 }
					 
					 $("#movie-detail-pagination").empty();
					 $("#movie-detail-pagination").append(prePage);
					 $("#movie-detail-pagination").append(nowPage);
					 $("#movie-detail-pagination").append(nextPage);
				 }
			}
		});
	});
});