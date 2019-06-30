package com.love.movie.service;

import java.util.List;
import java.util.Map;

import com.love.movie.model.Movie;
import com.love.movie.model.Score;

/**
 * @author DELL-DSD
 *
 */
public interface MovieService {

	/**
	 * 获取所有电影信息
	 *
	 */
	public List<Map<String, Object>> getAllMovie();
	
	/**
	 * 根据编号获取电影信息
	 *
	 */
	public Movie getMovieById(int mid);
	
	/**
	 * 获取最新上映 的前九个电影信息
	 *
	 */
	public List<Map<String, Object>> getTopNewDateMovie();
	
	/**
	 * 获取经典的电影信息
	 *
	 */
	public List<Map<String, Object>> getTopClassicsMovie();
	
	
	/**
	 * 冷门
	 */
	public List<Map<String, Object>> getColdMovie();
	
	public List<Map<String, Object>> getScoreMovie();
	
	public List<Map<String, Object>> getHotMovie();

	
	/**
	 * 获取指定电影评分每个阶段的人数
	 * 
	 * @return
	 */
	public List<Integer> getMovieScoreLevel(int mid);
	
	
	/**
	 * 更新用户对某部电影的得分
	 * 
	 * @param comment
	 * @return
	 */
	public boolean  modifyUserMovieScore(Score score);
	
	
	public List<Map<String, Object>> getAllNewDateMovie();
	
	
	/**
	 * 根据关键词获取电影
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Map<String, Object>> getSearchResult(String keyword);

	
}
