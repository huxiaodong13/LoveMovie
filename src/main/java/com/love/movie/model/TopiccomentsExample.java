package com.love.movie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TopiccomentsExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	public TopiccomentsExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
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

		public Criteria andUidIsNull() {
			addCriterion("uid is null");
			return (Criteria) this;
		}

		public Criteria andUidIsNotNull() {
			addCriterion("uid is not null");
			return (Criteria) this;
		}

		public Criteria andUidEqualTo(Integer value) {
			addCriterion("uid =", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotEqualTo(Integer value) {
			addCriterion("uid <>", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThan(Integer value) {
			addCriterion("uid >", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("uid >=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThan(Integer value) {
			addCriterion("uid <", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThanOrEqualTo(Integer value) {
			addCriterion("uid <=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidIn(List<Integer> values) {
			addCriterion("uid in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotIn(List<Integer> values) {
			addCriterion("uid not in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidBetween(Integer value1, Integer value2) {
			addCriterion("uid between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotBetween(Integer value1, Integer value2) {
			addCriterion("uid not between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andTidIsNull() {
			addCriterion("tid is null");
			return (Criteria) this;
		}

		public Criteria andTidIsNotNull() {
			addCriterion("tid is not null");
			return (Criteria) this;
		}

		public Criteria andTidEqualTo(Integer value) {
			addCriterion("tid =", value, "tid");
			return (Criteria) this;
		}

		public Criteria andTidNotEqualTo(Integer value) {
			addCriterion("tid <>", value, "tid");
			return (Criteria) this;
		}

		public Criteria andTidGreaterThan(Integer value) {
			addCriterion("tid >", value, "tid");
			return (Criteria) this;
		}

		public Criteria andTidGreaterThanOrEqualTo(Integer value) {
			addCriterion("tid >=", value, "tid");
			return (Criteria) this;
		}

		public Criteria andTidLessThan(Integer value) {
			addCriterion("tid <", value, "tid");
			return (Criteria) this;
		}

		public Criteria andTidLessThanOrEqualTo(Integer value) {
			addCriterion("tid <=", value, "tid");
			return (Criteria) this;
		}

		public Criteria andTidIn(List<Integer> values) {
			addCriterion("tid in", values, "tid");
			return (Criteria) this;
		}

		public Criteria andTidNotIn(List<Integer> values) {
			addCriterion("tid not in", values, "tid");
			return (Criteria) this;
		}

		public Criteria andTidBetween(Integer value1, Integer value2) {
			addCriterion("tid between", value1, value2, "tid");
			return (Criteria) this;
		}

		public Criteria andTidNotBetween(Integer value1, Integer value2) {
			addCriterion("tid not between", value1, value2, "tid");
			return (Criteria) this;
		}

		public Criteria andTdateIsNull() {
			addCriterion("tdate is null");
			return (Criteria) this;
		}

		public Criteria andTdateIsNotNull() {
			addCriterion("tdate is not null");
			return (Criteria) this;
		}

		public Criteria andTdateEqualTo(Date value) {
			addCriterionForJDBCDate("tdate =", value, "tdate");
			return (Criteria) this;
		}

		public Criteria andTdateNotEqualTo(Date value) {
			addCriterionForJDBCDate("tdate <>", value, "tdate");
			return (Criteria) this;
		}

		public Criteria andTdateGreaterThan(Date value) {
			addCriterionForJDBCDate("tdate >", value, "tdate");
			return (Criteria) this;
		}

		public Criteria andTdateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("tdate >=", value, "tdate");
			return (Criteria) this;
		}

		public Criteria andTdateLessThan(Date value) {
			addCriterionForJDBCDate("tdate <", value, "tdate");
			return (Criteria) this;
		}

		public Criteria andTdateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("tdate <=", value, "tdate");
			return (Criteria) this;
		}

		public Criteria andTdateIn(List<Date> values) {
			addCriterionForJDBCDate("tdate in", values, "tdate");
			return (Criteria) this;
		}

		public Criteria andTdateNotIn(List<Date> values) {
			addCriterionForJDBCDate("tdate not in", values, "tdate");
			return (Criteria) this;
		}

		public Criteria andTdateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("tdate between", value1, value2, "tdate");
			return (Criteria) this;
		}

		public Criteria andTdateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("tdate not between", value1, value2, "tdate");
			return (Criteria) this;
		}

		public Criteria andTlikeIsNull() {
			addCriterion("tlike is null");
			return (Criteria) this;
		}

		public Criteria andTlikeIsNotNull() {
			addCriterion("tlike is not null");
			return (Criteria) this;
		}

		public Criteria andTlikeEqualTo(Integer value) {
			addCriterion("tlike =", value, "tlike");
			return (Criteria) this;
		}

		public Criteria andTlikeNotEqualTo(Integer value) {
			addCriterion("tlike <>", value, "tlike");
			return (Criteria) this;
		}

		public Criteria andTlikeGreaterThan(Integer value) {
			addCriterion("tlike >", value, "tlike");
			return (Criteria) this;
		}

		public Criteria andTlikeGreaterThanOrEqualTo(Integer value) {
			addCriterion("tlike >=", value, "tlike");
			return (Criteria) this;
		}

		public Criteria andTlikeLessThan(Integer value) {
			addCriterion("tlike <", value, "tlike");
			return (Criteria) this;
		}

		public Criteria andTlikeLessThanOrEqualTo(Integer value) {
			addCriterion("tlike <=", value, "tlike");
			return (Criteria) this;
		}

		public Criteria andTlikeIn(List<Integer> values) {
			addCriterion("tlike in", values, "tlike");
			return (Criteria) this;
		}

		public Criteria andTlikeNotIn(List<Integer> values) {
			addCriterion("tlike not in", values, "tlike");
			return (Criteria) this;
		}

		public Criteria andTlikeBetween(Integer value1, Integer value2) {
			addCriterion("tlike between", value1, value2, "tlike");
			return (Criteria) this;
		}

		public Criteria andTlikeNotBetween(Integer value1, Integer value2) {
			addCriterion("tlike not between", value1, value2, "tlike");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table topiccoments
	 * @mbg.generated  Mon Jun 24 19:49:52 CST 2019
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
     * This class corresponds to the database table topiccoments
     *
     * @mbg.generated do_not_delete_during_merge Wed Jun 19 18:53:06 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}