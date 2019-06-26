<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>电影详情页面</title>
	
</head>
<body>
	写影评人的名字== ${comment.username }<br>
	写影评人的头像== ${comment.uimg }<br>
	评论的电影名== ${mname }<br>
	评论的时间== ${comment.cdate }<br>
	影评的标题== ${comment.ctitle }<br>
	影评具体内容== ${comment.content }<br>
	点击有用的数量== ${comment.clike }<br>
	点击没有用的数量== ${comment.cdislike }<br>
	<p>
	
	回复写影评人的名字 == <br>
	回复人的头像 == <br>
	回复的内容 == <br>
	点击有用的数量== <br>
	点击没用的数量== <br>
</body>
</html>