package com.love.movie.service;

import java.util.List;
import java.util.Map;

import com.love.movie.model.Movie;

/**
 * @author DELL-DSD
 *
 */
public interface MovieService {

	/**
	 * *获取所有电影信息
	 *
	 */
	public List<Map<String, Object>> getAllMovie();
	
	/**
	 * *根据编号获取电影信息
	 *
	 */
	public Movie getMovieById(int mid);
	
	/**
	 * *获取最新上映 的前九个电影信息
	 *
	 */
	public List<Map<String, Object>> getTopNewDateMovie();
	
	/**
	 * * 获取经典的电影信息
	 *
	 */
	public List<Map<String, Object>> getTopClassicsMovie();
	
	
	/**
	 * *冷门
	 */
	public List<Map<String, Object>> getColdMovie();
	
	public List<Map<String, Object>> getScoreMovie();
	
	public List<Map<String, Object>> getHotMovie();


	//管理员获取所有电影
	public List<Map<String, Object>> getMAllMovie();
	
	//管理员修改电影信息
	public boolean updateMovie(Movie movie);
	
	//下架(删除电影)
	public boolean delMovieByMid(int mid);
	
	//上架(插入电影)
	public boolean insertMovie(Movie movie);
	
	public List<Map<String, Object>> getAllNewDateMovie();

	
}
