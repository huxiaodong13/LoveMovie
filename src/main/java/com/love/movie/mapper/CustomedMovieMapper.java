package com.love.movie.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.love.movie.model.Score;

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

	/**
	 * 获取评分0-2的人数
	 * 
	 * @param mid
	 * @return
	 */
	@SelectProvider(method = "selectMovieScoreLevel1Count", type = com.love.movie.service.impl.SQL.class)
	public Integer getMovieScoreLevel1Count(int mid);

	/**
	 * 获取评分2-4的人数
	 * 
	 * @param mid
	 * @return
	 */
	@SelectProvider(method = "selectMovieScoreLevel2Count", type = com.love.movie.service.impl.SQL.class)
	public Integer getMovieScoreLevel2Count(int mid);

	/**
	 * 获取评分4-6的人数
	 * 
	 * @param mid
	 * @return
	 */
	@SelectProvider(method = "selectMovieScoreLevel3Count", type = com.love.movie.service.impl.SQL.class)
	public Integer getMovieScoreLevel3Count(int mid);

	/**
	 * 获取评分6-8的人数
	 * 
	 * @param mid
	 * @return
	 */
	@SelectProvider(method = "selectMovieScoreLevel4Count", type = com.love.movie.service.impl.SQL.class)
	public Integer getMovieScoreLevel4Count(int mid);

	/**
	 * 获取评分8-10的人数
	 * 
	 * @param mid
	 * @return
	 */
	@SelectProvider(method = "selectMovieScoreLevel5Count", type = com.love.movie.service.impl.SQL.class)
	public Integer getMovieScoreLevel5Count(int mid);
	
	
	/**
	 * 根据mid和uid获取用户对某部电影的评分 （以此判断用户是否对某部电影进行过评分）
	 * 
	 * @param mid
	 * @param uid
	 * @return
	 */
	@SelectProvider(method = "selectSScoreByMidAndUid", type = com.love.movie.service.impl.SQL.class)
	public Score getScoreByMidAndUid(Score score);
	
	/**
	 * 根据mid和uid获取用户对某部电影的评分进行更新 
	 * 
	 * @param mid
	 * @param uid
	 * @return
	 */
	@SelectProvider(method = "updateSScoreByMidAndUid", type = com.love.movie.service.impl.SQL.class)
	public Integer modifyScoreByMidAndUid(Score score);
	
	
	/**
	 * 更新电影的评分人数
	 * 
	 * @param mid
	 */
	@SelectProvider(method = "updateMovieCount", type = com.love.movie.service.impl.SQL.class)
	public void addMovieCount(int mid);
	
	/**
	 * 更新指定电影的的分数
	 * 
	 * @param mid
	 */
	@SelectProvider(method = "updateMovieScore", type = com.love.movie.service.impl.SQL.class)
	public void modifyMovieScore(int mid);
	
	
}
