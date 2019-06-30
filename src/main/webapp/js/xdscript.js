function time(time = +new Date()) {
    var date = new Date(time + 8 * 3600 * 1000);
    return date.toJSON().substr(0, 11).replace('T', ' ');
}

var mnameIsOk = false;
//检查电影名
function checkMname() {
	var mname = $("#mname");
	if(mname.val() == ""){//获取元素值
		userName.addClass("wrong"); //在该元素上添加值为wrong的class属性
		mname_prompt.text("不能为空");
		mnameIsOk = false;
		return;
	}
}

$(function(){
	$("#doReset").click(function(){
		$('#insertM')[0].reset();
	})
	$("#doInsert").click(function(){
		//判断输入是否合法
		//var mname = $("input[name='mname']").text;
		//console.log(mname);
		//console.log($("#insertM").serialize());
		$.ajax({
			url: "insertMovie",
			type: "post",
			data: $("#insertM").serialize(),
			async: false,
			success: function (data) {
				if(data=="success"){
					alert("添加电影成功");
					$('#insertM')[0].reset();
					window.location.reload();
				}else{
					$('#insertM')[0].reset();
					alert("操作失败");
				}

			}
		});
	});
	
	$('#movie-text').on('click','.xdbtn-edit',function(){
		var mid = $(this).parents().children().eq(4).text();
		console.log(mid);
		$.ajax({
			url: "selectMovie?mid="+mid,
			type: "post",
			success: function (data) {
				if(data != null){
					var datas = JSON.parse(data);
					console.log(datas);
					$("#umid").val(datas.mid);
//					$("#add input[name=mid]").val()
					$("#umname").val(datas.mname);
					$("#umactor").val(datas.mactor);
					$("#umalias").val(datas.malias);
					$("#umbrief").val(datas.mbrief);
					$("#umcountry").val(datas.mcountry);
					$("#umdirect").val(datas.mdirect);
					$("#umid").val(datas.mid);
					$("#umlanguage").val(datas.mlanguage);
					$("#umlong").val(datas.mlong);
					$("#umtag").val(datas.mtag);
					$("#umtime").val(datas.mtime);
					$("#umurl").val(datas.murl);
					$("#umwriter").val(datas.mwriter);
					console.log(datas.mname);
				}else{
					console.log("该电影已经不存在");
				}
			},error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			}
		});

	});
	
	$("#doUpdate").click(function(){
		console.log($("#updateM").serialize());
		console.log($("#umid").val);
		$.ajax({
			url: "updateMovie",
			type: "post",
			data: $("#updateM").serialize(),
			async: false,
			success: function (data){
				if(data=="success"){
					alert("更新电影成功");
					$('#updateM')[0].reset();
					window.location.reload();
				}else{
					$('#updateM')[0].reset();
					alert("操作失败");
				}
			},
		});
	});
});


$(function(){

	$('#newDate-movies-items').on('mouseover','.movie-item',function(){
		console.log('over');
		console.log($(this));
		$(this).find('.item-info-summary').show();
	});
	
	$('#newDate-movies-items').on('mouseleave','.movie-item',function(){
		console.log('left');
		console.log($(this));
		$(this).find('.item-info-summary').hide();
	});
	
	//点击用户删除
	$('#users-text').on('click','.xdbtn-delete', function(){
		console.log("xdbtn-delete");
		var uid = $(this).parents().children().eq(2).text();
		console.log(uid);
		var mymessage=confirm("确定要删除该用户吗？");
		if(mymessage==true){
			$.ajax({
				url : "delUser?uid=" + uid,
				type : "post",
				success: function(data) {
					if(data=="success"){
						alert("删除用户信息成功");
						window.location.reload();
					}else{
						alert("删除用户信息失败");
					}
				}
			});
			
		}else{

		}
		
	});
	
	//点击电影删除
	$('#movie-text').on('click','.xdbtn-delete', function(){
		console.log("xdbtn-delete");
		var mid = $(this).parents().children().eq(4).text();
		console.log(mid);
		var mymessage=confirm("确定要删除该电影吗？");
		if(mymessage==true){
			$.ajax({
				url : "delMovie?mid=" + mid,
				type : "post",
				success: function(data) {
					if(data=="success"){
						alert("删除电影信息成功");
						window.location.reload();
					}else{
						alert("删除电影信息失败");
					}
				}
			});
			
		}else{
		}
		
	});

	//点击影评删除
	$('#comments-text').on('click','.xdbtn-delete', function(){
		console.log("xdbtn-delete");
		var cid = $(this).parents().children().eq(3).text();
		console.log(cid);
		var mymessage=confirm("确定要删除该影评吗？");
		if(mymessage==true){
			$.ajax({
				url : "delComment?cid=" + cid,
				type : "post",
				success: function(data) {
					if(data=="success"){
						alert("删除影评信息成功");
						window.location.reload();
					}else{
						alert("删除影评信息失败");
					}
				}
			});
			
		}else{
		}
		
	});
	
	//点击 恶意影评删除
	$('#badComment-text').on('click','.xdbtn-delete', function(){
		console.log("xdbtn-delete");
		var cid = $(this).parents().children().eq(3).text();
		console.log(cid);
		var mymessage=confirm("确定要删除该恶意影评吗？");
		if(mymessage==true){
			$.ajax({
				url : "delComment?cid=" + cid,
				type : "post",
				success: function(data) {
					if(data=="success"){
						alert("删除 恶意影评信息成功");
						window.location.reload();
					}else{
						alert("删除 恶意影评信息失败");
					}
				}
			});
			
		}else{
		}
		
	});

	//点击 恶意回复删除
	$('#badReplys-text').on('click','.xdbtn-delete', function(){
		console.log("xdbtn-delete");
		var rid = $(this).parents().children().eq(2).text();
		console.log(rid);
		var mymessage=confirm("确定要删除该恶意回复吗？");
		if(mymessage==true){
			$.ajax({
				url : "delBadReply?rid=" + rid,
				type : "post",
				success: function(data) {
					if(data=="success"){
						alert("删除 恶意回复信息成功");
						window.location.reload();
					}else{
						alert("删除 恶意回复信息失败");
					}
				}
			});
			
		}else{
		}
		
	});

	//点击 回复删除
	$('#replys-text').on('click','.xdbtn-delete', function(){
		console.log("xdbtn-delete");
		var rid = $(this).parents().children().eq(2).text();
		console.log(rid);
		var mymessage=confirm("确定要删除该回复吗？");
		if(mymessage==true){
			$.ajax({
				url : "delBadReply?rid=" + rid,
				type : "post",
				success: function(data) {
					if(data=="success"){
						alert("删除 回复信息成功");
						window.location.reload();
					}else{
						alert("删除 回复信息失败");
					}
				}
			});
			
		}else{
		}
		
	});

	
//	$('#userItems').click(function(){
//	    //alert($(this).children().eq(1).html());
//		alert(document.getElementById("userItems").rows[1].cells[2].innerHTML);
//	});

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

	//金典排行榜10
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

	/**
	 * 点击电影上一页
	 */
	$("#movie-pagination").on('click', '#pre-page', function(){
		console.log("#pre-page");
		var page = $(this).attr("value");
		//console.log(page);
		var count = (page-1)*6;
		$.ajax({
			url : "showMovies?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#movie-text").empty();
				 var info = JSON.parse(data);				 
				 var movies = info.list;				 
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 count += 1;
							var item = '<tr>'+
										'<th scope="row">'+count+'</th>'+
					 					'<td>'+value.mname+'</td>'+
					 					'<td>'+value.mid+'</td>'+
					 					'<td>'+value.mdirect+'</td>'+
					 					'<td>'+value.mtag+'</td>'+
					 					'<td><button type="button" class="btn btn-danger btn-sm xdbtn-delete">'+"删除"+'</button>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'+
										'<button type="button" class="btn btn-secondary btn-sm xdbtn-edit" data-toggle="modal" data-target="#exampleModalLong">'+"编辑"+'</button></td>'+'</tr>';	
									$("#movie-text").append(item);
								 });
				 
				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item" id="pre-page" value="'+info.prePage+'"><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>';
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item" id="next-page" value="'+info.nextPage+'"><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">下页</a></li>'; 
				 }
				 
				 $("#movie-pagination").empty();
				 $("#movie-pagination").append(prePage);
				 $("#movie-pagination").append(nowPage);
				 $("#movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});

		
	/**
	 * 点击电影下一页
	 */
	$("#movie-pagination").on('click', '#next-page', function(){
		console.log("#next-page");
		var page = $(this).attr("value");
		//console.log(page);
		var count = (page-1)*6;
		$.ajax({
			url : "showMovies?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#movie-text").empty();
				 var info = JSON.parse(data);				 
				 var movies = info.list;				 
				 $.each(movies, function(key, value) { // 遍历json中的key和value
					 count += 1;
							console.log(value.mactor);
							var item = '<tr>'+
										'<th scope="row">'+count+'</th>'+
					 					'<td>'+value.mname+'</td>'+
					 					'<td>'+value.mid+'</td>'+
					 					'<td>'+value.mdirect+'</td>'+
					 					'<td>'+value.mtag+'</td>'+
					 					'<td><button type="button" class="btn btn-danger btn-sm xdbtn-delete">'+"删除"+'</button>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'+
										'<button type="button" class="btn btn-secondary btn-sm xdbtn-edit" data-toggle="modal" data-target="#exampleModalLong">'+"编辑"+'</button></td>'+'</tr>';	
									$("#movie-text").append(item);
								 });
				 
				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item" id="pre-page" value="'+info.prePage+'"><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>';
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item" id="next-page" value="'+info.nextPage+'"><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">下页</a></li>'; 
				 }
				 
				 $("#movie-pagination").empty();
				 $("#movie-pagination").append(prePage);
				 $("#movie-pagination").append(nowPage);
				 $("#movie-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 点击用户上一页
	 */
	$("#users-pagination").on('click', '#upre-page', function(){
		console.log("#upre-page");
		var page = $(this).attr("value");
		//console.log(page);
		var count = (page-1)*6;
		$.ajax({
			url : "showUsers?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#users-text").empty();
				 var info = JSON.parse(data);				 
				 var users = info.list;				 
				 $.each(users, function(key, value) { // 遍历json中的key和value
					 count += 1;
							var item = '<tr>'+
										'<th scope="row">'+count+'</th>'+
					 					'<td>'+value.uid+'</td>'+
					 					'<td>'+value.username+'</td>'+
					 					'<td>'+time(value.udate)+'</td>'+
					 					'<td><button type="button" class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>'+'';	
									$("#users-text").append(item);
								 });
				 
				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item" id="upre-page" value="'+info.prePage+'"><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>';
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item" id="unext-page" value="'+info.nextPage+'"><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">下页</a></li>'; 
				 }
				 
				 $("#users-pagination").empty();
				 $("#users-pagination").append(prePage);
				 $("#users-pagination").append(nowPage);
				 $("#users-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});

	/**
	 * 点击用户下一页
	 */
	$("#users-pagination").on('click', '#unext-page', function(){
		console.log("#unext-page");
		var page = $(this).attr("value");
		//console.log(page);
		var count = (page-1)*6;
		$.ajax({
			url : "showUsers?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#users-text").empty();
				 var info = JSON.parse(data);				 
				 var users = info.list;				 
				 $.each(users, function(key, value) { // 遍历json中的key和value
					 count += 1;
							var item = '<tr>'+
										'<th scope="row">'+count+'</th>'+
					 					'<td>'+value.uid+'</td>'+
					 					'<td>'+value.username+'</td>'+
					 					'<td>'+time(value.udate)+'</td>'+
					 					'<td><button type="button" class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>'+'';	
									$("#users-text").append(item);
								 });
				 
				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item" id="upre-page" value="'+info.prePage+'"><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>';
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item" id="unext-page" value="'+info.nextPage+'"><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">下页</a></li>'; 
				 }
				 
				 $("#users-pagination").empty();
				 $("#users-pagination").append(prePage);
				 $("#users-pagination").append(nowPage);
				 $("#users-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});

	/**
	 * 点击影评上一页
	 */
	$("#comments-pagination").on('click', '#cpre-page', function(){
		console.log("#cpre-page");
		var page = $(this).attr("value");
		//console.log(page);
		var count = (page-1)*6;
		$.ajax({
			url : "showComments?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comments-text").empty();
				 var info = JSON.parse(data);				 
				 var comments = info.list;				 
				 $.each(comments, function(key, value) { // 遍历json中的key和value
					 var ctitle = value.ctitle.substring(10);
					 var content = value.content.substring(0,20);
					 count += 1;
							var item = '<tr>'+
										'<th scope="row">'+count+'</th>'+
					 					'<td>'+value.mname+'</td>'+
					 					'<td>'+value.cid+'</td>'+
					 					'<td>'+value.username+'</td>'+
					 					'<td>'+ctitle+'</td>'+
					 					'<td>'+content+'</td>'+
					 					'<td>'+value.cscore+'</td>'+
					 					'<td>'+time(value.cdate)+'</td>'+
					 					'<td><button type="button" class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>'+'';	
									$("#comments-text").append(item);
								 });
				 
				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item" id="cpre-page" value="'+info.prePage+'"><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>';
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item" id="cnext-page" value="'+info.nextPage+'"><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">下页</a></li>'; 
				 }
				 
				 $("#comments-pagination").empty();
				 $("#comments-pagination").append(prePage);
				 $("#comments-pagination").append(nowPage);
				 $("#comments-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});

	/**
	 * 点击影评下一页
	 */
	$("#comments-pagination").on('click', '#cnext-page', function(){
		console.log("#cnext-page");
		var page = $(this).attr("value");
		//console.log(page);
		var count = (page-1)*6;
		$.ajax({
			url : "showComments?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#comments-text").empty();
				 var info = JSON.parse(data);				 
				 var comments = info.list;				 
				 $.each(comments, function(key, value) { // 遍历json中的key和value
					 var ctitle = value.ctitle.substring(10);
					 var content = value.content.substring(0,20);
					 count += 1;
							var item = '<tr>'+
										'<th scope="row">'+count+'</th>'+
					 					'<td>'+value.mname+'</td>'+
					 					'<td>'+value.cid+'</td>'+
					 					'<td>'+value.username+'</td>'+
					 					'<td>'+ctitle+'</td>'+
					 					'<td>'+content+'</td>'+
					 					'<td>'+value.cscore+'</td>'+
					 					'<td>'+time(value.cdate)+'</td>'+
					 					'<td><button type="button" class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>'+'';	
									$("#comments-text").append(item);
								 });
				 
				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item" id="cpre-page" value="'+info.prePage+'"><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>';
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item" id="cnext-page" value="'+info.nextPage+'"><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">下页</a></li>'; 
				 }
				 
				 $("#comments-pagination").empty();
				 $("#comments-pagination").append(prePage);
				 $("#comments-pagination").append(nowPage);
				 $("#comments-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});

	/**
	 * 点击 恶意影评上一页
	 */
	$("#badComments-pagination").on('click', '#badC-pre-page', function(){
		console.log("#badC-pre-page");
		var page = $(this).attr("value");
		console.log(page);
		var count = (page-1)*6;
		$.ajax({
			url : "showBadComments?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#badComment-text").empty();
				 var info = JSON.parse(data);				 
				 var badComments = info.list;				 
				 $.each(badComments, function(key, value) { // 遍历json中的key和value
					 var ctitle = value.ctitle.substring(10);
					 var content = value.content.substring(0,20);
					 count += 1;
							var item = '<tr>'+
										'<th scope="row">'+count+'</th>'+
					 					'<td>'+value.mname+'</td>'+
					 					'<td>'+value.cid+'</td>'+
					 					'<td>'+value.username+'</td>'+
					 					'<td>'+ctitle+'</td>'+
					 					'<td>'+content+'</td>'+
					 					'<td>'+value.cscore+'</td>'+
					 					'<td>'+time(value.cdate)+'</td>'+
					 					'<td><button type="button" class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>'+'';	
									$("#badComment-text").append(item);
								 });
				 
				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item" id="badC-pre-page" value="'+info.prePage+'"><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>';
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item" id="badC-next-page" value="'+info.nextPage+'"><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">下页</a></li>'; 
				 }
				 
				 $("#badComments-pagination").empty();
				 $("#badComments-pagination").append(prePage);
				 $("#badComments-pagination").append(nowPage);
				 $("#badComments-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});

	/**
	 * 点击 恶意影评下一页
	 */
	$("#badComments-pagination").on('click', '#badC-next-page', function(){
		console.log("#badC-next-page");
		var page = $(this).attr("value");
		//console.log(page);
		var count = (page-1)*6;
		$.ajax({
			url : "showBadComments?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#badComment-text").empty();
				 var info = JSON.parse(data);				 
				 var comments = info.list;				 
				 $.each(comments, function(key, value) { // 遍历json中的key和value
					 var ctitle = value.ctitle.substring(10);
					 var content = value.content.substring(0,20);
					 count += 1;
							var item = '<tr>'+
										'<th scope="row">'+count+'</th>'+
					 					'<td>'+value.mname+'</td>'+
					 					'<td>'+value.cid+'</td>'+
					 					'<td>'+value.username+'</td>'+
					 					'<td>'+ctitle+'</td>'+
					 					'<td>'+content+'</td>'+
					 					'<td>'+value.cscore+'</td>'+
					 					'<td>'+time(value.cdate)+'</td>'+
					 					'<td><button type="button" class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>'+'';	
									$("#badComment-text").append(item);
								 });
				 
				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item" id="badC-pre-page" value="'+info.prePage+'"><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>';
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item" id="badC-next-page" value="'+info.nextPage+'"><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">下页</a></li>'; 
				 }
				 
				 $("#badComments-pagination").empty();
				 $("#badComments-pagination").append(prePage);
				 $("#badComments-pagination").append(nowPage);
				 $("#badComments-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});

	/**
	 * 点击 回复评论上一页
	 */
	$("#replys-pagination").on('click', '#rpre-page', function(){
		console.log("#rpre-page");
		var page = $(this).attr("value");
		//console.log(page);
		var count = (page-1)*6;
		$.ajax({
			url : "showReplys?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#replys-text").empty();
				 var info = JSON.parse(data);				 
				 var comments = info.list;				 
				 $.each(comments, function(key, value) { // 遍历json中的key和value
					 var content = value.rcontent.substring(0,20);
					 count += 1;
							var item = '<tr>'+
										'<th scope="row">'+count+'</th>'+
					 					'<td>'+value.rid+'</td>'+
					 					'<td>'+value.cid+'</td>'+
					 					'<td>'+value.username+'</td>'+
					 					'<td>'+content+'</td>'+
					 					'<td>'+time(value.rdate)+'</td>'+
					 					'<td><button type="button" class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>'+'';	
									$("#replys-text").append(item);
								 });
				 
				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item" id="rpre-page" value="'+info.prePage+'"><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>';
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item" id="rnext-page" value="'+info.nextPage+'"><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">下页</a></li>'; 
				 }
				 
				 $("#replys-pagination").empty();
				 $("#replys-pagination").append(prePage);
				 $("#replys-pagination").append(nowPage);
				 $("#replys-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});

	/**
	 * 点击 回复评论下一页
	 */
	$("#replys-pagination").on('click', '#rnext-page', function(){
		console.log("#rnext-page");
		var page = $(this).attr("value");
		//console.log(page);
		var count = (page-1)*6;
		$.ajax({
			url : "showReplys?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#replys-text").empty();
				 var info = JSON.parse(data);				 
				 var comments = info.list;				 
				 $.each(comments, function(key, value) { // 遍历json中的key和value
					 var content = value.rcontent.substring(0,20);
					 count += 1;
							var item = '<tr>'+
										'<th scope="row">'+count+'</th>'+
					 					'<td>'+value.rid+'</td>'+
					 					'<td>'+value.cid+'</td>'+
					 					'<td>'+value.username+'</td>'+
					 					'<td>'+content+'</td>'+
					 					'<td>'+time(value.rdate)+'</td>'+
					 					'<td><button type="button" class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>'+'';	
									$("#replys-text").append(item);
								 });
				 
				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item" id="rpre-page" value="'+info.prePage+'"><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>';
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item" id="rnext-page" value="'+info.nextPage+'"><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">下页</a></li>'; 
				 }
				 
				 $("#replys-pagination").empty();
				 $("#replys-pagination").append(prePage);
				 $("#replys-pagination").append(nowPage);
				 $("#replys-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});

	/**
	 * 点击 恶意回复评论上一页
	 */
	$("#badReplys-pagination").on('click', '#badR-pre-page', function(){
		console.log("#badR-pre-page");
		var page = $(this).attr("value");
		//console.log(page);
		var count = (page-1)*6;
		$.ajax({
			url : "showBadComments?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#badReplys-text").empty();
				 var info = JSON.parse(data);				 
				 var comments = info.list;				 
				 $.each(comments, function(key, value) { // 遍历json中的key和value
					 var content = value.rcontent.substring(0,20);
					 count += 1;
							var item = '<tr>'+
										'<th scope="row">'+count+'</th>'+
					 					'<td>'+value.rid+'</td>'+
					 					'<td>'+value.cid+'</td>'+
					 					'<td>'+value.username+'</td>'+
					 					'<td>'+content+'</td>'+
					 					'<td>'+time(value.rdate)+'</td>'+
					 					'<td><button type="button" class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>'+'';	
									$("#badReplys-text").append(item);
								 });
				 
				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item" id="badR-pre-page" value="'+info.prePage+'"><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>';
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item" id="badR-next-page" value="'+info.nextPage+'"><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">下页</a></li>'; 
				 }
				 
				 $("#badReplys-pagination").empty();
				 $("#badReplys-pagination").append(prePage);
				 $("#badReplys-pagination").append(nowPage);
				 $("#badReplys-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});
	
	/**
	 * 点击 恶意回复评论下一页
	 */
	$("#badReplys-pagination").on('click', '#badR-next-page', function(){
		console.log("#badR-next-page");
		var page = $(this).attr("value");
		//console.log(page);
		var count = (page-1)*6;
		$.ajax({
			url : "showBadComments?page=" + page,
			type : "post",
			success : function(data) {
				// 找到item父节点 删除其子节点，然后追加新的子节点
				 $("#badReplys-text").empty();
				 var info = JSON.parse(data);				 
				 var comments = info.list;				 
				 $.each(comments, function(key, value) { // 遍历json中的key和value
					 var content = value.rcontent.substring(0,20);
					 count += 1;
							var item = '<tr>'+
										'<th scope="row">'+count+'</th>'+
					 					'<td>'+value.rid+'</td>'+
					 					'<td>'+value.cid+'</td>'+
					 					'<td>'+value.username+'</td>'+
					 					'<td>'+content+'</td>'+
					 					'<td>'+time(value.rdate)+'</td>'+
					 					'<td><button type="button" class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>'+'';	
									$("#badReplys-text").append(item);
								 });
				 
				 var prePage = "";
				 var nextPage = "";
		 
				 //修改页码
				 if(info.hasPreviousPage){
					 console.log('有前一页');
					 prePage = '<li class="page-item" id="badR-pre-page" value="'+info.prePage+'"><a class="page-link" href="#">上页</a></li>';
				 }else{
					 prePage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">上页</a></li>';
				 }
				 
				 var nowPage = '<li class="page-item"><a class="page-link" href="#">'+info.pageNum+'/'+info.pages+'</a></li>';
				 
				 if(info.hasNextPage){
					 nextPage = '<li class="page-item" id="badR-next-page" value="'+info.nextPage+'"><a class="page-link" href="#">下页</a></li>';
					 console.log('有后一页');
				 }else{
					 nextPage = '<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">下页</a></li>'; 
				 }
				 
				 $("#badReplys-pagination").empty();
				 $("#badReplys-pagination").append(prePage);
				 $("#badReplys-pagination").append(nowPage);
				 $("#badReplys-pagination").append(nextPage);
			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			} 
		});
	});
	

});

