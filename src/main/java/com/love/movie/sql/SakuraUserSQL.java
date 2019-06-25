package com.love.movie.sql;

public class SakuraUserSQL {
	
	/**
	 * 返回用户看过的电影
	 * 
	 * @param uid
	 * @return
	 */
	public String selectUserSeenMovies(int uid) {
		String sql = "SELECT * FROM seenmovie, movie WHERE seenmovie.uid = "+uid+" and seenmovie.mid = movie.mid ";
		return sql;
	}
	
	/**
	 * 用户想看的电影
	 * 
	 * @param uid
	 * @return
	 */
	public String selectUserWSeenMovies(int uid) {
		String sql = "SELECT * FROM wseemovie, movie WHERE wseemovie.uid = "+uid+" and wseemovie.mid = movie.mid ";
		return sql;
	}
	
	/**
	 * 用户的评论
	 * 
	 * @param uid
	 * @return
	 */
	public String selectUserComments(int uid) {
		String sql = "SELECT * FROM comment, movie WHERE comment.mid = movie.mid and comment.uid = " + uid;
		return sql;
	}
	
	
	/**
	 * 热门电影
	 * 
	 * @return
	 */
	public String selectHotMovies() {
		String sql = "SELECT * FROM movie ORDER BY mcount DESC";
		return sql;
	}
}
