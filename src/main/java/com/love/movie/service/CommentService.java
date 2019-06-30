package com.love.movie.service;

import java.util.List;
import java.util.Map;

import com.love.movie.model.Attitude;
import com.love.movie.model.Comment;
import com.love.movie.model.Storeup;

public interface CommentService {

	public List<Map<String, Object>> getLikeComment();

	/**
	 * 获取所有最受欢迎的
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getPopularComment();

	/**
	 * 获取热门影评
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getHotComment();

	public List<Map<String, Object>> getAllHotComment();

	public List<Map<String, Object>> getNewComment();

	public List<Map<String, Object>> getAllNewComment();

	public List<Map<String, Object>> getCommentByMid(int mid);

	public Map<String, Object> getCommentByCid(int cid);

	public List<Map<String, Object>> getAllComment();

	public List<Map<String, Object>> getMAllComment();

	/**
	 * 获取指定mid的电影的最受欢迎的影评
	 * 
	 * @param mid
	 * @return
	 */
	public List<Map<String, Object>> getPopularCommentByMid(int mid);

	/**
	 * 获取指定mid的电影的热门的影评
	 * 
	 * @param mid
	 * @return
	 */
	public List<Map<String, Object>> getHotCommentByMid(int mid);

	/**
	 * 获取指定mid的电影的最新的影评
	 * 
	 * @param mid
	 * @return
	 */
	public List<Map<String, Object>> getNewCommentByMid(int mid);

	/**
	 * 获取指定mid的电影 指定用户的好友影评
	 * 
	 * @param mid
	 * @return
	 */
	public List<Map<String, Object>> getFriendCommentByMid(Comment comment);

	/**
	 * 获取指定评论的回复数
	 * 
	 * @param cid
	 * @return
	 */
	public int getCommentReplyCountByCid(int cid);
	
	
	/**
	 * 获取指定影评的收藏数
	 * 
	 * @param cid
	 * @return
	 */
	public Integer getCommentStroeCount(int cid);
	
	
	/**
	 * 获取用户对影评的态度
	 * 
	 * @param attitude
	 * @return
	 */
	public Integer getUserAttitudeToComment(Attitude attitude);
	
	/**
	 * 判断用户是否收藏过该评论
	 * 
	 * @param storeup
	 * @return
	 */
	public Boolean isStoreComment(int cid, int uid);
	
	
	/**
	 * 取消收藏评论
	 * 
	 * @param cid
	 * @param uid
	 * @return
	 */
	public Boolean cancelStoreComment(int cid, int uid);
	
	/**
	 * 收藏评论
	 * 
	 * @param cid
	 * @param uid
	 * @return
	 */
	public Boolean storeComment(int cid, int uid);
	
	
	/**
	 * 点赞评论
	 * 
	 * @param cid
	 * @param uid
	 * @return
	 */
	public Boolean doThumbUpComment(int cid, int uid);
	
	/**
	 * 取消点赞评论
	 * 
	 * @param cid
	 * @param uid
	 * @return
	 */
	public Boolean cancelThumbUpComment(int cid, int uid);
	
	/**
	 * 踩评论
	 * 
	 * @param cid
	 * @param uid
	 * @return
	 */
	public Boolean doThumDownComment(int cid, int uid);
	
	/**
	 * 取消踩评论
	 * 
	 * @param cid
	 * @param uid
	 * @return
	 */
	public Boolean cancelThumDownComment(int cid, int uid);
	
	/**
	 * 处理举报
	 * 
	 * @param reason
	 * @param cid
	 * @param uid
	 * @return
	 */
	public Boolean doReport(String reason, int cid, int uid);
	
	/**
	 * 处理回复
	 * 
	 * @param comment
	 * @param cid
	 * @param uid
	 * @return
	 */
	public boolean doAddReplyToComment(String comment, int cid, int uid, int toUid);
	
	/**
	 * 获取对指定影评的直接回复
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getReplyToCommentByCid(int cid);
	

}
