package com.love.movie.sql;

public class SakuraMovieSQL {
	/**
	 * 热门电影SQL
	 * 
	 * @return
	 */
	public String selectHotMovies() {
		String sql = "SELECT * FROM movie ORDER BY mcount DESC";
		return sql;
	}
	
	/**
	 * 最新电影SQL
	 * 
	 * @return
	 */
	public String selectNewMovies() {
		String sql = "SELECT * FROM movie ORDER BY mtime DESC";
		return sql;
	}
	
	/**
	 * 经典电影SQL
	 * 
	 * @return
	 */
	public String selectClassicMovies() {
		String sql = "SELECT * FROM movie WHERE mscore > 8 ORDER  BY mtime,mscore ASC";
		return sql;
	}	
	
	/**
	 * 可播放电影SQL
	 * 
	 * @return
	 */
	public String selectPalyableMovies() {
		String sql = "SELECT * FROM movie";
		return sql;
	}
	
	/**
	 * 高分电影SQL
	 * 
	 * @return
	 */
	public String selectHighScoreMovies() {
		String sql = "SELECT * FROM movie ORDER BY mscore DESC";
		return sql;
	}
	
	/**
	 * 冷门电影SQL
	 * 
	 * @return
	 */
	public String selectDarkHorseMovies() {
		String sql = "SELECT * FROM movie WHERE mcount < 5000 and mscore > 7 ORDER BY mscore DESC";
		return sql;
	}
	
	/**
	 * 华语电影SQL
	 * 
	 * @return
	 */
	public String selectChineseMovies() {
		String sql = "SELECT * FROM movie WHERE movie.mcountry REGEXP '中国大陆'";
		return sql;
	}
	
	/**
	 * 韩语电影SQL
	 * 
	 * @return
	 */
	public String selectKoreanMovies() {
		String sql = "SELECT * FROM movie WHERE movie.mcountry REGEXP '韩国'";
		return sql;
	}
	
	/**
	 * 欧美电影SQL
	 * 
	 * @return
	 */
	public String selectEuropeanAndAmericanMovies() {
		String sql = "SELECT * FROM movie WHERE movie.mcountry REGEXP '美国|英国'";
		return sql;
	}
	
	/**
	 * 日本电影SQL
	 * 
	 * @return
	 */
	public String selectJapaneseMovies() {
		String sql = "SELECT * FROM movie WHERE movie.mcountry REGEXP '日本'";
		return sql;
	}
	
	/**
	 * 动作电影SQL
	 * 
	 * @return
	 */
	public String selectActionMovies() {
		String sql = "SELECT * FROM movie WHERE movie.mtag REGEXP '动作'";
		return sql;
	}
	
	/**
	 * 喜剧电影SQL
	 * 
	 * @return
	 */
	public String selectComedyMovies() {
		String sql = "SELECT * FROM movie WHERE movie.mtag REGEXP '喜剧'";
		return sql;
	}
	
	/**
	 * 爱情电影SQL
	 * 
	 * @return
	 */
	public String selectLoveMovies() {
		String sql = "SELECT * FROM movie WHERE movie.mtag REGEXP '爱情'";
		return sql;
	}
	
	/**
	 * 科幻电影SQL
	 * 
	 * @return
	 */
	public String selectScienceFictionMovies() {
		String sql = "SELECT * FROM movie WHERE movie.mtag REGEXP '科幻'";
		return sql;
	}
	
	/**
	 * 动画电影SQL
	 * 
	 * @return
	 */
	public String selectCartoonMovies() {
		String sql = "SELECT * FROM movie WHERE movie.mtag REGEXP '动画'";
		return sql;
	}
	
	/**
	 * 悬疑电影SQL
	 * 
	 * @return
	 */
	public String selectSuspenseMovies() {
		String sql = "SELECT * FROM movie WHERE movie.mtag REGEXP '悬疑'";
		return sql;
	}
	
	/**
	 * 惊悚电影SQL
	 * 
	 * @return
	 */
	public String selectHorribleMovies() {
		String sql = "SELECT * FROM movie WHERE movie.mtag REGEXP '惊悚'";
		return sql;
	}
	
}
