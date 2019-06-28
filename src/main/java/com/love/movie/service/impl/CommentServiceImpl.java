package com.love.movie.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.movie.mapper.CommentMapper;
import com.love.movie.mapper.CustomedCommentMapper;
import com.love.movie.model.Comment;
import com.love.movie.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CustomedCommentMapper customedCommentMapper;
	
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<Map<String, Object>> getLikeComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getLikeComment();
		return commentsList;
	}
	
	@Override
	public List<Map<String, Object>> getPopularComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getPopularComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getHotComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getHotComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getNewComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getNewComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getCommentByMid(int mid) {
		List<Map<String, Object>> commentsList = customedCommentMapper.selectCommentByMid(mid);
		return commentsList;
	}

	@Override
	public Map<String, Object> getCommentByCid(int cid) {
		Map<String, Object> comment = customedCommentMapper.selectCommentByCid(cid);
		return comment;
	}

	@Override
	public List<Map<String, Object>> getAllComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getAllComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getMAllComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getMAllComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getAllHotComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getAllHotComment();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getAllNewComment() {
		List<Map<String, Object>> commentsList = customedCommentMapper.getAllNewComment();
		return commentsList;
	}

	
	
	

	@Override
	public List<Map<String, Object>> getPopularCommentByMid(int mid) {	
		return customedCommentMapper.getPopularCommentByMid(mid);
	}

	@Override
	public List<Map<String, Object>> getHotCommentByMid(int mid) {
		return customedCommentMapper.getHotCommentByMid(mid);
	}

	@Override
	public List<Map<String, Object>> getNewCommentByMid(int mid) {
		return customedCommentMapper.getNewCommentByMid(mid);
	}

	@Override
	public List<Map<String, Object>> getFriendCommentByMid(Comment comment) {
		return customedCommentMapper.getFriendCommentByMid(comment);
	}

	@Override
	public int getCommentReplyCountByCid(int cid) {
		return customedCommentMapper.getCommentReplyCountByCid(cid);
	}

}
