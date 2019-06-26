package com.love.movie.service;

import java.util.List;
import java.util.Map;

import com.love.movie.model.Comment;


public interface CommentService {

	/**
	  *  获取点赞数排名靠前的
	 *
	 */
	public List<Map<String, Object>> getLikeComment();
	
	public List<Map<String, Object>> getTopLikeComment();

	public List<Map<String, Object>> getHotComment();
	public List<Map<String, Object>> getAllHotComment();
	
	public List<Map<String, Object>> getNewComment();
	public List<Map<String, Object>> getAllNewComment();
	
	public List<Map<String, Object>> getCommentByMid(int mid);

	public Map<String, Object> getCommentByCid(int cid);
	
	public List<Map<String, Object>> getAllComment();
	
	public List<Map<String, Object>> getMAllComment();

}
