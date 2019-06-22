package com.love.movie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MovieExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	public MovieExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andMidIsNull() {
			addCriterion("mid is null");
			return (Criteria) this;
		}

		public Criteria andMidIsNotNull() {
			addCriterion("mid is not null");
			return (Criteria) this;
		}

		public Criteria andMidEqualTo(Integer value) {
			addCriterion("mid =", value, "mid");
			return (Criteria) this;
		}

		public Criteria andMidNotEqualTo(Integer value) {
			addCriterion("mid <>", value, "mid");
			return (Criteria) this;
		}

		public Criteria andMidGreaterThan(Integer value) {
			addCriterion("mid >", value, "mid");
			return (Criteria) this;
		}

		public Criteria andMidGreaterThanOrEqualTo(Integer value) {
			addCriterion("mid >=", value, "mid");
			return (Criteria) this;
		}

		public Criteria andMidLessThan(Integer value) {
			addCriterion("mid <", value, "mid");
			return (Criteria) this;
		}

		public Criteria andMidLessThanOrEqualTo(Integer value) {
			addCriterion("mid <=", value, "mid");
			return (Criteria) this;
		}

		public Criteria andMidIn(List<Integer> values) {
			addCriterion("mid in", values, "mid");
			return (Criteria) this;
		}

		public Criteria andMidNotIn(List<Integer> values) {
			addCriterion("mid not in", values, "mid");
			return (Criteria) this;
		}

		public Criteria andMidBetween(Integer value1, Integer value2) {
			addCriterion("mid between", value1, value2, "mid");
			return (Criteria) this;
		}

		public Criteria andMidNotBetween(Integer value1, Integer value2) {
			addCriterion("mid not between", value1, value2, "mid");
			return (Criteria) this;
		}

		public Criteria andMnameIsNull() {
			addCriterion("mname is null");
			return (Criteria) this;
		}

		public Criteria andMnameIsNotNull() {
			addCriterion("mname is not null");
			return (Criteria) this;
		}

		public Criteria andMnameEqualTo(String value) {
			addCriterion("mname =", value, "mname");
			return (Criteria) this;
		}

		public Criteria andMnameNotEqualTo(String value) {
			addCriterion("mname <>", value, "mname");
			return (Criteria) this;
		}

		public Criteria andMnameGreaterThan(String value) {
			addCriterion("mname >", value, "mname");
			return (Criteria) this;
		}

		public Criteria andMnameGreaterThanOrEqualTo(String value) {
			addCriterion("mname >=", value, "mname");
			return (Criteria) this;
		}

		public Criteria andMnameLessThan(String value) {
			addCriterion("mname <", value, "mname");
			return (Criteria) this;
		}

		public Criteria andMnameLessThanOrEqualTo(String value) {
			addCriterion("mname <=", value, "mname");
			return (Criteria) this;
		}

		public Criteria andMnameLike(String value) {
			addCriterion("mname like", value, "mname");
			return (Criteria) this;
		}

		public Criteria andMnameNotLike(String value) {
			addCriterion("mname not like", value, "mname");
			return (Criteria) this;
		}

		public Criteria andMnameIn(List<String> values) {
			addCriterion("mname in", values, "mname");
			return (Criteria) this;
		}

		public Criteria andMnameNotIn(List<String> values) {
			addCriterion("mname not in", values, "mname");
			return (Criteria) this;
		}

		public Criteria andMnameBetween(String value1, String value2) {
			addCriterion("mname between", value1, value2, "mname");
			return (Criteria) this;
		}

		public Criteria andMnameNotBetween(String value1, String value2) {
			addCriterion("mname not between", value1, value2, "mname");
			return (Criteria) this;
		}

		public Criteria andMtagIsNull() {
			addCriterion("mtag is null");
			return (Criteria) this;
		}

		public Criteria andMtagIsNotNull() {
			addCriterion("mtag is not null");
			return (Criteria) this;
		}

		public Criteria andMtagEqualTo(Integer value) {
			addCriterion("mtag =", value, "mtag");
			return (Criteria) this;
		}

		public Criteria andMtagNotEqualTo(Integer value) {
			addCriterion("mtag <>", value, "mtag");
			return (Criteria) this;
		}

		public Criteria andMtagGreaterThan(Integer value) {
			addCriterion("mtag >", value, "mtag");
			return (Criteria) this;
		}

		public Criteria andMtagGreaterThanOrEqualTo(Integer value) {
			addCriterion("mtag >=", value, "mtag");
			return (Criteria) this;
		}

		public Criteria andMtagLessThan(Integer value) {
			addCriterion("mtag <", value, "mtag");
			return (Criteria) this;
		}

		public Criteria andMtagLessThanOrEqualTo(Integer value) {
			addCriterion("mtag <=", value, "mtag");
			return (Criteria) this;
		}

		public Criteria andMtagIn(List<Integer> values) {
			addCriterion("mtag in", values, "mtag");
			return (Criteria) this;
		}

		public Criteria andMtagNotIn(List<Integer> values) {
			addCriterion("mtag not in", values, "mtag");
			return (Criteria) this;
		}

		public Criteria andMtagBetween(Integer value1, Integer value2) {
			addCriterion("mtag between", value1, value2, "mtag");
			return (Criteria) this;
		}

		public Criteria andMtagNotBetween(Integer value1, Integer value2) {
			addCriterion("mtag not between", value1, value2, "mtag");
			return (Criteria) this;
		}

		public Criteria andMscoreIsNull() {
			addCriterion("mscore is null");
			return (Criteria) this;
		}

		public Criteria andMscoreIsNotNull() {
			addCriterion("mscore is not null");
			return (Criteria) this;
		}

		public Criteria andMscoreEqualTo(Float value) {
			addCriterion("mscore =", value, "mscore");
			return (Criteria) this;
		}

		public Criteria andMscoreNotEqualTo(Float value) {
			addCriterion("mscore <>", value, "mscore");
			return (Criteria) this;
		}

		public Criteria andMscoreGreaterThan(Float value) {
			addCriterion("mscore >", value, "mscore");
			return (Criteria) this;
		}

		public Criteria andMscoreGreaterThanOrEqualTo(Float value) {
			addCriterion("mscore >=", value, "mscore");
			return (Criteria) this;
		}

		public Criteria andMscoreLessThan(Float value) {
			addCriterion("mscore <", value, "mscore");
			return (Criteria) this;
		}

		public Criteria andMscoreLessThanOrEqualTo(Float value) {
			addCriterion("mscore <=", value, "mscore");
			return (Criteria) this;
		}

		public Criteria andMscoreIn(List<Float> values) {
			addCriterion("mscore in", values, "mscore");
			return (Criteria) this;
		}

		public Criteria andMscoreNotIn(List<Float> values) {
			addCriterion("mscore not in", values, "mscore");
			return (Criteria) this;
		}

		public Criteria andMscoreBetween(Float value1, Float value2) {
			addCriterion("mscore between", value1, value2, "mscore");
			return (Criteria) this;
		}

		public Criteria andMscoreNotBetween(Float value1, Float value2) {
			addCriterion("mscore not between", value1, value2, "mscore");
			return (Criteria) this;
		}

		public Criteria andMurlIsNull() {
			addCriterion("murl is null");
			return (Criteria) this;
		}

		public Criteria andMurlIsNotNull() {
			addCriterion("murl is not null");
			return (Criteria) this;
		}

		public Criteria andMurlEqualTo(String value) {
			addCriterion("murl =", value, "murl");
			return (Criteria) this;
		}

		public Criteria andMurlNotEqualTo(String value) {
			addCriterion("murl <>", value, "murl");
			return (Criteria) this;
		}

		public Criteria andMurlGreaterThan(String value) {
			addCriterion("murl >", value, "murl");
			return (Criteria) this;
		}

		public Criteria andMurlGreaterThanOrEqualTo(String value) {
			addCriterion("murl >=", value, "murl");
			return (Criteria) this;
		}

		public Criteria andMurlLessThan(String value) {
			addCriterion("murl <", value, "murl");
			return (Criteria) this;
		}

		public Criteria andMurlLessThanOrEqualTo(String value) {
			addCriterion("murl <=", value, "murl");
			return (Criteria) this;
		}

		public Criteria andMurlLike(String value) {
			addCriterion("murl like", value, "murl");
			return (Criteria) this;
		}

		public Criteria andMurlNotLike(String value) {
			addCriterion("murl not like", value, "murl");
			return (Criteria) this;
		}

		public Criteria andMurlIn(List<String> values) {
			addCriterion("murl in", values, "murl");
			return (Criteria) this;
		}

		public Criteria andMurlNotIn(List<String> values) {
			addCriterion("murl not in", values, "murl");
			return (Criteria) this;
		}

		public Criteria andMurlBetween(String value1, String value2) {
			addCriterion("murl between", value1, value2, "murl");
			return (Criteria) this;
		}

		public Criteria andMurlNotBetween(String value1, String value2) {
			addCriterion("murl not between", value1, value2, "murl");
			return (Criteria) this;
		}

		public Criteria andMcountIsNull() {
			addCriterion("mcount is null");
			return (Criteria) this;
		}

		public Criteria andMcountIsNotNull() {
			addCriterion("mcount is not null");
			return (Criteria) this;
		}

		public Criteria andMcountEqualTo(Integer value) {
			addCriterion("mcount =", value, "mcount");
			return (Criteria) this;
		}

		public Criteria andMcountNotEqualTo(Integer value) {
			addCriterion("mcount <>", value, "mcount");
			return (Criteria) this;
		}

		public Criteria andMcountGreaterThan(Integer value) {
			addCriterion("mcount >", value, "mcount");
			return (Criteria) this;
		}

		public Criteria andMcountGreaterThanOrEqualTo(Integer value) {
			addCriterion("mcount >=", value, "mcount");
			return (Criteria) this;
		}

		public Criteria andMcountLessThan(Integer value) {
			addCriterion("mcount <", value, "mcount");
			return (Criteria) this;
		}

		public Criteria andMcountLessThanOrEqualTo(Integer value) {
			addCriterion("mcount <=", value, "mcount");
			return (Criteria) this;
		}

		public Criteria andMcountIn(List<Integer> values) {
			addCriterion("mcount in", values, "mcount");
			return (Criteria) this;
		}

		public Criteria andMcountNotIn(List<Integer> values) {
			addCriterion("mcount not in", values, "mcount");
			return (Criteria) this;
		}

		public Criteria andMcountBetween(Integer value1, Integer value2) {
			addCriterion("mcount between", value1, value2, "mcount");
			return (Criteria) this;
		}

		public Criteria andMcountNotBetween(Integer value1, Integer value2) {
			addCriterion("mcount not between", value1, value2, "mcount");
			return (Criteria) this;
		}

		public Criteria andMdirectIsNull() {
			addCriterion("mdirect is null");
			return (Criteria) this;
		}

		public Criteria andMdirectIsNotNull() {
			addCriterion("mdirect is not null");
			return (Criteria) this;
		}

		public Criteria andMdirectEqualTo(String value) {
			addCriterion("mdirect =", value, "mdirect");
			return (Criteria) this;
		}

		public Criteria andMdirectNotEqualTo(String value) {
			addCriterion("mdirect <>", value, "mdirect");
			return (Criteria) this;
		}

		public Criteria andMdirectGreaterThan(String value) {
			addCriterion("mdirect >", value, "mdirect");
			return (Criteria) this;
		}

		public Criteria andMdirectGreaterThanOrEqualTo(String value) {
			addCriterion("mdirect >=", value, "mdirect");
			return (Criteria) this;
		}

		public Criteria andMdirectLessThan(String value) {
			addCriterion("mdirect <", value, "mdirect");
			return (Criteria) this;
		}

		public Criteria andMdirectLessThanOrEqualTo(String value) {
			addCriterion("mdirect <=", value, "mdirect");
			return (Criteria) this;
		}

		public Criteria andMdirectLike(String value) {
			addCriterion("mdirect like", value, "mdirect");
			return (Criteria) this;
		}

		public Criteria andMdirectNotLike(String value) {
			addCriterion("mdirect not like", value, "mdirect");
			return (Criteria) this;
		}

		public Criteria andMdirectIn(List<String> values) {
			addCriterion("mdirect in", values, "mdirect");
			return (Criteria) this;
		}

		public Criteria andMdirectNotIn(List<String> values) {
			addCriterion("mdirect not in", values, "mdirect");
			return (Criteria) this;
		}

		public Criteria andMdirectBetween(String value1, String value2) {
			addCriterion("mdirect between", value1, value2, "mdirect");
			return (Criteria) this;
		}

		public Criteria andMdirectNotBetween(String value1, String value2) {
			addCriterion("mdirect not between", value1, value2, "mdirect");
			return (Criteria) this;
		}

		public Criteria andMwriterIsNull() {
			addCriterion("mwriter is null");
			return (Criteria) this;
		}

		public Criteria andMwriterIsNotNull() {
			addCriterion("mwriter is not null");
			return (Criteria) this;
		}

		public Criteria andMwriterEqualTo(String value) {
			addCriterion("mwriter =", value, "mwriter");
			return (Criteria) this;
		}

		public Criteria andMwriterNotEqualTo(String value) {
			addCriterion("mwriter <>", value, "mwriter");
			return (Criteria) this;
		}

		public Criteria andMwriterGreaterThan(String value) {
			addCriterion("mwriter >", value, "mwriter");
			return (Criteria) this;
		}

		public Criteria andMwriterGreaterThanOrEqualTo(String value) {
			addCriterion("mwriter >=", value, "mwriter");
			return (Criteria) this;
		}

		public Criteria andMwriterLessThan(String value) {
			addCriterion("mwriter <", value, "mwriter");
			return (Criteria) this;
		}

		public Criteria andMwriterLessThanOrEqualTo(String value) {
			addCriterion("mwriter <=", value, "mwriter");
			return (Criteria) this;
		}

		public Criteria andMwriterLike(String value) {
			addCriterion("mwriter like", value, "mwriter");
			return (Criteria) this;
		}

		public Criteria andMwriterNotLike(String value) {
			addCriterion("mwriter not like", value, "mwriter");
			return (Criteria) this;
		}

		public Criteria andMwriterIn(List<String> values) {
			addCriterion("mwriter in", values, "mwriter");
			return (Criteria) this;
		}

		public Criteria andMwriterNotIn(List<String> values) {
			addCriterion("mwriter not in", values, "mwriter");
			return (Criteria) this;
		}

		public Criteria andMwriterBetween(String value1, String value2) {
			addCriterion("mwriter between", value1, value2, "mwriter");
			return (Criteria) this;
		}

		public Criteria andMwriterNotBetween(String value1, String value2) {
			addCriterion("mwriter not between", value1, value2, "mwriter");
			return (Criteria) this;
		}

		public Criteria andMactorIsNull() {
			addCriterion("mactor is null");
			return (Criteria) this;
		}

		public Criteria andMactorIsNotNull() {
			addCriterion("mactor is not null");
			return (Criteria) this;
		}

		public Criteria andMactorEqualTo(String value) {
			addCriterion("mactor =", value, "mactor");
			return (Criteria) this;
		}

		public Criteria andMactorNotEqualTo(String value) {
			addCriterion("mactor <>", value, "mactor");
			return (Criteria) this;
		}

		public Criteria andMactorGreaterThan(String value) {
			addCriterion("mactor >", value, "mactor");
			return (Criteria) this;
		}

		public Criteria andMactorGreaterThanOrEqualTo(String value) {
			addCriterion("mactor >=", value, "mactor");
			return (Criteria) this;
		}

		public Criteria andMactorLessThan(String value) {
			addCriterion("mactor <", value, "mactor");
			return (Criteria) this;
		}

		public Criteria andMactorLessThanOrEqualTo(String value) {
			addCriterion("mactor <=", value, "mactor");
			return (Criteria) this;
		}

		public Criteria andMactorLike(String value) {
			addCriterion("mactor like", value, "mactor");
			return (Criteria) this;
		}

		public Criteria andMactorNotLike(String value) {
			addCriterion("mactor not like", value, "mactor");
			return (Criteria) this;
		}

		public Criteria andMactorIn(List<String> values) {
			addCriterion("mactor in", values, "mactor");
			return (Criteria) this;
		}

		public Criteria andMactorNotIn(List<String> values) {
			addCriterion("mactor not in", values, "mactor");
			return (Criteria) this;
		}

		public Criteria andMactorBetween(String value1, String value2) {
			addCriterion("mactor between", value1, value2, "mactor");
			return (Criteria) this;
		}

		public Criteria andMactorNotBetween(String value1, String value2) {
			addCriterion("mactor not between", value1, value2, "mactor");
			return (Criteria) this;
		}

		public Criteria andMcountryIsNull() {
			addCriterion("mcountry is null");
			return (Criteria) this;
		}

		public Criteria andMcountryIsNotNull() {
			addCriterion("mcountry is not null");
			return (Criteria) this;
		}

		public Criteria andMcountryEqualTo(String value) {
			addCriterion("mcountry =", value, "mcountry");
			return (Criteria) this;
		}

		public Criteria andMcountryNotEqualTo(String value) {
			addCriterion("mcountry <>", value, "mcountry");
			return (Criteria) this;
		}

		public Criteria andMcountryGreaterThan(String value) {
			addCriterion("mcountry >", value, "mcountry");
			return (Criteria) this;
		}

		public Criteria andMcountryGreaterThanOrEqualTo(String value) {
			addCriterion("mcountry >=", value, "mcountry");
			return (Criteria) this;
		}

		public Criteria andMcountryLessThan(String value) {
			addCriterion("mcountry <", value, "mcountry");
			return (Criteria) this;
		}

		public Criteria andMcountryLessThanOrEqualTo(String value) {
			addCriterion("mcountry <=", value, "mcountry");
			return (Criteria) this;
		}

		public Criteria andMcountryLike(String value) {
			addCriterion("mcountry like", value, "mcountry");
			return (Criteria) this;
		}

		public Criteria andMcountryNotLike(String value) {
			addCriterion("mcountry not like", value, "mcountry");
			return (Criteria) this;
		}

		public Criteria andMcountryIn(List<String> values) {
			addCriterion("mcountry in", values, "mcountry");
			return (Criteria) this;
		}

		public Criteria andMcountryNotIn(List<String> values) {
			addCriterion("mcountry not in", values, "mcountry");
			return (Criteria) this;
		}

		public Criteria andMcountryBetween(String value1, String value2) {
			addCriterion("mcountry between", value1, value2, "mcountry");
			return (Criteria) this;
		}

		public Criteria andMcountryNotBetween(String value1, String value2) {
			addCriterion("mcountry not between", value1, value2, "mcountry");
			return (Criteria) this;
		}

		public Criteria andMlanguageIsNull() {
			addCriterion("mlanguage is null");
			return (Criteria) this;
		}

		public Criteria andMlanguageIsNotNull() {
			addCriterion("mlanguage is not null");
			return (Criteria) this;
		}

		public Criteria andMlanguageEqualTo(String value) {
			addCriterion("mlanguage =", value, "mlanguage");
			return (Criteria) this;
		}

		public Criteria andMlanguageNotEqualTo(String value) {
			addCriterion("mlanguage <>", value, "mlanguage");
			return (Criteria) this;
		}

		public Criteria andMlanguageGreaterThan(String value) {
			addCriterion("mlanguage >", value, "mlanguage");
			return (Criteria) this;
		}

		public Criteria andMlanguageGreaterThanOrEqualTo(String value) {
			addCriterion("mlanguage >=", value, "mlanguage");
			return (Criteria) this;
		}

		public Criteria andMlanguageLessThan(String value) {
			addCriterion("mlanguage <", value, "mlanguage");
			return (Criteria) this;
		}

		public Criteria andMlanguageLessThanOrEqualTo(String value) {
			addCriterion("mlanguage <=", value, "mlanguage");
			return (Criteria) this;
		}

		public Criteria andMlanguageLike(String value) {
			addCriterion("mlanguage like", value, "mlanguage");
			return (Criteria) this;
		}

		public Criteria andMlanguageNotLike(String value) {
			addCriterion("mlanguage not like", value, "mlanguage");
			return (Criteria) this;
		}

		public Criteria andMlanguageIn(List<String> values) {
			addCriterion("mlanguage in", values, "mlanguage");
			return (Criteria) this;
		}

		public Criteria andMlanguageNotIn(List<String> values) {
			addCriterion("mlanguage not in", values, "mlanguage");
			return (Criteria) this;
		}

		public Criteria andMlanguageBetween(String value1, String value2) {
			addCriterion("mlanguage between", value1, value2, "mlanguage");
			return (Criteria) this;
		}

		public Criteria andMlanguageNotBetween(String value1, String value2) {
			addCriterion("mlanguage not between", value1, value2, "mlanguage");
			return (Criteria) this;
		}

		public Criteria andMtimeIsNull() {
			addCriterion("mtime is null");
			return (Criteria) this;
		}

		public Criteria andMtimeIsNotNull() {
			addCriterion("mtime is not null");
			return (Criteria) this;
		}

		public Criteria andMtimeEqualTo(Date value) {
			addCriterionForJDBCDate("mtime =", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("mtime <>", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeGreaterThan(Date value) {
			addCriterionForJDBCDate("mtime >", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("mtime >=", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeLessThan(Date value) {
			addCriterionForJDBCDate("mtime <", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("mtime <=", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeIn(List<Date> values) {
			addCriterionForJDBCDate("mtime in", values, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("mtime not in", values, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("mtime between", value1, value2, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("mtime not between", value1, value2, "mtime");
			return (Criteria) this;
		}

		public Criteria andMaliasIsNull() {
			addCriterion("malias is null");
			return (Criteria) this;
		}

		public Criteria andMaliasIsNotNull() {
			addCriterion("malias is not null");
			return (Criteria) this;
		}

		public Criteria andMaliasEqualTo(String value) {
			addCriterion("malias =", value, "malias");
			return (Criteria) this;
		}

		public Criteria andMaliasNotEqualTo(String value) {
			addCriterion("malias <>", value, "malias");
			return (Criteria) this;
		}

		public Criteria andMaliasGreaterThan(String value) {
			addCriterion("malias >", value, "malias");
			return (Criteria) this;
		}

		public Criteria andMaliasGreaterThanOrEqualTo(String value) {
			addCriterion("malias >=", value, "malias");
			return (Criteria) this;
		}

		public Criteria andMaliasLessThan(String value) {
			addCriterion("malias <", value, "malias");
			return (Criteria) this;
		}

		public Criteria andMaliasLessThanOrEqualTo(String value) {
			addCriterion("malias <=", value, "malias");
			return (Criteria) this;
		}

		public Criteria andMaliasLike(String value) {
			addCriterion("malias like", value, "malias");
			return (Criteria) this;
		}

		public Criteria andMaliasNotLike(String value) {
			addCriterion("malias not like", value, "malias");
			return (Criteria) this;
		}

		public Criteria andMaliasIn(List<String> values) {
			addCriterion("malias in", values, "malias");
			return (Criteria) this;
		}

		public Criteria andMaliasNotIn(List<String> values) {
			addCriterion("malias not in", values, "malias");
			return (Criteria) this;
		}

		public Criteria andMaliasBetween(String value1, String value2) {
			addCriterion("malias between", value1, value2, "malias");
			return (Criteria) this;
		}

		public Criteria andMaliasNotBetween(String value1, String value2) {
			addCriterion("malias not between", value1, value2, "malias");
			return (Criteria) this;
		}

		public Criteria andMreleaseIsNull() {
			addCriterion("mrelease is null");
			return (Criteria) this;
		}

		public Criteria andMreleaseIsNotNull() {
			addCriterion("mrelease is not null");
			return (Criteria) this;
		}

		public Criteria andMreleaseEqualTo(Integer value) {
			addCriterion("mrelease =", value, "mrelease");
			return (Criteria) this;
		}

		public Criteria andMreleaseNotEqualTo(Integer value) {
			addCriterion("mrelease <>", value, "mrelease");
			return (Criteria) this;
		}

		public Criteria andMreleaseGreaterThan(Integer value) {
			addCriterion("mrelease >", value, "mrelease");
			return (Criteria) this;
		}

		public Criteria andMreleaseGreaterThanOrEqualTo(Integer value) {
			addCriterion("mrelease >=", value, "mrelease");
			return (Criteria) this;
		}

		public Criteria andMreleaseLessThan(Integer value) {
			addCriterion("mrelease <", value, "mrelease");
			return (Criteria) this;
		}

		public Criteria andMreleaseLessThanOrEqualTo(Integer value) {
			addCriterion("mrelease <=", value, "mrelease");
			return (Criteria) this;
		}

		public Criteria andMreleaseIn(List<Integer> values) {
			addCriterion("mrelease in", values, "mrelease");
			return (Criteria) this;
		}

		public Criteria andMreleaseNotIn(List<Integer> values) {
			addCriterion("mrelease not in", values, "mrelease");
			return (Criteria) this;
		}

		public Criteria andMreleaseBetween(Integer value1, Integer value2) {
			addCriterion("mrelease between", value1, value2, "mrelease");
			return (Criteria) this;
		}

		public Criteria andMreleaseNotBetween(Integer value1, Integer value2) {
			addCriterion("mrelease not between", value1, value2, "mrelease");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table movie
	 * @mbg.generated  Fri Jun 21 16:04:53 CST 2019
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table movie
     *
     * @mbg.generated do_not_delete_during_merge Wed Jun 19 18:53:06 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}