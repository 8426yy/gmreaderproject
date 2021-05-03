package com.gm.gmreader.model;

import java.io.Serializable;
import java.util.Date;

public class Star extends StarKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column star.sttime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private Date sttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table star
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column star.sttime
     *
     * @return the value of star.sttime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public Date getSttime() {
        return sttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column star.sttime
     *
     * @param sttime the value for star.sttime
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    public void setSttime(Date sttime) {
        this.sttime = sttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sttime=").append(sttime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}