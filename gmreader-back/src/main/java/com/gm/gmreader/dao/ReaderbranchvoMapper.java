package com.gm.gmreader.dao;

import com.gm.gmreader.model.Readerbranchvo;
import com.gm.gmreader.model.ReaderbranchvoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReaderbranchvoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table readerbranchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    long countByExample(ReaderbranchvoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table readerbranchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int deleteByExample(ReaderbranchvoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table readerbranchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int insert(Readerbranchvo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table readerbranchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int insertSelective(Readerbranchvo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table readerbranchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    List<Readerbranchvo> selectByExample(ReaderbranchvoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table readerbranchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int updateByExampleSelective(@Param("record") Readerbranchvo record, @Param("example") ReaderbranchvoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table readerbranchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int updateByExample(@Param("record") Readerbranchvo record, @Param("example") ReaderbranchvoExample example);
}