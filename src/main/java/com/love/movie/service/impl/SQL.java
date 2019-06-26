package com.love.movie.service.impl;

public class SQL {
	public String selectCommentByMid(int mid) {
		String sql = "select `cid`,`img`,`mname`,`mscore`,`ctitle`,`content`,`username`,`uimg`,`clike`,`cdislike`,`cscore` from `movie`,`comment`,`user` where user.uid = comment.uid and movie.mid = comment.mid and comment.mid =  " + mid; 
		return sql;
	}
	
	public String selectCommentByCid(int cid) {
		String sql = "select comment.mid,`ctitle`,`content`,`username`,`uimg`,`cdate`,`clike`,`cdislike`,`cscore` from `movie`,`comment`,`user` where user.uid = comment.uid and movie.mid = comment.mid and comment.cid =  " + cid; 
		return sql;
	}
}
