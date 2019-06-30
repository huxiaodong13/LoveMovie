/**
 *  影评相关
 */

$(function(){
	
//	/*------------------获取最受欢迎影评---------------------*/
//	$('#main-badge').click(function(){
//		console.log("点击所有最受欢迎影评");
//		
//		var requestUrl = "showPopuplarComment?page=1";
////		alert("fasong数据");
//		
//		$.get(requestUrl,function(data,status){
////		    alert("Data: " + data + "\nStatus: " + status);
//
//			// 将字符串数据转换为json数据
//			var info = JSON.parse(data);
//			console.log("000info" + info);
//			
//			//添加评论节点
//			 var comments = info.commentPageInfo.list;
//			 var commentReply = info.commentReplyCount;
//			 
//			 
//			// 找到item父节点 删除其子节点，然后追加新的子节点
//			 $(".review-items").empty();
//			 
//			 $.each(comments, function(key, value) { // 遍历json中的key和value
//				 console.log(value.ctitle);
//				 
//				 var item = '<div class="comment-item">\
//						<div class="media">\
//					<div class="media-left">\
//						<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank"\
//							style="width: 10rem"> <img class="media-object"\
//							src="'+value.img+'" alt="">\
//						</a>\
//					</div>\
//					<div class="media-body comment-info">\
//						<div id="review-meta">\
//							<a href="../index/userInfo?uid='+value.uid +'"><img src="'+value.uimg +'" alt=""></a> <a\
//								href="../index/userInfo?uid='+value.uid +'">'+value.username +'</a> <strong class="item-degree"\
//								title="推荐"> ' + value.cscore +' </strong>\
//							<p>'+toTime(value.cdate) +'</p>\
//						</div>\
//						<h4 class="media-heading">\
//							<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
//						</h4>\
//						<p style="color: #666667;">'+value.content.substring(0,60)+'...\
//							<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
//						</p>\
//						<div class="action">\
//							<a href="#" title="有用">▲  '+value.clike + '</span></a> <a href="#"\
//								title="无用">▼ '+ value.cdislike +'</span></a> <a href="" class="reply"\
//								style="margin: 0 1rem;">'+commentReply[key]+'回复</a>\
//						</div>\
//					</div>\
//				</div>\
//			</div>';
//				$(".review-items").append(item);
//			 }); 
//
//			 var prePage = "";
//			 var nextPage = "";
//			 
//			//修改页码
//			 var infoPage = info.commentPageInfo;
//			 if(infoPage.hasPreviousPage){
//				 console.log('有前一页');
//				 prePage = '<li class="page-item page-link pre-page" \
//						value="showPopuplarComment?page='+infoPage.prePage+'" id="pre-page-comment">上页</li>';
//				 
//				 
//			 }else{
//				 prePage = '<li class="page-item disabled page-link pre-page " tabindex="-1">上页</li>';
//			 }
//			 
//			 var nowPage = '<li class="page-item page-link">'+infoPage.pageNum + '/' + infoPage.pages+'</li>';
//			 
//			 if(infoPage.hasNextPage){
//				 nextPage = '<li class="page-item page-link next-page" \
//						value="showPopuplarComment?page='+infoPage.nextPage+'" id="next-page-comment">下页</li>';
//				 console.log('有后一页');
//			 }else{
//				 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
//			 }
//			 
//			 $("#comments-pagination").empty();
//			 $("#comments-pagination").append(prePage);
//			 $("#comments-pagination").append(nowPage);
//			 $("#comments-pagination").append(nextPage);
//		    
//		  });
//	});
	
	/*------------------获取最受欢迎影评---------------------*/
	$('#main-badge').click(function(){
		console.log("点击所有最受欢迎影评");
		
		var requestUrl = "showPopuplarComment?page=1";
//		alert("fasong数据");
		
		$.get(requestUrl,function(data,status){
//		    alert("Data: " + data + "\nStatus: " + status);

			// 将字符串数据转换为json数据
			var info = JSON.parse(data);
			console.log("000info" + info);
			
			//添加评论节点
			 var comments = info.commentPageInfo.list;
			 var commentReply = info.commentReplyCount;
			 
			 
			// 找到item父节点 删除其子节点，然后追加新的子节点
			 $(".review-items").empty();
			 
			 $.each(comments, function(key, value) { // 遍历json中的key和value
				 console.log(value.ctitle);
				 
				 var item = '<div class="comment-item">\
						<div class="media">\
					<div class="media-left">\
						<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank"\
							style="width: 10rem"> <img class="media-object"\
							src="'+value.img+'" alt="">\
						</a>\
					</div>\
					<div class="media-body comment-info">\
						<div id="review-meta">\
							<a href="../index/userInfo?uid='+value.uid +'"><img src="'+value.uimg +'" alt=""></a> <a\
								href="../index/userInfo?uid='+value.uid +'">'+value.username +'</a> <strong class="item-degree"\
								title="推荐"> ' + value.cscore +' </strong>\
							<p>'+toTime(value.cdate) +'</p>\
						</div>\
						<h4 class="media-heading">\
							<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
						</h4>\
						<p style="color: #666667;">'+value.content.substring(0,60)+'...\
							<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
						</p>\
						<div class="action">\
							<a href="#" title="有用">▲  '+value.clike + '</span></a> <a href="#"\
								title="无用">▼ '+ value.cdislike +'</span></a> <a href="" class="reply"\
								style="margin: 0 1rem;">'+commentReply[key]+'回复</a>\
						</div>\
					</div>\
				</div>\
			</div>';
				$(".review-items").append(item);
			 }); 

			 var prePage = "";
			 var nextPage = "";
			 
			//修改页码
			 var infoPage = info.commentPageInfo;
			 if(infoPage.hasPreviousPage){
				 console.log('有前一页');
				 prePage = '<li class="page-item page-link pre-page" \
						value="showPopuplarComment?page='+infoPage.prePage+'" id="pre-page-comment">上页</li>';
				 
				 
			 }else{
				 prePage = '<li class="page-item disabled page-link pre-page " tabindex="-1">上页</li>';
			 }
			 
			 var nowPage = '<li class="page-item page-link">'+infoPage.pageNum + '/' + infoPage.pages+'</li>';
			 
			 if(infoPage.hasNextPage){
				 nextPage = '<li class="page-item page-link next-page" \
						value="showPopuplarComment?page='+infoPage.nextPage+'" id="next-page-comment">下页</li>';
				 console.log('有后一页');
			 }else{
				 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
			 }
			 
			 $("#comments-pagination").empty();
			 $("#comments-pagination").append(prePage);
			 $("#comments-pagination").append(nowPage);
			 $("#comments-pagination").append(nextPage);
		    
		  });
	});

	/*----------------------------点击最受欢迎评论下一页获取数据------------------------*/
	$('#comments-pagination').on('click', '#next-page-comment', function(){
		var url = $(this).attr("value");
		console.log(url + " 点击了下一页");
		
		var request = url.split('=')[0]; //要请求的链接
		
		$.get(url,function(data,status){
//		    alert("Data: " + data + "\nStatus: " + status);

			// 将字符串数据转换为json数据
			var info = JSON.parse(data);
			console.log("000info" + info);
			
			//添加评论节点
			 var comments = info.commentPageInfo.list;
			 var commentReply = info.commentReplyCount;
			 
			 
			// 找到item父节点 删除其子节点，然后追加新的子节点
			 $(".review-items").empty();
			 
			 $.each(comments, function(key, value) { // 遍历json中的key和value
				 console.log(value.ctitle);
				 
				 var item = '<div class="comment-item">\
						<div class="media">\
					<div class="media-left">\
						<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank"\
							style="width: 10rem"> <img class="media-object"\
							src="'+value.img+'" alt="">\
						</a>\
					</div>\
					<div class="media-body comment-info">\
						<div id="review-meta">\
							<a href="../index/userInfo?uid='+value.uid+'"><img src="'+value.uimg +'" alt=""></a> <a\
								href="../index/userInfo?uid='+value.uid+'">'+value.username +'</a> <strong class="item-degree"\
								title="推荐"> ' + value.cscore +' </strong>\
							<p>'+toTime(value.cdate) +'</p>\
						</div>\
						<h4 class="media-heading">\
							<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
						</h4>\
						<p style="color: #666667;">'+value.content.substring(0,60)+'...\
							<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
						</p>\
						<div class="action">\
							<a href="#" title="有用">▲  '+value.clike + '</span></a> <a href="#"\
								title="无用">▼ '+ value.cdislike +'</span></a> <a href="" class="reply"\
								style="margin: 0 1rem;">'+commentReply[key]+'回复</a>\
						</div>\
					</div>\
				</div>\
			</div>';
				$(".review-items").append(item);
			 }); 

			 var prePage = "";
			 var nextPage = "";
			 
			//修改页码
			 var infoPage = info.commentPageInfo;
			 if(infoPage.hasPreviousPage){
				 console.log('有前一页');
				 prePage = '<li class="page-item page-link pre-page" \
						value="'+ request +'='+infoPage.prePage+'" id="pre-page-comment">上页</li>';
				 
				 
			 }else{
				 prePage = '<li class="page-item disabled page-link pre-page " tabindex="-1">上页</li>';
			 }
			 
			 var nowPage = '<li class="page-item page-link">'+infoPage.pageNum + '/' + infoPage.pages+'</li>';
			 
			 if(infoPage.hasNextPage){
				 nextPage = '<li class="page-item page-link next-page" \
						value="'+ request +'='+ infoPage.nextPage+'" id="next-page-comment">下页</li>';
				 console.log('有后一页');
			 }else{
				 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
			 }
			 
			 $("#comments-pagination").empty();
			 $("#comments-pagination").append(prePage);
			 $("#comments-pagination").append(nowPage);
			 $("#comments-pagination").append(nextPage);
		    
		  });
	});
	
	
	/*----------------------------点击评论上一页获取数据------------------------*/
	$('#comments-pagination').on('click', '#pre-page-comment', function(){
		var url = $(this).attr("value");
		console.log(url + " 点击了上一页");
		
		var request = url.split('=')[0]; //要请求的链接
		
		
		$.get(url,function(data,status){
//		    alert("Data: " + data + "\nStatus: " + status);

			// 将字符串数据转换为json数据
			var info = JSON.parse(data);
			console.log("000info" + info);
			
			//添加评论节点
			 var comments = info.commentPageInfo.list;
			 var commentReply = info.commentReplyCount;
			 
			 
			// 找到item父节点 删除其子节点，然后追加新的子节点
			 $(".review-items").empty();
			 
			 $.each(comments, function(key, value) { // 遍历json中的key和value
				 console.log(value.ctitle);
				 
				 var item = '<div class="comment-item">\
						<div class="media">\
					<div class="media-left">\
						<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank"\
							style="width: 10rem"> <img class="media-object"\
							src="'+value.img+'" alt="">\
						</a>\
					</div>\
					<div class="media-body comment-info">\
						<div id="review-meta">\
							<a href="../index/userInfo?uid='+value.uid+'"><img src="'+value.uimg +'" alt=""></a> <a\
								href="../index/userInfo?uid='+value.uid+'">'+value.username +'</a> <strong class="item-degree"\
								title="推荐"> ' + value.cscore +' </strong>\
							<p>'+toTime(value.cdate) +'</p>\
						</div>\
						<h4 class="media-heading">\
							<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
						</h4>\
						<p style="color: #666667;">'+value.content.substring(0,60)+'...\
							<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
						</p>\
						<div class="action">\
							<a href="#" title="有用">▲  '+value.clike + '</span></a> <a href="#"\
								title="无用">▼ '+ value.cdislike +'</span></a> <a href="" class="reply"\
								style="margin: 0 1rem;">'+commentReply[key]+'回复</a>\
						</div>\
					</div>\
				</div>\
			</div>';
				$(".review-items").append(item);
			 }); 

			 var prePage = "";
			 var nextPage = "";
			 
			//修改页码
			 var infoPage = info.commentPageInfo;
			 if(infoPage.hasPreviousPage){
				 console.log('有前一页');
				 prePage = '<li class="page-item page-link pre-page" \
						value="'+ request +'='+infoPage.prePage+'" id="pre-page-comment">上页</li>';
				 
				 
			 }else{
				 prePage = '<li class="page-item disabled page-link pre-page " tabindex="-1">上页</li>';
			 }
			 
			 var nowPage = '<li class="page-item page-link">'+infoPage.pageNum + '/' + infoPage.pages+'</li>';
			 
			 if(infoPage.hasNextPage){
				 nextPage = '<li class="page-item page-link next-page" \
						value="'+ request +'='+ infoPage.nextPage+'" id="next-page-comment">下页</li>';
				 console.log('有后一页');
			 }else{
				 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
			 }
			 
			 $("#comments-pagination").empty();
			 $("#comments-pagination").append(prePage);
			 $("#comments-pagination").append(nowPage);
			 $("#comments-pagination").append(nextPage);
		    
		  });
	});
	
	/*------------------获取新片影评---------------------*/
	$('#newReview').click(function(){
		console.log("点击所有新片影评");
		
		var requestUrl = "showNewComment?page=1";
//		alert("fasong数据");
		
		$.get(requestUrl,function(data,status){
//		    alert("Data: " + data + "\nStatus: " + status);

			// 将字符串数据转换为json数据
			var info = JSON.parse(data);
			console.log("000info" + info);
			
			//添加评论节点
			 var comments = info.commentPageInfo.list;
			 var commentReply = info.commentReplyCount;
			 
			 
			// 找到item父节点 删除其子节点，然后追加新的子节点
			 $(".review-items").empty();
			 
			 $.each(comments, function(key, value) { // 遍历json中的key和value
				 console.log(value.ctitle);
				 
				 var item = '<div class="comment-item">\
						<div class="media">\
					<div class="media-left">\
						<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank"\
							style="width: 10rem"> <img class="media-object"\
							src="'+value.img+'" alt="">\
						</a>\
					</div>\
					<div class="media-body comment-info">\
						<div id="review-meta">\
							<a href="../index/userInfo?uid='+value.uid +'"><img src="'+value.uimg +'" alt=""></a> <a\
								href="../index/userInfo?uid='+value.uid +'">'+value.username +'</a> <strong class="item-degree"\
								title="推荐"> ' + value.cscore +' </strong>\
							<p>'+toTime(value.cdate) +'</p>\
						</div>\
						<h4 class="media-heading">\
							<a href="../review/reviewDetail?cid='+value.cid+'">'+value.ctitle +'</a>\
						</h4>\
						<p style="color: #666667;">'+value.content.substring(0,60)+'...\
							<a href="../review/reviewDetail?cid='+value.cid+'" class="btn btn-link">全文</a>\
						</p>\
						<div class="action">\
							<a href="#" title="有用">▲  '+value.clike + '</span></a> <a href="#"\
								title="无用">▼ '+ value.cdislike +'</span></a> <a href="" class="reply"\
								style="margin: 0 1rem;">'+commentReply[key]+'回复</a>\
						</div>\
					</div>\
				</div>\
			</div>';
				$(".review-items").append(item);
			 }); 

			 var prePage = "";
			 var nextPage = "";
			 
			//修改页码
			 var infoPage = info.commentPageInfo;
			 if(infoPage.hasPreviousPage){
				 console.log('有前一页');
				 prePage = '<li class="page-item page-link pre-page" \
						value="showNewComment?page='+infoPage.prePage+'" id="pre-page-comment">上页</li>';
				 
				 
			 }else{
				 prePage = '<li class="page-item disabled page-link pre-page " tabindex="-1">上页</li>';
			 }
			 
			 var nowPage = '<li class="page-item page-link">'+infoPage.pageNum + '/' + infoPage.pages+'</li>';
			 
			 if(infoPage.hasNextPage){
				 nextPage = '<li class="page-item page-link next-page" \
						value="showNewComment?page='+infoPage.nextPage+'" id="next-page-comment">下页</li>';
				 console.log('有后一页');
			 }else{
				 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
			 }
			 
			 $("#comments-pagination").empty();
			 $("#comments-pagination").append(prePage);
			 $("#comments-pagination").append(nowPage);
			 $("#comments-pagination").append(nextPage);
		    
		  });
	});
	
	
	/*------------------获取热门影评---------------------*/
	$('#hotReview').click(function(){
		console.log("点击所有热门影评");
		
		var requestUrl = "showHotComment?page=1";
//		alert("fasong数据");
		
		$.get(requestUrl,function(data,status){
//		    alert("Data: " + data + "\nStatus: " + status);

			// 将字符串数据转换为json数据
			var info = JSON.parse(data);
			console.log("000info" + info);
			
			//添加评论节点
			 var comments = info.commentPageInfo.list;
			 var users = info.commentUser;
			 var movies = info.commentMovie;
			 
			 
			// 找到item父节点 删除其子节点，然后追加新的子节点
			 $(".review-items").empty();
			 
			 $.each(comments, function(key, value) { // 遍历json中的key和value
				 console.log(value.ctitle);
				 
				 var item = '<div class="comment-item">\
						<div class="media">\
					<div class="media-left">\
						<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank"\
							style="width: 10rem"> <img class="media-object"\
							src="'+movies[key].img+'" alt="">\
						</a>\
					</div>\
					<div class="media-body comment-info">\
						<div id="review-meta">\
							<a href="../index/userInfo?uid='+ value.comuid +'"><img src="'+users[key].uimg +'" alt=""></a> <a\
								href="../index/userInfo?uid='+value.comuid +'">'+users[key].username +'</a> <strong class="item-degree"\
								title="推荐"> ' + value.cscore +' </strong>\
							<p>'+toTime(value.cdate) +'</p>\
						</div>\
						<h4 class="media-heading">\
							<a href="../review/reviewDetail?cid='+value.comcid+'">'+value.ctitle +'</a>\
						</h4>\
						<p style="color: #666667;">'+value.content.substring(0,60)+'...\
							<a href="../review/reviewDetail?cid='+value.comcid+'" class="btn btn-link">全文</a>\
						</p>\
						<div class="action">\
							<a href="#" title="有用">▲  '+value.clike + '</span></a> <a href="#"\
								title="无用">▼ '+ value.cdislike +'</span></a> <a href="" class="reply"\
								style="margin: 0 1rem;">'+value.replyCount+'回复</a>\
						</div>\
					</div>\
				</div>\
			</div>';
				$(".review-items").append(item);
			 }); 

			 var prePage = "";
			 var nextPage = "";
			 
			//修改页码
			 var infoPage = info.commentPageInfo;
			 if(infoPage.hasPreviousPage){
				 console.log('有前一页');
				 prePage = '<li class="page-item page-link pre-page" \
						value="showHotComment?page='+infoPage.prePage+'" id="pre-page-hotcomment">上页</li>';
				 
				 
			 }else{
				 prePage = '<li class="page-item disabled page-link pre-page " tabindex="-1">上页</li>';
			 }
			 
			 var nowPage = '<li class="page-item page-link">'+infoPage.pageNum + '/' + infoPage.pages+'</li>';
			 
			 if(infoPage.hasNextPage){
				 nextPage = '<li class="page-item page-link next-page" \
						value="showHotComment?page='+infoPage.nextPage+'" id="next-page-hotcomment">下页</li>';
				 console.log('有后一页');
			 }else{
				 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
			 }
			 
			 $("#comments-pagination").empty();
			 $("#comments-pagination").append(prePage);
			 $("#comments-pagination").append(nowPage);
			 $("#comments-pagination").append(nextPage);
		    
		  });
	});
	
	/*------------------获取热门影评的下一页---------------------*/
	$('#comments-pagination').on('click', '#next-page-hotcomment', function(){
		
		var url = $(this).attr("value");
		console.log(url + " 点击了热门影评的下一页");
		
		
		var request = url.split('=')[0]+'='; //要请求的链接
		console.log(request);
		
		
		
		$.get(url,function(data,status){
//		    alert("Data: " + data + "\nStatus: " + status);

			// 将字符串数据转换为json数据
			var info = JSON.parse(data);
			console.log("000info" + info);
			
			//添加评论节点
			 var comments = info.commentPageInfo.list;
			 var users = info.commentUser;
			 var movies = info.commentMovie;
			 
			 
			// 找到item父节点 删除其子节点，然后追加新的子节点
			 $(".review-items").empty();
			 
			 $.each(comments, function(key, value) { // 遍历json中的key和value
				 console.log(value.ctitle);
				 
				 var item = '<div class="comment-item">\
						<div class="media">\
					<div class="media-left">\
						<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank"\
							style="width: 10rem"> <img class="media-object"\
							src="'+movies[key].img+'" alt="">\
						</a>\
					</div>\
					<div class="media-body comment-info">\
						<div id="review-meta">\
							<a href="../index/userInfo?uid='+ value.comuid +'"><img src="'+users[key].uimg +'" alt=""></a> <a\
								href="../index/userInfo?uid='+value.comuid +'">'+users[key].username +'</a> <strong class="item-degree"\
								title="推荐"> ' + value.cscore +' </strong>\
							<p>'+toTime(value.cdate) +'</p>\
						</div>\
						<h4 class="media-heading">\
							<a href="../review/reviewDetail?cid='+value.comcid+'">'+value.ctitle +'</a>\
						</h4>\
						<p style="color: #666667;">'+value.content.substring(0,60)+'...\
							<a href="../review/reviewDetail?cid='+value.comcid+'" class="btn btn-link">全文</a>\
						</p>\
						<div class="action">\
							<a href="#" title="有用">▲  '+value.clike + '</span></a> <a href="#"\
								title="无用">▼ '+ value.cdislike +'</span></a> <a href="" class="reply"\
								style="margin: 0 1rem;">'+value.replyCount+'回复</a>\
						</div>\
					</div>\
				</div>\
			</div>';
				$(".review-items").append(item);
			 }); 

			 var prePage = "";
			 var nextPage = "";
			 
			//修改页码
			 var infoPage = info.commentPageInfo;
			 if(infoPage.hasPreviousPage){
				 console.log('有前一页');
				 prePage = '<li class="page-item page-link pre-page" \
						value="'+request+infoPage.prePage+'" id="pre-page-hotcomment">上页</li>';
				 
				 
			 }else{
				 prePage = '<li class="page-item disabled page-link pre-page " tabindex="-1">上页</li>';
			 }
			 
			 var nowPage = '<li class="page-item page-link">'+infoPage.pageNum + '/' + infoPage.pages+'</li>';
			 
			 if(infoPage.hasNextPage){
				 nextPage = '<li class="page-item page-link next-page" \
						value="'+request+infoPage.nextPage+'" id="next-page-hotcomment">下页</li>';
				 console.log('有后一页');
			 }else{
				 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
			 }
			 
			 $("#comments-pagination").empty();
			 $("#comments-pagination").append(prePage);
			 $("#comments-pagination").append(nowPage);
			 $("#comments-pagination").append(nextPage);
		    
		  });
	});
	
	/*------------------获取热门影评的上一页---------------------*/
	$('#comments-pagination').on('click', '#pre-page-hotcomment', function(){
		
		var url = $(this).attr("value");
		console.log(url + " 点击了热门影评的下一页");
		
		
		var request = url.split('=')[0]+'='; //要请求的链接
		console.log(request);
		
		
		
		$.get(url,function(data,status){
//		    alert("Data: " + data + "\nStatus: " + status);

			// 将字符串数据转换为json数据
			var info = JSON.parse(data);
			console.log("000info" + info);
			
			//添加评论节点
			 var comments = info.commentPageInfo.list;
			 var users = info.commentUser;
			 var movies = info.commentMovie;
			 
			 
			// 找到item父节点 删除其子节点，然后追加新的子节点
			 $(".review-items").empty();
			 
			 $.each(comments, function(key, value) { // 遍历json中的key和value
				 console.log(value.ctitle);
				 
				 var item = '<div class="comment-item">\
						<div class="media">\
					<div class="media-left">\
						<a href="../movie/movieDetail?mid='+value.mid+'" class="comment-cover " target="_blank"\
							style="width: 10rem"> <img class="media-object"\
							src="'+movies[key].img+'" alt="">\
						</a>\
					</div>\
					<div class="media-body comment-info">\
						<div id="review-meta">\
							<a href="../index/userInfo?uid='+ value.comuid +'"><img src="'+users[key].uimg +'" alt=""></a> <a\
								href="../index/userInfo?uid='+value.comuid +'">'+users[key].username +'</a> <strong class="item-degree"\
								title="推荐"> ' + value.cscore +' </strong>\
							<p>'+toTime(value.cdate) +'</p>\
						</div>\
						<h4 class="media-heading">\
							<a href="../review/reviewDetail?cid='+value.comcid+'">'+value.ctitle +'</a>\
						</h4>\
						<p style="color: #666667;">'+value.content.substring(0,60)+'...\
							<a href="../review/reviewDetail?cid='+value.comcid+'" class="btn btn-link">全文</a>\
						</p>\
						<div class="action">\
							<a href="#" title="有用">▲  '+value.clike + '</span></a> <a href="#"\
								title="无用">▼ '+ value.cdislike +'</span></a> <a href="" class="reply"\
								style="margin: 0 1rem;">'+value.replyCount+'回复</a>\
						</div>\
					</div>\
				</div>\
			</div>';
				$(".review-items").append(item);
			 }); 

			 var prePage = "";
			 var nextPage = "";
			 
			//修改页码
			 var infoPage = info.commentPageInfo;
			 if(infoPage.hasPreviousPage){
				 console.log('有前一页');
				 prePage = '<li class="page-item page-link pre-page" \
						value="'+request+infoPage.prePage+'" id="pre-page-hotcomment">上页</li>';
				 
				 
			 }else{
				 prePage = '<li class="page-item disabled page-link pre-page " tabindex="-1">上页</li>';
			 }
			 
			 var nowPage = '<li class="page-item page-link">'+infoPage.pageNum + '/' + infoPage.pages+'</li>';
			 
			 if(infoPage.hasNextPage){
				 nextPage = '<li class="page-item page-link next-page" \
						value="'+request+infoPage.nextPage+'" id="next-page-hotcomment">下页</li>';
				 console.log('有后一页');
			 }else{
				 nextPage = '<li class="page-item disabled page-link next-page " tabindex="-1">下页</li>';
			 }
			 
			 $("#comments-pagination").empty();
			 $("#comments-pagination").append(prePage);
			 $("#comments-pagination").append(nowPage);
			 $("#comments-pagination").append(nextPage);
		    
		  });
	});
	
	
	
	
});