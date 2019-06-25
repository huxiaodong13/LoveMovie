$(function(){
	$('.dropdown-toggle').dropdown();
	$('.carousel').carousel();
	$('.badge').click(function () {
		if ($(this).attr('class') == 'badge badge-yellow') {
			$(this).addClass('badge-active');
			$(this).find('input').attr('checked','checked')
		}else{
			$(this).removeClass('badge-active');
		}
		$(this).parent().siblings().find('span').removeClass("badge-active");
		
	});


	$('.movie-item').mouseover(function () {
		$(this).find('.item-info-summary').show();
	});

	$('.movie-item').mouseleave(function () {
		$(this).find('.item-info-summary').hide();
	});

	$('.review-response .btn-outline-dark').mouseover(function () {
		if($(this).find('img').attr('src') == 'img/open-iconic-master/thumb-up-3x.png'){
			$(this).find('img').attr('src','img/open-iconic-master/thumb-up-white-3x.png')
		}
		if($(this).find('img').attr('src') == 'img/open-iconic-master/thumb-down-3x.png'){
			$(this).find('img').attr('src','img/open-iconic-master/thumb-down-white-3x.png')
		}
	});

	$('.review-response .btn-outline-dark').mouseleave(function () {
		if($(this).find('img').attr('src') == 'img/open-iconic-master/thumb-up-white-3x.png'){
			$(this).find('img').attr('src','img/open-iconic-master/thumb-up-3x.png')
		}
		if($(this).find('img').attr('src') == 'img/open-iconic-master/thumb-down-white-3x.png'){
			$(this).find('img').attr('src','img/open-iconic-master/thumb-down-3x.png')
		}
	});


	$('.review-comment').mouseover(function () {
		$(this).find('.comment_action').css('visibility','visible');
	});

	$('.review-comment').mouseleave(function () {
		$(this).find('.comment_action').css('visibility','hidden');
	});



	$(this).find('.comment_reply').mouseover(function () {
		$(this).find('.reply_action').css('visibility','visible');
	});

	$('.comment_reply').mouseleave(function () {
		$(this).find('.reply_action').css('visibility','hidden');
	});





	$('.response-btn').click(function () {
		
		$(this).parent().parent().find('.reply-editor').show();
		$(this).css('visibility','hidden');
	});
	$('.cancel-btn').click(function () {
		
		$(this).parents().find('.reply-editor').hide();
		$(this).parents().find('.response-btn').css('visibility','inherit');
	});


	$('.reply-btn').click(function () {
		if ($('.reply-editor input').val() == '') {
			alert("回复不能为空哦~");
			$('.reply-editor input').focus();
			
		}else{
			$(this).parents().find('.reply-editor').hide();
			$(this).parents().find('.response-btn').css('visibility','inherit');
		}
		
		
	});

	$('.add-comment-btn').click(function () {
		if ($('#comment-text').val() == '') {
			alert("回复不能为空哦~");
			$('#comment-text').focus();
			
		}	
	});



	//设置最大值
    ScrollBar.maxValue = 100;
    //初始化
    ScrollBar.Initialize();

	$('#myModal').modal();

	
	




});
var ScrollBar = {
    value: 0,
    maxValue: 100,
    step: 1,
    currentX: 0,
    Initialize: function () {
        if (this.value > this.maxValue) {
            alert("给定当前值大于了最大值");
            return;
        }
        this.GetValue();
        $("#scroll_Track").css("width", this.currentX + 2 + "px");
        $("#scroll_Thumb").css("margin-left", this.currentX + "px");
        this.Value();
        $("#scrollBarTxt").html(ScrollBar.value + "/" + ScrollBar.maxValue);
    },
    Value: function () {
        var valite = false;
        var currentValue;
       
        $("#scrollBar").mousedown(function () {
            valite = true;
            $(document).mousemove(function (e) {
                var event = e || window.event;
                
                if (valite == false) return;
                
                currentValue = event.clientX - $('#scrollBar').offset().left ;
                
                $("#scroll_Thumb").css("margin-left", currentValue + "px");
                $("#scroll_Track").css("width", currentValue + 2 + "px");
                //超出限制
                if ((currentValue + 25) >= $("#scrollBar").width()) {
                    $("#scroll_Thumb").css("margin-left", $("#scrollBar").width() - 25 + "px");
                    $("#scroll_Track").css("width", $("#scrollBar").width() + 2 + "px");
                    ScrollBar.value = ScrollBar.maxValue;
                } else if (currentValue <= 0) {
                    $("#scroll_Thumb").css("margin-left", "0px");
                    $("#scroll_Track").css("width", "0px");
                } else {
                    ScrollBar.value = parseInt(currentValue*100/ $("#scrollBar").width());
                }
                $("#scrollBarTxt").html(ScrollBar.value + "/" + ScrollBar.maxValue);
            });
        });
        $(document).mouseup(function () {
            
            $(this).unbind('mousedown');
            $(this).unbind('mousemove');
        });
    },
    GetValue: function () {
        this.currentX = $("#scrollBar").width() * (this.value / this.maxValue);
    }
}
	
