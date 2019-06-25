
$(document).ready(function() {
	$("#click-btn").click(function() {
		console.log("点击了我");
		var info = {
			"name" : "sakuara"
		};
		$.ajax({
			url : "showPerson",
			type : "post",
			data : info,
			success : function(data) {

				console.log(data);

			},
			error : function(errordata) {
				console.log(errordata);
				console.log(errordata);
			}
		});
	});

});