package com.gm.gmreader.model;

import java.io.Serializable;
import java.util.Date;

public class Thumbvo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column thumbvo.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Integer rid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column thumbvo.rname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String rname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column thumbvo.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Integer bid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column thumbvo.bname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String bname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column thumbvo.theva
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Boolean theva;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column thumbvo.thtime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Date thtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table thumbvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column thumbvo.rid
     *
     * @return the value of thumbvo.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column thumbvo.rid
     *
     * @param rid the value for thumbvo.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column thumbvo.rname
     *
     * @return the value of thumbvo.rname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getRname() {
        return rname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column thumbvo.rname
     *
     * @param rname the value for thumbvo.rname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column thumbvo.bid
     *
     * @return the value of thumbvo.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column thumbvo.bid
     *
     * @param bid the value for thumbvo.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column thumbvo.bname
     *
     * @return the value of thumbvo.bname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getBname() {
        return bname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column thumbvo.bname
     *
     * @param bname the value for thumbvo.bname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column thumbvo.theva
     *
     * @return the value of thumbvo.theva
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Boolean getTheva() {
        return theva;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column thumbvo.theva
     *
     * @param theva the value for thumbvo.theva
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setTheva(Boolean theva) {
        this.theva = theva;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column thumbvo.thtime
     *
     * @return the value of thumbvo.thtime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Date getThtime() {
        return thtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column thumbvo.thtime
     *
     * @param thtime the value for thumbvo.thtime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setThtime(Date thtime) {
        this.thtime = thtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table thumbvo
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
        sb.append(", theva=").append(theva);
        sb.append(", thtime=").append(thtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}