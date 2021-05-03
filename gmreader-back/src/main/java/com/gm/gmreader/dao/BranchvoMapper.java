package com.gm.gmreader.dao;

import com.gm.gmreader.model.Branchvo;
import com.gm.gmreader.model.BranchvoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BranchvoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    long countByExample(BranchvoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int deleteByExample(BranchvoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int insert(Branchvo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int insertSelective(Branchvo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    List<Branchvo> selectByExample(BranchvoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int updateByExampleSelective(@Param("record") Branchvo record, @Param("example") BranchvoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table branchvo
     *
     * @mbg.generated Thu Apr 08 17:05:12 CST 2021
     */
    int updateByExample(@Param("record") Branchvo record, @Param("example") BranchvoExample example);
}