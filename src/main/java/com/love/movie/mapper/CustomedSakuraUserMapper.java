package com.love.movie.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

//定制关于用户的查询
public interface CustomedSakuraUserMapper {
	
	/**
	 * 用户想看的电影
	 * 
	 * @param uid
	 * @return
	 */
	@SelectProvider(method="selectUserSeenMovies", type=com.love.movie.sql.SakuraUserSQL.class)
	public List<Map<String, Object>> getUserSeenMovies(int uid);
	
	
	/**
	 * 用户看过的电影
	 * 
	 * @param uid
	 * @return
	 */
	@SelectProvider(method="selectUserWSeenMovies", type=com.love.movie.sql.SakuraUserSQL.class)
	public List<Map<String, Object>> getUserWSeenMovies(int uid);
	
	
	
	/**
	 * 用户参与的影评
	 * 
	 * @param uid
	 * @return
	 */
	@SelectProvider(method="selectUserComments", type=com.love.movie.sql.SakuraUserSQL.class)
	public List<Map<String, Object>> getUserComments(int uid);
	
	
	
}
