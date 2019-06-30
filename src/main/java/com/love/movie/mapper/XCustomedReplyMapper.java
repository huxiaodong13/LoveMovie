package com.love.movie.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface XCustomedReplyMapper {

	//所有回复
	@Select(value = "select * from reply,user where user.uid = reply.uid ORDER BY rdate DESC")
	public List<Map<String, Object>> getMAllReply();

	// 被举报回复
	@Select(value = "select * from reply,user where user.uid = reply.uid and report=1 ORDER BY rdate DESC")
	public List<Map<String, Object>> getMBadAllReply();

	//通过查找 影评id 删除回复评论
//	@Select(value = "delete from reply ,user where user.uid = reply.uid and report=1 ORDER BY rdate DESC")
//	public List<Map<String, Object>> delReplyBymid();

	//通过 cid删除评论
	@SelectProvider(method = "delReplyByCid", type=com.love.movie.service.impl.SQL.class)
	public int delReplyByCid(int cid);

}
