package com.gm.gmreader.model;

import java.io.Serializable;
import java.util.Date;

public class Starvo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column starvo.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Integer rid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column starvo.rname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String rname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column starvo.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Integer bid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column starvo.bname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String bname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column starvo.sttime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Date sttime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column starvo.bhimg
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String bhimg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table starvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column starvo.rid
     *
     * @return the value of starvo.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column starvo.rid
     *
     * @param rid the value for starvo.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column starvo.rname
     *
     * @return the value of starvo.rname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getRname() {
        return rname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column starvo.rname
     *
     * @param rname the value for starvo.rname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column starvo.bid
     *
     * @return the value of starvo.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column starvo.bid
     *
     * @param bid the value for starvo.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column starvo.bname
     *
     * @return the value of starvo.bname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getBname() {
        return bname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column starvo.bname
     *
     * @param bname the value for starvo.bname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column starvo.sttime
     *
     * @return the value of starvo.sttime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Date getSttime() {
        return sttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column starvo.sttime
     *
     * @param sttime the value for starvo.sttime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setSttime(Date sttime) {
        this.sttime = sttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column starvo.bhimg
     *
     * @return the value of starvo.bhimg
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getBhimg() {
        return bhimg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column starvo.bhimg
     *
     * @param bhimg the value for starvo.bhimg
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setBhimg(String bhimg) {
        this.bhimg = bhimg == null ? null : bhimg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table starvo
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
        sb.append(", bid=").append(bid);
        sb.append(", bname=").append(bname);
        sb.append(", sttime=").append(sttime);
        sb.append(", bhimg=").append(bhimg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}