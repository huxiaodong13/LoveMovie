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
	@SelectProvider(method="selectHotMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getHotMovies();
	
	/**
	 * 查询最新电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectNewMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getNewMovies();
	

	/**
	 * 查询经典电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectClassicMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getClassicMovies();
	
	/**
	 * 查询可播放电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectPalyableMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getPalyableMovies();
	
	/**
	 * 查询高分放电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectHighScoreMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getHighScoreMovies();	

	/**
	 * 查询冷门电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectDarkHorseMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getDarkHorseMovies();	
	
	/**
	 * 查询华语电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectChineseMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getChineseMovies();
	
	/**
	 * 查询韩国电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectKoreanMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getKoreanMovies();
	
	/**
	 * 查询欧美电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectEuropeanAndAmericanMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getEuropeanAndAmericanMovies();
	
	/**
	 * 查询日本电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectJapaneseMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getJapaneseMovies();
	
	/**
	 * 查询动作电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectActionMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getActionMovies();
	
	/**
	 * 查询喜剧电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectComedyMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getComedyMovies();
	
	/**
	 * 查询爱情电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectLoveMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getLoveMovies();
	
	/**
	 * 查询科幻电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectScienceFictionMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getScienceFictionMovies();
	
	/**
	 * 查询动画电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectCartoonMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getCartoonMovies();
	
	/**
	 * 查询悬疑电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectSuspenseMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getSuspenseMovies();
	
	/**
	 * 查询惊悚电影
	 * 
	 * @return
	 */
	@SelectProvider(method="selectHorribleMovies", type=com.love.movie.sql.SakuraMovieSQL.class)
	public List<Map<String, Object>> getHorribleMovies();
	
	
	
	
	
}
