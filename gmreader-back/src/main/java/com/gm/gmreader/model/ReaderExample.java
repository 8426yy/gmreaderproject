package com.gm.gmreader.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReaderExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public ReaderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
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

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRnameIsNull() {
            addCriterion("rname is null");
            return (Criteria) this;
        }

        public Criteria andRnameIsNotNull() {
            addCriterion("rname is not null");
            return (Criteria) this;
        }

        public Criteria andRnameEqualTo(String value) {
            addCriterion("rname =", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotEqualTo(String value) {
            addCriterion("rname <>", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThan(String value) {
            addCriterion("rname >", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThanOrEqualTo(String value) {
            addCriterion("rname >=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThan(String value) {
            addCriterion("rname <", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThanOrEqualTo(String value) {
            addCriterion("rname <=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLike(String value) {
            addCriterion("rname like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotLike(String value) {
            addCriterion("rname not like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameIn(List<String> values) {
            addCriterion("rname in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotIn(List<String> values) {
            addCriterion("rname not in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameBetween(String value1, String value2) {
            addCriterion("rname between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotBetween(String value1, String value2) {
            addCriterion("rname not between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRpwdIsNull() {
            addCriterion("rpwd is null");
            return (Criteria) this;
        }

        public Criteria andRpwdIsNotNull() {
            addCriterion("rpwd is not null");
            return (Criteria) this;
        }

        public Criteria andRpwdEqualTo(String value) {
            addCriterion("rpwd =", value, "rpwd");
            return (Criteria) this;
        }

        public Criteria andRpwdNotEqualTo(String value) {
            addCriterion("rpwd <>", value, "rpwd");
            return (Criteria) this;
        }

        public Criteria andRpwdGreaterThan(String value) {
            addCriterion("rpwd >", value, "rpwd");
            return (Criteria) this;
        }

        public Criteria andRpwdGreaterThanOrEqualTo(String value) {
            addCriterion("rpwd >=", value, "rpwd");
            return (Criteria) this;
        }

        public Criteria andRpwdLessThan(String value) {
            addCriterion("rpwd <", value, "rpwd");
            return (Criteria) this;
        }

        public Criteria andRpwdLessThanOrEqualTo(String value) {
            addCriterion("rpwd <=", value, "rpwd");
            return (Criteria) this;
        }

        public Criteria andRpwdLike(String value) {
            addCriterion("rpwd like", value, "rpwd");
            return (Criteria) this;
        }

        public Criteria andRpwdNotLike(String value) {
            addCriterion("rpwd not like", value, "rpwd");
            return (Criteria) this;
        }

        public Criteria andRpwdIn(List<String> values) {
            addCriterion("rpwd in", values, "rpwd");
            return (Criteria) this;
        }

        public Criteria andRpwdNotIn(List<String> values) {
            addCriterion("rpwd not in", values, "rpwd");
            return (Criteria) this;
        }

        public Criteria andRpwdBetween(String value1, String value2) {
            addCriterion("rpwd between", value1, value2, "rpwd");
            return (Criteria) this;
        }

        public Criteria andRpwdNotBetween(String value1, String value2) {
            addCriterion("rpwd not between", value1, value2, "rpwd");
            return (Criteria) this;
        }

        public Criteria andRmailIsNull() {
            addCriterion("rmail is null");
            return (Criteria) this;
        }

        public Criteria andRmailIsNotNull() {
            addCriterion("rmail is not null");
            return (Criteria) this;
        }

        public Criteria andRmailEqualTo(String value) {
            addCriterion("rmail =", value, "rmail");
            return (Criteria) this;
        }

        public Criteria andRmailNotEqualTo(String value) {
            addCriterion("rmail <>", value, "rmail");
            return (Criteria) this;
        }

        public Criteria andRmailGreaterThan(String value) {
            addCriterion("rmail >", value, "rmail");
            return (Criteria) this;
        }

        public Criteria andRmailGreaterThanOrEqualTo(String value) {
            addCriterion("rmail >=", value, "rmail");
            return (Criteria) this;
        }

        public Criteria andRmailLessThan(String value) {
            addCriterion("rmail <", value, "rmail");
            return (Criteria) this;
        }

        public Criteria andRmailLessThanOrEqualTo(String value) {
            addCriterion("rmail <=", value, "rmail");
            return (Criteria) this;
        }

        public Criteria andRmailLike(String value) {
            addCriterion("rmail like", value, "rmail");
            return (Criteria) this;
        }

        public Criteria andRmailNotLike(String value) {
            addCriterion("rmail not like", value, "rmail");
            return (Criteria) this;
        }

        public Criteria andRmailIn(List<String> values) {
            addCriterion("rmail in", values, "rmail");
            return (Criteria) this;
        }

        public Criteria andRmailNotIn(List<String> values) {
            addCriterion("rmail not in", values, "rmail");
            return (Criteria) this;
        }

        public Criteria andRmailBetween(String value1, String value2) {
            addCriterion("rmail between", value1, value2, "rmail");
            return (Criteria) this;
        }

        public Criteria andRmailNotBetween(String value1, String value2) {
            addCriterion("rmail not between", value1, value2, "rmail");
            return (Criteria) this;
        }

        public Criteria andRtimeIsNull() {
            addCriterion("rtime is null");
            return (Criteria) this;
        }

        public Criteria andRtimeIsNotNull() {
            addCriterion("rtime is not null");
            return (Criteria) this;
        }

        public Criteria andRtimeEqualTo(Date value) {
            addCriterion("rtime =", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeNotEqualTo(Date value) {
            addCriterion("rtime <>", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeGreaterThan(Date value) {
            addCriterion("rtime >", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rtime >=", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeLessThan(Date value) {
            addCriterion("rtime <", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeLessThanOrEqualTo(Date value) {
            addCriterion("rtime <=", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeIn(List<Date> values) {
            addCriterion("rtime in", values, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeNotIn(List<Date> values) {
            addCriterion("rtime not in", values, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeBetween(Date value1, Date value2) {
            addCriterion("rtime between", value1, value2, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeNotBetween(Date value1, Date value2) {
            addCriterion("rtime not between", value1, value2, "rtime");
            return (Criteria) this;
        }

        public Criteria andRhimgIsNull() {
            addCriterion("rhimg is null");
            return (Criteria) this;
        }

        public Criteria andRhimgIsNotNull() {
            addCriterion("rhimg is not null");
            return (Criteria) this;
        }

        public Criteria andRhimgEqualTo(String value) {
            addCriterion("rhimg =", value, "rhimg");
            return (Criteria) this;
        }

        public Criteria andRhimgNotEqualTo(String value) {
            addCriterion("rhimg <>", value, "rhimg");
            return (Criteria) this;
        }

        public Criteria andRhimgGreaterThan(String value) {
            addCriterion("rhimg >", value, "rhimg");
            return (Criteria) this;
        }

        public Criteria andRhimgGreaterThanOrEqualTo(String value) {
            addCriterion("rhimg >=", value, "rhimg");
            return (Criteria) this;
        }

        public Criteria andRhimgLessThan(String value) {
            addCriterion("rhimg <", value, "rhimg");
            return (Criteria) this;
        }

        public Criteria andRhimgLessThanOrEqualTo(String value) {
            addCriterion("rhimg <=", value, "rhimg");
            return (Criteria) this;
        }

        public Criteria andRhimgLike(String value) {
            addCriterion("rhimg like", value, "rhimg");
            return (Criteria) this;
        }

        public Criteria andRhimgNotLike(String value) {
            addCriterion("rhimg not like", value, "rhimg");
            return (Criteria) this;
        }

        public Criteria andRhimgIn(List<String> values) {
            addCriterion("rhimg in", values, "rhimg");
            return (Criteria) this;
        }

        public Criteria andRhimgNotIn(List<String> values) {
            addCriterion("rhimg not in", values, "rhimg");
            return (Criteria) this;
        }

        public Criteria andRhimgBetween(String value1, String value2) {
            addCriterion("rhimg between", value1, value2, "rhimg");
            return (Criteria) this;
        }

        public Criteria andRhimgNotBetween(String value1, String value2) {
            addCriterion("rhimg not between", value1, value2, "rhimg");
            return (Criteria) this;
        }

        public Criteria andRstateIsNull() {
            addCriterion("rstate is null");
            return (Criteria) this;
        }

        public Criteria andRstateIsNotNull() {
            addCriterion("rstate is not null");
            return (Criteria) this;
        }

        public Criteria andRstateEqualTo(String value) {
            addCriterion("rstate =", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateNotEqualTo(String value) {
            addCriterion("rstate <>", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateGreaterThan(String value) {
            addCriterion("rstate >", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateGreaterThanOrEqualTo(String value) {
            addCriterion("rstate >=", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateLessThan(String value) {
            addCriterion("rstate <", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateLessThanOrEqualTo(String value) {
            addCriterion("rstate <=", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateLike(String value) {
            addCriterion("rstate like", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateNotLike(String value) {
            addCriterion("rstate not like", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateIn(List<String> values) {
            addCriterion("rstate in", values, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateNotIn(List<String> values) {
            addCriterion("rstate not in", values, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateBetween(String value1, String value2) {
            addCriterion("rstate between", value1, value2, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateNotBetween(String value1, String value2) {
            addCriterion("rstate not between", value1, value2, "rstate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table reader
     *
     * @mbg.generated do_not_delete_during_merge Thu Apr 08 17:05:12 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table reader
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
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
}