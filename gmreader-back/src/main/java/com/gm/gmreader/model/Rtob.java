package com.gm.gmreader.model;

import java.io.Serializable;

public class Rtob implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rtob.rbid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Integer rbid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rtob.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Integer rid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rtob.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Integer bid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table rtob
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rtob.rbid
     *
     * @return the value of rtob.rbid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Integer getRbid() {
        return rbid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rtob.rbid
     *
     * @param rbid the value for rtob.rbid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRbid(Integer rbid) {
        this.rbid = rbid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rtob.rid
     *
     * @return the value of rtob.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rtob.rid
     *
     * @param rid the value for rtob.rid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rtob.bid
     *
     * @return the value of rtob.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rtob.bid
     *
     * @param bid the value for rtob.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rtob
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rbid=").append(rbid);
        sb.append(", rid=").append(rid);
        sb.append(", bid=").append(bid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}