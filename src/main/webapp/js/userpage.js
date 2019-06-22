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
        console.log($("#set-image").val());
        $(".edit-message-wrap").hide();
        $(".userpage-wrap").show();
    });
    $("#edit-cancelbtn").click(function(){
        $(".edit-message-wrap").hide();
        $(".userpage-wrap").show();
    });
    $("#edit-btn").click(function(){
        $(".edit-message-wrap").show();
        $(".userpage-wrap").hide();
    });

})