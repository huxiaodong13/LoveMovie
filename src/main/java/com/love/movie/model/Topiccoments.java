package com.love.movie.model;

import java.util.Date;

public class Topiccoments extends TopiccomentsKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topiccoments.tdate
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    private Date tdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topiccoments.tlike
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    private Integer tlike;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topiccoments.tcontent
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    private String tcontent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topiccoments.tdate
     *
     * @return the value of topiccoments.tdate
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    public Date getTdate() {
        return tdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topiccoments.tdate
     *
     * @param tdate the value for topiccoments.tdate
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topiccoments.tlike
     *
     * @return the value of topiccoments.tlike
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    public Integer getTlike() {
        return tlike;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topiccoments.tlike
     *
     * @param tlike the value for topiccoments.tlike
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    public void setTlike(Integer tlike) {
        this.tlike = tlike;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topiccoments.tcontent
     *
     * @return the value of topiccoments.tcontent
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    public String getTcontent() {
        return tcontent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topiccoments.tcontent
     *
     * @param tcontent the value for topiccoments.tcontent
     *
     * @mbg.generated Wed Jun 19 18:53:06 CST 2019
     */
    public void setTcontent(String tcontent) {
        this.tcontent = tcontent;
    }
}