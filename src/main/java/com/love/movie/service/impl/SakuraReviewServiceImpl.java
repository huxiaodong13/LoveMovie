package com.love.movie.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.movie.mapper.CommentMapper;
import com.love.movie.model.Comment;
import com.love.movie.service.SakuraReviewService;


@Service("SakuraReviewServiceId")
public class SakuraReviewServiceImpl implements SakuraReviewService{

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public boolean addComment(Comment comment) {
		int n = commentMapper.insert(comment);
		if(n>=1) {
			return true;
		}
		return false;
	}

}
