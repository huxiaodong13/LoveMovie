/**
 * 影评详情
 */

$(function(){
	// 收藏评论
	$('.stroupId').on('click','.favorites', function(){
//		$(this).hide();
//		var count = $(this).find('span').text();
//		count = parseInt(count)+1;
//		$('.isfavorites').find('span').text(count);	
//		$('.isfavorites').show();
		
		var count = $(this).find('span').text();
		//异步请求收藏该评论
		var commentId = $('#commentId').attr('value');
		$.get("doStoreUpComment", { status: "0", cid:commentId},function(data){
				    console.log("Data Loaded: " + data);
				    
				    if(data=="-1"){
				    	alert("请登录后再收藏");
				    }else if(data == "2"){
				    	alert("收藏失败, 请稍后重试");
				    }else{
				    	alert("收藏成功");
				    	count = parseInt(count)+1;
						var item = '<button type="button" class="btn btn-dark isfavorites">\
													已收藏 <span>'+ count +'</span></button>';
						$('button').remove('.favorites');
						$('.stroupId').append(item);
				    }	    
		});
	});
	
	
	
	
	//取消收藏评论
	$('.stroupId').on('click','.isfavorites', function(){
//		$(this).hide();
//		var count = $(this).find('span').text();
////		count = parseInt(count)-1;
////		$('.favorites').find('span').text(count);	
//		$('.favorites').show();	
		
		var count = $(this).find('span').text();
		var commentId = $('#commentId').attr('value');
		//异步请求收藏该评论
		//...
		
		$.get("doStoreUpComment", { status: "1", cid:commentId},function(data){
		    console.log("Data Loaded: " + data);
		    if(data == "2"){
		    	alert("收藏失败, 请稍后重试");
		    }else{
		    	alert("取消收藏成功");
		    	count = parseInt(count)-1;
				var item = '<button type="button" class="btn btn-outline-dark favorites">\
											收藏 <span>'+ count +'</span></button>';
				$('button').remove('.isfavorites');
				$('.stroupId').append(item);
		    }	    
		});
	});
	
	//--------点击有用     10 没有点击  11 状态为点击了有用
	$('#likeId').on('click', '#thumb-up', function(){
		
		console.log("点击了有用");
		var status = $(this).attr('value');
		var commentId = $('#commentId').attr('value');
		if(status == "0"){
			alert("点击有用前请登录");
		}else if(status == "10"){
			console.log("我要点击有用, 要判断是否踩了该帖子");
			var isDown = $('#thumb-down').attr('value');
	 
			//踩了 修改踩了的样式
			if(isDown == "01"){
				var downCount = $('#thumb-down').find('span').text();
				downCount = parseInt(downCount)-1;
				var downItem = '<button type="button" class="btn btn-outline-dark"\
					id="thumb-down" value="00">\
				<img src="../img/open-iconic-master/thumb-down-3x.png" alt="">\
				没用 <span>'+downCount+'</span>\
					</button>';	
				$('button').remove('#thumb-down');	//删除原来的并添加现在的没用节点
				$('#likeId').prepend(downItem);
			}
			//点击有用
			//ajax请求
			//若是没用是原来的状态的话 要修改评论的概状态
			//赞
			$.get("doThumb", { thumbStatus: "11", cid:commentId},function(data){
				console.log(" 我赞了 data");
			});
			var count = $(this).find('span').text();
			count = parseInt(count)+1;
			var item = '<button type="button" class="btn btn-dark" id="thumb-up" value="11">\
				<img src="../img/open-iconic-master/thumb-up-white-3x.png"\
					alt=""> 有用 <span>'+count +'</span>\
			</button>';
			$('button').remove('#thumb-up');
			$('#likeId').prepend(item);
			
		}else if(status == "11"){
			console.log("我要取消有用，我原来是赞同了他的");
			//ajax请求
			$.get("doThumb", { thumbStatus: "10", cid:commentId},function(data){
				console.log(" 我取消赞了 data");
			});
			var count = $(this).find('span').text();
			count = parseInt(count)-1;
			var item = '<button type="button" class="btn btn-outline-dark" id="thumb-up"\
				value="10">\
					<img src="../img/open-iconic-master/thumb-up-3x.png" alt="">\
					有用 <span>'+count+'</span>\
				</button>';
			$('button').remove('#thumb-up');
			$('#likeId').prepend(item);
		}
	});



	//--------点击没用     00 没有踩   01 状态为点击了踩
	$('#likeId').on('click', '#thumb-down', function(){
		
		console.log("点击了踩");
		var status = $(this).attr('value');
		var commentId = $('#commentId').attr('value');
		
		console.log(" 踩 status "+status);
		
		if(status == "0"){
			alert("点击踩前请登录");
		}else if(status == "00"){
			console.log("我要点击踩, 要判断是否赞了该帖子");
			var isUp = $('#thumb-up').attr('value');
	 
			//踩了 修改踩了的样式
			if(isUp == "11"){
				var upCount = $('#thumb-up').find('span').text();
				upCount = parseInt(upCount)-1;
				var upItem = '<button type="button" class="btn btn-outline-dark" id="thumb-up"\
					value="10">\
					<img src="../img/open-iconic-master/thumb-up-3x.png" alt="">\
					有用 <span>'+ upCount +'</span>\
					</button>';	
				
				$('button').remove('#thumb-up');	//删除原来的并添加现在有用节点
				$('#likeId').prepend(upItem);
			}
			//点击踩
			//ajax请求
			//若是踩本是原来的状态的话 要修改评论的概状态
			//赞
			$.get("doThumb", { thumbStatus: "01", cid:commentId},function(data){
				console.log(" 我踩了 data");
			});
			var count = $(this).find('span').text();
			count = parseInt(count)+1;
			var item = '<button type="button" class="btn btn-dark" id="thumb-down"\
				value="01">\
				<img src="../img/open-iconic-master/thumb-down-white-3x.png"\
				alt=""> 没用 <span>'+count+'</span>\
				</button>';
			$('button').remove('#thumb-down');
			$('#likeId').append(item);
			
		}else if(status == "01"){
			console.log("我要取消踩，我原来是踩了他的");
			//ajax请求
			$.get("doThumb", { thumbStatus: "00", cid:commentId},function(data){
				console.log(" 我取消踩了 data");
			});
			var count = $(this).find('span').text();
			count = parseInt(count)-1;
			var item = '<button type="button" class="btn btn-outline-dark"\
				id="thumb-down" value="00">\
				<img src="../img/open-iconic-master/thumb-down-3x.png" alt="">\
				没用 <span>'+count+'</span>\
				</button>';
			$('button').remove('#thumb-down');
			$('#likeId').append(item);
		}
	});
	
	/*-------------------------举报-------------------------------*/
	$('#comment-report').click(function(){
		var reason = $("input[type='radio']:checked").val();
		console.log(reason);
		var commentId = $('#commentId').attr('value');
		
		$.get("doReport", { reason: reason, cid:commentId},function(data){
			console.log(data);
			
			if(data == "0"){
				alert("请登录后再举报");
			}else if(data == "1"){
				alert("举报成功");
			}else{
				alert("举报失败");
			}
		});
	});
	
	/*-------------------------添加回复-------------------------------*/
	$('#addReply').click(function(){
		
		var content = $('#comment-text').val();
		console.log(content);
		var commentId = $('#commentId').attr('value');
		var touid = $('#touidUrl').attr('href').split('=')[1];
		console.log("touid:"+touid)
		
		$.post("doAddReplyToComment", { content: content, cid:commentId, touid:touid},function(data){
			if(data == "0"){
				alert("请登录后再回复");
			}else if(data == "1"){
				alert("回复成功");
				location.reload();
			}else{
				alert("回复失败");
			}
		});
		
	});
	
	
	
	
	
});