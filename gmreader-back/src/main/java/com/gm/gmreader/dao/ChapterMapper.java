package com.gm.gmreader.dao;

import com.gm.gmreader.model.Chapter;
import com.gm.gmreader.model.ChapterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chapter
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    long countByExample(ChapterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chapter
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int deleteByExample(ChapterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chapter
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int deleteByPrimaryKey(Integer cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chapter
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int insert(Chapter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chapter
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int insertSelective(Chapter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chapter
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    List<Chapter> selectByExample(ChapterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chapter
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    Chapter selectByPrimaryKey(Integer cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chapter
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int updateByExampleSelective(@Param("record") Chapter record, @Param("example") ChapterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chapter
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int updateByExample(@Param("record") Chapter record, @Param("example") ChapterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chapter
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int updateByPrimaryKeySelective(Chapter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chapter
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int updateByPrimaryKey(Chapter record);
}