package com.yangg.spring.dao;

import com.yangg.spring.model.TbGradeInfo;
import com.yangg.spring.model.TbGradeInfoExample;
import java.util.List;

import org.springframework.stereotype.Repository;

public interface TbGradeInfoDAO {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_grade_info
     *
     * @mbggenerated Sat Jan 07 17:13:40 CST 2017
     */
    int countByExample(TbGradeInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_grade_info
     *
     * @mbggenerated Sat Jan 07 17:13:40 CST 2017
     */
    int deleteByExample(TbGradeInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_grade_info
     *
     * @mbggenerated Sat Jan 07 17:13:40 CST 2017
     */
    void insert(TbGradeInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_grade_info
     *
     * @mbggenerated Sat Jan 07 17:13:40 CST 2017
     */
    void insertSelective(TbGradeInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_grade_info
     *
     * @mbggenerated Sat Jan 07 17:13:40 CST 2017
     */
    List<TbGradeInfo> selectByExample(TbGradeInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_grade_info
     *
     * @mbggenerated Sat Jan 07 17:13:40 CST 2017
     */
    int updateByExampleSelective(TbGradeInfo record, TbGradeInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_grade_info
     *
     * @mbggenerated Sat Jan 07 17:13:40 CST 2017
     */
    int updateByExample(TbGradeInfo record, TbGradeInfoExample example);
}