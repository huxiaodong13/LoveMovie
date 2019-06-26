package com.love.movie.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface CustomedMovieMapper {
	
	
	/**
	 * *所有电影
	 */
	@Select(value = "select * from movie")
	public List<Map<String, Object>> getAllMovie();
	
	/**
	 * *最新时间的电影
	 */
	@Select(value = "select * from movie ORDER BY mtime DESC limit 9")
	public List<Map<String, Object>> getNewDateMovie();
	@Select(value = "select * from movie ORDER BY mtime DESC")
	public List<Map<String, Object>> getAllNewDateMovie();
	
	
	/**
	 * *经典电影(评分高且是老电影)
	 */
	@Select(value = "select * from movie where mtime < '2019' ORDER BY mscore DESC limit 9")
	public List<Map<String, Object>> getClassicsMovie();
	
	
	/**
	 * *高分电影
	 */
	@Select(value = "select * from movie ORDER BY mscore DESC limit 9")
	public List<Map<String, Object>> getScoreMovie();
	
	/**
	 * *冷门电影
	 */
	@Select(value = "select * from movie ORDER BY mcount DESC limit 9")
	public List<Map<String, Object>> getColdMovie();

	/**
	 * *热门电影(评分高且点赞数多)
	 */
	@Select(value = "select * from movie ORDER BY mscore,mcount DESC limit 9")
	public List<Map<String, Object>> getHotMovie();


	/**
	 * *管理员 管理所有电影
	 */
	@Select(value = "select * from movie ORDER BY mtime DESC")
	public List<Map<String, Object>> getMAllMovie();

}
