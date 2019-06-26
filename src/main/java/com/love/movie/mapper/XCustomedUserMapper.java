package com.love.movie.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface XCustomedUserMapper {

	//管理员 所有用户 按时间处理
		@Select(value = "select * from user ORDER BY udate DESC")
		public List<Map<String, Object>> getMAllUser();

}
