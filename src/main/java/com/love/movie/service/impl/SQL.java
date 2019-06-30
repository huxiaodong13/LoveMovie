package com.love.movie.service.impl;

import com.love.movie.model.Comment;
import com.love.movie.model.Score;

public class SQL {

	/**
	 * 根据电影id 查询评论SQL
	 * 
	 * @param mid
	 * @return
	 */
	public String selectCommentByMid(int mid) {
		String sql = "select `cid`,`img`,`mname`,`mscore`,`ctitle`,`content`,`username`,`uimg`,`clike`,`cdislike`,`cscore` from `movie`,`comment`,`user` where user.uid = comment.uid and movie.mid = comment.mid and comment.mid =  "
				+ mid;
		return sql;
	}

	public String selectCommentByCid(int cid) {
		String sql = "select comment.cid, comment.uid , comment.mid,`ctitle`,`content`,`username`,`uimg`,`cdate`,`clike`,`cdislike`,`cscore` from `movie`,`comment`,`user` where user.uid = comment.uid and movie.mid = comment.mid and comment.cid =  "
				+ cid;
		return sql;
	}

	/**
	 * 得分等级1 SQL
	 * 
	 * @param mid
	 * @return
	 */
	public String selectMovieScoreLevel1Count(int mid) {
		String sql = "SELECT COUNT(*) FROM score WHERE score.sscore >= 0 AND score.sscore < 20 AND score.mid = " + mid;
		return sql;
	}

	/**
	 * 得分等级2 SQL
	 * 
	 * @param mid
	 * @return
	 */
	public String selectMovieScoreLevel2Count(int mid) {
		String sql = "SELECT COUNT(*) FROM score WHERE score.sscore >= 20 AND score.sscore < 40 AND score.mid = " + mid;
		return sql;
	}

	/**
	 * 得分等级3 SQL
	 * 
	 * @param mid
	 * @return
	 */
	public String selectMovieScoreLevel3Count(int mid) {
		String sql = "SELECT COUNT(*) FROM score WHERE score.sscore >= 40 AND score.sscore < 60 AND score.mid = " + mid;
		return sql;
	}

	/**
	 * 得分等级4 SQL
	 * 
	 * @param mid
	 * @return
	 */
	public String selectMovieScoreLevel4Count(int mid) {
		String sql = "SELECT COUNT(*) FROM score WHERE score.sscore >= 60 AND score.sscore < 80 AND score.mid = " + mid;
		return sql;
	}

	/**
	 * 得分等级5 SQL
	 * 
	 * @param mid
	 * @return
	 */
	public String selectMovieScoreLevel5Count(int mid) {
		String sql = "SELECT COUNT(*) FROM score WHERE score.sscore >= 80 AND score.sscore <= 100 AND score.mid = "
				+ mid;
		return sql;
	}

	/**
	 * 得分SQL
	 * 
	 * @param mid
	 * @param uid
	 * @return
	 */
	public String selectSScoreByMidAndUid(Score score) {
		String sql = "SELECT * FROM score WHERE score.uid = #{uid} AND score.mid = #{mid}";
		return sql;
	}

	/**
	 * 更新得分SQL
	 * 
	 * @param mid
	 * @param uid
	 * @return
	 */
	public String updateSScoreByMidAndUid(Score score) {
		String sql = "UPDATE `love_movie`.`score` SET `sscore` = #{sscore} WHERE `mid` =  #{mid} AND `uid` =  #{uid}";
		return sql;
	}
	
	/**
	 * 更新电影评分人数SQL
	 * 
	 * @param mid
	 * @return
	 */
	public String updateMovieCount(int mid) {
		String sql = "UPDATE movie SET movie.mcount = movie.mcount + 1 WHERE mid = " + mid;
		return sql;
	}
	
	/**
	 * 更新电影的的分数SQL
	 * 
	 * @param mid
	 * @return
	 */
	public String updateMovieScore(int mid) {
		String sql = "UPDATE movie SET movie.mscore = (SELECT FLOOR(AVG(sscore))/10 FROM score WHERE score.mid = "+mid+") WHERE movie.mid = " + mid;
		return sql;
	}
	
	/**
	 * 获取指定电影最受欢迎评论SQL
	 * 
	 * @param mid
	 * @return
	 */
	public String	selectPopularCommentByMid(int mid) {
		String sql = "SELECT * FROM comment, user WHERE comment.uid = user.uid AND comment.mid = "+mid+" ORDER BY comment.clike DESC";
		return sql;
	}
	
	/**
	 * 获取指定电影热门评论SQL
	 * 
	 * @param mid
	 * @return
	 */
	public String	selectHotCommentByMid(int mid) {
		String sql = "SELECT DISTINCT\r\n" + 
				"comment.uid, comment.mid, comment.content, comment.clike, comment.cdislike, comment.cdate, comment.ctitle,comment.cscore,comment.cid,\r\n" + 
				"count(*) replyCount\r\n" + 
				"FROM comment , reply WHERE comment.cid = reply.cid and reply.replytype = 0  AND mid = "+mid+"\r\n" + 
				"GROUP BY comment.cid\r\n" + 
				"ORDER BY replyCount DESC";
		return sql;
	}
	
	
	/**
	 * 获取所有热门评论SQL
	 * 
	 * @return
	 */
	public String selectHotComment() {
		String sql = "SELECT comment.uid as comuid\r\n" + 
				", `mid`, `content`, `cdate`, `clike`, comment.cid comcid,  `ctitle`, `cscore`, `cdislike`\r\n" + 
				",reply.cid as repcid,COUNT(*) replyCount \r\n" + 
				"FROM reply,comment\r\n" + 
				"WHERE reply.cid = comment.cid\r\n" + 
				"GROUP BY reply.cid \r\n" + 
				"ORDER BY replyCount DESC";
		
		return sql;
	}
	
	/**
	 * 获取指定电影最新评论SQL
	 * 
	 * @param mid
	 * @return
	 */
	public String	selectNewCommentByMid(int mid) {
		String sql = "SELECT * FROM comment, user WHERE comment.uid = user.uid AND comment.mid = "+ mid+" ORDER BY comment.cdate DESC";
		return sql;
	}
	
	/**
	 * 获取指定电影好友评论SQL
	 * 
	 * @param mid
	 * @return
	 */
	public String	selectFriendCommentByMid(Comment comment) {
		String sql = "SELECT * from comment  \r\n" + 
				"WHERE comment.uid in\r\n" + 
				"(SELECT followee.use_uid FROM followee WHERE followee.uid = #{uid}) \r\n" + 
				"AND comment.mid = #{mid}";
		return sql;
	}
	
	
	/**
	 * 查询指定影评的回复数SQL
	 * 
	 * @param cid
	 * @return
	 */
	public String selectCommentReplyCountByCid(int cid) {
		String sql = "SELECT COUNT(*) FROM reply WHERE reply.cid = " + cid;
		return sql;
	}
	
	/**
	 * 获取指定cid影评被收藏的次数
	 * 
	 * @param cid
	 * @return
	 */
	public String selectCommentStroeCount(int cid) {
		String sql = "SELECT COUNT(*) FROM storeup GROUP BY storeup.cid HAVING storeup.cid = " + cid;
		return sql;
	}
	
	
	/**
	 * 获取对指定影评的回复SQL
	 * 
	 * @param cid
	 * @return
	 */
	public String selectReplyToCommentByCid(int cid) {
		String sql = " SELECT `rid`, `cid`, `replyid`, `replytype`, `rcontent`, reply.uid, `touid`, `report`, `rdate`,  `username`,  `gender`,`uimg`\r\n" + 
				" FROM reply , user WHERE reply.uid = user.uid AND reply.cid = " + cid;
		return sql;
	}
	
	/**
	 * 根据关键词获取电影信息 SQL
	 * 
	 * @param keyword
	 * @return
	 */
	public String selectSearchResult(String keyword) {
		
		String sql="SELECT * FROM movie WHERE CONCAT(\r\n" + 
				"movie.mname, movie.mactor, movie.mwriter, movie.mtag, movie.mlanguage, movie.mdirect, movie.mcountry) REGEXP " + "'"+keyword+"'";
		
		return sql;
	}
	
}
