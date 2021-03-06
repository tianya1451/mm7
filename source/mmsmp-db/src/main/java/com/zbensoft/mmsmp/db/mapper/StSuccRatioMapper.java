package com.zbensoft.mmsmp.db.mapper;

import java.util.List;

import com.zbensoft.mmsmp.db.domain.StSuccRatio;
import com.zbensoft.mmsmp.db.domain.StSuccRatioKey;

public interface StSuccRatioMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_succ_ratio
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    int deleteByPrimaryKey(StSuccRatioKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_succ_ratio
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    int insert(StSuccRatio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_succ_ratio
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    int insertSelective(StSuccRatio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_succ_ratio
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    StSuccRatio selectByPrimaryKey(StSuccRatioKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_succ_ratio
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    int updateByPrimaryKeySelective(StSuccRatio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_succ_ratio
     *
     * @mbg.generated Mon Sep 10 10:22:28 CST 2018
     */
    int updateByPrimaryKey(StSuccRatio record);
    
    List<StSuccRatio> selectPage(StSuccRatio record);
    
    int count(StSuccRatio record);
}