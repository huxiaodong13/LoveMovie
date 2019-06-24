$(document).ready(function(){
    $(".edit-introduce").click(function(){
        $("#self-introduce-text").hide();
        $("#self-introduce-edit").show();
    });
    $("#btn-brief-save").click(function(){
        $("#self-introduce-text").text("----"+$('#edit-concent').val());
        $("#self-introduce-edit").hide()
        $("#self-introduce-text").show();
    });
    $("#btn-brief-cancel").click(function(){
        $("#self-introduce-edit").hide()
        $("#self-introduce-text").show();
    });
    $('#datetimepicker1').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn'),
    });
    $('#datetimepicker2').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn'),
    });
    
    //提交修改数据
    $("#edit-savebtn").click(function(){
        console.log($("#set-form").serialize());
    });
    
    
    $("#edit-cancelbtn").click(function(){
        $(".edit-message-wrap").hide();
        $(".userpage-wrap").show();
    });
    
    $("#edit-btn").click(function(){
        $(".edit-message-wrap").show();
        $(".userpage-wrap").hide();
    });
    
    //点击模块显示不同的界面 想看的电影模块、看过的电影模块、参与的评论模块
    $(".block-saw").click(function(){
        $(".saw").show();
        $(".plan").hide();
        $("#comments-content").hide();
    });
    
    
    $(".block-plan").click(function(){
    	console.log("pannnnn");
        $(".saw").hide();
        $(".plan").show();
        $("#comments-content").hide();
    });
    $(".block-comment").click(function(){
        $(".saw").hide();
        $(".plan").hide();
        $("#comments-content").show();
    });

})