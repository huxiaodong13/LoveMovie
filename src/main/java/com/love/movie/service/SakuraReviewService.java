package com.love.movie.service;

import com.love.movie.model.Comment;

public interface SakuraReviewService {
	
	/**
	 * 添加评论
	 * 
	 * @param comment
	 * @return
	 */
	public boolean addComment(Comment comment);
	
	
}
