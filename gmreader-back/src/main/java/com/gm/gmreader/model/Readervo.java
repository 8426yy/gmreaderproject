package com.gm.gmreader.model;

import java.io.Serializable;
import java.util.Date;

public class Readervo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column readervo.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Integer rid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column readervo.rname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String rname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column readervo.rmail
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String rmail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column readervo.rtime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Date rtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column readervo.rhimg
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String rhimg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table readervo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column readervo.rid
     *
     * @return the value of readervo.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column readervo.rid
     *
     * @param rid the value for readervo.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column readervo.rname
     *
     * @return the value of readervo.rname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getRname() {
        return rname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column readervo.rname
     *
     * @param rname the value for readervo.rname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column readervo.rmail
     *
     * @return the value of readervo.rmail
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getRmail() {
        return rmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column readervo.rmail
     *
     * @param rmail the value for readervo.rmail
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRmail(String rmail) {
        this.rmail = rmail == null ? null : rmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column readervo.rtime
     *
     * @return the value of readervo.rtime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Date getRtime() {
        return rtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column readervo.rtime
     *
     * @param rtime the value for readervo.rtime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column readervo.rhimg
     *
     * @return the value of readervo.rhimg
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getRhimg() {
        return rhimg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column readervo.rhimg
     *
     * @param rhimg the value for readervo.rhimg
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRhimg(String rhimg) {
        this.rhimg = rhimg == null ? null : rhimg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table readervo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rid=").append(rid);
        sb.append(", rname=").append(rname);
        sb.append(", rmail=").append(rmail);
        sb.append(", rtime=").append(rtime);
        sb.append(", rhimg=").append(rhimg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}