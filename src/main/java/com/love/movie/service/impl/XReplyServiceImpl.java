package com.love.movie.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.movie.mapper.ReplyMapper;
import com.love.movie.mapper.XCustomedReplyMapper;
import com.love.movie.service.XReplyService;

@Service("xReplyService")
public class XReplyServiceImpl implements XReplyService {

	@Autowired
	private XCustomedReplyMapper xcustomedReplyMapper;
	@Autowired
	private ReplyMapper replyMapper;
	@Override
	public List<Map<String, Object>> getMAllReply() {
		List<Map<String, Object>>  commentsList = xcustomedReplyMapper.getMAllReply();
		return commentsList;
	}

	@Override
	public List<Map<String, Object>> getMBadAllReply() {
		List<Map<String, Object>>  commentsList = xcustomedReplyMapper.getMBadAllReply();
		return commentsList;
	}

	@Override
	public Boolean delReply(int rid) {
		int n = replyMapper.deleteByPrimaryKey(rid);
		if(n>=1) {
			return true;
		}
		return false;
		
	}

	@Override
	public Boolean delReplyByCid(int rid) {
		int n = xcustomedReplyMapper.delReplyByCid(rid);
		if(n>=1) {
			return true;
		}
		return false;
	}

}
