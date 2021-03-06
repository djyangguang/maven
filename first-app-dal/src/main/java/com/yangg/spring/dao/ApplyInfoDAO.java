package com.yangg.spring.dao;

import com.yangg.spring.model.ApplyInfo;
import com.yangg.spring.model.ApplyInfoExample;
import java.util.List;

public interface ApplyInfoDAO {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_apply
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    int countByExample(ApplyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_apply
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    int deleteByExample(ApplyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_apply
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    void insert(ApplyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_apply
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    void insertSelective(ApplyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_apply
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    List<ApplyInfo> selectByExample(ApplyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_apply
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    int updateByExampleSelective(ApplyInfo record, ApplyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_apply
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    int updateByExample(ApplyInfo record, ApplyInfoExample example);
}