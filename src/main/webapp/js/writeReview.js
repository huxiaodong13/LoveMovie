
$(document).ready(function() {
	$("#btn-subReview").click(function() {
		console.log("点击了我提交影评");
		var mid = $('#sm-title').attr('href').split('=')[1];
		console.log(mid);
		
		
		
		var content = CKEDITOR.instances.editor1.getData();
		var score = $('.score-bar').text().split('/')[0];
		var title = $(" input[ name='stitle'] ").val();
		
		console.log(score);
		
		var reviewData = {
				'cscore':score,
				'content':content,
				'mid':mid,
				'ctitle':title
				
		};
		
		console.log(reviewData);
		
		$.ajax({
			url : "submitReview?mid="+mid,
			type : "post",
			data : reviewData,
			success : function(data) {
				console.log(data);
				if(data == "1"){
					alert("评论成功");
					
					//-----------跳转到影评详情页-----------
					
					
				}else{
					alert("评论失败");
				}
			},
			error : function(errordata) {
				console.log(errordata);
			}
		});
		
	});

});