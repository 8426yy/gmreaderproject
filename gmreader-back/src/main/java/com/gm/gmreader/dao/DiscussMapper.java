package com.gm.gmreader.dao;

import com.gm.gmreader.model.Discuss;
import com.gm.gmreader.model.DiscussExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiscussMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discuss
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    long countByExample(DiscussExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discuss
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int deleteByExample(DiscussExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discuss
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int deleteByPrimaryKey(Integer did);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discuss
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int insert(Discuss record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discuss
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int insertSelective(Discuss record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discuss
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    List<Discuss> selectByExample(DiscussExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discuss
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    Discuss selectByPrimaryKey(Integer did);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discuss
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int updateByExampleSelective(@Param("record") Discuss record, @Param("example") DiscussExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discuss
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int updateByExample(@Param("record") Discuss record, @Param("example") DiscussExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discuss
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int updateByPrimaryKeySelective(Discuss record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discuss
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int updateByPrimaryKey(Discuss record);
}