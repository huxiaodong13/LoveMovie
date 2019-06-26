package com.love.movie.service;

import java.util.List;
import java.util.Map;

import com.love.movie.model.Movie;

public interface SakuraMovieService {
	
	
	/**
	 * 根据mid获取电影信息
	 * 
	 * @param mid
	 * @return
	 */
	public Movie getMovieByMid(int mid);
	
	/**
	 * 获取热门电影 （影评数多的）
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getHotMovies();
	
	
	/**
	 * 获取最新的电影 （上映时间较近的）
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getNewMovies();
	
	
	/**
	 * 获取经典电影（上映时间较长 评分高）
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getClassicMovies();
	
	
	/**
	 * 获取可播放电影
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getPalyableMovies();
	
	/**
	 * 获取高分系列电影
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getHighScoreMovies();
	
	/**
	 * 获取冷门佳片 （评分高影评少）
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getDarkHorseMovies();
	
	/**
	 * 获取华语电影
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getChineseMovies();
	
	/**
	 * 获取韩国电影
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getKoreanMovies();
	
	
	/**
	 * 获取欧美电影
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getEuropeanAndAmericanMovies();
	
	
	/**
	 * 获取日本电影
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getJapaneseMovies();
	
	
	/**
	 * 获取动作片
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getActionMovies();
	
	/**
	 * 获取喜剧电影
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getComedyMovies();
	
	/**
	 * 获取爱情电影
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getLoveMovies();
	
	/**
	 * 获取科幻电影
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getScienceFictionMovies();
	
	/**
	 * 获取动画电影
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getCartoonMovies();
	
	/**
	 *获取悬电影
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getSuspenseMovies();
	
	/**
	 * 获取恐怖电影
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getHorribleMovies();
	
	
	
	
}
