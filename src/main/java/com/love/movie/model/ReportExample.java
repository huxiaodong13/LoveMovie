package com.love.movie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReportExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public ReportExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
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

		public Criteria andReportidIsNull() {
			addCriterion("reportid is null");
			return (Criteria) this;
		}

		public Criteria andReportidIsNotNull() {
			addCriterion("reportid is not null");
			return (Criteria) this;
		}

		public Criteria andReportidEqualTo(Integer value) {
			addCriterion("reportid =", value, "reportid");
			return (Criteria) this;
		}

		public Criteria andReportidNotEqualTo(Integer value) {
			addCriterion("reportid <>", value, "reportid");
			return (Criteria) this;
		}

		public Criteria andReportidGreaterThan(Integer value) {
			addCriterion("reportid >", value, "reportid");
			return (Criteria) this;
		}

		public Criteria andReportidGreaterThanOrEqualTo(Integer value) {
			addCriterion("reportid >=", value, "reportid");
			return (Criteria) this;
		}

		public Criteria andReportidLessThan(Integer value) {
			addCriterion("reportid <", value, "reportid");
			return (Criteria) this;
		}

		public Criteria andReportidLessThanOrEqualTo(Integer value) {
			addCriterion("reportid <=", value, "reportid");
			return (Criteria) this;
		}

		public Criteria andReportidIn(List<Integer> values) {
			addCriterion("reportid in", values, "reportid");
			return (Criteria) this;
		}

		public Criteria andReportidNotIn(List<Integer> values) {
			addCriterion("reportid not in", values, "reportid");
			return (Criteria) this;
		}

		public Criteria andReportidBetween(Integer value1, Integer value2) {
			addCriterion("reportid between", value1, value2, "reportid");
			return (Criteria) this;
		}

		public Criteria andReportidNotBetween(Integer value1, Integer value2) {
			addCriterion("reportid not between", value1, value2, "reportid");
			return (Criteria) this;
		}

		public Criteria andCidIsNull() {
			addCriterion("cid is null");
			return (Criteria) this;
		}

		public Criteria andCidIsNotNull() {
			addCriterion("cid is not null");
			return (Criteria) this;
		}

		public Criteria andCidEqualTo(Integer value) {
			addCriterion("cid =", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotEqualTo(Integer value) {
			addCriterion("cid <>", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidGreaterThan(Integer value) {
			addCriterion("cid >", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidGreaterThanOrEqualTo(Integer value) {
			addCriterion("cid >=", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidLessThan(Integer value) {
			addCriterion("cid <", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidLessThanOrEqualTo(Integer value) {
			addCriterion("cid <=", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidIn(List<Integer> values) {
			addCriterion("cid in", values, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotIn(List<Integer> values) {
			addCriterion("cid not in", values, "cid");
			return (Criteria) this;
		}

		public Criteria andCidBetween(Integer value1, Integer value2) {
			addCriterion("cid between", value1, value2, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotBetween(Integer value1, Integer value2) {
			addCriterion("cid not between", value1, value2, "cid");
			return (Criteria) this;
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

		public Criteria andReportdateIsNull() {
			addCriterion("reportdate is null");
			return (Criteria) this;
		}

		public Criteria andReportdateIsNotNull() {
			addCriterion("reportdate is not null");
			return (Criteria) this;
		}

		public Criteria andReportdateEqualTo(Date value) {
			addCriterionForJDBCDate("reportdate =", value, "reportdate");
			return (Criteria) this;
		}

		public Criteria andReportdateNotEqualTo(Date value) {
			addCriterionForJDBCDate("reportdate <>", value, "reportdate");
			return (Criteria) this;
		}

		public Criteria andReportdateGreaterThan(Date value) {
			addCriterionForJDBCDate("reportdate >", value, "reportdate");
			return (Criteria) this;
		}

		public Criteria andReportdateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("reportdate >=", value, "reportdate");
			return (Criteria) this;
		}

		public Criteria andReportdateLessThan(Date value) {
			addCriterionForJDBCDate("reportdate <", value, "reportdate");
			return (Criteria) this;
		}

		public Criteria andReportdateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("reportdate <=", value, "reportdate");
			return (Criteria) this;
		}

		public Criteria andReportdateIn(List<Date> values) {
			addCriterionForJDBCDate("reportdate in", values, "reportdate");
			return (Criteria) this;
		}

		public Criteria andReportdateNotIn(List<Date> values) {
			addCriterionForJDBCDate("reportdate not in", values, "reportdate");
			return (Criteria) this;
		}

		public Criteria andReportdateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("reportdate between", value1, value2, "reportdate");
			return (Criteria) this;
		}

		public Criteria andReportdateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("reportdate not between", value1, value2, "reportdate");
			return (Criteria) this;
		}

		public Criteria andReasonIsNull() {
			addCriterion("reason is null");
			return (Criteria) this;
		}

		public Criteria andReasonIsNotNull() {
			addCriterion("reason is not null");
			return (Criteria) this;
		}

		public Criteria andReasonEqualTo(String value) {
			addCriterion("reason =", value, "reason");
			return (Criteria) this;
		}

		public Criteria andReasonNotEqualTo(String value) {
			addCriterion("reason <>", value, "reason");
			return (Criteria) this;
		}

		public Criteria andReasonGreaterThan(String value) {
			addCriterion("reason >", value, "reason");
			return (Criteria) this;
		}

		public Criteria andReasonGreaterThanOrEqualTo(String value) {
			addCriterion("reason >=", value, "reason");
			return (Criteria) this;
		}

		public Criteria andReasonLessThan(String value) {
			addCriterion("reason <", value, "reason");
			return (Criteria) this;
		}

		public Criteria andReasonLessThanOrEqualTo(String value) {
			addCriterion("reason <=", value, "reason");
			return (Criteria) this;
		}

		public Criteria andReasonLike(String value) {
			addCriterion("reason like", value, "reason");
			return (Criteria) this;
		}

		public Criteria andReasonNotLike(String value) {
			addCriterion("reason not like", value, "reason");
			return (Criteria) this;
		}

		public Criteria andReasonIn(List<String> values) {
			addCriterion("reason in", values, "reason");
			return (Criteria) this;
		}

		public Criteria andReasonNotIn(List<String> values) {
			addCriterion("reason not in", values, "reason");
			return (Criteria) this;
		}

		public Criteria andReasonBetween(String value1, String value2) {
			addCriterion("reason between", value1, value2, "reason");
			return (Criteria) this;
		}

		public Criteria andReasonNotBetween(String value1, String value2) {
			addCriterion("reason not between", value1, value2, "reason");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table report
	 * @mbg.generated  Sun Jun 30 13:44:07 CST 2019
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
     * This class corresponds to the database table report
     *
     * @mbg.generated do_not_delete_during_merge Sun Jun 30 00:28:39 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}