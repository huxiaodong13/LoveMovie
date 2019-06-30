<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>后台管理</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/manage.css">
<link rel="stylesheet" href="../css/style.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/manage.js"></script>
<script src="../js/xdscript.js"></script>
<script src="../js/jquery-ui.js"></script>

</head>
<body>
	<div id="header">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">想看电影</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">管理后台<span
							class="sr-only">(current)</span></a></li>
				</ul>

				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> ${user.username } </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="../index/logout">退出</a>
						</div></li>
				</ul>
			</div>
		</nav>
	</div>

	<!--表格-->
	<div id="content-display" class="clearfix">
		<div class="left-side">
			<div class="hr-manage"></div>
			<div class="left-manage font-center">
				<label class="user-manage">用户管理</label>
			</div>
			<div class="left-manage font-center ">
				<label class="moviecomment-manage">影评管理</label>
			</div>
			<div class="left-manage font-center ">
				<label class="comment-manage">评论管理</label>
			</div>
			<div class="left-manage font-center ">
				<label class="movie-manage">电影管理</label>
			</div>
			<div class="left-manage font-center ">
				<label class="badcomment-manage">恶意评论</label>
			</div>
			<div class="left-manage font-center ">
				<label class="badmoviecomment-manage">恶意影评</label>
			</div>
		</div>
		<div class="right-side-user right-side">
			<div class="font-center right-title">用户管理</div>
			<div id="users-items">
				<table class="table table-striped table-dark table-hover"
					id="userItems">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">用户id</th>
							<th scope="col">用户名</th>
							<th scope="col">注册时间</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody id="users-text">
						<c:forEach items="${usersPageInfo.list}" var="user" varStatus="k">
							<tr class="users">
								<th scope="row">${k.index+1 }</th>
								<td id="uid">${user.uid }</td>
								<td>${user.username }</td>
								<td>${user.udate }</td>
								<td><input type="button"
									class="btn btn-danger btn-sm xdbtn-delete" value="删除"></td>
								<!--  							<td><input type="button" class="btn btn-danger btn-sm" onclick="delUser(this)">删除</input></td>
 -->
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="page">
				<nav aria-label="" class="page">
					<ul class="pagination h-center v-center" id="users-pagination">
						<c:if test="${usersPageInfo.hasPreviousPage==true}">
							<li class="page-item" id="upre-page"><a class="page-link"
								href="#">上页</a></li>
						</c:if>

						<c:if test="${usersPageInfo.hasPreviousPage==false}">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">上页</a></li>
						</c:if>

						<li class="page-item"><a class="page-link" href="#">${usersPageInfo.pageNum}/${ usersPageInfo.pages}</a></li>

						<c:if test="${usersPageInfo.hasNextPage==true}">
							<li class="page-item" id="unext-page"
								value="${usersPageInfo.nextPage}"><a class="page-link"
								href="#">下页</a></li>

						</c:if>

						<c:if test="${usersPageInfo.hasNextPage==false}">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">下页</a></li>
						</c:if>


					</ul>
				</nav>
			</div>
		</div>
		<div class="right-side-moviecomment right-side" style="display: none">
			<div class="font-center right-title">影评管理</div>
			<div id="comments-items">
				<table class="table table-striped table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">电影名</th>
							<th scope="col">影评id</th>
							<th scope="col">用户</th>
							<th scope="col">影评标题</th>
							<th scope="col">影评内容</th>
							<th scope="col">评分</th>
							<th scope="col">评价时间</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody id="comments-text">
						<c:forEach items="${commentsPageInfo.list}" var="comment"
							varStatus="k">
							<tr>
								<th scope="row">${k.index+1 }</th>
								<td>${comment.mname }</td>
								<td>${comment.cid }</td>
								<td>${comment.username }</td>
								<td>${fn:substring(comment.ctitle, 0, 10)}</td>
								<td>${fn:substring(comment.content,0, 20)}...</td>
								<td>${comment.cscore }</td>
								<td>${comment.cdate }</td>
								<td><button type="button"
										class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="page">
				<nav aria-label="" class="page">
					<ul class="pagination h-center v-center" id="comments-pagination">
						<c:if test="${commentsPageInfo.hasPreviousPage==true}">
							<li class="page-item" id="cpre-page"><a class="page-link"
								href="#">上页</a></li>
						</c:if>

						<c:if test="${commentsPageInfo.hasPreviousPage==false}">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">上页</a></li>
						</c:if>

						<li class="page-item"><a class="page-link" href="#">${commentsPageInfo.pageNum}/${ commentsPageInfo.pages}</a></li>

						<c:if test="${commentsPageInfo.hasNextPage==true}">
							<li class="page-item" id="cnext-page"
								value="${commentsPageInfo.nextPage}"><a class="page-link"
								href="#">下页</a></li>

						</c:if>

						<c:if test="${commentsPageInfo.hasNextPage==false}">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">下页</a></li>
						</c:if>


					</ul>
				</nav>
			</div>
		</div>
		<div class="right-side-comment right-side" style="display: none">
			<div class="font-center right-title">评论管理</div>
			<div id="replys-items">
				<table class="table table-striped table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">评论id</th>
							<th scope="col">影评id</th>
							<th scope="col">评论用户</th>
							<th scope="col">评论内容</th>
							<th scope="col">评论时间</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody id="replys-text">
						<c:forEach items="${xReplyPageInfo.list}" var="reply"
							varStatus="k">
							<tr>
								<th scope="row">${k.index+1 }</th>
								<td>${reply.rid }</td>
								<td>${reply.cid }</td>
								<td>${reply.username }</td>
								<td>${fn:substring(reply.rcontent,0,20) }</td>
								<td>${reply.rdate }</td>
								<td><button type="button"
										class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="page">
				<nav aria-label="" class="page">
					<ul class="pagination h-center v-center" id="replys-pagination">
						<c:if test="${xReplyPageInfo.hasPreviousPage==true}">
							<li class="page-item" id="rpre-page"><a class="page-link"
								href="#">上页</a></li>
						</c:if>

						<c:if test="${xReplyPageInfo.hasPreviousPage==false}">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">上页</a></li>
						</c:if>

						<li class="page-item"><a class="page-link" href="#">${xReplyPageInfo.pageNum}/${ xReplyPageInfo.pages}</a></li>

						<c:if test="${xReplyPageInfo.hasNextPage==true}">
							<li class="page-item" id="rnext-page"
								value="${xReplyPageInfo.nextPage}"><a class="page-link"
								href="#">下页</a></li>

						</c:if>

						<c:if test="${xReplyPageInfo.hasNextPage==false}">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">下页</a></li>
						</c:if>


					</ul>
				</nav>
			</div>
		</div>
		<div class="right-side-movie right-side" style="display: none">
			<div class="font-center right-title">电影管理</div>
			<div id="movies-items">
				<table class="table table-striped table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">电影名</th>
							<th scope="col">电影id</th>
							<th scope="col">导演</th>
							<th scope="col">类型</th>
							<th scope="col">上映时间</th>
							<th scope="col"></th>
							<th scope="col"><button type="button"
									class="btn btn-success btn-sm" data-toggle="modal"
									data-target="#exampleModalLong-add">添加</button></th>
						</tr>
					</thead>
					<tbody id="movie-text">
						<c:forEach items="${moviesPageInfo.list}" var="movie"
							varStatus="k">
							<tr>
								<th scope="row">${k.index+1 }</th>
								<td id="mname">${movie.mname }</td>
								<td id="mid">${movie.mid }</td>
								<td id="mdirect">${movie.mdirect }</td>
								<td id="mtag">${movie.mtag }</td>
								<td><button type="button"
										class="btn btn-danger btn-sm xdbtn-delete">删除</button>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									<button type="button"
										class="btn btn-secondary btn-sm xdbtn-edit"
										data-toggle="modal" data-target="#exampleModalLong">编辑</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="page">
				<nav aria-label="" class="page">
					<ul class="pagination h-center v-center" id="movie-pagination">
						<c:if test="${moviesPageInfo.hasPreviousPage==true}">
							<li class="page-item" id="pre-page"><a class="page-link"
								href="#">上页</a></li>
						</c:if>

						<c:if test="${moviesPageInfo.hasPreviousPage==false}">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">上页</a></li>
						</c:if>

						<li class="page-item"><a class="page-link" href="#">${moviesPageInfo.pageNum}/${ moviesPageInfo.pages}</a></li>

						<c:if test="${moviesPageInfo.hasNextPage==true}">
							<li class="page-item" id="next-page"
								value="${moviesPageInfo.nextPage}"><a class="page-link"
								href="#">下页</a></li>

						</c:if>

						<c:if test="${moviesPageInfo.hasNextPage==false}">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">下页</a></li>
						</c:if>


					</ul>
				</nav>
			</div>
		</div>
		<div class="right-side-badcomment right-side" style="display: none">
			<div class="font-center right-title">恶意回复管理</div>
			<div id="badReplys-items">
				<table class="table table-striped table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">影评id</th>
							<th scope="col">评论id</th>
							<th scope="col">评论用户</th>
							<th scope="col">评论内容</th>
							<th scope="col">评论时间</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody id="badReplys-text">
						<c:forEach items="${badReplysPageInfo.list}" var="reply"
							varStatus="k">
							<tr>
								<th scope="row">${k.index+1 }</th>
								<td>${reply.rid }</td>
								<td>${reply.cid }</td>
								<td>${reply.username }</td>
								<td>${fn:substring(reply.rcontent,0,10) }</td>
								<td>${reply.rdate }</td>
								<td><button type="button"
										class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="page">
				<nav aria-label="" class="page">
					<ul class="pagination h-center v-center" id="badReplys-pagination">
						<c:if test="${badReplysPageInfo.hasPreviousPage==true}">
							<li class="page-item" id="badR-pre-page"><a
								class="page-link" href="#">上页</a></li>
						</c:if>

						<c:if test="${badReplysPageInfo.hasPreviousPage==false}">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">上页</a></li>
						</c:if>

						<li class="page-item"><a class="page-link" href="#">${badReplysPageInfo.pageNum}/${ badReplysPageInfo.pages}</a></li>

						<c:if test="${badReplysPageInfo.hasNextPage==true}">
							<li class="page-item" id="badR-next-page"
								value="${badReplysPageInfo.nextPage}"><a class="page-link"
								href="#">下页</a></li>

						</c:if>

						<c:if test="${xReplyPageInfo.hasNextPage==false}">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">下页</a></li>
						</c:if>


					</ul>
				</nav>
			</div>
		</div>
		<div class="right-side-badmoviecomment right-side"
			style="display: none">
			<div class="font-center right-title">恶意影评管理</div>
			<div id="badComments-items">
				<table class="table table-striped table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">电影名</th>
							<th scope="col">影评id</th>
							<th scope="col">用户</th>
							<th scope="col">影评标题</th>
							<th scope="col">影评内容</th>
							<th scope="col">评分</th>
							<th scope="col">评价时间</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody id="badComment-text">
						<c:forEach items="${badCommentsPageInfo.list}" var="badComment"
							varStatus="k">
							<tr>
								<th scope="row">${k.index+1 }</th>
								<td>${badComment.mname }</td>
								<td>${badComment.cid }</td>
								<td>${badComment.username }</td>
								<td>${fn:substring(badComment.ctitle, 0, 10)}</td>
								<td>${fn:substring(badComment.content, 0, 20) }</td>
								<td>${badComment.cscore }</td>
								<td>${badComment.cdate }</td>
								<td><button type="button"
										class="btn btn-danger btn-sm xdbtn-delete">删除</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="page">
				<nav aria-label="" class="page">
					<ul class="pagination h-center v-center"
						id="badComments-pagination">
						<c:if test="${badCommentsPageInfo.hasPreviousPage==true}">
							<li class="page-item" id="badC-pre-page"><a
								class="page-link" href="#">上页</a></li>
						</c:if>

						<c:if test="${badCommentsPageInfo.hasPreviousPage==false}">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">上页</a></li>
						</c:if>

						<li class="page-item"><a class="page-link" href="#">${badCommentsPageInfo.pageNum}/${ badCommentsPageInfo.pages}</a></li>

						<c:if test="${badCommentsPageInfo.hasNextPage==true}">
							<li class="page-item" id="badC-next-page"
								value="${badCommentsPageInfo.nextPage}"><a
								class="page-link" href="#">下页</a></li>

						</c:if>

						<c:if test="${badCommentsPageInfo.hasNextPage==false}">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">下页</a></li>
						</c:if>


					</ul>
				</nav>
			</div>
		</div>
	</div>

	<!--模态框 编辑电影信息-->
	<div class="modal fade" id="exampleModalLong" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">编辑电影信息</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="updateM" name="set-movie-message" method="POST">
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">电影id</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mid" id="umid"
									readonly>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">电影名字</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mname" id="umname">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">简介</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mbrief"
									id="umbrief">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">类型</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mtag" id="umtag">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">链接</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="murl" id="umurl">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">导演</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mdirect"
									id="umdirect">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">编剧</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mwriter"
									id="umwriter">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">主演</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mactor"
									id="umactor">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">制片国家</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mcountry"
									id="umcountry">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">语言</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mlanguage"
									id="umlanguage">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">上映日期</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mtime" id="umtime">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">时长</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mlong" id="umlong">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">别名</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="malias"
									id="umalias">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="doUpdate"
								data-dismiss="modal">提交</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">取消</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--模态框 添加电影-->
	<div class="modal fade" id="exampleModalLong-add" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">添加电影</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="insertM" name="set-movie-message" method="POST">
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">电影名字</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mname" id="tmname" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">简介</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mbrief"
									id="tmbrief">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">类型</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mtag" id="tmtag">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">链接</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="murl" id="tmurl">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">导演</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mdirect"
									id="tmdirect">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">编剧</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mwriter"
									id="tmwriter">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">主演</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mactor"
									id="tmactor">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">制片国家</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mcountry"
									id="tmcountry">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">语言</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mlanguage"
									id="tmlanguage">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">上映日期</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mtime" id="tmtime">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">时长</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="mlong" id="tmlong">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">别名</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="malias"
									id="tmalias">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" id="doInsert" class="btn btn-primary"
								data-dismiss="modal">提交</button>
							<button type="button" id="doReset" class="btn btn-secondary"
								data-dismiss="modal">取消</button>
						</div>
					</form>
					
				</div>
			</div>
		</div>
	</div>


	<div id="footer" class="manage-footer">
		<div class="my-hr">
			<div id="copyright" class="h-center v-center">
				<p>想看电影 &copy;第七小组： 夏靖雯 胡小东 胡新倩 王一凡 邓雯 王琴</p>
			</div>
		</div>
	</div>

</body>
</html>