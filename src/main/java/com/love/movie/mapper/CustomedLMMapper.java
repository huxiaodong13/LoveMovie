package com.love.movie.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface CustomedLMMapper {
	@Select(value = "select * from user")
	public List<Map<String, Object>> getAllUsers();
	
	
}
