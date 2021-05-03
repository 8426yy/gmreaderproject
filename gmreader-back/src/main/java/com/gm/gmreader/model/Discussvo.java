package com.gm.gmreader.model;

import java.io.Serializable;
import java.util.Date;

public class Discussvo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column discussvo.did
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Integer did;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column discussvo.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Integer rid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column discussvo.rname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String rname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column discussvo.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Integer bid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column discussvo.bname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String bname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column discussvo.comment
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String comment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column discussvo.time
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column discussvo.rhimg
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String rhimg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table discussvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column discussvo.did
     *
     * @return the value of discussvo.did
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Integer getDid() {
        return did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column discussvo.did
     *
     * @param did the value for discussvo.did
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column discussvo.rid
     *
     * @return the value of discussvo.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column discussvo.rid
     *
     * @param rid the value for discussvo.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column discussvo.rname
     *
     * @return the value of discussvo.rname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getRname() {
        return rname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column discussvo.rname
     *
     * @param rname the value for discussvo.rname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column discussvo.bid
     *
     * @return the value of discussvo.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column discussvo.bid
     *
     * @param bid the value for discussvo.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column discussvo.bname
     *
     * @return the value of discussvo.bname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getBname() {
        return bname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column discussvo.bname
     *
     * @param bname the value for discussvo.bname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column discussvo.comment
     *
     * @return the value of discussvo.comment
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column discussvo.comment
     *
     * @param comment the value for discussvo.comment
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column discussvo.time
     *
     * @return the value of discussvo.time
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column discussvo.time
     *
     * @param time the value for discussvo.time
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column discussvo.rhimg
     *
     * @return the value of discussvo.rhimg
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getRhimg() {
        return rhimg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column discussvo.rhimg
     *
     * @param rhimg the value for discussvo.rhimg
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRhimg(String rhimg) {
        this.rhimg = rhimg == null ? null : rhimg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discussvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", did=").append(did);
        sb.append(", rid=").append(rid);
        sb.append(", rname=").append(rname);
        sb.append(", bid=").append(bid);
        sb.append(", bname=").append(bname);
        sb.append(", comment=").append(comment);
        sb.append(", time=").append(time);
        sb.append(", rhimg=").append(rhimg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}