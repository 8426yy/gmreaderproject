package com.gm.gmreader.model;

import java.io.Serializable;
import java.util.Date;

public class Branchchaptervo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branchchaptervo.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Integer bid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branchchaptervo.bname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String bname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branchchaptervo.cid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Integer cid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branchchaptervo.ctitle
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private String ctitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column branchchaptervo.ctime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Date ctime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table branchchaptervo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branchchaptervo.bid
     *
     * @return the value of branchchaptervo.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branchchaptervo.bid
     *
     * @param bid the value for branchchaptervo.bid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branchchaptervo.bname
     *
     * @return the value of branchchaptervo.bname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getBname() {
        return bname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branchchaptervo.bname
     *
     * @param bname the value for branchchaptervo.bname
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branchchaptervo.cid
     *
     * @return the value of branchchaptervo.cid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branchchaptervo.cid
     *
     * @param cid the value for branchchaptervo.cid
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branchchaptervo.ctitle
     *
     * @return the value of branchchaptervo.ctitle
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public String getCtitle() {
        return ctitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branchchaptervo.ctitle
     *
     * @param ctitle the value for branchchaptervo.ctitle
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setCtitle(String ctitle) {
        this.ctitle = ctitle == null ? null : ctitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column branchchaptervo.ctime
     *
     * @return the value of branchchaptervo.ctime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column branchchaptervo.ctime
     *
     * @param ctime the value for branchchaptervo.ctime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branchchaptervo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bid=").append(bid);
        sb.append(", bname=").append(bname);
        sb.append(", cid=").append(cid);
        sb.append(", ctitle=").append(ctitle);
        sb.append(", ctime=").append(ctime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}