package com.love.movie.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

//定制关于电影的查询
public interface CustomedSakuraMovieMapper {
	
	
	/**
	 * 查询热门电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectHotMovies", type=com.love.movie.sql.SakuraUserSQL.class)
	public List<Map<String, Object>> getHotMovies();
	
	
	
	
	
}
