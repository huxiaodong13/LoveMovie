package com.love.movie.model;

public class Score {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column score.sid
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	private Integer sid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column score.mid
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	private Integer mid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column score.uid
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	private Integer uid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column score.sscore
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	private Integer sscore;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column score.sid
	 * @return  the value of score.sid
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public Integer getSid() {
		return sid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column score.sid
	 * @param sid  the value for score.sid
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public void setSid(Integer sid) {
		this.sid = sid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column score.mid
	 * @return  the value of score.mid
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public Integer getMid() {
		return mid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column score.mid
	 * @param mid  the value for score.mid
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public void setMid(Integer mid) {
		this.mid = mid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column score.uid
	 * @return  the value of score.uid
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column score.uid
	 * @param uid  the value for score.uid
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column score.sscore
	 * @return  the value of score.sscore
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public Integer getSscore() {
		return sscore;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column score.sscore
	 * @param sscore  the value for score.sscore
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public void setSscore(Integer sscore) {
		this.sscore = sscore;
	}

	@Override
	public String toString() {
		return "Score [sid=" + sid + ", mid=" + mid + ", uid=" + uid + ", sscore=" + sscore + "]";
	}
}