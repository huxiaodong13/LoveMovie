package com.love.movie.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.love.movie.model.Comment;

public interface CustomedCommentMapper {
	
	/**
	 * *获取点赞数和时间排名最靠前的5个影评
	 *
	 */
	@Select(value = "select cid,img,mname,mscore,ctitle,content,username,cscore,cdate from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid ORDER BY cdate,clike DESC limit 5")
	public List<Map<String, Object>> getLikeComment();

	/**
	 * * 最受欢迎的影评
	 *
	 */
	@Select(value = "select cid,img,mname,mscore,ctitle,content,username,clike,cdislike,cscore,cdate from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid ORDER BY clike DESC limit 5")
	public List<Map<String, Object>> getTopLikeComment();

	/**
	 * *热门影评
	 *
	 */
	@Select(value = "select cid,img,mname,mscore,ctitle,content,username,uimg,clike,cdislike,cscore,cdate from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid ORDER BY mscore,clike DESC limit 5")
	public List<Map<String, Object>> getHotComment();

	@Select(value = "select cid,img,mname,mscore,ctitle,content,username,uimg,clike,cdislike,cscore,cdate from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid ORDER BY mscore DESC")
	public List<Map<String, Object>> getAllHotComment();

	/**
	 * *新片影评
	 *
	 */
	@Select(value = "select cid,img,mname,mscore,ctitle,content,username,uimg,clike,cdislike,cscore,cdate from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid ORDER BY cdate DESC limit 5")
	public List<Map<String, Object>> getNewComment();

	@Select(value = "select cid,img,mname,mscore,ctitle,content,username,uimg,clike,cdislike,cscore,cdate from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid ORDER BY cdate DESC")
	public List<Map<String, Object>> getAllNewComment();

	/**
	 * *指定电影号的影评
	 *
	 */
	@SelectProvider(method="selectCommentByMid", type=com.love.movie.service.impl.SQL.class)
	public List<Map<String, Object>> selectCommentByMid(int mid);
	
	@SelectProvider(method = "selectCommentByCid", type=com.love.movie.service.impl.SQL.class)
	public Map<String, Object> selectCommentByCid(int cid);

	@Select(value = "select cid,img,mname,mscore,ctitle,content,username,uimg,clike,cdislike,cscore,cdate from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid")
	public List<Map<String, Object>> getAllComment();

	//管理员 所有影评 按时间处理
	@Select(value = "select cid,mname,ctitle,content,cdate,username,report,cscore,cdate from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid ORDER BY cdate DESC")
	public List<Map<String, Object>> getMAllComment();

	
}
