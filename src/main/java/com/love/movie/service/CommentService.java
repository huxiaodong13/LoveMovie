package com.love.movie.service;

import java.util.List;
import java.util.Map;

import com.love.movie.model.Comment;

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

}
