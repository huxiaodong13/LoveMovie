package com.love.movie.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.love.movie.model.Attitude;
import com.love.movie.model.Comment;

public interface CustomedCommentMapper {

	/**
	 * 获取点赞数和时间排名最靠前的5个影评
	 *
	 */
	@Select(value = "select * from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid ORDER BY cdate,clike DESC limit 5")
	public List<Map<String, Object>> getLikeComment();

	/**
	 * 最受欢迎的影评
	 *
	 */
	@Select(value = "select * from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid ORDER BY clike DESC")
	public List<Map<String, Object>> getPopularComment();

	/**
	 * 热门影评
	 *
	 */
	@SelectProvider(method = "selectHotComment", type = com.love.movie.service.impl.SQL.class)
	public List<Map<String, Object>> getHotComment();

	/**
	 * 新片影评
	 *
	 */
	@Select(value = "select * from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid ORDER BY cdate")
	public List<Map<String, Object>> getNewComment();

	@Select(value = "select * from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid ORDER BY mscore DESC")
	public List<Map<String, Object>> getAllHotComment();

	@Select(value = "select * from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid ORDER BY cdate DESC")
	public List<Map<String, Object>> getAllNewComment();

	/**
	 * 搜索指定电影id的评论
	 * 
	 * @param mid
	 * @return
	 */
	@SelectProvider(method = "selectCommentByMid", type = com.love.movie.service.impl.SQL.class)
	public List<Map<String, Object>> selectCommentByMid(int mid);

	/**
	 * 根据cid获取影评
	 * 
	 * @param cid
	 * @return
	 */
	@SelectProvider(method = "selectCommentByCid", type = com.love.movie.service.impl.SQL.class)
	public Map<String, Object> selectCommentByCid(int cid);

	@Select(value = "select * from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid")
	public List<Map<String, Object>> getAllComment();

	/**
	 * 获取指定电影最受欢迎评论
	 * 
	 * @return
	 */
	@SelectProvider(method = "selectPopularCommentByMid", type = com.love.movie.service.impl.SQL.class)
	public List<Map<String, Object>> getPopularCommentByMid(int mid);

	/**
	 * 获取指定电影热门评论
	 * 
	 * @return
	 */
	@SelectProvider(method = "selectHotCommentByMid", type = com.love.movie.service.impl.SQL.class)
	public List<Map<String, Object>> getHotCommentByMid(int mid);

	/**
	 * 获取指定电影最新评论
	 * 
	 * @return
	 */
	@SelectProvider(method = "selectNewCommentByMid", type = com.love.movie.service.impl.SQL.class)
	public List<Map<String, Object>> getNewCommentByMid(int mid);

	/**
	 * 获取指定电影好友评论
	 * 
	 * @return
	 */
	@SelectProvider(method = "selectFriendCommentByMid", type = com.love.movie.service.impl.SQL.class)
	public List<Map<String, Object>> getFriendCommentByMid(Comment comment);

	/**
	 * 查询指定影评的回复数
	 * 
	 * @param cid
	 * @return
	 */
	@SelectProvider(method = "selectCommentReplyCountByCid", type = com.love.movie.service.impl.SQL.class)
	public int getCommentReplyCountByCid(int cid);

	// 管理员 所有影评 按时间处理
	@Select(value = "select * from movie,comment,user where user.uid = comment.uid and movie.mid = comment.mid ORDER BY cdate DESC")
	public List<Map<String, Object>> getMAllComment();
	
	/**
	 * 查询指定影评被收藏的次数
	 * 
	 * @param comment
	 * @return
	 */
	@SelectProvider(method = "selectCommentStroeCount", type = com.love.movie.service.impl.SQL.class)
	public Integer getCommentStroeCount(int cid);
	
	
	/**
	 * 获取用户对评论的态度
	 * 
	 * @param attitude
	 * @return
	 */
	@Select(value="select attitude.attitude from  attitude where uid=#{uid} and cid=#{cid}")
	public Integer getUserAttitudeToComment(Attitude attitude);
	
	/**
	 * 获取对指定影评的直接回复
	 * 
	 * @param cid
	 * @return
	 */
	@SelectProvider(method = "selectReplyToCommentByCid", type = com.love.movie.service.impl.SQL.class)
	public List<Map<String, Object>> getReplyToCommentByCid(int cid);
	

	
	
}
