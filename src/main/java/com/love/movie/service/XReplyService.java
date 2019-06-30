package com.love.movie.service;

import java.util.List;
import java.util.Map;

public interface XReplyService {

	//管理员 获取所有回复
	public List<Map<String, Object>> getMAllReply();
	
	//管理员 获取 所有恶意回复
	public List<Map<String, Object>> getMBadAllReply();
	
	//删除恶意回复
	public Boolean delReply(int rid);
	
	//删除回复 通过cid
	public Boolean delReplyByCid(int rid);
}
